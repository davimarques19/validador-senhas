package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import com.validacao.senha.exception.PasswordBadRequestException;
import com.validacao.senha.repository.PasswordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordService {

    private final PasswordRepository repository;
    private final ValidatorPasswordService validatorPasswordService;

    public PasswordService(PasswordRepository repository, ValidatorPasswordService validatorPasswordService) {
        this.repository = repository;
        this.validatorPasswordService = validatorPasswordService;
    }

    public Password validatePassword(PasswordRequest password) {
        log.info("Iniciando consulta UserService.validatePassword");

        if (password.getInput() == null) {
            throw new PasswordBadRequestException("Erro");
        }

        return repository.save(validatorPasswordService.validate(password));

    }

}
