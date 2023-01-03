package com.validacao.senha.service;

import com.validacao.senha.domain.Password;
import com.validacao.senha.mock.PasswordMock;
import com.validacao.senha.mock.PasswordRequestMock;
import com.validacao.senha.repository.PasswordRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PasswordServiceTest {
    @InjectMocks
    PasswordService passwordService;

    @Mock
    ValidatorPasswordService validatorPasswordService;

    @Mock
    EncryptPasswordService encryptPasswordService;

    @Mock
    PasswordRepository repository;

    @Test
    void deveriaRetornarSucessoComStatusTrue() {
        when(passwordService.validatePassword(PasswordRequestMock.toPasswordRequest())).thenReturn(any(Password.class));

        Password retorno = PasswordMock.toPasswordValid();

        assertEquals("AbTp9!fok", retorno.getInput());
        assertTrue(retorno.getOutput());
    }

    @Test
    void deveriaRetornarSucessoComStatusFalse() {
        when(passwordService.validatePassword(PasswordRequestMock.toPasswordRequest())).thenReturn(PasswordMock.toPasswordInvalid());

        Boolean retorno = PasswordMock.toPasswordInvalid().getOutput();

        assertFalse(retorno.booleanValue());
    }

}