/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.ContatoDAL;
import domain.Colaborador;
import domain.Contato;
import domain.Paciente;
import java.util.ArrayList;
import java.sql.SQLException;

/**
 *
 * @author Marciele
 */
public class ContatoBLL {

    ContatoDAL dal = new ContatoDAL();

    //Incluir um registro
    public String insert(Contato contato) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isEmpty() || contato.getFone().trim().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }

        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres.");
        }

        if (contato.getEmail().isEmpty() || contato.getEmail().trim().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.insert(contato);
        return respostaDB;
    }

    //Obter todos os registros
    public ArrayList<Contato> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Contato contato) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (contato.getFone().isEmpty() || contato.getFone().trim().length() == 0) {
            builder.append("O telefone deve ser informado.");
        }
        if (contato.getFone().length() > 20) {
            builder.append("O telefone não pode conter mais que 20 caracteres. ");
        }

        if (contato.getEmail().isEmpty() || contato.getEmail().trim().length() == 0) {
            builder.append("O email deve ser informada.");
        }
        if (contato.getEmail().length() > 50) {
            builder.append("O email não pode conter mais que 50 caracteres. ");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(contato);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Contato contato) throws SQLException {
        String respostaDB = dal.delete(contato);
        return respostaDB;
    }

    //Obter um registro
    public Contato getById(Contato contato) throws Exception {
        if (contato.getId() != 0 || contato.getId() < 0) {
            throw new Exception("O ID do contato deve ser informado.");
        }
        return dal.getById(contato.getId());
    }

    //Obter último registro
    public Contato getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }

    //Obtem os contatos do colaborador
    public ArrayList<Contato> getByColaborador(Colaborador colaborador) throws SQLException {
        return dal.getByColaborador(colaborador);
    }

    //Obtem os contatos do paciente
    public ArrayList<Contato> getByPaciente(Paciente paciente) throws SQLException {
        return dal.getByPaciente(paciente);
    }
}
