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
public class FXMLLangkahController implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    
    @FXML
    private Label lblangkah;
    
    @FXML
    private AnchorPane apLangkah;
    
    @FXML
    private Button btCentang;
    
    @FXML
    private Button btHasil;
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        FXMLLoader uiPanduan = new FXMLLoader(getClass().getResource("FXMLPanduan.fxml"));
        Parent root = (Parent) uiPanduan.load();            
                
        FXMLPanduanController panduan = uiPanduan.getController();
        panduan.setNama(username);        
                
        btCentang.getScene().setRoot(root); 
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        FXMLLoader uiHasil = new FXMLLoader(getClass().getResource("FXMLHasil.fxml"));
        Parent root = (Parent) uiHasil.load();            
                
        FXMLHasilController hasil = uiHasil.getController();
        hasil.setNama(username);        
                
        btHasil.getScene().setRoot(root); 
    }
    
    @FXML
    void handleButtonLogout(ActionEvent event) throws IOException {
        AnchorPane awal = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        apLangkah.getChildren().setAll(awal);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String kalimat = "1. Pembuatan Bedengan untuk Persemaian/Pembibitan Padi\n" +
                "Cara menanam padi pada umumnya bukan dengan benih langsung tanam, namun dengan \nbibit yang sebelumnya disemai terlebih dahulu. Penyemaian padi dilakukan dengan membuat \nbedengan semai yang dilakukan bersamaan saat olah tanah. \n" +
                "2. Persiapan Benih dan Menyemai Benih Padi \n" +
                "3. Penyiapan Lahan Padi \n" +
                "Penyiapan lahan terdiri atas beberapa langkah, yaitu: pembersihan lahan dari \ngulma atau bekas tanaman lama, penggenangan lahan, olah tanah, dan penggaruan. \n" +
                "4. Pindah Tanam dan Perawatan Masa Vegetatif Padi\n" +
                "Pindah tanam bibit padi adalah saat berusia 3-4 minggu (kurang lebih 5-7 daun). \nCara penanamannya yakni bibit padi jangan ditanam terlalu dalam karena berakibat \npertumbuhan tanaman menjadi lambat.\n" +
                "5. Pengairan Tanaman Padi \n" +
                "Pengairan dilakukan dengan pola irigasi berselang, yaitu tanah dialiri air dalam \nkondisi macak-macak.\n" +
                "6. Pemupukan Padi\n" +
                "7. Pengendalian Gulma pada Tanaman Padi\n" +
                "8. Panen Padi \n" +
                "Masa/umur panen biasanya dilakukan setelah umur 30 hari setelah masa pembungaan \natau bisa dilihat dari kondisi fisik gabah yang telah berubah warna menjadi kuning. ";
        
        lblangkah.setText(kalimat);
    }    
    public String getNama() {
        return username;
    }

    public void setNama(String username) {
        this.username = username;
        
    }
}
