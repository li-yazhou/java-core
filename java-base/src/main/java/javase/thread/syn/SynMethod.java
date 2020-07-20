package javase.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * Created by ji .
 */
public class SynMethod {

    public void method1() {
        synchronized (SynMethod.class) {
            System.out.println("[method1] " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2() {
        System.out.println("[method2] " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method3() {
        System.out.println("[method3] " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method4() {
        System.out.println("[method4] " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
//
//        final SynMethod synMethod = new SynMethod();
//
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synMethod.method1();
//            }
//        },"thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synMethod.method1();
//            }
//        },"thread-2");
//        t1.start();
//        t2.start();


        /*****************************************/

//        final SynMethod synMethod = new SynMethod();
//
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synMethod.method1();
//            }
//        },"thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                synMethod.method2();
//            }
//        },"thread-2");
//        t1.start();
//        t2.start();


        /***************************************/
//        final SynMethod synMethod = new SynMethod();
//
//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                synMethod.method1();
//            }
//        },"thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                SynMethod.method3();
//            }
//        },"thread-2");
//        t2.start();
//        t1.start();

        /*********************************/

//        Thread t1 = new Thread(new Runnable() {
//            public void run() {
//                SynMethod.method3();
//            }
//        },"thread-1");
//
//        Thread t2 = new Thread(new Runnable() {
//            public void run() {
//                SynMethod.method3();
//            }
//        },"thread-2");
//        t1.start();
//        t2.start();


        /************************************/

        final SynMethod synMethod = new SynMethod();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synMethod.method1();
            }
        }, "thread-1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                SynMethod.method4();
            }
        }, "thread-2");
        t1.start();
        t2.start();
    }
}
