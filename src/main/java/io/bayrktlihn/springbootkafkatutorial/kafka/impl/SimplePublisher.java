package io.bayrktlihn.springbootkafkatutorial.kafka.impl;

import io.bayrktlihn.springbootkafkatutorial.kafka.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class SimplePublisher implements Publisher {


    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public <V> void publish(String topicName, String key, V value) {
        doPublish(topicName, key, value);
    }

    private <V> void doPublish(String topicName, String key, V value) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topicName, key, value);

        future.whenCompleteAsync((stringObjectSendResult, throwable) -> {
            if(throwable != null){
                log.info("{}", throwable);
            } else {
                ProducerRecord<String, Object> producerRecord = stringObjectSendResult.getProducerRecord();
                RecordMetadata recordMetadata = stringObjectSendResult.getRecordMetadata();

                log.info("{} | {} | {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset());
            }

        });
    }
}
