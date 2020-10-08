package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author liyazhou
 * @date 2020/10/4
 */
public class ConsumerConf {

    // required config
    private final String brokerList = "127.0.0.1:9092";
    private final String groupId = "test-consumer-group";  // 默认值
    private final String autoCommit = "true";
    private final String autoCommitIntervalMs = "1000";
    private final String sessionTimeoutMs = "30000";
    private final String keyDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";
    private final String valueDeserializer = "org.apache.kafka.common.serialization.StringDeserializer";


    public Properties newConfig() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitIntervalMs);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        return props;
    }
}
