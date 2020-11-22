/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.AtendimentoDAL;
import domain.Atendimento;
import java.util.ArrayList;

/**
 *
 * @author Marciele
 */
public class AtendimentoBLL {

    AtendimentoDAL dal = new AtendimentoDAL();

    //Incluir um registro
    public String insert(Atendimento atendimento) throws Exception{
        StringBuilder builder = new StringBuilder();

        if (atendimento.getQtdProcedimento() < 0 || atendimento.getQtdProcedimento() != 0) {
            builder.append("A quantidade de procedimento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(atendimento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Atendimento> getAll() throws Exception{
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Atendimento atendimento) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (atendimento.getQtdProcedimento() < 0 || atendimento.getQtdProcedimento() != 0) {
            builder.append("A quantidade de procedimento deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(atendimento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Atendimento atendimento) throws Exception {
        String respostaDB = dal.delete(atendimento);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Atendimento atendimento) throws Exception {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Atendimento atendimento) throws Exception {
//
//    }
//
}
