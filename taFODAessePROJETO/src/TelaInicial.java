import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaInicial extends Application{
    private static Stage stage ; // uma janela

    public static void main(String[] args) throws Exception {
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{  
        
            //carregando o arquivo
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
            Parent root = fxmlLoader.load();
            
            //coloca o fxml em uma cena
            Scene tela = new Scene(root);

            //Configuração dos dados da tela
            stage.setTitle("Tela Inicial");
            stage.resizableProperty().setValue(Boolean.FALSE);;
        
            //atribuindo a cena a tela
            stage.setScene(tela);
            stage.show();
            setStage(stage);

    }


    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stage){
        TelaInicial.stage = stage;
    }
}