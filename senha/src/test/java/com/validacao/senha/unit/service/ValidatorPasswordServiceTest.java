//package com.validacao.senha.service;
//
//import com.validacao.senha.domain.Password;
//import com.validacao.senha.mock.PasswordMock;
//import com.validacao.senha.mock.PasswordRequestMock;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class ValidatorPasswordServiceTest {
//
//    @InjectMocks
//    ValidatorPasswordService validatorPasswordService;
//
//    @Mock
//    EncryptPasswordService encryptPasswordService;
//
//    @Mock
//    PasswordEncoder encoder;
//
//    @Test
//    void shouldReturnSuccessWithStatusTrue() {
//        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn(PasswordMock.toPasswordInvalid());
//
//        Password retorno = PasswordMock.toPasswordValid();
//
//        assertTrue(retorno.getOutput());
//    }
//
//    @Test
//    void shouldReturnSuccessWithStatusFalse() {
//        when(validatorPasswordService.validate(PasswordRequestMock.toPasswordRequest())).thenReturn("");
//
//        Password retorno = PasswordMock.toPasswordInvalid();
//
//        assertFalse(retorno.getOutput());
//    }
//
//}
