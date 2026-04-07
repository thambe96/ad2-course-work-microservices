package edu.lk.ijse.gdse.zone_management_service.controller;

import edu.lk.ijse.gdse.zone_management_service.dto.ApiResponse;
import edu.lk.ijse.gdse.zone_management_service.dto.RequestZoneDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/zones")
public class ZoneController {

    @PostMapping()
    public ResponseEntity<ApiResponse> createZone(
            @RequestBody RequestZoneDTO requestZoneDTO,
            @RequestHeader(value = "Authorization", required = false) String authHeader
    )

    {
        if (authHeader.startsWith("Bearer ")) {
            authHeader = "Bearer " + authHeader.substring(7);
        }

        if (requestZoneDTO.getMinTemp() < requestZoneDTO.getMaxTemp()) {

            return ResponseEntity.ok(
                    new ApiResponse(
                            HttpStatus.OK.value(),
                            "zone and device creation was successfully",
                            "replace this with data"));
        }

        return ResponseEntity.badRequest().body(new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                "temperature validation faild",
                null
        ));

    }


}
