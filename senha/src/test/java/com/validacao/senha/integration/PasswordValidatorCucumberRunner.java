package com.validacao.senha.integration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) 
@CucumberOptions(features = "classpath:features", tags = "@TestPassword")
public class PasswordValidatorCucumberRunner {

}
