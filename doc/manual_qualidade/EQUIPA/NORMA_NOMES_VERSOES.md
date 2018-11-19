# NORMA NOMES VERSÕES

**DOC ID:** NORMA_NOMES_VERSOES

| UNIDADE | COORDENADOR
|:-:|:-:
| QUA |João Soares

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|:-:|:-:|:-:|---
| 1.0 | 18/11/2018 | João Soares | Criação do documento

#### DESCRIÇÃO

##### Nomes

Esta norma serve para guiar as nomeções a dar aos diferentes artefactos da equipa, *Pull Requests* e *Branches* no *GitHub*.

As regras que se seguem devem ser aplicados pela ordem da lista no que toca a nomes:
1. No caso de um artefacto produzido no decorrer de um processo onde esteja definida uma nomenclatura especifica, deve ser usada não sendo necessário a aplicação das restantes regras
2. Todo e qualquer artefacto,*branch* ou *Pull Request* criado, exceptuando-se código fonte, no *scope* do trabalho de uma unidade em especifico deve sempre começar pelo acrónimo da unidade
3. Em seguida deve seguir o acrónimo de tipo documento, no caso dos artefactos, ou o tipo de operação, no caso de *Pull Requests* e *Branches* 
4. Por fim deve vir o nome do artefacto, deve ser curto e claro, representando claramente o seu conteúdo.
5. No caso de artefactos que sejam relativos a uma determinada semana de uma sprint devem ainda conter essa informação na seguinte forma: Wx_Sy, onde x representa o numero da semana dentro da sprint y.
6. Os vários componentes devem ser separados por \_.

No caso de documentos gerais à equipa, como atas, deve ser a nomenclatura inidicada no numero 2, seguida de GERAL, aplicando-se as restantes regras.

Em caso de necessidade ou para melhor enquadramento, podem, pontualmente ser utilizadas outras nomenclaturas desde que aprovado pela QUA. Nessas situações o team-lead da unidade que pretende produzir tal nomenclatura deve entrar em contacto com o team-lead da QUA através de mensagem direta no Slack.

###### Exemplos:

Artefactos:

|Nomenclatura|Descrição
|:---:|---
ATA_GERAL_W2_S3|Ata de uma reunião geral "Aula" da equipa na 2ª semana da 3ª sprint
QUA_ATA_W1_S2|Ata de reunião da QUA da semana 1 da sprint 2
GES_REL_ACOMPAHAMENTO|Relatorio de acompanhamento elaborado pela GES

*Branches* e *Pull Requests*:

|Nomenclatura|Descrição
|:---:|---
TST_REL_TESTES_XYZ|*Branch* ou *Pull Request* de TST para integração da 
REQ_ACT_MockUps|*Branch* ou *Pull Request* de REQ da atualização de mockups 
GES_REL_ACOMPANHAMENTO|*Branch* ou *Pull Request* de GES para elaboração de um relatório de acompanhamento


###### Tabela Acrónimos

| Acrónimo | Descrição
| :-: |---
|GES|Unidade Gestão
|REQ|Unidade Requisitos
|IMP|Unidade Implementação
|TST|Unidade Testes
|QUA|Unidade Qualidade
|ENV|Unidade Ambiente
|RcH|Recursos Humanos
|ISP|Inspeção (Fagan Inspection)
|RSC|Risco
|REL|Relatório
|DOC|Documento
|REV|Revisão
|ATA|Acta
|ACT|Actualização
|MOD|Modelo/*Template*

##### Versões

1. A versão de qualquer documento deve começar pela 0.1
2. Á medida que se fazem várias alterações, itera-se uma décima
3. Aquando a finalização da criação do documento e passagem para verificação técnica, a versão passa a 1.0
4. Em diante todas as alterações efetuadas, desde que não alterem estrutura do documento ou a sua orientação técnica devem iterar a versão em uma décima, todas as alterações a um total superior a 30% das linhas, estrutura ou orientação técnica, deve o documento iterar a versão em uma unidade.
