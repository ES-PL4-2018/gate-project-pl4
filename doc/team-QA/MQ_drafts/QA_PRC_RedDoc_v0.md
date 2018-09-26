REDAÇÃO DE UM DOCUMENTO
======

###DOC ID: QA\_PRC\_RedDoc\_v0

### TABELA DE VERSÕES



| VERSÃO | DATA | AUTORES | DESCRIÇÃO |
|--------|------|---------|-----------|
|0.1|26/09|Madalena|Rascunho inicial|



### DESCRIÇÃO DO PROCESSO

Este processo é utilizado sempre que existe a necessidade de redação de um documento, independentemente do tipo de documento. Todos os documentos formais/técnicos têm que seguir certos parâmetros. Qualquer membro de qualquer unidade pode estar envolvido neste processo.

Na fase final do processo, o documento tem que ser aprovado pelos responsáveis e validado pela unidade de QA.


### RESPONSÁVEIS


| NOME | CURSO | CARGO |
|------|-------|-------|
| Madalena |LEI|Teamlead QA
<o coordenador é o coordenador da unidade, os colaboradores são os elementos da mesma unidade que contribuiram para a descrição do processo>


### INPUTS

* Informações necessárias à redação do documento



### CRITÉRIO DE ATIVAÇÃO/TRIGGER

* Este processo inicia-se quando existe a necessidade de redação de um documento, quer seja um relatório, uma ata, ou o produto final de um outro processo.



### DESCRIÇÃO DAS TAREFAS

* Redação de documento segundo as seguintes regras:
	* Todos os documentos de texto devem estar no formato Markdown (.md)
	* Todos os documentos técnicos de maior relevância devem possuir uma página de rosto com informações sobre a natureza do documento, o(s) autor(es) e um contacto.
	* Todos os documentos técnicos devem possuir um cabeçalho, onde sejam disponbilizadas as informações sobre o título do documento, a unidade em que está inserido (caso aplicável) e a referência única do documento ("UNIDADE\_TIPO-DE-DOC\_NOME-DO-DOC\_VERSÃO);
	* Todos os documentos devem ter uma designação apropriada (comum com a referência única do documento);
	* Todos os documentos técnicos devem possuir uma Tabela de Versões onde sejam descriminadas todas as modificações relevantes feitas ao longo do tempo:

		| VERSÃO | DATA | AUTORES | DESCRIÇÃO |
		|--------|------|---------|-----------|
		|||||
	* Todos os documentos técnicos devem ter uma formatação limpa e legível, sem erros ortográficos, devem ser coerentes e ter paginação (ver documentação ![Pandoc]());
	* Os documentos mais extensos devem-se fazer acompanhar de um índice;
	* Caso aplicável, o documento deve fazer-se acompanhar de introdução, conclusão, anexos, referências, lista de acrónimos;
	* Documentos do tipo ata, relatório de esforço, documentos de revisão de documentos, descrição formal de um processo ou de uma unidade devem seguir modelos específicos disponibilizados no repositório *GitHub* da equipa;
	* Todas as expressões estrangeiras devem estar em *itálico*.

	
* Após a redação do documento:
	* O documento deve ser sempre aprovado por todas as pessoas que contribuiram para a sua redação;
	* Posteriormente, deve ser aprovado pelo *team lead* da equipa responsável;
	* Finalmente, qualquer documento é validado pela equipa de Qualidade, onde são verificados todos os parâmetros formais do processo;
	* NOTA: É necessário notificar as equipas respetivas aquando a fase de aprovação/validação, para que estas possam prosseguir aos processos.




### CICLO DE VIDA DOS ARTEFACTOS

1) O documento é redigido;
2) O documento é aprovado pela equipa. Caso existam modificações a fazer, seguir passo 1);
3) O documento é validado pela QA. Caso existam modificações a fazer, seguir passo 1);
4) O documento é arquivado.

(acrescentar esquema visual)


### OUTPUTS

* O documento que foi redigido;
* O relatório de esforço aplicado para esta tarefa.


### CRITÉRIO DE SAÍDA


* O processo termina quando o documento estiver aprovado e validado, e for dado como definitivo.



### MÉTRICAS

* Nº de horas dispendidas na readação do documento;
* Nº de erros encontrados nas várias revisões do documento;



### APROVAÇÃO E VALIDAÇÃO

* O documento é aprovado por toda a unidade responsável, e posteriormente validado pela unidade de QA.





