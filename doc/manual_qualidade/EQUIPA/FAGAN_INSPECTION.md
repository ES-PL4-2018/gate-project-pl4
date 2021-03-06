# FAGAN INSPECTION

**DOC ID:** FAGAN_INSPECTION

| UNIDADE | COORDENADOR |
|:---:|:---:|
| QUA | Maria Pereira|

#### TABELA DE VERSÕES

| Versão | Data | Autor(es) | Descrição
|:---:|:---:|:---:|---
| 0.1 | 10/11/2018 | João Soares | Rascunho inicial |
| 1.0 | 12/11/2018 | João Soares | Alteração da descrição + critério entrada |
| 1.1 | 15/11/2018 | Maria Pereira | Alterações |
| 1.2 | 09/12/2018 | Sergii Mykolyshyn | Alterações de acordo com indicações do coordenador

#### DESCRIÇÃO DO PROCESSO

Este processo regula a realização de inspeções formais aos artefactos com o intuito de diminuir o número de defeitos no produto final, como, tão breve quanto possivel, encontrar os defeitos perto da sua criação de forma a dimuir o seu impacto no produto ou produtos relacionados.

Para a execução deste processo deve ser definido um grupo de trabalho constituido no mínimo por 3 elementos (moderador, inspetor e  autor do documento (um representante, nas situações em que existam vários autores)), no entanto caso seja tido como necessário podem ser convidados mais inspectores a integrar o grupo.

Todos os inspectores do grupo, independemente do seu papel são considerados pares durante o processo de inspeção.

O objetivo de cada papel:
- Moderador: o moderador tem um papel de maior responsabilidade no processo, tendo tarefas a executar, antes, durante e depois da reunião;
  - Antes da reunião:
    - Distribuição da informação ao grupo que vai executar a inspeção (artefacto(s) a analisar, nome e respetiva versão);
    - Agendamento da reunião de inspeção;   
  - Durante a reunião:
    - Moderar a reunião garantindo que a mesma mantém a sua objetividade;
  - Após a reunião:
    - Registar a descrição da inspeção ao artefacto no relatório da reunião;
    - Efetuar follow up às correções / alterações no artefacto tendo em conta as anotações produzidas durante a reunião;
- Inspetor: Prepara a reunião e regista todas as observações que considere importantes para correção/análise por parte do autor do artefacto e moderador;
- Autor: Prepara igualmente a reunião, apontando as observações que achar pertinentes e é convidado para ajudar a contextualizar;

#### RESPONSÁVEIS

Os elementos da unidade de qualidade são os reponsáveis pela implementação deste processo na equipa.

#### INPUTS

Artefacto(s) a analisar.

#### CRITÉRIO DE ENTRADA/ATIVAÇÃO

A inicialização deste processo ocorre quando seja definida a necessidade de realizar uma inspeção a um artefacto pelo seu autor, team-lead responsável pela unidade que produziu o artefacto ou por um elemento da unidade de qualidade.

#### DESCRIÇÃO DAS TAREFAS

- Antes da reunião:
  - Criação do grupo de trabalho;
  - Atribuição dos papéis a cada inspector do grupo;
  - Moderador garante que todos os elementos têm acesso ou na sua posse cópia do artefacto / versão a ser analisado;
  - Todos os elementos devem ler o documento e preparar a inspeção, registando as anotações no template existente para o efeito (encontra-se publicado no manual de qualidade na secção de templates com a codificação fagan_inspection_solo_report);
  - Moderador marca a reunião de inspeção tendo em conta a disponibilidade de todos os elementos;
    - A marcação da reunião de inspeção deve seguir os pontos defenidos na escolha de data, hora e sitio descritos no processo de reuniões da equipa;
  - Moderador deve garantir que a reunião só deve ser realizada se todos os elementos tiverem efectuado a devida preparação, caso contrário deve reagendar;
- Durante a reunião:
  - Cada elemento presente informa os defeitos que encontrou;
    - Caso não fique esclarecido se se trata efetivamente ou não de um defeito, o mesmo deve ser registado para futura verificação por parte do autor;
  - O moderador regista os defeitos/dúvidas encontradas no artefacto no template existente para o efeito (encontra-se publicado no manual de qualidade na secção de templates com a codificação fagan_inspection_meeting_report);
- Após a reunião:
  - Autor procede às alterações necessárias ao artefacto caso seja necessário e conforme o relatório da reunião de inspeção, notificando o moderador através de uma mensagem direta no slack quando tenha concluido o rework de forma a permitir o follow up do moderador ás alterações produzidas;
  - Moderador valida o documento alterado pelo autor.

#### CICLO DE VIDA DOS ARTEFACTOS

Todos os artefactos gerados devem seguir o processo de gestão do ciclo de vida dos artefactos.

#### OUTPUTS

- Relatórios de inspeção individuais de cada elemento;
- Relatório da reunião de inspeção.

#### CRITÉRIO DE SAÍDA

Este processo é finalizado quando se verifica uma das seguintes condições:
- O artefacto ficou aprovado;
- Após follow up do moderador ao artefacto que ficou aprovado com defeitos e foram positivamente verificadas as alterações produzidas;
- Após nova inicialização deste processo assim que o autor proceda ás correções necessárias no seguimento de um artefacto que foi reporovado.

#### MÉTRICAS DE AVALIAÇÃO

- Nº de elementos do grupo de trabalho;
- Duração da reunião de inspeção;
- Nº defeitos encontrados por classificação;
- Nº de inspecções a que o artefacto foi sujeito sem ter obtido pelo menos 1 aprovação até ao momento.

#### APROVAÇÃO E VALIDAÇÃO

A unidade de QUA está encarregue da validação deste processo devendo monitorizar as suas métricas e verificar junto dos intervenientes sugestões de pontos a serem corrigidos no processo de forma a fazer uma avaliação e alteração do processo caso necessário no sentido de melhoria e evolução constante.
