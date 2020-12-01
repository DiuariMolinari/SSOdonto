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
import domain.Produto;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class ProdutoDAL {
    private final Conexao conexao = new Conexao();
    public Produto getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Produto WHERE IDProduto =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            TipoEmbalagem TipoEmbalagem = new TipoEmbalagemDAL().getById(rs.getInt("IDTipoEmbalagem"));
            return new Produto(rs.getInt("IDProduto"), rs.getString("NOMEProduto"), TipoEmbalagem, rs.getDouble("PrecoProduto"), rs.getDate("dtCompra").toLocalDate());
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Produto. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Produto> getByTipoEmbalagem(TipoEmbalagem TipoEmbalagem) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Produto WHERE IDTipoEmbalagem =" + TipoEmbalagem.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Produto> Produtos = new ArrayList<Produto>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Produtos.add(new Produto(rs.getInt("IDProduto"), rs.getString("NOMEProduto"), TipoEmbalagem, rs.getDouble("PrecoProduto"), rs.getDate("dtCompra").toLocalDate()));
            
            return Produtos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar produtos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Produto getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Produto ORDER BY IDProduto DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            TipoEmbalagem TipoEmbalagem = new TipoEmbalagemDAL().getById(rs.getInt("IDTipoEmbalagem"));
            return new Produto(rs.getInt("IDProduto"), rs.getString("NOMEProduto"), TipoEmbalagem, rs.getDouble("PrecoProduto"), rs.getDate("dtCompra").toLocalDate());
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar produto. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Produto> getAll() throws SQLException{
        try 
        {
            ArrayList<Produto> Produtos = new ArrayList<Produto>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Produto ORDER BY IDProduto", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                TipoEmbalagem TipoEmbalagem = new TipoEmbalagemDAL().getById(rs.getInt("IDTipoEmbalagem"));
                Produtos.add(new Produto(rs.getInt("IDProduto"), rs.getString("NOMEProduto"), TipoEmbalagem, rs.getDouble("PrecoProduto"), rs.getDate("dtCompra").toLocalDate()));
            }
            
            return Produtos;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar produtos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Produto Produto) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Produto (IDProduto, NOMEProduto, IDTipoEmbalagem, precoProduto, dtCompra) VALUES(0, ?, ?, ?, ?)");
            pst.setString(1, Produto.getNome());
            pst.setInt(2, Produto.getTipoEmbalagem().getId());
            pst.setDouble(3, Produto.getPreco());
            pst.setDate(4, Date.valueOf(Produto.getDataCompra()));
            pst.executeUpdate();
            return "Produto inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir produto. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Produto Produto) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Produto SET NOMEProduto = ?, IDTipoEmbalagem = ?, precoProduto = ?, dtCompra = ? WHERE IDProduto = ?");
            pst.setString(1, Produto.getNome());
            pst.setInt(2, Produto.getTipoEmbalagem().getId());
            pst.setDouble(3, Produto.getPreco());
            pst.setDate(4, Date.valueOf(Produto.getDataCompra()));
            pst.setInt(5, Produto.getId());
            pst.executeUpdate();
            return "Produto atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar produto. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Produto Produto) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Produto WHERE IDProduto = ?");
            pst.setInt(1, Produto.getId());
            pst.executeUpdate();
            return "Produto excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar produto.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}