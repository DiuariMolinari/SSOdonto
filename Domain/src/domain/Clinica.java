/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;

/**
 *
 * @author Diuari
 */
public class Clinica {
    private int id;
    private String nome;
    private LocalDate dataInauguracao;
    private Endereco endereco;

    public Clinica(int id) {
        this.id = id;
    }
    
    public Clinica(int id, String nome, LocalDate dataInauguracao, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.dataInauguracao = dataInauguracao;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInauguracao() {
        return dataInauguracao;
    }

    public void setDataInauguracao(LocalDate dataInauguracao) {
        this.dataInauguracao = dataInauguracao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
