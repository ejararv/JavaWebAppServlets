/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logika.UsersDB;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 123
 */@WebServlet(name="login",urlPatterns = {"/login"})

public class Login extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email=request.getParameter("email");  
        
        String password=request.getParameter("password");  
          
       
          if(UsersDB.validate(email, password)) {
              
//                
//                RequestDispatcher rd=request.getRequestDispatcher("/index");
//                rd.forward(request,response);
               response.sendRedirect(request.getContextPath()+"/index");
          }else {
           
//                out.print("Sorry username or password error");
                
//                rd.forward(request,response);
                    
//                      getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
//            out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("/register");
                rd.forward(request,response);
        
          }
                
                
            
            
//    out.close();  
       
        
    }

   
    

}
