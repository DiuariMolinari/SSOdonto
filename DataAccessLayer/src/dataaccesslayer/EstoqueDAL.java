/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Estoque;
import domain.Produto;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class EstoqueDAL {
    private final Conexao conexao = new Conexao();
    public Estoque getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Estoque WHERE IDEstoque =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Produto Produto = new ProdutoDAL().getById(rs.getInt("IDProduto"));
            return new Estoque(rs.getInt("idEstoque"), Produto, rs.getInt("qtsProduto"), rs.getDate("dtEntrada").toLocalDate(), rs.getDate("dtSaida").toLocalDate());
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estoque. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Estoque> getByProduto(Produto Produto) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Estoque WHERE IDProduto =" + Produto.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Estoque> Estoques = new ArrayList<Estoque>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                Estoques.add(new Estoque(rs.getInt("idEstoque"), Produto, rs.getInt("qtsProduto"), rs.getDate("dtEntrada").toLocalDate(), rs.getDate("dtSaida").toLocalDate()));
            
            return Estoques;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estoques. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Estoque getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Estoque ORDER BY IDEstoque DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Produto Produto = new ProdutoDAL().getById(rs.getInt("IDProduto"));
            return new Estoque(rs.getInt("idEstoque"), Produto, rs.getInt("qtsProduto"),  rs.getDate("dtEntrada").toLocalDate(), rs.getDate("dtSaida").toLocalDate());
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estoque. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Estoque> getAll() throws SQLException{
        try 
        {
            ArrayList<Estoque> Estoques = new ArrayList<Estoque>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Estoque ORDER BY IDEstoque", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Produto Produto = new ProdutoDAL().getById(rs.getInt("IDProduto"));
                Estoques.add(new Estoque(rs.getInt("idEstoque"), Produto, rs.getInt("qtdProduto"), rs.getDate("dtEntrada").toLocalDate(), rs.getDate("dtSaida").toLocalDate()));
            }
            
            return Estoques;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar estoques. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Estoque Estoque) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Estoque (IDEstoque, idProduto, qtdProduto, dtEntrada, dtSaida) VALUES(0, ?, ?, ?, ?)");
            pst.setInt(1, Estoque.getProduto().getId());
            pst.setInt(2, Estoque.getQtdProduto());
            pst.setDate(3, Date.valueOf(Estoque.getDataEntrada()));
            pst.setDate(4, Date.valueOf(Estoque.getDataSaida()));
            pst.executeUpdate();
            return "Estoque inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Estoque. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Estoque Estoque) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Estoque SET idProduto = ?, qtdProduto = ?, dtEntrada = ?, dtSaida = ? WHERE IDEstoque = ?");
            pst.setInt(1, Estoque.getProduto().getId());
            pst.setInt(2, Estoque.getQtdProduto());
            pst.setDate(3, Date.valueOf(Estoque.getDataEntrada()));
            pst.setDate(4, Date.valueOf(Estoque.getDataSaida()));
            pst.setInt(5, Estoque.getId());
            pst.executeUpdate();
            return "Estoque atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar estoque. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Estoque Estoque) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Estoque WHERE IDEstoque = ?");
            pst.setInt(1, Estoque.getId());
            pst.executeUpdate();
            return "Estoque excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar estoque.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}