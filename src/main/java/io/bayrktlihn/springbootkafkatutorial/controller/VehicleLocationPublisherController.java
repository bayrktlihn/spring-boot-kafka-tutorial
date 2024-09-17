package io.bayrktlihn.springbootkafkatutorial.controller;

import io.bayrktlihn.springbootkafkatutorial.constant.KafkaConstant;
import io.bayrktlihn.springbootkafkatutorial.kafka.Publisher;
import io.bayrktlihn.springbootkafkatutorial.model.dto.ChangeVehicleLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/vehicle-location-publisher")
@RequiredArgsConstructor
public class VehicleLocationPublisherController {


    private final Publisher simplePublisher;


    @PostMapping("change-vehicle-location")
    public ResponseEntity<?> changeVehicleLocation(@RequestBody ChangeVehicleLocation changeVehicleLocation) {
        simplePublisher.publish(KafkaConstant.LOCATION_TOPIC_NAME, changeVehicleLocation.getVehicleId(), changeVehicleLocation);
        return ResponseEntity.ok().build();
    }


}
