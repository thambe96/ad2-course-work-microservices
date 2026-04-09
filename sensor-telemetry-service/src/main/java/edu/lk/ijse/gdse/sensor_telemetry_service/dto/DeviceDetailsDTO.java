package edu.lk.ijse.gdse.sensor_telemetry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeviceDetailsDTO {

    private String deviceId;
    private String zoneId;
    private SensorData value;
    private Instant capturedAt;

}
