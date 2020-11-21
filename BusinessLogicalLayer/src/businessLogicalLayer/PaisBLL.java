/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.PaisDAL;
import domain.Pais;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class PaisBLL {

    PaisDAL dal = new PaisDAL();

    //Incluir um registro
    public String Inserir(Pais pais) {
        StringBuilder builder = new StringBuilder();

        if (pais.getNome().isEmpty() || pais.getNome().trim().length() == 0) {
            builder.append("O nome do país deve ser informado.");
        }

        if (pais.getNome().length() > 20) {
            builder.append("O nome do país não pode conter mais que 20 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Inserir(pais);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Pais> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Pais pais) {
        StringBuilder builder = new StringBuilder();

        if (pais.getNome().length() > 20) {
            builder.append("O nome do país não pode conter mais que 20 caracteres. ");
        }

        if (pais.getNome().isEmpty() || pais.getNome().trim().length() == 0) {
            builder.append("O nome do país deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(pais);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Pais pais) {
        String respostaDB = dal.Deletar(pais);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
