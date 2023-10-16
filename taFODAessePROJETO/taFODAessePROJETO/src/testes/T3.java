package testes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T3 extends Application {
    @Override
    public void start(Stage stage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Item 1 (Alta Prioridade)", "Item 2 (Baixa Prioridade)", "Item 3 (Alta Prioridade)");

        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);

                            if (item.contains("Alta Prioridade")) {
                                setTextFill(Color.RED);
                            } else {
                                setTextFill(Color.BLACK);
                            }
                        }
                    }
                };
            }
        });

        Scene scene = new Scene(listView, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
