package edu.lk.ijse.gdse.automation_control_service.service.impl;

import edu.lk.ijse.gdse.automation_control_service.client.ZoneThresholdClient;
import edu.lk.ijse.gdse.automation_control_service.dto.AutomationLogDTO;
import edu.lk.ijse.gdse.automation_control_service.dto.SensorDataDTO;
import edu.lk.ijse.gdse.automation_control_service.dto.ZoneThresholdsDTO;
import edu.lk.ijse.gdse.automation_control_service.entity.AutomationLog;
import edu.lk.ijse.gdse.automation_control_service.entity.AutomationStatus;
import edu.lk.ijse.gdse.automation_control_service.repo.AutomationLogRepo;
import edu.lk.ijse.gdse.automation_control_service.service.AutomationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutomationServiceImpl implements AutomationService {

    private final ZoneThresholdClient zoneThresholdClient;
    private final AutomationLogRepo automationLogRepo;

    @Override
    public void createLog(SensorDataDTO sensorDataDTO) {

        System.out.println("SensorDataDTO: -> " + sensorDataDTO.toString());

        ZoneThresholdsDTO zoneThresholdsDTO = zoneThresholdClient.getZoneThresholds(
                sensorDataDTO.getZoneId(),
                sensorDataDTO.getDeviceId());


        AutomationLog automationLog = new AutomationLog();
//        LocalDateTime automatedActionLoggedAt = null;
//        AutomationStatus automationStatus = AutomationStatus.NO_ACTION;

        System.out.println("--------------------------------------------------------");
        System.out.println("Current Temperature: " + sensorDataDTO.getValue().getTemperature());
        System.out.println("Max Temperature: " + zoneThresholdsDTO.getMaxTemp());
        System.out.println("Min Temperature: " + zoneThresholdsDTO.getMinTemp());
        System.out.println("--------------------------------------------------------");

        if (sensorDataDTO.getValue().getTemperature() > zoneThresholdsDTO.getMaxTemp()) {
            log.info("Event={}", AutomationStatus.TURN_FAN_ON);
            automationLog.setStatus(AutomationStatus.TURN_FAN_ON);
            automationLog.setTime(LocalDateTime.now());
            automationLogRepo.save(automationLog);
        }


        if (sensorDataDTO.getValue().getTemperature() < zoneThresholdsDTO.getMinTemp()) {
            log.info("Event={}", AutomationStatus.TURN_HEATER_ON);
            automationLog.setStatus(AutomationStatus.TURN_HEATER_ON);
            automationLog.setTime(LocalDateTime.now());
            automationLogRepo.save(automationLog);
        }

        //repo implement jpa
        // write the logic here

    }


    public List<AutomationLogDTO> getAutomationLogs() {
        List<AutomationLog> automationLogs = automationLogRepo.findAll();
        List<AutomationLogDTO> automationLogDTOs = new ArrayList<>();
        for (AutomationLog automationLog : automationLogs) {
            automationLogDTOs.add(new AutomationLogDTO(
                    automationLog.getAutomationId(),
                    automationLog.getStatus(),
                    automationLog.getTime()));
        }
        return automationLogDTOs;
    }




}
