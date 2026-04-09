package edu.lk.ijse.gdse.sensor_telemetry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceDTO {
    private String deviceId;
    private String name;
    private String zoneId;
    private String userId;
    private Instant createAt;
}
