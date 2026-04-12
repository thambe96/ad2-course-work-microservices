package edu.lk.ijse.gdse.sensor_telemetry_service.controller;

import edu.lk.ijse.gdse.sensor_telemetry_service.dto.AuthResponseDTO;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.DeviceDetailsDTO;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.Tokens;
import edu.lk.ijse.gdse.sensor_telemetry_service.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sensors")
@RequiredArgsConstructor
public class SensorTelemetryController {

    private final SensorDataService sensorDataService;

    @PostMapping
    public void fetchSensorTelemetry(@RequestBody AuthResponseDTO authResponseDTO) {

//        System.out.println(authResponseDTO.getUsername());
//        System.out.println(authResponseDTO.getAccessToken());
//        System.out.println(authResponseDTO.getRefreshToken());
        //Now design the scheduler

        Tokens tokens = new Tokens(
                authResponseDTO.getAccessToken(),
                authResponseDTO.getRefreshToken()
        );

        sensorDataService.fetchDevices(tokens);


    }


    @GetMapping("/latest")
    ResponseEntity<DeviceDetailsDTO> fetchLatestSensorTelemetry() {
        return ResponseEntity.ok(sensorDataService.fetchLatestDeviceDetails());
    }

    @PostMapping("/terminate")
    public void terminateSensorTelemetry() {
        System.out.println("Terminating sensor telemetry");
//        sensorDataService.terminateRunningTask();
    }




}
