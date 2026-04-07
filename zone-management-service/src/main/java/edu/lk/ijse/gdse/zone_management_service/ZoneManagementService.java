package edu.lk.ijse.gdse.zone_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZoneManagementService {

	public static void main(String[] args) {
		SpringApplication.run(ZoneManagementService.class, args);
	}

}
