/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection connection;
    PreparedStatement preparedStatement  ;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
//        conn = new conectaDAO().connectDB();
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        try{ 
            connection = new conectaDAO().connectDB();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from produtos");
            resultset = preparedStatement.executeQuery();
            
            while(resultset.next()){
               ProdutosDTO produto = new ProdutosDTO();
               
               produto.setId(resultset.getInt("id"));
               produto.setNome(resultset.getString("nome"));
               produto.setValor(resultset.getInt("valor"));
               produto.setStatus(resultset.getString("status"));
               
               listagem.add(produto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar os registros do banco de dados.");
        }
        
        return listagem;
    }
    
    
    
        
}

