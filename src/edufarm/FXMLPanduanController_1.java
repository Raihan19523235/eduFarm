/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLPanduanController_1 implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    
    @FXML
    private AnchorPane apPanduan;
    
    @FXML
    private Button btLangkah;
    
    @FXML
    private Button btBibit;
    
    @FXML
    private Button btPupuk;
    
    @FXML
    private Button btHasil;
    
    
    @FXML
    private void handleButtonPilihPupuk(ActionEvent event) throws IOException {
        AnchorPane pilihPupuk = FXMLLoader.load(getClass().getResource("FXMLPilihPupuk_1.fxml"));
        apPanduan.getChildren().setAll(pilihPupuk);
    }
    
    @FXML
    private void handleButtonTanamPadi(ActionEvent event) throws IOException {
        AnchorPane langkah = FXMLLoader.load(getClass().getResource("FXMLLangkah_1.fxml"));
        apPanduan.getChildren().setAll(langkah);
    }
    
    @FXML
    private void handleButtonPilihBibit(ActionEvent event) throws IOException {
        AnchorPane pilihBibit = FXMLLoader.load(getClass().getResource("FXMLPilihBibit_1.fxml"));
        apPanduan.getChildren().setAll(pilihBibit);
    }
    
    @FXML
    private void handleButtonLogin(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        apPanduan.getChildren().setAll(login);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
