package io.bayrktlihn.springbootkafkatutorial.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLocation implements Serializable {

    private String vehicleId;

    private String lattitude;
    private String longitude;
}
