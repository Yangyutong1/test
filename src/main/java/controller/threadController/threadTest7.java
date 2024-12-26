package controller.threadController;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Chepiao {
    ReentrantLock lock = new ReentrantLock(true);
    private int number = 50;

    public void fangfa() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + number-- + "剩余" + number);
            }
        } finally {
            lock.unlock();
        }
    }
}

/**
 * ReentrantLock本质为非公平锁
 * ReentrantLock(true) 加上true 就成了公平锁
 */

public class threadTest7 {

    public static void main(String[] args) {
        Chepiao chepiao = new Chepiao();
        new Thread(()->{for (int i=0;i<=50;i++){chepiao.fangfa();}},"A").start();
        new Thread(()->{for (int i=0;i<=50;i++){chepiao.fangfa();}},"B").start();
        new Thread(()->{for (int i=0;i<=50;i++){chepiao.fangfa();}},"C").start();
    }
}
