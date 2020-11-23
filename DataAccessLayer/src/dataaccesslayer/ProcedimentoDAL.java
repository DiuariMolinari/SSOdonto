/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import domain.Atendimento;
import domain.Procedimento;
import domain.TipoProcedimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class ProcedimentoDAL {
    private final Conexao conexao = new Conexao();
    public Procedimento getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Procedimento WHERE IDProcedimento =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            TipoProcedimento TipoProcedimento = new TipoProcedimentoDAL().getById(rs.getInt("IDTipoProcedimento"));
            ArrayList<Atendimento> atendimentos = getAtendimentos(rs.getInt("idProcedimento"));
            return new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento, rs.getString("dsProcedimento"), atendimentos);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public ArrayList<Atendimento> getAtendimentos(int idProcedimento) throws SQLException {
        try 
        {
            ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM AtendimentoProcedimentos where idprocedimento = " + idProcedimento, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Atendimento atendimento = new AtendimentoDAL().getById(rs.getInt("IDAtendimento"));
                atendimentos.add(atendimento);
            }
            
            return atendimentos;
        } 
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
   
    
     public Procedimento getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Procedimento ORDER BY IDProcedimento DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            TipoProcedimento TipoProcedimento = new TipoProcedimentoDAL().getById(rs.getInt("IDTipoProcedimento"));
            ArrayList<Atendimento> atendimentos = getAtendimentos(rs.getInt("idProcedimento"));
            return new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento, rs.getString("dsProcedimento"), atendimentos);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Procedimento> getAll() throws SQLException{
        try 
        {
            ArrayList<Procedimento> Procedimentos = new ArrayList<Procedimento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Procedimento ORDER BY IDProcedimento", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                TipoProcedimento TipoProcedimento = new TipoProcedimentoDAL().getById(rs.getInt("IDTipoProcedimento"));
                ArrayList<Atendimento> atendimentos = getAtendimentos(rs.getInt("idProcedimento"));
                Procedimentos.add(new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento, rs.getString("dsProcedimento"), atendimentos));
            }
            
            return Procedimentos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar procedimentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Procedimento Procedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Procedimento (IDProcedimento, NOMEProcedimento, dsProcedimento, IDTipoProcedimento) VALUES(0, ?, ?, ?)");
            pst.setString(1, Procedimento.getNome());
            pst.setString(2, Procedimento.getDescricaoProcedimento());
            pst.setInt(3, Procedimento.getTipoProcedimento().getId());
            pst.executeUpdate();
            return "Procedimento inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Procedimento Procedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Procedimento SET NOMEProcedimento = ?, dsProcedimento, IDTipoProcedimento = ? WHERE IDProcedimento = ?");
            pst.setString(1, Procedimento.getNome());
            pst.setString(2, Procedimento.getDescricaoProcedimento());
            pst.setInt(3, Procedimento.getTipoProcedimento().getId());
            pst.setInt(4, Procedimento.getId());
            pst.executeUpdate();
            return "Procedimento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar procedimento. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Procedimento Procedimento) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Procedimento WHERE IDProcedimento = ?");
            pst.setInt(1, Procedimento.getId());
            pst.executeUpdate();
            return "Procedimento excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Procedimento.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}