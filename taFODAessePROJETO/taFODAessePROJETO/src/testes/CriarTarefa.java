package testes;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CriarTarefa extends Application{
    private static Stage stage = null;

    public static void main(String[] args) throws Exception {
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{  
        try {
            //carregando o arquivo
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Criartarefa.fxml"));
            Parent root = fxmlLoader.load();
            
            //coloca o fxml em uma cena
            Scene tela = new Scene(root);

            //Configuração dos dados da tela
            stage.setTitle("Criação de Tarefa");
            stage.resizableProperty().setValue(Boolean.FALSE);;
        
            //atribuindo a cena a tela
            stage.setScene(tela);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stage){
        CriarTarefa.stage = stage;
    }
}