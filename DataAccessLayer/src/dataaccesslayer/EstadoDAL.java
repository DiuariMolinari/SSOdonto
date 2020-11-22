/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Estado;
import domain.Pais;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class EstadoDAL {
    private final Conexao conexao = new Conexao();
    public Estado getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM ESTADO WHERE IDESTADO =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Pais pais = new PaisDAL().getById(rs.getInt("IDPAIS"));
            return new Estado(rs.getInt("IDESTADO"), rs.getString("NOMEESTADO"), pais);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estado. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Estado> getByPais(Pais pais) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM ESTADO WHERE IDPAIS =" + pais.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Estado> estados = new ArrayList<Estado>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                estados.add(new Estado(rs.getInt("IDESTADO"), rs.getString("NOMEESTADO"), pais));
            
            return estados;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estados. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Estado getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM ESTADO ORDER BY IDESTADO DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Pais pais = new PaisDAL().getById(rs.getInt("IDPAIS"));
            return new Estado(rs.getInt("IDESTADO"), rs.getString("NOMEESTADO"), pais);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estado. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Estado> getAll() throws SQLException{
        try 
        {
            ArrayList<Estado> estados = new ArrayList<Estado>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM ESTADO ORDER BY IDESTADO", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Pais pais = new PaisDAL().getById(rs.getInt("IDPAIS"));
                estados.add(new Estado(rs.getInt("IDESTADO"), rs.getString("NOMEESTADO"), pais));
            }
            
            return estados;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estados. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Estado estado) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO ESTADO (IDESTADO, NOMEESTADO, IDPAIS) VALUES(0, ?, ?)");
            pst.setString(1, estado.getNome());
            pst.setInt(2, estado.getPais().getId());
            pst.executeUpdate();
            return "Estado inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir estado. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Estado estado) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE ESTADO SET NOMEESTADO = ?, IDPAIS = ? WHERE IDESTADO = ?");
            pst.setString(1, estado.getNome());
            pst.setInt(2, estado.getPais().getId());
            pst.setInt(3, estado.getId());
            pst.executeUpdate();
            return "Estado atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar estado. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Estado estado) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM ESTADO WHERE IDESTADO = ?");
            pst.setInt(1, estado.getId());
            pst.executeUpdate();
            return "Estado excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar estado.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}