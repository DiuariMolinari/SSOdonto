/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.FoneTipo;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class FoneTipoDAL {
    private final Conexao conexao = new Conexao();
    public FoneTipo getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM FoneTipo WHERE IDFoneTipo =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new FoneTipo(rs.getInt("IDFoneTipo"), rs.getString("tipo"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Tipo de telefone. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public FoneTipo getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM FoneTipo ORDER BY IDFoneTipo DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new FoneTipo(rs.getInt("IDFoneTipo"), rs.getString("tipo"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Tipo de telefone. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<FoneTipo> getAll() throws SQLException{
        try 
        {
            ArrayList<FoneTipo> FoneTipoes = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM FoneTipo ORDER BY IDFoneTipo", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                FoneTipoes.add(new FoneTipo(rs.getInt("IDFoneTipo"), rs.getString("tipo")));
            
            return FoneTipoes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipos de Telefones. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(FoneTipo FoneTipo) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO FoneTipo (IDFoneTipo, tipo) VALUES(0, ?)");
            pst.setString(1, FoneTipo.getTipo());
            pst.executeUpdate();
            return "Tipo de telefone inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Tipo de telefone. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(FoneTipo FoneTipo) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE FoneTipo SET tipo = ? WHERE IDFoneTipo = ?");
            pst.setString(1, FoneTipo.getTipo());
            pst.setInt(2, FoneTipo.getId());
            pst.executeUpdate();
            return "Tipo de telefone atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar Tipo de telefone. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(FoneTipo FoneTipo) throws SQLException {
        try {
            if (FoneTipo.getId() == 0) {
                return "Tipo de telefone informado é inválido!";
            }
            
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM FoneTipo WHERE IDFoneTipo = ?");
            pst.setInt(1, FoneTipo.getId());
            pst.executeUpdate();
            return "Tipo de telefone excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Tipo de telefone.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}