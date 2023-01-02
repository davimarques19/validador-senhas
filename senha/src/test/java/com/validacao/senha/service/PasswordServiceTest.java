package com.validacao.senha.service;

import com.validacao.senha.domain.Password;
import com.validacao.senha.mock.PasswordMock;
import com.validacao.senha.mock.PasswordRequestMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@SpringBootTest
class PasswordServiceTest {

    @Mock
    ValidatorPasswordService validatorPasswordService;

    @Test
    void deveriaRetornarSucessoComStatusTrue() {
        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn(PasswordMock.toPasswordValid());

        Password retorno = PasswordMock.toPasswordValid();

        assertEquals("AbTp9!fok", retorno.getInput());
    }

    @Test
    void deveriaRetornarSucessoComStatusFalse() {
        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn(PasswordMock.toPasswordInvalid());

        Boolean retorno = PasswordMock.toPasswordInvalid().getOutput();

        assertFalse(retorno.booleanValue());
    }

}