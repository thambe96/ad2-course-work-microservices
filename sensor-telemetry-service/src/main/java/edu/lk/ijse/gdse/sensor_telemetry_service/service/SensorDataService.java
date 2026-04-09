package edu.lk.ijse.gdse.sensor_telemetry_service.service;

import edu.lk.ijse.gdse.sensor_telemetry_service.client.DeviceClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.client.IoTUserRefreshClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.client.SensorDataClient;
import edu.lk.ijse.gdse.sensor_telemetry_service.dto.*;
import edu.lk.ijse.gdse.sensor_telemetry_service.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class SensorDataService {

    private final DeviceClient deviceClient;
    private final SensorDataClient sensorDataClient;
    private final JWTUtil jwtUtil;
    private final IoTUserRefreshClient ioTUserRefreshClient;
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    public void fetchDevices(Tokens tokens) {



//        String accessToken = "Bearer " + tokens.getAccessToken();

        AtomicReference<String> accessToken = new AtomicReference<>("Bearer " + tokens.getAccessToken());

        ScheduledFuture<?> future = scheduledExecutorService.scheduleWithFixedDelay(() -> {

            if (jwtUtil.isTokenExpired(tokens.getAccessToken())) {
                // call the refresh token


                AuthResponseDTO authResponseDTO = ioTUserRefreshClient.refreshToken(
                        tokens.getAccessToken(),
                        new RefreshDTO(tokens.getRefreshToken()));

                tokens.setAccessToken(authResponseDTO.getAccessToken());
                tokens.setRefreshToken(authResponseDTO.getRefreshToken());

                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("Refresh Token was called !!!");
                System.out.println("Access Token: -> " + tokens.getAccessToken());
                System.out.println("Refresh Token: -> " + tokens.getRefreshToken());
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//                accessToken = "Bearer " + tokens.getAccessToken();
                accessToken.set("Bearer " + tokens.getAccessToken());

            }


            List<DeviceDTO> devices = deviceClient.getAllDevices(accessToken.get());

            final String tempAccessToken = accessToken.get();

            devices.forEach(deviceDTO -> {
                DeviceDetailsDTO deviceDetailsDTO = sensorDataClient.getDeviceData(tempAccessToken, deviceDTO.getDeviceId());
                System.out.println(deviceDetailsDTO.toString());
                System.out.println("---------------------------------------------------------");
            });


        }, 0, 10, TimeUnit.SECONDS);



        // now make this async that runs every 10 seconds

//        System.out.println(devices);



    }


}
