package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.UserCredentials;
import com.example.demo.service.AuthService;
@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) {
        // Aqui você deve validar o usuário (ex: verificar no banco de dados)
        if ("user".equals(userCredentials.getUsername()) && "password".equals(userCredentials.getPassword())) {
            Long userId = 1L;
            String userType = "1";
            String token = authService.generateToken(userCredentials.getUsername(), userId, userType);
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}

