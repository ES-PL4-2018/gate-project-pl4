## Resultados de Testes Sprint #4 - WeSearchers

#### DOC ID: TST_REVISAO_SPRINT#4_WeSearchers

#### # Sprint: 4

#### Data: 12/12/2018

#### Versão: 0.4

### Edição

| Rev # | Autor           | Descrição                         | Data  |
| ----- | --------------- | --------------------------------- | ----- |
| 0.1.0 | Pedro Sá        | Escrita dos testes no doc         | 5/12  |
| 0.1.1 | Catarina Mestre | Escrita dos testes no doc         | 5/12  |
| 0.1.2 | Ricardo Paiva   | Escrita dos testes no doc         | 8/12  |
| 0.2.0 | Ricardo Paiva   | Atualização dos testes realizados | 9/12  |
| 0.2.1 | Catarina Mestre | Atualização dos testes realizados | 9/12  |
| 0.2.2 | Pedro Sá        | Atualização dos testes realizados | 9/12  |
| 0.3   | Ricardo Paiva   | Alteração de inconformidades      | 11/12 |
| 0.4   | Pedro Sá        | Redação da conclusão              | 11/12 |

### Responsáveis

| Nome            | Curso | Cargo          |
| --------------- | ----- | -------------- |
| Pedro Sá        | LEI   | Coordenador    |
| Jessica Cunha   | LEI   | Co-coordenador |
| Catarina Mestre | LEI   | Colaborador    |
| João Oliveira   | LEI   | Colaborador    |
| João Silva      | LEI   | Colaborador    |
| Ricardo Paiva   | LEI   | Colaborador    |



### Descrição dos testes - WeSearchers

