package controller.futureController;

import java.sql.Time;
import java.util.concurrent.*;

//使用，CompletableFuture的whenComplete回调函数
public class CompletableFuture2 {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "-------------------come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("结果" + result);
                //模拟报错
                if (result > 5) {
                    int i = 10 / 0;
                }
                return result;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("没有异常" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常" + e.getMessage());
                return null;
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + "主线程");
        //不让线程睡眠，使用线程池，防止默认线程关闭
        //        TimeUnit.SECONDS.sleep(3);
    }
}
