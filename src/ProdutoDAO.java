

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutoDAO {
    
    
    ArrayList<Produto> listagem = new ArrayList<>();
    
    public void cadastrarProduto (Produto produto){
        
        try{ 
            Connection conn = new ConectaDAO().connectDB();
            String sql = "INSERT INTO produtos (nome,valor,status) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, produto.getNome());
            ps.setString(2, String.valueOf(produto.getValor()));
            ps.setString(3, produto.getStatus());
            
            int rowsAffected = ps.executeUpdate();
        
            if(rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto cadastro com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro no cadastro do produto");
            }   
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto no banco de dados.\n" + e.getMessage());
        }
        

        
        
    }
    
    public ArrayList<Produto> listarProdutos(){
        
        try{ 
            Connection conn = new ConectaDAO().connectDB();
            PreparedStatement ps = conn.prepareStatement("Select * from produtos");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               Produto produto = new Produto();
               
               produto.setId(rs.getInt("id"));
               produto.setNome(rs.getString("nome"));
               produto.setValor(rs.getInt("valor"));
               produto.setStatus(rs.getString("status"));
               
               listagem.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os registros do banco de dados.");
        }
        
        return listagem;
    }
    
    
    
        
}

