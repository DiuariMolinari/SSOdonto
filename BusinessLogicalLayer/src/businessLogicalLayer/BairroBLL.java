/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.BairroDAL;
import domain.Bairro;
import java.util.ArrayList;

/**
 *
 * @author Marciele
 */
public class BairroBLL {

    BairroDAL dal = new BairroDAL();

    //Incluir um registro
    public String insert(Bairro bairro) throws Exception {
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
    public ArrayList<Bairro> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Bairro bairro) throws Exception {
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
    public String delete(Bairro bairro) throws Exception {
        String respostaDB = dal.delete(bairro);
        return respostaDB;
    }

    //Obter um registro
    public String getById(Bairro bairro) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (bairro.getId() != 0 || bairro.getId() < 0) {
            builder.append("O ID do bairro deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.getById(bairro);
        return respostaDB;
    }

    //Obter todos os bairros por cidade
    public ArrayList<Bairro> getByCidade(Bairro bairro) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (bairro.getCidade().getId() {
            builder.append("O ID do bairro deve ser informado.");
        }

        if (bairro.getCidade().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres. ");
        }

        if (bairro.getCidade().getNome().length() < 0) {
            builder.append("O ID do bairro deve ser informado.");
        }
        if (bairro.getCidade().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres. ");
        }

        if (bairro.getCidade().getEstado().length() < 0) {
            builder.append("O ID do bairro deve ser informado.");
        }

        if (bairro.getCidade().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.getByCidade(bairro);
        return respostaDB;
    }

    //Obter último registro
    public String getLastRegister(Bairro bairro) throws Exception {
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

        String respostaDB = dal.getLastRegister(bairro);
        return respostaDB;
    }
}
