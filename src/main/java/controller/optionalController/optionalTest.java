package controller.optionalController;

import controller.domain.StreamTest;

import java.math.BigDecimal;
import java.util.Optional;

public class optionalTest {
    public static void main(String[] args) {

        //采用Optional判空处理
//        StreamTest stream = getAuthor2();
//        Optional.ofNullable(stream).ifPresent(s -> System.out.println(s.getName()));

        //采用静态方法，直接返回Optional对象
        //orElseGet当返回对象为空时，采用默认值
        Optional<StreamTest> optional = getAuthorOptional();
//        Stream stream = optional.orElseGet(() -> new Stream(1, "测试3333", 20, "AAAAAAAAAAAAAAAAA", 11, new BigDecimal(6.3454)));
//        System.out.println(stream.getName());

        // orElseThrow当返回对象为空时，抛出异常
//        try {
//            Stream stream = optional.orElseThrow(() -> new RuntimeException("没有数据"));
//            System.out.println(stream);
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }

    }

    public static Optional<StreamTest> getAuthorOptional() {
        StreamTest streamTest = new StreamTest(1, "测试1", 20, "AAAAAAAAAAAAAAAAA", 11, new BigDecimal(6.3454));
        return Optional.ofNullable(null);
    }

    public static StreamTest getAuthor2() {
        StreamTest streamTest = new StreamTest(1, "测试1", 20, "AAAAAAAAAAAAAAAAA", 11, new BigDecimal(6.3454));
        return null;
    }
}
