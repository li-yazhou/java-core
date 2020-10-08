package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author liyazhou
 * @date 2020/10/4
 */
public class ConsumerDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerDemo.class);


    private final KafkaConsumer<String, String> consumer;
    private final String topic = "topic20201004-1700";


    public ConsumerDemo() {
        Properties conf = new ConsumerConf().newConfig();
        consumer = new KafkaConsumer<>(conf);
    }


    public void consume() {
        consumer.subscribe(Collections.singletonList(topic));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    LOG.info("新消息 offset = [{}], key = [{}], value = [{}]", record.offset(), record.key(), record.value());
                }
            }
        } catch (Exception ex) {
            LOG.error("消费消息时发生异常，", ex);
        } finally {
            consumer.close();
        }
    }


    public static void main(String[] args) {
        new ConsumerDemo().consume();
    }

}
