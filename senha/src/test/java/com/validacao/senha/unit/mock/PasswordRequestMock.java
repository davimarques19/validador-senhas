package com.validacao.senha.unit.mock;

import com.validacao.senha.controller.representation.PasswordRequest;

public class PasswordRequestMock {

    public static PasswordRequest toPasswordRequest() {
        PasswordRequest retorno = new PasswordRequest();
        retorno.setInput("AbTp9!fok");
        return retorno;
    }

}
