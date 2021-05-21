/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logika;

/**
 *
 * @author 123
 */

import java.sql.*;
import java.util.ArrayList;
 
public class ProductDB {
 
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=productdb";
    private static String username = "sa";
    private static String password = "6077832Gt";
    
    public static ArrayList<Product> select() {
         
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    String proizwoditel = resultSet.getString(4);
                    String koliczestwo = resultSet.getString(5);
                    Product product = new Product(id, name, price, proizwoditel, koliczestwo);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
    
//     public static ArrayList<Product> selectfromhistory() {
//         
//        ArrayList<Product> products = new ArrayList<Product>();
//        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//                  
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM history");
//                while(resultSet.next()){
//                      
//                    int id = resultSet.getInt(1);
//                    String name = resultSet.getString(2);
//                    int price = resultSet.getInt(3);
//                    String proizwoditel = resultSet.getString(4);
//                    int koliczestwo = resultSet.getInt(5);
//                    Product product = new Product(id, name, price, proizwoditel, koliczestwo);
//                    products.add(product);
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//        return products;
//    }
    
    public static Product selectOne(int id) {
         
        Product product = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM products WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                         String proizwoditel = resultSet.getString(4);
                        String koliczestwo = resultSet.getString(5);
                        product = new Product(prodId, name, price, proizwoditel, koliczestwo);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }
    public static int insert(Product product) {
         
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO products  (name, price, koliczestwo, proizwoditel) Values (?, ?, ? ,?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());
                     preparedStatement.setString(3, product.getProizwoditel());
                    preparedStatement.setString(4, product.getKoliczestwo());
                    //  preparedStatement.setBinaryStream(3, request.getPart("file"));
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Product product) {
         
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE products SET name = ?, price = ?, proizwoditel = ?, koliczestwo = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());
                    preparedStatement.setString(3, product.getProizwoditel());
                    preparedStatement.setString(4, product.getKoliczestwo());
                    
                    preparedStatement.setInt(5, product.getId());
                   
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
         
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = ""
                        + "INSERT INTO history (id, name, price, proizwoditel,koliczestwo )\n" +
                        "SELECT id, name, price, proizwoditel,koliczestwo FROM products where id = ?;"
                        + ""
                        + "DELETE FROM products WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    preparedStatement.setInt(2, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
