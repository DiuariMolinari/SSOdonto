/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoPagamentoDAL;
import domain.TipoPagamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoPagamentoBLL {

    TipoPagamentoDAL dal = new TipoPagamentoDAL();

    //Incluir um registro
    public String insert(TipoPagamento tipoPagamento) throws Exception {
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
    public ArrayList<TipoPagamento> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(TipoPagamento tipoPagamento) throws Exception {
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
    public String delete(TipoPagamento tipoPagamento) throws Exception {
        String respostaDB = dal.delete(tipoPagamento);
        return respostaDB;
    }

   //    //Obter um registro
//    public String getById(TipoPagamento tipoPagamento) throws Exception {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(TipoPagamento tipoPagamento) throws Exception {
//
//    }
}
