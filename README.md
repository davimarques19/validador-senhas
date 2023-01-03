# API Validador de senhas

[![MIT](https://img.shields.io/npm/l/react)](https://github.com/davimarques19/validador-senhas/blob/master/LICENSE) 

# Sobre o projeto

O objetivo do projeto **Validador de senhas** é desenvolver uma **API WEB** que ao receber uma string, seja retornado um booleano *true* para senhas validas e *false* para senhas não validas.

Compartilhando sobre minhas experiências neste projeto, para organizar as atividades que teria que desenvolver, utilizei a ferramenta do **Trello ->** [Board Trello - Validador de Senhas](https://trello.com/b/z59kbc6F/validador-de-senhas "Trello - Validador de Senhas"), assim consegui mapear grande parte das atividades que iria desenvolver.
Foram mais de 15 atividades escritas que me auxiliaram no entendimento, desenho de quais ferramentas utilizaria e prazos para cada atividade.

Confesso que "estrapolei" no prazo da atividade do service, foquei em achar uma expressão regular capaz de validar caracteres repetidos na string.
Após analisar diversos links de apoio, consegui montar um regex capaz de cobrir praticamente todos os requisitos da primissa do projeto e com isso fui para o *plano B* que seria montar um for, percorrer os caracteres e fazer uma condição para caracteres presentes mais de uma vez na mesma string.

Outro ponto que Foquei foi no quesito de segurança do dado que seria trafegado, a principio havia montado o metodo como GET, porém estamos falando de um dado sensível e por este motivo optei em alterar o metodo para POST. 
Fiquei em dúvida se retornaria o status code 201 ou 200, fiz diversas refatorações no código com melhorias e por fim, decidi retornar o status code 200, assumindo que essa api pode se tonar uma api transacional onde não precisaremos salvar dados no banco e sim validar se a senha/hash são a mesma string.

Agora que dividi um pouco das minhas experiências no desenvolvimento, vamos para a parte de entendiemento do case, depois seguiremos para preparar o ambiente para executar o teste.

Requisitos da senha:
- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```Java
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Banco em memória H2
- Swagger 
- Maven
- Lombok
## Testes Unitários
- Jnit5
- Mockito
# Como executar o projeto
Pré-requisitos: 
- Java 11
- Maven 3.8.6

```bash
# clonar repositório
git clone git@github.com:davimarques19/validador-senhas.git

# entrar na pasta do projeto validador-senhas
cd validador-senhas/senha

# executar o projeto
./mvnw spring-boot:run

#Abrir o navegador de preferência (ou via postman) e digitar a url:
http://localhost:8080/swagger-ui.html#/
```

## Layout API web via Swagger
![Web 1](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/tela-inicial.PNG)

# Efetuar teste na api
```bash
# clique no botão Try it Out
```
![Web 2](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/teste-1.PNG)

```bash
# Preencha o campo "input" com a senha desejada
```
![Web 3](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/execute.PNG)

```bash
# Preencha o campo "input" com a senha desejada e clique no botão execute
```
![Web 3](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/execute.PNG)

```bash
# Será apresentado o resultado da requisição...
# Retorno verdadeiro:
```
![Web 4](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/true.PNG)

```bash
# Retorno Falso:
```
![Web 5](https://github.com/davimarques19/validador-senhas/blob/develop/senha/src/main/resources/asset/false.PNG)

# Considerações finais.
Este foi um projeto que gostei bastante, isto porque o desafio de encontrar uma solução, uma maneira ou forma diferente de resolver um problema é o que me motivou a sair da "zona de conforto"(trabalhar como analista de suporte - cloud), para alçar voos mais altos no mundo de desenvolvimento.

Um abraço e até o próximo projeto. 

# Autor

Davi Marques Santos

https://www.linkedin.com/in/davi-marques-santos-a13bab94/