| Requisito #   | Testes Realizados                                            | Elemento |
| ------------- | ------------------------------------------------------------ | -------- |
| Req 1.1       | Pré-condições: Página de Perfil. <br />Teste: Testar o botão. <br />Resultado esperado: Possibilidade de reescrever os about, network,  publications e projects. | CM, RP   |
| Req 1.2       | Pré-condições: Possibilidade de reescrever dados.  <br />Teste: Alterar dados.  <br />Resultado esperado: Reescrever dados apenas. | PS, RP   |
| Req 1.3       | Pré-condições:  Salvar edições.  Teste: Quebrar restrições de dados.  Resultado esperado: Não permitir edição dos dados. | CM, PS   |
| Req 1.4       | Pré-condições: Possibilidade de reescrever dados. Teste: Testar salvar.  Resultado esperado: Dados foram alterados. | RP, CM   |
| Req 1.3(1)    | Pré-condições: Página de perfil.   Teste: Colocar ORCID.   Resultado esperado: Dados relativos À pessoa preenchidos  automaticamente. | PS, RP   |
| Req 1.5       | Pré-condições: Página de perfil de outro user.    Teste: Testar botão.  Resultado esperado: Não aparecer botão. | CM, PS   |
| Req 1.6       | Pré-condições: Não ter orientador.   Teste: Testar secção.   Resultado esperado: Não aparecer secção. | PS, RP   |
| Req 1.8(1)    | Pré-condições: Página de perfil.   Teste: Testar entrar na secção followers e following.  Resultado esperado: Aparecer a secção followers e following. | CM, PS   |
| Req 1.8(2)    | Pré-condições: Secção followers e following.   Teste: Testar entrar na sub secção para followers e para following. Resultado esperado: Aparecer a sub secção para followers e following. | RP, CM   |
| Req 1.9       | Pré-condições: Secção followers e following.   Teste: Pesquisar na sub secção para followers e para Resultado esperado: Poder pesquisar e aparecer resultados. | PS, RP   |
| Req 1.10      | Pré-condições: Página de perfil.    Teste: Testar botão + ( secções de publicações e projetos).  Resultado esperado: Página para criar publicação ou projeto. | CM, PS   |
| Req 1.11      | Pré-condições: Página de perfil.    Teste: Testar card.  Resultado esperado: Ver publicação ou projeto. | CM, RP   |
| Req 1.12      | Pré-condições: Entrar card Project.   Teste: Verificar se tem título e descrição.    Resultado esperado: Ter título e descrição. | CM, PS   |
| Req 1.13      | Pré-condições: Entrar card Publication.    Teste: Verificar se tem título, data, tipo de artigo e colaboradores.   Resultado esperado: Ter título, data, tipo de artigo e colaboradores. | RP, CM   |
| Req 1.14      | Pré-condições: Card project/publication.    Teste: Verificar quantidades.   Resultado esperado: Aparecer número de posts e publicações. | PS, RP   |
| Req 2.1       | Pré-condições: Logged in, estar no feed.    Teste: Testar upvote e downvote de um post.    Resultado esperado: Aparecer número de posts e publicações. | CM, PS   |
| Req 2.3       | Pré-condições: Logged in, estar no feed.    Teste: Testar comentar o post.    Resultado esperado: Comentário aparecer no post. | CM, RP   |
| Req 2.4       | Pré-condições: Logged in, estar no feed.    Teste: Testar selecionar o botão comentar.    Resultado esperado: São apresentados os vários comentários desse post. | RP, PS   |
| Req 2.5       | Pré-condições: Logged in, estar no feed.    Teste: Testar botão “see more” de um post.  Resultado esperado: Abre um novo separador com link associado. | RP, CM   |
| Req 2.5(1)    | Pré-condições: Logged in, estar no feed.    Teste: Testar carregar na imagem de um post.   Resultado esperado: Abre um novo separador com link associado. | PS, CM   |
| Req 2.6       | Pré-condições: Logged in, estar no feed.    Teste: Testar post com mais votos, introduzir vários upvotes num post.   Resultado esperado: Post aparece no feed, estando colocado no topo. | CM, PS   |
| Req 2.7       | Pré-condições: Logged in, estar no feed.    Teste: Testar criar um post, introduzindo dados em todos os campos.  Resultado esperado: Post aparece no feed de notícias. | CM, RP   |
| Req 2.12      | Pré-condições: Logged in, estar no feed.    Teste: Testar criar um post, introduzindo dados em todos os campos.   Resultado esperado: Post aparece no feed de notícias. | CM, PS   |
| Req 3 (1)     | Pré-condições: Verificar mail.    Teste: Testa ativação de conta.    Resultado esperado: Conta ativada/ Botão para efetuar login. | RP, CM   |
| Req 3 (2)     | Pré-condições: Página de Account criada.    Teste: Testar botão de retroceder.   Resultado esperado: Abre a página de login. | PS, RP   |
| Req 3 (3)     | Pré-condições: Entrar na página Sign Up.    Teste: Testar com credenciais válidas e foto selecionada.  Resultado esperado:  Abre página de confirmação de email e é recebido | CM, RP   |
| Req 3.1       | Pré-condições: Entrar na página Sign Up.    Teste: Testar com credenciais válidas, foto selecionada mas com username  já registado na Base de Dados.    Resultado esperado: Mensagem a dizer que o username já se encontra em  uso. | PS, RP   |
| Req 3.2       | Pré-condições: Entrar na página Sign Up.    Teste: Testar com credenciais válidas, foto selecionada mas com ORCID  inválido.  Resultado esperado: Mensagem a dizer que o ORCID está inválido. | CM, PS   |
| Req 3.3       | Pré-condições: Entrar na página Sign Up.    Teste: Testar com credenciais válidas, foto selecionada e com 1º campo de  password sem respeitar os requisitos de password.   Resultado esperado: Mensagem a dizer que a password tem formato | RP, CM   |
| Req 3.3(1)    | Pré-condições: Entrar na página Sign Up.    Teste: Testar com credenciais válidas, foto selecionada e com 2º campo de  password sem corresponder ao 1º.   Resultado esperado: Mensagem a dizer que a passwords não  correspondem. | PS, RP   |
| Req 3.4       | Pré-condições: Entrar na página Sign Up.    Teste: Testar input através de lista de instituições.   Resultado esperado: Após escolher na lista ter o input no campo. | CM, PS   |
| Req 3.5       | Pré-condições: Entrar na página Sign Up,    Teste: Testar com credenciais válidas, foto selecionada e tamanho da  bio/descrição superior a 240 caracteres.  Resultado esperado: Mensagem a dizer que a bio/descrição não pode  conter mais de 240 caracteres. | CM, RP   |
| Req 3.6       | Pré-condições: Entrar na página Sign Up.    Teste: Testar fazer registo com campos por preencher, testar para cada um  dos campos.   Resultado esperado: Mensagem a dizer que existem campos por  preencher. | RP, PS   |
| Req 4.1(1)    | Pré-condições: Entrar na página de forgot password.  Teste: Testar inserir email válido e presente na Base de Dados.  Resultado esperado: Receção de um email para reposição de password. | RP, CM   |
| Req 4.1(2)    | Pré-condições: Entrar na página de forgot password.    Teste: Testar inserir email inválido.  Resultado esperado: Mensagem de formato inválido. | PS, CM   |
| Req 4.1(3)    | Pré-condições: Entrar na página de forgot password.    Teste: Testar inserir email válido e não presente na Base de Dados.  Resultado esperado: Mensagem a dizer que o email não está associado | CM, PS   |
| Req 4.2       | Pré-condições: Verificar email.   Teste: Testar clicar no email.  Resultado esperado: Abre página de reposição de password. | PS, RP   |
| Req 4.3       | Pré-condições: Entrar na página de reposição de password.  Teste: Testar inserir o 1º campo de password válido e 2º correspondente.   Resultado esperado: Altera password com sucesso. | RP, PS   |
| Req 4.4       | Pré-condições: Entrar na página de reposição de password.  Teste: Testar inserir o 1º campo de password inválido e 2º correspondente  ou não.  Resultado esperado: Mensagem de formato inválido de password. | RP, CM   |
| Req 4.6       | Pré-condições: Estar na página de login.  Teste: Testar botão de sign up.  Resultado esperado: Abrir página de sign up. | PS, CM   |
| Req 4.9       | Pré-condições: Estar na página de login.  Teste: Testar login com credenciais certas.  Resultado esperado: Abre feed de notícias. | CM, RP   |
| Req 4.7       | Pré-condições: Estar na página de login.  Teste: Testar com username inválido.  Resultado esperado: Mensagem de erro username não existe. | PS, RP   |
| Req 4.8       | Pré-condições: Estar na página de login. Teste: Testar com username válido e password inválida.  Resultado esperado: Mensagem de erro password não corresponde ao  username. | CM, PS   |
| Req.5.1       | Pré-condições: Página de resources.  Teste: Testar selecionar o botão +.  Resultado esperado: Abre página para adicionar resource. | RP, CM   |
| Req 5         | Pré-condições: Página de resources.  Teste: Testar adicionar nova resource com todos os campos válidos. (ver hashtag)Resultado esperado: Adiciona resource e fecha página de adição  automaticamente. | PS, RP   |
| Req 5.1 / 5.2 | Pré-condições: Página de resources.  Teste: Testar adicionar nova resource sem introduzir título e/ou link, ou  campos de formato inválido.  Resultado esperado: Não é adicionada nova resource. | CM, PS   |
| Req 5.4       | Pré-condições: Página de resources.  Teste: Testar confirmar ou cancelar a nova resource.  Resultado esperado: Se selecionar o add, adiciona. Se selecionar o “X” volta  para a página de resources. | PS, RP   |
| Req 5.5       | Pré-condições: Página de resources.  Teste: Inserir novo resource com resourcer já inseridos.   Resultado esperado: Serem apresentados por ordem cronológica. | RP, PS   |
| Req 5.6       | Pré-condições: Página de resources.  Teste: Apagar uma ligação.  Resultado esperado: A ligação deixar de existir na página. | RP, CM   |
| Req 5.7       | Pré-condições: Página de resources. Teste: Filtrar através de hashtags seleccionadas.  Resultado esperado: Aparecem só as que tem selecionada. | PS, RP   |
| Req 5.8       | Pré-condições: Página de resources.  Teste: Filtrar através de hashtags seleccionadas.  Resultado esperado: Aparecem filtradas e por ordem cronológica. | CM, PS   |

