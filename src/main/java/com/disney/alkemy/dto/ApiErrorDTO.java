package com.disney.alkemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
@AllArgsConstructor
@Data
public class ApiErrorDTO {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
