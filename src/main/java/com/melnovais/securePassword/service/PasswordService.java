package com.melnovais.securePassword.service;

import com.melnovais.securePassword.dto.ValidationErrorDTO;
import com.melnovais.securePassword.models.Password;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public ResponseEntity<?> validatePassword(Password password) {
        List<String> errors = new ArrayList<>();
        String pwd = password.getPassword();

        // Verifica se a senha tem pelo menos 8 caracteres
        if (pwd.length() < 8) {
            errors.add("A senha deve ter pelo menos 8 caracteres.");
        }

        // Verifica se a senha contém pelo menos uma letra maiúscula
        if (!pwd.matches(".*[A-Z].*")) {
            errors.add("A senha deve conter pelo menos uma letra maiúscula.");
        }

        // Verifica se a senha contém pelo menos uma letra minúscula
        if (!pwd.matches(".*[a-z].*")) {
            errors.add("A senha deve conter pelo menos uma letra minúscula.");
        }

        // Verifica se a senha contém pelo menos um dígito numérico
        if (!pwd.matches(".*[0-9].*")) {
            errors.add("A senha deve conter pelo menos um dígito numérico.");
        }

        // Verifica se a senha contém pelo menos um caractere especial
        if (!pwd.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            errors.add("A senha deve conter pelo menos um caractere especial.");
        }

        // Se houver erros, retornar 400 Bad Request com os erros
        if (!errors.isEmpty()) {
            ValidationErrorDTO errorResponse = new ValidationErrorDTO(errors);
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        // Se não houver erros, retornar 204 No Content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
