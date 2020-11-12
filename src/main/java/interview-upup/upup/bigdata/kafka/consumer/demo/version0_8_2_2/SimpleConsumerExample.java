package upup.bigdata.kafka.consumer.demo.version0_8_2_2;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Yuan Jiajun
 * @date 2020/10/15 17:01
 * @description @link
 */
public class SimpleConsumerExample {

    private static final String TOPIC = "server_packet";
//    private static final String TOPIC = "yuanjiajun-test";

    public static void exec() throws UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("zookeeper.connect", "10.0.3.12:2181");
        props.put("auto.offset.reset", "smallest");
        props.put("group.id", "yuanjiajun-test2");
        props.put("enable.auto.commit", "true");
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("replica.fetch.max.bytes", "2097152001");
        props.put("fetch.message.max.bytes", "2097152001");
//        props.put("serializer.class", "kafka.serializer.ajg");
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        ConsumerConfig consumerConfig = new kafka.consumer.ConsumerConfig(props);
        ConsumerConnector consumerConnector = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);

        Map<String, Integer> topicCountMap = new HashMap<>();
        int localConsumerCount = 1;
        topicCountMap.put(TOPIC, localConsumerCount);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
                .createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(TOPIC);
        AtomicLong a = new AtomicLong();
        streams.stream().forEach(stream -> {
            ConsumerIterator<byte[], byte[]> it = stream.iterator();
            while (it.hasNext()) {
                ByteBuffer s = ByteBuffer.wrap(it.next().message());
                s.order(ByteOrder.LITTLE_ENDIAN);
                a.getAndIncrement();
                System.out.println(s.getInt() + " " + a);
//                System.out.println(new String(it.next().message()));
            }
        });
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        exec();
    }
}