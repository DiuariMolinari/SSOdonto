/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ClinicaDAL;
import domain.Clinica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class ClinicaBLL {

    //TODO: Obter um registro
    ClinicaDAL dal = new ClinicaDAL();

    //Incluir um registro
    public String Inserir(Clinica clinica) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (clinica.getNome().isEmpty() || clinica.getNome().trim().length() == 0) {
            builder.append("O nome da clíncia deve ser informado.");
        }

        if (clinica.getNome().length() > 60) {
            builder.append("O nome da clínica não pode conter mais que 60 caracteres.");
        }

        if (clinica.getDataInauguracao().equals("") || clinica.getDataInauguracao() == null) {
            builder.append("A data de inauguração deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.insert(clinica);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Clinica> LerTodos() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String Atualizar(Clinica clinica) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (clinica.getNome().length() > 60) {
            builder.append("O nome da clínica não pode conter mais que 60 caracteres. ");
        }

        if (clinica.getNome().isEmpty() || clinica.getNome().trim().length() == 0) {
            builder.append("O nome da clínica deve ser informado.");
        }

        if (clinica.getDataInauguracao().equals("") || clinica.getDataInauguracao() == null) {
            builder.append("A data de inauguração deve ser informada.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(clinica);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Clinica clinica) throws SQLException {
        String respostaDB = dal.delete(clinica);
        return respostaDB;
    }
}
