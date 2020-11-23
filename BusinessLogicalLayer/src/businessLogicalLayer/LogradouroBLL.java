/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.LogradouroDAL;
import domain.Bairro;
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
    public String insert(Logradouro logradouro) throws SQLException {
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
    public ArrayList<Logradouro> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Logradouro logradouro) throws SQLException {
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
    public String delete(Logradouro logradouro) throws SQLException {
        String respostaDB = dal.delete(logradouro);
        return respostaDB;
    }

    //Obter um registro
    public Logradouro getById(Logradouro logradouro) throws Exception {
        if (logradouro.getId() < 0 || logradouro.getId() != 0) {
            throw new Exception("O ID do logradouro deve ser informado.");
        }

        return dal.getById(logradouro.getId());
    }

    //Obter último registro
    public Logradouro getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    //Obter registros de determinado estado
    public ArrayList<Logradouro> getByBairro(Bairro bairro) throws SQLException {
        return dal.getByBairro(bairro);
    }
}
