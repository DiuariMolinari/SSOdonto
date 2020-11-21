/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.ProcedimentoDAL;
import domain.Procedimento;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class ProcedimentoBLL {

    ProcedimentoDAL dal = new ProcedimentoDAL();

    //Incluir um registro
    public String Inserir(Procedimento procedimento) {
        StringBuilder builder = new StringBuilder();

        if (procedimento.getNome().isEmpty() || procedimento.getNome().isBlank() || procedimento.getNome().length() == 0) {
            builder.append("O nome do procedimento deve ser informado.");
        }

        if (procedimento.getNome().length() > 60) {
            builder.append("O nome do procedimento não pode conter mais que 60 caracteres.");
        }

        if (procedimento.getDescricaoProcedimento().isEmpty() || procedimento.getDescricaoProcedimento().isBlank() || procedimento.getDescricaoProcedimento().length() == 0) {
            builder.append("A descrição do procedimento deve ser informado.");
        }
        if (procedimento.getDescricaoProcedimento().length() > 60) {
            builder.append("A descrição do procedimento não pode conter mais que 60 caracteres. ");
        };

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(procedimento);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Procedimento> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Procedimento procedimento) {
        StringBuilder builder = new StringBuilder();

        if (procedimento.getNome().isEmpty() || procedimento.getNome().isBlank() || procedimento.getNome().length() == 0) {
            builder.append("O nome do procedimento deve ser informado.");
        }
        if (procedimento.getNome().length() > 60) {
            builder.append("O nome do procedimento não pode conter mais que 60 caracteres. ");
        }

        if (procedimento.getDescricaoProcedimento().isEmpty() || procedimento.getDescricaoProcedimento().isBlank() || procedimento.getDescricaoProcedimento().length() == 0) {
            builder.append("A descrição do procedimento deve ser informado.");
        }
        if (procedimento.getDescricaoProcedimento().length() > 60) {
            builder.append("A descrição do procedimento não pode conter mais que 60 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(procedimento);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Procedimento procedimento) {
        String respostaDB = dal.Deletar(procedimento);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
