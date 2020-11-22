/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.TipoEmbalagem;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class TipoEmbalagemDAL {
    private final Conexao conexao = new Conexao();
    public TipoEmbalagem getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoEmbalagem WHERE IDTipoEmbalagem =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoEmbalagem(rs.getInt("IDTipoEmbalagem"), rs.getString("Descricao"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Tipo de embalagem. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public TipoEmbalagem getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoEmbalagem ORDER BY IDTipoEmbalagem DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            return new TipoEmbalagem(rs.getInt("IDTipoEmbalagem"), rs.getString("Descricao"));
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Tipo de embalagem. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<TipoEmbalagem> getAll() throws SQLException{
        try 
        {
            ArrayList<TipoEmbalagem> TipoEmbalagemes = new ArrayList<>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM TipoEmbalagem ORDER BY IDTipoEmbalagem", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                TipoEmbalagemes.add(new TipoEmbalagem(rs.getInt("IDTipoEmbalagem"), rs.getString("Descricao")));
            
            return TipoEmbalagemes;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar tipos de Pagamentos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(TipoEmbalagem TipoEmbalagem) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO TipoEmbalagem (IDTipoEmbalagem, Descricao) VALUES(0, ?)");
            pst.setString(1, TipoEmbalagem.getDescricao());
            pst.executeUpdate();
            return "Tipo de embalagem inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Tipo de embalagem. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(TipoEmbalagem TipoEmbalagem) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE TipoEmbalagem SET Descricao = ? WHERE IDTipoEmbalagem = ?");
            pst.setString(1, TipoEmbalagem.getDescricao());
            pst.setInt(2, TipoEmbalagem.getId());
            pst.executeUpdate();
            return "Tipo de embalagem atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar Tipo de embalagem. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(TipoEmbalagem TipoEmbalagem) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM TipoEmbalagem WHERE IDTipoEmbalagem = ?");
            pst.setInt(1, TipoEmbalagem.getId());
            pst.executeUpdate();
            return "Tipo de embalagem excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Tipo de embalagem.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}