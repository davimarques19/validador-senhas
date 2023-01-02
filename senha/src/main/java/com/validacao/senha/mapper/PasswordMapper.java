package com.validacao.senha.mapper;

import com.validacao.senha.domain.Password;
import com.validacao.senha.domain.PasswordResponse;

public class PasswordMapper {

    public static PasswordResponse toPasswordResponse(Password password) {
        PasswordResponse response = new PasswordResponse();
        response.setPasswordStatus(password.getOutput());
        return response;
    }
}
