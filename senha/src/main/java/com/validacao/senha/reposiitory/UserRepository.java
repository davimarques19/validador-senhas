package com.validacao.senha.reposiitory;

import com.validacao.senha.domain.UserDomain;

public interface UserRepository {
    UserDomain saveUser(UserDomain user);
}
