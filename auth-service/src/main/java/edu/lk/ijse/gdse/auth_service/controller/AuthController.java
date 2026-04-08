package edu.lk.ijse.gdse.auth_service.controller;

import edu.lk.ijse.gdse.auth_service.dto.ApiResponse;
import edu.lk.ijse.gdse.auth_service.dto.AuthRequestDTO;
import edu.lk.ijse.gdse.auth_service.dto.AuthResponseDTO;
import edu.lk.ijse.gdse.auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> regiserUser(@RequestBody AuthRequestDTO authRequestDTO) {
        return ResponseEntity.ok(
                new ApiResponse(HttpStatus.OK.value(),
                        "user registration was successful",
                        userService.registeruser(authRequestDTO)
                )
        );
    }

}
