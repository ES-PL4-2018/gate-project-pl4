# MQ_QUA_TEMPLATE_CREATION


#### TABELA DE VERSÕES

| Versão | Data | Autores | Descrição
|---|---|---|---
|0.1 | 2018/09/25 | jmsoares | Criação processo
|0.2 | 2018/09/26 | jmsoares | Revisão processo

<br>

#### DESCRIÇÃO DO PROCESSO

Este processo serve para gerir e garantir um processo de qualidade na criação de templates para uniformizar a criação de artefatos do projeto

<br>

#### RESPONSÁVEIS

| Nome | Curso | Cargo |
|---|---|---

<br>

#### INPUTS

Dados para arquivo/registo para os quais não exista um template aprovado

<br>

### CRITÉRIO DE ATIVAÇÃO/TRIGGER

Sempre que exitam dados/artefatos a serem arquivados que não se enquadrem em nenhum template disponível

<br>

### DESCRIÇÃO DAS TAREFAS

1. Discução da estrutura mais indicada de suporte aos dados e seu enquadramento (listas, tabelas, esquemas, criação de estatistica etc)
2. Deverá ser criado um template utilizando o modelo de estrutura base com a codificação QUA_TEMPLATE_STRUCT, com "dummy data" para prova de conceito
3. Aprovação do template pela QUA (Se não aprovado volta ao ponto 1)
4. Caso seja considerado necessário pela QUA deverá ser criado igualmente um processo para normalizar a utilização do template, referir ao processo QA_TEMPLATE_ProcessDesc_v0
5. Codificação do templeate pela QUA

<br>

### CICLO DE VIDA DOS ARTEFACTOS

1. Novo template criado (Draft)
2. Verificação pela QUA (Se não aprovado volta ao ponto 1)
3. Template aprovado pela QUA é codificado
4. Arquivo no GIT para utilização pela equipa;

<br>

### OUTPUTS

Template de suporte aos dados devidamente codificado e arquivado no GIT do projeto

<br>

### CRITÉRIO DE SAÍDA

Aprovação do template pela QUA e sua codificação para arquivo

<br>

### MÉTRICAS

- Nº de revisões que o template foi sujeito para aprovação
- Nº horas esforço para conclusao da tarefa