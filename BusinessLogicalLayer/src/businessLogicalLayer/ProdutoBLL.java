/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ProdutoDAL;
import domain.Produto;
import domain.TipoEmbalagem;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marciele
 */
public class ProdutoBLL {

    ProdutoDAL dal = new ProdutoDAL();

    //Incluir um registro
    public String insert(Produto produto) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (produto.getNome().isEmpty() || produto.getNome().trim().length() == 0) {
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
        String respostaDB = dal.insert(produto);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Produto> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Produto produto) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (produto.getNome().isEmpty() || produto.getNome().trim().length() == 0) {
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

        String respostaDB = dal.update(produto);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Produto produto) throws SQLException {
        String respostaDB = dal.delete(produto);
        return respostaDB;
    }

    //Obter um registro
    public Produto getById(Produto produto) throws Exception {
        if (produto.getId() < 0 || produto.getId() != 0) {
            throw new Exception("O ID do produto deve ser informado.");
        }

        return dal.getById(produto.getId());
    }

    //Obter último registro
    public Produto getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
    
    public ArrayList<Produto> getByTipoEmbalagem(TipoEmbalagem tipoEmbalagem) throws SQLException{
        return dal.getByTipoEmbalagem(tipoEmbalagem);
    }
}
