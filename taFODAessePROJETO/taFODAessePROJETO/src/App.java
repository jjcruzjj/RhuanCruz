
import java.util.ArrayList;

import entidades.ListadeTarefas;
import entidades.Tarefa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
    //private static Stage stage = null;
    private ArrayList<Tarefa> lista = new ArrayList<>();
    private boolean prioridade = false; 
    private boolean prioridadeLista = false;
    private ArrayList<ListadeTarefas> visualizacao = new ArrayList<>();


    public static void main(String[] args) throws Exception {
    launch(args);
    
    }

    @Override
    public void start(Stage stage) throws Exception{  
        stage.initStyle(StageStyle.UNDECORATED);
        
        stage.setTitle("Tela inicial");

        //Elementos da tela inicial 
        Button botao = new Button("Nova Tarefa");
        Button botaoVerListas = new Button("Ver Todas listas");
        Button botaoVerTarefas = new Button("Ver todas Tarefas");
        Button botaoCriarListas = new Button("Nova Lista");
        Button botaoFecharapp = new Button("x");    
        Button botaoMinimizaApp = new Button("-");
        
        //add os estilos nos botoes da tela inicial 
        botao.getStyleClass().add("rounded-button");
        botaoVerListas.getStyleClass().add("rounded-button");
        botaoVerTarefas.getStyleClass().add("rounded-button");
        botaoCriarListas.getStyleClass().add("rounded-button");


        botaoMinimizaApp.setStyle("-fx-background-color: #422402; -fx-text-fill: white; -fx-font-size: 12px;");
        botaoMinimizaApp.setOnMouseEntered(e -> botaoMinimizaApp.setStyle("-fx-background-color: #c44800; -fx-text-fill: white; -fx-font-size: 12px;"));
        botaoMinimizaApp.setOnMouseExited(e -> botaoMinimizaApp.setStyle("-fx-background-color: #422402; -fx-text-fill: white; -fx-font-size: 12px;"));

        botaoFecharapp.setStyle("-fx-background-color: #422402; -fx-text-fill: white; -fx-font-size: 12px;");
        botaoFecharapp.setOnMouseEntered(e -> botaoFecharapp.setStyle("-fx-background-color: #ff0000; -fx-text-fill: white; -fx-font-size: 12px;"));
        botaoFecharapp.setOnMouseExited(e -> botaoFecharapp.setStyle("-fx-background-color: #422402; -fx-text-fill: white; -fx-font-size: 12px;"));
        // add imagem ao plano de fundo do app
        Image FundoDaTelaInicialIMAGE = new Image(getClass().getResourceAsStream("/imagens/TelaUM.jpg"));
        BackgroundImage FundoDaTelaInicial = new BackgroundImage(FundoDaTelaInicialIMAGE, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);

        //criando layout da tela inicial
        AnchorPane TelaInicial = new AnchorPane();
        TelaInicial.getChildren().addAll(botao,botaoVerListas, botaoVerTarefas, botaoFecharapp, botaoMinimizaApp, botaoCriarListas); // add os elemetos na tela
        TelaInicial.setBackground(new Background(FundoDaTelaInicial));
        //POSIÇÂO DOS ELEMENTOS NA TELA INICIAL
        AnchorPane.setTopAnchor(botao, 25.00);
        AnchorPane.setLeftAnchor(botao, 105.00);
        AnchorPane.setTopAnchor(botaoVerTarefas, 75.00);
        AnchorPane.setLeftAnchor(botaoVerTarefas, 88.00);
        AnchorPane.setTopAnchor(botaoCriarListas, 145.00);
        AnchorPane.setLeftAnchor(botaoCriarListas, 105.00);
        AnchorPane.setTopAnchor(botaoVerListas, 195.00);
        AnchorPane.setLeftAnchor(botaoVerListas, 92.00);
        AnchorPane.setTopAnchor(botaoFecharapp, 5.00);
        AnchorPane.setLeftAnchor(botaoFecharapp, 265.00);
        AnchorPane.setTopAnchor(botaoMinimizaApp, 5.00);
        AnchorPane.setLeftAnchor(botaoMinimizaApp, 240.00);
        

        // cria a cena e configura o tamanho 
        Scene tela = new Scene(TelaInicial, 300,250);
        //vincula no arquivo CSS
        tela.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // proibe o usuario mudar o tamanho da janela 
        stage.resizableProperty().setValue(Boolean.FALSE);;
        //atribui a cena a tela 
        stage.setScene(tela);
        stage.show();



        //Criação da tela de Criação de tarefa
        Stage telaCriar = new Stage();
        //tira a barra da janela 
        telaCriar.initStyle(StageStyle.TRANSPARENT);
        //importa a imagem de fundo
        Image FundoDaTelaCriarIMAGE = new Image(getClass().getResourceAsStream("/imagens/TelaCRIAR.jpg"));
        //define um objeto para a imagem de fundo
        BackgroundImage FundoDaTelaCriar = new BackgroundImage(FundoDaTelaCriarIMAGE, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);
                
        Button btnSalvar = new Button("Salvar");
        Button btnVoltarTelaInicial = new Button("Voltar");
        Button btnPrioridadeSIM = new Button("SIM");
        Button btnPrioridadeNAO = new Button("NÃO");
        Label lblNome = new Label("Nome:");
        Label lblDescricao = new Label("Descrição:");
        Label lblPrioridade = new Label("Prioridade:");
        TextField txtNome = new TextField();
        TextArea txtDescricao = new TextArea();
        //configurando os elementos
        txtDescricao.setWrapText(true);
        txtDescricao.setStyle("-fx-text-fill: black; -fx-background-color: #c09f83;");
        txtNome.setStyle("-fx-text-fill: black; -fx-background-color: #c09f83;");
            
        Line line = new Line(55, 33, 203, 33); 
        line.setStyle("-fx-stroke: #301b03;"); // Cor da linha

        // add estilo ao elementos da tela de criação
        btnSalvar.getStyleClass().add("rounded-button");
        btnVoltarTelaInicial.getStyleClass().add("rounded-button");
        btnPrioridadeSIM.getStyleClass().add("rounded-button");
        btnPrioridadeNAO.getStyleClass().add("rounded-button");
        //muda cor das label
        //lblNome.setStyle("-fx-text-fill: #301b03");
        lblNome.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #301b03;");
        lblDescricao.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #301b03;");
        lblPrioridade.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #301b03;");

        AnchorPane TelaCriacaoDeTarefa = new AnchorPane();
        // Define o fundo da tela 
        TelaCriacaoDeTarefa.setBackground(new Background(FundoDaTelaCriar));
        //TelaCriacaoDeTarefa.setStyle("-fx-background-color: #c09f83;");
        //add elementos na tela
        TelaCriacaoDeTarefa.getChildren().addAll(btnSalvar,btnVoltarTelaInicial , btnPrioridadeSIM, btnPrioridadeNAO, lblNome,
        lblDescricao, lblPrioridade, txtNome, txtDescricao, line);

        AnchorPane.setTopAnchor(btnSalvar, 230.00);
        AnchorPane.setLeftAnchor(btnSalvar, 450.00);

        AnchorPane.setTopAnchor(btnVoltarTelaInicial, 270.00);
        AnchorPane.setLeftAnchor(btnVoltarTelaInicial, 20.00);

        AnchorPane.setTopAnchor(btnPrioridadeSIM, 230.00);
        AnchorPane.setLeftAnchor(btnPrioridadeSIM, 105.00);

        AnchorPane.setTopAnchor(btnPrioridadeNAO, 230.00);
        AnchorPane.setLeftAnchor(btnPrioridadeNAO, 170.00);

        AnchorPane.setTopAnchor(lblNome, 14.00);
        AnchorPane.setLeftAnchor(lblNome, 10.00);

        AnchorPane.setTopAnchor(lblDescricao, 45.00);
        AnchorPane.setLeftAnchor(lblDescricao, 10.00);

        AnchorPane.setTopAnchor(lblPrioridade, 224.00);
        AnchorPane.setLeftAnchor(lblPrioridade, 10.00);

        AnchorPane.setTopAnchor(txtNome, 10.00);
        AnchorPane.setLeftAnchor(txtNome, 55.00);

        AnchorPane.setTopAnchor(txtDescricao, 40.00);
        AnchorPane.setLeftAnchor(txtDescricao, 85.00);

        //cria uma cena pra tela 
        telaCriar.setScene(new Scene(TelaCriacaoDeTarefa, 600, 320));
        //add estilo na cena
        TelaCriacaoDeTarefa.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        

        // tela de ver tarefas listadas
        Stage TelaTarefas = new Stage();
        ListView<String> listaTarefaPadrão = new ListView<>();
        Button btnVoltar = new Button("Voltar");
        // add items pra teste da interface
        listaTarefaPadrão.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 5","Item 5","Item 5",
        "Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5");

        //add estilo aos elementos
        btnVoltar.getStyleClass().add("rounded-button");
        listaTarefaPadrão.getStylesheets().add(getClass().getResource("listastyle.css").toExternalForm());
        listaTarefaPadrão.setPrefSize(350, 340);

        VBox vBox = new VBox();
        vBox.getChildren().add(listaTarefaPadrão);
        
        vBox.setPrefSize(375, 340);

        AnchorPane pnlTelaVerTarefas = new AnchorPane();
        pnlTelaVerTarefas.getChildren().addAll(vBox, btnVoltar);

        AnchorPane.setTopAnchor(btnVoltar, 350.00);
        AnchorPane.setLeftAnchor(btnVoltar, 20.00);

        Scene scene = new Scene(pnlTelaVerTarefas, 400, 400);
        TelaTarefas.setScene(scene);

        Image FundoDaTelaListagemdeTraefasIMAGE = new Image(getClass().getResourceAsStream("/imagens/telaListas.jpg"));
        BackgroundImage FundoDaTelaListagemdeTarefas = new BackgroundImage(FundoDaTelaListagemdeTraefasIMAGE, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);
        pnlTelaVerTarefas.setBackground(new Background(FundoDaTelaListagemdeTarefas));
        vBox.setBackground(new Background(FundoDaTelaListagemdeTarefas));
        listaTarefaPadrão.setBackground(new Background(FundoDaTelaListagemdeTarefas));
        pnlTelaVerTarefas.getStylesheets().add(getClass().getResource("style.css").toExternalForm());



        //tela criar lista
        Stage CriaLista = new Stage();

        CriaLista.initStyle(StageStyle.TRANSPARENT);

        Image FundoDaTelaCriarListaIMAGE = new Image(getClass().getResourceAsStream("/imagens/FundoCriaLista.jpg"));
        BackgroundImage FundoDaTelaCriarLista = new BackgroundImage(FundoDaTelaCriarListaIMAGE, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);

        Button salvarLista = new Button("Salvar");
        Button voltarPraTelaInicial = new Button("Voltar");
        Button prioridadeDaListaSIM = new Button("SIM");
        Button prioridadeDaListaNAO = new Button("NÃO");
        Label lblnomeDalista = new Label("Nome:");
        Label lblprioridadeDaLista = new Label("Prioridade:");
        TextField txtNomeLista = new TextField();

        txtNomeLista.setStyle("-fx-text-fill: black; -fx-background-color: #c09f83;");
        
        salvarLista.getStyleClass().add("rounded-button");
        voltarPraTelaInicial.getStyleClass().add("rounded-button");
        prioridadeDaListaNAO.getStyleClass().add("rounded-button");
        prioridadeDaListaSIM.getStyleClass().add("rounded-button");

        AnchorPane TelaCriarLista = new AnchorPane();
        TelaCriarLista.setBackground(new Background(FundoDaTelaCriar));
        TelaCriarLista.getChildren().addAll(salvarLista, voltarPraTelaInicial, prioridadeDaListaSIM, 
        prioridadeDaListaNAO, lblnomeDalista, lblprioridadeDaLista, txtNomeLista, line);

        TelaCriarLista.setBackground(new Background(FundoDaTelaCriarLista));
        AnchorPane.setTopAnchor(salvarLista, 180.00);
        AnchorPane.setLeftAnchor(salvarLista, 200.00);

        AnchorPane.setTopAnchor(voltarPraTelaInicial, 180.00);
        AnchorPane.setLeftAnchor(voltarPraTelaInicial, 20.00);

        AnchorPane.setTopAnchor(prioridadeDaListaSIM, 60.00);
        AnchorPane.setLeftAnchor(prioridadeDaListaSIM, 80.00);

        AnchorPane.setTopAnchor(prioridadeDaListaNAO, 60.00);
        AnchorPane.setLeftAnchor(prioridadeDaListaNAO, 145.00);

        AnchorPane.setTopAnchor(lblnomeDalista, 14.00);
        AnchorPane.setLeftAnchor(lblnomeDalista, 10.00);

        AnchorPane.setTopAnchor(lblprioridadeDaLista, 60.00);
        AnchorPane.setLeftAnchor(lblprioridadeDaLista, 10.00);

        AnchorPane.setTopAnchor(txtNomeLista, 10.00);
        AnchorPane.setLeftAnchor(txtNomeLista, 55.00);

        CriaLista.setScene(new Scene(TelaCriarLista,300, 250));
        TelaCriarLista.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        //tela de ver todas listas 
        Stage TelaListas = new Stage();
        ListView<String> listasPadrão = new ListView<>();
        Button btVoltar = new Button("Voltar");
        // add items pra teste da interface
        listasPadrão.getItems().addAll("Item 1", "Item 2", "Item 3", "Item 4", "Item 5","Item 5","Item 5","Item 5",
        "Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5","Item 5");

        //add estilo aos elementos
        btVoltar.getStyleClass().add("rounded-button");
        listasPadrão.getStylesheets().add(getClass().getResource("listastyle.css").toExternalForm());
        listasPadrão.setPrefSize(350, 340);

        VBox vBoxListas = new VBox();
        vBoxListas.getChildren().add(listasPadrão);
        
        vBoxListas.setPrefSize(375, 340);

        AnchorPane pnlTelaVerListas = new AnchorPane();
        pnlTelaVerListas.getChildren().addAll(vBoxListas, btVoltar);

        AnchorPane.setTopAnchor(btVoltar, 350.00);
        AnchorPane.setLeftAnchor(btVoltar, 20.00);

        Scene cenaTelaverTarefas = new Scene(pnlTelaVerListas, 400, 400);
        TelaListas.setScene(cenaTelaverTarefas);

        Image FundoDaTelaListagemdeListasIMAGE = new Image(getClass().getResourceAsStream("/imagens/telaListas.jpg"));
        BackgroundImage FundoDaTelaListagemdeListas = new BackgroundImage(FundoDaTelaListagemdeListasIMAGE, 
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
        BackgroundSize.DEFAULT);
        pnlTelaVerListas.setBackground(new Background(FundoDaTelaListagemdeListas));
        vBoxListas.setBackground(new Background(FundoDaTelaListagemdeTarefas));
        listasPadrão.setBackground(new Background(FundoDaTelaListagemdeListas));
        pnlTelaVerListas.getStylesheets().add(getClass().getResource("style.css").toExternalForm());



