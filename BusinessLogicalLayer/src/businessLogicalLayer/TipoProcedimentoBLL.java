/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.TipoProcedimentoDAL;
import domain.TipoProcedimento;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoProcedimentoBLL {

    TipoProcedimentoDAL dal = new TipoProcedimentoDAL();

    //Incluir um registro
    public String Inserir(TipoProcedimento tipoProcedimento) {
        StringBuilder builder = new StringBuilder();

        if (tipoProcedimento.getNome().isEmpty() || tipoProcedimento.getNome().isBlank() || tipoProcedimento.getNome().length() == 0) {
            builder.append("O nome do tipo de procedimento deve ser informado.");
        }

        if (tipoProcedimento.getNome().length() > 60) {
            builder.append("O nome do tipo de procedimento não pode conter mais que 60 caracteres.");
        }

        if (tipoProcedimento.getValor() < 0 || tipoProcedimento.getValor() != 0) {
            builder.append("O valor do procedimento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(tipoProcedimento);
        return respostaDB;
    }

    // Obter todos os registros
    public List<TipoProcedimento> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(TipoProcedimento tipoProcedimento) {
        StringBuilder builder = new StringBuilder();

        if (tipoProcedimento.getNome().isEmpty() || tipoProcedimento.getNome().isBlank() || tipoProcedimento.getNome().length() == 0) {
            builder.append("O nome do tipo de procedimento deve ser informado.");
        }

        if (tipoProcedimento.getNome().length() > 60) {
            builder.append("O nome do tipo de procedimento não pode conter mais que 60 caracteres. ");
        }

        if (tipoProcedimento.getValor() < 0 || tipoProcedimento.getValor() != 0) {
            builder.append("O valor do procedimento deve ser informada.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(tipoProcedimento);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(TipoProcedimento tipoProcedimento) {
        String respostaDB = dal.Deletar(tipoProcedimento);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
