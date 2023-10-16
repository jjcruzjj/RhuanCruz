package testes;
import entidades.Tarefa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tabelaexemplo extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Listas");

        // Cria uma lista de objetos personalizados (por exemplo, Tarefa)
        ObservableList<Tarefa> tarefas = FXCollections.observableArrayList(
            new Tarefa("Tarefa 1", "Descrição 1"),
            new Tarefa("Tarefa 2", "Descrição 2"),
            new Tarefa("Tarefa 3", "Descrição 3"),
            new Tarefa("Tarefa 4", "Descrição 4"),
            new Tarefa("Tarefa 5", "Descrição 5")
        );

        // Criei uma TableView
        TableView<Tarefa> tableView = new TableView<>(tarefas);

        // criei as colunas 
        TableColumn<Tarefa, String> nomeColuna = new TableColumn<>("Nome");
        TableColumn<Tarefa, String> descricaoColuna = new TableColumn<>("Descrição");
        

        // Adicionei as colunas à TableView
        tableView.getColumns().addAll(nomeColuna, descricaoColuna);

        TableColumn<Tarefa, String> coluna = new TableColumn<>("Teste");
coluna.setCellValueFactory(new PropertyValueFactory<>("atributoModelo"));
coluna.setStyle("-fx-alignment: CENTER;"); // Exemplo de estilo para alinhar o conteúdo no centro
coluna.setStyle(STYLESHEET_CASPIAN);
coluna.setStyle("-fx-background-color: #3498db; -fx-text-fill: white;");
tableView.getColumns().addAll(coluna);
        // Criei um VBox pra TableView
        VBox vbox = new VBox(tableView);

        // Cria uma cena e add o VBox
        Scene scene = new Scene(vbox, 600, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        // poe a cena numa tela
        stage.setScene(scene);

        // mostra a tela
        stage.show();
    }

    private Object extracted3(CellDataFeatures<Tarefa, String> cellData) {
        return cellData.getValue().descricaoProperty();
    }

    private Object extracted2(CellDataFeatures<Tarefa, String> cellData) {
        return extracted(cellData);
    }

    private Object extracted(CellDataFeatures<Tarefa, String> cellData) {
        return cellData.getValue().nomeProperty();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
