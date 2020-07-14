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
public class FXMLMenuUtamaController implements Initializable {

   @FXML
    private AnchorPane apMenuUtama;
    
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan.fxml"));
        apMenuUtama.getChildren().setAll(panduan);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLHasil.fxml"));
        apMenuUtama.getChildren().setAll(login);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
