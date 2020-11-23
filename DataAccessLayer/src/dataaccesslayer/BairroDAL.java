/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Cidade;
import domain.Bairro;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class BairroDAL {
    private final Conexao conexao = new Conexao();
    public Bairro getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Bairro WHERE IDBairro =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Cidade cidade = new CidadeDAL().getById(rs.getInt("IDcidade"));
            return new Bairro(rs.getInt("IDBairro"), rs.getString("NOMEBairro"), cidade);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar bairro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Bairro> getByCidade(Cidade cidade) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Bairro WHERE IDCIDADE =" + cidade.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Bairro> bairros = new ArrayList<Bairro>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                bairros.add(new Bairro(rs.getInt("IDBairro"), rs.getString("NOMEBairro"), cidade));
            
            return bairros;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar bairros. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Bairro getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Bairro ORDER BY IDBairro DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Cidade cidade = new CidadeDAL().getById(rs.getInt("IDCIDADE"));
            return new Bairro(rs.getInt("IDBairro"), rs.getString("NOMEBairro"), cidade);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar bairro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Bairro> getAll() throws SQLException{
        try 
        {
            ArrayList<Bairro> Bairros = new ArrayList<Bairro>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Bairro ORDER BY IDBairro", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Cidade cidade = new CidadeDAL().getById(rs.getInt("IDCIDADE"));
                Bairros.add(new Bairro(rs.getInt("IDBairro"), rs.getString("NOMEBairro"), cidade));
            }
            
            return Bairros;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar bairros. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Bairro Bairro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Bairro (IDBairro, NOMEBairro, IDCIDADE) VALUES(0, ?, ?)");
            pst.setString(1, Bairro.getNome());
            pst.setInt(2, Bairro.getCidade().getId());
            pst.executeUpdate();
            return "Bairro inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir Bairro. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Bairro Bairro) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Bairro SET NOMEBairro = ?, IDCIDADE = ? WHERE IDBairro = ?");
            pst.setString(1, Bairro.getNome());
            pst.setInt(2, Bairro.getCidade().getId());
            pst.setInt(3, Bairro.getId());
            pst.executeUpdate();
            return "Bairro atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar Bairro. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Bairro Bairro) throws SQLException {
        try {
            if (Bairro.getId() == 0) {
                return "Bairro informada inválido!";
            }
            
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Bairro WHERE IDBairro = ?");
            pst.setInt(1, Bairro.getId());
            pst.executeUpdate();
            return "Bairro excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar bairro.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}

