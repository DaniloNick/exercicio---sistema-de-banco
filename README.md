# Exercício de sistema bancário

Esta aplicação Java tem como objetivo simular um sistema de banco, onde o usuário poderá acessar, fazer depósitos, saques e transferência como uma aplicação convencional.

## Como Utilizar

Ao executar a aplicação, o usuário será solicitado a informar o CPF. Após informar o dado, a aplicação irá consultar na lista de usuários se o CPF informado esta cadastrado, estando, o usuário recebera uma mensagem de bem vindo e poderá prosseguir com as demais funções disponíveis no programa.


## Funcionamento

A aplicação utiliza um List de clientes, os quais tem uma classe "conta" associada a cada cliente, atraves do uso de stream, e possível comparar e filtrar os CPFs na lista de clientes, assim, invocando as operações de deposito, saque e transferência.

Na operação de transferência, e utilizado um stream para buscar o destinatário, usando o CPF como comparador, sendo possível acessar a referencia da conta e transferir saldo do cliente logado para o destinatário, tendo em vista que uma mensagem exibindo o titular do CPF, seguido de uma pergunta para confirmar se o destinatário esta correto, ira evitar que transferências acidentais sejam executadas.

## Dependências

Não há dependências externas para a execução desta aplicação.

## Desenvolvedor
***Danilo Nascimento de Andrade***
