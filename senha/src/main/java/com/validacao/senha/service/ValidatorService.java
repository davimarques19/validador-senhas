package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import com.validacao.senha.exception.PasswordBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidatorService {

    @Autowired
    ValidatorBooleanService validatorBooleanService;

    @Autowired
    PasswordEncoder encoder;

    public Password validate(PasswordRequest passwordRequest) {
        log.info("Iniciando consulta ValidatorService.validate");

        Password retorno = new Password();

        if (validatorBooleanService.validateBoolean(passwordRequest)) {
            retorno.setInput(encoder.encode(passwordRequest.getInput()));
            retorno.setOutput(true);
            return retorno;
        } else {
            retorno.setInput(passwordRequest.getInput());
            retorno.setOutput(false);
            throw new PasswordBadRequestException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }
    }

}
