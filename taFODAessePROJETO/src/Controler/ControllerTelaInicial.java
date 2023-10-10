package Controler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerTelaInicial implements Initializable {
    private static final Stage stage = null;

    @FXML
    private Button btnVerTodasListas;

    @FXML
    private Button btnCriarTarefa;

    @FXML
    private Button btnVerTodasTarefas;

    @FXML
    private Label labelPrincipaisTarefas;

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private ListView<?> pnlViewDeTarefas;

    @FXML
    public void clickCriarTarefa(ActionEvent event) {
        System.out.println("Clicou criar Tarefas");
    }

    @FXML
    public void clickVerListas(ActionEvent event) {
        System.out.println("Clicou Ver listas");
    }

    @FXML
    public void clickVerTarefas(ActionEvent event) {
        System.out.println("Clicou Ver Tarefas");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //btnVerTodasListas.setOnMouseClicked((MouseEvent e) -> {
        //    System.out.println("Clicou Todas as listas");
        //});
            btnCriarTarefa.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                
                //Fecha a tela inicial
                stage.close();

                //Cria a nova Tela
                Stage telaCriar = new Stage();
                telaCriar.setTitle("Criar Tarefa");
                Button btnSalvar = new Button("Salvar");
                Button btnVoltarTelaInicial = new Button("Voltar");
                Button btnPrioridadeSIM = new Button("SIM");
                Button btnPrioridadeNAO = new Button("NÃO");
                Label lblNome = new Label("Nome:");
                Label lblDescricao = new Label("Descrição:");
                Label lblPrioridade = new Label("Prioridade:");

                TextField txtNome = new TextField();
                TextArea txtDescricao = new TextArea();


                AnchorPane root2 = new AnchorPane();
                root2.getChildren().addAll(btnSalvar);
                root2.getChildren().addAll(btnVoltarTelaInicial); 
                root2.getChildren().addAll(btnPrioridadeSIM);
                root2.getChildren().addAll(btnPrioridadeNAO);
                root2.getChildren().addAll(lblNome);
                root2.getChildren().addAll(lblDescricao);
                root2.getChildren().addAll(lblPrioridade);
                root2.getChildren().addAll(txtNome);
                root2.getChildren().addAll(txtDescricao);

                //POSIÇÂO DOS ELEMENTOS NA TELA
                root2.setTopAnchor(btnSalvar, 270.00);
                root2.setLeftAnchor(btnSalvar, 70.00);

                root2.setTopAnchor(btnVoltarTelaInicial, 270.00);
                root2.setLeftAnchor(btnVoltarTelaInicial, 20.00);


                root2.setTopAnchor(btnPrioridadeSIM, 230.00);
                root2.setLeftAnchor(btnPrioridadeSIM, 105.00);

                root2.setTopAnchor(btnPrioridadeNAO, 230.00);
                root2.setLeftAnchor(btnPrioridadeNAO, 145.00);

                root2.setTopAnchor(lblNome, 10.00);
                root2.setLeftAnchor(lblNome, 10.00);

                root2.setTopAnchor(lblDescricao, 40.00);
                root2.setLeftAnchor(lblDescricao, 10.00);

                root2.setTopAnchor(lblPrioridade, 230.00);
                root2.setLeftAnchor(lblPrioridade, 10.00);                

                root2.setTopAnchor(txtNome, 10.00);
                root2.setLeftAnchor(txtNome, 50.00);

                root2.setTopAnchor(txtDescricao, 40.00);
                root2.setLeftAnchor(txtDescricao, 70.00);

                //cria uma seta pra tela e exibe
                telaCriar.setScene(new Scene(root2, 600, 320));
                telaCriar.show();


            }
        });

        
    }}
