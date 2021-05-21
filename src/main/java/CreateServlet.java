import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logika.Product;
import Logika.ProductDB;
import javax.servlet.http.Part;
 

@WebServlet(name="create", urlPatterns = {"/create"})

public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String proizwoditel = request.getParameter("proizwoditel");
            String koliczestwo = request.getParameter("koliczestwo");
           // Part image = request.getPart("image")
            Product product = new Product(name, price, proizwoditel, koliczestwo);
            ProductDB.insert(product);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
        }
    }
}