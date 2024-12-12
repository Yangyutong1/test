package controller.threadController;

import controller.domain.threadDemo1;
import controller.domain.threadDemo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class threadTest4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new threadDemo1(),"AA").start();

//        new Thread(new ThredDemo2(),"BB").start();

        FutureTask<Integer> task1 = new FutureTask<>(new threadDemo2());

        FutureTask<Integer> task2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"xxxx");
            return 1024;
        });

        new Thread(task2,"AA").start();
        System.out.println(task2.get());

    }
}
