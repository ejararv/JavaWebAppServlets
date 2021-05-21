///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.util.List;
//import java.util.stream.Collectors;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
///**
// *
// * @author 123
// */
//
//@WebServlet(name="upload", urlPatterns = {"/upload"})
//@MultipartConfig
//
//
//public class Upload extends HttpServlet {
//
//    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=productdb";
//    private static String username = "sa";
//    private static String password = "6077832Gt";
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Upload</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Upload at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//         getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
//        
//      
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//        
//        int result = 0;
//        
//        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
//        Part image = request.getPart("image"); // Retrieves <input type="file" name="file">
//          String fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//         InputStream fileContent =  (InputStream) new FileInputStream((File) image);
//        
//        
//
//        // ... (do your job here)
//    
//         if (image!= null){
//             
//              try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();
//            try (Connection conn = DriverManager.getConnection(url, username, password)){
//                  
//                String sql = "INSERT INTO register  (image) Values ( ?)";
//                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
//                    
//                     File imgfile = new File("image");
//                     
//                     FileInputStream fin = new FileInputStream(imgfile);
//   
//   
// 
//                        preparedStatement.setBinaryStream(3, fin, (int) imgfile.length());
//                           preparedStatement.executeUpdate();
//    
//                    InputStream is = image.getInputStream();
//                    preparedStatement.setBinaryStream(1, is);
//                    result = preparedStatement.executeUpdate();
//                    
//                    if (result > 0){
//                        response.sendRedirect("login.jsp");
//                    }
//                    else {
//                        response.sendRedirect("index.jsp");
//                    }
//                    
//                  //  preparedStatement.setBinaryStream(1, image.getInputStream("image"));
//                   
//                  //  preparedStatement.setBinaryStream(3, request.getPart("image"));
//                   // return  preparedStatement.executeUpdate();
//                }
//            }
//        }
//        catch(Exception ex){
//            System.out.println(ex);
//        }
//       // return 0;
//             
//         }
//        
//    }
//
// 
//}
