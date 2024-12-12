package controller.threadController;

import java.util.concurrent.*;

/**
 * 使用FutureTask异步类
 * 模拟3个线程和1个线程，
 * 针对与3个方法，耗时的统计
 */
public class threadTest6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long satatTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        FutureTask futureTask = new FutureTask<String>(()->{
            try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            return "1结束";
        });
        Thread t1 = new Thread(futureTask,"t1");
        t1.start();
        executorService.submit(futureTask);

        FutureTask futureTask1 = new FutureTask<String>(()->{
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            return "2结束";
        });
        Thread t2 = new Thread(futureTask1,"t1");
        t2.start();
        executorService.submit(futureTask1);

        FutureTask futureTask2 = new FutureTask<String>(()->{
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            return "3结束";
        });
        Thread t3 = new Thread(futureTask2,"t1");
        t3.start();
        executorService.submit(futureTask2);
        System.out.println(futureTask.get());
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("时间"+(endTime-satatTime)+ "毫米");
    }
    public static void m1(String[] args){
        long satatTime = System.currentTimeMillis();
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
        long endTime = System.currentTimeMillis();
        System.out.println("时间"+(endTime-satatTime)+ "毫米");
        System.out.println(Thread.currentThread().getName());
    }
}
