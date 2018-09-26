# MQ_QUA_TEMPLATE_CREATION


#### TABELA DE VERSÕES

| Versão | Data | Autores | Descrição
|---|---|---|---
|0.1 | 2018/09/25 | jmsoares | Criação processo

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

Deverá ser criado um template utilizando o modelo de estrutura base com a codificação QUA_TEMPLATE_STRUCT

<br>

### CICLO DE VIDA DOS ARTEFACTOS

1. Discução da estrutura mais indicada de suporte aos dados e seu enquadramento (listas, tabelas, esquemas, criação de estatistica etc)
2. Elaboração do template com "dummy data" para prova de conceito;
3. Aprovação do template pela QUA (em caso de não aceite, volta ao ponto 1);
4. Codificação do template e arquivo no git;

<br>

### OUTPUTS

Template de suporte aos dados devidamente codificado e arquivado no GIT do projeto

<br>

### CRITÉRIO DE SAÍDA

Aprovação do template pela QUA e sua codificação para arquivo

<br>

### MÉTRICAS

Nº de revisões que o template foi sujeito para aprovação
Nº horas esforço para conclusao da tarefa