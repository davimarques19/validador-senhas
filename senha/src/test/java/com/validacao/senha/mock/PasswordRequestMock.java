package com.validacao.senha.mock;

import com.validacao.senha.controller.representation.PasswordRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

public class PasswordRequestMock {

    public static PasswordRequest toPasswordRequest() {
        PasswordRequest retorno = new PasswordRequest();
        retorno.setInput("AbTp9!fok");
        return retorno;
    }

}
