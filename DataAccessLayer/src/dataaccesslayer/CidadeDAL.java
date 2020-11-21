/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Estado;
import domain.Cidade;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class CidadeDAL {
    private final Conexao conexao = new Conexao();
    public Cidade getById(long id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM CIDADE WHERE IDCIDADE =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Estado estado = new EstadoDAL().getById(rs.getInt("IDESTADO"));
            return new Cidade(rs.getInt("IDCIDADE"), rs.getString("NOMECIDADE"), estado);
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar cidade. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Cidade> getByEstado(Estado estado) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM CIDADE WHERE IDESTADO =" + estado.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            ResultSet rs = pst.executeQuery();
            while (rs.next())               
                cidades.add(new Cidade(rs.getInt("IDCIDADE"), rs.getString("NOMECIDADE"), estado));
            
            return cidades;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar cidades. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Cidade getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM CIDADE ORDER BY IDCIDADE DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Estado estado = new EstadoDAL().getById(rs.getInt("IDESTADO"));
            return new Cidade(rs.getInt("IDCIDADE"), rs.getString("NOMECIDADE"), estado);
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar cidade. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Cidade> getAll() throws SQLException{
        try 
        {
            ArrayList<Cidade> cidades = new ArrayList<Cidade>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM CIDADE ORDER BY IDCIDADE", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Estado estado = new EstadoDAL().getById(rs.getInt("IDESTADO"));
                cidades.add(new Cidade(rs.getInt("IDCIDADE"), rs.getString("NOMECIDADE"), estado));
            }
            
            return cidades;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar cidades. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Cidade cidade) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO CIDADE (IDCIDADE, NOMECIDADE, IDESTADO) VALUES(0, ?, ?)");
            pst.setString(1, cidade.getNome());
            pst.setInt(2, cidade.getEstado().getId());
            pst.executeUpdate();
            return "Cidade inserida com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir cidade. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Cidade cidade) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE CIDADE SET NOMECIDADE = ?, IDESTADO = ? WHERE IDCIDADE = ?");
            pst.setString(1, cidade.getNome());
            pst.setInt(1, cidade.getEstado().getId());
            pst.setInt(2, cidade.getId());
            pst.executeUpdate();
            return "Cidade atualizada com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar cidade. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Cidade cidade) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM CIDADE WHERE IDCIDADE = ?");
            pst.setInt(1, cidade.getId());
            pst.executeUpdate();
            return "Cidade excluída com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar cidade.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}

