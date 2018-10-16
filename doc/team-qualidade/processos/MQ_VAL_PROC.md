# VALIDAÇÃO DE PROCESSOS

**DOC ID:** MQ\_VAL\_PROC\

#### TABELA DE VERSÕES
| VERSÃO | DATA | AUTORES | DESCRIÇÃO |
|-|-|-|-|
| 0.1 | 25/09/2018 | Sergii Mykolyshyn | Criação do processo |
| 0.2 | 04/10/2018 | Maria Pereira | Alterações |
| 1.0 | 16/10/2018 | Sergii Mykolyshyn | Reestruturação e alterações

## DESCRIÇAO DO PROCESSO
O processo relata qual a metodologia para validação de processos.

## INPUTS
* Cards do *Trello* criadas;
* Documentos validados / em processo de validação;
* Commits no *GitHub*.

## CRITÉRIO DE ATIVAÇÃO/TRIGGER
* Realizado sempre que houver um processo a ser validado.

## DESCRIÇÃO DAS TAREFAS
Quando se pretende validar um processo, deve-se ir ao *Trello* e selecionar a card com a qual se vai trabalhar. Cada card corresponde a um pull request, pelo que é necessário verificar o histórico de pull requests no *GitHub*, para ver se existe algum a ser aprovado. Caso o processo não tenha inconformidades, deve-se aprovar o seu pull request e atualizar a card do *Trello*. Caso contrário, deve-se recusar o pull request (quem o criou é notificado) e criar uma card no Trello da respetiva unidade, avisando que o processo deve ser corrigido.

## OUTPUTS
* Relatório de acompanhamento (deve ser seguido o template fornecido);
* Processo validado, se for revisto e o seu pull request aprovado;
* Card no Trello da unidade responsável pelo processo, se este tiver erros.

## CRITÉRIO DE SAÍDA
* Criação do relatório e comunicação à unidade responsável para a correção das não conformidades.

## MÉTRICAS
* Nº de inconformidades encontradas na revisão de processos;
* Nº de processos validados;
* Nº de cards verificadas;
