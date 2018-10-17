### Unidade de Testing (TST)

| Disciplina: TST        | Data: 24/09/2018 | Coordenador: Jessica Cunha |
| ---------------------- | ---------------- | -------------------------- |
| **Estado:** Incompleto | **Versão:** v0.5 |                            |

#### Lista de membros:

| Nome            | Curso | Contacto                   |
| --------------- | ----- | -------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com |
| Catarina Mestre | LEI   | mestrekata@hotmail.com     |
| João Oliveira   | LEI   | jdoliveira579@gmail.com    |
| João Silva      | LEI   | joaomiguelbsilva@hotmail.com|
| Pedro Sá        | LEI   | sa@student.dei.uc.pt       |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt  |

#### Objetivos da unidade de TST:
- Fazer testes ao código, sendo que cada um tem de ser testado por pelo menos 2 pessoas.
- Detetar erros existentes na aplicação, fornecendo essa informação a equipa de implementação.
- Determinar se a aplicação está pronta para ser entregue ao cliente, de acordo com os requisitos impostos pelo mesmo.

#### Processos utilizados por esta unidade:

1. Processo de Reuniões 													MQ_TST_REUNIOES
2. Processo de Testes/Revisão de Código								MQ_TST_TESTES_CODIGO
3. Processo de revisão de documentos                  MQ_TST_REVISAO


### MQ_TST_REUNIOES
### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO           |
| ------ | ---------- | ------------- | ------------------- |
| ?      | ?          | ?             | ?                   |
| 0.3    | 24/09/2018 | ?             | Criação do processo |
| 0.4    | 04/10/2018 | Maria Pereira | Alterações          |

| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DO PROCESSO
O processo de reuniões serve para discussão de tarefas e distribuição destas por todos os elementos, assim como decisões a tomar nos próximos dias. As reuniões devem ser feitas regularmente, quer sejam feitas semanalmente ou após libertação de código por parte da equipa de implementação. No início da reunião será decidido duas pessoas para escreverem a ata.  O gestor da equipa está encarregue de distribuir os testes por cada elemento da equipa.

### RESPONSÁVEIS

| Nome            | Curso | Contacto                   |
| --------------- | ----- | -------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com |
| Catarina Mestre | LEI   | mestrekata@hotmail.com     |
| João Oliveira   | LEI   | jdoliveira579@gmail.com    |
| João Silva      | LEI   |joaomiguelbsilva@hotmail.com|
| Pedro Sá        | LEI   | sa@student.dei.uc.pt       |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt  |

### INPUTS
- TST_TEMPLATE_TASKS_#1.md.
- template_ata.md.
- Métricas/requisitos.
- Tópicos a discutir inseridos no Trello.

### CRITÉRIO DE ATIVAÇÃO/TRIGGER
- Necessidade de tomada de decisões importantes por parte do Gestor de equipa.

### DESCRIÇÃO DAS TAREFAS
- Criação da lista de tarefas a realizar.
- Distribuição das tarefas por cada elemento da equipa.
- Estipulação de prazo para entrega de resultados.
- Escolha de um elemento para fazer a concatenação dos relatórios de revisão de código individuais.
- Verificar se os requisitos são cumpridos.

### OUTPUTS
- Ata da reunião guardada no GitHub ATA_TST_#1.md.
- Lista de tarefas a fazer, colocadas no Trello, associadas a cada elemento.

### CRITÉRIO DE SAÍDA
A reunião está terminada, todas as tarefas foram feitas, os documentos foram aceites e a ata validada por todos.



### MQ_TST_TESTES_CÓDIGO
### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO           |
| ------ | ---------- | ------------- | ------------------- |
| ?      | ?          | ?             | ?                   |
| 0.3    | 24/09/2018 | ?             | Criação do processo |
| 0.4    | 04/10/2018 | Maria Pereira | Alterações          |

| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DE PROCESSOS
Este processo descreve a verificação e validação do código através da descoberta de erros/bugs. A implementação, após ter terminado uma tarefa, avisará através do slack e colocará a respetiva card do trello na parte dos testes,  para estes iniciarem continuous testing.

Sempre que os testes forem terminados, o respetivo elemento, irá escrever na descrição da card quais os testes realizados, a sua duração, e se foi ou não aprovado. No caso de ser aprovado, essa tarefa passará para o "Done", e a implementação será avisada através do slack. No caso de ser reprovado, essa tarefa passará para o "Done", criando uma nova e colocando-a na board da implementação, com os erros encontrados na descrição.

Durante a sprint, todos os elementos irão colocar num documento (TST_REVISAO_SPRINT#.md), os resultados obtidos, para que qualquer pessoa facilmene consiga ver o estado da aplicação/testes.



### RESPONSÁVEIS
| Nome            | Curso | Contacto                   |
| --------------- | ----- | -------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com |
| Catarina Mestre | LEI   | mestrekata@hotmail.com     |
| João Oliveira   | LEI   | jdoliveira579@gmail.com    |
| João Silva      | LEI   |joaomiguelbsilva@hotmail.com|
| Pedro Sá        | LEI   | sa@student.dei.uc.pt       |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt  |

### INPUTS
- Código fornecido pela equipa de Implementação sujeito a teste

### CRITÉRIO DE ATIVAÇÃO/TRIGGER
- Implementação libertar uma card

### DESCRIÇÃO DAS TAREFAS
- Realização dos testes necessário para aprovação/reprovação de cada tarefa a si atríbuida.
- Afixação dos aspectos falhados pela aplicação ao longo do sprint na board de implementação do Trello.
- Escrita dos resultados no template TST_REVISAO_SPRINT#.md no final do sprint.
- Verificar se os requisitos são cumpridos.

### OUTPUTS
- Documento TST_REVISAO_SPRINT#.md que contém o resumo do trabalho feito e das conclusões chegadas.

### CRITÉRIO DE SAÍDA
Após conclusão de todas as tarefas estipuladas na reunião e realização do relatório final, este processo termina.



### MQ_TST_REVISAO
### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO           |
| ------ | ---------- | ------------- | ------------------- |
| ?      | ?          | ?             | ?                   |
| 0.2    | 24/09/2018 | ?             | Criação do processo |
| 0.4    | 04/10/2018 | Maria Pereira | Alterações          |

| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DE PROCESSOS
Método de revisão de documentos internos à equipa.

### RESPONSÁVEIS
| Nome            | Curso | Contacto                   |
| --------------- | ----- | -------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com |
| Catarina Mestre | LEI   | mestrekata@hotmail.com     |
| João Oliveira   | LEI   | jdoliveira579@gmail.com    |
| João Silva      | LEI   |joaomiguelbsilva@hotmail.com|
| Pedro Sá        | LEI   | sa@student.dei.uc.pt       |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt  |

### INPUT
- Documento TST_REVISAO_SPRINT#.md que contém o resumo dos testes e os respetivos resultados.
- Atas ATA_TST_#1.md que corresponde às atas elaboradas em cada uma das reuniões de equipa.

### CRITÉRIO DE ATIVAÇÃO/TRIGGER
- Após colocação do documento em causa num novo branch no git e aviso à restante equipa através do Slack.

### DESCRIÇÃO DAS TAREFAS
- Assegurar que os documentos seguem a estrutura dos templates existentes.
- Assegurar que os documentos não têm erros ortográficos.
- Garantir que a informação fornecida através dos relatórios/atas é informativa, esclarecedora e enquadrada com o que é pretendido.

### OUTPUTS
Documento validado, pronto para fazer merge no master, fazendo pull request.

### CRITÉRIO DE SAÍDA
Após assegurar que o documento respeita todas as regras, este processo termina.

### MÉTRICAS
- Número de documentos validados.
- Se o documento não for validado ao fim de 24h após a sua conclusão será dado como inválido.
