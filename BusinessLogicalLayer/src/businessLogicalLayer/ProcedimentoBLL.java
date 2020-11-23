/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ProcedimentoDAL;
import domain.Atendimento;
import domain.Procedimento;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class ProcedimentoBLL {

    ProcedimentoDAL dal = new ProcedimentoDAL();

    //Incluir um registro
    public String insert(Procedimento procedimento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (procedimento.getNome().isEmpty() || procedimento.getNome().trim().length() == 0) {
            builder.append("O nome do procedimento deve ser informado.");
        }

        if (procedimento.getNome().length() > 60) {
            builder.append("O nome do procedimento não pode conter mais que 60 caracteres.");
        }

        if (procedimento.getDescricaoProcedimento().isEmpty() || procedimento.getDescricaoProcedimento().trim().length() == 0) {
            builder.append("A descrição do procedimento deve ser informado.");
        }
        if (procedimento.getDescricaoProcedimento().length() > 60) {
            builder.append("A descrição do procedimento não pode conter mais que 60 caracteres. ");
        };

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(procedimento);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Procedimento> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Procedimento procedimento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (procedimento.getNome().isEmpty() || procedimento.getNome().trim().length() == 0) {
            builder.append("O nome do procedimento deve ser informado.");
        }
        if (procedimento.getNome().length() > 60) {
            builder.append("O nome do procedimento não pode conter mais que 60 caracteres. ");
        }

        if (procedimento.getDescricaoProcedimento().isEmpty() || procedimento.getDescricaoProcedimento().trim().length() == 0) {
            builder.append("A descrição do procedimento deve ser informado.");
        }
        if (procedimento.getDescricaoProcedimento().length() > 60) {
            builder.append("A descrição do procedimento não pode conter mais que 60 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(procedimento);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Procedimento procedimento) throws SQLException {
        String respostaDB = dal.delete(procedimento);
        return respostaDB;
    }

    //Obter um registro
    public Procedimento getById(Procedimento procedimento) throws Exception {
        if (procedimento.getId() < 0 || procedimento.getId() != 0) {
            throw new Exception("O ID do procedimento deve ser informado.");
        }

        return dal.getById(procedimento.getId());
    }

    //Obter último registro
    public Procedimento getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    //Obtem lista de atendimentos por procedimento
    public ArrayList<Atendimento> getAtendimentos(int idProcedimento) throws SQLException {
        return dal.getAtendimentos(idProcedimento);
    }
}
