package javase.serializer.test;

import javase.serializer.impl.JSONSerializer;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2019/3/8
 */
@Slf4j
public class SerializerTest {

    public static void main(String[] args) {
        JSONSerializer serializer = new JSONSerializer();
        Book book = new Book("Netty In Action", "hepin", 99.9f);
        byte[] bytes = serializer.encode(book);
        Book decodedBook = serializer.decode(Book.class, bytes);
        log.info("book = {}", decodedBook);
        // book = Book(bookName=Netty In Action, author=hepin, price=99.9)
    }

}
