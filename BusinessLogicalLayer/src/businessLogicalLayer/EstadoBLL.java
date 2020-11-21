/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogicalLayer;

import domain.Estado;

/**
 *
 * @author Marciele
 */
public class EstadoBLL {
    // Obter todos os registros
    //Obter um registro
    //Incluir um registro
    //Atualizar um registro existente
    //Excluir um registro

    //BairroDAL dal = new BairroDAL();

    public String Inserir(Bairro bairro) {
        StringBuilder erros = new StringBuilder();
        if (String.IsNullOrWhiteSpace(bairro.Nome)) {
            erros.AppendLine("O nome deve ser informado.");
        }

        if (bairro.Nome.Length > 50) {
            erros.AppendLine("O nome não pode conter mais que 50 caracteres.");
        }

        if (String.IsNullOrWhiteSpace(bairro.Senha)) {
            erros.AppendLine("A senha deve ser informada.");
        }
        if (atendimento.Senha.Length > 50) {
            erros.AppendLine("A senha não pode conter mais que 50 caracteres.");
        }

        if (String.IsNullOrWhiteSpace(bairro.Usuario)) {
            erros.AppendLine("O usuário deve ser informado.");
        }
        if (atendimento.Usuario.Length > 50) {
            erros.AppendLine("O usuário não pode conter mais que 50 caracteres.");
        }

        if (erros.Length != 0) {
            return erros.ToString();
        }
        String respostaDB = dal.Inserir(bairro);
        return respostaDB;
    }

    public void Autenticar(String user, String senha) {
        atendimento a = dal.Autenticar(user, senha);
        if (a == null) {
            throw new Exception("Usuário e/ou senha inválidos.");
        }
        Parametros.FuncionarioLogado = a;
    }

    public List<Atendimento> LerTodos() {
        return dal.LerTodos();
    }

    public String Atualizar(Atendimento atendimento) {
        StringBuilder erros = new StringBuilder();

        if (atendimento.Usuario.Length > 50) {
            erros.AppendLine("O usuário não pode conter mais que 50 caracteres. ");
        }

        if (string.IsNullOrWhiteSpace(atendimento.Usuario)) {
            erros.AppendLine("O usuário deve ser informado.");
        }

        if (string.IsNullOrWhiteSpace(atendimento.Senha)) {
            erros.AppendLine("A senha deve ser informada.");
        }

        if (atendimento.Senha.Length > 50) {
            erros.AppendLine("A senha não pode conter mais que 50 caracteres. ");
        }

        String respostaDB = dal.Atualizar(atendimento);
        return respostaDB;
    }

    public String Deletar(Atendimento atendimento) {
        String respostaDB = dal.Deletar(atendimento);
        return respostaDB;
    }
}
