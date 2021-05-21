/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logika;

import java.io.InputStream;

/**
 *
 * @author 123
 */
public class Users {
    
    private InputStream profile;

    
    
    private String email;
        
    private String contact;
    
    private String name;
    
    private String age;
    
    private String gender;
    
    
    private String password;

    public InputStream getProfile() {
        return profile;
    }

    public void setProfile(InputStream profile) {
        this.profile = profile;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
