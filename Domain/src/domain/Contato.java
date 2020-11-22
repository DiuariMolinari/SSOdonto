/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Diuari e Marciele
 */
public class Contato {

    private int id;
    private String fone;
    private FoneTipo foneTipo;
    private String email;
    private Paciente paciente;
    private Colaborador colaborador;

     public Contato(int id) {
        this.id = id;
    }
    
    public Contato(int id, String fone, FoneTipo foneTipo, String email, Colaborador colaborador) {
        this.id = id;
        this.fone = fone;
        this.foneTipo = foneTipo;
        this.email = email;
        this.colaborador = colaborador;
    }
    
    public Contato(int id, String fone, FoneTipo foneTipo, String email, Paciente paciente) {
        this.id = id;
        this.fone = fone;
        this.foneTipo = foneTipo;
        this.email = email;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public FoneTipo getFoneTipo() {
        return foneTipo;
    }

    public void setFoneTipo(FoneTipo foneTipo) {
        this.foneTipo = foneTipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
