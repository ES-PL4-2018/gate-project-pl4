@ECHO OFF
setlocal
SET FILE= %1

IF EXIST "%userprofile%\AppData\Roaming\pandoc\templates\mytemplate.latex" (
    pandoc %FILE%.md -o %FILE%.pdf --from markdown --template mytemplate --listings -V lang=pt)

IF NOT EXIST "%userprofile%\AppData\Roaming\pandoc\templates\mytemplate.latex" (
    pandoc %FILE%.md -o %FILE%.pdf --from markdown --template=mytemplate.latex --listings -V lang=pt)

endlocal