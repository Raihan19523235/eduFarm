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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author PREDATOR
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private Label label1;
    
    @FXML
    private Label label2;
    
    @FXML
    private Label label3;
    
    @FXML
    private Label label4;
    
    @FXML
    private Label label5;
    
    @FXML
    private Label label6;
    
    @FXML
    private Label label7;
    
    @FXML
    private Label label8;
    
    @FXML
    private Label label9;
    
    @FXML
    private AnchorPane apAwal;
    
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
//        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan.fxml"));
//        apAwal.getChildren().setAll(panduan);
        AnchorPane sistemAdmin = FXMLLoader.load(getClass().getResource("FXMLSistemAdmin.fxml"));
        apAwal.getChildren().setAll(sistemAdmin);

    }
    
    @FXML
    private void handleButtonLogin(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        apAwal.getChildren().setAll(login);

    }
    
    @FXML
    private void handleButtonMulai(ActionEvent event) throws IOException {
        AnchorPane mulai = FXMLLoader.load(getClass().getResource("FXMLDaftar.fxml"));
        apAwal.getChildren().setAll(mulai);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
