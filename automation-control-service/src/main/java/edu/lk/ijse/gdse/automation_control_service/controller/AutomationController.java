package edu.lk.ijse.gdse.automation_control_service.controller;

import edu.lk.ijse.gdse.automation_control_service.dto.SensorDataDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    @PostMapping(value = "/process")
    void saveLogs(@RequestBody SensorDataDTO sensorDataDTO) {

    }

}
