package edu.lk.ijse.gdse.automation_control_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AutomationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "automation_id")
    private String automationId;

    @Enumerated (EnumType.STRING)
    private AutomationStatus status;

}
