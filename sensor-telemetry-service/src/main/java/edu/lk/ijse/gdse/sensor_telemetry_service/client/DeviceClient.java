package edu.lk.ijse.gdse.sensor_telemetry_service.client;

import edu.lk.ijse.gdse.sensor_telemetry_service.dto.DeviceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "device-client", url = "http://localhost:8087/api/devices")
public interface DeviceClient {
    @GetMapping
    List<DeviceDTO> getAllDevices(@RequestHeader("Authorization") String accessToken);
}
