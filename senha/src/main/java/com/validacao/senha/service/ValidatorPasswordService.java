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
public class ValidatorPasswordService {

    final String REGEX_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?:([0-9a-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";

    @Autowired
    PasswordEncoder encoder;

    public Password validate(PasswordRequest passwordRequest) {
        log.info("Iniciando consulta ValidatorService.validate");

        Password retorno = new Password();

        if (validateBoolean(passwordRequest)) {
            retorno.setInput(encoder.encode(passwordRequest.getInput()));
            retorno.setOutput(true);
            return retorno;
        } else {
            retorno.setInput(passwordRequest.getInput());
            retorno.setOutput(false);
            throw new PasswordBadRequestException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }
    }

    private Boolean validateBoolean(PasswordRequest request) {
        log.info("Iniciando acesso a classe ValidatorService.validateBoolean");

        if (request.getInput().matches(REGEX_VALIDATOR)) {
            log.info("Setando -> true ValidatorService.validateBoolean");
            return true;
        } else {
            log.info("Setando -> false ValidatorService.validateBoolean");
            return false;
        }
    }


}
