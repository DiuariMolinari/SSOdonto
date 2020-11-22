/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Pais;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class PaisDAL {
    private final Conexao conexao = new Conexao();
    public Pais getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM PAIS WHERE IDPAIS =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new Pais(rs.getInt("IDPAIS"), rs.getString("NOMEPAIS"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar país. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Pais getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM PAIS ORDER BY IDPAIS DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new Pais(rs.getInt("IDPAIS"), rs.getString("NOMEPAIS"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar país. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Pais> getAll() throws SQLException{
        try 
        {
            ArrayList<Pais> paises = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM PAIS ORDER BY IDPAIS", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                paises.add(new Pais(rs.getInt("IDPAIS"), rs.getString("NOMEPAIS")));
            
            return paises;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar paises. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Pais pais) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO PAIS (IDPAIS, NOMEPAIS) VALUES(0, ?)");
            pst.setString(1, pais.getNome());
            pst.executeUpdate();
            return "País inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir país. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Pais pais) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE PAIS SET NOMEPAIS = ? WHERE IDPAIS = ?");
            pst.setString(1, pais.getNome());
            pst.setInt(2, pais.getId());
            pst.executeUpdate();
            return "País atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar país. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Pais pais) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM PAIS WHERE IDPAIS = ?");
            pst.setInt(1, pais.getId());
            pst.executeUpdate();
            return "País excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar país.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}