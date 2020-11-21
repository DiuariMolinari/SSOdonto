/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Pagamento;
import domain.TipoPagamento;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class PagamentoDAL {
    private final Conexao conexao = new Conexao();
    public Pagamento getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Pagamento WHERE IDPagamento =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            TipoPagamento TipoPagamento = new TipoPagamentoDAL().getById(rs.getInt("IDTipoPagamento"));
            return new Pagamento(rs.getInt("IDPagamento"), rs.getDate("dtPagamento").toLocalDate(), TipoPagamento);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Pagamento> getByTipoPagamento(TipoPagamento TipoPagamento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Pagamento WHERE IDTipoPagamento =" + TipoPagamento.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Pagamento> Pagamentos = new ArrayList<Pagamento>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Pagamentos.add(new Pagamento(rs.getInt("IDPagamento"), rs.getDate("dtPagamento").toLocalDate(), TipoPagamento));
            
            return Pagamentos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar pagamentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Pagamento getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Pagamento ORDER BY IDPagamento DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            TipoPagamento TipoPagamento = new TipoPagamentoDAL().getById(rs.getInt("IDTipoPagamento"));
            return new Pagamento(rs.getInt("IDPagamento"), rs.getDate("dtPagamento").toLocalDate(), TipoPagamento);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Pagamento> getAll() throws SQLException{
        try 
        {
            ArrayList<Pagamento> Pagamentos = new ArrayList<Pagamento>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Pagamento ORDER BY IDPagamento", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                TipoPagamento TipoPagamento = new TipoPagamentoDAL().getById(rs.getInt("IDTipoPagamento"));
                Pagamentos.add(new Pagamento(rs.getInt("IDPagamento"), rs.getDate("dtPagamento").toLocalDate(), TipoPagamento));
            }
            
            return Pagamentos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar pagamentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Pagamento Pagamento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Pagamento (IDPagamento, dtPagamento, IDTipoPagamento) VALUES(0, ?, ?)");
            pst.setDate(1, Date.valueOf(Pagamento.getDataPagamento()));
            pst.setInt(2, Pagamento.getTipoPagamento().getId());
            pst.executeUpdate();
            return "Pagamento inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir pagamento. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Pagamento Pagamento) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Pagamento SET dtPagamento = ?, IDTipoPagamento = ? WHERE IDPagamento = ?");
            pst.setDate(1, Date.valueOf(Pagamento.getDataPagamento()));
            pst.setInt(2, Pagamento.getTipoPagamento().getId());
            pst.setInt(3, Pagamento.getId());
            pst.executeUpdate();
            return "Pagamento atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar pagamento. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Pagamento Pagamento) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Pagamento WHERE IDPagamento = ?");
            pst.setInt(1, Pagamento.getId());
            pst.executeUpdate();
            return "Pagamento excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar pagamento.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}