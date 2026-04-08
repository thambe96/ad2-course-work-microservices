package edu.lk.ijse.gdse.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponseDTO {

    private String username;
    private String accessToken;
    private String refreshToken;

}
