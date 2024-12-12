package controller.domain;

import java.util.concurrent.locks.ReentrantLock;

public class MaiPiao1 {

    private int piao = 30;

    //true是公平锁，false是非公平锁，默认不穿参数就是非公平锁
    private final ReentrantLock lock = new ReentrantLock(true);

    public void fangfa() {
        lock.lock();
        try {
            if (piao > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + piao-- + "剩余" + piao);
            }
        } finally {
            lock.unlock();
        }

//    public synchronized void fangfa() {
//        if (piao > 0) {
//            System.out.println(Thread.currentThread().getName() + "卖出" + piao-- + "剩余" + piao);
//        }
//    }
    }
}
