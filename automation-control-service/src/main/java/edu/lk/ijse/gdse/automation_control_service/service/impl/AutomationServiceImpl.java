package edu.lk.ijse.gdse.automation_control_service.service.impl;

import edu.lk.ijse.gdse.automation_control_service.client.ZoneThresholdClient;
import edu.lk.ijse.gdse.automation_control_service.dto.ZoneThresholdsDTO;
import edu.lk.ijse.gdse.automation_control_service.service.AutomationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutomationServiceImpl implements AutomationService {

    private final ZoneThresholdClient zoneThresholdClient;

    @Override
    public void createLog(String zoneId, String deviceId) {

        ZoneThresholdsDTO zoneThresholdsDTO = zoneThresholdClient.getZoneThresholds(zoneId, deviceId);

    }
}
