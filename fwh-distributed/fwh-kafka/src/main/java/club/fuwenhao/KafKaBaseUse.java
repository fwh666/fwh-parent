package club.fuwenhao;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @program: fwh-parent
 * @description: kafka基本使用
 * @author: fwh
 * @date: 2021-07-27 15:21
 **/
public class KafKaBaseUse {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //生产者
//        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        properties.put(ProducerConfig.ACKS_CONFIG, "1");
//        properties.put(ProducerConfig.RETRIES_CONFIG, 3);
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//
//        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
////        final CountDownLatch countDownLatch = new CountDownLatch(5);
//        for (int i = 0; i < 5; i++) {
//            ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String >("mykafka","orderid","order");
//
//            RecordMetadata recordMetadata = producer.send(producerRecord).get();
//            System.out.println("同步发送消息结果："+recordMetadata.topic()+"partion:"+recordMetadata.partition()+ "offset:"+recordMetadata.offset());
//        }
//        producer.close();
//    }

    public static void main(String[] args) {
        //消费者
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
//        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"test");



        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("mykafka"));

        //指定时间消费
//        Map<TopicPartition, OffsetAndTimestamp> timestampMap = consumer.offsetsForTimes(new HashMap<>());
//        for (Map.Entry<TopicPartition, OffsetAndTimestamp> topicPartitionOffsetAndTimestampEntry : timestampMap.entrySet()) {
//            TopicPartition key = topicPartitionOffsetAndTimestampEntry.getKey();
//            OffsetAndTimestamp value = topicPartitionOffsetAndTimestampEntry.getValue();
//            if (null==key||value==null) {
//                continue;
//            }
//            long offset = value.offset();
//            System.out.println("partion:"+key.partition()+"offset:"+offset);
//
//            if (value!=null) {
//                consumer.assign(Arrays.asList(key));
//                consumer.seek(key,offset);
//            }
//        }

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("收到消息：partition:"+record.partition()+"offset:"+record.offset()+"key:"+record.key()+"value:"+record.value());
            }
        }



    }
}
