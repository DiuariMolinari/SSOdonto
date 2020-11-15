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
public class Atendimento {
    private int id;
    private Paciente paciente;
    private Procedimento procedimento;
    private Colaborador colaborador;
    private int qtdProcedimento;
    private ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public int getQtdProcedimento() {
        return qtdProcedimento;
    }

    public void setQtdProcedimento(int qtdProcedimento) {
        this.qtdProcedimento = qtdProcedimento;
    }
    
    public ArrayList<Procedimento> getProcedimentos(){
        return procedimentos;
    }
    
    public void setProcedimentos(Procedimento procedimento){
        this.procedimentos.add(procedimento);
    }
}
