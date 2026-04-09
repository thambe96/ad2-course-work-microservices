package edu.lk.ijse.gdse.sensor_telemetry_service.client;

import edu.lk.ijse.gdse.sensor_telemetry_service.dto.AuthResponseDTO;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.RefreshDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "refresh-user", url = "http://localhost:8087/api/auth")
public interface IoTUserRefreshClient {

    @PostMapping(value = "/refresh", consumes = "application/json")
    AuthResponseDTO refreshToken(
            @RequestHeader("Authorization") String accessToken,
            @RequestBody(required = true) RefreshDTO refreshTokenDTO);

}