### Revisão de Tarefas

| Requisito # | Autor | Apontamentos                                                 | Data  |
| ----------- | ----- | ------------------------------------------------------------ | ----- |
| 1.1         | CM    | Conclusão: ReprovadoPrioridade: Must have                    | 5/12  |
| 1.1         | RP    | Conclusão: ReprovadoPrioridade:Must have                     | 9/12  |
| 1.2         | RP    | Conclusão: AprovadoPrioridade:Must have                      | 8/12  |
| 1.2         | PS    | Conclusão: AprovadoPrioridade:Must have                      | 9/12  |
| 1.3         | PS    | Conclusão: AprovadoPrioridade: Should have                   | 5/12  |
| 1.3         | CM    | Conclusão: AprovadoPrioridade:Should have                    | 9/12  |
| 1.3(1)      | RP    | Conclusão: ReprovadoNota: Dados mantêm-se iguais e apenas é alterado o OrcidPrioridade: Should have | 9/12  |
| 1.3(1)      | PS    | Conclusão: ReprovadoPrioridade: Should have                  |       |
| 1.4         | CM    | Conclusão: AprovadoPrioridade: Could have                    | 5/12  |
| 1.4         | RP    | Conclusão:AprovadoPrioridade:Could have                      | 8/12  |
| 1.5         | CM    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade: Must have | 5/12  |
| 1.5         | PS    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade: Must have | 9/12  |
| 1.6         | RP    | Conclusão: AprovadoPrioridade:Should have                    | 8/12  |
| 1.6         | PS    | Conclusão:AprovadoPrioridade:Should have                     | 9/12  |
| 1.8(1)      | PS    | Conclusão: AprovadoPrioridade:Must have                      | 9/12  |
| 1.8(1)      | CM    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 1.8(2)      | CM    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade: Must have | 9/12  |
| 1.8(2)      | RP    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade:Must have | 8/12  |
| 1.9         | PS    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade: Could have | 5/12  |
| 1.9         | RP    | Conclusão: InconclusivoNota: Deixou de ser requisito ou não se encontra implementado.Prioridade:Could have | 9/12  |
| 1.10        | CM    | Conclusão: ReprovadoNota: botão existe mas não funcionaPrioridade: Must have | 5/12  |
| 1.10        | PS    | Conclusão: ReprovadoPrioridade: Must have                    | 5/12  |
| 1.11        | RP    | Conclusão: ReprovadoPrioridade:Should have                   | 8/12  |
| 1.11        | CM    | Conclusão:  ReprovadoPrioridade:Should have                  | 9/12  |
| 1.12        | PS    | Conclusão: Aprovado Prioridade: Must have                    | 5/12  |
| 1.12        | CM    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 1.13        | CM    | Conclusão: AprovadoPrioridade: Must have                     | 7/12  |
| 1.13        | RP    | Conclusão: AprovadoPrioridade: Must have                     | 8/12  |
| 1.14        | PS    | Conclusão: ReprovadoNota: Não corresponde à quantidade.Prioridade: Could have | 5/12  |
| 1.14        | RP    | Conclusão: ReprovadoNota: Números não correspondem à realidade.Prioridade: Could have | 9/12  |
| 2.1         | CM    | Conclusão: Reprovado Nota: Não existe opção de votePrioridade: Must have | 7/12  |
| 2.1         | PS    | Conclusão: Reprovado Prioridade: Must have                   | 9/12  |
| 2.3         | RP    | Conclusão: Reprovado.Nota: Não aparece opção.Prioridade: Must have | 8/12  |
| 2.3         | CM    | Conclusão: ReprovadoPrioridade: Must have                    | 9/12  |
| 2.4         | PS    | Conclusão: ReprovadoPrioridade: Must have                    | 5/12  |
| 2.4         | RP    | Conclusão: ReprovadoNota: Não aparece botão comentar em nenhuma publicação visto que são todas do twitterPrioridade: Must have | 9/12  |
| 2.5(1)      | PS    | Conclusão: ReprovadoPrioridade: Could have                   | 5/12  |
| 2.5         | CM    | Conclusão: ReprovadoNota: imagem não é “clickable”Prioridade: Could have | 9/12  |
| 2.5         | RP    | Conclusão: AprovadoPrioridade: Could have                    | 8/12  |
| 2.5(1)      | CM    | Teste: Testar botão “see more” de um post e verificar se entra no link do twitter.Conclusão: AprovadoPrioridade: Could have | 7/12  |
| 2.6         | PS    | Conclusão: ReprovadoPrioridade: Could have                   | 7/12  |
| 2.6         | CM    | Conclusão:ReprovadoNota: Não existe opção votePrioridade: Could have | 7/12  |
| 2.7         | RP    | Conclusão: ReprovadoNota: Publicação é criada e aparece no perfil pessoal do twitter porém não aparece no feed na aplicação.Prioridade: Could have | 8/12  |
| 2.7         | CM    | Conclusão: ReprovadoNota: twitter criado mas não aparece no feed de notíciasPrioridade: Could have | 9/12  |
| 2.12        | PS    | Conclusão: ReprovadoPrioridade: Must have                    | 5/12  |
| 2.12        | CM    | Conclusão: ReprovadoNota: não existe botão com opção de adicionar hashtagsPrioridade: Must have | 9/12  |
| 3 (1)       | CM    | Conclusão: AprovadoPrioridade: Sem informação                | 5/12  |
| 3 (1)       | RP    | Conclusão: AprovadoPrioridade: Sem informação                | 8/12  |
| 3 (2)       | PS    | Conclusão: AprovadoPrioridade: Sem informação                | 9/12  |
| 3 (2)       | RP    | Conclusão: AprovadoPrioridade: Sem informação                | 9/12  |
| 3 (3)       | CM    | Conclusão: AprovadoPrioridade: Sem informação                | 5/12  |
| 3 (3)       | RP    | Teste: AprovadoPrioridade: Sem informação                    | 9/12  |
| 3.1         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 08/12 |
| 3.1         | RP    | Conclusão:AprovadoPrioridade: Must have                      | 08/12 |
| 3.2         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 3.2         | CM    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 3.3         | RP    | Conclusão: AprovadoPrioridade: Must have                     | 8/12  |
| 3.3         | CM    | Conclusão: ReprovadoNota: não exige um caracter especial pelo que não cumpre um dos requisitos de uma palavra passe.Prioridade: Must have | 5/12  |
| 3.3(1)      | PS    | Conclusão: AprovadoPrioridade: Must have                     | 5/12  |
| 3.3(1)      | RP    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 3.4         | CM    | Conclusão: ReprovadoNota: Não é apresentada uma lista.Prioridade: Could have | 5/12  |
| 3.4         | PS    | Conclusão: ReprovadoPrioridade: Could have                   | 9/12  |
| 3.5         | RP    | Conclusão: AprovadoPrioridade:Must have                      | 8/12  |
| 3.5         | CM    | Conclusão: AprovadoPrioridade:Must have                      | 5/12  |
| 3.6         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 5/12  |
| 3.6         | RP    | Conclusão: ReprovadoNota: Para alguns parâmetros é mostrada a mensagem mas por exemplo, a aplicação aceita um registo que não tenha nome e apelido.Prioridade: Must have | 9/12  |
| 4.1(1)      | CM    | Conclusão: AprovadoPrioridade: Should have                   | 7/12  |
| 4.1(1)      | RP    | Conclusão: AprovadoPrioridade: Should have                   | 8/12  |
| 4.1(2)      | PS    | Conclusão: ReprovadoPrioridade: Should have                  | 9/12  |
| 4.1(2)      | CM    | Conclusão: Reprovado Prioridade: Should have                 | 9/12  |
| 4.1(3)      | PS    | Conclusão: ReprovadoPrioridade: Should have                  | 9/12  |
| 4.1(3)      | CM    | Conclusão: ReprovadoPrioridade: Should have                  | 9/12  |
| 4.2         | RP    | Conclusão: AprovadoPrioridade: Must have                     | 8/12  |
| 4.2         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 4.3         | PS    | Conclusão: AprovadoNota: O utilizador é direcionado para uma página que mostra uma mensagem de erro.Prioridade: Must have | 9/12  |
| 4.3         | RP    | Conclusão: ReprovadoNota: Insere nova password mas o utilizador é direcionado para uma página que mostra uma mensagem de erro.Prioridade: Must have | 9/12  |
| 4.4         | CM    | Conclusão: ReprovadoNota: Botão “save” da palavra passe não funciona. Após colocar a palavra errada não sugere nada.Prioridade: Should have | 7/12  |
| 4.4         | RP    | Conclusão: ReprovadoNota: Não aparece mensagem. O botão “save” não funciona após colocar password inválidaPrioridade: Should have | 8/12  |
| 4.6         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 5/12  |
| 4.6         | CM    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 4.7         | RP    | Conclusão:AprovadoPrioridade: Must have                      | 8/12  |
| 4.7         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 4.8         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 4.8         | CM    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 4.9         | CM    | Conclusão: AprovadoPrioridade: Should have                   | 7/12  |
| 4.9         | RP    | Conclusão: AprovadoPrioridade: Should have                   | 9/12  |
| 5           | PS    | Conclusão: AprovadoPrioridade: Sem informações               | 9/12  |
| 5           | RP    | Conclusão: AprovadoPrioridade: Sem informações               | 9/12  |
| 5.1         | CM    | Conclusão: ReprovadoNota: Existe botão mas direciona para nenhum ladoPrioridade: Must have | 7/12  |
| 5.1         | RP    | Conclusão: AprovadoPrioridade: Must have                     | 8/12  |
| 5.1/ 5.2    | CM    | Conclusão: AprovadoPrioridade: Should have                   | 9/12  |
| 5.1/ 5.2    | PS    | Conclusão: AprovadoPrioridade: Should have                   | 9/12  |
| 5.4         | RP    | Conclusão: AprovadoPrioridade: Should have                   | 8/12  |
| 5.4         | PS    | Conclusão: AprovadoPrioridade: Should have                   | 9/12  |
| 5.5         | PS    | Conclusão: AprovadoPrioridade:Could have                     | 9/12  |
| 5.5         | RP    | Conclusão: AprovadoPrioridade: Could have                    | 9/12  |
| 5.6         | CM    | Conclusão: AprovadoPrioridade: Should have                   | 7/12  |
| 5.6         | RP    | Conclusão: AprovadoPrioridade:Should have                    | 8/12  |
| 5.7         | PS    | Conclusão: AprovadoPrioridade: Must have                     | 5/12  |
| 5.7         | RP    | Conclusão: AprovadoPrioridade: Must have                     | 9/12  |
| 5.8         | CM    | Conclusão: AprovadoPrioridade: Could have                    | 7/12  |
| 5.8         | PS    | Conclusão: AprovadoPrioridade: Could have                    | 9/12  |

