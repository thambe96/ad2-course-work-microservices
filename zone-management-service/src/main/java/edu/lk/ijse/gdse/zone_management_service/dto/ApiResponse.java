package edu.lk.ijse.gdse.zone_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private int status;
    private String message;
    private Object data;
}
