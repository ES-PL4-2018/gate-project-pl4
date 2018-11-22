# GATE - QUA

## ATA Reunião

### Ref: QUA_ATA_W1_S4

### Data & Hora: 21 Novembro 2018 @ 1230

### Duração: 01:15

### # páginas: 1

#### ASSIDUIDADE

Maria Pereira, Sergii Mykolyshyn, Vitor Ribeiro, João Soares, Carlos Poiares, Pedro Fernandes

#### TABELA DE REVISÕES

Rev # | Autor|  Descrição | Data
--- | --- | --- | ---
0.1 | João Soares | Edição inicial | 21/11/2018
1.0 | João Soares | Revisão e formatação | 22/11/2018

<br/>

#### ORDEM DE TRABALHOS

* Balanço da Sprint #3
* Decidir que registo será utilizado para ver se os processos do MQ estão a ser compridos
* Debate sobre todas as notas do professor em relação ao MQ
* Discutir os novos processos e se os mesmos precisam de alguma alteração
* Discussão de outras possíveis alterações ao MQ

<br/> 

#### Eleição do Co-lead da unidade

##### DISCUSSÃO

Foi levantada a questão relativamente aos processos da equipa, sendo necessário existir um _co-lead_ da unidade. Tendo em conta que o João Soares esteve 2 semanas como _lead_ e trocou, neste momento também não faria sentido ficar como _co-lead_. Sendo que nos restantes elementos não existiam voluntários, ficou decidida a nomeção através de sorteio entre os elementos.

##### DECISÕES

* Foi eleito _co-lead_ da unidade o Pedro Fernandes

<br/>

#### Balanço da Sprint #3

##### DISCUSSÃO

Efectuado balanço da sprint 3, onde ficou patente que existiu alguma falta de empenho no dia da entrega para revisão dos últimos documentos que era necessário, ficando um elemento sobre-carregado com tarefas que deveriam ter sido distribuidas.

##### DECISÕES

* Irão começar a ser distribuidas as cards nominalmente no trello

<br/>

#### Decidir que registo será utilizado para ver se os processos do MQ estão a ser compridos

##### DISCUSSÃO

Tendo em conta a necessidade de consolidar os registos das métricas reúnidas nas iterações dos diferentes processos, acompanhamento e monitorização do trabalho da equipa, foram debatidas algumas soluções.
* Criação de vários documentos no repositório (um para acompanhamento e outro para métricas do processo)
  * Vantagens
    * Registo de versionamento automático pelo git
    * Maior facilidade para visualizar informação diretamente no repositório
  * Desvantagens 
    * Utilização simultânea do documento irá fácilmente originar colisões entre versões ao fazer pull
* Criação de um documento excel no repositório
  * Vantagens
    * Maior facilidade em tratamento dos dados
  * Desvantagens 
    * Utilização simultânea do documento irá fácilmente originar colisões entre versões ao fazer pull
    * GitHub trata documentos excel como "blob" não faz versionamento das alterações
    * Dificuldade em converter o documento para markdown
* Criação de _sheet_ no google
  * Vantagens
    * Permite edição simultânea sem risco de colisões
    * Versionamento automático
  * Desvantanges
  	* Dificuldade em converter o documento para markdown

##### DECISÕES

* Vai ser criada _sheet_ no google para consolidação da informação
* Alteração ao processo de monitorização:
  * Contemplar as a nova _sheet_ para registo da informação
  * Acompanhamento de processsos continuo em vez de uma iteração para cada
  * Remover template de acompanhamento existente (irá ficar obsoleto)
* Articular com unidade de ENV a criação de um script para converter a _sheet_ para markdown


<br/>

#### Debate sobre todas as notas do professor em relação ao MQ

##### DISCUSSÃO

Foram debatidas as notas da sprint 3 que não foram possíveis de rever

##### DECISÕES

* Revisão do processo Team_Workflow - tentar a criação de um grupo trabalho com as várias unidades para revisão
* Remover workflow de git do manual de qualidade


<br/>

#### Discutir os novos processos e se os mesmos precisam de alguma alteração

##### DISCUSSÃO

Foram verificados os novos processos e debatidas alterações a serem efetuadas

##### DECISÕES

* Alteração do processo de ciclo vida do artefacto:
  * Para melhorar a integração de métricas do git que estão a ser avaliadas, os _Pull Requests_ terão de ter tags.
    * Ao ser criado pelo autor, tem de colocar a tag correspondente á sua unidade;
    * Durante a validação técnica, se o processo alguma vez for devolvido ao autor, o _reviewer_ terá de colocar a tag _rework_
    * Durante a validação formal, se o processo alguma vez for devolvido ao autor, o _reviewer_ da qua terá de adicionar a tag _unconformity_
* Efetuar uma revisão in(formal) a todo o manual, no tocante a processos e duplicação dos mesmos

<br/>

#### Discussão de outras possíveis alterações ao MQ

##### DISCUSSÃO

Foram debatidas algumas gralhas no manual detectadas pós entrega e também troca de ideias relativas a melhorias em processos

##### DECISÕES

* Efetuar avaliação e testes para integração automática dos dados dos _pull requests_ na plataforma de acompanhamento da unidade
* Notificar a unidade de requesitos para alterar documento de rosto da unidade (não segue template)
* Necessário fazer verificação do processo de inspeções, para garantir follow up
  * _reviewer_ formal do ciclo de alteração do documento tem obrigatóriamente de ser o moderador da reunião de inspeção

<br/> 
<br/>

#### MÉTRICAS PARA A REUNIÃO
Assiduidade -> 6 / 6<br/>
Duração -> 1:15<br/>
Nº de tópicos discutidos -> <br/>
Avaliação global -> 4,5<br/>
