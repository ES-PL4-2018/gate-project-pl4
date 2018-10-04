## Template de Revisão de Código Individual

#### Ref: TST_REVISAO_JOAO

#### # Sprint: 1

#### Data revisão: 03/10/2018

#### Autor: João Oliveira

#### # Páginas: 1

#### Versão: 0.1.1

### Tarefas:

####Tarefa #1: Registo
-Tamanho limitado para os diferentes campos
-Não aceitar números e caracteres especiais no nome, username, instituição e unidades de investigação
-ORCID válido
-Data de nascimento válida
-Obrigatório colocar pelo menos três research unit

####Tarefa #2: Login

-Cancelar o processo de registo a qualquer momento
-Testar log out
-Testar log in
-Ver se é redirecionado para o feed
-Criar conta com username/mail repetido
-Sugerir recuperar palavra-passe caso erre 3 vezes

## Tarefa 1:

### Método de revisão:
Colocar diferentes palavras de modo a testar os vários erros possíveis. Exemplos: 12334, £££, 123€€€, João.
### Defeitos encontrados:
Um mail inválido foi aceite (ex: user12). Datas de nascimento aceita qualquer valor para dia (ex: 32), mês (ex: 20) e ano (ex: 3000). Primeiro e último nome aceita números (ex: 1234).
Instituição aceita caracteres especiais e aceita uma instituição só com números (ex: 123, €//). Unidades de investigação aceita só números (ex. 123456789).
### Sugestão de correção:
Sugestão para correção da data: o formato da data podem ser 3 espaços diferentes mas caso queiram deixar assim devem colocar o formato da data (ex. DD/MM/AAAA)

## Tarefa 2:

### Método de revisão:
Utilização da aplicação para verificar as diferentes tarefas.
### Defeitos encontrados:
A aplicação não tem log out. Depois de efetuado o registo e entrar na conta ao clickar no botão de retroceder do telemóvel volta para o fim do registo (página das research units). No login caso a palavra passe esteja errada não há qualquer aviso de que tal aconteceu, o mesmo para o username. A aplicação está a detetar que o username e o email já estão em uso mas falta algum aviso ou alteração visual.
### Sugestão de correção


## Observações:
-Dizer número máximo e mínimo caracteres nos diferentes campos.
-Nomes com til não estão a ser possíveis utilizar (ex: João).
-Aconteceu um bug quando fiz login a terceira vez em que não apareceu a minha informação mas sim a do TestUser
-Quando não se coloca pass está a dar uma exception in thread.
-Era bom ter um botão para Cancelar o registo e voltar a página inicial em vez de retroceder as 3 vezes
