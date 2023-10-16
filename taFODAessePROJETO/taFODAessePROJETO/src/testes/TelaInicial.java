package testes;

import java.util.ArrayList;

import entidades.Tarefa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicial extends Application{
    //private static Stage stage = null;
    private ArrayList<Tarefa> lista = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    launch(args);
    
    }

    @Override
    public void start(Stage stage) throws Exception{  
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setTitle("Tela inicial");

        //Elementos da tela inicial 
        Button botao = new Button("Criar tarefa");
        Button botaoVerListas = new Button("Ver Todas listas");
        Button botaoVerTarefas = new Button("Ver todas Tarefas");
        Button botaoFecharapp = new Button("x");
        
        //add os estilos nos botoes da tela inicial 
        botao.getStyleClass().add("rounded-button");
        botaoVerListas.getStyleClass().add("rounded-button");
        botaoVerTarefas.getStyleClass().add("rounded-button");

        botaoFecharapp.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 12px;");
        botaoFecharapp.setOnMouseEntered(e -> botaoFecharapp.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 12px;"));
        botaoFecharapp.setOnMouseExited(e -> botaoFecharapp.setStyle("-fx-background-color: #422402; -fx-text-fill: white; -fx-font-size: 12px;"));
        // add imagem ao plano de fundo do app
        Image backgroundImage = new Image(getClass().getResourceAsStream("TelaUM.jpg"));
        BackgroundImage background = new BackgroundImage(backgroundImage, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);

        //criando layout da tela inicial
        AnchorPane TelaInicial = new AnchorPane();
        TelaInicial.getChildren().addAll(botao,botaoVerListas, botaoVerTarefas, botaoFecharapp); // add os elemetos na tela
        TelaInicial.setBackground(new Background(background));
        //POSIÇÂO DOS ELEMENTOS NA TELA INICIAL
        AnchorPane.setTopAnchor(botao, 20.00);
        AnchorPane.setLeftAnchor(botao, 100.00);
        AnchorPane.setTopAnchor(botaoVerTarefas, 90.00);
        AnchorPane.setLeftAnchor(botaoVerTarefas, 80.00);
        AnchorPane.setTopAnchor(botaoVerListas, 165.00);
        AnchorPane.setLeftAnchor(botaoVerListas, 87.00);
        AnchorPane.setTopAnchor(botaoFecharapp, 5.00);
        AnchorPane.setLeftAnchor(botaoFecharapp, 265.00);
        // cria a cena e configura o tamanho 
        Scene tela = new Scene(TelaInicial, 300,250);
        //vincula no arquivo CSS
        tela.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        // proibe o usuario mudar o tamanho da janela 
        stage.resizableProperty().setValue(Boolean.FALSE);;
        //atribui a cena a tela 
        stage.setScene(tela);
        stage.show();
    }
}