/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.CidadeDAL;
import domain.Cidade;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class CidadeBLL {

    //TODO: Obter um registro
    CidadeDAL dal = new CidadeDAL();

    //Incluir um registro
    public String Inserir(Cidade cidade) {
        StringBuilder builder = new StringBuilder();

        if (cidade.getNome().isBlank() || cidade.getNome().isEmpty() || cidade.getNome().length() == 0) {
            builder.append("O nome da cidade deve ser informado.");
        }

        if (cidade.getNome().length() > 50) {
            builder.append("O nome da cidade não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(cidade);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Cidade> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Cidade cidade) {
        StringBuilder builder = new StringBuilder();

        if (cidade.getNome().length() > 50) {
            builder.append("O nome da cidade não pode conter mais que 50 caracteres. ");
        }

        if (cidade.getNome().isBlank() || cidade.getNome().isEmpty() || cidade.getNome().length() == 0) {
            builder.append("O nome da cidade deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(cidade);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Cidade cidade) {
        String respostaDB = dal.Deletar(cidade);
        return respostaDB;
    }
}
