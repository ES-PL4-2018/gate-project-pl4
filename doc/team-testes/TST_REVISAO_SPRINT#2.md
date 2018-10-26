## Resultados de Testes Sprint #2 - versão 0.2.1 da app
#### DOC ID: TST_TEMPLATE_REVISAO_SPRINT#2

#### # Sprint: #

#### Data: 26/10
#### Versão: 0.2.1

### Edição

| Rev # | Autor | Descrição            | Data  |
| ----- | ----- | -------------------- | ----- |
| 0.1   | JC    | Redação do documento | 26/10 |
| 0.2   | RP    | Redação do documento | 26/10 |
| 0.3   | CM    | Redação do documento | 26/10 |
| 0.4   | PS    | Redação do documento | 26/10 |
| 0.5   | JS    | Redação do documento | 26/10 |

### Descrição do Processo:
Este documento é usado para anotar os testes realizados, e mostrar o progresso dos testes ao longo da sprint.

### Responsáveis
| Nome            | Curso | Cargo       |
| --------------- | ----- | ----------- |
| Jessica Cunha   | LEI   | Coordenador |
| Catarina Mestre | LEI   | Colaborador |
| João Oliveira   | LEI   | Colaborador |
| João Silva      | LEI   | Colaborador |
| Pedro Sá        | LEI   | Colaborador |
| Ricardo Paiva   | LEI   | Colaborador |

# Hiperligações

[Descrição dos testes](Descrição-dos-testes)

[Revisão de Tarefas](Revisão-de-Tarefas)

[Conclusão](Conclusão)




### Descrição dos testes

| Requisito # | Testes Realizados                                            | Elemento |
| ----------- | ------------------------------------------------------------ | -------- |
| Req 1.1     | Não deve aceitar números nos nomes de registo.                | CM       |
| Req 1.4     | O utilizador deve introduzir uma instituição à qual está filiado. | PS,JS    |
| Req 1.5     | O utilizador pode associar-se a uma ou mais Research Units.   | JO       |
| Req 1.7     | No registo devem ser sugeridos temas de interesse populares ao utilizador. | RP       |
| Req 1.8     | O user deve poder selecionar(escrever) os seus temas.         | PS       |
| Req 1.9     | O user pode cancelar o registo a qualquer momento.           | CM       |
| Req 1.10    | O user insere um mail válido.                                 | JC       |
| Req 1.11    | No registo, o user cria um username e password.               | PS       |
| Req  1.13   | Sugestão da recuperação da password a quem erre mais do que 3 vezes. | JS       |
| Req 2.1     | Cada post no feed de notícias apresenta a foto e o nome de quem o postou, assim como o seu conteúdo. | CM       |
| Req 2.2     | Os posts no feed de notícias são apresentados como tweets.   | JC       |
| Req 2.3     | O ecrã do feed de notícias apresenta uma barra inferior com 2 botões dão acesso ao perfil e bookmarks. | PS       |
| Req 2.4     | Deve existir uma maneira de aceder ao perfil pessoal a partir do feed de notícias. | JS       |
| Req 2.5     | O utilizador consegue aceder ao perfil deslizando pro lado esquerdo. | PS       |
| Req 2.6     | O símbolo de bookmarks redireciona para a lista de bookmarks. | RP       |
| Req 2.7     | O utilizador consegue aceder à lista de bookmarks deslizando pro lado direito. | CM       |
| Req 2.8     | Conectar a aplicação ao twitter e extrair tweets específicos. | JC       |
| Req 2.10 |    2.10 Caso um tweet contenha um link este deve ser aberto num browser. |  JS    |
| Req 2.11 |   Apresentar no feed imagens presentes no link do tweet. | PS |
| Req 3.1 |O perfil do utilizador contém: O seu nome, instituição, research unit(s), temas de interesse e uma fotografia.|CM|
| Req 3.2 |Estando no seu perfil, pode retroceder para a página do feed.| JM       |
| Req 3.3 | O utilizador pode editar o seu perfil. |   JO       |
| Req 3.5 |O utilizador pode efetuar logout através de um botão no perfil.| PS         |
| Req 3.6 |O logout redireciona o utilizador para a página de login.|   RP       |
| Req 4.1 |É apresentado um ecrã com uma lista (botões) com o nome das bookmarks.|   CM  |
| Req 4.2 |Ao clicar no botão "+" somos redirecionados para o ecrã de criação de uma bookmark. |    JC   |
| Req 4.3 |Na criação do bookmark é pedido um título, link externo e opcionalmente hashtags. |     JC     |
| Req 4.4 |Ao clicar numa bookmark o utilizador é redirecionado para o link associado. |     JS  |
| Req 4.5 |O utilizar pode cancelar o processo de criação de uma bookmark.| PS          |


