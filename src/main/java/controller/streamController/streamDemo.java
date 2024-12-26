package controller.streamController;

import controller.domain.StreamTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

//采用流的形式，去重打印年龄小于25岁的人名

public class streamDemo {

    public static void main(String[] args) {
//        getAuthor().stream().filter(e -> e.getName().length() > 3).forEach(e-> System.out.println(e.getName()));
//        getAuthor().stream().map(e->e.getName()).forEach(e-> System.out.println(e));
//        getAuthor().stream().distinct().forEach(e-> System.out.println(e.getName()));
//        getAuthor().stream().distinct().sorted().forEach(e-> System.out.println(e.getAge()));

        //设置最大长度，剩余的将被扔掉
//        getAuthor().stream().distinct().sorted().limit(2).forEach(Stream::getAge);

        //跳过第一个元素，输出其他元素
//        getAuthor().stream().distinct().sorted().skip(1).forEach(s-> System.out.println(s.getName()));

        //最大值
//        Optional<Integer> max = getAuthor().stream().map(e -> e.getAge()).max((s1, s2) -> s1 - s2);
//        System.out.println(max.get());

        //最小值
//        Optional<Integer> min = getAuthor().stream().map(e -> e.getAge()).max((s1, s2) -> s2 - s1);
//        System.out.println(min.get());

//        List<Integer> collect = getAuthor().stream().map(Stream::getAge).collect(Collectors.toList());
//        System.out.println(collect);

        // 采用Map，key放name.value放年龄，
        // 用到distinct因为，map的key不允许重复，需去重
//        Map<String, Integer> collect1 = getAuthor().stream().distinct().collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
//        System.out.println(collect1);

        //查看流中是否有年龄大于50的值
//        boolean flag = getAuthor().stream().anyMatch(e -> e.getAge() > 50);
//        System.out.println(flag);

        //查看流中的所有元素，名字是否都包含 "测试" 两个字
//        boolean flag = getAuthor().stream().allMatch(e -> e.getName().contains("测试"));
//        System.out.println(flag);

        //去重，并过滤出年龄大于20岁，年龄的总合
//        Integer reduce = getAuthor().stream().distinct().filter(e->e.getAge()>20).map(StreamTest::getAge).reduce(0, Integer::sum);
//        System.out.println(reduce);

        //身高总合
//        BigDecimal reduce = getAuthor().stream().map(StreamTest::getShengao).reduce(BigDecimal.ZERO, BigDecimal::add);
//        System.out.println(reduce);

//        getAuthor().stream()
//                .map(e->e.getName())
//                .map(StringBuilder::new)
//                .map(s->s.append("121").toString())
//                .forEach(System.out::println);

//       getAuthor().stream()
//               .map(Stream::getAge)
//               .map(age->age+10)
//               .filter(age->age>10)
//               .map(age->age+2)
//               .forEach(age-> System.out.println(age));

//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(stream.filter(s -> s > 5).reduce(0, Integer::sum));

//        new Thread(() -> System.out.println(Thread.currentThread().getName()),"AA").start();

    }

    private static List<StreamTest> getAuthor() {
        List list = new ArrayList<>();
        StreamTest streamTest = new StreamTest(1, "测试1", 20, "AAAAAAAAAAAAAAAAA", 11, new BigDecimal(6.3454));
        StreamTest streamTest1 = new StreamTest(2, "测试AA", 22, "BBBBBBBBBBBBBBBBB", 22, new BigDecimal(21.431));
        StreamTest streamTest2 = new StreamTest(3, "测试ABC", 34, "CCCCCCCCCCCCCCCCC", 33, new BigDecimal(11.21));
        StreamTest streamTest3 = new StreamTest(4, "测试D", 17, "DDDDDDDDDDDDDDDDDDD", 44, new BigDecimal(125.21));
        StreamTest streamTest4 = new StreamTest(4, "测试D", 17, "DDDDDDDDDDDDDDDDDDD", 44, new BigDecimal(65.12));

        list.add(streamTest);
        list.add(streamTest1);
        list.add(streamTest2);
        list.add(streamTest3);
        list.add(streamTest4);
        return list;
    }
}
