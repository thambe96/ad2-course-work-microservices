package edu.lk.ijse.gdse.zone_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class IotServerResponse {

    private String zoneId;
    private String name;
    private String deviceId;
    private String userId;
    private Date createAt;
}
