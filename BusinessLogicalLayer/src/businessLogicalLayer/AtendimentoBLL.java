/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.AtendimentoDAL;
import domain.Atendimento;
import domain.Procedimento;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class AtendimentoBLL {

    AtendimentoDAL dal = new AtendimentoDAL();

    //Incluir um registro
    public String insert(Atendimento atendimento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(atendimento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Atendimento> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Atendimento atendimento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(atendimento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Atendimento atendimento) throws SQLException {
        String respostaDB = dal.delete(atendimento);
        return respostaDB;
    }

    //Obter um registro
    public Atendimento getById(Atendimento atendimento) throws Exception {
        if (atendimento.getId() != 0 || atendimento.getId() < 0) {
            throw new Exception("O ID do atendimento deve ser informado.");
        }
        return dal.getById(atendimento.getId());
    }

    //Obter último registro
    public Atendimento getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    public ArrayList<Procedimento> getProcedimentos(int idAtendimento) throws SQLException {
        return dal.getProcedimentos(idAtendimento);
    }
}
