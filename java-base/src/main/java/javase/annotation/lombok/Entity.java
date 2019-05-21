package javase.annotation.lombok;

import lombok.*;

import java.util.List;

/**
 * @author liyazhou1
 * @desc TODO
 * @date 2019/5/10
 */
public class Entity {
}


@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
class Person {
    private String name;
    private Integer age;
}


@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
class Student extends Person {
    private String studentId;
    @Singular
    private List<Book> books;

//    @Builder
    public Student(String name, Integer age, String studentId, List<Book> books) {
        // 显式调用父类的全参构造方法
        super(name, age);
        this.studentId = studentId;
        this.books = books;
    }
}


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
class Book {
    @Builder.Default
    private String name = "Java Core";
}