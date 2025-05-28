
package controller;

import dao.VendaDAO;
import model.Venda;

public class VendaController {

    private VendaDAO vendaDAO;

    public VendaController() {
        vendaDAO = new VendaDAO();
    }

    public void realizarVenda(int produtoId, int quantidade) {
        // Recupera o preço do produto
        double precoUnitario = getPrecoProduto(produtoId);  // Método fictício para buscar o preço do produto
        double precoTotal = precoUnitario * quantidade;

        // Cria a venda
        Venda venda = new Venda(produtoId, quantidade, precoUnitario, precoTotal);

        // Registra a venda no banco
        vendaDAO.inserir(venda);

        // Atualiza o estoque
        vendaDAO.atualizarEstoque(produtoId, quantidade);
    }

    // Método fictício para obter o preço do produto
    private double getPrecoProduto(int produtoId) {
        // consulta ao banco para pegar o preço do produto
        return 100.0; // Exemplo fixo
    }
}
