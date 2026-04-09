package edu.lk.ijse.gdse.sensor_telemetry_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tokens {
    String accessToken;
    String refreshToken;
}
