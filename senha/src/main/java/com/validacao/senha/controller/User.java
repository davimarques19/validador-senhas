package com.validacao.senha.controller;

import com.validacao.senha.domain.UserDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user-password")
public class User {

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDomain user) {
        return null;
    }
}
