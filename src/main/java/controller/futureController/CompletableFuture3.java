package controller.futureController;

import java.util.concurrent.*;

//thenApply存在依赖关系，可传值
//对计算结果进行处理
public class CompletableFuture3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        }, threadPool).thenApply(f -> {
//            int i = 10/0;
            System.out.println("111");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("222");
            return f + 4;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算" + v);
            }
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "main");
        threadPool.shutdown();
    }
}