### Revisão de Tarefas

| Requisito # | Autor | Apontamentos                                                 | Data  |
| :---------: | :---- | :----------------------------------------------------------- | :---: |
|     1.1     | CM    | **Método de revisão:** Inputs de nomes com números não eram permitidos<br />**Conclusão:** Aprovado | 24/10 |
|     1.4     | JS,PS | **Método de revisão:**O utilizador é obrigado a introduzir a instituição.<br />**Conclusão: ** Aprovado | 24/10 |
|     1.5     | JO    | **Método de revisão:**Apenas é permitido ao utilizador associar-se a uma research unit. Não é permitido colocar "UC" pois apenas tem duas letras, e "Universidade de Coimbra" é muito longo <br />**Conclusão: ** Aprovado, pois é possível associar a 1, e a prioridade é média. | 25/10 |
|     1.7     | RP    | **Método de revisão:**Apenas sugerem alguns temas criados pela aplicação, não são sugestões populares<br />**Conclusão: ** Reprovado | 25/10 |
|     1.8     | PS    | **Método de revisão:**Não aceita temas para além dos presentes, é possível pesquisar e filtrar<br />**Conclusão: ** Reprovado | 25/10 |
|     1.9     | CM    | **Método de revisão: ** Verificar se há botões para cancelar: Existem e funcionam<br />Ver  que o user não é registado: não é<br />**Conclusão: ** Aprovado | 24/10 |
|    1.10     | JC    | **Método de revisão: ** Verificar que o mail é do formato: user@domain.tld:<br />Ver se aceita números antes do @<br/>Não pode aceitar números depois do @<br />A aplicação deixa inserir um mail válido, só não deixa colocar numeros no email<br/>**Conclusão: **Aprovado | 24/10 |
|    1.11     | PS    | **Método de revisão: ** Verificar se há botões para cancelar: Existem e funcionam; ver  que o user não é registado: não é<br />**Conclusão:** Aprovado | 25/10 |
|    1.13     | JS    | **Método de revisão: ** Não há nenhuma sugestão de recuperação de password após errar 3 vezes. Não é possível fazer recuperação de password a nenhuma altura. Após errar a password algumas vezes seguidas a aplicação tem um crash.<br />**Conclusão:** Aprovação | 26/10 |
|     2.1     | CM    | **Método de revisão:**Verificar se a foto e o nome de quem postou no feed estão corretos. Verificar se o conteúdo está correto.<br />Nota:De vez em quando, quando se faz refresh na página do feed, os dados desaparecem.<br/ >No tlm de um dos elementos (android 9) não aparecem as fotos no twitter<br/>**Conclusão: ** Aprovado | 25/10 |
|     2.2     | JC    | **Método de revisão: **Os posts no feed são apresentados como tweets relacionados com os interesses do utilizador<br />**Conclusão:** Aprovado | 26/10 |
|     2.3     | PS    | **Método de revisão: **Verificar se a foto e o nome de quem postou no feed estão corretos.: Está<br/> Verificar se o conteúdo está correto: Está<br />**Conclusão:**Aprovado | 25/10 |
|     2.4     | JS    | **Método de revisão: **Verificar se existe uma maneira de aceder ao perfil pessoal a partir do feed de notícias. Verificar se o botão acede ao perfil pessoal.<br />**Conclusão:** Aprovado | 26/10 |
|     2.5     | PS    | **Método de revisão: **Deslizar para o lado esquerdo e verificar se aparece o perfil. **Nota:** Nao é possivel aceder ao perfil deslizando para o lado esquerdo. Apenas pressionando no "Perfil"<br />**Conclusão: **Reprovado | 26/10 |
|     2.6     | RP    | **Método de revisão: **Verificar se existe o símbolo, caso exista, verificar se existe alguma interação e se esta leva para a lista de bookmarks.: Funciona<br />**Conclusão:** Aprovado | 25/10 |
|     2.7     | CM    | **Método de revisão: **Deslizar para o lado esquerdo e esperar que algo aconteça: Não acontece nada<br />**Conclusão:** Reprovado | 25/10 |
|     2.8     | JC    | **Método de revisão: **Conectar conta twitter e verificar se funcionou; verificar se é possível extrair tweets específicos.<br />**Nota:** Não dá para conectar a aplicação ao seu twitter, e os tweets estão relacionados com os temas de interesse.<br />**Conclusão: **Aprovado | 25/10 |
|    2.10     | JS    | **Método de revisão: **Verificar se ao clickar num link este é aberto num browser.<br />**Nota:** Ao clickar num tweet que contém um link, o que é aberto é o tweet e não o link quando deveria ser ao contrário.<br />**Conclusão: **Aprovado | 25/10 |
|    2.11     | PS    | **Método de revisão: **Verificar se a imagem está presente ou não.<br />**Nota:** Não está presente a imagem, com links associados (ex. youtube, foto presente, links para browser)<br />**Conclusão:** Reprovado | 25/10 |
|     3.1     | CM    | **Método de revisão: **Verificar se todos os elementos obrigatórios (nome, instituição, research unit(s), temas de interesse e uma fotografia) estao presentes; Alterar elementos e verificar novamente; acrescentar research units caso possível<br /> **Nota:**Tudo obrigatório menos a foto e caso tente retroceder ("botão" do telemóvel para trás) a meio da edição, a aplicação crasha <br />**Conclusão:** Aprovado | 25/10 |
|     3.2     | JC    | **Método de revisão: **Estando no seu perfil, pode retroceder para a página do feed. | 25/10 |
|     3.3     | JO    | **Método de revisão:** Alterar campos de nome, instituicao, research unit, research center, Research interests (acrescentar e retirar) <br />**Conclusão:** Aprovado | 25/10 |
|     3.5     | PS    | **Método de revisão:** Presente botÃo na zona de perfil que permita o logout <br />**Conclusão:** Aprovado | 25/10 |
|     3.6     | RP    | **Método de revisão:** Validação deste teste em diferentes páginas. <br />**Conclusão:** Aprovado | 25/10 |
|     4.1     | CM    | **Método de revisão:** Verificar se a página abre; verificar se as bookmarks estão bem distribuídas; verificar se o layout da página se mantém bem estruturada. <br />**Conclusão:** Aprovado | 25/10 |
|     4.2     | JC    | **Método de revisão:** Verificar se o botão "+" funciona; verificar se a janela de criação de uma bookmark abre;<br />**Nota:** Ao clicar no "+" é redirecionado para o ecrã de criação de uma bookmark<br />**Conclusão:** Aprovado | 25/10 |
|     4.3     | JC    | **Método de revisão:** Verificar se aceita links inválidos; verificar se é possível não colocar tags.<br />**Nota:**  É obrigatorio ter pelo menos uma tag com 3 carateres; aceita URL's inválidos, mas funciona quando colocado um URL válido; dá para eliminar se pressionar 2 segundos; hashtags são uma string;<br />**Conclusão:** Aprovado | 25/10 |
|     4.4     | JS    | **Método de revisão:** Verificar se ao clickar numa bookmark o utilizador é redirecionado para o link associado;<br/>**Conclusão:** Aprovado | 25/10 |
|     4.5     | PS    | **Método de revisão:** Cancelar a criação em cada uma das diferentes fases, i.e., quando insere o titulo, link etc. <br />**Conclusão:** Aprovado | 25/10 |

## Conclusão

Após a execução dos testes concluímos que a aplicação foi aprovada na maior parte dos testes, sendo que existem alguns problemas na parte do tratamento dos inputs dados pelo utilizador. Existiram ocasionalmente alguns erros que fizeram com que a aplicação deixasse de funcionar, sendo que os mesmos poderão estar relacionados com o tratamento dado aos inputs. Tendo em conta que neste sprint foi necessário refazer o backend e frontend referentes à Sprint #1, a equipa de testes concluiu que a aplicação se encontra aceitável e que aprova o seu lançamento. No entanto, acreditamos que para a próxima Sprint a aplicação deve ser mais estável e deverá conter todos os requisitos referentes à Sprint #2 implementados.
