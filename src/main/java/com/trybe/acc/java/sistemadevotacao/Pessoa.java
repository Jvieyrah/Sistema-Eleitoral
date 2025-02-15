package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe base para pessoa.
 *
 */
public abstract class Pessoa {
  protected String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public abstract String getNome();

  public abstract void setNome(String nome);

}
