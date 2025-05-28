
package dao;

import model.Venda;
import database.DatabaseConnection;

import java.sql.*;

public class VendaDAO {

    public void inserir(Venda venda) {
        String sql = "INSERT INTO vendas (produto_id, quantidade, preco_unitario, preco_total) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getProdutoId());
            stmt.setInt(2, venda.getQuantidade());
            stmt.setDouble(3, venda.getPrecoUnitario());
            stmt.setDouble(4, venda.getPrecoTotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // atualizar o estoque
    public void atualizarEstoque(int produtoId, int quantidadeVendida) {
        String sql = "UPDATE produtos SET estoque = estoque - ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidadeVendida);
            stmt.setInt(2, produtoId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
