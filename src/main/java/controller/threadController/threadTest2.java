package controller.threadController;

import controller.domain.MaiPiao1;

//3个线程交替卖票

public class threadTest2 {

    public static void main(String[] args) {
        MaiPiao1 maiPiao = new MaiPiao1();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                maiPiao.fangfa();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                maiPiao.fangfa();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                maiPiao.fangfa();
            }
        }, "CC").start();


    }
}
