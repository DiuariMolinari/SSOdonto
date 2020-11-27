/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.TipoProcedimento;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class TipoProcedimentoDAL {
    private final Conexao conexao = new Conexao();
    public TipoProcedimento getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoProcedimento WHERE IDTipoProcedimento =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoProcedimento(rs.getInt("IDTipoProcedimento"), rs.getString("NOMETipoProcedimento"), rs.getDouble("valorProcedimento"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipo de procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public TipoProcedimento getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoProcedimento ORDER BY IDTipoProcedimento DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoProcedimento(rs.getInt("IDTipoProcedimento"), rs.getString("NOMETipoProcedimento"), rs.getDouble("valorProcedimento"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipo de procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<TipoProcedimento> getAll() throws SQLException{
        try 
        {
            ArrayList<TipoProcedimento> TipoProcedimentoes = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoProcedimento ORDER BY IDTipoProcedimento", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                TipoProcedimentoes.add(new TipoProcedimento(rs.getInt("IDTipoProcedimento"), rs.getString("NOMETipoProcedimento"), rs.getDouble("valorProcedimento")));
            
            return TipoProcedimentoes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipos de procedimentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(TipoProcedimento TipoProcedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO TipoProcedimento (IDTipoProcedimento, NOMETipoProcedimento, ValorProcedimento) VALUES(0, ?, ?)");
            pst.setString(1, TipoProcedimento.getNome());
            pst.setDouble(2, TipoProcedimento.getValor());
                        
            pst.executeUpdate();
            return "Tipo de procedimento inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir tipo de procedimento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(TipoProcedimento TipoProcedimento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE TipoProcedimento SET NOMETipoProcedimento = ?, valorProcedimento = ? WHERE IDTipoProcedimento = ?");
            pst.setString(1, TipoProcedimento.getNome());
            pst.setDouble(2, TipoProcedimento.getValor());
            pst.setInt(3, TipoProcedimento.getId());
            pst.executeUpdate();
            return "Tipo de procedimento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar tipo de procedimento. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(TipoProcedimento TipoProcedimento) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM TipoProcedimento WHERE IDTipoProcedimento = ?");
            pst.setInt(1, TipoProcedimento.getId());
            pst.executeUpdate();
            return "Tipo de procedimento excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar tipo de procedimento.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}