Feature: Criar uma nova conta

Scenario: Cadastrar uma nova conta de usuario e validar se o cadastro foi realizado com sucesso

Given Acessada a pagina da loja
And E clicado o botao Sign in
Given Ao preencher um e-mail e clicar no botao de Create an account
And E preencher todos os dados obrigatorios da compra 
Then O site abre a pagina de detalhes da conta