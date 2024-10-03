package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe que contém o método pessoa eleitora para executar o sistema de votação.
 */
public class PessoaEleitora extends Pessoa {
  public PessoaEleitora(String nome, String cpf) {
    super(nome);
    this.cpf = cpf;
  }

  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
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
}
