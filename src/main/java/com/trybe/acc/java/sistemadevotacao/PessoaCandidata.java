package com.trybe.acc.java.sistemadevotacao;

/**
 * complementa a pessoa incluindo numerodecandidato.
 *
 */
public class PessoaCandidata extends Pessoa {
  private int numero;
  public int votos;

  /**
   * Classe que contém o método de gerar candidatos para executar o sistema de votação.
   */
  public PessoaCandidata(String nome, int numero) {
    super(nome);
    // TODO Auto-generated constructor stub
    this.numero = numero;
    this.votos = 0;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Override
  public String getNome() {
    // TODO Auto-generated method stub
    return super.nome;
  }

  @Override
  public void setNome(String nome) {
    // TODO Auto-generated method stub
    super.nome = nome;
  }

  public void receberVoto() {
    this.votos += 1;
  }
}
