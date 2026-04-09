package edu.lk.ijse.gdse.automation_control_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SensorData {
    private Double temperature;
    private String tempUnit;
    private Double humidity;
    private String humidityUnit;
}
