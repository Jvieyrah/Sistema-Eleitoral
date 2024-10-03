package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * 
 * <p>
 * .classe geral que contem metodos.
 * </p>
 * author joao.
 *
 */
public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos;

  public ArrayList<PessoaCandidata> getPessoasCandidatas() {
    return pessoasCandidatas;
  }

  private void setPessoasCandidatas(PessoaCandidata pessoasCandidata) {
    this.pessoasCandidatas.add(pessoasCandidata);
  }

  public ArrayList<PessoaEleitora> getPessoasEleitoras() {
    return pessoasEleitoras;
  }

  private void setPessoasEleitoras(PessoaEleitora pessoasEleitoras) {
    this.pessoasEleitoras.add(pessoasEleitoras);
  }

  public ArrayList<String> getCpfComputado() {
    return cpfComputado;
  }

  public void setCpfComputado(String cpfComputado) {
    this.cpfComputado.add(cpfComputado);
  }

  public int getTotalVotos() {
    return totalVotos;
  }

  public void addTotalVotos() {
    this.totalVotos += 1;
  }

  /**
   * Classe que contém o método cadastro de candidato para executar o sistema de votação.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata candidato : getPessoasCandidatas()) {
      if (candidato.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
        return;
      }
    }
    PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
    setPessoasCandidatas(novoCandidato);
  }

  /**
   * Classe que contém o método cadastro de eleitor para executar o sistema de votação.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora eleitor : getPessoasEleitoras()) {
      if (eleitor.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
    setPessoasEleitoras(novoEleitor);
  }

  /**
   * Classe que contém o método votar para executar o sistema de votação.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : getCpfComputado()) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
        return;
      }
    }
    for (PessoaCandidata candidate : getPessoasCandidatas()) {
      if (candidate.getNumero() == numeroPessoaCandidata) {
        candidate.receberVoto();
        setCpfComputado(cpfPessoaEleitora);
        addTotalVotos();
        return;
      }
    }
    System.out.println("Candidato não encontrado.");
  }

  /**
   * Classe que contém o método mostrar resultado para executar o sistema de votação.
   */
  public void mostrarResultado() {
    if (getTotalVotos() == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
      return;
    }
    int size = pessoasCandidatas.size();
    int index;
    for (index = 0; index < size; index++) {
      System.out.println("Nome: " + pessoasCandidatas.get(index).getNome() + " - "
          + pessoasCandidatas.get(index).votos + " votos ( " + calcularPorcentagemVotos(index)
          + " }");
    }
    System.out.println("Total de votos: " + getTotalVotos());
  }

  private double calcularPorcentagemVotos(int index) {
    int votos = pessoasCandidatas.get(index).votos;
    double porcentagem = (Double.valueOf(votos) / Double.valueOf(totalVotos)) * 100;
    return Math.round(porcentagem * 10.0) / 10.0;
  }

}
