## Resultados de Testes Sprint #3 - versão 0.3.1 da app
#### DOC ID: TST_REVISAO_SPRINT#3

#### # Sprint: 3

#### Data: 19/11/2018

#### Versão: 0.4

### Edição

| Rev # | Autor           | Descrição                 | Data  |
| ----- | --------------- | ------------------------- | ----- |
| 0.1   | Pedro Sá        | Escrita dos testes no doc | 17/11 |
| 0.1.1   | João Oliveira   | Escrita dos testes no doc | 17/11 |
| 0.1.2   | Catarina Mestre | Escrita dos testes no doc | 18/11 |
| 0.1.3   | Jessica Cunha   | Escrita dos testes no doc | 18/11 |
| 0.1.4   | Ricardo Paiva   | Escrita dos testes no doc | 18/11 |
| 0.2.1 | Pedro Sá        | Atualização dos testes realizados| 18/11 |
| 0.2.2   | João Oliveira   | Atualização dos testes realizados | 18/11|
| 0.2.3   | Catarina Mestre | Atualização dos testes realizados| 18/11 |
| 0.2.4   | Jessica Cunha   | Atualização dos testes realizados | 18/11|
| 0.2.5   | Ricardo Paiva   | Atualização dos testes realizados | 18/11|
| 0.3   | Pedro Sá        | Redação da conclusão      | 19/11 |
| 0.4   | Jessica Cunha   | Revisão do doc            | 19/11 |


### Responsáveis
| Nome            | Curso | Cargo       |
| --------------- | ----- | ----------- |
| Pedro Sá   | LEI   | Coordenador |
| Jessica Cunha  | LEI   | Co-coordenador |
| Catarina Mestre | LEI   | Colaborador |
| João Oliveira   | LEI   | Colaborador |
| João Silva      | LEI   | Colaborador |
| Ricardo Paiva   | LEI   | Colaborador |

# Hiperligações

### Descrição dos testes

| Requisito # | Testes Realizados                                            | Elemento |
| ----------- | ------------------------------------------------------------ | -------- |
| Req 1.1     | O utilizador pode alterar o primeiro e último nome fornecido pelo login no ORCID. Este campo contém apenas letras | CM, JO   |
| Req 1.4     | O utilizador pode alterar a instituição à qual está filiado sugerida pelo ORCID.  Este campo deve aceitar apenas caracteres alfabéticos | JC, RP   |
| Req 1.6     | O utilizador pode alterar o Research Center sugerido pelo ORCID. Este campo deve aceitar apenas caracteres alfabéticos | CM,JC    |
| Req 1.7     | No registo o utilizador pode inserir uma foto de perfil      | RP,CM    |
| Req 1.8     | No registo devem ser sugeridos temas de interesse populares ao utilizador (predefinidos) Ex: #ArtificialIntelligence, #ComputerScience,  #BusinessManagemen, #MachineLearning, #WebSecurity, #SoftwareEngineering | PS, JO   |
| Req 1.10    | O utilizador deve poder selecionar (escrever) os seus temas. Este campo deve aceitar apenas caracteres alfabéticos | CM,RP    |
| Req 1.11    | O utilizador pode cancelar o processo de registo a qualquer momento, deve existir uma botão com a etiqueta "Cancel" | JC, PS   |
| Req 1.12    | No registo o utilizador pode alterar o email sugerido pelo ORCID, por outro email válido. Formato: ‘user@domain.tld’ | JO,CM    |
| Req 1.13    | No registo, o utilizador cria uma password para o login      | RP,JC    |
| Req 1.15    | No login deve ser sugerida a recuperação de password a um utilizador que erre a palavra-passe mais que 3 vezes | PS,JO    |
| Req 1.16    | Se os dados de login estiverem corretos, o utilizador é redirecionado para o feed de notícias | CM,RP    |
| Req 1.17    | Após o registo, o utilizador é redirecionado para o feed     | JC, PS   |
| Req 1.18    | O registo é feito através do número do ORCID e a respectiva password para aceder à API da plataforma e recolher as informações através da mesma | CM, JO   |
| Req 1.19    | A partir do login, o utilizador apenas verifica as informações. Escolhe seus interesses | JC, PS   |
| Req 2.5     | O utilizador consegue aceder ao seu perfil deslizando para o lado esquerdo | JO,CM    |
| Req 2.7     | Deslizar para o lado direito, dá também acesso à lista de bookmarks | JO,JC    |
| Req 2.11    | Apresentar no post da app imagens presentes no link do tweet | RP,JO    |
| Req 2.13    | Ao clicar no símbolo da Discovery redireciona para a Discovery | JO, RP   |
| Req 2.14    | Caso o utilizador tenha associado a conta do Twitter à app, é possível criar um post no Twitter a partir da mesma. (Pode ser redirecionado para o Twitter para compor o post) | PS, CM   |
| Req 2.15    | No feed de um utilizador, os posts passam a ser também acerca dos interesses dos contactos da sua lista | RP, JC   |
| Req 3.4     | Na edição de perfil, os dados devem ser validados tal como no registo | CM,PS    |
| Req 3.7     | O utilizador pode (opcionalmente) associar o Twitter ao seu perfil na aplicação | CM, JO   |
| Req 4.6     | As bookmarks podem estar organizadas por temas ou pastas     | JC,CM    |
| Req 5.1     | Nesta página é apresentada uma lista de contactos e ao clicar num deles, é possível aceder ao seu perfil | JC, PS   |
| Req 5.2     | A lista de contactos de um utilizador tem um máximo de 500 utilizadores, escolhidos pelo mesmo | JO, RP   |
| Req 5.3     | Deverá existir um botão de eliminar junto a cada contacto    | PS, CM   |
| Req 5.4     | Um contacto é permanente até ser eliminado pelo investigador | RP, JC   |
| Req 5.5     | Os contactos presentes na lista de um utilizador possuem os seus perfis armazenados no dispositivo do mesmo | CM, JO   |
| Req 6.1     | Os contactos são obtidos através de multicast, ou seja, investigadores presentes na mesma rede são automaticamente adicionados à lista. | JC, PS   |
| Req 6.2     | O discovery process guarda as conexões com outros investigadores na rede, até ao limite de 5000 | JO, RP   |
| Req 6.3     | Caso a lista ultrapasse o limite de conexões, devem ser automaticamente eliminados os utilizadores que há mais tempo não se conectam com o investigador | PS, CM   |
| Req 6.4     | O utilizador recebe uma notificação a cada 25 novas conexões no espaço de tempo superior a uma hora | RP, JC   |
| Req 6.5     | A lista está ordenada por ordem de última conexão via multicast | PS, JO   |
| Req 6.6     | Dos investigadores presentes nesta lista, o utilizador pode clicar num botão que os adiciona aos seus contactos | RP, PS   |

