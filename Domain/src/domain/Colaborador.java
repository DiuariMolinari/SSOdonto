/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDateTime;

/**
 *
 * @author Diuari
 */
public class Colaborador {
    private int id;
    private String nome;
    private String cro;
    private String croEstado;
    private LocalDateTime dataAdmissao;
    private LocalDateTime dataDemissao;
    private Endereco endereco;
    private Funcao funcao;
    private Clinica clinica;
    private boolean ferias;

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

    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDateTime dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDateTime getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDateTime dataDemissao) {
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

    public boolean getFerias() {
        return ferias;
    }

    public void setFerias(boolean ferias) {
        this.ferias = ferias;
    }
}
