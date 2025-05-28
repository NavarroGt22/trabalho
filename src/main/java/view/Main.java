
package view;

import controller.VendaController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private VendaController vendaController;

    @Override
    public void start(Stage primaryStage) {
        vendaController = new VendaController();

        // interface
        primaryStage.setTitle("Venda de Produtos");

        // Tela de Venda
        VBox vbox = new VBox();

        // Seleção do Produto
        ComboBox<String> comboProduto = new ComboBox<>();
        comboProduto.getItems().addAll("Produto A", "Produto B", "Produto C");  // Exemplo fixo, na prática seria do banco

        // Quantidade
        TextField qtdField = new TextField();
        qtdField.setPromptText("Quantidade");

        // Botão de Salvar
        Button btnRealizarVenda = new Button("Realizar Venda");
        btnRealizarVenda.setOnAction(e -> {
            int produtoId = comboProduto.getSelectionModel().getSelectedIndex() + 1;  // Exemplo de ID
            int quantidade = Integer.parseInt(qtdField.getText());
            vendaController.realizarVenda(produtoId, quantidade);
            showAlert("Venda realizada com sucesso!");
        });

        vbox.getChildren().addAll(comboProduto, qtdField, btnRealizarVenda);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método de alerta
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Venda");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
