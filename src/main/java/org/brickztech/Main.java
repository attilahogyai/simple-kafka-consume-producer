package org.brickztech;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        String externalFilePath = "test.properties";
        if (args.length == 1) {
            externalFilePath = args[0];
        }
        System.out.println(externalFilePath);

        Random random = new Random();

        TestProducer producer = new TestProducer();
        producer.init(externalFilePath);
        producer.produce("Hello Kafka for "+random.nextInt());
        TestConsumer testConsumer = new TestConsumer();
        testConsumer.init(externalFilePath);
        testConsumer.start();
        while(true){
            producer.produce("Üdv kafka:"+ random.nextInt());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}