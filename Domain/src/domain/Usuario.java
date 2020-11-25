/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Diuari
 */
public class Usuario {
    private int id;
    private String login;
    private String senha;
    private Colaborador colaborador;

     @Override
    public String toString() {
        return colaborador.getNome();
    }
    
    public Usuario(int id) {
        this.id = id;
    }
    
    public Usuario(int id, String login, String senha, Colaborador colaborador) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.colaborador = colaborador;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    
}
