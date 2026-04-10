package edu.lk.ijse.gdse.crop_inventory_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String batchId;
    private String cropName;

    @Enumerated(EnumType.STRING)
    private StateMachine stateMachine;
    private Instant registeredAT;

    @PrePersist
    public void prePersist() {
        registeredAT = Instant.now();
    }


}
