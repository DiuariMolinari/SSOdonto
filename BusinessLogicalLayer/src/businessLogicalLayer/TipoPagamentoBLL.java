/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.TipoPagamentoDAL;
import domain.TipoPagamento;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoPagamentoBLL {

    TipoPagamentoDAL dal = new TipoPagamentoDAL();

    //Incluir um registro
    public String Inserir(TipoPagamento tipoPagamento) {
        StringBuilder builder = new StringBuilder();

        if (String.IsNullOrWhiteSpace(tipoPagamento.tipoPagamento)) {
            builder.append("O nome deve ser informado.");
        }

        if (tipoPagamento.getTipoPagamento().length() > 50) {
            builder.append("O tipo de pagamento não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(tipoPagamento);
        return respostaDB;
    }

    // Obter todos os registros
    public List<TipoPagamento> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(TipoPagamento tipoPagamento) {
        StringBuilder builder = new StringBuilder();

        if (tipoPagamento.tipoPagamento.Length > 50) {
            builder.append("O usuário não pode conter mais que 50 caracteres. ");
        }

        if (String.IsNullOrWhiteSpace(tipoPagamento.tipoPagamento)) {
            builder.append("O usuário deve ser informado.");
        }

        String respostaDB = dal.Atualizar(tipoPagamento);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(TipoPagamento tipoPagamento) {
        String respostaDB = dal.Deletar(tipoPagamento);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
