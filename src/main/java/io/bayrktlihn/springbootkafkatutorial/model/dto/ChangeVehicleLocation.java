package io.bayrktlihn.springbootkafkatutorial.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChangeVehicleLocation implements Serializable {
    private String vehicleId;
    private String lattitude;
    private String longitude;
}
