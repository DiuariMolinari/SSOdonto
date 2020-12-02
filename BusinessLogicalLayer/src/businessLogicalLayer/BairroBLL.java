/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.BairroDAL;
import domain.Bairro;
import java.util.ArrayList;
import java.sql.SQLException;
import domain.Cidade;

/**
 *
 * @author Marciele
 */
public class BairroBLL {

    BairroDAL dal = new BairroDAL();

    //Incluir um registro
    public String insert(Bairro bairro) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (bairro.getNome().isEmpty() || bairro.getNome().trim().length() == 0) {
            builder.append("O nome do bairro deve ser informado.");
        }

        if (bairro.getNome().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.insert(bairro);
        return respostaDB;
    }

    //Obter todos os registros
    public ArrayList<Bairro> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Bairro bairro) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (bairro.getNome().isEmpty() || bairro.getNome().trim().length() == 0) {
            builder.append("O nome do bairro deve ser informado.");
        }

        if (bairro.getNome().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(bairro);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Bairro bairro) throws SQLException {
        String respostaDB = dal.delete(bairro);
        return respostaDB;
    }

    //Obter um registro
    public Bairro getById(Bairro bairro) throws Exception {
        if (bairro.getId() == 0 || bairro.getId() < 0) {
            throw new Exception("O ID do bairro deve ser informado.");
        }

        return dal.getById(bairro.getId());
    }

    //Obter todos os bairros por cidade
    public ArrayList<Bairro> getByCidade(Cidade cidade) throws SQLException {       
        return dal.getByCidade(cidade);
    }

    //Obter último registro
    public Bairro getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
