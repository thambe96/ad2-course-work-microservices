package edu.lk.ijse.gdse.zone_management_service.client;


import edu.lk.ijse.gdse.zone_management_service.dto.IotServerResponse;
import edu.lk.ijse.gdse.zone_management_service.dto.ZoneRegDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "external-iot-server", url = "http://localhost:8087/api/devices/")
public interface IoTServerClient {

    @PostMapping(consumes = "application/json")
    IotServerResponse registerDeviceWithZone(
            @RequestHeader("Authorizaton") String authHeader,
            @RequestBody ZoneRegDTO zoneRegDTO
    );


}
