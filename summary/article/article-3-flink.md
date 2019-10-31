# Flink



## 基本概念

Flink 几个最基础的概念，Client、JobManager 和 TaskManager。
Client 用来提交任务给JobManager，JobManager 分发任务给 TaskManager 去执行，然后 TaskManager 会心跳的汇报任务状态。
看到这里，已经有种回到 Hadoop 一代的错觉。
确实，从架构图去看，JobManager 很像当年的 JobTracker，TaskManager 也很像当年的 TaskTracker。
然而有一个最重要的区别就是 TaskManager 之间是是流（Stream）。
其次，Hadoop 一代中，只有 Map 和 Reduce 之间的 Shuffle，而对 Flink 而言，可能是很多级，
并且在 TaskManager内部和 TaskManager 之间都会有数据传递，而不像 Hadoop，是固定的 Map 到 Reduce。


---


## 特性

* 有状态计算的Exactly-once语义。状态是指flink能够维护数据在时序上的聚类和聚合，同时它的checkpoint机制
* 支持带有事件时间（event time）语义的流处理和窗口处理。事件时间的语义使流计算的结果更加精确，尤其在事件到达无序或者延迟的情况下。
* 支持高度灵活的窗口（window）操作。支持基于time、count、session，以及data-driven的窗口操作，能很好的对现实环境中的创建的数据进行建模。
* 轻量的容错处理（fault tolerance）。 它使得系统既能保持高的吞吐率又能保证exactly-once的一致性。通过轻量的state snapshots实现
* 支持高吞吐、低延迟、高性能的流处理
* 支持savepoints 机制（一般手动触发）。即可以将应用的运行状态保存下来；在升级应用或者处理历史数据是能够做到无状态丢失和最小停机时间。
* 支持大规模的集群模式，支持yarn、Mesos。可运行在成千上万的节点上
* 支持具有Backpressure功能的持续流模型
* Flink在JVM内部实现了自己的内存管理
* 支持迭代计算
* 支持程序自动优化：避免特定情况下Shuffle、排序等昂贵操作，中间结果进行缓存


---


## 任务和运算（算子）链（Tasks and Operator Chains）

在Flink分布式执行环境中，会将多个运算子任务Operator Subtask串起来组成一个Operator Chain，实际上就是一个运算链。
每个运算会在TaskManager上一个独立的线程中执行。
将算子串连到任务中是一种很好的优化：它能减少线程间的数据交接和缓存，并且提高整体的吞吐，降低处理的时延。这种串联的操作，可以通过API来进行配置。


---


## Job Managers，Task Managers，Clients

Flink的运行时，由两种类型的进程组成：

JobManagers： 也就是masters ，协调分布式任务的执行 。用来调度任务，协调checkpoints，协调错误恢复等等。
    至少需要一个JobManager，高可用的系统会有多个，一个leader，其他是standby。

TaskManagers： 也就是workers，用来执行数据流任务或者子任务，缓存和交互数据流，至少需要一个TaskManager。

Client: Client不是运行是和程序执行的一部分，它是用来准备和提交数据流到JobManagers。之后，可以断开连接或者保持连接以获取任务的状态信息。


Flink运行时的整体状态。 
Flink的Driver程序会将代码逻辑构建成一个Program Dataflow(区分source,operator,sink等等)，
在通过Graph Builder构建DAG的Dataflow graph, 构建job,划分出task 和subtask等等。
Client 将job 提交到JobManager. Client 通过Actor System和JobManager 进行消息通讯，接收JobManager返回的状态更新和任务执行统计结果。 
JobMangaer 按照Dataflow的Task 和Subtask的划分，将任务调度分配到各个TaskManager中进行执行。
TaskManager会将内存抽象成多个TaskSlot，用于执行Task任务。
JobManagers与TaskManagers之间的任务管理，Checkpoints的触发，任务状态，心跳等等消息处理都是通过ActorSystem。


---


## Task Slots和资源

每个Worker(Task Manager)是一个JVM进程，通常会在单独的线程里执行一个或者多个子任务。
为了控制一个Worker能够接受多少个任务，会在Worker上抽象多个Task Slot (至少一个)。
每个Task Slot代表固定的资源子集。比如一个TaskManager有3个Slots，每个Slot能管理对这个Worker分配的资源的3分之1的内存。 
对资源分槽，意味着Subtask不会同其他Subtasks竞争内存，同时可以预留一定的可用内存。
目前Task Slot没有对CPU进行隔离，仅是针对内存。通过动态的调整task slots的个数，用户可以定义哪些子任务可以相互隔离。
只有一个slot的TaskManager意味着每个任务组运行在一个单独JVM中。 
在拥有多个slot的TaskManager上，subtask共用JVM，可以共用TCP连接和心跳消息，同时可以共用一些数据集和数据结构，从而减小任务的开销。


