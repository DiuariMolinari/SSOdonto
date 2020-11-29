/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.EstoqueDAL;
import domain.Estoque;
import domain.Produto;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class EstoqueBLL {

    EstoqueDAL dal = new EstoqueDAL();

    //Incluir um registro
    public String insert(Estoque estoque) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (estoque.getQtdProduto() < 0 || estoque.getQtdProduto() == 0) {
            builder.append("A quantidade de produto deve ser informado.");
        }

        if (estoque.getDataEntrada().equals("") || estoque.getDataEntrada() == null) {
            builder.append("A data de entrada do produto deve ser informado.");
        }

        if (estoque.getDataSaida().equals("") || estoque.getDataSaida() == null) {
            builder.append("A data de saída do produto deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(estoque);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Estoque> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Estoque estoque) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (estoque.getQtdProduto() < 0 || estoque.getQtdProduto() == 0) {
            builder.append("A quantidade de produto deve ser informado.");
        }

        if (estoque.getDataEntrada().equals("") || estoque.getDataEntrada() == null) {
            builder.append("A data de entrada do produto deve ser informado.");
        }

        if (estoque.getDataSaida().equals("") || estoque.getDataSaida() == null) {
            builder.append("A data de saída do produto deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(estoque);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Estoque estoque) throws SQLException {
        String respostaDB = dal.delete(estoque);
        return respostaDB;
    }

    //Obter um registro
    public Estoque getById(Estoque estoque) throws Exception {
        if (estoque.getId() < 0 || estoque.getId() == 0) {
            throw new Exception("O ID do estoque deve ser informado.");
        }

        return dal.getById(estoque.getId());
    }

    //Obter último registro
    public Estoque getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    public ArrayList<Estoque> getByProduto(Produto produto) throws SQLException {
        return dal.getByProduto(produto);
    }
}
