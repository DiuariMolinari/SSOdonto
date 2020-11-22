/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import dataaccesslayer.UsuarioDAL;
import domain.Usuario;
import java.util.List;
import sun.security.validator.ValidatorException;

/**
 *
 * @author Marciele
 */
public class UsuarioBLL {

    UsuarioDAL dal = new UsuarioDAL();

    //Incluir um registro
    public String Inserir(Usuario usuario) {
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
        String respostaDB = dal.Inserir(usuario);
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
    public List<Usuario> LerTodos() {
        return dal.LerTodos();
    }

    //Atualizar um registro existente
    public String Atualizar(Usuario usuario) {
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

        String respostaDB = dal.Atualizar(usuario);
        return respostaDB;
    }

    //Excluir um registro
    public String Deletar(Usuario usuario) {
        String respostaDB = dal.Deletar(usuario);
        return respostaDB;
    }

    //TODO: Obter um registro
}
