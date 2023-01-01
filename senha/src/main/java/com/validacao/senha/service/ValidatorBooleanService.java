package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidatorBooleanService {

    final String REGEX_VALIDATOR = "^(?=.*\\S)(?=.*\\d)(?=.*[!@#$%^&*()-+])(?:([0-9a-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";


    public Boolean validateBoolean(PasswordRequest request) {
        log.info("Iniciando acesso a classe ValidatorService.validateBoolean");

        if (request.getInput().matches(REGEX_VALIDATOR)) {
            log.info("Finalizando consulta ValidatorBooleanService.validateBoolean -> true");

            return true;
        } else {
            log.info("Finalizando consulta ValidatorBooleanService.validateBoolean -> false");

            return false;
        }
    }

}
