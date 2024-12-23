package controller.streamController;

import controller.domain.Stream;

import java.util.*;
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
//        getAuthor().stream().distinct().sorted().forEach(e-> System.out.println(e.getAge()));

        //设置最大长度，剩余的将被扔掉
//        getAuthor().stream().distinct().sorted().limit(2).forEach(e-> System.out.println(e.getAge()));

        //跳过第一个元素，输出其他元素
//        getAuthor().stream().distinct().sorted().skip(1).forEach(s-> System.out.println(s.getName()));

        //最大值
//        Optional<Integer> max = getAuthor().stream().map(e -> e.getAge()).max((s1, s2) -> s1 - s2);
//        System.out.println(max.get());

        //最小值
//        Optional<Integer> min = getAuthor().stream().map(e -> e.getAge()).max((s1, s2) -> s2 - s1);
//        System.out.println(min.get());

//        List<Integer> collect = getAuthor().stream().map(e -> e.getAge()).collect(Collectors.toList());
//        System.out.println(collect);

        // 采用Map，key放name.value放年龄，
        // 用到distinct因为，map的key不允许重复，需去重
//        Map<String, Integer> collect1 = getAuthor().stream().distinct().collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
//        System.out.println(collect1);

        //查看流中是否有年龄大于50的值
//        boolean flag = getAuthor().stream().anyMatch(e -> e.getAge() > 50);
//        System.out.println(flag);

        //查看流中的所有元素，名字是否都包含 "测试" 两个字
        boolean flag = getAuthor().stream().allMatch(e -> e.getName().contains("测试"));
        System.out.println(flag);
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
