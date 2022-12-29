package com.validacao.senha.reposiitory.impl;

import com.validacao.senha.domain.UserDomain;
import com.validacao.senha.reposiitory.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserDomain saveUser(UserDomain user) {
        log.info("Acessando UserRepositoryImpl.saveUser");
        return null;
    }
}
