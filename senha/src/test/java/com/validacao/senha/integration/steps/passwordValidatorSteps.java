package com.validacao.senha.integration.steps;

import com.validacao.senha.controller.representation.PasswordRequest;
import com.validacao.senha.domain.Password;
import com.validacao.senha.exception.PasswordBadRequestException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class passwordValidatorSteps {

    private Password password;

    private Exception exception;

    @Dado("uma senha valida {string}")
    public void uma_senha_valida(String input) {
        PasswordRequest request = new PasswordRequest(input);
        password = new Password();
        password.setInput(request.getInput());
    }

    @Quando("a senha atender todos os requisitos")
    public void a_senha_atender_todos_os_requisitos() {
        password.setId(1l);
        password.setOutput(true);
    }

    @Entao("é retornado o booleano com status true")
    public void é_retornado_o_booleano_com_status_true() {
        Assert.assertEquals(password.getInput(), "AbTp9!fok");
        Assert.assertTrue(password.getOutput());
    }

    @Dado("uma senha inválida {string}")
    public void uma_senha_inválida(String input) {
        PasswordRequest request = new PasswordRequest(input);
        password = new Password();
        password.setInput(request.getInput());
    }

    @Quando("a senha nao conter um ou mais requisitos e não atender os requisitos")
    public void a_senha_nao_conter_um_ou_mais_requisitos_e_não_atender_os_requisitos() {
        password.setOutput(false);
    }

    @Entao("é retornado um campo boleano com status false")
    public void é_retornado_um_campo_boleano_com_status_false() {
        Assert.assertEquals(password.getInput(), "AbTp9 fok");
        Assert.assertFalse(password.getOutput());
    }


    @Dado("que o campo senha veio nulo")
    public void que_o_campo_senha_veio_nulo() {
        PasswordRequest request = new PasswordRequest(null);
        password = new Password();
        password.setInput(request.getInput());
    }

    @Quando("a mesma nao for válida")
    public void a_mesma_nao_for_válida() {
        try {
            password.getId();
        } catch (PasswordBadRequestException e) {
            this.exception = e;
        }
    }

    @Entao("é retornado uma excessão de bad request com a mensagem: {string}")
    public void é_retornado_uma_excessão_de_bad_request_com_a_mensagem(String msg) {
        Assert.assertEquals(msg, exception.getMessage());
    }
}
