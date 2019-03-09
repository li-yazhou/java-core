package javabase.javase.serializer;

/**
 * <p>
 *
 * @author liyazhou1
 * @date 2019/3/8
 */
public interface Serializer {

    byte[] encode(Object obj);

    <T> T decode(Class<T> clazz, byte[] bytes);
}
