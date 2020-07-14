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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLPanduanController implements Initializable {

    @FXML
    private AnchorPane apPanduan;
    
    @FXML
    private void handleButtonPilihPupuk(ActionEvent event) throws IOException {
        AnchorPane pilihPupuk = FXMLLoader.load(getClass().getResource("FXMLPilihPupuk.fxml"));
        apPanduan.getChildren().setAll(pilihPupuk);
    }
    
    @FXML
    private void handleButtonTanamPadi(ActionEvent event) throws IOException {
        AnchorPane langkah = FXMLLoader.load(getClass().getResource("FXMLLangkah.fxml"));
        apPanduan.getChildren().setAll(langkah);
    }
    
    @FXML
    private void handleButtonPilihBibit(ActionEvent event) throws IOException {
        AnchorPane pilihBibit = FXMLLoader.load(getClass().getResource("FXMLPilihBibit.fxml"));
        apPanduan.getChildren().setAll(pilihBibit);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        AnchorPane Hasil = FXMLLoader.load(getClass().getResource("FXMLHasil.fxml"));
        apPanduan.getChildren().setAll(Hasil);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
