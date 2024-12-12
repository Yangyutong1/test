package controller.futureController;

import java.util.concurrent.*;

//CompletableFuture异步
public class CompletableFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //CompletableFuture无参，
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        },threadPool);
//        System.out.println(voidCompletableFuture.get());
        //CompletableFuture有参，
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "this supplyAsync";
        }, threadPool);
        System.out.println(completableFuture.get());
        threadPool.shutdown();

    }
}
