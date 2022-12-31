package com.validacao.senha.service;

import com.validacao.senha.controller.representation.PasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncoderPassword {

    @Autowired
    PasswordEncoder encoder;

    public void getPasswordEncoder(PasswordRequest request) {
        request.setInput(encoder.encode(request.getInput()));
    }
}
