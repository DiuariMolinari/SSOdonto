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
    
    private ArrayList<Atendimento> getAtendimentos(int idProcedimento) throws SQLException{
        try 
        {
            ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM AtendimentoProcedimentos where idprocedimento = " + idProcedimento, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                //Atendimento atendimento = new AtendimentoDAL().getById(rs.getInt("IDAtendimento"));
                //atendimentos.add(atendimento);
            }
            
            return atendimentos;
        } 
    
    public ArrayList<Procedimento> getByTipoProcedimento(TipoProcedimento TipoProcedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Procedimento WHERE IDTipoProcedimento =" + TipoProcedimento.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Procedimento> Procedimentos = new ArrayList<Procedimento>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Procedimentos.add(new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento));
            
            return Procedimentos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Procedimentos. \n Entre em contato com o suporte.");
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
            return new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento);
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
                Procedimentos.add(new Procedimento(rs.getInt("IDProcedimento"), rs.getString("NOMEProcedimento"), TipoProcedimento));
            }
            
            return Procedimentos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Procedimentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Procedimento Procedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Procedimento (IDProcedimento, NOMEProcedimento, IDTipoProcedimento) VALUES(0, ?, ?)");
            pst.setString(1, Procedimento.getNome());
            pst.setInt(2, Procedimento.getTipoProcedimento().getId());
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
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Procedimento SET NOMEProcedimento = ?, IDTipoProcedimento = ? WHERE IDProcedimento = ?");
            pst.setString(1, Procedimento.getNome());
            pst.setInt(2, Procedimento.getTipoProcedimento().getId());
            pst.setInt(3, Procedimento.getId());
            pst.executeUpdate();
            return "Procedimento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar Procedimento. \n Entre em contato com o suporte.");
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