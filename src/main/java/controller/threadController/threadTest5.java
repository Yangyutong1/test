package controller.threadController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 线程池的种类
 */
public class threadTest5 {

    public static void main(String[] args) {

        //常用为3种
        //创建指定线程池，也叫核心线程
        //ExecutorService executorService = Executors.newFixedThreadPool(5);

        //创建单独线程池，也叫唯一线程去执行任务
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        //创建可扩展线程池，也叫可缓存线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();

        //定时任务线程池，它支持定时或周期性执行任务。比如每隔 10 秒钟执行一次任务
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        try {
            for (int i = 0; i <= 20; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理");
                });
            }
        } finally {
            executorService.shutdown();
        }

    }
}
