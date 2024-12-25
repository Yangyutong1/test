
package controller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StreamTest implements Comparable<StreamTest> {

    private int id;

    private String name;

    private int age;

    private String biaoqian;

    private Integer score;

    private BigDecimal shengao;

    @Override
    public int compareTo(StreamTest other) {
        return Integer.compare(this.age, other.age); // 按照age字段进行排序（从小到大）
    }
}
