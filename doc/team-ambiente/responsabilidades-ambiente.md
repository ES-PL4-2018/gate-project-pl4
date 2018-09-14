# Tarefas da equipa Ambiente
**Este documento está sujeito a alterações**

Este documento apresenta algumas tarefas identificadas como benéficas para a equipa do projeto por acelerar e manter uma relativa ordem dentro da organização.

# Verificar o devido uso das principais ferramentas
Nomeadamente o Github e Slack.

# Desenvolvimento unificado por um ambiente comum
1. Máquina Virtual
2. Containers

**Por que?**
Ambiente de desenvolvimento consistente entre todo o time de desenvolvimento. Todos os desenvolvedores usam o mesmo SO, mesmas livrarias de sistema, mesma versao de linguagem ou runtime, não importando qual a preferência de SO do desenvolvedor (até Windows é compatível).

O ambiente de desenvolvimento é exatamente o mesmo que o ambiente de produção (se assim configurado). Teoricamente deixando o deploy da aplicação _just working_.

Desenvolvedores podem usar os IDEs e editores favoritos como normalmente. Deixando as pessoas produtivas com um _workflow_ que já conhecem. Apesar de haverem editores compatíveis com diferentes plataformas que unificariam ainda mais o ambiente de desenvolvimento.

# Simplificar o workflow de desenvolvimento
Apresentar ferramentas que acelerem o _workflow_ e ajudem a colaboração entre os integrantes; **da forma mais simples  e _painless_ possível para os desenvolvedores**. O propósito dos desenvolvedores é produzir código e não configurar ferramentas.

Editores como o Visual Studio Code possuem forte integração com o protocolo git e ferramentas de [compartilhamento ao vivo de código](https://code.visualstudio.com/blogs/2017/11/15/live-share) que podem vir a ser úteis para potencializar a [programação em pares](https://en.wikipedia.org/wiki/Pair_programming). Para além disso também é um editor _cross-platform_.

# Simplificar o workflow de teste
Integração com [serviços de _Continuous Integration_](https://travis-ci.org/) (CI) ajudariam a acelerar o ambiente de teste via automação e evitar regressões de código.

# Gestão de Base de Dados (server-1)
Gerir o acesso à base de dados para os integrantes atuais da equipa de desenvolvimento e controlar autorização de escrita à base estritamente para o inicial. 

Formar snapshots dos dados em tempos periódicos para evitar perda.

# Gestão de Servidor (server-2)
Configurar a máquina para estar acessível à internet e possuir a mesma imagem que o desenvolvimento de trabalho.

Time de ambiente rersponsável pela configuração deste acesso. Time de teste com acesso restrito para o deployment da versão final de cada Sprint.

# Documentação
Como a cada Sprint há um fluxo de elementos que trocam de equipa é essencial que existe uma documentação clara e concisa para que os novos membros consigam integrar-se rapidamente nas respectivas tarefas.
