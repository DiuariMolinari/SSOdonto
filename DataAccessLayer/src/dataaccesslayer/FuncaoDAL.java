/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.Funcao;

/**
 *
 * @author Diuari
 */
public class FuncaoDAL {
    private final Conexao conexao = new Conexao();
    public Funcao getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Funcao WHERE IDFuncao =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new Funcao(rs.getInt("IDFuncao"), rs.getString("NOMEFuncao"), rs.getDouble("SALARIO"), rs.getDouble("COMISSAO"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar um função. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Funcao getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Funcao ORDER BY IDFuncao DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new Funcao(rs.getInt("IDFuncao"), rs.getString("NOMEFuncao"), rs.getDouble("SALARIO"), rs.getDouble("COMISSAO"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar função. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Funcao> getAll() throws SQLException{
        try 
        {
            ArrayList<Funcao> Funcoes = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Funcao ORDER BY IDFuncao", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Funcoes.add(new Funcao(rs.getInt("IDFuncao"), rs.getString("NOMEFuncao"), rs.getDouble("SALARIO"), rs.getDouble("COMISSAO")));
            
            return Funcoes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar funções. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Funcao Funcao) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Funcao (IDFuncao, NOMEFuncao, salario, comissao) VALUES(0, ?, ?, ?)");
            pst.setString(1, Funcao.getNome());
            pst.setDouble(2, Funcao.getSalario());
            pst.setDouble(3, Funcao.getComissao());
            pst.executeUpdate();
            return "Função inserida com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir função. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Funcao Funcao) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Funcao SET NOMEFuncao = ?, SALARIO = ?, COMISSAO = ? WHERE IDFuncao = ?");
            pst.setString(1, Funcao.getNome());
            pst.setDouble(2, Funcao.getSalario());
            pst.setDouble(3, Funcao.getComissao());
            pst.setDouble(4, Funcao.getId());
            pst.executeUpdate();
            return "Função atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar função. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Funcao Funcao) throws SQLException {
        try {
            if (Funcao.getId() == 0) {
                return "Funcao informada inválida!";
            }
            
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Funcao WHERE IDFuncao = ?");
            pst.setInt(1, Funcao.getId());
            pst.executeUpdate();
            return "Função excluída com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar função.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}

