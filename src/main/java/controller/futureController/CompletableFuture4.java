package controller.futureController;

import java.util.concurrent.*;

//获取结果
public class CompletableFuture4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "abc";
        });

//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.join());
//        System.out.println(completableFuture.get(1L, TimeUnit.SECONDS));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(completableFuture.getNow("cccc"));
    }
}
