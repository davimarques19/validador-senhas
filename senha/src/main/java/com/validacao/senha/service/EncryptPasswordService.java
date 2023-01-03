package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EncryptPasswordService {

    @Autowired
    PasswordEncoder encoder;

    public EncryptPasswordService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encrypt(PasswordRequest passwordRequest) {
        log.info("Acessando metodo para encriptar EncryptPasswordService.encrypt");

        return encoder.encode(passwordRequest.getInput());
    }

    public Boolean decrypt(Password password, PasswordRequest passwordRequest) {
        return encoder.matches(passwordRequest.getInput(), password.getInput());
    }

}
