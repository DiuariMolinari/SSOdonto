/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Bairro;
import domain.Logradouro;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class LogradouroDAL {
    private final Conexao conexao = new Conexao();
    public Logradouro getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Logradouro WHERE IDLogradouro =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Bairro bairro = new BairroDAL().getById(rs.getInt("IDBAIRRO"));
            return new Logradouro(rs.getInt("IDLogradouro"), rs.getString("NOMELogradouro"), bairro);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar logradouro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Logradouro> getByBairro(Bairro bairro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Logradouro WHERE IDLogradouro =" + bairro.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Logradouro> Logradouros = new ArrayList<Logradouro>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Logradouros.add(new Logradouro(rs.getInt("IDLogradouro"), rs.getString("NOMELogradouro"), bairro));
            
            return Logradouros;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar logradouros. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Logradouro getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Logradouro ORDER BY IDLogradouro DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Bairro bairro = new BairroDAL().getById(rs.getInt("IDBAIRRO"));
            return new Logradouro(rs.getInt("IDLogradouro"), rs.getString("NOMELogradouro"), bairro);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar logradouro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Logradouro> getAll() throws SQLException{
        try 
        {
            ArrayList<Logradouro> Logradouros = new ArrayList<Logradouro>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Logradouro ORDER BY IDLogradouro", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Bairro bairro = new BairroDAL().getById(rs.getInt("IDBAIRRO"));
                Logradouros.add(new Logradouro(rs.getInt("IDLogradouro"), rs.getString("NOMELogradouro"), bairro));
            }
            
            return Logradouros;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar logradouros. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Logradouro Logradouro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Logradouro (IDLogradouro, NOMELogradouro, IDBAIRRO) VALUES(0, ?, ?)");
            pst.setString(1, Logradouro.getNome());
            pst.setInt(2, Logradouro.getBairro().getId());
            pst.executeUpdate();
            return "Logradouro inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir logradouro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Logradouro Logradouro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Logradouro SET NOMELogradouro = ?, IDBAIRRO = ? WHERE IDLogradouro = ?");
            pst.setString(1, Logradouro.getNome());
            pst.setInt(2, Logradouro.getBairro().getId());
            pst.setInt(3, Logradouro.getId());
            pst.executeUpdate();
            return "Logradouro atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar Logradouro. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Logradouro Logradouro) throws SQLException {
        try {
            if (Logradouro.getId() == 0) {
                return "Logradouro informada inválido!";
            }
            
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Logradouro WHERE IDLogradouro = ?");
            pst.setInt(1, Logradouro.getId());
            pst.executeUpdate();
            return "Logradouro excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Logradouro.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}