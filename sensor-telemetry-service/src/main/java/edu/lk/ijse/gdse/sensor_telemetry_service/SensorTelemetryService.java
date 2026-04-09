package edu.lk.ijse.gdse.sensor_telemetry_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
public class SensorTelemetryService {

	public static void main(String[] args) {
		SpringApplication.run(SensorTelemetryService.class, args);
	}

}
