package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import com.validacao.senha.exception.PasswordBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ValidatorPasswordService {

    final String REGEX_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+])(?:([0-9a-zA-Z!@#$%^&*()-+])(?!\\1)){9,}$";

    @Autowired
    PasswordEncoder encoder;

    public Password validate(PasswordRequest passwordRequest) {
        log.info("Iniciando consulta ValidatorService.validate");

        Password retorno = new Password();

        validateCharacterDuplicate(passwordRequest);

        if (passwordRequest.getInput().matches(REGEX_VALIDATOR)) {
            retorno.setInput(encoder.encode(passwordRequest.getInput()));
            retorno.setOutput(true);
            return retorno;
        } else {
            retorno.setInput(passwordRequest.getInput());
            retorno.setOutput(false);
            throw new PasswordBadRequestException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }
    }

    private void validateCharacterDuplicate(PasswordRequest request) {
        log.info("Iniciando consulta ValidatorService.validatePasswordCharDuplicate");

        request.getInput().chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> {
                    if (value > 1) {
                        request.setInput(" ");
                    }
                });
    }
}
