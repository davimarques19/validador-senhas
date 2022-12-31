package com.validacao.senha.mapper;

import com.validacao.senha.domain.Password;
import com.validacao.senha.domain.PasswordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordMapper {

    public static PasswordResponse toPasswordResponse(Password password) {
        PasswordResponse response = new PasswordResponse();

        response.setPasswordStatus(password.getOutput());

        return response;
    }
}
