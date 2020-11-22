/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.UsuarioDAL;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import sun.security.validator.ValidatorException;

/**
 *
 * @author Marciele
 */
public class UsuarioBLL {

    UsuarioDAL dal = new UsuarioDAL();

    //Incluir um registro
    public String insert(Usuario usuario) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (usuario.getUsuario().isEmpty() || usuario.getUsuario().trim().length() == 0) {
            builder.append("O usuário de login deve ser informado.");
        }
        if (usuario.getUsuario().length() > 60) {
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

    public void Autenticar(String login, String password) throws Exception {
        Usuario user = dal.Autenticar(login, password);
        if (user == null) {
            throw new Exception("Usuário e/ou senha inválidos.");
        }
        Parametros.UsuarioLogado = user;
    }

    // Obter todos os registros
    public ArrayList<Usuario> getAll() throws Exception {
        return dal.getAll();
    }

    //Atualizar um registro existente
    public String update(Usuario usuario) throws Exception {
        StringBuilder builder = new StringBuilder();

        if (usuario.getUsuario().isEmpty() || usuario.getUsuario().trim().length() == 0) {
            builder.append("O usuário de login deve ser informado.");
        }
        if (usuario.getUsuario().length() > 60) {
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
    public String delete(Usuario usuario) throws Exception {
        String respostaDB = dal.delete(usuario);
        return respostaDB;
    }

    //    //Obter um registro
//    public String getById(Usuario usuario) throws Exception {
//
//    }
//
//    //Obter último registro
//    public String getLastRegister(Usuario usuario) throws Exception {
//
//    }
}
