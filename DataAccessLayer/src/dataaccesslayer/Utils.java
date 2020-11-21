/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccesslayer;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Diuari
 */
public class Utils {
    public static Date LocalDateToSqlDate(LocalDate localdate){
        return Date.valueOf(localdate);
    }
    
    public static LocalDate SqlDateToLocalDate(Date date){
        return date.toLocalDate();
    }
}
