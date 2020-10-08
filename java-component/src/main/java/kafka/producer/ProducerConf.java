package kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author liyazhou
 * @date 2020/10/4
 */
public class ProducerConf {

    // required config
    private final String brokerList = "127.0.0.1:9092";
    private final String keySerializer = StringSerializer.class.getName();
    private final String valueSerializer = StringSerializer.class.getName();

    private final String interceptors = DefInterceptor.class.getName();

    // other config
    private final String ack = "0";
    private final String timeout = "60000";
    private final String bufferSize = "1024";


    private final String topic = "";


    public Properties newConfig() {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);

        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);

        return props;
    }

}
