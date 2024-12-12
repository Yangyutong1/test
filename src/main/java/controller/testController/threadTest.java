package controller.testController;


import controller.domain.Maipiao;

//定制化三个线程，根据规则打印，并通知线程
public class threadTest {
    public static void main(String[] args) {

        Maipiao maipiao = new Maipiao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=5;i++){
                    try {
                        maipiao.lunshu5(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=8;i++){
                    try {
                        maipiao.lunshu8(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1;i<=12;i++){
                    try {
                        maipiao.lunshu12(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        },"CC").start();
    }
}
