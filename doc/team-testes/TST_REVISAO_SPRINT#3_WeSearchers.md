## Resultados de Testes Sprint #3 - WeSearchers

#### DOC ID: TST_REVISAO_SPRINT#3_WeSearchers

#### Sprint: 3

#### Data: 16/11/2018

#### Versão: x.x.x (versão do produto fornecido, desconhecida)

### Edição

| Rev # | Autor         | Descrição            | Data  |
| ----- | ------------- | -------------------- | ----- |
| 0.1   | Pedro Sá      | Redação do documento | 16/11 |
| 0.2   | Jessica Cunha | Revisão do documento | 17/11 |
| 0.3   | Pedro Sá      | Revisão do documento | 18/11 |

### Descrição:

Este documento é destinado à descrição dos testes e resultados dos mesmos na aplicação disponibilizada pela equipa WeSearchers, relativamente à sua versão da aplicação da sprint 2.

### Responsáveis

| Nome            | Curso | Cargo          |
| --------------- | ----- | -------------- |
| Pedro Sá        | LEI   | Coordenador    |
| Jessica Cunha   | LEI   | Co-Coordenador |
| Catarina Mestre | LEI   | Colaborador    |
| João Oliveira   | LEI   | Colaborador    |
| Ricardo Paiva   | LEI   | Colaborador    |

# Hiperligações

[Conclusão](conclusão)

### Descrição dos testes

| Requisito # | Testes Realizados | Elemento |
| ----------- | ----------------- | -------- |
| -------     | -------           | -------  |

### Revisão de Tarefas

| Requisito #    | Autor      | Apontamentos  | Data          |
| -------------- | ---------- | ------------- | ------------- |
| -------------- | ---------- | ------------- | ------------- |

## Conclusão

Após várias tentativas de configuração do sistema de forma a podermos testar o produto da equipa WeSearchers, não foi possível a mesma e consequentemente nao foram realizados os testes.
Foi nos facultado o documento com o tutorial de instalação (1.0.MQ_AMB_HOW_TO_INSTALL.pdf) por parte da equipa WeSearchers, tal como o documento de requisitos (2.0.MQ_REQ_DOCUMENTO_REQUISITOS.pdf) relativos à sprint 2 e o documento de planeamento dos testes relativos a estes requisitos.
O tutorial para a instalação e utilização da aplicação foi cumprido a rigor e repetido várias vezes pelos membros da undidade de Testes mas não foi bem sucedido em nenhuma máquina destes.
Consultamos várias vezes os elementos da equipa WeSearchers, passando pela sua equipa de implementação e ambiente, de forma a resolvermos o problema. É de salientar a sua disponibilização e empenho na resolução do problema mas, contudo, não foi de nenhum forma possível ultrapassado.

Inicialmente, os problemas passaram por faltas de módulos na versão de python e a não compatibilidade dos mesmos. 

As várias tentativas passaram por instalar várias versões de python, incluindo as versões 3.7, 3.4, 3.5.4, 3.5.0 e 3.5.2rc1. Sempre com falha em alguns módulos nomeadamente runpy, tweepy e psycopg. E após nova configuração do ficheiro credentials.json e a utlização de outras versões de python e a ajuda de um membro da unidade de implementação da equipa WeSearchers, foi possível ultrapassar estes detalhes retirando todos os componentes relativos à configuração e seguindo de novo o tutorial com a versão 3.5.2 do python. 

Infelizmente no registo inicial na aplicação deparamo-nos com um problema, que inicialmente pensamos ser da conexão com a base de dados mas verificamos que era um problema na libraria smtp.lib do python. Podendo estar corrompida, passamos por retirar e importar novamente mas o problema manteve-se.

Entrando em maior detalhe, o problema passa pela falha na ligação com o servidor SMTP no pedido de resposta. Esta falha, inicialmente foi avaliada como uma simples falha nas versões de pyhton instaladas mas foi testado com outras versões incluindo a versão utilizada pela própria unidade de testes da equipa WeSearchers. Prosseguimos em repetir o processo mas nao obtivemos um resultado diferente.

Destacamos também, que um elemento da unidade de implementação da equipa a testar, depois de retirar todos os elementos que integram a instalação e utilização da aplicação e de seguida, seguindo o tutorial rigorosamente conseguiu com que esta respondesse normalmente. Dado que vários elementos elementos da nossa equipa, tentativa após tentativa, seguiram estritamente o tutorial e não conseguiram a sua instalação ficamos assim sem alternativas e ultimamente, sem condições para testar a aplicação da equipa WeSearchers.
