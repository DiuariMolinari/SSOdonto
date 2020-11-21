/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.PagamentoDAL;
import domain.Pagamento;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class PagamentoBLL {

    PagamentoDAL dal = new PagamentoDAL();

    //Incluir um registro
    public String Inserir(Pagamento pagamento) {
        StringBuilder builder = new StringBuilder();

        if (pagamento.getDataPagamento().equals("") || pagamento.getDataPagamento() == null) {
            builder.append("A data de pagamento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(pagamento);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Pagamento> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Pagamento pagamento) {
        StringBuilder builder = new StringBuilder();

        if (pagamento.getDataPagamento().equals("") || pagamento.getDataPagamento() == null) {
            builder.append("A data de pagamento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(pagamento);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Pagamento pagamento) {
        String respostaDB = dal.Deletar(pagamento);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
