package com.validacao.senha.controller;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.model.Password;
import com.validacao.senha.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/validator")
public class PasswordController {

    @Autowired
    final PasswordService service;

    @PostMapping
    @ApiOperation(value = "Validador de senhas.")
    public ResponseEntity getPassword(@RequestBody PasswordRequest password) {
        log.info("Inicianco consulta no controller");

        Optional<Password> retorno = service.getPassword(password);

        return retorno != null ?
                ResponseEntity.ok(retorno) :
                ResponseEntity.badRequest().build();
    }

}
