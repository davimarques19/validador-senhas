package com.validacao.senha.mock;

public class UserDomainMock {

    public InputPassword userMockSuccess() {
        InputPassword user = new InputPassword();
        user.setInput("AbTp9!fok");
        user.setOutput(true);

        return user;
    }
}
