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

1. Processo de Reuniões 													             MQ_TST_REUNIOES
2. Processo de Testes/Revisão de Código							          	MQ_TST_TESTES_CODIGO
3. Processo de revisão de documentos                           MQ_TST_REVISAO
4. Processo de criação do documento de revisão de código       MQ_TST_DOC_TESTES
5. Processo de criação do documento de testes a realizar        MQ_TST_TASKS


### MQ_TST_REUNIOES

### TABELA DE VERSÕES

| VERSÃO | DATA       | AUTORES         | DESCRIÇÃO           |
| ------ | ---------- | --------------- | ------------------- |
| ?      | ?          | ?               | ?                   |
| 0.3    | 24/09/2018 | ?               | Criação do processo |
| 0.4    | 04/10/2018 | Maria Pereira   | Alterações          |
| 0.5    | 20/10/2018 | Catarina Mestre | Alterações          |

| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DO PROCESSO

O processo de reuniões serve para discussão de tarefas e distribuição destas por todos os elementos, assim como decisões a tomar nos próximos dias. As reuniões devem ser feitas regularmente, quer sejam feitas semanalmente ou após libertação de código por parte da equipa de implementação. No início da reunião será decidido duas pessoas para escreverem a ata.  O gestor da equipa está encarregue de distribuir os testes por cada elemento da equipa.

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

- template_ata.md.
- Métricas/requisitos.
- Tópicos a discutir inseridos no Trello.

### CRITÉRIO DE ATIVAÇÃO/TRIGGER

- Necessidade de tomada de decisões importantes por parte do Gestor de equipa.

### DESCRIÇÃO DAS TAREFAS

- Criação da lista de tarefas a realizar, colocando-as no Trello.
- Distribuição das tarefas por cada elemento da equipa.
- Estipulação de prazo para entrega de resultados.

### CICLO DE VIDA DOS ARTEFACTOS

1. Revisão do documento por membros da TST;
2. Verificação pela QA (Se não aprovado volta ao ponto 1);
3. Arquivo no github;

### OUTPUTS

- Ata da reunião guardada no GitHub ATA_TST_#.md.
- Lista de tarefas a fazer, colocadas no Trello, associadas a cada elemento.

### CRITÉRIO DE SAÍDA

A reunião está terminada, todas as tarefas foram feitas, os documentos foram aceites e a ata validada por todos.

### MÉTRICAS DE AVALIAÇÃO

- Qualidade das decisões tomadas

- Qualidade das atas elaboradas
- Assiduidade dos membros



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
- Escrita dos resultados no template TST_REVISAO_SPRINT#.md.
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
| 0.5    | 20/10/2018 | João Oliveira | Alterações          |

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

### CICLO DE VIDA DOS ARTEFACTOS
1.Revisão do documento por membros da TST;
2.Verificação pela QA (Se não aprovado volta ao ponto 1);
3.Arquivo no github;

### OUTPUTS
Documento validado, pronto para fazer merge no master, fazendo pull request.

### CRITÉRIO DE SAÍDA
Após assegurar que o documento respeita todas as regras, este processo termina.

### MÉTRICAS
- Número de documentos validados.
- Se o documento não for validado ao fim de 24h após a sua conclusão será dado como inválido.




### MQ_TST_DOC_TESTES
### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO           |
| ------ | ---------- | ------------- | ------------------- |
| ?      | ?          | ?             | ?                   |


| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DE PROCESSOS
Sempre que um elemento complete um teste e coloque a respetiva card no "Done" do Trello, irá colocar no documento TST_REVISAO_SPRINT#1.md todos os dados relativos aos testes realizados, seguidos de apontamentos que poderão ser importantes para a implementação. Quando todos os testes forem concluídos, o coordenador, ou um outro elemento à escolha, irá fazer uma revisão ao documento de forma a este respeitar o processo MQ_TST_REVISAO

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
- Após a implementação libertar código

### CRITÉRIO DE ATIVAÇÃO/TRIGGER
- Completar uma card no trello relatova a testes

### DESCRIÇÃO DAS TAREFAS
- Escrever os resultados dos testes realizados
- Escrever que tipos de testes foram feitos
- Verificar se os requisitos relativos às tarefas foram cumpridos

### OUTPUTS
- Documento TST_REVISAO_SPRINT#.md

### CRITÉRIO DE SAÍDA
Após conclusão de todas as tarefas estipuladas na reunião e realização do relatório final, este processo termina.



### MQ_TST_TASKS
### TABELA DE VERSÕES
| VERSÃO | DATA       | AUTORES       | DESCRIÇÃO           |
| ------ | ---------- | ------------- | ------------------- |
| ?      | ?          | ?             | ?                   |


| TST | ? | Estado: Incompleto |
| - | - | - |

------

### DESCRIÇÃO DE PROCESSOS
Processo destinado à redação de um documento com os testes a realizar e a sua distribuição pelos elementos da equipa.
Com base no documento de requisitos, um ou mais elementos irão fazer um rascunho dos testes que poderão ser realizados para testar o produto, que depois serão discutidos numa reunião e por decisão coletiva, o documento será dado como terminado. Após se terem decidido os testes definitivos, estes serão colocados na board do Trello.


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
- Documento de requisitos

### CRITÉRIO DE ATIVAÇÃO/TRIGGER
- Documento de requisitos atualizado para a sprint

### DESCRIÇÃO DAS TAREFAS
- Redação dos testes a realizar conforme os requisitos
- Delegação dos testes, aos elementos da equipa

### OUTPUTS
- Documento TST_TASKS#.md

### CRITÉRIO DE SAÍDA
Após se ter realizado uma reunião e os testes serem aprovados por todos os elementos presentes
