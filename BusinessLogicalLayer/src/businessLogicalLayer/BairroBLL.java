/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAcessLayer.BairroDAL;
import domain.Bairro;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class BairroBLL {
    //TODO: Obter um registro

    BairroDAL dal = new BairroDAL();

    //Incluir um registro
    public String Inserir(Bairro bairro) {
        StringBuilder builder = new StringBuilder();

        if (bairro.getNome().isEmpty() ||bairro.getNome().trim().length() == 0) {
            builder.append("O nome do bairro deve ser informado.");
        }

        if (bairro.getNome().length() > 50) {
            builder.append("O nome do bairro não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(bairro);
        return respostaDB;
    }

    //Obter todos os registros
    public List<Bairro> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Bairro bairro) {
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

        String respostaDB = dal.Atualizar(bairro);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Bairro bairro) {
        String respostaDB = dal.Deletar(bairro);
        return respostaDB;
    }
}
