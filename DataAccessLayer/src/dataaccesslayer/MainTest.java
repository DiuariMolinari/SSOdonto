/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;
import domain.Pais;
import java.sql.SQLException;
import java.util.ArrayList;
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
        for (int i = 0; i < 5; i++) {
            paisdal.insert(new Pais("PAIS " + i ));
        }
        
        ArrayList<Pais> paises = paisdal.getAll();
        System.out.println(paises.size());

    }
}
