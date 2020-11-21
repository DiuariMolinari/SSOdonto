/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataAccessLayer.EnderecoDAL;
import domain.Endereco;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class EnderecoBLL {

    //Obter um registro
    EnderecoDAL dal = new EnderecoDAL();

    //Incluir um registro
    public String Inserir(Endereco endereco) {
        StringBuilder builder = new StringBuilder();

        if (endereco.getCep().isEmpty() || endereco.getCep().trim().length() == 0) {
            builder.append("O CEP deve ser informada.");
        }

        if (endereco.getCep().length() > 9) {
            builder.append("O CEP não pode conter mais que 9 caracteres.");
        }

        if (endereco.getNumeroCasa() < 0 || endereco.getNumeroCasa() != 0) {
            builder.append("O número da casa deve ser informado.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.Inserir(endereco);
        return respostaDB;
    }

    //Obter todos os registros
    public List<Endereco> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Endereco endereco) {
        StringBuilder builder = new StringBuilder();

        if (endereco.getCep().isEmpty() || endereco.getCep().trim().length() == 0) {
            builder.append("O CEP deve ser informada.");
        }

        if (endereco.getCep().length() > 9) {
            builder.append("O CEP não pode conter mais que 9 caracteres. ");
        }

        if (endereco.getNumeroCasa() < 0 || endereco.getNumeroCasa() != 0) {
            builder.append("O número da casa deve ser informado.");
        }
        
        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.Atualizar(endereco);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Endereco endereco) {
        String respostaDB = dal.Deletar(endereco);
        return respostaDB;
    }
}
