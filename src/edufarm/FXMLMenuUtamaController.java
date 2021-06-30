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
public class FXMLMenuUtamaController implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    
    @FXML
    private AnchorPane apMenuUtama;
    @FXML
    private Button btPanduan;
    @FXML
    private Button btHasil;
    
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        FXMLLoader uiPanduan = new FXMLLoader(getClass().getResource("FXMLPanduan.fxml"));
        Parent root = (Parent) uiPanduan.load();            

        FXMLPanduanController panduan = uiPanduan.getController();
        panduan.setNama(username);        

        btPanduan.getScene().setRoot(root);
    }
    
    @FXML
    void handleButtonLogout(ActionEvent event) throws IOException {
        AnchorPane awal = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        apMenuUtama.getChildren().setAll(awal);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        FXMLLoader uiHasil = new FXMLLoader(getClass().getResource("FXMLHasil.fxml"));
        Parent root = (Parent) uiHasil.load();            
                
        FXMLHasilController hasil = uiHasil.getController();
        hasil.setNama(username);        
                
        btHasil.getScene().setRoot(root);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public String getNama() {
        return username;
    }

    public void setNama(String username) {
        this.username = username;
        
    }
}
