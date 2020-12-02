/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Contato;
import domain.Paciente;
import domain.Colaborador;
import domain.FoneTipo;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class ContatoDAL {
    private final Conexao conexao = new Conexao();
    public Contato getById(int id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Contato WHERE IDContato =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            FoneTipo FoneTipo = new FoneTipoDAL().getById(rs.getInt("IDFoneTipo"));
            if (rs.getInt("IDPaciente") == 0){
                Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
                return new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Colaborador);
            }
            else
            {
               Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
               return new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Paciente); 
            }
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar contato. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    public ArrayList<Contato> getByColaborador(Colaborador Colaborador) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Contato WHERE IDColaborador =" + Colaborador.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Contato> Contatos = new ArrayList<Contato>();
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                FoneTipo FoneTipo = new FoneTipoDAL().getById(rs.getInt("IDFoneTipo"));
                Contatos.add(new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Colaborador));
            }               
            return Contatos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar contatos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public ArrayList<Contato> getByPaciente(Paciente Paciente) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Contato WHERE IDPaciente =" + Paciente.getId(), ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ArrayList<Contato> Contatos = new ArrayList<Contato>();
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                FoneTipo FoneTipo = new FoneTipoDAL().getById(rs.getInt("IDFoneTipo"));
                Contatos.add(new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Paciente));
            }               
            return Contatos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar contatos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Contato getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Contato ORDER BY IDContato DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            
            FoneTipo FoneTipo = new FoneTipoDAL().getById(rs.getInt("IDFoneTipo"));
            if (rs.getInt("IDPaciente") == 0){
                Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
                return new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Colaborador);
            }
            else
            {
               Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
               return new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Paciente); 
            }
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar ontato. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Contato> getAll() throws SQLException{
        try 
        {
            ArrayList<Contato> Contatos = new ArrayList<Contato>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Contato ORDER BY IDContato", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                FoneTipo FoneTipo = new FoneTipoDAL().getById(rs.getInt("IDFoneTipo"));
                if (rs.getInt("IDPaciente") == 0){
                    Colaborador Colaborador = new ColaboradorDAL().getById(rs.getInt("IDColaborador"));
                    Contatos.add(new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Colaborador));
                }
                else
                {
                   Paciente Paciente = new PacienteDAL().getById(rs.getInt("IDPaciente"));
                   Contatos.add(new Contato(rs.getInt("IDContato"), rs.getString("fone"), FoneTipo, rs.getString("email"), Paciente)); 
                }
            }
            return Contatos;
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar Contatos. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
     }
    
    public String insert(Contato Contato) throws SQLException{
        try 
        {
            if (Contato.getPaciente() == null) {
                PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Contato (IDContato, fone, idfonetipo, email, idPaciente, idColaborador) VALUES(0, ?, ?, ?, null, ?)");
                pst.setString(1, Contato.getFone());
                pst.setInt(2, Contato.getFoneTipo().getId());
                pst.setString(3, Contato.getEmail());
                pst.setInt(4, Contato.getColaborador().getId());
                pst.executeUpdate();
            }
            else{
                PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Contato (IDContato, fone, idfonetipo, email, idPaciente, idColaborador) VALUES(0, ?, ?, ?, ?, null)");
                pst.setString(1, Contato.getFone());
                pst.setInt(2, Contato.getFoneTipo().getId());
                pst.setString(3, Contato.getEmail());
                pst.setInt(4, Contato.getPaciente().getId());
                pst.executeUpdate();
            }
            return "Contato inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir contato. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Contato Contato) throws SQLException{
        try 
        {
            if (Contato.getPaciente() == null) {
                PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Contato SET fone = ?, idFoneTipo = ?, email = ?,  idColaborador = ? WHERE idContato = ?");
                pst.setString(1, Contato.getFone());
                pst.setInt(2, Contato.getFoneTipo().getId());
                pst.setString(3, Contato.getEmail());
                pst.setInt(4, Contato.getColaborador().getId());
                pst.setInt(5, Contato.getId());
                pst.executeUpdate();
            }
            else{
                PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Contato SET fone = ?, idFoneTipo = ?, email = ?, idPaciente = ? WHERE idContato = ?");
                pst.setString(1, Contato.getFone());
                pst.setInt(2, Contato.getFoneTipo().getId());
                pst.setString(3, Contato.getEmail());
                pst.setInt(4, Contato.getPaciente().getId());
                pst.setInt(5, Contato.getId());
                pst.executeUpdate();
            }
            return "Contato atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar contato. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Contato Contato) throws SQLException {
        try {
            if (Contato.getId() == 0) {
                return "Contato informado inválido!";
            }
            
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Contato WHERE IDContato = ?");
            pst.setInt(1, Contato.getId());
            pst.executeUpdate();
            return "Contato excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar Contato.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}