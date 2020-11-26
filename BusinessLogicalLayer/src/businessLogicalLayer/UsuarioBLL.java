/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.UsuarioDAL;
import domain.Colaborador;
import domain.Usuario;
import java.util.ArrayList;
import java.sql.SQLException;
import sun.security.validator.ValidatorException;

/**
 *
 * @author Marciele
 */
public class UsuarioBLL {

    UsuarioDAL dal = new UsuarioDAL();

    //Incluir um registro
    public String insert(Usuario usuario) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (usuario.getLogin().isEmpty() || usuario.getLogin().trim().length() == 0) {
            builder.append("O usuário de login deve ser informado.");
        }
        if (usuario.getLogin().length() > 60) {
            builder.append("O usuário de login não pode conter mais que 60 caracteres.");
        }

        if (usuario.getSenha().isEmpty() || usuario.getSenha().trim().length() == 0) {
            builder.append("A senha deve ser informada.");
        }
        if (usuario.getSenha().length() > 250) {
            builder.append("A senha não pode conter mais que 250 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }
        String respostaDB = dal.insert(usuario);
        return respostaDB;
    }

    public boolean Autenticar(String login, String password) throws ValidatorException {
        Usuario user = dal.Autenticar(login, password);
        if (user == null) {
            return false;
        }

        Parametros.UsuarioLogado = user;
        return true;
    }

    // Obter todos os registros
    public ArrayList<Usuario> getAll() throws SQLException {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Usuario usuario) throws SQLException {
        StringBuilder builder = new StringBuilder();

        if (usuario.getLogin().isEmpty() || usuario.getLogin().trim().length() == 0) {
            builder.append("O usuário de login deve ser informado.");
        }
        if (usuario.getLogin().length() > 60) {
            builder.append("O usuário de login não pode conter mais que 60 caracteres.");
        }

        if (usuario.getSenha().isEmpty() || usuario.getSenha().trim().length() == 0) {
            builder.append("A senha deve ser informada.");
        }
        if (usuario.getSenha().length() > 250) {
            builder.append("A senha não pode conter mais que 250 caracteres.");
        }

        if (builder.length() != 0) {
            return builder.toString();
        }

        String respostaDB = dal.update(usuario);
        return respostaDB;
    }

    //Excluir um registro
    public String delete(Usuario usuario) throws SQLException {
        String respostaDB = dal.delete(usuario);
        return respostaDB;
    }

    //Obter um registro
    public Usuario getById(Usuario usuario) throws Exception {
        if (usuario.getId() < 0 || usuario.getId() != 0) {
            throw new Exception("O ID do usuário deve ser informado.");
        }

        return dal.getById(usuario.getId());
    }

    //Obter último registro
    public Usuario getLastRegister() throws SQLException {
        return dal.getLastRegister();
    }
    
    public Usuario getByColaborador(Colaborador colaborador) throws SQLException{
        return dal.getByColaborador(colaborador);
    }
}
