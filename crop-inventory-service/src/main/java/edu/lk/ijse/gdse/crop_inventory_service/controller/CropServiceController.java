package edu.lk.ijse.gdse.crop_inventory_service.controller;

import edu.lk.ijse.gdse.crop_inventory_service.dto.APIResponse;
import edu.lk.ijse.gdse.crop_inventory_service.dto.CropDTO;
import edu.lk.ijse.gdse.crop_inventory_service.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
public class CropServiceController {

    private final CropService cropService;

    @PostMapping()
    public ResponseEntity<APIResponse> registerNewBatch(@RequestBody CropDTO cropDTO) {
        return ResponseEntity.ok(new APIResponse(
                HttpStatus.OK.value(),
                "batch created successfully",
                cropService.createCrop(cropDTO)));
    }



}
