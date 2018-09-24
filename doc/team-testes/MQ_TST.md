### Unidade de Testing (TST)

| Disciplina: Tst        | Data: 24/09/2018 | Coordenador: Jessica Cunha |
| ---------------------- | ---------------- | -------------------------- |
| **Estado:** Incompleto | **Versão:** v0.1 |                            |

#### Lista de membros:

| Nome            | Curso | Contacto                   |
| --------------- | ----- | -------------------------- |
| Jessica Cunha   | LEI   | jessicacunha98@hotmail.com |
| Catarina Mestre | LEI   | mestrekata@hotmail.com     |
| João Oliveira   | LEI   | jdoliveira579@gmail.com    |
| Pedro Sá        | LEI   | sa@student.dei.uc.pt       |
| Ricardo Paiva   | LEI   | rjpaiva@student.dei.uc.pt  |

#### Objetivos da unidade de TST:

#### Processos utilizados por esta unidade:

1. Processo de Reuniões 															MQ_TST_REUNIOES
2. Processo de Testes/Revisão de Código								MQ_TST_TESTES_CODIGO
3. Processo de Resultados 													  MQ_TST_RESULTADOS
4. Processo de revisão de documentos                  MQ_TST_REVISAO


- A equipa discute que testes serão feitos, sendo que cada um tem de ser testado por, pelo menos 2 pessoas
- O gestor da equipa terá de distribuir os testes por cada elemento da equipa
- Será redigido um relatório com os aspectos em falha e o que foi testado, sendo que este só será lançado, com a aprovação do gestor de equipa.
- A equipa de testes é que decide se o projeto corresponde aos requisitos, e juntamente com a equipa de qualidade, se este pode ser entregue ao cliente
- No caso da deteção de um erro trivial durante os testes, será possível a sua correção com o consentimento dos vários elementos da equipa;
- Para haver alteração do código, será necessário criar um pull request no git, que seguirá para a aprovação do Gestor da Implementação
- Será imposto pelo gestor de equipa um prazo máximo para a realização de cada teste e entrega da sua parte do relatório.
- Se o gestor de equipa não estiver a ir de encontro com os objetivos do seu cargo, este deve ser destituído. Dentro da equipa deverá ser escolhido um novo elemento para o substituir, por voluntariado ou votação.


### MQ_TST_REUNIOES

**Estado:** Incompleto		**Data:** 24/09/2018		**Versão:** v0.2

------

### Descrição do processo:

O processo de reuniões serve para discussão de tarefas e distribuição destas por todos os elementos, assim como decisões a tomar nos próximos dias. As reuniões devem ser feitas regularmente, quer sejam feitas semanalmente ou após libertação de código por parte da equipa de implementação. Neste segundo caso, a reunião irá ser baseada na distribuição de tarefas/testes pelos membros da equipa, sendo redigido um relatório com todas as funções.
No início da reunião será decidido duas pessoas para escreverem a ata.

### Responsáveis:

Todos os elementos da equipa devem participar nas reuniões. Caso algum elemento não posso comparecer, este deve ler a ata da reunião, e perguntar aos restantes membros das equipas no caso de dúvidas.

### Input:
- TST_TEMPLATE_TASKS_#1.md
- template_ata.md
- Métricas/requisitos
- Tópicos a discutir inseridos no Trello

### Critério de entrada/ativação:
- Necessidade de tomada de decisões importantes por parte do Gestor de equipa
- Após libertação de código por parte da equipa de Implementação

### Descrição das Tarefas:
- Criação da lista de tarefas a realizar
- Distribuição das tarefas por cada elemento da equipa
- Estipulação de prazo para entrega de resultados
- Escolha de um elemento para fazer a concatenação dos relatórios de revisão de código individuais

### Critério de saída:
A reunião está terminada, todas as tarefas foram feitas, os documentos foram aceites e a ata validada por todos.

### Outputs:
- Ata da reunião guardada no GitHub ATA_TST_#1.md
- Documento de tarefas para os testes, caso necessário, TST_TASKS_#1.md
- Lista de tarefas a fazer, colocadas no Trello

##### 


### MQ_TST_TESTES_CÓDIGO

**Estado:** Incompleto		**Data:** 24/09/2018		**Versão:** v0.2

------

### Descrição do processo:

Este processo descreve a verificação e validação do código através da descoberta de erros e ver se corresponde aos requisitos, pela parte da equipa de Testes. No final será apresentado um relatório deste à equipa de implementação.

### Input:

- Template TST_TASKS#1.md que serve para cada elemento se guiar no que tem de fazer, e o que os restantes membros têm de fazer.
- Template TST_REVISAO_NOME.md para apresentação de resultados individual
- Código fornecido pela equipa de Implementação sujeito a teste

### Critério de entrada/ativação:
- Após término de uma reunião

### Descrição das Tarefas:
- Realização dos testes necessário para aprovação/reprovação de cada tarefa a si atríbuida
- Escrita dos resultados no template TST_REVISAO_NOME.md
- Concatenação dos relatórios individuais num só usando o TST_TEMPLATE_RESULTADOS#1.md, por parte de um membro a definir na reunião.

### Critério de saída:

Após conclusão de todas as tarefas estipuladas na reunião, e realização do relatório final, este processo termina.

### Outputs:
- Documento TST_RESULTADOS_#1.md que contém o resumo do trabalho feito, e das conclusões chegadas.

# TO-DO

### MQ_TST_REVISAO

**Estado:** Incompleto		**Data:** 24/09/2018		**Versão:** v0.2

------

### Descrição do processo:
Método de revisão de documentos internos à equipa

### Input:
- Documento TST_RESULTADOS_#1.md que contém o resumo dos testes e os respetivos resultados.
- Atas ATA_TST_#1.md que corresponde às atas elaboradas em cada uma das reuniões de equipa.
- Documento TST_TASKS_#1.md que é constituído pela divisão de tarefas/testes ao fim de cada reunião.

### Critério de entrada/ativação:
- Após colocação do documento em causa num novo branch no git, e aviso à restante equipa através do Slack.

### Descrição das Tarefas:
- Assegurar que os documentos seguem a estrutura dos templates existentes;
- Assegurar que os documentos não têm erros ortográficos;
- Garantir que a informação fornecida através dos relatórios/atas é informativa, esclarecedora e enquadrada com o que é pretendido;

### Métricas:
- Número de documentos validados;
- Se o documento não for validado ao fim de 24h após a sua conclusão será dado como inválido.

### Critério de saída:
Após assegurar que o documento respeita todas as regras, este processo termina.

###  Output:
Documento validado, pronto para fazer merge no master, fazendo pull request.

---------
