/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoEmbalagemDAL;
import domain.TipoEmbalagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoEmbalagemBLL {

    TipoEmbalagemDAL dal = new TipoEmbalagemDAL();

    //Incluir um registro
    public String insert(TipoEmbalagem tipoEmbalagem) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (tipoEmbalagem.getDescricao().isEmpty() || tipoEmbalagem.getDescricao().trim().length() == 0) {
            builder.append("A descricao deve ser informado.");
        }

        if (tipoEmbalagem.getDescricao().length() > 60) {
            builder.append("A descricao não pode conter mais que 60 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(tipoEmbalagem);
        return respostaDB;
    }

    // Obter todos os registros
    public ArrayList<TipoEmbalagem> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(TipoEmbalagem tipoEmbalagem) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (tipoEmbalagem.getDescricao().isEmpty() || tipoEmbalagem.getDescricao().trim().length() == 0) {
            builder.append("A descricao deve ser informado.");
        }

        if (tipoEmbalagem.getDescricao().length() > 60) {
            builder.append("A descricao não pode conter mais que 60 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(tipoEmbalagem);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(TipoEmbalagem tipoEmbalagem) throws Exception {
        String respostaDB = dal.delete(tipoEmbalagem);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(TipoEmbalagem tipoEmbalagem) throws Exception {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(TipoEmbalagem tipoEmbalagem) throws Exception {
//
//    }
}
