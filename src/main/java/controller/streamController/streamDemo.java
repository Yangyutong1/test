package controller.streamController;

import controller.domain.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//采用流的形式，去重打印年龄小于25岁的人名

public class streamDemo {

    public static void main(String[] args) {
//        getAuthor().stream().filter(e -> e.getName().length() > 3).forEach(e-> System.out.println(e.getName()));
//        getAuthor().stream().map(e->e.getName()).forEach(e-> System.out.println(e));
//        getAuthor().stream().distinct().forEach(e-> System.out.println(e.getName()));
        getAuthor().stream().distinct().sorted().forEach(e-> System.out.println(e.getAge()));
    }

    private static List<Stream> getAuthor() {
        List list = new ArrayList<>();
        Stream stream = new Stream(1, "测试1", 20, "AAAAAAAAAAAAAAAAA", 11);
        Stream stream1 = new Stream(2, "测试AA", 22, "BBBBBBBBBBBBBBBBB", 22);
        Stream stream2 = new Stream(3, "测试ABC", 34, "CCCCCCCCCCCCCCCCC", 33);
        Stream stream3 = new Stream(4, "测试D", 17, "DDDDDDDDDDDDDDDDDDD", 44);
        Stream stream4 = new Stream(4, "测试D", 17, "DDDDDDDDDDDDDDDDDDD", 44);

        list.add(stream);
        list.add(stream1);
        list.add(stream2);
        list.add(stream3);
        list.add(stream4);
        return list;
    }
}
