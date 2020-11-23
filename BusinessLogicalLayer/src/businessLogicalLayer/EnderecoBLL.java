/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.EnderecoDAL;
import domain.Endereco;
import java.util.ArrayList;
import java.sql.SQLException;
import domain.Logradouro;

/**
 *
 * @author Marciele
 */
public class EnderecoBLL {

    EnderecoDAL dal = new EnderecoDAL();

    //Incluir um registro
    public String insert(Endereco endereco) throws SQLException {
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
        String respostaDB = dal.insert(endereco);
        return respostaDB;
    }

    //Obter todos os registros
    public ArrayList<Endereco> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Endereco endereco) throws SQLException {
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

        String respostaDB = dal.update(endereco);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Endereco endereco) throws SQLException {
        String respostaDB = dal.delete(endereco);
        return respostaDB;
    }

    //Obter um registro
    public Endereco getById(Endereco endereco) throws Exception {
        if (endereco.getId() != 0 || endereco.getId() < 0) {
            throw new Exception("O ID do endereco deve ser informado.");
        }

        return dal.getById(endereco.getId());
    }

    //Obter último registro
    public Endereco getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    //Obter registros de determinado estado
    public ArrayList<Endereco> getByLogradouro(Logradouro logradouro) throws SQLException {
        return dal.getByLogradouro(logradouro);
    }
}
