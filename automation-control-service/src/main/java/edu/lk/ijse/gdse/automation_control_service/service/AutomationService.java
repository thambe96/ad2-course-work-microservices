package edu.lk.ijse.gdse.automation_control_service.service;

import edu.lk.ijse.gdse.automation_control_service.dto.AutomationLogDTO;
import edu.lk.ijse.gdse.automation_control_service.dto.SensorDataDTO;

import java.util.List;

public interface AutomationService {

    void createLog(SensorDataDTO data);
    List<AutomationLogDTO> getAutomationLogs();


}
