# VALIDAÇÃO DE PROCESSOS

**DOC ID:** QUA_VALIDACAO_DOCS

#### TABELA DE VERSÕES
| VERSÃO | DATA | AUTORES | DESCRIÇÃO |
|-|-|-|-|
| 0.1 | 25/09/2018 | Sergii Mykolyshyn | Criação do processo |
| 0.2 | 04/10/2018 | Maria Pereira | Alterações |
| 0.3 | 16/10/2018 | Sergii Mykolyshyn | Reestruturação e alterações
|1.0|16/10/2018|João Soares|Revisão e Aprovação

## DESCRIÇAO DO PROCESSO
O processo relata qual a metodologia para validação de artefactos.

## INPUTS
* Cards do *Trello* criadas;
* Documentos validados / em processo de validação;
* Commits no *GitHub*.

## CRITÉRIO DE ATIVAÇÃO/TRIGGER
* Realizado sempre que houver um processo a ser validado.

## DESCRIÇÃO DAS TAREFAS
Quando se pretende validar um artefacto, deve-se ir ao *Trello* e selecionar a card com a qual se vai trabalhar. Cada card corresponde a um pull request, pelo que é necessário verificar o histórico de pull requests no *GitHub*, para ver se existe algum a ser aprovado. Caso o artefacto não tenha inconformidades, deve-se aprovar o seu pull request e atualizar a card do *Trello*. Caso contrário, deve-se recusar o pull request (quem o criou é notificado) e criar uma card no Trello da respetiva unidade, avisando que o artefacto deve ser corrigido.

## OUTPUTS
* Resultado da validação (arquivado no histórico do pull request)
* Artefacto validado, se for revisto e o seu pull request aprovado;
* Card no Trello da unidade responsável pelo artefacto, se este tiver erros.

## CRITÉRIO DE SAÍDA
* Aquando a validação do pull request do(s) referido(s) artefacto(s)

## MÉTRICAS
* Nº de inconformidades encontradas na revisão de processos;
* Nº de processos validados;
* Nº de cards verificadas;
