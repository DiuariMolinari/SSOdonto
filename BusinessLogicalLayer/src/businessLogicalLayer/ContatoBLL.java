/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.ContatoDAL;
import domain.Contato;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class ContatoBLL {

    ContatoDAL dal = new ContatoDAL();

    //Incluir um registro
    public String Inserir(Contato contato) {
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isBlank() || contato.getFone().isEmpty() || contato.getFone().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }

        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres.");
        }

        if (contato.getEmail().isBlank() || contato.getEmail().isEmpty() || contato.getEmail().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Inserir(contato);
        return respostaDB;
    }

    //Obter todos os registros
    public List<Contato> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Contato contato) {
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isBlank() || contato.getFone().isEmpty() || contato.getFone().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }
        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres. ");
        }

        if (contato.getEmail().isBlank() || contato.getEmail().isEmpty() || contato.getEmail().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(contato);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Contato contato) {
        String respostaDB = dal.Deletar(contato);
        return respostaDB;
    }

    //TODO: Obter um registro
}
