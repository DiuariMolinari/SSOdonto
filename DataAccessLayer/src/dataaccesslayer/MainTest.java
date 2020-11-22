/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import java.sql.SQLException;
import java.util.ArrayList;
import domain.Clinica;
import domain.Colaborador;
import domain.Endereco;
import domain.Funcao;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Diuari
 */
public class MainTest {
    public static void main(String[] args) throws SQLException
    {
        Funcao funcao = new FuncaoDAL().getById(2);
        Clinica clinica = new ClinicaDAL().getById(2);
        Endereco endereco = new EnderecoDAL().getById(2);
        Colaborador colaborador = new ColaboradorDAL().getById(2);
        
        
        
    }
}
