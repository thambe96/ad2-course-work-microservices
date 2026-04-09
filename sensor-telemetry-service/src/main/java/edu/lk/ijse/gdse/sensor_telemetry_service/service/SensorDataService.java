package edu.lk.ijse.gdse.sensor_telemetry_service.service;

import edu.lk.ijse.gdse.sensor_telemetry_service.client.DeviceClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.client.IoTUserRefreshClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.client.SensorDataClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.*;
import edu.lk.ijse.gdse.sensor_telemetry_service.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorDataService {

    private final DeviceClient deviceClient;
    private final SensorDataClient sensorDataClient;
    private final JWTUtil jwtUtil;
    private final IoTUserRefreshClient ioTUserRefreshClient;

    public void fetchDevices(Tokens tokens) {

        String accessToken = "Bearer " + tokens.getAccessToken();
        if (jwtUtil.isTokenExpired(tokens.getAccessToken())) {
            // call the refresh token


            AuthResponseDTO authResponseDTO = ioTUserRefreshClient.refreshToken(
                    tokens.getAccessToken(),
                    new RefreshDTO(tokens.getRefreshToken()));

            tokens.setAccessToken(authResponseDTO.getAccessToken());
            tokens.setRefreshToken(authResponseDTO.getRefreshToken());

            System.out.println("Refresh Token was called !!!");

        }


        List<DeviceDTO> devices = deviceClient.getAllDevices(accessToken);

        devices.forEach(deviceDTO -> {
            DeviceDetailsDTO deviceDetailsDTO = sensorDataClient.getDeviceData(accessToken, deviceDTO.getDeviceId());
            System.out.println(deviceDetailsDTO.toString());
            System.out.println("---------------------------------------------------------");
        });


//        System.out.println(devices);



    }


}
