package edu.lk.ijse.gdse.auth_service.service;

import edu.lk.ijse.gdse.auth_service.dto.AuthRequestDTO;
import edu.lk.ijse.gdse.auth_service.dto.AuthResponseDTO;

public interface UserService {

    AuthResponseDTO registeruser(AuthRequestDTO authRequestDTO);
    AuthResponseDTO login(AuthRequestDTO authRequestDTO);

}
