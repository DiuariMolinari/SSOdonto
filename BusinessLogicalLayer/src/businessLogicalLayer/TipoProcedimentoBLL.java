/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoProcedimentoDAL;
import domain.TipoProcedimento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoProcedimentoBLL {

    TipoProcedimentoDAL dal = new TipoProcedimentoDAL();

    //Incluir um registro
    public String insert(TipoProcedimento tipoProcedimento) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (tipoProcedimento.getNome().isEmpty() || tipoProcedimento.getNome().trim().length() == 0) {
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
        String respostaDB = dal.insert(tipoProcedimento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<TipoProcedimento> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(TipoProcedimento tipoProcedimento) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (tipoProcedimento.getNome().isEmpty() || tipoProcedimento.getNome().trim().length() == 0) {
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

        String respostaDB = dal.update(tipoProcedimento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(TipoProcedimento tipoProcedimento) throws Exception {
        String respostaDB = dal.delete(tipoProcedimento);
        return respostaDB;
    }

    //Obter um registro
    public TipoProcedimento getById(TipoProcedimento tipoProcedimento) throws Exception {
        if (tipoProcedimento.getId() < 0 || tipoProcedimento.getId() != 0) {
            throw new Exception("O ID do tipo de procedimento deve ser informado.");
        }

        return dal.getById(tipoProcedimento.getId());
    }

    //Obter último registro
    public TipoProcedimento getLastRegister() throws Exception {
        return dal.getLastRegister();
    }
}
