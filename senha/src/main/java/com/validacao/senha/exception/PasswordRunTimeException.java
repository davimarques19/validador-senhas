package com.validacao.senha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class PasswordRunTimeException extends RuntimeException {

    public PasswordRunTimeException(String msg) {
        super(String.format("Erro interno, entre em contato com o administrador do sistema", msg));
    }
}
