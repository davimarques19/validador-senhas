package com.validacao.senha.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiErrorMessage {

    private final HttpStatus status;
    private final List<String> errors;

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }

}
