package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.exception.PasswordBadRequestException;
import com.validacao.senha.domain.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ValidatorService {

    @Autowired
    ValidatorBooleanService validatorBooleanService;

    public Password validate(PasswordRequest passwordRequest) {
        log.info("Iniciando consulta ValidatorService.validate");

        Password retorno = new Password();

        if (validatorBooleanService.validateBoolean(passwordRequest)) {
            retorno.setInput(passwordRequest.getInput());
            retorno.setOutput(true);
            return retorno;
        } else {
            retorno.setInput(passwordRequest.getInput());
            retorno.setOutput(false);
            throw new PasswordBadRequestException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }
    }

}
