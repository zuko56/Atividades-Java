
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import conexao.Mysql;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(urlPatterns = {"/SaveContact"})
public class SaveContact extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SaveContact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(request.getParameter("nome"));
            out.println("<h1>Servlet SaveContact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            try{
                DriverManager.registerDriver(new Driver());
                Connection mysql = DriverManager.getConnection(
                    "jdbc:mysql://localhost/agenda", 
                    "root",
                    "1q"
                    
            );
            
           String instrucao = "insert into contatos (nome, endereco) values (?, ?)";
           
                PreparedStatement ps = mysql.prepareStatement(instrucao);
                ps.setString(1, nome);
                ps.setString(2, endereco);
                
                ps.execute();
                
        }catch(Exception e){
                out.println("Ocorreu um erro!");
                out.println(e.getMessage());
                
            
        }
      }      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mysql bd = new Mysql();
        
        Connection conexao = bd.conecta();
        
        try {
            PreparedStatement instrucao = conexao.prepareStatement(
                    "insert into contatos(nome, email, endereco) values (?, ?, ?"
            );
           
            
        } catch (SQLException ex) {
            System.out.println("Erro na operação!");
            throw new RuntimeException(ex.getMessage());
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
