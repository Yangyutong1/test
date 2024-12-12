package controller.domain;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Maipiao {

    private int flag = 1;

    private final Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void lunshu5(int lunshu) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "轮数" + lunshu);
            }
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void lunshu8(int lunshu) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 1; i <= 8; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "轮数" + lunshu);
            }
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }
    public void lunshu12(int lunshu) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 1; i <= 12; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "轮数" + lunshu);
            }
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
