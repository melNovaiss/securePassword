package com.melnovais.securePassword.controllers;

import com.melnovais.securePassword.models.Password;
import com.melnovais.securePassword.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping
    public ResponseEntity<?> validatePassword(@RequestBody Password password) {
        return passwordService.validatePassword(password);
    }
}
