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
import domain.Estado;

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

    //Obter um registro
    public Cidade getById(Cidade cidade) throws Exception {
        if (cidade.getId() == 0 || cidade.getId() < 0) {
            throw new Exception("O ID da cidade deve ser informado.");
        }

        return dal.getById(cidade.getId());
    }

    //Obter último registro
    public Cidade getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    //Obter lista de cidades de determinado estado
    public ArrayList<Cidade> getByEstado(Estado estado) throws SQLException {
        return dal.getByEstado(estado);
    }
}
