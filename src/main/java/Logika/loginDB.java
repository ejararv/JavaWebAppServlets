/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 123
 */
public class loginDB {
    
    
    public static boolean validate(String email,String password){  
        
    boolean status=false;  
    
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:sqlserver://localhost:1433;databaseName=productdb", "sa", "6077832Gt");  

            PreparedStatement ps=con.prepareStatement(  
            "select * from register where email=? and password=?");  
            ps.setString(1,email);  
            ps.setString(2,password);  

            ResultSet rs=ps.executeQuery();  
            status=rs.next();  

        }catch(Exception e){System.out.println(e);}  
        return status;  
      }  
}
