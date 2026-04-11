package edu.lk.ijse.gdse.automation_control_service.dto;

import edu.lk.ijse.gdse.automation_control_service.entity.AutomationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutomationLogDTO {

    private String automationId;
    private AutomationStatus status;
    private LocalDateTime time;

}
