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
public class FXMLPanduanController implements Initializable {
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
        System.out.println(username);
        FXMLLoader uiPilihPupuk = new FXMLLoader(getClass().getResource("FXMLPilihPupuk.fxml"));
        Parent root = (Parent) uiPilihPupuk.load();            
                
        FXMLPilihPupukController pupuk = uiPilihPupuk.getController();
        pupuk.setNama(username);        
                
        btPupuk.getScene().setRoot(root); 
    }
    
    @FXML
    private void handleButtonTanamPadi(ActionEvent event) throws IOException {
        System.out.println(username);

        FXMLLoader uiLangkah = new FXMLLoader(getClass().getResource("FXMLLangkah.fxml"));
        Parent root = (Parent) uiLangkah.load();            
                
        FXMLLangkahController langkah = uiLangkah.getController();
        langkah.setNama(username);        
                
        btLangkah.getScene().setRoot(root); 
    }
    
    @FXML
    private void handleButtonPilihBibit(ActionEvent event) throws IOException {
        System.out.println(username);

        FXMLLoader uiPilihBibit = new FXMLLoader(getClass().getResource("FXMLPilihBibit.fxml"));
        Parent root = (Parent) uiPilihBibit.load();            
                
        FXMLPilihBibitController bibit = uiPilihBibit.getController();
        bibit.setNama(username);        
                
        btBibit.getScene().setRoot(root); 
    }
    
    @FXML
    void handleButtonLogout(ActionEvent event) throws IOException {
        AnchorPane awal = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        apPanduan.getChildren().setAll(awal);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        System.out.println(username);

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
