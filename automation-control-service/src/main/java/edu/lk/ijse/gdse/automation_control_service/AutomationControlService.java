package edu.lk.ijse.gdse.automation_control_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AutomationControlService {

	public static void main(String[] args) {
		SpringApplication.run(AutomationControlService.class, args);
	}

}
