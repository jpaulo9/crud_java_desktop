
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conect {
    
    
    //adicione seu URL e seu user e senha do php_admin
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/db_cliente";
    private static String USER = "root";
    
    private static String PASS = "0906";
          
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro: A conexão falhou!", ex);
        }
    
    }
    
    public static void closeConnection(Connection con){
    
            
         try {
              if(con!= null){
             con.close();
              }
         } catch (SQLException ex) {
             Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
      
    }
    
    public static void closeConnection(Connection con, PreparedStatement smt){
    
        
        closeConnection(con);
            
         try {
              if(smt!= null){
             smt.close();
              }
         } catch (SQLException ex) {
             Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
      
    }
    public static void closeConnection(Connection con, PreparedStatement smt, ResultSet res){
    
        
        closeConnection(con, smt);
            
         try {
              if(res!= null){
             res.close();
              }
         } catch (SQLException ex) {
             Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
      
    }
    
}
