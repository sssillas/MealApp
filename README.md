ESTE PROJETO USA UMA API DE CATEGORIAS DE COMIDA E MOSTRA EM UMA LISTA

INICIALMENTE FOI FEITA A INJEÇÃO DE DEPENDÊNCIAS UTILIZANDO A BIBLIOTECA KOIN
    - O KOIN OPERA TUDO EM TEMPO DE EXECUÇÃO, PORTANTO QUALQUER ERRO SÓ VAI DESCOBRIR COM O APLICATIVO RODANDO
    - POR SER EM TEMPO DE EXECUÇÃO, A PERFOMANCE DO APLICATIVO PODE DIMINUIR, MAS NADA QUE ATRAPALHE A EXPERIENCIA DO USUARIO COM O APP

PAGINA OFICIAL: https://insert-koin.io/
VIDEO AULA DE BASE: https://www.youtube.com/watch?v=Mh_NK5G0WjY

**********************************************************************************
PARA UTILIZAR O KOIN ADICIONAR NAS DEPENDÊNCIAS DO GRADLE APP

def koin_version = "3.2.1"
implementation "io.insert-koin:koin-core:$koin_version"
testImplementation "io.insert-koin:koin-test:$koin_version"

**********************************************************************************
SUGESTÃO: CRIE UM NOVO PACOTE CHAMADO di, E CRIA UM NOVA ARQUIVO MainModule(UM MODULO DO COIN PARA FACTORY MAIN)


É NECESSÁRIO CRIAR UMA CLASSE QUE IRÁ HERDAR O APPLICATION QUE SERÁ ADICIONADA NO ANDROIDMANIFEST
ESSA CLASSE IRA SOBRESCREVER O MÉTODO ONCREATE E DAR UM STARTKOIN, QUE SERÁ PASSADO O CONTEXTO E
A LISTA DE DEPENDENCIAS COM A PALAVRA RESERVADA modules

DICA DE NOME DESSA CLASSE: COLOCA O NOME DO PROJETO SEGUIDO DE Application

CRIE UMA CLASSE CHAMADA SERVICE ONDE IRÁ INICIALIZAR O RETROFIT

CRIE UM SINGLE NO MAINMODULE INJETANDO O SERVICE


ORGANIZAÇÃO DE PACOTES

-presentation (Activities, Models) - Toda parte de visualização em que o usuário está interagindo
    /books

-data (Classe de dados) - RETROFIT, RESPONSE, VIEWMODEL
    -model
    -response (ANOTAÇÔES DO RETROFIT)

A função do viewModel é gerenciar od dados da UI(Activities) e fazer a ponte para as demais camadas do aplicativo

if(it != null) 
Pode ser trocado por
it?.let{

}
