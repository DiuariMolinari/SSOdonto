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
public class Funcao {
    private int id;
    private String nome;
    private double salario;
    private double comissao;

     @Override
    public String toString() {
        return nome;
    }
    
    public Funcao(int id) {
        this.id = id;
    }
    
    public Funcao(int id, String nome, double salario, double comissao) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.comissao = comissao;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
