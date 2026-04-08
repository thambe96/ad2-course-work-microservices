package edu.lk.ijse.gdse.auth_service.service.impl;

import edu.lk.ijse.gdse.auth_service.client.IoTUserLoginClient;
import edu.lk.ijse.gdse.auth_service.client.IoTUserRegClient;
import edu.lk.ijse.gdse.auth_service.dto.AuthRequestDTO;
import edu.lk.ijse.gdse.auth_service.dto.AuthResponseDTO;
import edu.lk.ijse.gdse.auth_service.entity.User;
import edu.lk.ijse.gdse.auth_service.repository.UserRepo;
import edu.lk.ijse.gdse.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
//    private final ModelMapper modelMapper;
    private final IoTUserRegClient ioTUserRegClient;
    private final IoTUserLoginClient ioTUserLoginClient;

    @Override
    public AuthResponseDTO registeruser(AuthRequestDTO authRequestDTO) {

        AuthResponseDTO authResponseDTO = ioTUserRegClient.registerUser(authRequestDTO);

        User user = new User();
        user.setUsername(authRequestDTO.getUsername());
        user.setPassword(authRequestDTO.getPassword()); // use Bcrypt

        userRepo.save(user);

        return authResponseDTO;
    }

    @Override
    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {
        return ioTUserLoginClient.login(authRequestDTO);
    }
}