/////////////////////////////////////////////Metodos dos Botões/////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        listaTarefaPadrão.setOnMouseClicked(event -> {
            String selectedItem = listaTarefaPadrão.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                // Aqui você pode abrir a tela desejada com base no item selecionado
                //abrirTela(selectedItem);
            }
        });


        //ação botao fechar app
        botaoFecharapp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stage.close();
            }
        });

        //ação botao minimizar
        botaoMinimizaApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stage.setIconified(true);
            }
        });



        //ação do botao Criar Tarefa
        botao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
                //Fecha a tela inicial
                stage.close();
                telaCriar.show();
        }
        });

        botaoCriarListas.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
                //Fecha a tela inicial
                stage.close();
                CriaLista.show();
        }
        });

        voltarPraTelaInicial.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    CriaLista.close();
                    stage.show();
                }
            });
        btnVoltar.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    TelaTarefas.close();
                    stage.show();
                }
            });
            
            btVoltar.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    TelaListas.close();
                    stage.show();
                }
            });

        btnVoltarTelaInicial.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    telaCriar.close();
                    stage.show();
                }
            });


            btnPrioridadeSIM.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    prioridade = true;
                    System.out.println(prioridade);
                }
            });

            btnSalvar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // Cria uma nova tarefa com a prioridade configurada e a adiciona à lista
                    Tarefa t = new Tarefa(txtNome.getText(), txtDescricao.getText(), prioridade, false);
                    lista.add(t);
                    System.out.println(t.getNome()); 
                    System.out.println(t.getDescricao());
                    System.out.println(t.isPrioridade());
                }
            });

         //ação botao ver listas 
        botaoVerTarefas.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                stage.close();
                TelaTarefas.show();
            }
        });

        prioridadeDaListaSIM.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                prioridadeLista = true;
                System.out.println(prioridadeLista);
            }
        });
        salvarLista.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                ListadeTarefas l = new ListadeTarefas(txtNomeLista.getText(), prioridadeLista);
                visualizacao.add(l);
                System.out.println(visualizacao.size());
                System.out.println(l.isPrioridade());
            }
        });

        botaoVerListas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                stage.close();
                TelaListas.show();
            }
        });


    }
    // private void abrirTarefa(Tarefa item) {
    //     // Implemente a lógica para abrir a tela com base no item clicado
    //     // Por exemplo, você pode abrir uma nova janela, trocar de cena, etc.
    //     System.out.println("Você clicou em: " + item);
    //     // Insira aqui a lógica para abrir a tela desejada
    // }


}
