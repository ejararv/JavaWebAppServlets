
import Logika.Users;
import Logika.UsersDB;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.websocket.Decoder.BinaryStream;

/**
 *
 * @author 123
 */


@WebServlet(name="register", urlPatterns = {"/register"})
@MultipartConfig
public class Register extends HttpServlet {


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
       getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{ 
//             String description = request.getParameter("description"); 
//    Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
//    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
              
               String email =request.getParameter("email");
               String password =request.getParameter("password");
               String profile =request.getParameter("profile");
               String contact =request.getParameter("contact");
               String name =request.getParameter("name");
               String age =request.getParameter("age");
               String gender =request.getParameter("gender");
               //InputStream profile =request.getPart()("image");
               
               Users users = new Users();
              
//               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//               Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=productdb", "sa", "6077832Gt");
//               
//               PreparedStatement ps = null;
//               
//               ps = con.prepareStatement("insert into register (email, password, profile,contact,name, age, gender,  values(?,?,?,?,?,?,?,?)");
  users.setEmail(email);
               users.setPassword(password);
              // users.setProfile(profile);             
               users.setContact(contact);
               users.setName(name);
               users.setAge(age);
               users.setGender(gender);
              // ps.setBinaryStream(8,h);
              
              UsersDB usersDB = new UsersDB();
              
              String userRegistered = usersDB.registerUser(users);
             response.sendRedirect(request.getContextPath()+"/login");
         
         if(userRegistered.equals("SUCCESS"))   
         {
              response.sendRedirect(request.getContextPath() + "/login");
             
             
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//            response.sendRedirect(request.getContextPath()+"/index");
//            
             
         }
         else   
         {
             
             String path = request.getContextPath() + "/notfound.jsp";
            response.sendRedirect(path);
//            request.setAttribute("errMessage", userRegistered);
//            request.getRequestDispatcher("/register.jsp").forward(request, response);
         }
           }catch (Exception e2) {out.println(e2);} 
            }  
        }
    }
  