### Revisão de Tarefas

| Requisito # | Autor | Apontamentos                                                 | Data  |
| ----------- | ----- | ------------------------------------------------------------ | ----- |
| 1.1         | CM    | Teste: Mudar nome de utilizador. Verificar se aceita algum caracter sem ser letras ou espaços.<br>Conclusão: Aprovado. | 15/11 |
| 1.1         | JO    | Teste: Mudar nome e apelido de utilizador. Verificar se aceita algum caracter sem ser letras ou espaços.<br/>Conclusão: Aprovado. | 17/11 |
| 1.4         | JC    | Teste: Verificar que é possível alterar a instituição e que o orcid sugere uma instituição.<br/>Conclusão: Aprovado | 15/11 |
| 1.4         | RP    | Teste: Inserir nomes com símbolos ou com caracteres numéricos.<br/>Conclusão: Aprovado.. | 15/11 |
| 1.6         | JC    | Teste: O user pode alterar o research center sugerido pelo orcid. Só pode aceitar caracteres<br/>Conclusão: Aprovado | 17/11 |
| 1.6         | CM    | Teste: Alterar o Research Center. Apenas pode aceitar caracteres.<br/>Conclusão: Aprovado. | 17/11 |
| 1.7         | CM    | Teste: Adicionar e tentar mudar foto de perfi<br/>lNota: Apenas é possível adicionar foto de perfil se se conectar ao Twitter.<br/>Conclusão: Reprovado. | 15/11 |
| 1.7         | RP    | Teste: Clique no botãoNotas: Não existe opção para escolha.<br/>Conclusão: Reprovado | 15/11 |
| 1.8         | PS    | Teste: Ao fazer o registo verificar se são apresentadas as sugestões predefinidas.<br/>Conclusão: Aprovado | 15/11 |
| 1.8         | JO    | Teste: Visualização dos temas predefinidos.<br/>Conclusão: Aprovado | 15/11 |
| 1.10        | CM    | Teste: Selecionar e escrever temas. Verificar se aceita algum caracter sem ser letras ou espaços.<br/>Nota: Após o registo, a aplicação apenas permite escrever os temas e não selecionar os pré-definidos. É necessário carregar várias vezes para aparecer o teclado. Permite adicionar vários temas com o mesmo nome.<br/>Conclusão: Aprovado | 15/11 |
| 1.10        | RP    | Teste: Escrita de um tema e adicionar<br/>Notas: Alguns problemas de formatação<br/>Conclusão: Aprovado.. | 15/11 |
| 1.10        | JO    | Teste: Escrita de um tema e adicionar.<br/>Notas: Está com problemas na apresentação, resolver se possível.<br/>Conclusão: Aprovado | 15/11 |
| 1.11        | JC    | Teste: Verificar que em qualquer momento do registo é possível cancelar<br/>Nota: Não obedece ao requisito pois não tem a etiqueta “Cancel” <br/>Conclusão: Aprovado | 15/11 |
| 1.11        | PS    | Teste: Verificar que a qualquer passo, é possível voltar à página inicial <br/>Conclusão: Aprovado | 15/11 |
| 1.12        | CM    | Teste: Alterar o email sugerido pelo ORCID, no registo.<br/>Nota: Não é sugerido nenhum email no ato do login e é aceite um email não válido.<br/>Conclusão: Reprovado. | 15/11 |
| 1.12        | JO    | Teste: Alterar o email sugerido pelo ORCID, no registo.<br/>Nota: Não é sugerido nenhum email no ato do login e é aceite um email não válido.<br/>Conclusão: Aprovado | 18/11 |
| 1.13        | RP    | Teste: Inserir password<br/>Conclusão: Aprovado..            | 15/11 |
| 1.13        | JC    | Teste: Verificar que o utilizador tem de criar uma password para fazer login<br/>Conclusão: Aprovado | 15/11 |
| 1.15        | PS    | Teste: No login, após errar 3 vezes a password, verificar se é sugerida a sua recuperação.<br/>Conclusão: Reprovado | 15/11 |
| 1.15        | JO    | Teste: Errar na palavra-passe de propósito.<br/>Notas: Não há diferença se erro na palavra pass ou no orcid e após as 3 falhas não há qualquer sugestão para recuperação da palavra passe.<br/>Conclusão: Reprovado | 15/11 |
| 1.16        | CM    | Teste: Depois de fazer login, o utilizador é redirecionado para o Feed de notícias.<br/>Conclusão: Aprovado. | 15/11 |
| 1.16        | RP    | Teste: Clicar no botão para finalizar login<br/>Conclusão: Aprovado | 15/11 |
| 1.17        | PS    | Teste: Verificar se ao completar o registo, o user é redirecionado para o feed<br/>Conclusão: Aprovado | 15/11 |
| 1.17        | JC    | Teste: Completar registo e verificar que o user é redirecionado para o feed<br/>Conclusão: Aprovado | 15/11 |
| 1.18        | CM    | Teste: Verificar se o registo é feito apenas com o número de ORCID e uma password.<br/>Conclusão: Aprovado | 17/11 |
| 1.18        | JO    | Teste: Verificar se o registo é feito apenas com o número de ORCID e uma password.<br/>Conclusão: Aprovado | 18/11 |
| 1.19        | PS    | Teste: No registo apenas necessita de verificar as informações relativas ao ORCID e escolher pelo menos 3 interesses.<br/>Conclusão: Aprovado | 17/11 |
| 1.19        | JC    | Teste: Verificar que no registo, após colocar o orcid, o utilizador apenas tem de confirmar as informações e escolher os interesses<br/>Nota: É necessário inserir o email.<br/>Conclusão: Aprovado | 17/11 |
| 2.5         | JO    | Teste: Deslizar para o lado esquerdo.<br/>Notas: Não há qualquer tipo de ação.<br/>Conclusão: Reprovado | 15/11 |
| 2.5         | CM    | Teste: Aceder ao perfil deslizando para o lado esquerdo.<br/>Conclusão: Reprova | 15/11 |
| 2.7         | JC    | Teste: Dar swipe para a direita e verificar que muda para o separador “bookmarks”<br/>Conclusão:Reprovado | 15/11 |
| 2.7         | JO    | Teste: Deslizar para o lado direito.<br/>Notas: Não há qualquer tipo de ação.<br/>Conclusão: Reprovado | 15/11 |
| 2.11        | JO    | Teste: Visualização do feed.<br/>Notas: Funciona muito bem.<br/>Conclusão: Aprovado. | 15/11 |
| 2.11        | RP    | Teste: Verificar se apresenta imagens e se essas imagens estão enquadradas com a publicação.<br/>Conclusão: Aprovado | 15/11 |
| 2.13        | JO    | Teste: Clique no botão.<br/>Nota: O botão abre a lista de contactos.<br/>Conclusão: Aprovado | 17/11 |
| 2.13        | RP    | Teste: Clique no botão<br/>Nota: Ao clicar vai para a lista de contactos.<br/>Conclusão: Aprovado | 17/11 |
| 2.14        | PS    | Teste:  Conectar a conta do Twitter à app e criar um post no Twitter a partir da mesma. Verificar na aplicação Twitter se o tweet existe.<br/>Conclusão: Aprovado | 17/11 |
| 2.14        | CM    | Teste: Conectar conta ao Twitter, tentar criar um post na aplicação GATE.<br/>Conclusão: Aprovado. | 17/11 |
| 2.15        | RP    | Teste: Adicionar um contacto e depois verificar se os post passam a ser também relacionados com o interesse do contacto<br/>Conclusão: Reprovado | 18/11 |
| 2.15        | JC    | Teste: Ver interesses dos contactos e confirmar que também aparecem no feed posts relacionados<br/>Conclusão: Reprovado | 18/11 |
| 3.4         | CM    | Teste: Editar as informações inseridas no registo. Verificar se os campos aceitam apenas letras e espaços.<br/>Conclusão: Aprovado. | 15/11 |
| 3.4         | PS    | Teste: Editar as informações inseridas no registo. Verificar se os campos aceitam apenas letras e espaços.<br/>Conclusão: Aprovado. | 15/11 |
| 3.7         | JO    | Teste: Conexão da conta twitter<br/>Notas: Está no perfil a opção de conectar a conta.<br/>Conclusão: Aprovado | 17/11 |
| 3.7         | CM    | Teste: Conectar conta ao Twitter.Conclusão: Aprovado.        | 17/11 |
| 4.6         | CM    | Teste: Organizar bookmarks por temas ou pastas.<br/>Notas: Apenas existe um botão para adicionar bookmarks. Não existe mais nada que permita a sua organização. Foi necessário encerrar a app e voltar a entrar para aparecerem as bookmarks adicionadas.<br/>Conclusão: Reprovado. | 15/11 |
| 4.6         | JC    | Teste: Organizar bookmarks por temas ou pastas<br/>Notas: Não é possível organizar as bookmarks<br/>Conclusão: Reprovado | 15/11 |
| 5.1         | PS    | Teste: Verificar se é apresentada a lista de contactos adicionados. Verificar se ao pressionar no contacto aparece as informações referentes ao perfil.<br/>Nota: Ao adicionar um contacto, o programa a correr na máquina, na mesma rede que o telemóvel tem um erro e para de correr<br/>Conclusão: Aprovado | 18/11 |
| 5.1         | JC    | Teste: Verificar que aparece a lista de contactos, conforme os utilizadores na rede. Clicar num contacto e ver se aparece o seu perfil<br/>Nota: Após testar com outro telemóvel na rede, não apareceu nada<br/>Conclusão: Aprovado | 17/11 |
| 5.2         | JO    | Teste: Verificar se aparecem no máximo 500 utilizadores na lista de contactos.<br/>Conclusão: Inconclusivo | 17/11 |
| 5.2         | RP    | Teste: Verificar se aparecem no máximo 500 utilizadores na lista de contactos.<br/>Notas: Não é possível adicionar qualquer contacto<br/>Conclusão: Inconclusivo | 17/11 |
| 5.3         | PS    | Teste: Adicionar um contacto e verificar se existe um botão ao lado que o permita eliminar.<br/>Nota: O contacto é removido se carregarmos durante algum tempo no contacto.<br/>Conclusão: Aprovado | 17/11 |
| 5.3         | CM    | Teste: Criar contacto e verificar se existe um botão ao lado que o permita eliminar.<br/>Notas: Não é possível adicionar utilizadores à lista de contactos.<br/>Conclusão: Aprovado | 18/11 |
| 5.4         | JC    | Teste: Verificar que o contacto não é eliminado. Tentar eliminar contacto<br/>Conclusão: Aprovado | 17/11 |
| 5.4         | RP    | Teste: Tentar eliminar contacto. Verificar se ele não é eliminado.<br/>Conclusão: Aprovado | 17/11 |
| 5.5         | JO    | Teste: Abrir perfil de um contacto presente na lista.<br/>Conclusão: Aprovado |       |
| 5.5         | CM    | Teste: Abrir perfil de um contacto da lista.<br/>Conclusão: Aprovado | 18/11 |
| 6.1         | PS    | Teste: Verificar que aparecem por default os utilizadores ligado à mesma rede, na lista de contactos.<br/>Nota: Aparecem todos os contactos mas os contactos offline não podem ser associados. Não podendo ser conectados, não faz sentido aparecerem na lista a adicionar.<br/>Conclusão: Aprovado | 17/11 |
| 6.1         | JC    | Teste: Verificar que aparecem por default os utilizadores ligado à mesma rede, nos contactos.<br/>Nota: Aparecem todos os contactos mas os contactos offline não podem ser associados. Não podendo ser conectados, não faz sentido aparecerem na lista a adicionar.<br/>Conclusão: Aprovado | 17/11 |
| 6.2         | JO    | Teste: Verificar se o discovery process guarda as conexões com outros investigadores na rede (max: 5000).<br/>Nota: Impossível testar este requisito.<br/>Conclusão: Inconclusivo | 17/11 |
| 6.2         | RP    | Teste: Verificar se o discovery process guarda as conexões com outros investigadores na rede (max: 5000).<br/>Notas: Impossível testar este requisito.<br/>Conclusão: Inconclusivo | 17/11 |
| 6.3         | CM    | Teste: Tentar criar uma lista de contactos que ultrapasse o limite de conexões e verificar se os investigadores que não se conectam há mais tempo são eliminados.<br/>Nota: Impossível testar este requisito.<br/>Conclusão: Inconclusivo | 18/11 |
| 6.3         | PS    | Teste: Tentar criar uma lista de contactos que ultrapasse o limite de conexões e verificar se os investigadores que não se conectam à mais tempo são eliminados.Nota: Implementado, mas impossível de testar.<br/>Conclusão: Inconclusivo | 17/11 |
| 6.4         | JC    | Teste: Verificar que o user recebe uma notificação após 25 novas conexões, no espaço de tempo superior a 1h<br/>Nota: Sem condições para testar<br/>Conclusão: Inconclusivo | 17/11 |
| 6.4         | RP    | Teste: Verificar que o user recebe uma notificação após 25 novas conexões, no espaço de tempo superior a 1h<br/>Notas: Sem condições para testar<br/>Conclusão: Inconclusivo | 17/11 |
| 6.5         | JO    | Teste: Verificar que aparecem os utilizadores por ordem de ultima conexão.Conclusão: Aprovado | 17/11 |
| 6.5         | PS    | Teste: Verificar que aparecem os utilizadores por ordem de ultima conexão.<br/>Nota: Deveria aparecer com a ordem contrária.<br/>Conclusão: Aprovado | 17/11 |
| 6.6         | RP    | Teste: O utilizador pode clicar num botão que adiciona aos seus contactos.<br/>Nota: Consegue carregar no nome do utilizador e adicionar assim.<br/>Conclusão: Aprovado | 17/11 |
| 6.6         | PS    | Teste: O utilizador pode clicar num botão que adiciona aos seus contactos.<br/>Nota: Consegue carregar no nome do utilizador e adicionar assim.<br/>Conclusão: Aprovado | 17/11 |

## Conclusão

##### Métricas:

Número de requisitos testados: 34

Número de testes realizados: 34*2+1 = 69

Número de requisitos inconclusivos: 8/69

Número de testes aprovados: 46/69

Número de requisitos aprovados: 48

- Prioridade alta: 34
- Prioridade baixa: 2
- Prioridade média: 12

Número de requisitos reprovados: 13

- Prioridade alta: 2
- Prioridade baixa: 8
- Prioridade média: 3

Número de requisitos inconclusivos: 8

- Prioridade alta: 4
- Prioridade baixa: 0
- Prioridade média: 4

Tendo em conta que os requisitos reprovados são maioritariamente  de prioridade baixa e não obrigatórios, concluimos que a aplicação é aprovada. No entanto, é de ter em conta, que não foi possível testar alguns requisitos de prioridade alta e média, relativos a esta sprint (#3) . 