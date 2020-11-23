/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoPagamentoDAL;
import domain.TipoPagamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoPagamentoBLL {

    TipoPagamentoDAL dal = new TipoPagamentoDAL();

    //Incluir um registro
    public String insert(TipoPagamento tipoPagamento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (tipoPagamento.getTipoPagamento().isEmpty() || tipoPagamento.getTipoPagamento().trim().length() == 0) {
            builder.append("O tipo de pagamento deve ser informado.");
        }

        if (tipoPagamento.getTipoPagamento().length() > 50) {
            builder.append("O tipo de pagamento não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(tipoPagamento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<TipoPagamento> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(TipoPagamento tipoPagamento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (tipoPagamento.getTipoPagamento().isEmpty() || tipoPagamento.getTipoPagamento().trim().length() == 0) {
            builder.append("O tipo de pagamento deve ser informado.");
        }

        if (tipoPagamento.getTipoPagamento().length() > 50) {
            builder.append("O tipo de pagamento não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(tipoPagamento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(TipoPagamento tipoPagamento) throws SQLException {
        String respostaDB = dal.delete(tipoPagamento);
        return respostaDB;
    }

    //Obter um registro
    public TipoPagamento getById(TipoPagamento tipoPagamento) throws Exception {
        if (tipoPagamento.getId() < 0 || tipoPagamento.getId() != 0) {
            throw new Exception("O ID do tipo de pagamento deve ser informado.");
        }

        return dal.getById(tipoPagamento.getId());
    }

    //Obter último registro
    public TipoPagamento getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
