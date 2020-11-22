/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ContatoDAL;
import domain.Contato;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class ContatoBLL {

    ContatoDAL dal = new ContatoDAL();

    //Incluir um registro
    public String insert(Contato contato) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isEmpty() || contato.getFone().trim().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }

        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres.");
        }

        if (contato.getEmail().isEmpty() || contato.getEmail().trim().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.insert(contato);
        return respostaDB;
    }

    //Obter todos os registros
    public ArrayList<Contato> getAll() throws SQLException{
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Contato contato) throws SQLException{
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isEmpty() || contato.getFone().trim().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }
        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres. ");
        }

        if (contato.getEmail().isEmpty() || contato.getEmail().trim().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(contato);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Contato contato) throws SQLException{
        String respostaDB = dal.delete(contato);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Contato contato) throws SQLException {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Contato contato) throws SQLException {
//
//    }
//
}
