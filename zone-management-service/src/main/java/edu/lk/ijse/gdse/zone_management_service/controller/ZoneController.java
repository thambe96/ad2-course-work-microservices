package edu.lk.ijse.gdse.zone_management_service.controller;

import edu.lk.ijse.gdse.zone_management_service.dto.ApiResponse;
import edu.lk.ijse.gdse.zone_management_service.dto.RequestZoneDTO;
import edu.lk.ijse.gdse.zone_management_service.dto.ThresholdLimitsDTO;
import edu.lk.ijse.gdse.zone_management_service.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @PostMapping()
    public ResponseEntity<ApiResponse> createZone(
            @RequestBody RequestZoneDTO requestZoneDTO,
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

//        if (authHeader.startsWith("Bearer ")) {
//            authHeader = "Bearer " + authHeader.substring(7);
//        }

        // problem is here:
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            authHeader = authHeader.substring(7); // remove "Bearer "
//        }
        System.out.println("This is Auth header: " + authHeader);

        if (requestZoneDTO.getMinTemp() < requestZoneDTO.getMaxTemp()) {

            return ResponseEntity.ok(

                    new ApiResponse(
                            HttpStatus.OK.value(),
                            "zone and device creation was successfully",
                            zoneService.saveZoneWithDevice(requestZoneDTO, authHeader)
                    )
            );
        }

        return ResponseEntity.badRequest().body(new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                "temperature validation faild",
                null
        ));

    }

    @GetMapping(value = "/get-threshold-limits")
    public ResponseEntity<ThresholdLimitsDTO> getZoneThresholdValues(
            @RequestParam String zoneId, @RequestParam String deviceId) {
        return ResponseEntity.ok(
                zoneService.getZoneThresholdLimits(
                        zoneId,
                        deviceId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getZones(@PathVariable String id) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(),
                "zone details", zoneService.getZone(id)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateZoneThresholds(
            @PathVariable String id,
            @RequestBody ThresholdLimitsDTO thresholdLimitsDTO) {

        thresholdLimitsDTO.setZoneId(id);

        return ResponseEntity.ok(new ApiResponse(
                HttpStatus.OK.value(),
                "update thresholds",
                zoneService.updateGivenZoneThresholds(thresholdLimitsDTO)));
    }







    // implement update tresholds , fetch specific zone details, delete zone


}
