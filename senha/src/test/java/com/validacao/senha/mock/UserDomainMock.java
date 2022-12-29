package com.validacao.senha.mock;

import com.validacao.senha.domain.UserDomain;

public class UserDomainMock {

    public UserDomain userMockSuccess() {
        UserDomain user = new UserDomain();
        user.setInput("AbTp9!fok");
        user.setOutput(true);

        return user;
    }
}
