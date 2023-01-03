package com.validacao.senha.unit.mock;

import com.validacao.senha.domain.Password;

public class PasswordMock {

    public static Password toPasswordValid() {
        Password retorno = new Password();

        retorno.setInput("AbTp9!fok");
        retorno.setOutput(true);

        return retorno;
    }

    public static Password toPasswordInvalid() {
        Password retorno = new Password();

        retorno.setInput("AbTp9 fok");
        retorno.setOutput(false);

        return retorno;
    }

}
