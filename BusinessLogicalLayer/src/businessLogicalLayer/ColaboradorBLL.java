/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ColaboradorDAL;
import domain.Colaborador;
import java.util.ArrayList;

/**
 *
 * @author Marciele
 */
public class ColaboradorBLL {

    ColaboradorDAL dal = new ColaboradorDAL();

    //Incluir um registro
    public String insert(Colaborador colaborador) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (colaborador.getNome().isEmpty() || colaborador.getNome().trim().length() == 0) {
            builder.append("O nome do colaborador deve ser informado.");
        }

        if (colaborador.getNome().length() > 100) {
            builder.append("O nome do colaborador não pode conter mais que 100 caracteres.");
        }

        if (colaborador.getCro().isEmpty() || colaborador.getCro().trim().length() == 0) {
            builder.append("O CRO deve ser informada.");
        }
        if (colaborador.getCro().length() > 10) {
            builder.append("O CRO não pode conter mais que 10 caracteres.");
        }

        if (colaborador.getCroEstado().isEmpty() || colaborador.getCroEstado().trim().length() == 0) {
            builder.append("O estado do CRO deve ser informado.");
        }

        if (colaborador.getCroEstado().length() > 2) {
            builder.append("O estado do CRO não pode conter mais que 2 caracteres.");
        }

        if (colaborador.getDataAdmissao().equals("") || colaborador.getDataAdmissao() == null) {
            builder.append("A data de admissão deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(colaborador);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Colaborador> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Colaborador colaborador) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (colaborador.getNome().isEmpty() || colaborador.getNome().trim().length() == 0) {
            builder.append("O nome do colaborador deve ser informado.");
        }

        if (colaborador.getNome().length() > 50) {
            builder.append("O nome do colaborador não pode conter mais que 50 caracteres. ");
        }

        if (colaborador.getCro().isEmpty() || colaborador.getCro().trim().length() == 0) {
            builder.append("O CRO deve ser informada.");
        }

        if (colaborador.getCro().length() > 50) {
            builder.append("O CRO não pode conter mais que 50 caracteres. ");
        }

        if (colaborador.getCroEstado().isEmpty() || colaborador.getCroEstado().trim().length() == 0) {
            builder.append("O estado do CRO deve ser informada.");
        }

        if (colaborador.getCroEstado().length() > 2) {
            builder.append("O estado do CRO não pode conter mais que 2 caracteres. ");
        }

        if (colaborador.getDataAdmissao().equals("") || colaborador.getDataAdmissao() == null) {
            builder.append("A data de admissão deve ser informada.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(colaborador);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Colaborador colaborador) throws Exception {
        String respostaDB = dal.delete(colaborador);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Colaborador colaborador) throws Exception {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Colaborador colaborador) throws Exception {
//
//    }
//
}
