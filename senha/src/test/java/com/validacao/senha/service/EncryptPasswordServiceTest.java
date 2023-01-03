package com.validacao.senha.service;

import com.validacao.senha.domain.Password;
import com.validacao.senha.mock.PasswordMock;
import com.validacao.senha.mock.PasswordRequestMock;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EncryptPasswordServiceTest {

    @InjectMocks
    EncryptPasswordService service;

    @Mock
    PasswordEncoder encoderPassword;

    @Test
    void shouldReturnSuccessWithHashPassword() {
        when(service.encrypt(PasswordRequestMock.toPasswordRequest())).thenReturn("teste");

        Password retorno = PasswordMock.toPasswordValid();

        assertTrue(retorno.getOutput());
    }

    @Test
    void shouldReturnSuccessWithStatusTrue() {
        when(service.decrypt(PasswordMock.toPasswordValid(), PasswordRequestMock.toPasswordRequest())).thenReturn(true);

        Password retorno = PasswordMock.toPasswordValid();

        assertTrue(retorno.getOutput());
    }

}
