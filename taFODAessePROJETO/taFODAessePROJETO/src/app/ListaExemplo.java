package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListaExemplo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Listas");

        //cria a lista de item
        ObservableList<String> items = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5");

        // criei a listview e adiociona os item nela 
        ListView<String> listView = new ListView<>(items);

        // cria um Vbox que é tipo um fundo pra conseguir adcionar a listview na tela 
        VBox vbox = new VBox(listView);

        // cria uma cena e add o vbox
        Scene scene = new Scene(vbox, 300, 200);

        // configura a cena numa tela
        stage.setScene(scene);

        // mostra a tela 
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
