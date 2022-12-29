package com.validacao.senha.service;

import com.validacao.senha.domain.UserDomain;
import com.validacao.senha.reposiitory.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserDomain saveUser(UserDomain user) {
        log.info("Acessando UserService.saveUser");
        repository.saveUser(user);
        log.info("Saindo do UserService.saveUser");
        return user;
    }
}
