# Requisitos
## ** ATA Reunião do Cliente #2 Sprint #2**

| **Equipa:** Requisitos | **Data:** 12 Outubro 2018| 
| ------ | ------ | 
| **Estado:** Incompleto |  **Coordenador:** Victor Carvalho |

#### **Responsáveis pela tarefa e respetiva função**
  * Catarina Pires  - Discussão da ordem de trabalhos
  * Victor Carvalho - Responsável pela ata e discussão da ordem de trabalhos

### Data & Hora: 
12 Outubro 2018
Marcado para 17h

### Duração: 52 minutos
Início: 17:01
Fim:    17:53

<br/> 

#### ASSIDUIDADE

* Victor Carvalho
* Catarina Pires

### TABELA DE VERSÕES
|**Versão**|**Autor**|**Data**|**Notas**|
|---|---|---|---|
|0.1 | Victor Carvalho | 12/10 | Versão inicial|

<br/>

#### ORDEM DE TRABALHOS
* Tipos de Diagrama de Navegação
* Requisitos Não-Funcionais
* Testes de aceitação (Acceptance tests)
* Mensagens diretas (RE)
* Informações de Perfil (RE)
* Aceder ao perfil de um utilizador (RE)
* Número de itens no Feed do utilizador (RE)

RE → Requisitos específicos
<div style="page-break-after: always;"></div>


#### Tipos de Diagrama de Navegação
##### DISCUSSÃO
O diagrama de navegação é um mapa de navegação, no âmbito do produto, no qual está definido a relação entre os caminhos possíveis dentro da aplicação.

É necessário esclarecer os tipos de navegação existentes e definir as possibilidades de uso no produto.

Uma arquitetura muito utilizada para aplicações atuais é a arquitetura em pétalas.
##### DECISÕES
* Estudar o esquema UED
* Definir Focus areas no diagrama
* Definir o modelo e legendas a se seguir para o diagrama de navegação

#### Requisitos Não-Funcionais
##### DISCUSSÃO
1. Usabilidade
É um critério que necessita a definição de métricas de modo a analisar e quantificar a descrição deste requisito.

Mais concretamente, se definirmos que a usabilidade está de acordo com os requisitos se o utilizador conseguir realizar uma ação em menos de 5 interações, ou em menos de 30 segundos então a usabilidade passa a ser algo subjetivo para algo mensurável (até certo ponto).

2. Robustez
Assim como a usabilidade, exige uma definição do que é em concreto.

Um exemplo de robustez é garantir que o produto se porta bem dado informações erradas ou que corrija o utilizador neste tipo de situação. Isto torna o produto mais resiliente à erros e mais _confiável_ ou robusto.
##### DECISÕES
* Definir os critérios de robustez no sentido de validação dos dados inseríveis
* Definir os critérios e métricas de usabilidade no âmbito de tornar o produto mais simples no número de ações

<div style="page-break-after: always;"></div>

#### Testes de aceitação (Acceptance tests)
##### DISCUSSÃO
São testes formais e concretos (no âmbito da cadeira) na perspectiva do utilizador que, dado um contexto específico, definem uma série de processos realizados passo a passo e ao final deve possuir um resultado definido neste documento.

Id est:
No login, um utilizador deseja registar-se. Deve estar na página inicial um botão de login que o leva ao processo de registo. O utilizador insere todas as suas informações: primeiro nome, último nome, instituição, e-mail, research unit, ORCID, etc, todos validados pela aplicação como corretos e após inscrição na plataforma é redirecionado ao feed. 
##### DECISÕES
* Definir os testes de aceitação de modo a abranger as funcionalidades apresentadas na tabela de requisitos **num documento à parte**

#### Mensagens diretas
##### DISCUSSÃO
Dentro do [método MoSCoW](https://en.wikipedia.org/wiki/MoSCoW_method) este requisito se encaixa em _Would_.
##### DECISÕES
* **Não** incluir este requisito na tabela de requisitos

#### Aceder ao perfil de um utilizador
##### DISCUSSÃO
Será concretizado e necessário quando houver a seção "Minha Rede" dentro da aplicação.
##### DECISÕES
* Incluir na tabela de requisitos com prioridade Baixa **no âmbito da Sprint #2**
<div style="page-break-after: always;"></div>

#### Informações de Perfil
##### DISCUSSÃO
As informações necessárias para o menu do perfil são:

* Nome
* Instituição
* Research Unit (i.e: CISUC)
* Research Interest (i.e: Pentesting, Dependability, etc)

##### DECISÕES
* Alterar o mockup para ter os campos descritos acima
* Alterar o mockup para remover as linhas embaixo da informação de modo a não sobrepor com a edição. O Cliente ficou visivelmente confuso ao início com a falta de diferença visual entre os dois.

#### Número de itens no Feed do utilizador
##### DISCUSSÃO
Visto que a aplicação necessita de manter um feed com diversas informações, convém que cada item presente neste feed não fique guardado _ad eternum_ foi definido que o feed guarda **1000** itens num buffer circular. Isto implica que a chegada de um novo item remove o item nº 1 e passa a ser o item nº 1001 e assim em diante.
##### DECISÕES
* Incluir na tabela de requisitos com prioridade Alta

#### MÉTRICAS PARA A REUNIÃO
* Assiduidade → Todos presente
* Duração → 
  * Esperado: 30 minutos
  * Tempo real: 54 minutos
* Número de tópicos discutidos: 
  * 7 discutidos
  * 7 totais
<br/>
