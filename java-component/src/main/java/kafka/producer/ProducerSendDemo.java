package kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author liyazhou
 * @date 2020/10/4
 */
public class ProducerSendDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerSendDemo.class);

    private KafkaProducer<String, String> producer;
    private final String topic =  "topic20201004-1700";


    public ProducerSendDemo() {
        Properties conf = new ProducerConf().newConfig();
        producer = new KafkaProducer<>(conf);
    }


    public void fireAndForgetSend() throws ExecutionException, InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<>("topic", "key", "value");
        Future<RecordMetadata> future = producer.send(record);
    }


    public void syncSend() throws InterruptedException {

        String[] keys = {"北京", "北京", "北京", "上海", "广州", "深圳"};

        int counter = 0;
        while (counter < 10000) {
            counter ++;
            String key = keys[counter % keys.length];
            String value = key + "-Message-" + counter;
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);

            try {
                RecordMetadata recordMetadata = producer.send(record).get();
                LOG.info("同步生产消息完成，counter-{}, recordMetadata = {}", counter, recordMetadata);
            } catch (Exception ex) {
                LOG.error("同步生产消息发生异常，", ex);
            }

            Thread.sleep(200);
        }
    }


    public void asyncSend() {
        ProducerRecord<String, String> record = new ProducerRecord<>("topic", "key", "value");

        Future<RecordMetadata> future = producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
                if (exception != null) {
                    LOG.error("异步生产消息发生异常，", exception);
                }
            }
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ProducerSendDemo().syncSend();
        // new ProducerSendDemo().asyncSend();
    }

}
