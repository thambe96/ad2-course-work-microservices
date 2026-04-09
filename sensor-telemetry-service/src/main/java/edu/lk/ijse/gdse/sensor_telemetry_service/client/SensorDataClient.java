package edu.lk.ijse.gdse.sensor_telemetry_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "sensor-data", url = "http://localhost:8087/api/devices")
public interface SensorDataClient {

    @GetMapping("/telemetry/{deviceId}")
    void getDeviceData(
            @RequestHeader("Authorization") String accessToken,
            @PathVariable("deviceId") String deviceId
    );
}
