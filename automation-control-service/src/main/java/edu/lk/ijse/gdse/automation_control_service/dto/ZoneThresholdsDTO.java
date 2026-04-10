package edu.lk.ijse.gdse.automation_control_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ZoneThresholdsDTO {

    private String zoneId;
    private double maxTemp;
    private double minTemp;

}
