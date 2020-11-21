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
        Funcao Funcao = new FuncaoDAL().getById(2);
        Clinica Clinica = new ClinicaDAL().getById(2);
        Endereco endereco = new EnderecoDAL().getById(2);
        
        System.out.println(new ColaboradorDAL().insert(new Colaborador(1,
                "daniel",
                "123",
                "df",
                LocalDate.of(2010, Month.MARCH, 1),
                endereco,
                Funcao,
                Clinica,
                true,
                true)));
    }
}
