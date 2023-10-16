package testes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class testelistview extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ListView Clicável");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4", "Item 5");

        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aqui você pode abrir a tela desejada com base no item selecionado
                abrirTela(selectedItem);
            }
        });

        VBox root = new VBox();
        root.getChildren().add(listView);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void abrirTela(String item) {
        // Implemente a lógica para abrir a tela com base no item clicado
        // Por exemplo, você pode abrir uma nova janela, trocar de cena, etc.
        System.out.println("Você clicou em: " + item);
        // Insira aqui a lógica para abrir a tela desejada
    }

    public static void main(String[] args) {
        launch(args);
    }
}