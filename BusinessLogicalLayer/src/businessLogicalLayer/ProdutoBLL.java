/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.ProdutoDAL;
import domain.Produto;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class ProdutoBLL {

    ProdutoDAL dal = new ProdutoDAL();

    //Incluir um registro
    public String Inserir(Produto produto) {
        StringBuilder builder = new StringBuilder();

        if (produto.getNome().isEmpty() || produto.getNome().isBlank() || produto.getNome().length() == 0) {
            builder.append("O nome do produto deve ser informado.");
        }

        if (produto.getNome().length() > 60) {
            builder.append("O nome do produto não pode conter mais que 60 caracteres.");
        }

        if (produto.getPreco() < 0 || produto.getPreco() != 0) {
            builder.append("O preço do produto deve ser informado.");
        }

        if (produto.getDataCompra().equals("") || produto.getDataCompra() == null) {
            builder.append("A data da compra deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(produto);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Produto> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Produto produto) {
        StringBuilder builder = new StringBuilder();

        if (produto.getNome().isEmpty() || produto.getNome().isBlank() || produto.getNome().length() == 0) {
            builder.append("O nome do produto deve ser informado.");
        }

        if (produto.getNome().length() > 60) {
            builder.append("O nome do produto não pode conter mais que 60 caracteres.");
        }

        if (produto.getPreco() < 0 || produto.getPreco() != 0) {
            builder.append("O preço do produto deve ser informado.");
        }

        if (produto.getDataCompra().equals("") || produto.getDataCompra() == null) {
            builder.append("A data da compra deve ser informado.");
        }

        String respostaDB = dal.Atualizar(produto);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Produto produto) {
        String respostaDB = dal.Deletar(produto);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
