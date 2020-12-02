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
public class Estoque {
    private int id;
    private Produto produto;
    private int qtdProduto;    
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

     @Override
    public String toString() {
        return produto.getNome();
    }
    
    public Estoque(int id) {
        this.id = id;
    }
    
    public Estoque(int id, Produto produto,int qtdProduto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.id = id;
        this.produto = produto;
        this.qtdProduto = qtdProduto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
}
