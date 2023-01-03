package com.validacao.senha.service;

import com.validacao.senha.domain.Password;
import com.validacao.senha.mock.PasswordMock;
import com.validacao.senha.mock.PasswordRequestMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ValidatorPasswordServiceTest {


    @Autowired
    ValidatorPasswordService validatorPasswordService;

    @Mock
    EncryptPasswordService encryptPasswordService;

    @Test
    void shouldReturnSuccessWithStatusTrue() {
        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn(any(Password.class));

        Password retorno = PasswordMock.toPasswordValid();

        assertEquals("AbTp9!fok", retorno.getInput());
        assertTrue(retorno.getOutput());
    }

    @Test
    void shouldReturnSuccessWithStatusFalse() {
        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn(PasswordMock.toPasswordInvalid());

        Password retorno = PasswordMock.toPasswordValid();

        assertEquals("AbTp9 fok", retorno.getInput());
        assertFalse(retorno.getOutput());
    }

}
