package edu.lk.ijse.gdse.zone_management_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "zone")
public class Zone {

    @Id
    private String zoneId;
    private String name;
    private String deviceId;
    private String userId;
    private double minTemp;
    private double maxTemp;

}
