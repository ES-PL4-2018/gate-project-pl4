# QUA_MONITORIZACAO_PROCESSOS

**DOC ID:** QUA_MONITORIZACAO_PROCESSOS

| UNIDADE | COORDENADOR |
|---------|-------------|
|    QUA  | João Soares |

## **TABELA DE VERSÕES**
| Versão | Data | Autor(es) | Descrição |
|-|-|-|-|
| 0.1 | 20/09/2018 | João Soares | Criação do processo |
| 0.2 | 04/10/2018 | Maria Pereira | Alterações |
| 0.5 | 22/10/2018 | Carlos Poiares | Alterações, Revisão e Aprovação|
| 0.6 | 13/11/2018 | Vítor Ribeiro  | Alteração e Revisão|
| 0.7 | 19/11/2018 | Vítor Ribeiro  | Alteração e Revisão|
| 1.0 | 19/11/2018 | Maria Pereira |Alterações
| 2.0 | 28/11/2018 | Sergii Mykolyshyn | Adição de acompanhamento contínuo


#### DESCRIÇÃO DO PROCESSO
Este processo consiste na monitorização da atividade da equipa, de acordo com o Manual de Qualidade, estabelecendo a monitorização de toda a equipa e a regulamentação do cumprimento das métricas (definidas e regulamentadas pelos processos descritos no Manual de Qualidade) de avaliação de toda equipa,definindo todo o processo desde a recolha e processo geracional, interpretação (estatísticas e dados) e manutenção da informação relativa às métricas, tudo isto com base em todas as cards registadas no Trello da equipa. Após a interpretação dos dados, perceber que comportamentos há a corrigir na equipa, em que casos é preciso fazer alterações mais profundas e também os aspectos mais positivos do trabalho da equipa, possíveis alterações de processos e outros elementos do Manual de Qualidade. 

#### RESPONSÁVEIS
Unidade de Qualidade.

#### INPUTS
* Todas as cards registadas no Trello (semanalmente);
* Documentos presentes no Manual de Qualidade;
* Dados obtidos através das plataformas de recolha de métricas (recolhidos na aplicação de recolha de métricas do Trello);
* Artefactos produzidos (relatórios, docs).

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO
No início de cada sprint (sendo realizada numa base diária).

#### DESCRIÇÃO DAS TAREFAS
* Recolha de métricas e estatísticas, através da aplicação de recolha de métricas da plataforma Trello;
* Comparação dos elementos recolhidos com as regras impostas para o respectivo processo através do Manual de Qualidade e dos templates disponíveis (averiguação de procedimentos);
* Análise dos dados e estatisticas recolhidos através dos métodos de recolha de métricas, de modo a percerber os comportamentos e desempenhos da equipa, com o objetivo de entender o momento da equipa e as causas do momento;
* O team-lead de Qualidade é responsável por notificar o team-lead da unidade em causa de modo a notificar toda a equipa quando algo não está dentro dos parâmetros definidos e perceber o que está errado;
* Alterações na equipa relativamente às conclusões obtidas após a análise e interpretação dos dados relativos às métricas;
* Possíveis revisões do Manual de Qualidade, ao nível de processos, após um parecer do team-lead de Qualidade e da unidade em questão;
* Possível revisão de artefactos por parte das unidades, depois de um parecer do team-lead de Qualidade e da unidade em questão.
* Acompanhamento contínuo de processos, isto é, após a revisão de um *pull request*, é necessário o preenchimento de Google Sheet partilhado pelos membros da equipa de qualidade, onde terá de ser especificado:
	* Unidade à qual o *pull request* pertence;
	* DOC ID;
	* Número do *pull request*;
	* Nome do artefacto;
	* Autor do *pull request*;
	* Inspetor (membro da qualidade responsável pela revisão do *pull request*);
	* Data da inspeção;
	* Observações, no caso da reprovação do PR, especificar a razão para isso ter acontecido. Outras observações relevantes, se necessárias;
	* Estado - Aprovado (artefacto está de acordo com templates fornecidos)/ Reprovado (artefacto não está de acordo com templates fornecidos).


#### CICLO DE VIDA DOS ARTEFACTOS
A informação recolhida e todos os documentos produzidos são armazenados no GitHub e integrados na apresentação semanal.


#### OUTPUTS
* Métricas recolhidas, analisadas, interpretadas e incluídas na apresentação semanal;
* Possíveis pareceres, referidos na descrição de tarefas;
* Google Sheet com métricas recolhidas.


#### CRITÉRIO DE SAÍDA
Final da sprint.

#### MÉTRICAS DE AVALIAÇÃO
* Número de inconformidades encontradas;
* Número de recomendações produzidas;
* Número de horas dispendidas em cada processo;
* Número de alterações promovidas.


#### APROVAÇÃO E VALIDAÇÃO
Qualquer membro da Equipa de Qualidade está apto de validar processos e analise das métricas.
