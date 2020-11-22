/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.EstadoDAL;
import domain.Estado;
import java.util.ArrayList;
import java.sql.SQLException;


/**
 *
 * @author Marciele
 */
public class EstadoBLL {

    EstadoDAL dal = new EstadoDAL();

    //Incluir um registro
    public String insert(Estado estado) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (estado.getNome().isEmpty() || estado.getNome().trim().length() == 0) {
            builder.append("O nome do estado deve ser informado.");
        }

        if (estado.getNome().length() > 20) {
            builder.append("O nome do estado não pode conter mais que 20 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(estado);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Estado> gettAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Estado estado) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (estado.getNome().isEmpty() || estado.getNome().trim().length() == 0) {
            builder.append("O nome do estado deve ser informado.");
        }

        if (estado.getNome().length() > 20) {
            builder.append("O nome do estado não pode conter mais que 20 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(estado);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Estado estado) throws SQLException {
        String respostaDB = dal.delete(estado);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Estado estado) throws SQLException {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Estado estado) throws SQLException {
//
//    }
//
//    //Obter registros de determinado estado
//    public ArrayList<Estado> getByPais(Estado estado) throws SQLException {
//
//    }
}
