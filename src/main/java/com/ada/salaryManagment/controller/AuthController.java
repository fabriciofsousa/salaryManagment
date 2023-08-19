package com.ada.salaryManagment.controller;

import com.ada.salaryManagment.dto.security.AuthRequestDTO;
import com.ada.salaryManagment.dto.security.AuthResponseDTO;
import com.ada.salaryManagment.service.security.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody @Valid AuthRequestDTO request) {
       return ResponseEntity.ok(authService.authenticate(request));
    }
}
