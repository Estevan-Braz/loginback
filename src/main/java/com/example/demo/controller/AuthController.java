package com.example.demo.controller;

import com.example.demo.model.AuthResponse;
import com.example.demo.model.UserCredentials;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) {
        // Aqui você deve validar o usuário (ex: verificar no banco de dados)
        if ("user".equals(userCredentials.getUsername()) && "password".equals(userCredentials.getPassword())) {
            String token = authService.generateToken(userCredentials.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}

