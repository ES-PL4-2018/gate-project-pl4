# REUNIÕES

**DOC ID:** EQUIPA_REUNIOES

| UNIDADE | COORDENADOR |
|---------|-------------|
|   QUA   |João Soares|

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|---|---|---|---
|0.1 | 25/09/2018 | Pedro Fernandes | Criação processo|
|1.0|03/10/2018|Madalena Santos|Alterações + validação|
|2.0|20/10/2018|Pedro Fernandes|Revisão, edição e aprovação|
|3.0|14/11/2018|Pedro Fernandes|Edição conforme o relatório da inspecção elaborada pela unidade de Qualidade (incorporação dos processos de tomada de decisões e atas neste processo)|

#### DESCRIÇÃO DO PROCESSO

Este processo gere a marcação de reuniões, a sua ocorrência e todo o registo documental efectuado.

#### RESPONSÁVEIS

Todos os elementos da equipa.

#### INPUTS

* Ordem de trabalhos;
* *Template* para a ata da reunião.

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO

Este processo é ativado sempre que exista a necessidade de reunir para discutir a ordem de trabalhos.

#### DESCRIÇÃO DAS TAREFAS
* Escolha da data, hora e sítio da reunião:
	* Através da plataforma *doodle*, cada um dos convocados pode seleccionar o *slot* correspondente à data e hora mais conveniente;
	* O link para o *doodle* deve ser publicado no canal do *Slack* onde integrem todos os convocados para a reunião;
	* Deve ser escolhida a data e a hora de acordo com as disponibilidades recolhidas de todos os convocados, tentando sempre que haja a maior adesão possível;
	* O sítio deve ser escolhido pelo presidente da reunião e anunciado no canal do *Slack*, juntamente com a ordem de trabalhos para a reunião.
* Deve ser nomeado pelo menos um elemento responsável pela anotação dos acontecimentos da reunião e pela redação da ata, sendo que na ata ficam registas as discussões sobre os diversos pontos da ordem de trabalhos, bem como as decisões tomadas.

#### OUTPUTS

* Ata da reunião, que deve ser realizada até 24h após a ocorrência da reunião;
* As decisões mais importantes devem ser partilhadas no respetivo canal do *Slack* aquando a ausência de parte dos convocados, para permitir que toda a unidade/equipa seja atualizada e possa opinar sobre os assuntos abordados.

#### CRITÉRIO DE SAÍDA

* Conclusão da reunião e arquivamento da ata no *branch* QUA_DOC.

#### MÉTRICAS DE AVALIAÇÃO

* Número de convocados *vs* Número de presenças;
* Tempo gasto para abordar todos os tópicos;
* Número de decisões por tempo gasto.

#### APROVAÇÃO E VALIDAÇÃO

A ata da reunião deve ser publicada na plataforma *GitHub* (até 24h depois da realização da reunião) num novo *branch* biforcado do *branch* relativo aos documentos da QUA. Aquando a aprovação por parte da equipa e do *leader* da equipa, deve ser feito um *pull request* para o *branch* QUA_DOC. Este PR é aprovado depois de ser feita a validação da ata pela equipa da Qualidade, permitindo a arquivação definitiva do documento.