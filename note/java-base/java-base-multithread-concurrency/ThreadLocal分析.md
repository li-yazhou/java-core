# ThreadLocal分析

ThreadLocal是一个为线程提供线程局部变量的工具类。
它的思想也十分简单，就是为线程提供一个线程私有的变量副本，这样多个线程都可以随意更改自己线程局部的变量，不会影响到其他线程。
不过需要注意的是，ThreadLocal提供的只是一个浅拷贝，如果变量是一个引用类型，那么就要考虑它内部的状态是否会被改变，
想要解决这个问题可以通过重写ThreadLocal的initialValue()函数来自己实现深拷贝，建议在使用ThreadLocal时一开始就重写该函数。

ThreadLocal与像synchronized这样的锁机制是不同的。
首先，它们的应用场景与实现思路就不一样，锁更强调的是如何同步多个线程去正确地共享一个变量，
ThreadLocal则是为了解决同一个变量如何不被多个线程共享。从性能开销的角度上来讲，如果锁机制是用时间换空间的话，
那么ThreadLocal就是用空间换时间。

ThreadLocal中含有一个叫做ThreadLocalMap的内部类，该类为一个采用线性探测法实现的HashMap。
它的key为ThreadLocal对象而且还使用了WeakReference，ThreadLocalMap正是用来存储变量副本的。



## ThreadLocal示例
```
/**
 * description:
 *
 * @author liyazhou
 * @since 2017-08-14 21:03
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

    public static void main(String... args){
        for (int i = 0; i < 2; i ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " put data, " + data);
                    x.set(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        void get(){
            int data = x.get();  // ThreadLocal的成员方法get()
            System.out.println("A from " + Thread.currentThread().getName() + " get data : " + data);
        }
    }

    static class B{
        void get(){
            int data = x.get();  // ThreadLocal的成员方法get()
            System.out.println("B from " + Thread.currentThread().getName() + " get data : " + data);
        }
    }
}

// 运行结果为
/*
    Thread-0 put data, -1698175580
    Thread-1 put data, 881572399
    A from Thread-0 get data : -1698175580
    A from Thread-1 get data : 881572399
    B from Thread-0 get data : -1698175580
    B from Thread-1 get data : 881572399
 */
```