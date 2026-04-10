package edu.lk.ijse.gdse.crop_inventory_service.service.impl;

import edu.lk.ijse.gdse.crop_inventory_service.dto.CropDTO;
import edu.lk.ijse.gdse.crop_inventory_service.entity.Crop;
import edu.lk.ijse.gdse.crop_inventory_service.entity.StateMachine;
import edu.lk.ijse.gdse.crop_inventory_service.repository.CropRepo;
import edu.lk.ijse.gdse.crop_inventory_service.service.CropService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public CropDTO updateStatus(String id,  CropDTO cropDTO) {
        Optional<Crop> crop = cropRepo.findById(id);

        if (crop.isPresent()) {
            Crop cropEntity = crop.get();

            if (cropDTO.getStateMachine() == StateMachine.VEGETATIVE) {
                cropEntity.setStateMachine(StateMachine.VEGETATIVE);
                return modelMapper.map(cropRepo.save(cropEntity), CropDTO.class) ;
            } else if (cropDTO.getStateMachine() == StateMachine.HARVESTED) {
                cropEntity.setStateMachine(StateMachine.HARVESTED);
                return modelMapper.map(cropRepo.save(cropEntity), CropDTO.class);
            }

        }

        return null;

    }

    public List<CropDTO> getAllCrops() {
        List<Crop> crops = cropRepo.findAll();
        List<CropDTO> cropDTOS = new ArrayList<>();
        for (Crop crop : crops) {
            cropDTOS.add(modelMapper.map(crop, CropDTO.class));
        }
        return cropDTOS;
    }


}
