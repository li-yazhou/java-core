# 跨库分页查询

以时间排序进行跨库分页查询。


## 方法一：全局视野法
步骤如下：

（1）SQL改写，将 order by time offset X limit Y; 改写成 order by time offset 0 limit X+Y;

（2）服务层对得到的 N\*(X+Y)条数据进行内存排序，内存排序后再取偏移量X后的Y条记录。

优缺点：
    查询结果准确，但随着翻页的进行，性能越来越低。
    
 
## 方法二：禁止跳页查询法
步骤如下：

（1）用正常的方法取得第一页数据，并得到第一页记录的time_max；

（2）每次翻页，将 order by time offset X limit Y; 改写成 order by time where time>$time_max limit Y; 其中 $time_max 是上一分页的最大时间。

优缺点：
    以保证每次只返回一页数据，性能为常量，但无法分页跳转。
    
 
## 方法三：允许模糊数据法
步骤如下：

（1）SQL查询改写，将 order by time offset X limit Y; 改写成 order by time offset X/N limit Y/N;

优缺点：
    性能很高，但拼接的结果集不精准。
    
 
## 方法四：二次查询法
步骤如下：

（1）SQL改写，将 order by time offset X limit Y; 改写成 order by time offset X/N limit Y;

（2）多页返回，找到最小值time_min，分页记录的时间一定大于等于time_min；

（3）between二次查询 order by time between $time_min and $time_i_max;

（4）设置虚拟time_min，找到time_min在各个分库的offset，从而得到time_min在全局的offset；

（5）得到了time_min在全局的offset，自然得到了全局的 offset X limit Y；

优缺点：
    可以精确的返回业务所需数据，每次返回的数据量都非常小，不会随着翻页增加数据的返回量，不过查询过程较为复杂。
   