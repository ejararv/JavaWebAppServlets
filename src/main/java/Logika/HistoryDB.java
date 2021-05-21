/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 123
 */
public class HistoryDB {
    
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=productdb";
    private static String username = "sa";
    private static String password = "6077832Gt";
    
    
    
    
     public static ArrayList<History> selectfromhistory() {
         
        ArrayList<History> historyes = new ArrayList<History>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM history");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    String proizwoditel = resultSet.getString(4);
                    String koliczestwo = resultSet.getString(5);
                   History history = new History(id, name, price, proizwoditel, koliczestwo);
                    historyes.add(history);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return historyes;
    }
    
    
}
