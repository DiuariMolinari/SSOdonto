/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.PaisDAL;
import domain.Pais;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class PaisBLL {

    PaisDAL dal = new PaisDAL();

    //Incluir um registro
    public String insert(Pais pais) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (pais.getNome().isEmpty() || pais.getNome().trim().length() == 0) {
            builder.append("O nome do país deve ser informado.");
        }

        if (pais.getNome().length() > 20) {
            builder.append("O nome do país não pode conter mais que 20 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.insert(pais);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Pais> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Pais pais) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (pais.getNome().length() > 20) {
            builder.append("O nome do país não pode conter mais que 20 caracteres. ");
        }

        if (pais.getNome().isEmpty() || pais.getNome().trim().length() == 0) {
            builder.append("O nome do país deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(pais);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Pais pais) throws SQLException {
        String respostaDB = dal.delete(pais);
        return respostaDB;
    }

    //Obter um registro
    public Pais getById(Pais pais) throws Exception {
        if (pais.getId() < 0 || pais.getId() != 0) {
            throw new Exception("O ID do país deve ser informado.");
        }

        return dal.getById(pais.getId());
    }

    //Obter último registro
    public Pais getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
