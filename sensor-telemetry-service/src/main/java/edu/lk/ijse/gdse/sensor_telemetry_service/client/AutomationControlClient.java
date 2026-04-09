package edu.lk.ijse.gdse.sensor_telemetry_service.client;

import edu.lk.ijse.gdse.sensor_telemetry_service.dto.DeviceDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "automation-client", url = "")
public interface AutomationControlClient {

    @PostMapping(value = "", consumes = "application/json")
    void sendDeviceData(@RequestBody DeviceDetailsDTO deviceDetailsDTO);
}
