import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/CriarContato"})
public class CriarContato extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CriarContato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='GET' action='/Agenda/SaveContact'>");
            out.println("Nome: ");
            out.println("<input type='text' name='nome'/></br>");
            out.println("Endereço: ");
            out.println("<input type='text' name='endereco'/></br>");
            out.println("Data de Nascimento: ");
            out.println("<input type='text' name='data_nascimento'/></br>");
            out.println("<button type= 'submit'>Criar Contato</button>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            
            
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/criar-contato.jsp")
        .forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
