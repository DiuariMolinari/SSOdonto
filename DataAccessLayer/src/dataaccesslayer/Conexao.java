package dataaccesslayer;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    // criar variável conexao
    public Connection connection;
    //driver, DRIVER = banco de dados, URL referente ao caminho
    public Connection getConexao() throws SQLException{
                            //geralmente varia de tipo de banco e so muda o .mysql.
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://127.0.0.1:3306/sorrisempre?Timezone=true&serverTimezone=UTC";
     // tenta a conexao, [user] root e [password] localhost123 como usuário e senha   
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, "root" ,"localhost123");
            return connection;
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e.toString());
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas na fonte de dados." + e.toString());
        }
        return null;
    }
    //fechar conexão
    public void close(){
        try{
            connection.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problemas ao fechar conexão" + e.toString());
        }
    }     
}    
