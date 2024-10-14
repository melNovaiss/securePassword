package com.melnovais.securePassword.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationErrorDTO {
    private List<String> errors;
}
