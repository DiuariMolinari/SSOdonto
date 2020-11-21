/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.EspecialidadeDAL;
import domain.Especialidade;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class EspecialidadeBLL {

    //Obter um registro
    EspecialidadeDAL dal = new EspecialidadeDAL();

    //Incluir um registro
    public String Inserir(Especialidade especialidade) {
        StringBuilder builder = new StringBuilder();

        if (especialidade.getNome().isBlank() || especialidade.getNome().isEmpty() || especialidade.getNome().length() == 0) {
            builder.append("A especialidade deve ser informado.");
        }

        if (especialidade.getNome().length() > 100) {
            builder.append("A especialidade não pode conter mais que 100 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(especialidade);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Especialidade> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Especialidade especialidade) {
        StringBuilder builder = new StringBuilder();

        if (especialidade.getNome().isBlank() || especialidade.getNome().isEmpty() || especialidade.getNome().length() == 0) {
            builder.append("A especialidade deve ser informado.");
        }

        if (especialidade.getNome().length() > 100) {
            builder.append("A especialidade não pode conter mais que 100 caracteres. ");
        }

        String respostaDB = dal.Atualizar(especialidade);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Especialidade especialidade) {
        String respostaDB = dal.Deletar(especialidade);
        return respostaDB;
    }
}
