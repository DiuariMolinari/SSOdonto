/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.PagamentoDAL;
import domain.Pagamento;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class PagamentoBLL {

    PagamentoDAL dal = new PagamentoDAL();

    //Incluir um registro
    public String insert(Pagamento pagamento) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (pagamento.getDataPagamento().equals("") || pagamento.getDataPagamento() == null) {
            builder.append("A data de pagamento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(pagamento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Pagamento> getAll() throws SQLException{
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Pagamento pagamento) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (pagamento.getDataPagamento().equals("") || pagamento.getDataPagamento() == null) {
            builder.append("A data de pagamento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(pagamento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Pagamento pagamento) throws SQLException{
        String respostaDB = dal.delete(pagamento);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Pagamento pagamento) throws SQLException {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Pagamento pagamento) throws SQLException {
//
//    }
}
