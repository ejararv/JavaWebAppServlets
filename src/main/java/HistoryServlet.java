

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Logika.HistoryDB;
import Logika.History;



 @WebServlet(name="history", urlPatterns = {"/history"})
//@WebServlet(urlPatterns = "/")
public class HistoryServlet extends HttpServlet {
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
  ArrayList<History> historyes = HistoryDB.selectfromhistory();   

  request.setAttribute("historyes", historyes);
          
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }
}

        
      
      
   
