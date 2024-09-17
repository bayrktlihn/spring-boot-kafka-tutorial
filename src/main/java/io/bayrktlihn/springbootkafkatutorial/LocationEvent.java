package io.bayrktlihn.springbootkafkatutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationEvent {
    private final KafkaTemplate<String, Object> kafkaTemplate;
}
