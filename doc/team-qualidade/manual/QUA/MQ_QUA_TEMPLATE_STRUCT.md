# CRIAÇÃO DE UM TEMPLATE

**DOC ID:**  MQ_QUA_TEMPLATE_STRUCT_v0.2

#### TABELA DE VERSÕES

| Versão | Data | Autores | Descrição
|---|---|---|---
|0.1 | 2018/09/25 | jmsoares | Criação processo
|0.2 | 2018/09/26 | jmsoares | Revisão processo
|0.3 | 2018/10/04 | Sergii | Revisão

<br>

#### DESCRIÇÃO DO PROCESSO

Gerir e garantir um processo de qualidade na criação de *templates* para uniformizar a criação de artefactos do projeto.

<br>

#### RESPONSÁVEIS

| Nome | Curso | Cargo |
|---|---|---

<br>

#### INPUTS

Dados para arquivo/registo para os quais não exista um *template* aprovado.

<br>

### CRITÉRIO DE ATIVAÇÃO/TRIGGER

Sempre que existam dados/artefactos a serem arquivados que não se enquadrem em nenhum *template* disponível.

<br>

### DESCRIÇÃO DAS TAREFAS

1. Discussão da estrutura mais indicada de suporte aos dados e seu enquadramento (listas, tabelas, esquemas, criação de estatística, etc);
2. Deverá ser criado um *template* utilizando o modelo de estrutura base com a codificação QA_TEMPLATE_STRUCT, com "dummy data" para prova de conceito;
3. Aprovação do *template* pela QA (Se não aprovado volta ao ponto 1);
4. Caso seja considerado necessário pela QA, deverá ser criado igualmente um processo para normalizar a utilização do *template*, referir ao processo QA_TEMPLATE_ProcessDesc_v0;
5. Codificação do *template* pela QA.

<br>

### CICLO DE VIDA DOS ARTEFACTOS

1. Novo *template* criado (*Draft*):
2. Verificação pela QA (Se não aprovado volta ao ponto 1);
3. *Template* aprovado pela QA é codificado;
4. Arquivo no *github* para utilização pela equipa;

<br>

### OUTPUTS

*Template* de suporte aos dados devidamente codificado e arquivado no *github* do projeto.

<br>

### CRITÉRIO DE SAÍDA

Aprovação do *template* pela QA e sua codificação para arquivo.

<br>

### MÉTRICAS

* Nº de revisões a que o *template* foi sujeito para aprovação;
* Nº horas esforço para conclusão da tarefa.
