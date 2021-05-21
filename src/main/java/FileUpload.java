/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author 123
 */

@WebServlet(name="FileUpload", urlPatterns = {"/FileUpload"})
@MultipartConfig
public class FileUpload extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
    }
    
    
//        try ( PrintWriter out = response.getWriter()) {
//            Part part = request.getPart("file");
//            String fileName = part.getSubmittedFileName();
//
//            String path = getServletContext().getRealPath("/" + "files" + File.separator + fileName);
//            InputStream is = part.getInputStream();
//
//            uploadFile(is, path);
//
//            boolean succes =  uploadFile(is, path);
//            
//            if (succes){
//                System.out.println("FileUploadet" +path);
//            }
//            else{
//                 System.out.println("ERORR" );
//            }
//          
//        }
//    }
//    
//    public boolean uploadFile(InputStream is, String path) {
//
//        boolean isuploadet = false;
//        try {
//            byte[] byt = new byte[is.available()];
//            is.read();
//            FileOutputStream fop = new FileOutputStream(path);
//
//            fop.write(byt);
//            fop.flush();
//            fop.close();
//
//            isuploadet = true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return isuploadet;
//
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         try ( PrintWriter out = response.getWriter()) {
            Part part = request.getPart("file");
            String fileName = part.getSubmittedFileName();

            String path = getServletContext().getRealPath("/" + "files" + File.separator + fileName);
            InputStream is = part.getInputStream();

            uploadFile(is, path);

            boolean succes =  uploadFile(is, path);
            
            if (succes){
                System.out.println("FileUploadet" +path);
            }
            else{
                 System.out.println("ERORR" );
            }
          
        }
         

    }
    public boolean uploadFile(InputStream is, String path) {

        boolean isuploadet = false;
        try {
            byte[] byt = new byte[is.available()];
            is.read();
            FileOutputStream fop = new FileOutputStream(path);

            fop.write(byt);
            fop.flush();
            fop.close();

            isuploadet = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isuploadet;

    }
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

