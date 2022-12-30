package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.exception.PasswordBadRequestException;
import com.validacao.senha.model.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ValidatorService {

    @Autowired
    ValidatorBooleanService validatorBooleanService;

    public Optional<Password> validate(PasswordRequest passwordRequest) {
        log.info("Iniciando consulta ValidatorService.validate");

        Optional<Password> retorno = Optional.of(new Password());

        if (validatorBooleanService.validateBoolean(passwordRequest)) {
            retorno.get().setInput(passwordRequest.getInput());
            retorno.get().setOutput(true);
            return retorno;
        } else {
            retorno.get().setInput(passwordRequest.getInput());
            retorno.get().setOutput(false);
            throw new PasswordBadRequestException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }
    }

}
