package controller.futureController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//采用异步多线程，同时去查询每个网站，图书的价格，时间对比
public class CompletableFutureDemo {

    static List<Book> list = Arrays.asList(
            new Book("jd"),
            new Book("tm"),
            new Book("pdd"),
            new Book("tb"),
            new Book("sn"),
            new Book("ymx")
    );

    //一家一家查
    public static List<String> getPrcie(List<Book> list, String productName) {
        return list
                .stream()
                .map(Book ->
                        String.format(productName + "in %s price is %.2f"
                                , Book.getName(), Book.Price(productName)))
                .collect(Collectors.toList());
    }

    //同时去查
    public static List<String> getCompletableFuturePrcie(List<Book> list, String productName) {
        return list.stream().map(Book ->
                        CompletableFuture.supplyAsync(() -> String.format(productName + "in %s price is %.2f",
                                Book.getName(),
                                Book.Price(productName))))
                .collect(Collectors.toList())
                .stream().map(s -> s.join())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> list1 = getPrcie(list, "mysql");
        list1.forEach(s -> {
            System.out.println(s);
        });
        long end = System.currentTimeMillis();
        System.out.println("time" + (end - start));
        System.out.println("----------------------------------------------------");

        long start1 = System.currentTimeMillis();
        List<String> list2 = getCompletableFuturePrcie(list, "mysql");
        list2.forEach(s -> {
            System.out.println(s);
        });
        long end1 = System.currentTimeMillis();
        System.out.println("time" + (end1 - start1));
    }
}

class Book {

    private String name;

    public String getName() {
        return name;
    }

    public Book(String name) {
        this.name = name;
    }

    public double Price(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
