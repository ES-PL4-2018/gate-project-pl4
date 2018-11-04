# CRIAÇÃO DE UM TEMPLATE

**DOC ID:**  QUA_TEMPLATE_BUILD

| UNIDADE | COORDENADOR |
|---------|-------------|
|    QUA   | João Soares |

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|---|---|---|---
|0.1 | 25/09/2018 | jmsoares | Criação processo
|0.2 | 26/09/2018 | jmsoares | Revisão processo
|0.3 | 04/10/2018 | Sergii | Revisão
|1.0 | 20/10/2018 | Pedro Fernandes | Revisão, edição e aprovação

#### DESCRIÇÃO DO PROCESSO

Gerir e garantir um processo de qualidade na criação de *templates* para uniformizar a criação de artefactos do projeto.

#### RESPONSÁVEIS

Qualquer membro de qualquer unidade pode ser responsável por criar um *template*.

#### INPUTS

Dados para arquivo/registo para os quais não exista um *template* aprovado.

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO

Sempre que existam dados/artefactos a serem arquivados que não se enquadrem em nenhum *template* disponível.

#### DESCRIÇÃO DAS TAREFAS

1. Discussão da estrutura mais indicada de suporte aos dados e seu enquadramento (listas, tabelas, esquemas, criação de estatística, etc);
2. Deverá ser criado um *template* utilizando o modelo de estrutura base com a codificação QA_TEMPLATE_STRUCT, com "dummy data" para prova de conceito;
3. Aprovação do *template* pela QUA (Se não aprovado volta ao ponto 1);
4. Caso seja considerado necessário pela QUA, deverá ser criado igualmente um processo para normalizar a utilização do *template*, referir ao processo QA_TEMPLATE_ProcessDesc;
5. Codificação do *template* pela QUA.

#### CICLO DE VIDA DOS ARTEFACTOS

1. Novo *template* criado (*Draft*);
2. Verificação pela QUA (Se não aprovado volta ao ponto 1);
3. *Template* aprovado pela QUA é codificado;
4. Arquivo no *github* para utilização pela equipa.

#### OUTPUTS

*Template* de suporte aos dados devidamente codificado e arquivado no *github* do projeto.

#### CRITÉRIO DE SAÍDA

Aprovação do *template* pela QUA e sua codificação para arquivo.

#### MÉTRICAS DE AVALIAÇÃO

* Nº de revisões a que o *template* foi sujeito para aprovação;
* Nº horas esforço para conclusão da tarefa.