package javase.serializer.impl;

import com.alibaba.fastjson.JSON;
import javase.serializer.Serializer;
import lombok.NonNull;


/**
 * <p>
 *
 * @author liyazhou1
 * @date 2019/3/8
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte[] encode(@NonNull Object obj) {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T decode(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
