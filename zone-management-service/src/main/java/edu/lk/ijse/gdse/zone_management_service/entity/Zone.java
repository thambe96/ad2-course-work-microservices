package edu.lk.ijse.gdse.zone_management_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String recordId;
    private String zoneId;
    private String name;
    private String deviceId;
    private String userId;
    private double minTemp;
    private double maxTemp;
    private Date createdAt;

}
