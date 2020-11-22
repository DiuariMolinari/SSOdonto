/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.TipoPagamento;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class TipoPagamentoDAL {
    private final Conexao conexao = new Conexao();
    public TipoPagamento getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoPagamento WHERE IDTipoPagamento =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoPagamento(rs.getInt("IDTipoPagamento"), rs.getString("TipoPagamento"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Tipo de pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public TipoPagamento getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoPagamento ORDER BY IDTipoPagamento DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoPagamento(rs.getInt("IDTipoPagamento"), rs.getString("TipoPagamento"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipo de pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<TipoPagamento> getAll() throws SQLException{
        try 
        {
            ArrayList<TipoPagamento> TipoPagamentoes = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoPagamento ORDER BY IDTipoPagamento", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                TipoPagamentoes.add(new TipoPagamento(rs.getInt("IDTipoPagamento"), rs.getString("TipoPagamento")));
            
            return TipoPagamentoes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipos de Pagamentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(TipoPagamento TipoPagamento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO TipoPagamento (IDTipoPagamento, TipoPagamento) VALUES(0, ?)");
            pst.setString(1, TipoPagamento.getTipoPagamento());
            pst.executeUpdate();
            return "Tipo de pagamento inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir tipo de pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(TipoPagamento TipoPagamento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE TipoPagamento SET TipoPagamento = ? WHERE IDTipoPagamento = ?");
            pst.setString(1, TipoPagamento.getTipoPagamento());
            pst.setInt(2, TipoPagamento.getId());
            pst.executeUpdate();
            return "Tipo de pagamento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar tipo de pagamento. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(TipoPagamento TipoPagamento) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM TipoPagamento WHERE IDTipoPagamento = ?");
            pst.setInt(1, TipoPagamento.getId());
            pst.executeUpdate();
            return "Tipo de pagamento excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar tipo de pagamento.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}