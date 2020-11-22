/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.LogradouroDAL;
import domain.Logradouro;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class LogradouroBLL {

    LogradouroDAL dal = new LogradouroDAL();

    //Incluir um registro
    public String insert(Logradouro logradouro) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (logradouro.getNome().isEmpty() || logradouro.getNome().trim().length() == 0) {
            builder.append("O nome do logradouro deve ser informado.");
        }

        if (logradouro.getNome().length() > 50) {
            builder.append("O nome do logradouro não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(logradouro);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Logradouro> getAll() throws SQLException{
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Logradouro logradouro) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (logradouro.getNome().isEmpty() || logradouro.getNome().trim().length() == 0) {
            builder.append("O nome do logradouro deve ser informado.");
        }

        if (logradouro.getNome().length() > 50) {
            builder.append("O nome do logradouro não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        
        String respostaDB = dal.update(logradouro);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Logradouro logradouro) throws SQLException{
        String respostaDB = dal.delete(logradouro);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Logradouro logradouro) throws SQLException {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Logradouro logradouro) throws SQLException {
//
//    }
//
//    //Obter registros de determinado estado
//    public ArrayList<Logradouro> getByBairro(Logradouro logradouro) throws SQLException {
//
//    }
}
