package edu.lk.ijse.gdse.crop_inventory_service.dto;

import edu.lk.ijse.gdse.crop_inventory_service.entity.StateMachine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO {

    private String batchId;
    private String cropName;
    private StateMachine stateMachine;
    private Instant registeredAT;

}
