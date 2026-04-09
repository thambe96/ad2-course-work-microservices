package edu.lk.ijse.gdse.auth_service.client;

import edu.lk.ijse.gdse.auth_service.dto.AuthRequestDTO;
import edu.lk.ijse.gdse.auth_service.dto.AuthResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-login-iot", url = "http://localhost:8087/api/auth")
public interface IoTUserLoginClient {
    @PostMapping(value = "/login", consumes = "application/json")
    AuthResponseDTO login(@RequestBody AuthRequestDTO authRequestDTO);
}
