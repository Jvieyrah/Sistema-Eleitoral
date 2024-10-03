package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe que contém o método principal para executar o sistema de votação.
 */
public class Principal {
  /**
   * Método principal para executar o sistema de votação.
   *
   * @param args os argumentos de linha de comando (não são utilizados neste programa)
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scan = new Scanner(System.in);
    GerenciamentoVotacao manage = new GerenciamentoVotacao();

    boolean pergunta1 = true;
    boolean pergunta2 = true;
    boolean escolher = true;

    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      short option = scan.nextShort();
      if (option == 2) {
        pergunta1 = false;
      } else {
        System.out.println("Entre com o nome da pessoa candidata");
        String nomeCandidato = scan.next();
        System.out.println("Entre com o número da pessoa candidata");
        short numeroCandidato = scan.nextShort();
        manage.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (pergunta1);

    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim\n" + "2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      short option = scan.nextShort();
      if (option == 2) {
        pergunta2 = false;
      } else {
        System.out.println("Entre com o nome da pessoa eleitora");
        String nomeeleitor = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora");
        String numerocpf = scan.next();
        manage.cadastrarPessoaEleitora(nomeeleitor, numerocpf);
      }
    } while (pergunta2);

    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar\n" + "2 - Resultado Parcia\n" + "3 - Finalizar Votação");
      short escolha = scan.nextShort();
      if (escolha == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora");
        String numeroCpf = scan.next();
        System.out.println("Entre com o número da pessoa candidata");
        short numeroCandidato = scan.nextShort();
        manage.votar(numeroCpf, numeroCandidato);
      }
      if (escolha == 2) {
        manage.mostrarResultado();
      }
      if (escolha == 3) {
        manage.mostrarResultado();
        escolher = false;
      }
    } while (escolher);
    scan.close();
  }

}
