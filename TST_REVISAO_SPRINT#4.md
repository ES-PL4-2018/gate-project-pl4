## Resultados de Testes Sprint #4 - versão 0.4.2 da app
#### DOC ID: TST_REVISAO_SPRINT#4

#### # Sprint: 4

#### Data: 18/12/2018

#### Versão: 0.4

### Edição

| Rev # | Autor         | Descrição                                      | Data  |
| ----- | ------------- | ---------------------------------------------- | ----- |
| 0.1   | Pedro Sá      | Preenchimento da tabela de descrição de testes | 17/12 |
| 0.1.1 | Jessica Cunha | Escrita dos testes no doc                      | 18/12 |
| 0.1.2 | Pedro Sá      | Escrita dos testes no doc                      | 18/12 |
| 0.1.3 | João Oliveira | Escrita dos testes no doc                      | 18/12 |
| 0.2.1 | Pedro Sá      | Atualização dos testes realizados              | 18/12 |
| 0.2.2 | Jessica Cunha | Atualização dos testes realizados              | 18/12 |
| 0.2.3 | João Oliveira | Atualização dos testes realizados              | 18/12 |
| 0.3   | Pedro Sá      | Redação da conclusão                           | 18/12 |
| 0.4   | Jessica Cunha | Revisão do doc                                 | 18/12 |


### Responsáveis
| Nome            | Curso | Cargo          |
| --------------- | ----- | -------------- |
| Pedro Sá        | LEI   | Coordenador    |
| Jessica Cunha   | LEI   | Co-coordenador |
| Catarina Mestre | LEI   | Colaborador    |
| João Oliveira   | LEI   | Colaborador    |
| João Silva      | LEI   | Colaborador    |
| Ricardo Paiva   | LEI   | Colaborador    |

# Hiperligações

### Descrição dos testes - GATE

| Requisito # | Testes Realizados                                            | Elemento |
| ----------- | ------------------------------------------------------------ | -------- |
| 1.7         | No registo o utilizador pode inserir uma foto de perfil      | PS, JC   |
| 1.12        | No registo o utilizador pode alterar o email sugerido pelo ORCID, por outro email válido. Formato: ‘user@domain.tld’ | JO, JC   |
| 2.12        | Os tweets apresentados devem funcionar como um buffer circular até 1000 tweets, ou seja, ao inserir o 1001º, o 1º será removido do feed | JO, PS   |
| 2.15        | No feed de um utilizador, os posts passam a ser também acerca dos interesses dos contactos da sua lista | JC, JO   |
| 4.6         | O utilizador pode remover a bookmark criada                  | PS, JO   |
| 4.7         | O utilizador pode editar todos os campos de uma bookmark adicionada | PS, JC   |
| 5.2         | A lista de contactos de um utilizador tem um máximo de 500 utilizadores, escolhidos pelo mesmo | JC, JO   |
| 5.6         | É possível pesquisar um utilizador                           | JO, PS   |
| 6.2         | O discovery process guarda as conexões com outros investigadores na rede, até ao limite de 5000 | JC, PS   |
| 6.3         | Caso a lista ultrapasse o limite de conexões, devem ser automaticamente eliminados os utilizadores que há mais tempo não se conectam com o investigador | JC, JO   |
| 6.4         | O utilizador recebe uma notificação a cada 25 novas conexões no espaço de tempo superior a uma hora | PS, JC   |
| 6.7         | É possível pesquisar um utilizador                           | JO, PS   |

### Revisão de Tarefas

| Requisito # | Autor | Apontamentos                                                 | Data  |
| ----------- | ----- | ------------------------------------------------------------ | ----- |
| 1.7         | JC    | Teste: No registo dá para inserir uma foto de perfil</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 1.7         | PS    | Teste: No registo dá para inserir uma foto de perfil</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 1.12        | JO    | Teste: No registo o utilizador pode alterar o email sugerido pelo ORCID, por outro email válido</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 1.12        | JC    | Teste: No registo o utilizador pode alterar o email sugerido pelo ORCID, por outro email válido</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 2.12        | JO    | Teste: Verificação de limite de 1000 tweets</br>Resultado: Aprovado </br>Prioridade: Alta | 18/12 |
| 2.12        | PS    | Teste: Verificação de limite de 1000 tweets </br>Resultado: Aprovado</br>Prioridade: Alta | 18/12 |
| 2.15        | JC    | Teste: No feed os posts passam estão de acordo com os interesses dos contactos da sua lista.Alterar interesses no perfil e ver se atualiza.</br>Resultado: Aprovado</br>Prioridade: Alta | 18/12 |
| 2.15        | JO    | Teste: No feed os posts passam estão de acordo com os interesses dos contactos da sua lista.</br>Resultado: Aprovado</br>Prioridade: Alta | 18/12 |
| 4.6         | PS    | Teste: Remover a bookmark anteriormente criada.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 4.6         | JO    | Teste: Remover a bookmark anteriormente criada.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 4.7         | JC    | Teste: O utilizador pode editar todos os campos de uma bookmark adicionada</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 4.7         | PS    | Teste: O utilizador pode editar todos os campos de uma bookmark adicionada</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 5.2         | JC    | Teste: Adicionar vários contactos, se funcionar, assumir que aceita.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 5.2         | JO    | Teste: Adicionar vários contactos, se funcionar, assumir que aceita.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 5.6         | PS    | Teste: Pesquisa de um utilizador na mesma rede.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 5.6         | JO    | Teste: Pesquisa de um utilizador na mesma rede.</br>Resultado: Aprovado</br>Prioridade: Média | 18/12 |
| 6.2         | JC    | Teste: O discovery process guarda as conexões com outros investigadores na rede, até ao limite de 5000</br>Resultado: Aprovado</br>Prioridade: Alta | 18/12 |
| 6.2         | PS    | Teste: O discovery process guarda as conexões com outros investigadores na rede, até ao limite de 5000</br>Resultado: Aprovado</br>Prioridade: Alta | 18/12 |
| 6.3         | JC    | Teste: Caso a lista ultrapasse o limite de conexões, devem ser automaticamente eliminados os utilizadores que há mais tempo não se conectam com o investigadorNotas: Não há limite, logo é uma incógnita o que acontece</br>Resultado: Reprovado</br>Prioridade: Alta | 18/12 |
| 6.3         | JO    | Teste: Caso a lista ultrapasse o limite de conexões, devem ser automaticamente eliminados os utilizadores que há mais tempo não se conectam com o investigador</br>Resultado: Reprovado</br>Prioridade: Alta | 18/12 |
| 6.4         | JC    | Teste: Criar 25 conexões e verificar que recebe uma notificação</br>Resultado: Reprovado</br>Prioridade: Média | 18/12 |
| 6.4         | PS    | Teste: Criar 25 conexões e verificar que recebe uma notificação</br>Resultado: Reprovado</br>Prioridade: Média | 18/12 |

### Observações:

Métricas:

Número de requisitos testados: 12

Número de testes realizados: 12*2  = 24

Número de requisitos inconclusivos: 0

Número de testes aprovados: 20/24

Número de requisitos aprovados: 10

- Prioridade alta: 3
- Prioridade baixa: 0
- Prioridade média: 7

Número de requisitos reprovados: 2

- Prioridade alta: 1
- Prioridade baixa: 0
- Prioridade média: 1



De destacar que o requisito de alta prioridade reprovado deve se ao facto de existir um limite associado ao nível de conexões e que foram aprovados 10 de 12 requisitos finais. Com isto, podemos afirmar que a aplicação está pronta para o deploy, sendo aprovada pela nossa equipa.
