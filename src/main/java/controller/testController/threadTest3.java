package controller.testController;

import java.util.concurrent.TimeUnit;

//模拟死锁
//利用可重入锁原理，用两个线程，互相取对方的锁，
//可在控制台进行查看。
public class threadTest3 {

    static Object a = new Object();
    static Object b = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "持有锁a,准备获取锁b");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + "获取锁b");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + "持有锁b,准备获取锁a");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + "获取锁a");
                }
            }
        }, "B").start();

    }

}