默认情况下，Flink允许子任务共享slots,即便它们是不同任务的子任务，只要属于同一个job。
这样的结果就是一个slot会负责一个job的整个pipeline。共用slot有两个好处:

* Flink 集群的task slot的个数就是job的最高并行度。

* 更实现更好的资源利用。没有共享的slots，非密集的source/map()  subtask 会占用和 window 这类密集型的subtask 同样多的资源。 
使用共享的slot的将充分的利用分槽的资源，使代价较大的subtask能够均匀的分布在TaskManager上。
同时APIs也提供了资源组的机制，可以实现不想进行资源隔离的情况。

实践中，比较好的每个TaskManager的task slot的默认数量最好是CPU的核数。


---


## 保存点（Savepoints）

通过Data Stream AP编写的程序可以从一个保存点重新开始执行。即便更新了你的程序和Flink集群都不会有状态数据丢失。
保存点是手动触发的，触发时会将它写入状态后端。Savepoints的实现也是依赖Checkpoint的机制。

Flink 程序在执行中会周期性的在worker 节点上进行快照并生成Checkpoint。因为任务恢复的时候只需要最后一个完成的Checkpoint的，所以旧有的Checkpoint会在新的Checkpoint完成时被丢弃。

Savepoints和周期性的Checkpoint非常的类似，只是有两个重要的不同。一个是由用户触发，而且不会随着新的Checkpoint生成而被丢弃。


---


## Backpressure 背压机制

Backpressure在流式计算系统中会比较受到关注，因为在一个Stream上进行处理的多个Operator之间，
它们处理速度和方式可能非常不同，所以就存在上游Operator如果处理速度过快，下游Operator处可能机会堆积Stream记录，
严重会造成处理延迟或下游Operator负载过重而崩溃（有些系统可能会丢失数据）。
因此，对下游Operator处理速度跟不上的情况，如果下游Operator能够将自己处理状态传播给上游Operator，
使得上游Operator处理速度慢下来就会缓解上述问题，比如通过告警的方式通知现有流处理系统存在的问题。


---


## 计算引擎

Spark和Flink全部都运行在Hadoop YARN上，性能为Flink > Spark > Hadoop(MR)，
迭代次数越多越明显，性能上，Flink优于Spark和Hadoop最主要的原因是Flink支持增量迭代，具有对迭代自动优化的功能。 


---


## Flink 资料
## Flink 官方文档
1. [flink-overview](https://flink.apache.org/)
1. [flink-issues](https://issues.apache.org/jira/projects/FLINK/issues/FLINK-13408?filter=allopenissues)
1. [Flink官方文档-EN](https://flink.apache.org/flink-architecture.html)
1. [Flink官方文档-ZH](https://flink.apache.org/zh/flink-architecture.html)


### Flink 开发资料
1. [flink-china/flink-training-course](https://github.com/flink-china/flink-training-course)
1. [5分钟从零构建第一个 Apache Flink 应用](https://ververica.cn/developers/build-from-zero/)

### Flink 零基础入门 系列文章
1. [Apache Flink 零基础入门（一&二）：基础概念解析](https://ververica.cn/developers/flink-basic-tutorial-1-basic-concept/)
1. [Apache Flink 零基础入门（三）：开发环境搭建和应用的配置、部署及运行](https://ververica.cn/developers/flink-basic-tutorial-1-environmental-construction/)
1. [Apache Flink 零基础入门（四）：DataStream API 编程](https://ververica.cn/developers/apache-flink-basic-zero-iii-datastream-api-programming/)
1. [Apache Flink 零基础入门（五）：客户端操作](https://ververica.cn/developers/apache-flink-zero-basic-introduction-iv-client-operation/)
1. [Apache Flink 零基础入门（六）：Flink Time & Window 解析](https://ververica.cn/developers/time-window/)
1. [Apache Flink 零基础入门（七）：状态管理及容错机制](https://ververica.cn/developers/state-management/)
1. [Apache Flink 零基础入门（八）：Table API 编程](https://ververica.cn/developers/table-api-programming/)

### Flink 文章

### Flink Forward
1. [flink-forward-china-2018](https://github.com/flink-china/flink-forward-china-2018)




















































