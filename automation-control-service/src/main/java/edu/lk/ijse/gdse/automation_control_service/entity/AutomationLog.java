package edu.lk.ijse.gdse.automation_control_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "automation_logs")
public class AutomationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "automation_id")
    private String automationId;

    @Enumerated (EnumType.STRING)
    private AutomationStatus status;

    private double currentTemp;
    private double maxTemp;
    private double minTemp;


    private LocalDateTime time;

}