Observações:

Os testes são relativos aos requisitos da Sprint#2 mas é utilizada a aplicação mais recente da equipa WeSearchers, ou seja, Sprint#4.
Relembro que não foi possível a concretização dos testes na passada Sprint, então, em reunião com o professor responsável foi aceite a utilização da aplicação mais recente.

- Quando, na coluna referente aos requisitos, apenas é apresentado um algarismo como é o exemplo de 3, em vez de 3.1, refere se a um teste sobre a categoria dos requisito, neste caso o Sign Up e nao com um requisito em específico.

Métricas:

Número de requisitos testados: 51

Número de testes realizados: 51*2 = 102

Número de requisitos inconclusivos: 3/50 **

Número de testes aprovados: 60/100

Número de testes reprovados: 36/100

Número de testes inconclusivos: 6/100

Número de requisitos aprovados: 30

- Prioridade alta (Must have): 19
- Prioridade baixa (Could have): 4
- Prioridade média (Should have): 7

Número de requisitos reprovados: 18

- Prioridade alta (Must have): 7
- Prioridade baixa (Could have): 6
- Prioridade média (Should have): 5

** De notar que estes requisitos, tendo sido aplicados na Sprint#2, em discussão com a equipa WeSearchers confirmamos que já não são requisitos da Sprint atual, daí o teste não ter resultado.

- Dado o número de requisitos implementados e funcionais e a utilização extensiva da aplicação podemos confirmar que se trata de um produto que preciso de algum retoque mas, no geral, cumpre maior parte das funcionalidades exigidas.
  De destacar que poderá haver algumas inconformidades entre os requisitos fornecidos à nossa equipa e os requisitos atuais e daí, alguns dos testes serem inconclusivos. 