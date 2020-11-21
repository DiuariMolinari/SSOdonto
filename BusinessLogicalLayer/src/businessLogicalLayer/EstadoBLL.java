/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.EstadoDAL;
import domain.Estado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class EstadoBLL {

    EstadoDAL dal = new EstadoDAL();

    //Incluir um registro
    public String Inserir(Estado estado) throws SQLException {
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
        String respostaDB = dal.insert(estado);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Estado> LerTodos() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String Atualizar(Estado estado) throws SQLException {
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

        String respostaDB = dal.update(estado);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Estado estado) throws SQLException {
        String respostaDB = dal.delete(estado);
        return respostaDB;
    }

    //TODO: Obter um registro
}
