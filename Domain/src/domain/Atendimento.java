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
    private Colaborador colaborador;
    private ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();

    public Atendimento(int id) {
        this.id = id;
    }
    
    public Atendimento(int id, Paciente paciente, Colaborador colaborador) {
        this.id = id;
        this.paciente = paciente;
        this.colaborador = colaborador;
    }
    
    public Atendimento(int id, Paciente paciente, Colaborador colaborador, ArrayList<Procedimento> procedimentos) {
        this.id = id;
        this.paciente = paciente;
        this.colaborador = colaborador;
        this.procedimentos = procedimentos;
    }

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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public ArrayList<Procedimento> getProcedimentos(){
        return procedimentos;
    }
    
    public void setProcedimentos(Procedimento procedimento){
        this.procedimentos.add(procedimento);
    }
}
