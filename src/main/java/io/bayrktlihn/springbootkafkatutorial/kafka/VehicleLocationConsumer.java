package io.bayrktlihn.springbootkafkatutorial.kafka;

import io.bayrktlihn.springbootkafkatutorial.constant.KafkaConstant;
import io.bayrktlihn.springbootkafkatutorial.model.dto.ChangeVehicleLocation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class VehicleLocationConsumer {


//    @KafkaListener(topics = KafkaConstant.LOCATION_TOPIC_NAME, groupId = KafkaConstant.CHANGED_LOCATION_LISTENER_GROUP)
//    public void receiveChangedLocation(
//            @Header(KafkaHeaders.RECEIVED_KEY) String key,
//            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
//            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts,
//            @Header(KafkaHeaders.OFFSET) int offset,
//            @Payload ChangeVehicleLocation changeVehicleLocation){
//        log.info("{}", changeVehicleLocation);
//    }

    @KafkaListener(topics = KafkaConstant.LOCATION_TOPIC_NAME, groupId = KafkaConstant.CHANGED_LOCATION_LISTENER_GROUP)
    public void receiveChangedLocation(
            ConsumerRecord<String, Object> record){
        log.info("{}", record);
    }

    @KafkaListener(topics = KafkaConstant.LOCATION_TOPIC_NAME, groupId = KafkaConstant.CHANGED_LOCATION_LISTENER_GROUP)
    public void receiveChangedLocation2(@Payload ChangeVehicleLocation changeVehicleLocation){
        log.info("{}", changeVehicleLocation);
    }

}
