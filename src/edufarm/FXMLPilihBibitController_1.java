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
public class FXMLPilihBibitController_1 implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    
    @FXML
    private Label lbPanduan;
    
    @FXML
    private AnchorPane apBibit;
    
    @FXML
    private Button btCentang;
    
    @FXML
    private Button btHasil;
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan_1.fxml"));
        apBibit.getChildren().setAll(panduan);
    }
    
    
    @FXML
    private void handleButtonLogin(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        apBibit.getChildren().setAll(login);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String kalimat = "1. Perhatikan Bagian Daun\n" +
                    "Saat akan memilih bibit tanaman buah yang harus dipastikan adalah daunnya berwarna \nhijau cerah atau bagian pucuknya yang hijau kemerahan. " +
                    "Pastikan juga di semua bagian \ndaun tidak ada bekas termakan ulat dan hama yang lain. \n" +
                    "2. Jeli Melihat Batang Tanaman\n" +
                    "Setelah kondisi daun tidak ada masalah, maka lanjutkan dengan memperhatikan \nbatang tanaman sebelum membeli. Batang tanaman yang sehat tidak akan ada \nbekas sambungan pada batang, selain itu batang yang baru \nmuncul akan tegak lurus ke atas atau ke bawah dan tidak bengkok.\n" +
                    "3. Akar Jarang Diperhatikan Saat Membeli Bibit Buah\n" +
                    "Hal yang perlu Anda lakukan adalah membongkar media tanam dan memperhatikan \nakar serabut pada tanaman tersebut. Bibit buah yang berkualitas dan mampu \ntumbuh subur ditandai dengan akar serabut yang sangat banyak \ndan sangat mudah terlihat.\n" +
                    "4. Jika Bibit Sudah Berbuah, Anda Bisa Memperhatikan Hal Ini\n" +
                    "Anda harus memastikan kondisi buah yang tumbuh memiliki ukuran yang normal, \nwarna kulit yang cerah, dan rasanya sesuai dengan jenis buah tersebut. ";
        
        lbPanduan.setText(kalimat);
    }
    
}
