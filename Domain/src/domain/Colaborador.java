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
public class Colaborador {
    private int id;
    private String nome;
    private String cro;
    private String croEstado;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;
    private Endereco endereco;
    private Funcao funcao;
    private Clinica clinica;
    private boolean ferias;
    private boolean demitido;

    public Colaborador(int id, String nome, String cro, String croEstado, LocalDate dataAdmissao, LocalDate dataDemissao, Endereco endereco, Funcao funcao, Clinica clinica, boolean ferias, boolean demitido) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.croEstado = croEstado;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
        this.endereco = endereco;
        this.funcao = funcao;
        this.clinica = clinica;
        this.ferias = ferias;
        this.demitido = demitido;
    }
    public Colaborador(int id, String nome, String cro, String croEstado, LocalDate dataAdmissao, Endereco endereco, Funcao funcao, Clinica clinica, boolean ferias, boolean demitido) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.croEstado = croEstado;
        this.dataAdmissao = dataAdmissao;
        this.endereco = endereco;
        this.funcao = funcao;
        this.clinica = clinica;
        this.ferias = ferias;
        this.demitido = demitido;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getCroEstado() {
        return croEstado;
    }

    public void setCroEstado(String croEstado) {
        this.croEstado = croEstado;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public boolean isFerias() {
        return ferias;
    }

    public void setFerias(boolean ferias) {
        this.ferias = ferias;
    }
    
    public boolean isDemitido() {
        return demitido;
    }

    public void setDemitido(boolean demitido) {
        this.demitido = demitido;
    }
}
