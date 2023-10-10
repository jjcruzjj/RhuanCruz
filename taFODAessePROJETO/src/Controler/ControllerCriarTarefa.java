package Controler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerCriarTarefa implements Initializable {
    
    @FXML
    private Button btnPrioridadeNAO;

    @FXML
    private Button btnPrioridadeSIM;

    @FXML
    private Button btnSalvarTarefa;

    @FXML
    private Button btnVoltarPraTelaInicial;

    @FXML
    private AnchorPane pnlCriarTarefa;

    @FXML
    private TextArea txtDescricaoTarefa;

    @FXML
    private TextField txtNomeTarefa;

    @FXML
    public void clickPrioriadadeNAO(ActionEvent event) {
        
    }

    @FXML
    public void clickPrioriadadeSIM(ActionEvent event) {

    }

    @FXML
    public void clickSalvarTarefa(ActionEvent event) {

    }

    @FXML
    public void clickVoltarTelainicial(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //btnVerTodasListas.setOnMouseClicked((MouseEvent e) -> {
        //    System.out.println("Clicou Todas as listas");
        //});

        
    }
}
