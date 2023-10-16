package testes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class teste extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("VBox Rolável em um AnchorPane");

        AnchorPane root = new AnchorPane();

        // Crie um ScrollPane
        ScrollPane scrollPane = new ScrollPane();

        // Crie uma VBox para conter o conteúdo rolável
        VBox vbox = new VBox(10);
        vbox.setStyle("-fx-background-color: lightblue;");
        

        // Crie um ListView para adicionar ao VBox
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4");

        // Adicione alguns elementos à VBox
        Label label = new Label("Outros elementos na VBox");
        vbox.getChildren().addAll(label, listView);

        // Adicione a VBox ao ScrollPane
        scrollPane.setContent(vbox);

        // Ancore o ScrollPane dentro do AnchorPane
        AnchorPane.setTopAnchor(scrollPane, 20.0);
        AnchorPane.setLeftAnchor(scrollPane, 20.0);
        AnchorPane.setBottomAnchor(scrollPane, 20.0);
        AnchorPane.setRightAnchor(scrollPane, 20.0);

        root.getChildren().add(scrollPane);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
