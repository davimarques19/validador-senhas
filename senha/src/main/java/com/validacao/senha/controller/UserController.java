package com.validacao.senha.controller;

import com.validacao.senha.domain.UserDomain;
import com.validacao.senha.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/user-password")
public class UserController {

    @Autowired
    final UserService service;

    @PostMapping
    public UserDomain saveUser(@RequestBody UserDomain user) {
        log.info("Acessando UserController.saveUser");

        service.saveUser(user);

        return user;
    }
}
