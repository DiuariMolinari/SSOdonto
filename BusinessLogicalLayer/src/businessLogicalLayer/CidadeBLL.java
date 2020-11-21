/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import domain.Cidade;

/**
 *
 * @author Marciele
 */
public class CidadeBLL {
    // Obter todos os registros
    //Obter um registro
    //Incluir um registro
    //Atualizar um registro existente
    //Excluir um registro

    //BairroDAL dal = new BairroDAL();

    public String Inserir(Cidade cidade) {
        StringBuilder erros = new StringBuilder();
        if (String.IsNullOrWhiteSpace(cidade.Nome)) {
            erros.AppendLine("O nome deve ser informado.");
        }

        if (cidade.Nome.Length > 50) {
            erros.AppendLine("O nome não pode conter mais que 50 caracteres.");
        }

        if (String.IsNullOrWhiteSpace(cidade.Senha)) {
            erros.AppendLine("A senha deve ser informada.");
        }
        if (atendimento.Senha.Length > 50) {
            erros.AppendLine("A senha não pode conter mais que 50 caracteres.");
        }

        if (String.IsNullOrWhiteSpace(cidade.Usuario)) {
            erros.AppendLine("O usuário deve ser informado.");
        }
        if (atendimento.Usuario.Length > 50) {
            erros.AppendLine("O usuário não pode conter mais que 50 caracteres.");
        }

        if (erros.Length != 0) {
            return erros.ToString();
        }
        String respostaDB = dal.Inserir(cidade);
        return respostaDB;
    }

    public void Autenticar(String user, String senha) {
        cidade c = dal.Autenticar(user, senha);
        if (c == null) {
            throw new Exception("Usuário e/ou senha inválidos.");
        }
        Parametros.FuncionarioLogado = c;
    }

    public List<Cidade> LerTodos() {
        return dal.LerTodos();
    }

    public String Atualizar(Cidade cidade) {
        StringBuilder erros = new StringBuilder();

        if (cidade.Usuario.Length > 50) {
            erros.AppendLine("O usuário não pode conter mais que 50 caracteres. ");
        }

        if (string.IsNullOrWhiteSpace(cidade.Usuario)) {
            erros.AppendLine("O usuário deve ser informado.");
        }

        if (string.IsNullOrWhiteSpace(cidade.Senha)) {
            erros.AppendLine("A senha deve ser informada.");
        }

        if (cidade.Senha.Length > 50) {
            erros.AppendLine("A senha não pode conter mais que 50 caracteres. ");
        }

        String respostaDB = dal.Atualizar(cidade);
        return respostaDB;
    }

    public String Deletar(cidade atendimento) {
        String respostaDB = dal.Deletar(atendimento);
        return respostaDB;
    }
}
