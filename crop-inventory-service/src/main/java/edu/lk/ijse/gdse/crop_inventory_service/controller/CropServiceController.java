package edu.lk.ijse.gdse.crop_inventory_service.controller;

import edu.lk.ijse.gdse.crop_inventory_service.dto.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crops")
public class CropServiceController {

    @PostMapping()
    public ResponseEntity<APIResponse> registerNewBatch() {
        // write the logic here
        return ResponseEntity.ok(new APIResponse());
    }



}
