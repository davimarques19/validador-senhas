package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.exception.PasswordRunTimeException;
import com.validacao.senha.model.Password;
import com.validacao.senha.repository.PasswordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PasswordService {

    @Autowired
    PasswordRepository repository;

    @Autowired
    ValidatorService validatorService;

    public Optional<Password> getPassword(PasswordRequest password) {
        log.info("Iniciando consulta UserService.getPassword");

        if (password.getInput() == null) {
            throw new PasswordRunTimeException("Um ou mais requisitos da senha não foram preenchidos, tente novamente.");
        }

        return validatorService.validate(password);

    }

}
