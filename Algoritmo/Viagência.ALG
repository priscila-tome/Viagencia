Algoritmo "Viag�ncia"

Var
   destinos: vetor [1..5] de caractere
   valores: vetor [1..5] de real
   i, j, k, n, opcao, viagem: inteiro
   resposta: caractere
   nome, cpf, email, senha: vetor [1..10] de caractere

procedimento menu ()
var

inicio
   escreval("======== M E N U ========")
   escreval ("[1] Destinos dispon�veis")
   escreval ("[2] Consultar cadastro")
   escreval ("[3] Sair")
   escreval("=========================")

   leia(opcao)
   menu2 ()
fimprocedimento


procedimento menu2 ()
var

inicio

   escolha opcao
   caso 1
      limpatela
      escreval ("Atualmente temos esses destinos dispon�veis:")
      escreval ()
      para i de 1 ate 5 faca
         escreval("[",i," ] ", destinos[i], " R$", valores[i])
      fimpara
      escreval ()
      escreval ("Digite o n�mero do destino selecionado: ")
      leia (viagem)

      se (viagem = 1) ou (viagem = 2) ou (viagem = 3) ou (viagem = 4) ou (viagem = 5) entao
         limpatela

         cadastro ()

      senao
         repita
            escreval ("Destino inv�lido. Digite o n�mero do destino selecionado: ")
            leia (viagem)
         ate (viagem = 1) ou (viagem = 2) ou (viagem = 3) ou (viagem = 4) ou (viagem = 5)

         limpatela

         cadastro ()
      fimse

      limpatela
      escreval ("Passageiros cadastrados com sucesso!")
      menu ()

   caso 2
      se (n = 0) entao
         limpatela
         escreval ("Voc� ainda n�o cadastrou nenhum destino.")
         menu ()

      senao
         limpatela
         escreval ("Destino selecionado: ", destinos[viagem],".")
         para j de 1 ate n faca
            escreval (j,"� passageiro: ", nome[j])
            escreval ("CPF: ", cpf[j])
            escreval ()
         fimpara

      caso 3
fimalgoritmo

outrocaso
   limpatela
   escreval ("Op��o inv�lida. Escolha novamente:")
   escreval ()
   menu ()
   
fimescolha
fimprocedimento



procedimento cadastro ()
var

inicio

   escreval ("Voc� selecionou o destino ", destinos[viagem],".")
   repita
      escreval ("Vamos iniciar o cadastro!")
      escreva ("Digite o nome do", j,"� passageiro: ")
      leia (nome [j])
      escreva ("Digite o CPF: ")
      leia (cpf [j])
      j <- j + 1
      n <- n + 1
      escreval()
      escreva ("Deseja cadastrar mais uma pessoa? [S/N]")
      leia (resposta)
      escreval ()
   ate (resposta = "n") ou (resposta = "N")

fimprocedimento


Inicio

   destinos [1] <- "S�o Paulo"
   destinos [2] <- "Rio de Janeiro"
   destinos [3] <- "Las Vegas"
   destinos [4] <- "Bahia"
   destinos [5] <- "Florian�polis"

   valores [1] <- 130.00
   valores [2] <- 150.00
   valores [3] <- 3000.00
   valores [4] <- 800.00
   valores [5] <- 300.00

   j <- 1
   n <- 0

   escreval ("===========================================")
   escreval ("B E M   V I N D O   A   V I A G � N C I A!")
   escreval ("===========================================")

   menu ()


Fimalgoritmo