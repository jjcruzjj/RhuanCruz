package app;
import java.util.ArrayList;

import entidades.Tarefa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application{
    //private static Stage stage = null;
    private ArrayList<Tarefa> lista = new ArrayList<>();
    private boolean prioridade = false; 

    public static void main(String[] args) throws Exception {
    launch(args);
    
    }

    @Override
    public void start(Stage stage) throws Exception{  
        stage.setTitle("Tela inicial");
        Button botao = new Button("Criar tarefa");
        Button botaoVerListas = new Button("Ver Todas listas");
        Button botaoVerTarefas = new Button("Ver todas Tarefas");

        //ação do botao Criar Tarefa
        botao.setOnAction(new EventHandler<ActionEvent>(){
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
                root2.setTopAnchor(btnSalvar, 230.00);
                root2.setLeftAnchor(btnSalvar, 450.00);

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

                //cria uma cena pra tela e exibe
                telaCriar.setScene(new Scene(root2, 600, 320));
                telaCriar.show();

            btnVoltarTelaInicial.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    telaCriar.close();
                    stage.show();
                }
            });
            
            btnPrioridadeSIM.setOnAction(new EventHandler<ActionEvent>(){
                private boolean prioridade;

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
                    System.out.println(t.getNome()); // Imprime o nome da tarefa (você pode ajustar essa parte conforme necessário)
                    System.out.println(t.getDescricao());
                }
            });

            }
        });
    




        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(botao);
        root.getChildren().addAll(botaoVerListas); 
        root.getChildren().addAll(botaoVerTarefas);
        
        root.setTopAnchor(botao, 90.00);
        root.setLeftAnchor(botao, 115.00);

        root.setTopAnchor(botaoVerTarefas, 120.00);
        root.setLeftAnchor(botaoVerTarefas, 100.00);


        root.setTopAnchor(botaoVerListas, 150.00);
        root.setLeftAnchor(botaoVerListas, 105.00);

        stage.setScene(new Scene(root, 300, 250));
        stage.show();
        
    }


    
}
