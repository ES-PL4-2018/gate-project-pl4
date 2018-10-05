# Documentação Pandoc

## Table of Contents
1. [Instalação](#Instalação)
2. [Como Usar](#Como-Usar)
3. [Customizing](#Customizing)

## Instalação
* Instalar [Pandoc](https://pandoc.org/installing.html)
* Instalar também [LaTeX](https://en.wikibooks.org/wiki/LaTeX/Installation#Distributions).
* Mover os ficheiros `convert.bat` e `mytemplate.latex` para a pasta em que os documentos irão ser convertidos, ou caso queira guardar o template na pasta do pandoc também é possível:
	* Unix, Linux, macOS: `~/.pandoc/templates/`
	* Windows XP: `C:\Documents And Settings\USERNAME\Application Data\pandoc`
	* Windows Vista or later: `C:\Users\USERNAME\AppData\Roaming\pandoc`
	
	Se não existirem as pastas `templates` or `pandoc` então é necessário criar e mover o `mytemplate.latex` para lá.

## Como Usar

1.   Abrir a consola de comandos e ir para a pasta onde os documentos irão ser convertidos(assumindo que os ficheiros especificados anteriormente já lá estão).
2.   Executar o comando `convert filename` onde o \filename é o nome, sem extensão, do markdown que quer converter.
3.  Quando o comando acabar de correr, o pdf convertido irá aparecer na pasta com o mesmo nome do documento

- Caso queira usar diretamente na consola/bash pode usar o comando `pandoc documento.md -o documento.pdf --from markdown --template=mytemplate.latex --listings -V lang=pt` caso tenha adicionado o template à pasta do roaming basta usar `--template mytemplate`

## Customizing

O template latex permite a definição de variaveis manuais no documento por YAML como: titulo do documento, autor, data (que serão usados para gerar um cabeçalho e rodapé automaticamente).
Para além disso podemos definir por exemplo o que queremos no lado esquerdo do rodapé. 

```markdown
---
title: "The Document Title"
author: [Example Author, Another Author]
date: "2017-02-20"
keywords: [Markdown, Example]
...

Here is the actual document text...
```

### Custom Template Variables

- `titlepage` (defaults to `false`)
    
    Gera uma capa para o documento quando é iniciada a `true`
- `titlepage-color`
    
    A cor de fundo da folha de capa. A cor deve ser dada como um HTML hex como `D8DE2C` sem o símbolo (`#`). Quando a cor é especificada no YAML, é aconselhado usar aspas `titlepage-color: "D8DE2C"` para evitar truncamento (e.g. `000000` ficando `0`).
- `titlepage-text-color` (defaults to `5F5F5F`)
    
    Cor do texto na capa
- `titlepage-rule-color` (defaults to `435488`)
    
    Cor da _rule_ no topo da capa
- `titlepage-rule-height` (defaults to `4`)
    
    Tamanho da _rule_ no topo da capa(em pontos)
- `caption-justification` (defaults to `raggedright`)
    
   Configuração de justificação para _captions_ (usa o parâmetro `justification` do pacote [caption](https://ctan.org/pkg/caption?lang=en))
- `toc-own-page` (defaults to `false`)

    Começa uma nova página depois da tabela de conteúdos, quando é iniciado a `true`
- `listings-disable-line-numbers` (defaults to `false`)
    
    Desativa _line numbers_ para todas as listagens
- `disable-header-and-footer` (default to `false`)
	
	Desativa completamente os cabeçalhos e rodapés
- `header-left` (defaults to the title)
	
	O texto no lado esquerdo do cabeçalho
- `header-center`
	
	O texto no meio do cabeçalho
- `header-right` (defaults to the date)
	
	O texto no lado direito do cabeçalho
- `footer-left` (defaults to the author)
	
	O texto no lado esquerdo do rodapé
- `footer-center`
	
	O texto no meio do rodapé
- `footer-right` (defaults to the page number)
	
	O texto no lado direito do rodapé
- `logo`
	
	Caminho para a imagem que será usada na capa. O caminho é relativo à pasta onde o script se encontra
- `logo-width` (defaults to `100`)
	
	Largura do logo(em pontos)
