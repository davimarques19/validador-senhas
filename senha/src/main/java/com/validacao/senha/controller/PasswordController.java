package com.validacao.senha.controller;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.exception.PasswordBadRequestException;
import com.validacao.senha.mapper.PasswordMapper;
import com.validacao.senha.service.PasswordService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/v1/validator")
public class PasswordController {

    @Autowired
    PasswordService service;

    @PostMapping
    @ApiOperation(value = "Validador de senhas.")
    public ResponseEntity getPassword(@RequestBody PasswordRequest password) {

        log.info("Inicianco consulta no controller");

        try {
            return ResponseEntity.created(URI.create("/v1/validator/" + password.getInput()))
                    .body(PasswordMapper.toPasswordResponse(service.getPassword(password)));
        } catch (Exception ex) {
            throw new PasswordBadRequestException("Erro");
        }

    }

}
