/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Logradouro;
import domain.Endereco;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class EnderecoDAL {
    private final Conexao conexao = new Conexao();
    public Endereco getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Endereco WHERE IDEndereco =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Logradouro logradouro = new LogradouroDAL().getById(rs.getInt("IDLOGRADOURO"));
            return new Endereco(rs.getInt("IDEndereco"), logradouro, rs.getInt("NUMEROCASA"), rs.getString("CEP"));
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar endereco. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Endereco> getByLogradouro(Logradouro logradouro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Endereco WHERE IDLogradouro =" + logradouro.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Endereco> Enderecos = new ArrayList<Endereco>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Enderecos.add(new Endereco(rs.getInt("IDEndereco"), logradouro, rs.getInt("numeroCasa"), rs.getString("CEP")));
            
            return Enderecos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar endereços. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Endereco getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Endereco ORDER BY IDEndereco DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Logradouro logradouro = new LogradouroDAL().getById(rs.getInt("IDLOGRADOURO"));
            return new Endereco(rs.getInt("IDEndereco"), logradouro, rs.getInt("numeroCasa"), rs.getString("cep"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar endereço. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Endereco> getAll() throws SQLException{
        try 
        {
            ArrayList<Endereco> Enderecos = new ArrayList<Endereco>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Endereco ORDER BY IDEndereco", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Logradouro logradouro = new LogradouroDAL().getById(rs.getInt("IDLogradouro"));
                Enderecos.add(new Endereco(rs.getInt("IDEndereco"), logradouro, rs.getInt("numeroCasa"), rs.getString("cep")));
            }
            
            return Enderecos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar endereços. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Endereco endereco) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Endereco (IDEndereco, IDLOGRADOURO, NUMEROCASA, CEP) VALUES(0, ?, ?, ?)");
            pst.setInt(1, endereco.getLogradouro().getId());
            pst.setInt(2, endereco.getNumeroCasa());
            pst.setString(3, endereco.getCep());
            pst.executeUpdate();
            return "Endereço inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir endereço. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Endereco Endereco) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Endereco SET IDLOGRADOURO = ?, NUMEROCASA = ?, CEP = ? WHERE IDEndereco = ?");
            pst.setInt(1, Endereco.getLogradouro().getId());
            pst.setInt(2, Endereco.getNumeroCasa());
            pst.setString(3, Endereco.getCep());
            pst.setInt(4, Endereco.getId());
            pst.executeUpdate();
            return "Endereço atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar endereço. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Endereco Endereco) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Endereco WHERE IDEndereco = ?");
            pst.setInt(1, Endereco.getId());
            pst.executeUpdate();
            return "Endereço excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar endereço.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}