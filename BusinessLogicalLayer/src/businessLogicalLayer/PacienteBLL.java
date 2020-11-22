/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.PacienteDAL;
import domain.Paciente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marciele
 */
public class PacienteBLL {

    PacienteDAL dal = new PacienteDAL();

    //Incluir um registro
    public String Inserir(Paciente paciente) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (paciente.getNome().isEmpty() || paciente.getNome().trim().length() == 0) {
            builder.append("O nome do paciente deve ser informado.");
        }

        if (paciente.getNome().length() > 60) {
            builder.append("O nome do paciente não pode conter mais que 60 caracteres.");
        }

        if (paciente.getSobrenome().isEmpty() || paciente.getSobrenome().trim().length() == 0) {
            builder.append("O sobrenome do paciente deve ser informado.");
        }

        if (paciente.getSobrenome().length() > 60) {
            builder.append("O sobrenome do paciente não pode conter mais que 60 caracteres.");
        }

        if (paciente.getRg().isEmpty() || paciente.getRg().trim().length() == 0) {
            builder.append("O RG deve ser informado.");
        }

        if (paciente.getRg().length() > 20) {
            builder.append("O RG não pode conter mais que 20 caracteres.");
        }

        if (paciente.getCpf().isEmpty() || paciente.getCpf().trim().length() == 0) {
            builder.append("O CPF deve ser informado.");
        }

        if (paciente.getCpf().length() > 14) {
            builder.append("O CPF não pode conter mais que 14 caracteres.");
        }

        if (paciente.getDataNascimento().equals("") || paciente.getDataNascimento() == null) {
            builder.append("A data de nascimento do paciente deve ser informado.");
        }

        if (paciente.getObservacao().isEmpty() || paciente.getObservacao().trim().length() == 0) {
            builder.append("As observações do paciente deve ser informado.");
        }

        if (paciente.getObservacao().length() > 250) {
            builder.append("As observações do paciente não pode conter mais que 250 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(paciente);
        return respostaDB;
    }

    // Obter todos os registros
    public List<Paciente> LerTodos() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String Atualizar(Paciente paciente) throws SQLException {
        StringBuilder builder = new StringBuilder();

       if (paciente.getNome().isEmpty() || paciente.getNome().trim().length() == 0) {
            builder.append("O nome do paciente deve ser informado.");
        }

        if (paciente.getNome().length() > 60) {
            builder.append("O nome do paciente não pode conter mais que 60 caracteres.");
        }

        if (paciente.getSobrenome().isEmpty() || paciente.getSobrenome().trim().length() == 0) {
            builder.append("O sobrenome do paciente deve ser informado.");
        }

        if (paciente.getSobrenome().length() > 60) {
            builder.append("O sobrenome do paciente não pode conter mais que 60 caracteres.");
        }

        if (paciente.getRg().isEmpty() || paciente.getRg().trim().length() == 0) {
            builder.append("O RG deve ser informado.");
        }

        if (paciente.getRg().length() > 20) {
            builder.append("O RG não pode conter mais que 20 caracteres.");
        }

        if (paciente.getCpf().isEmpty() || paciente.getCpf().trim().length() == 0) {
            builder.append("O CPF deve ser informado.");
        }

        if (paciente.getCpf().length() > 14) {
            builder.append("O CPF não pode conter mais que 14 caracteres.");
        }

        if (paciente.getDataNascimento().equals("") || paciente.getDataNascimento() == null) {
            builder.append("A data de nascimento do paciente deve ser informado.");
        }

        if (paciente.getObservacao().isEmpty() || paciente.getObservacao().trim().length() == 0) {
            builder.append("As observações do paciente deve ser informado.");
        }

        if (paciente.getObservacao().length() > 250) {
            builder.append("As observações do paciente não pode conter mais que 250 caracteres.");
        }
        
        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(paciente);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Paciente paciente) throws SQLException {
        String respostaDB = dal.delete(paciente);
        return respostaDB;
    }

    //TODO: Obter um registro
}
