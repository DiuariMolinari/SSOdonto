/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.AtendimentoDAL;
import domain.Atendimento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class AtendimentoBLL {

    AtendimentoDAL dal = new AtendimentoDAL();

    //Incluir um registro
    public String Inserir(Atendimento atendimento) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(atendimento);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Atendimento> LerTodos() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String Atualizar(Atendimento atendimento) throws SQLException {
        StringBuilder builder = new StringBuilder();


        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(atendimento);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Atendimento atendimento) throws SQLException {
        String respostaDB = dal.delete(atendimento);
        return respostaDB;
    }

    //TODO: Obter um registro    
}
