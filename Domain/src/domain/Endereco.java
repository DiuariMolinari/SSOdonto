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
public class Endereco {
    private int id;
    private Logradouro logradouro;
    private int numeroCasa;
    private String cep;

     @Override
    public String toString() {
        return cep;
    } 
    
    public Endereco(int id) {
        this.id = id;
    }
    
    public Endereco(int id, Logradouro logradouro, int numeroCasa, String cep) {
        this.id = id;
        this.numeroCasa = numeroCasa;
        this.logradouro = logradouro;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
