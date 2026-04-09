package edu.lk.ijse.gdse.sensor_telemetry_service.service;

import edu.lk.ijse.gdse.sensor_telemetry_service.client.DeviceClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.DeviceDTO;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.Tokens;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {

    private final DeviceClient deviceClient;
    public void fetchDevices(Tokens tokens) {
        String accessToken = "Bearer " + tokens.getAccessToken();
        List<DeviceDTO> devices = deviceClient.getAllDevices(accessToken);
        System.out.println(devices);
    }


}
