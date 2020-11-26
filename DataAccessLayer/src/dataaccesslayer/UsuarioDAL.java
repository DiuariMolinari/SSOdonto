/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Usuario;
import domain.Colaborador;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class UsuarioDAL {
    private final Conexao conexao = new Conexao();
    public Usuario getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE IDUsuario =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Colaborador colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
            return new Usuario(rs.getInt("IDUsuario"), rs.getString("LOGIN"), rs.getString("SENHA"), colaborador);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar usuário. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public Usuario getByColaborador(Colaborador Colaborador) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE IDColaborador =" + Colaborador.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            return new Usuario(rs.getInt("IDUsuario"), rs.getString("LOGIN"), rs.getString("SENHA"), Colaborador);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar usuário. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Usuario getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Usuario ORDER BY IDUsuario DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
            return new Usuario(rs.getInt("IDUsuario"), rs.getString("LOGIN"), rs.getString("SENHA"), Colaborador);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar usuário. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Usuario> getAll() throws SQLException{
        try 
        {
            ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Usuario ORDER BY IDUsuario", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
                Usuarios.add(new Usuario(rs.getInt("IDUsuario"), rs.getString("LOGIN"), rs.getString("SENHA"), Colaborador));
            }
            
            return Usuarios;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar usuários. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Usuario Usuario) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Usuario (IDUsuario, login, senha, idcolaborador) VALUES(0, ?, ?, ?)");
            pst.setString(1, Usuario.getLogin());
            pst.setString(2, Usuario.getSenha());
            pst.setInt(3, Usuario.getColaborador().getId());
            pst.executeUpdate();
            return "Usuário inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir usuário. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Usuario Usuario) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Usuario SET login = ?, senha = ?, idcolaborador = ? WHERE IDUsuario = ?");
            pst.setString(1, Usuario.getLogin());
            pst.setString(2, Usuario.getSenha());
            pst.setInt(3, Usuario.getColaborador().getId());
            pst.setInt(4, Usuario.getId());
            pst.executeUpdate();
            return "Usuário atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar usuário. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Usuario Usuario) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Usuario WHERE IDUsuario = ?");
            pst.setInt(1, Usuario.getId());
            pst.executeUpdate();
            return "Usuário excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar usuário.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }

    public Usuario Autenticar(String login, String password) {
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Usuario WHERE login = ? and senha = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pst.setString(1, login);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();            
            
            rs.first();
            
            return new Usuario(rs.getInt("IDUsuario"), rs.getString("LOGIN"), rs.getString("SENHA"));
        }
        
        catch (Exception e) {
            return null;
        }
        
        finally
        {
            conexao.close();
        }
    }
}