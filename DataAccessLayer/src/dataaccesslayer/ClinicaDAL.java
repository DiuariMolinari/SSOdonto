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
import domain.Endereco;
import domain.Clinica;
import java.sql.Date;
import java.time.ZoneId;

/**
 *
 * @author Diuari
 */
public class ClinicaDAL {
    private final Conexao conexao = new Conexao();
    public Clinica getById(long id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Clinica WHERE IdClinica =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Endereco endereco = new EnderecoDAL().getById(rs.getInt("idEndereco"));
            return new Clinica(rs.getInt("IDClinica"), rs.getString("NOMEClinica"), rs.getDate("dtInauguracao").toLocalDate(), endereco);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar clínica. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Clinica> getByEndereco(Endereco endereco) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Clinica WHERE IdEndereco =" + endereco.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Clinica> clinicas = new ArrayList<Clinica>();
            ResultSet rs = pst.executeQuery();
            while (rs.next()){ 
                clinicas.add(new Clinica(rs.getInt("IDClinica"), rs.getString("NOMEClinica"), rs.getDate("dtInauguracao").toLocalDate(), endereco));
            }
            
            return clinicas;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar clínicas. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Clinica getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Clinica ORDER BY IDClinica DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Endereco endereco = new EnderecoDAL().getById(rs.getInt("IDEndereco"));
            return new Clinica(rs.getInt("IDClinica"), rs.getString("NOMEClinica"), rs.getDate("dtInauguracao").toLocalDate(), endereco);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar clínica. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Clinica> getAll() throws SQLException{
        try 
        {
            ArrayList<Clinica> Clinicas = new ArrayList<Clinica>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Clinica ORDER BY IDClinica", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Endereco endereco = new EnderecoDAL().getById(rs.getInt("IDEndereco"));
                Clinicas.add(new Clinica(rs.getInt("IDClinica"), rs.getString("NOMEClinica"), rs.getDate("dtInauguracao").toLocalDate(), endereco));
            }
            
            return Clinicas;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar clínicas. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Clinica Clinica) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Clinica (IDClinica, NOMEClinica, dtInauguracao, idEndereco) VALUES(0, ?, ?, ?)");
            pst.setString(1, Clinica.getNome());
            pst.setDate(2, Date.valueOf(Clinica.getDataInauguracao()));
            pst.setInt(3, Clinica.getEndereco().getId());
            pst.executeUpdate();
            return "Clínica inserida com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir clínica. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Clinica Clinica) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Clinica SET NOMEClinica = ?, dtInauguracao = ?, idEndereco = ? WHERE IDClinica = ?");
            pst.setString(1, Clinica.getNome());
            pst.setDate(2, Date.valueOf(Clinica.getDataInauguracao()));
            pst.setInt(3, Clinica.getEndereco().getId());
            pst.setInt(4, Clinica.getId());
            pst.executeUpdate();
            return "Clínica atualizada com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar clínica. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Clinica Clinica) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Clinica WHERE IDClinica = ?");
            pst.setInt(1, Clinica.getId());
            pst.executeUpdate();
            return "Clínica excluída com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar clínica.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}