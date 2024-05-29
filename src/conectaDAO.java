
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaDAO {
        Connection conn = null;
        private String url = "jdbc:mysql://localhost:3306/uc11_db"; 
        private String user = "root"; 
        private String password = "";
    
    public Connection connectDB(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Falha ao carregar a classe da conexão. Classe não encontrada\n" + ex.getMessage());
        }
        return conn;
    }
    
    
    
}
