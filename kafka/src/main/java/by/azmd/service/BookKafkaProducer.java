package by.azmd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:/kafka.properties")
public class BookKafkaProducer {
    @Value("${kafka.topic.name}")
    private String TOPIC;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println(TOPIC);
        this.kafkaTemplate.send(TOPIC, message);
    }
}