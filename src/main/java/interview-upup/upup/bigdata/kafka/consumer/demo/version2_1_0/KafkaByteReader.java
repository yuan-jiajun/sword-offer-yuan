/*
package upup.bigdata.kafka.consumer.demo.version2_1_0;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


public class KafkaByteReader implements Runnable {
    String topic;
    String groupId;
    String brokers;

    public KafkaByteReader(String topic, String brokers, String groupId) {
        this.topic = topic;
        this.brokers = brokers;
        this.groupId = groupId;
    }

    //config
    public static Properties getConfig(String group_id, String broker_list) {
        Properties props = new Properties();
        props.put("group.id", group_id);
        props.put("bootstrap.servers", broker_list);
        props.put("auto.offset.reset", "earliest");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        return props;
    }

    public void consumeMessage() {
        // launch 3 threads to consume
        int numConsumers = 1;
//        final String topic = this.topic;
        final ExecutorService executor = Executors.newFixedThreadPool(numConsumers);
        final List<KafkaConsumerRunner> consumers = new ArrayList<KafkaConsumerRunner>();
        for (int i = 0; i < numConsumers; i++) {
            KafkaConsumerRunner consumer = new KafkaConsumerRunner(this.topic, this.brokers, this.groupId);
            consumers.add(consumer);
            executor.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (KafkaConsumerRunner consumer : consumers) {
                    consumer.shutdown();
                }
                executor.shutdown();
                try {
                    executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void run() {
        consumeMessage();
    }

    // Thread to consume kafka data
    public static class KafkaConsumerRunner implements Runnable {
        private final AtomicBoolean closed = new AtomicBoolean(false);
        private final KafkaConsumer<byte[], byte[]> consumer;
        private final String topic;
        private final String brokers;
        private final String groupId;

        public KafkaConsumerRunner(String topic, String brokers, String groupId) {
            Properties props = getConfig(groupId, brokers);
            consumer = new KafkaConsumer<>(props);
            this.topic = topic;
            this.brokers = brokers;
            this.groupId = groupId;
        }

        public void handleRecord(ConsumerRecord<byte[], byte[]> record) {
            System.out.println("aaaa");
            System.out.println("message: " + new String(record.value()));

//            System.out.println("name: " +
//                    Thread.currentThread().getName() +
//                    " ; topic: " + record.topic() +
//                    " ; offset" + record.offset() +
//                    " ; key: " + record.key() + " ; value: " + record.value());

        }

        public void run() {
            try {
                // subscribe 订阅topic
                consumer.subscribe(Collections.singletonList(topic));
                while (!closed.get()) {
                    //read data
                    ConsumerRecords<byte[], byte[]> records = consumer.poll(Duration.ofMillis(10000));
                    // Handle new records
                    for (ConsumerRecord<byte[], byte[]> record : records) {
                        handleRecord(record);
                    }
                }
            } catch (WakeupException e) {
                // Ignore exception if closing
                e.printStackTrace();
                if (!closed.get()) {
                    throw e;
                }
            } finally {
                consumer.close();
            }
        }

        // Shutdown hook which can be called from a separate thread
        public void shutdown() {
            closed.set(true);
            consumer.wakeup();
        }
    }

    public static void main(String[] args) {
        KafkaByteReader example = new KafkaByteReader("xmt-data",
                "10.0.3.12:9001",
                "yuanjiajun-test");
        example.consumeMessage();
    }
}
*/
