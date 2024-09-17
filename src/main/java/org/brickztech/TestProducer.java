package org.brickztech;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class TestProducer {
    private final ConfigReader config = new ConfigReader();
    KafkaProducer<String, String> producer;
    String topicName;
    public void init (String file) throws IOException {
        Properties properties = config.getData(file);
        producer = new KafkaProducer<>(properties);
        topicName = properties.getProperty("topic.name");
    }
    public void produce(String message) {
        producer.send(new ProducerRecord<>(topicName, message));
    }
}
