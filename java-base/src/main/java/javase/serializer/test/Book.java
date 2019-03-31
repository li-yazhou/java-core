package javase.serializer.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2019/3/8
 */
@AllArgsConstructor
@Getter
@ToString
public class Book {
    private String bookName;
    private String author;
    private float price;
}
