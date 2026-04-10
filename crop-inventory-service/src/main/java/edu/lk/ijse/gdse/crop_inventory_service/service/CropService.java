package edu.lk.ijse.gdse.crop_inventory_service.service;

import edu.lk.ijse.gdse.crop_inventory_service.dto.CropDTO;

import java.util.List;

public interface CropService {

    CropDTO createCrop(CropDTO cropDTO);
    CropDTO updateStatus(String id,  CropDTO cropDTO);
    List<CropDTO> getAllCrops();

}
