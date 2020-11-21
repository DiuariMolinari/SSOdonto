/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.BairroDAL;
import domain.Bairro;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class BairroBLL {

    BairroDAL dal = new BairroDAL();

    //Incluir um registro
    public String insert(Bairro bairro) {
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
    public List<Bairro> getAll() {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Bairro bairro) {
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
    public String delete(Bairro bairro) {
        String respostaDB = dal.delete(bairro);
        return respostaDB;
    }

    //Obter um registro
    public String getById(Bairro bairro) {
        StringBuilder builder = new StringBuilder();

        if (bairro.getId().length() < 0 || bairro.getId() != 0) {
            builder.append("O ID do bairro deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.getById(bairro);
        return respostaDB;
    }

    public List<Bairro> getByCidade(Bairro bairro) {
        StringBuilder builder = new StringBuilder();

        if (bairro.getCidade().getId().length() < 0) {
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

    public String getLastRegister(Bairro bairro) {
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
