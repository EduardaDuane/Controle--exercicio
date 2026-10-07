/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author EDUARDADUANEDOSSANTO
 */
public class conexao {
      public static Connection conectar(){
        
        Connection conexao = null;
        
        String url = "jdbc:postgresql://localhost/BD_controle_261T";
        String usuario = "postgres";
        String senha = "root";
          
         
        try{
             conexao = DriverManager.getConnection(url, usuario, senha);
             System.out.println("Conectado com o banco 100%");
        } catch (SQLException erro){
            System.out.println("Erro ao Conectar.");
            System.out.println(erro.getMessage());
        }
        return conexao;
        }
    }
