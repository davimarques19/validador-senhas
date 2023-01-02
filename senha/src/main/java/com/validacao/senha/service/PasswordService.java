package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import com.validacao.senha.repository.PasswordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordService {

    @Autowired
    PasswordRepository repository;

    @Autowired
    ValidatorPasswordService validatorPasswordService;

    public Password getPassword(PasswordRequest password) {
        log.info("Iniciando consulta UserService.getPassword");

        return repository.save(validatorPasswordService.validate(password));

    }

}
