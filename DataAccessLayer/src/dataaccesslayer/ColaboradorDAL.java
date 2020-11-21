/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import domain.Clinica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domain.Colaborador;
import domain.Endereco;
import domain.Funcao;
import domain.Pais;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Diuari
 */
public class ColaboradorDAL {
    private final Conexao conexao = new Conexao();
    public Colaborador getById(long id ) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Colaborador WHERE IDColaborador =" + id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Endereco endereco = new EnderecoDAL().getById(rs.getInt("idEndereco"));
            Funcao Funcao = new FuncaoDAL().getById(rs.getInt("idFuncao"));
            Clinica clinica = new ClinicaDAL().getById(rs.getInt("idClinica"));
            return new Colaborador(
                    rs.getInt("IDColaborador"), 
                    rs.getString("NOME"), 
                    rs.getString("cro"), 
                    rs.getString("croEstado"), 
                    rs.getDate("dtAdmissao").toLocalDate(),
                    rs.getDate("dtDemissao").toLocalDate(), 
                    endereco, 
                    Funcao, 
                    clinica,
                    rs.getBoolean("ferias"), 
                    rs.getBoolean("demitido")
            );
        }
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar colaborador. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
     public Colaborador getLastRegister() throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Colaborador ORDER BY IDColaborador DESC LIMIT 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            rs.first();
            Endereco endereco = new EnderecoDAL().getById(rs.getInt("idEndereco"));
            Funcao Funcao = new FuncaoDAL().getById(rs.getInt("idFuncao"));
            Clinica clinica = new ClinicaDAL().getById(rs.getInt("idClinica"));
            return new Colaborador(
                    rs.getInt("IDColaborador"), 
                    rs.getString("NOME"), 
                    rs.getString("cro"), 
                    rs.getString("croEstado"), 
                    rs.getDate("dtAdmissao").toLocalDate(),
                    rs.getDate("dtDemissao").toLocalDate(), 
                    endereco, 
                    Funcao, 
                    clinica,
                    rs.getBoolean("ferias"), 
                    rs.getBoolean("demitido")
            );
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar colaborador. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
     
     public ArrayList<Colaborador> getAll() throws SQLException{
        try 
        {
            ArrayList<Colaborador> Colaboradors = new ArrayList<Colaborador>();
            PreparedStatement pst = conexao.getConexao().prepareStatement("SELECT * FROM Colaborador ORDER BY IDColaborador", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Endereco endereco = new EnderecoDAL().getById(rs.getInt("idEndereco"));
                Funcao Funcao = new FuncaoDAL().getById(rs.getInt("idFuncao"));
                Clinica clinica = new ClinicaDAL().getById(rs.getInt("idClinica"));
                Colaboradors.add(
                    new Colaborador(
                        rs.getInt("IDColaborador"), 
                        rs.getString("NOME"), 
                        rs.getString("cro"), 
                        rs.getString("croEstado"), 
                        rs.getDate("dtAdmissao").toLocalDate(),
                        rs.getDate("dtDemissao").toLocalDate(), 
                        endereco, 
                        Funcao, 
                        clinica,
                        rs.getBoolean("ferias"), 
                        rs.getBoolean("demitido")
                    )
                );
            }
            
            return Colaboradors;
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao buscar colaboradors. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String insert(Colaborador Colaborador) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("INSERT INTO Colaborador (IDColaborador, NOME, IDFUNCAO, CRO, CROESTADO, DTADMISSAO, DTDEMISSAO, IDENDERECO, IDCLINICA, FERIAS, DEMITIDO) VALUES(0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, Colaborador.getNome());
            pst.setInt(2, Colaborador.getFuncao().getId());
            pst.setString(3, Colaborador.getCro());
            pst.setString(4, Colaborador.getCroEstado());
            pst.setDate(5, Date.valueOf(Colaborador.getDataAdmissao()));
            if (Colaborador.getDataDemissao() != null)
                pst.setDate(6, Date.valueOf(Colaborador.getDataDemissao()));
            else
                pst.setDate(6, Date.valueOf(LocalDate.of(0001, 1, 1)));
                
            pst.setInt(7, Colaborador.getEndereco().getId());
            pst.setInt(8, Colaborador.getClinica().getId());
            pst.setBoolean(9, Colaborador.isFerias());
            pst.setBoolean(10, Colaborador.isDemitido());
            
            pst.executeUpdate();
            return "Colaborador inserido com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao inserir colaborador. \n Entre em contato com o suporte.");
        }
        
        finally
        {
            conexao.close();
        }
    }
    
    public String update(Colaborador Colaborador) throws SQLException{
        try 
        {
            PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE Colaborador SET "
                    + " NOME = ?, "
                    + " IDFUNCAO = ?, "
                    + " CRO = ?,"
                    + " CROESTADO = ?, "
                    + " DTADMISSAO = ?,"
                    + " DTDEMISSAO = ?, "
                    + " IDENDERECO = ?, "
                    + " IDCLINICA = ?, "
                    + " FERIAS = ?, "
                    + " DEMITIDO = ? "
            + " WHERE IDColaborador = ?");
            
            pst.setString(1, Colaborador.getNome());
            pst.setInt(2, Colaborador.getFuncao().getId());
            pst.setString(3, Colaborador.getCro());
            pst.setString(4, Colaborador.getCroEstado());
            pst.setDate(5, Date.valueOf(Colaborador.getDataAdmissao()));
            if (Colaborador.getDataDemissao() != null)
                pst.setDate(6, Date.valueOf(Colaborador.getDataDemissao()));
            else
                pst.setDate(6, Date.valueOf(LocalDate.of(0001, 1, 1)));
            
            pst.setInt(7, Colaborador.getEndereco().getId());
            pst.setInt(8, Colaborador.getClinica().getId());
            pst.setBoolean(9, Colaborador.isFerias());
            pst.setBoolean(10, Colaborador.isDemitido());
            pst.setInt(11, Colaborador.getId());

            pst.executeUpdate();
            return "Colaborador atualizado com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao atualizar colaborador. \n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
    
    public String delete(Colaborador Colaborador) throws SQLException {
        try {
            PreparedStatement pst = conexao.getConexao().prepareStatement("DELETE FROM Colaborador WHERE IDColaborador = ?");
            pst.setInt(1, Colaborador.getId());
            pst.executeUpdate();
            return "Colaborador excluído com sucesso!";
        } 
        
        catch (Exception e) {
            throw new SQLException("Falha ao deletar colaborador.\n Entre em contato com o suporte.");
        }
        
        finally {
            conexao.close();
        }
    }
}