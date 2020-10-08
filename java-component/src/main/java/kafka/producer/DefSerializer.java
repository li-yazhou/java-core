package kafka.producer;

import org.apache.kafka.common.serialization.Serializer;

/**
 * @author liyazhou
 * @date 2020/10/6
 */
public class DefSerializer implements Serializer<String> {

    @Override
    public byte[] serialize(String s, String o) {
        return new byte[0];
    }

}
