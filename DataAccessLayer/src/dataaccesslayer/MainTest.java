/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import domain.Cidade;
import domain.Bairro;
import domain.Logradouro;

import java.sql.SQLException;

/**
 *
 * @author Diuari
 */
public class MainTest {
    public static void main(String[] args) throws SQLException
    {
        
        BairroDAL bairrodal = new BairroDAL();
        Bairro bairro = bairrodal.getById(1);
        
        LogradouroDAL logradal = new LogradouroDAL();
        logradal.update(new Logradouro(1, "logradouro 1", bairro));
        
    }
}
