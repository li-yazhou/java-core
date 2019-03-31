package javase.thread;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2018/12/16
 */

/*
    停止线程：
    1，stop方法。
    2，run方法结束。

    怎么控制线程的任务结束呢?
    任务中都会有循环结构，只要控制住循环就可以结束任务。
    控制循环通常就用定义标记来完成。

    但是如果线程处于了冻结状态，无法读取标记。如何结束呢？
    可以使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来，让线程具备cpu的执行资格。
    当时强制动作会发生了InterruptedException，记得要处理

 */
public class StopThreadDemo {
}
