package controller.streamController;

import controller.domain.Stream;

import java.util.ArrayList;
import java.util.List;

//采用流的形式，去重打印年龄小于25岁的人名

public class streamDemo {

    public static void main(String[] args) {
        getAuthor().stream().distinct()
                .filter(age -> age.getAge() < 25)
                .forEach(name -> System.out.println(name.getName()));
    }

    private static List<Stream> getAuthor() {
        List list = new ArrayList<>();
        Stream stream = new Stream(1, "A", 20, "AAAAAAAAAAAAAAAAA", 11);
        Stream stream1 = new Stream(2, "B", 22, "BBBBBBBBBBBBBBBBB", 22);
        Stream stream2 = new Stream(3, "C", 34, "CCCCCCCCCCCCCCCCC", 33);
        Stream stream3 = new Stream(4, "D", 17, "DDDDDDDDDDDDDDDDDDD", 44);
        Stream stream4 = new Stream(4, "D", 17, "DDDDDDDDDDDDDDDDDDD", 44);

        list.add(stream);
        list.add(stream1);
        list.add(stream2);
        list.add(stream3);
        list.add(stream4);
        return list;
    }
}
