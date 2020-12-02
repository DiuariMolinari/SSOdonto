/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoEmbalagemDAL;
import domain.TipoEmbalagem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoEmbalagemBLL {

    TipoEmbalagemDAL dal = new TipoEmbalagemDAL();

    //Incluir um registro
    public String insert(TipoEmbalagem tipoEmbalagem) throws SQLException {
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
    public ArrayList<TipoEmbalagem> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(TipoEmbalagem tipoEmbalagem) throws SQLException {
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
    public String delete(TipoEmbalagem tipoEmbalagem) throws SQLException {
        String respostaDB = dal.delete(tipoEmbalagem);
        return respostaDB;
    }

    //Obter um registro
    public TipoEmbalagem getById(TipoEmbalagem tipoEmbalagem) throws Exception {
        if (tipoEmbalagem.getId() < 0 || tipoEmbalagem.getId() == 0) {
            throw new Exception("O ID do tipo de embalagem deve ser informado.");
        }

        return dal.getById(tipoEmbalagem.getId());
    }

    //Obter último registro
    public TipoEmbalagem getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
}
