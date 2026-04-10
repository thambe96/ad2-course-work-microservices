package edu.lk.ijse.gdse.automation_control_service.service.impl;

import edu.lk.ijse.gdse.automation_control_service.client.ZoneThresholdClient;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class AutomationServiceImpl implements AutomationService {

    private final ZoneThresholdClient zoneThresholdClient;
    private final AutomationLogRepo automationLogRepo;

    @Override
    public void createLog(SensorDataDTO sensorDataDTO) {

        ZoneThresholdsDTO zoneThresholdsDTO = zoneThresholdClient.getZoneThresholds(
                sensorDataDTO.getZoneId(),
                sensorDataDTO.getDeviceId());

        AutomationLog automationLog = new AutomationLog();
        LocalDateTime automatedActionLoggedAt = null;
        AutomationStatus automationStatus = AutomationStatus.TURN_FAN_ON;
        if (sensorDataDTO.getValue().getTemperature() > zoneThresholdsDTO.getMaxTemp()) {
            automatedActionLoggedAt = LocalDateTime.now();
            log.info("Event={}", AutomationStatus.TURN_FAN_ON);


        }
        if (sensorDataDTO.getValue().getTemperature() < zoneThresholdsDTO.getMinTemp()) {
            automatedActionLoggedAt = LocalDateTime.now();
            log.info("Event={}", AutomationStatus.TURN_HEATER_ON);
            automationStatus = AutomationStatus.TURN_HEATER_ON;
        }

        automationLog.setStatus(automationStatus);
        automationLog.setTime(automatedActionLoggedAt);
        automationLogRepo.save(automationLog);


        //repo implement jpa
        // write the logic here

    }
}
