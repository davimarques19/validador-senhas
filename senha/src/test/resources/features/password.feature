# language: pt
@TestPassword

Funcionalidade: Propondo senhas

  Cenario: Propondo uma senha valida
    Dado uma senha valida "AbTp9!fok"
    Quando a senha atender todos os requisitos
    Entao é retornado o booleano com status true

  Cenario: Propondo uma senha inválida
    Dado uma senha inválida "AbTp9 fok"
    Quando a senha nao conter um ou mais requisitos e não atender os requisitos
    Entao é retornado um campo boleano com status false

  Cenario: Propondo nulo no campo senha
    Dado que o campo senha veio nulo
    Quando a mesma nao for válida
    Entao é retornado uma excessão de bad request com a mensagem: "  "