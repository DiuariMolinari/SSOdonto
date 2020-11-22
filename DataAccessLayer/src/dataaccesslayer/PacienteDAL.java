/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Paciente;
import domain.Endereco;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class PacienteDAL {
    private final Conexao conexao = new Conexao();
    public Paciente getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Paciente WHERE IDPaciente =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            Endereco Endereco = new EnderecoDAL().getById(rs.getInt("IDEndereco"));
            return new Paciente(rs.getInt("IDPaciente"), rs.getString("NOMEPaciente"), rs.getString("SOBRENOME"), rs.getString("rg"), rs.getString("cpf"), rs.getDate("dtNascimento").toLocalDate(), rs.getString("OBS"), Endereco);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar paciente. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Paciente getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Paciente ORDER BY IDPaciente DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Endereco Endereco = new EnderecoDAL().getById(rs.getInt("IDEndereco"));
            return new Paciente(rs.getInt("IDPaciente"), rs.getString("NOMEPaciente"), rs.getString("SOBRENOME"), rs.getString("rg"), rs.getString("cpf"), rs.getDate("dtNascimento").toLocalDate(), rs.getString("OBS"), Endereco);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar paciente. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Paciente> getAll() throws SQLException{
        try 
        {
            ArrayList<Paciente> Pacientes = new ArrayList<Paciente>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Paciente ORDER BY IDPaciente", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Endereco Endereco = new EnderecoDAL().getById(rs.getInt("IDEndereco"));
                Pacientes.add(new Paciente(
                        rs.getInt("IDPaciente"), 
                        rs.getString("NOMEPaciente"), 
                        rs.getString("SOBRENOME"), 
                        rs.getString("rg"), 
                        rs.getString("cpf"), 
                        rs.getDate("dtNascimento").toLocalDate(), 
                        rs.getString("OBS"), Endereco)
                );
            }
            
            return Pacientes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar pacientes. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Paciente Paciente) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Paciente (IDPaciente, nome, sobrenome, rg, cpf, dtNascimento, obs, idendereco) VALUES(0, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, Paciente.getNome());
            pst.setString(2, Paciente.getSobrenome());
            pst.setString(3, Paciente.getRg());
            pst.setString(4, Paciente.getCpf());
            pst.setDate(5, Date.valueOf(Paciente.getDataNascimento()));
            pst.setString(6, Paciente.getObservacao());
            pst.setInt(7, Paciente.getEndereco().getId());
            pst.executeUpdate();
            return "Paciente inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Paciente. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Paciente Paciente) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Paciente SET nome = ?, sobrenome = ?, rg = ?, cpf = ?, dtNascimento = ?, obs = ?, idendereco = ? WHERE IDPaciente = ?");
            pst.setString(1, Paciente.getNome());
            pst.setString(2, Paciente.getSobrenome());
            pst.setString(3, Paciente.getRg());
            pst.setString(4, Paciente.getCpf());
            pst.setDate(5, Date.valueOf(Paciente.getDataNascimento()));
            pst.setString(6, Paciente.getObservacao());
            pst.setInt(7, Paciente.getEndereco().getId());
            pst.setInt(8, Paciente.getId());
            pst.executeUpdate();
            return "Paciente atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar paciente. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Paciente Paciente) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Paciente WHERE IDPaciente = ?");
            pst.setInt(1, Paciente.getId());
            pst.executeUpdate();
            return "Paciente excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar paciente.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}