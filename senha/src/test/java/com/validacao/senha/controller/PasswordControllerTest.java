package com.validacao.senha.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.validacao.senha.controller.representation.PasswordRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PasswordControllerTest {

    @Autowired
    private MockMvc mock;

    @Test
    public void shouldReturn201WithValidInputTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("AbTp9!fok")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturn400WithDoubleCharacterEqualsTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("AbbTp9!fok")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithoutMinCharactersTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("AbTp9!f")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400JustWithLowerCaseTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("abcdefghi")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400JustWithNumbersTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456789")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithNumbersAndLowerCaseTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456abcd")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithouUpperCaseAndSpecialCharacterTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456abcd")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithNumbersAndUpperCaseTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456ABCD")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithNumbersLowerCaseAndUpperCaseTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456ABCd")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithNumberAndUpperCaseAndLowerCaseAndEmptyTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("123456 BCd!")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithEmptyCaseTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest("")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturn400WithBodyNullTest() throws Exception {

        mock.perform(MockMvcRequestBuilders
                        .post("/v1/validator")
                        .content(asJsonString(new PasswordRequest(null)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}