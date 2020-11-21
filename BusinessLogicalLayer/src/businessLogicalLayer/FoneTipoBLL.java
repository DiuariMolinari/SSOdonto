/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.FoneTipoDAL;
import domain.FoneTipo;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class FoneTipoBLL {

    FoneTipoDAL dal = new FoneTipoDAL();

    //Incluir um registro
    public String Inserir(FoneTipo foneTipo) {
        StringBuilder builder = new StringBuilder();

        if (foneTipo.getTipo().isBlank() || foneTipo.getTipo().isEmpty() || foneTipo.getTipo().length() == 0) {
            builder.append("O tipo de contato deve ser informado.");
        }

        if (foneTipo.getTipo().length() > 60) {
            builder.append("O tipo de contato não pode conter mais que 60 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(foneTipo);
        return respostaDB;
    }

    // Obter todos os registros
    public List<FoneTipo> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(FoneTipo foneTipo) {
        StringBuilder builder = new StringBuilder();

        if (foneTipo.getTipo().isBlank() || foneTipo.getTipo().isEmpty() || foneTipo.getTipo().length() == 0) {
            builder.append("O tipo de contato deve ser informado.");
        }

        if (foneTipo.getTipo().length() > 60) {
            builder.append("O tipo de contato não pode conter mais que 60 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(foneTipo);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(FoneTipo foneTipo) {
        String respostaDB = dal.Deletar(foneTipo);
        return respostaDB;
    }

    //TODO: Obter um registro
}
