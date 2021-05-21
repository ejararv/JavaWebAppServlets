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
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
 
public class Product implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int id;
    private String name;
    private int price;
    private String proizwoditel;
    private String koliczestwo;

    public Product(int id, String name, int price, String proizwoditel, String koliczestwo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.proizwoditel = proizwoditel;
        this.koliczestwo = koliczestwo;
        
    }
    
    public Product( String name, int price, String proizwoditel, String koliczestwo) {
       
        this.name = name;
        this.price = price;
        this.proizwoditel = proizwoditel;
        this.koliczestwo = koliczestwo;
        
    }

   


    public String getProizwoditel() {
        return proizwoditel;
    }

    public void setProizwoditel(String proizwoditel) {
        this.proizwoditel = proizwoditel;
    }

    public String getKoliczestwo() {
        return koliczestwo;
    }

    public void setKoliczestwo(String koliczestwo) {
        this.koliczestwo = koliczestwo;
    }
     
     
    public int getId() {
        return id;
    }
     
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getPrice() {
        return price;
    }
 
    public void setPrice(int price) {
        this.price = price;
    }

   
}