
package controller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Stream implements Comparable<Stream> {

    private int id;

    private String name;

    private int age;

    private String biaoqian;

    private Integer score;


    @Override
    public int compareTo(Stream other) {
        return Integer.compare(this.age, other.age); // 按照age字段进行排序（从小到大）
    }
}
