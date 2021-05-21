/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import Logika.Users;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 123
 */
public class UsersDB {
    
    
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=productdb";
    private static String username = "sa";
    private static String password = "6077832Gt";
    
     public String registerUser(Users users) throws ClassNotFoundException
     {  
         boolean status=false;
         String name = users.getName();
         String email = users.getEmail();
         String age = users.getAge();
         String password = users.getPassword();
         InputStream profile = users.getProfile();
         String contact = users.getContact();
         String gender = users.getGender();
         
         PreparedStatement preparedStatement = null;         
         try
         {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=productdb", "sa", "6077832Gt")){
               
               
             String query = "insert into register(email,password,contact,name, age, gender) values (?,?,?,?,?,?)"; 
             preparedStatement = conn.prepareStatement(query); 
             preparedStatement.setString(1, email);
             preparedStatement.setString(2, password);
             preparedStatement.setBinaryStream(3, profile);
             preparedStatement.setString(3, contact);
             preparedStatement.setString(4, name);
             preparedStatement.setString(5, age);
             preparedStatement.setString(6, gender);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0)  
             return "SUCCESS"; 
         }catch(Exception e){e.printStackTrace();} 
              return "SUCCESS"; 
         
         
         }catch(Exception e){e.printStackTrace();} 
         return "SUCCESS"; 
     }
    
     
     public static boolean validate(String email,String password) {  
        
    boolean status=false;  
    PreparedStatement preparedStatement = null;       
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=productdb", "sa", "6077832Gt");
          

           
            String query = "select * from register where email=? and password=?";
            
            preparedStatement = conn.prepareStatement(query); 
            
            preparedStatement.setString(1,email);  
            preparedStatement.setString(2,password);  

            ResultSet rs=preparedStatement.executeQuery();  
            status=rs.next();  
             
        }catch(Exception e){e.printStackTrace();}  
        return status;  
      }  
    
}
