### MQ_TST_TESTES_CÓDIGO

**DOC_ID:** MQ_TST_TESTES CÓDIGO

| Unidade | Coordenador   |
| ------- | ------------- |
| TST     | Jessica Cunha |

### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO                                              |
| ------ | ---------- | ------------- | ------------------------------------------------------ |
| 0.3    | 24/09/2018 | Jessica Cunha | Criação do processo                                    |
| 0.4    | 04/10/2018 | Maria Pereira | Alterações                                             |
| 1.0    | 17/10/2018 | Jessica Cunha | Alteração de acordo com o novo método de trabalho      |
| 1.1    | 20/10/2018 | Ricardo Paiva | Add info sobre métricas e ciclo de vida dos artefactos |
| 2.0    | 26/10/2018 | Maria Pereira | Validação |
| 2.1    | 14/11/2019 | Jessica Cunha | Alteração do processo de acordo com as inspeções realizadas |

------

### DESCRIÇÃO DE PROCESSOS
Este processo descreve a verificação e validação do código através da descoberta de defeitos. A implementação, após ter terminado uma tarefa, avisará através do slack e colocará a respetiva card do trello na parte dos testes,  para estes iniciarem continuous testing.

Sempre que os testes forem terminados, o respetivo elemento, irá escrever na descrição da card quais os testes realizados, a sua duração, e se foi ou não aprovado. No caso de ser aprovado, essa tarefa passará para o "Done", e a implementação será avisada através do slack. No caso de ser reprovado, essa tarefa passará para o "Done", criando uma nova e colocando-a na board da implementação, com os erros encontrados na descrição.

Após terminados os testes à aplicação, um dos elementos, a escolher pelo coordenador, irá colocar num documento (TST_REVISAO_SPRINT#n.md), os resultados obtidos, para que qualquer pessoa consiga ver o estado da aplicação/testes. Esses resultados estão nas cards do trello referentes a cada requisito.

### RESPONSÁVEIS
| Nome            | Curso | Contacto                     |
| --------------- | ----- | ---------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com   |
| Catarina Mestre | LEI   | mestrekata@hotmail.com       |
| João Oliveira   | LEI   | jdoliveira579@gmail.com      |
| João Silva      | LEI   | joaomiguelbsilva@hotmail.com |
| Pedro Sá        | LEI   | sa@student.dei.uc.pt         |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt    |

### INPUTS
- Documento de requisitos (SRS)
- Produto a testar, disponibilizado pela equipa de implementação

### CRITÉRIO DE ENTRADA/ATIVAÇÃO
- Implementação libertar uma card

### DESCRIÇÃO DAS TAREFAS
- Realização dos testes, atribuídos pelo coordenador no Trello.
- Descrição dos testes efetuados, duração e aprovação/reprovação do teste (de acordo com os requisitos, e a sua prioridade), na respetiva card.
- Afixação dos aspectos falhados pela aplicação na board de Implementação, do Trello.
- Escrita dos resultados no template TST_REVISAO_SPRINT#.md, por um elemento a decidir pelo coordenador.

### CICLO DE VIDA DOS ARTEFACTOS
- Criação da card no Trello por parte dos membros de implementação;
- Análise e teste do código fornecido pelos membros de implementação;
- Escrita dos resultados na card do trello;
- Caso seja aprovada coloca-se card em done e a implementação é avisada;
- Caso seja reprovada, coloca-se card em done e cria uma card nova para a implementação com a descrição de todos os erros (Volta ao ponto 1);
- Redação do documento TST_REVISAO_SPRINT#n.md após todos os testes serem finalizados

### OUTPUTS
- Documento TST_REVISAO_SPRINT#.md que contém o resumo do trabalho feito e das conclusões chegadas.

### CRITÉRIO DE SAÍDA
Após conclusão de todas as cards do Trello e realização do relatório final, este processo termina.

### MÉTRICAS DE AVALIAÇÃO
- Número de testes realizados;
- Número de aprovações obtidas em função do número total de revisões, e da prioridade do respetivo requisito;
- Número de reprovações obtidas em função do número total de revisões, e da prioridade do respetivo requisito;

### APROVAÇÃO E VALIDAÇÃO
