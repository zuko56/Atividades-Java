package deleteContato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class DeleteContato {
    public static void main(String[] args) {
        try{
            Connection mysql = DriverManager.getConnection(
            "jdbc:mysql://localhost/agenda",
            "root",
            "123456"
            
            );
            System.out.println("Conectado");
         
            String sql = "delete from contato where idContato = 6";
            PreparedStatement deletar = mysql.prepareStatement(sql);
            
            deletar.execute();
            
            System.out.println("Registro deletado!");
            
        }catch(SQLException e){
            System.out.println("Ocorreu um erro!");
            throw new RuntimeException(e.getMessage());
        }
    }
}
