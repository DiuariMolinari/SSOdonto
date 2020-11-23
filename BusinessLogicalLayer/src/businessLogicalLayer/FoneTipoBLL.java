/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.FoneTipoDAL;
import domain.FoneTipo;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class FoneTipoBLL {

    FoneTipoDAL dal = new FoneTipoDAL();

    //Incluir um registro
    public String insert(FoneTipo foneTipo) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (foneTipo.getTipo().isEmpty() || foneTipo.getTipo().trim().length() == 0) {
            builder.append("O tipo de contato deve ser informado.");
        }

        if (foneTipo.getTipo().length() > 60) {
            builder.append("O tipo de contato não pode conter mais que 60 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(foneTipo);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<FoneTipo> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(FoneTipo foneTipo) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (foneTipo.getTipo().isEmpty() || foneTipo.getTipo().trim().length() == 0) {
            builder.append("O tipo de contato deve ser informado.");
        }

        if (foneTipo.getTipo().length() > 60) {
            builder.append("O tipo de contato não pode conter mais que 60 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(foneTipo);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(FoneTipo foneTipo) throws SQLException {
        String respostaDB = dal.delete(foneTipo);
        return respostaDB;
    }

    //Obter um registro
    public FoneTipo getById(FoneTipo foneTipo) throws Exception {
        if (foneTipo.getId() < 0 || foneTipo.getId() != 0) {
            throw new Exception("O ID do tipo de fone deve ser informado.");
        }

        return dal.getById(foneTipo.getId());
    }

    //Obter último registro
    public FoneTipo getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
