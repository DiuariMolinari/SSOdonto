/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.CidadeDAL;
import domain.Cidade;
import java.util.ArrayList;
import java.sql.SQLException;


/**
 *
 * @author Marciele
 */
public class CidadeBLL {

    CidadeDAL dal = new CidadeDAL();

    //Incluir um registro
    public String insert(Cidade cidade) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (cidade.getNome().isEmpty() || cidade.getNome().trim().length() == 0) {
            builder.append("O nome da cidade deve ser informado.");
        }

        if (cidade.getNome().length() > 50) {
            builder.append("O nome da cidade não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(cidade);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Cidade> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Cidade cidade) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (cidade.getNome().length() > 50) {
            builder.append("O nome da cidade não pode conter mais que 50 caracteres. ");
        }

        if (cidade.getNome().isEmpty() || cidade.getNome().trim().length() == 0) {
            builder.append("O nome da cidade deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(cidade);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Cidade cidade) throws SQLException {
        String respostaDB = dal.delete(cidade);
        return respostaDB;
    }

//    //Obter um registro
    public String getById(Cidade cidade) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (cidade.getId() != 0 || cidade.getId() < 0) {
            builder.append("O ID da cidade deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.getById(cidade);
        return respostaDB;
    }

//    //Obter último registro
//    public String getLastRegister(Cidade cidade) throws SQLException {
//
//    }
//
//    //Obter registros de determinado estado
//    public ArrayList<Cidade> getByEstado(Cidade cidade) throws SQLException {
//
//    }
}
