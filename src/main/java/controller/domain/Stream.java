package controller.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Stream {

    private int id;

    private String name;

    private int age;

    private String biaoqian;

    private Integer score;
}
