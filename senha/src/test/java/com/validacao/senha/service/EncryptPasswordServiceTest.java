package com.validacao.senha.service;

import com.validacao.senha.domain.Password;
import com.validacao.senha.mock.PasswordMock;
import com.validacao.senha.mock.PasswordRequestMock;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class EncryptPasswordServiceTest {


    @Autowired
    EncryptPasswordService service;

    @Mock
    PasswordEncoder encoderPassword;

    @Test
    void shouldReturnSuccessWithHashPassword() {
        when(service.encrypt(PasswordRequestMock.toPasswordRequest())).thenReturn(anyString());

        Password retorno = PasswordMock.toPasswordValid();

        assertTrue(retorno.getOutput());
    }

    @Test
    void shouldReturnSuccessWithStatusFalse() {
        when(service.decrypt(PasswordMock.toPasswordValid(), PasswordRequestMock.toPasswordRequest())).thenReturn(anyBoolean());

        Password retorno = PasswordMock.toPasswordValid();

        assertFalse(retorno.getOutput());
    }

}
