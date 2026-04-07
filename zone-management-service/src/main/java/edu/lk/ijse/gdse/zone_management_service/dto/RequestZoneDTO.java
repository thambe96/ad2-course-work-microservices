package edu.lk.ijse.gdse.zone_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RequestZoneDTO {
    private String zoneId;
    private String name;
    private double minTemp;
    private double maxTemp;
}
