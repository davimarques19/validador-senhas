package com.validacao.senha.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.validacao.senha.controller.representation.PasswordRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class PasswordControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void deveriaRetornar200AoEfetuarRequisicaoComInputValidoTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                .post("/v1/validator")
                .content(asJsonString(new PasswordRequest("AbTp9!fok")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoComCaracterDuplicadoSeguidoTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("AbbTp9!fok")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoComMenosDeNoveCaracteresTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("AbTp9!f")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComLetrasMinusculasTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("Abcdefghi")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComNumerosTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456789")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComNumerosELetrasMinusculasTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456abcd")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComNumerosELetrasMaiusculasTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456ABCD")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComNumerosELetrasMaiusculasEMinusculasTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456ABCd")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoApenasComNumerosELetrasMaiusculasEMinusculasEEspacoTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456 BCd!")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar400AoEfetuarRequisicaoVaziaTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deveriaRetornar500AoEfetuarRequisicaoComBodyNuloTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest(null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}