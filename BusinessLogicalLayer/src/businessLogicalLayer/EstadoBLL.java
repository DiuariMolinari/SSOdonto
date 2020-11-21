/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.EstadoDAL;
import domain.Estado;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class EstadoBLL {

    EstadoDAL dal = new EstadoDAL();

    //Incluir um registro
    public String Inserir(Estado estado) {
        StringBuilder builder = new StringBuilder();

        if (estado.getNome().isBlank() || estado.getNome().isEmpty() || estado.getNome().length() == 0) {
            builder.append("O nome do estado deve ser informado.");
        }

        if (estado.getNome().length() > 20) {
            builder.append("O nome do estado não pode conter mais que 20 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(estado);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Estado> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Estado estado) {
        StringBuilder builder = new StringBuilder();

        if (estado.getNome().isBlank() || estado.getNome().isEmpty() || estado.getNome().length() == 0) {
            builder.append("O nome do estado deve ser informado.");
        }

        if (estado.getNome().length() > 20) {
            builder.append("O nome do estado não pode conter mais que 20 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(estado);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Estado estado) {
        String respostaDB = dal.Deletar(estado);
        return respostaDB;
    }

    //TODO: Obter um registro
}
