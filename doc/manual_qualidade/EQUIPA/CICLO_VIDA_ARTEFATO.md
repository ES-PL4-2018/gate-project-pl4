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
| 0.4 | 26/11/2018 | Pedro Fernandes| Revisão: Alterações do conteúdo e correções ortográficas

#### DESCRIÇÃO DO PROCESSO

Este processo é responsável por descrever o ciclo de vida de um artefacto e definir _guidelines_ para a sua criação, sendo ortogonal a toda a equipa, excepto o código fonte que não tem template definido e a sua validação formal passa pelas ferramentas de análise de código integradas no *GitHub* que fazem análise automática.

#### RESPONSÁVEIS

Todos os elementos da equipa são responsáveis pela execução deste processo.

#### INPUTS

- Informação a registar;
- Templates e normas publicadas no Manual de Qualidade.

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO

Necessidade de criar um artefacto.

#### DESCRIÇÃO DAS TAREFAS

- Criar um branch no repositório da equipa seguindo a partir do branch QUA_DOC e nomeando-o segundo a norma existente (ou se cria uma secção especifica ou então mete-se numa secção aqui no manual onde se regula tudo o que seja nomes de documentos e afins);
- Após a análise da informação a registar e a sua origem, escolher o template adequado existente no manual de qualidade em secção pŕopria;
- Criar o artefacto nomeando-o segundo a norma existente;
- Criar um _Pull Request_ no _GitHub_ com o nome do artefacto criado e colocar a tag correspondente à unidade do autor, de seguida solicitar a revisão técnica ao _Team-Lead_ ou _Co-Lead_ da unidade que está a produzir o artefacto, no caso de uma ata deverá ser solicitada revisão técnica ao moderador / presidente da reunião. A revisão deverá ser solicitada ao elemento através da _feature_ do _GitHub_ para o efeito, adicionando-o à lista de _Reviewers_.
- **Após revisão técnica:**
    - Caso existam correções a efetuar, o _reviewer_ deve registar a informação que considera pertinente nas linhas do documento e fazer um pedido de alterações no _Pull Request_, atribuindo-o ao autor do documento, utilizando a lista de _Assignees_, e colocando a _tag_ de _rework_;
	- Caso tenha sido aprovado, o _reviewer_ deve registar a sua aprovação no _Pull Request_, e em seguida solicitar revisão formal à unidade de Qualidade, através da _feature_ do _GitHub_ para o efeito, adicionando-a à lista de _Reviewers_.
	
- **Após revisão formal:**
 	- Caso existam correções a efetuar, o _reviewer_ deve registar a informação que considera pertinente nas linhas do documento e fazer um pedido de alterações no _Pull Request_, atribuindo-o ao autor do documento, caso ele ainda não tenha sido adicionado, utilizando a lista de _Assignees_, e colocando a _tag_ de _unconformity_;
	- Caso tenha sido aprovado, o _Pull Request_ é fechado e as alterações do _branch_ são _merged_ com o _branch_ da documentação conforme solicitado.


###### Diagrama:

![cva](ciclo_vida_artefacto.png)

#### OUTPUTS

- Artefacto arquivado no repositório da equipa no _branch_ da documentação;
- *Pull Request* fechado e arquivado.

#### CRITÉRIO DE SAÍDA

- Validação formal positiva pela unidade de Qualidade.

#### MÉTRICAS DE AVALIAÇÃO

- Número de horas envolvidas no processo;
- Número de reprovações na validação técnica;
- Número de reprovações na validação formal;
- Número de erros total de todas as reprovações (equivalente ao número de linhas assinaladas para correção no *Pull Request*).

#### APROVAÇÃO E VALIDAÇÃO

Após a aprovação da equipa responsável, a aprovação final e respectiva validação é feita pela equipa de Qualidade.