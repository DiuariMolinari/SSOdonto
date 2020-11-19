/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import domain.Pais;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diuari
 */
public class MainTest {
    public static void main(String[] args) throws SQLException
    {
        PaisDAL paisdal = new PaisDAL();
        String result = paisdal.insert(new Pais("Teste 3"));
        Pais pais = paisdal.getLastRegister();
        System.out.println(result);
        System.out.println(pais.getNome());

    }
}
