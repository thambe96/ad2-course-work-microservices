package edu.lk.ijse.gdse.automation_control_service.controller;

import edu.lk.ijse.gdse.automation_control_service.dto.AutomationLogDTO;
import edu.lk.ijse.gdse.automation_control_service.dto.SensorDataDTO;
import edu.lk.ijse.gdse.automation_control_service.service.AutomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automation")
@RequiredArgsConstructor
public class AutomationController {

    private final AutomationService automationService;

    @PostMapping(value = "/process")
    void saveLogs(@RequestBody SensorDataDTO sensorDataDTO) {
//        System.out.println("Automation Controller: " + sensorDataDTO.toString());
        automationService.createLog(sensorDataDTO);

    }

    @GetMapping("/logs")
    ResponseEntity<List<AutomationLogDTO>> getLogs() {
        return  ResponseEntity.ok(automationService.getAutomationLogs());
    }




}
