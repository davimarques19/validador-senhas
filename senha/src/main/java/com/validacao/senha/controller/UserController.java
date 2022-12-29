package com.validacao.senha.controller;

import com.validacao.senha.domain.UserDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/user-password")
public class UserController {

    @PostMapping
    public UserDomain saveUser(@RequestBody UserDomain user) {
        log.info("Acessando UserController.saveUser");

        return user;
    }
}
