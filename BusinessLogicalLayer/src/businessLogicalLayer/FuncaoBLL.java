/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.FuncaoDAL;
import domain.Funcao;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class FuncaoBLL {

    FuncaoDAL dal = new FuncaoDAL();

    //Incluir um registro
    public String insert(Funcao funcao) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (funcao.getNome().isEmpty() || funcao.getNome().trim().length() == 0) {
            builder.append("O nome da funçao deve ser informado.");
        }

        if (funcao.getNome().length() > 100) {
            builder.append("O nome da funçao não pode conter mais que 100 caracteres.");
        }

        if (funcao.getSalario() < 0 || funcao.getSalario() == 0) {
            builder.append("O salário deve ser informado.");
        }

        if (funcao.getComissao() > 0.4) {
            builder.append("A comissão não pode ser de maior que 40%.");
        }

        if (funcao.getComissao() < 0) {
            builder.append("O comissão deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(funcao);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<Funcao> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Funcao funcao) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (funcao.getNome().isEmpty() || funcao.getNome().trim().length() == 0) {
            builder.append("O nome da funçao deve ser informado.");
        }

        if (funcao.getNome().length() > 100) {
            builder.append("O nome da funçao não pode conter mais que 100 caracteres. ");
        }

        if (funcao.getSalario() < 0 || funcao.getSalario() == 0) {
            builder.append("O salário deve ser informado.");
        }

        if (funcao.getComissao() > 0.4) {
            builder.append("A comissão não pode ser de maior que 40%.");
        }

        if (funcao.getComissao() < 0) {
            builder.append("A comissão deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(funcao);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Funcao funcao) throws SQLException {
        String respostaDB = dal.delete(funcao);
        return respostaDB;
    }

    //Obter um registro
    public Funcao getById(Funcao funcao) throws Exception {
        if (funcao.getId() < 0 || funcao.getId() == 0) {
            throw new Exception("O ID da função deve ser informado.");
        }

        return dal.getById(funcao.getId());
    }

    //Obter último registro
    public Funcao getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
