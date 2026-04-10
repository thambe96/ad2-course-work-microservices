package edu.lk.ijse.gdse.zone_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ThresholdLimitsDTO {

    private String zoneId;
    private double minTemp;
    private double maxTemp;

}
