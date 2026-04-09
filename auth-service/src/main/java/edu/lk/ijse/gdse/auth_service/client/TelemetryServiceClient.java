package edu.lk.ijse.gdse.auth_service.client;


import edu.lk.ijse.gdse.auth_service.dto.AuthResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telemetry-service", url = "http://localhost:8082/api/sensors")
public interface TelemetryServiceClient {

    @PostMapping(consumes = "application/json")
    void sendTokens(@RequestBody AuthResponseDTO authResponseDTO);
}

