/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.TipoEmbalagemDAL;
import domain.TipoEmbalagem;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class TipoEmbalagemBLL {

    TipoEmbalagemDAL dal = new TipoEmbalagemDAL();

    //Incluir um registro
    public String Inserir(TipoEmbalagem tipoEmbalagem) {
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
        String respostaDB = dal.Inserir(tipoEmbalagem);
        return respostaDB;
    }

    // Obter todos os registros
    public List<TipoEmbalagem> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(TipoEmbalagem tipoEmbalagem) {
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

        String respostaDB = dal.Atualizar(tipoEmbalagem);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(TipoEmbalagem tipoEmbalagem) {
        String respostaDB = dal.Deletar(tipoEmbalagem);
        return respostaDB;
    }

    //TODO: Obter um registro  
}
