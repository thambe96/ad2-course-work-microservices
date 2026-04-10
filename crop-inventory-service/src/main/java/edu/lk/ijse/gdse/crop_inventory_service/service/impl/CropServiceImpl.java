package edu.lk.ijse.gdse.crop_inventory_service.service.impl;

import edu.lk.ijse.gdse.crop_inventory_service.dto.CropDTO;
import edu.lk.ijse.gdse.crop_inventory_service.entity.Crop;
import edu.lk.ijse.gdse.crop_inventory_service.entity.StateMachine;
import edu.lk.ijse.gdse.crop_inventory_service.repository.CropRepo;
import edu.lk.ijse.gdse.crop_inventory_service.service.CropService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepo cropRepo;
    private final ModelMapper modelMapper;

    @Override
    public CropDTO createCrop(CropDTO cropDTO) {

        Crop crop = modelMapper.map(cropDTO, Crop.class);
        crop.setStateMachine(StateMachine.SEEDLING);
        crop = cropRepo.save(crop);
        return modelMapper.map(crop, CropDTO.class);
    }
}
