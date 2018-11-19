# CICLO VIDA ARTEFACTO

**DOC ID:** CICLO_VIDA_ARTEFACTO

| UNIDADE | COORDENADOR
|:-:|:-:
| QUA |João Soares

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|:-:|:-:|:-:|---
| 0.1 | 14/11/2018 | Carlos Poiares | Criação do documento
| 0.2 | 18/11/2018 | Carlos Poiares | Revisão do documento: Alterações de forma e estrutura
| 0.3 | 19/11/2018 | João Soares | Criação diagrama, reformulação tarefas

#### DESCRIÇÃO DO PROCESSO

Este processo é responsável por descrever o ciclo de vida de um artefacto e definir guide lines para a sua criação, sendo ortogonal a toda a equipa, exceptuando-se o código fonte que não tem template definido e a sua validação formal passa pelas ferramentas de análise de código integradas no *GitHub* que fazem análise automática

#### RESPONSÁVEIS

Todos os elementos da equipa são responsáveis pela execução deste processo

#### INPUTS

- Informação a registar
- Templates e normas publicadas no Manual de Qualidade

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO

Necessidade de criar um artefacto

#### DESCRIÇÃO DAS TAREFAS

- Criar um branch no repositório da equipa seguindo a partir do branch QUA_DOC e nomeando-o segundo a norma existente (ou se cria uma secção especifica ou então mete-se numa secção aqui no manual onde se regula tudo o que seja os nomes de documentos e afins)
- Escolher o template adequado existente no manual de qualidade em secção pŕopria, após análise da informação a registar e a sua origem
- Criar o artefacto nomeando-o segundo a norma existente
- Criar um _Pull Request_ no _GitHub_ com o nome do artefacto criado e solicitar revisão técnica ao Team-Lead ou Co-Lead da unidade que está a produzir o artefacto, no caso de uma acta deverá ser solicitada revisão técnica ao moderador / presidente da reunião. A revisão deverá ser solicitada ao elemento atravéz da _feature_ do _GitHub_ para o efeito, adicionando-o á lista de _Reviewers_
- Após revisão técnica:
	- Caso tenha sido aprovado, deverá o _reviewer_ registar a sua aprovação no _Pull Request_, e em seguida solicitar revisão formal á unidade de qualidade atravéz da _feature_ do _GitHub_ para o efeito, adicionando-a á lista de _Reviewers_
	- Caso existam correções a efetuar, deverá o _reviewer_ registar a informação que considerar pertinente nas linhas do documento e fazer um pedido de alterações no _Pull Request_, atribuido-o ao autor do documento, utilizando a lista de _Assignees_
- Após revisão formal:
	- Caso tenha sido aprovado, o _Pull Request_ é fechado e as alterações do _branch_ são _merged_ com o _branch_ da documentação conforme solicitado
	- Caso existam correções a efetuar, deverá o _reviewer_ registar a informação que considerar pertinente nas linhas do documento e fazer um pedido de alterações no _Pull Request_, atribuido-o ao autor do documento, utilizando a lista de _Assignees_ caso ainda não esteja adicionado o autor

###### Diagrama:

![cva](EQUIPA/ciclo_vida_artefacto.png)

#### OUTPUTS

- Artefacto arquivado no repositório da equipa no _branch_ da documentação.
- *Pull Request* fechado e arquivado.

#### CRITÉRIO DE SAÍDA

- Validação formal positiva pela unidade de qualidade.

#### MÉTRICAS DE AVALIAÇÃO

- Número de horas envolvidas no processo.
- Número de reprovações na validação técnica
- Número de reprovações na validação formal.
- Número de erros total de todas as reprovações (equivalente ao número de linhas assinaladas para correção no *Pull Request*).

#### APROVAÇÃO E VALIDAÇÃO

Após a aprovação da equipa responsável, a aprovação final e respectiva validação é feita pela equipa de Qualidade.
