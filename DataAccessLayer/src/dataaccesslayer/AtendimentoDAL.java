/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import domain.Procedimento;
import domain.Atendimento;
import domain.Paciente;
import domain.Colaborador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class AtendimentoDAL {
    private final Conexao conexao = new Conexao();
    public Atendimento getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Atendimento WHERE IDAtendimento =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
            Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
            ArrayList<Procedimento> procedimentos = getProcedimentos(rs.getInt("idAtendimento"));
            return new Atendimento(rs.getInt("IDAtendimento"), Paciente, Colaborador, procedimentos);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar atendimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    private ArrayList<Procedimento> getProcedimentos(int idAtendimento) throws SQLException {
        try 
        {
            ArrayList<Procedimento> Procedimentos = new ArrayList<Procedimento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM AtendimentoAtendimentos where idAtendimento = " + idAtendimento, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Procedimento Procedimento = new ProcedimentoDAL().getById(rs.getInt("IDProcedimento"));
                Procedimentos.add(Procedimento);
            }
            
            return Procedimentos;
        } 
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Atendimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
   
    
     public Atendimento getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Atendimento ORDER BY IDAtendimento DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
            Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
            ArrayList<Procedimento> procedimentos = getProcedimentos(rs.getInt("idAtendimento"));
            return new Atendimento(rs.getInt("IDAtendimento"), Paciente, Colaborador, procedimentos);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar atendimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Atendimento> getAll() throws SQLException{
        try 
        {
            ArrayList<Atendimento> Atendimentos = new ArrayList<Atendimento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Atendimento ORDER BY IDAtendimento", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
                Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
                ArrayList<Procedimento> procedimentos = getProcedimentos(rs.getInt("idAtendimento"));
                Atendimentos.add(new Atendimento(rs.getInt("IDAtendimento"), Paciente, Colaborador, procedimentos));
            }
            
            return Atendimentos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar atendimentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Atendimento Atendimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Atendimento (IDAtendimento, idPaciente, idcolaborador) VALUES(0, ?, ?)");
            pst.setInt(1, Atendimento.getPaciente().getId());
            pst.setInt(2, Atendimento.getColaborador().getId());
            pst.executeUpdate();
            return "Atendimento inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir atendimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Atendimento Atendimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Atendimento SET idPaciente = ?, idcolaborador = ?  WHERE IDAtendimento = ?");
            pst.setInt(1, Atendimento.getPaciente().getId());
            pst.setInt(2, Atendimento.getColaborador().getId());
            pst.setInt(2, Atendimento.getId());
            pst.executeUpdate();
            return "Atendimento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar atendimento. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Atendimento Atendimento) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Atendimento WHERE IDAtendimento = ?");
            pst.setInt(1, Atendimento.getId());
            pst.executeUpdate();
            return "Atendimento excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Atendimento.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}