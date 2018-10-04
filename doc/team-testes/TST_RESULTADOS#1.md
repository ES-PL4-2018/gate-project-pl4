## Template de Resultados de Testes #1
#### Ref: TST_RESULTADOS_#1

#### # Sprint: 1

#### Autor: Jessica Cunha

#### # Páginas: 1

#### Data: 04/10
#### Versão: 0.1.1

# Nota

[Revisão de Tarefas](#revisão-de-tarefas)

[Tabela de distribuição de tarefas](#tabela-de-distribuição-de-tarefas)

[Notas/Extras](#notas/extras)

[Conclusão](#conclusão) 

### Objetivo:
O seguinte documento será redigido pós todos os elementos terem completado as tarefas/testes, e será a junção de todos os dados obtidos através dos relatórios individuais (TST_REVISAO_NOME.md).

### Revisions

Rev # | Author | Description | Date
--- | --- | --- | ---
rev | author | things donne on revision | when


### Testes
**Tarefa #1**: Registo

 - Não aceitar números nos nomes de registo
 - ORCID válido
 - Data de nascimento válida
 - Palavra-passe limitada
 - Mail válido
 - username sem carateres estranhos
 - Obrigatório colocar pelo menos uma Research Unit

**Tarefa #2**: Login

 - Cancelar o processo de registo a qualquer momento
 - Testar log out
 - Testar log in
 - Ver se é redirecionado para o feed
 - Criar conta com username/mail repetido
 - Sugerir recuperar palvra-passe caso erre 3 vezes

**Tarefa #3:**

- Sugestão de temas de interesse, no registo
- Selecionar mais temas de interesse no uso da app
- Selecionar obrigatoriamente, no minimo, 3 temas
- Liberdade de escrever temas novos: testar se aceita numeros
- Feed de acordo com as preferencas escolhidas
- Botão "?" com informações, a funcionar em todas as pags

**Tarefa #4:**

- Publicar algo no feed, dar log out, dar log in e verificar se ainda lá está
- Post presentar foto, nome e conteudo
- Aceder ao perfil atraves do feed
- Alterar info do perfil
- Ao mudar interesses, ver se muda o feed
- ver perfil de outros users
- confirmar a info do perfil: nome, research unit, instituiçao, temas interesse, foto

**Tarefa #5:**

- Estando no feed, retroceder para o feed
- Abrir todas as páginas e ver se demora mais do que 3 segundos
- Testar a aba lateral, abrir todas as págs, retroceder
- Swipe para a direita para abrir a aba lateral (não está nos requisitos, mas está nos mockups dos requisitos)

### Tabela de distribuição de tarefas

|           | Jessica C. | Ricardo P. | Pedro Sá | João O. | Catarina M. |
| :-------: | :--------: | :--------: | :------: | :-----: | :---------: |
| Tarefa #1 |            |     X      |          |    X     |            |
| Tarefa #2 |            |            |          |    X    |      X      |
| Tarefa #3 |     X      |            |          |         |      X     |
| Tarefa #4 |     X      |            |    X     |         |             |
| Tarefa #5 |            |     X      |    X     |         |             |

### Revisão de Tarefas

| Tarefa # | Autor | Apontamentos                                                 | Data  |
| :------: | :---- | ------------------------------------------------------------ | :---: |
|    1     | JO    |  | 03/10 |
|    1     | RP    | Durante o registo, a aplicação ou deixa de funcionar ( stopped) ou volta para a página inicial. <br />Quando conseguimos preencher todos os dados da primeira página e queremos passar para a página seguinte, a aplicação deixa de responder.<br />Aceita emails inválidos.<br />No geral a aplicação fecha sozinha sem razão aparente. | 03/10 |
|    2     | CM    | Não há botão log-out<br />Não sugere palavra-passe caso erre 3x<br />Não sugere que o username não existe o que faz com que não aconteça nada quando se carrega no botão "continue"<br />Aceita e-mails repetidos | 03/10 |
|    2     | JO    |                                                              | 03/10 |
|    3     | JC    | Não é possível adicionar mais temas de interesse, apenas editar os existentes, substituindo-os por uma string, não adicionando independentemente.<br />Feed está fixo, não está de acordo com preferencias.<br />Não é possível publicar no feed<br />Botões "?" sem funcionar | 03/10 |
|    3     | CM    |  Botão "?" só funciona na página inicial do login             |  03/10 |
|    4     | JC    | Não é possível publicar no feed, nem alterar foto<br />Não é possivel alterar o nome no perfil<br />Não é possivel ver perfil de outros utilizadores<br />Às vezes ao ver o perfil pessoal, o utilizador é um default: "Zé"<br />Botões "?" sem funcionar<br /> | 03/10 |
|    4     | PS    | Não existência de um butao "logout";<br />Não comprovação da gravação de dados tendo apenas conseguido executar uma vez.<br />Aceder ao perfil é possivel mas não foi possivel mudar os interesses nem ver o perfil dos outros utilizadores.<br />A foto de perfil está predefinida e os restantes campos estao corretos de acordo com os dados inicialmente introduzidos. | 03/10 |
|    5     | RP    | A aba lateral não existe no momento                          | 03/10 |
|    5     | PS    | Não tive sucesso na abertura das páginas<br />Aba lateral nao aparece. |       |




### Notas/Extras

Tarefa #1: Foi notado que o problema do botão de log in foi na linha #235, class "Java" [colocar link do commit]

PS: A aplicação apenas funcionou na primeira vez que testei, quando a fechei nao consegui sair da primeira página do registo. Após varias tentativas de reset do servidor e instalação do apk nao consegui com que fosse possivel passar do log in, daí ter avaliações inconclusivas. Os defeitos encontrados sao referentes a quando a primeira utilização visto que, acreditando que a nao capacidade de utilização da aplição seja um problema basico a resolver.

PS: Uma melhor explicação do metodo de utilizacão da aplicação no sentido de promover uma melhor avaliação por parte da equipa de testes, no sentido em que seja mais prático o processo de teste e aproveitador.

A minha visão e avaliação da aplicação fica comprometida pela utilização breve da mesma.
RP: Muita dificuldade em ligar o smarphone ao servidor; Falta de warnings; Muitos bugs por corrigir; Dificuldade em completar o registo;

CM: Díficil testar a aplicação quando não há warnings, não se percebe se o programa não deixa avançar ou se o botão do telemóvel não funciona.

## Conclusão

Foi decidido não lançar a aplicação dentro da data estabelecida, pois não cumpre uma quantidade significativa de requisitos, o que faz com que a utilização da aplicação por parte do utilizador ainda não seja possível, uma vez que pode levar a frustação o seu uso. Decisão unânime da equipa de testes.
As funcionalidades mais importantes que ainda não funcionavam, que impedem o uso minimamente fluente da aplicação são (Prioridade alta pela parte dos requisitos):

- (10) No registo o utilizador insere um mail válido
  - **Erro:** O utilizador podia colocar qualquer tipo de mail
- (13) Se os dados de login estiverem corretos, o utilizador é redirecionado para o feed de notícias
  - **Erro:** O utilizador tinha de retroceder até ao ecrã principal para fazer login
- (16) O feed de notícias tem de estar de acordo com as preferências do utilizador
  - **Erro:** O feed de notícias não estava por preferências
- (24) O utilizador pode publicar uma notícia no feed
  - **Erro:**  Não era possível publicar no feed

Funcionalidades de prioridade média que não funcionavam:

- (2) No ato de registo, verificar que o ORCID inserido é válido
  - **Erro:** Ainda não conectado com a API a verificar se é valido, no entanto aceitava 16 digitos
- (3) O utilizador deve introduzir a sua data de nascimento no registo
  - **Erro:** Data nascimento sem restrições
- (6) No registo devem ser sugeridos temas de interesse populares ao utilizador
  - **Erro:** Para já apenas temas de interesse sugeridos
- (14) Após o registo, o utilizador é redirecionado para o feed.
  - **Erro:** Não acontece
- (19) Clicar no avatar revela aba lateral com várias opções de navegação pela app
  - **Erro:** Clicar no avatar redireciona para o perfil
  - **Erro:** Ainda não há menu com opções de navegação
- (21) O utilizador pode aceder ao perfil de outro utilizador
  - **Erro:** Não é possível
