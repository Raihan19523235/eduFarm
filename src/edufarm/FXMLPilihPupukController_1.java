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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLPilihPupukController_1 implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    @FXML
    private Label lbKalimat;
    
    @FXML
    private AnchorPane apPupuk;
    
    @FXML
    private Button btCentang;
    
    @FXML
    private Button btHasil;
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan_1.fxml"));
        apPupuk.getChildren().setAll(panduan);
    }
    
    
    @FXML
    private void handleButtonLogin(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        apPupuk.getChildren().setAll(login);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String kalimat = "Pupuk merupakan hal penting dalam kegiatan bercocok \ntanam, karena pupuk mengandung satu atau lebih \nunsur hara yang memberikan nutrisi bagi tanaman, \nsalah satunya adalah pupuk organik. "+
                    "Pupuk organik lebih \ndiminati karena tidak memberian dampak negatif pada \ntanaman dan pembuatannya sangat sederhana.\n" +
                    "Berikut adalah hal yang harus diperhatikan dalam \nmemilih pupuk organik yang baik dan benar :\n\n" +
                    "1. Pupuk berkualitas, pastikan membeli pupuk berkualitas \ntinggi dan bermutu untuk meningkatkan produksi pada \ntanaman.\n" +
                    "2. Memahami kandungan pupuk, pastikan anda tahu \ntentang kegunaan serta manfaat, dan komposisi pupuk.\n" +
                    "3. Pupuk terpercaya, pastikan anda membeli pupuk yang \nmemiliki sertifikat dari Deptan dan teruji secara klinis.";
        lbKalimat.setText(kalimat);   
    }

}
