package view;

import conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author EDUARDADUANEDOSSANTO
 */
public class principal {

    public static void main(String[] args) {

        Scanner resposta = new Scanner(System.in);

        System.out.println("=========================");
        System.out.println(" CADASTRO DE PRODUTOS ");
        System.out.println("=========================");

        System.out.print("Digite a descricao do produto: ");
        String descricao = resposta.nextLine();

        /*if (descricao.isEmpty()) {
            System.out.println("A descricao nao pode ficar vazia!");
            return;
        }*/
        
        System.out.print("Digite a quantidade em estoque: ");
        int estoque = Integer.parseInt(resposta.nextLine());
        
        System.out.print("Digite o valor de venda: ");
        String valor_venda = resposta.nextLine();

        /*if (valor_venda <= 0) {
            System.out.print("O valor de venda nao pode ser negativo!");
            return;
        
        }*/
        
        if (valor_venda.isEmpty() || Integer.parseInt(valor_venda) < 0){
            System.out.println("O valor de venda nao pode ser negativo!");
            return;
        }
        
        
        String sql = "INSERT INTO Produto(descricao, estoque, valor_venda) VALUES (?, ?, ?)";
        
        

        try {
            Connection Conexao = conexao.conectar();
            PreparedStatement stmt = Conexao.prepareStatement(sql);
            stmt.setString(1, descricao);
            stmt.setInt(2, estoque);
            stmt.setDouble(3, valor_venda);

            stmt.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!");

            stmt.close();

            PreparedStatement stmt2 = Conexao.prepareStatement("SELECT * FROM Produto");
            ResultSet resultado = stmt2.executeQuery();

            System.out.println("=========================");
            System.out.println(" PRODUTOS CADASTRADOS ");
            System.out.println("=========================");

            while (resultado.next()) {
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("descricao"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("estoque"));
                System.out.print(" | ");
                System.out.println(resultado.getDouble("valor_venda"));
            }

            stmt2.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao cadastrar o produto!!!");
            System.out.println(erro.getMessage());
        }

        resposta.close();
    }
}