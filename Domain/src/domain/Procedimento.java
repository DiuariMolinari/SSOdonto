/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class Procedimento {
    private int id;
    private String nome;
    private TipoProcedimento tipoProcedimento;
    private String descricaoProcedimento;
    private ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public Procedimento(int id) {
        this.id = id;
    }
    
    public Procedimento(int id, String nome, TipoProcedimento tipoProcedimento, String descricaoProcedimento, ArrayList<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.tipoProcedimento = tipoProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.atendimentos = atendimentos;
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

    public TipoProcedimento getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }
    
    public ArrayList<Atendimento> getAtendimentos(){
        return atendimentos;
    }
    
    public void setAtendimentos(Atendimento atendimento){
        this.atendimentos.add(atendimento);
    }
    
    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    public void setDescricaoProcedimento(String descricaoProcedimento) {
        this.descricaoProcedimento = descricaoProcedimento;
    }
}
