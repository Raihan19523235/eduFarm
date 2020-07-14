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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLLangkahController implements Initializable {

    @FXML
    private Label lblangkah;
    
    @FXML
    private AnchorPane apLangkah;
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan.fxml"));
        apLangkah.getChildren().setAll(panduan);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        AnchorPane hasil = FXMLLoader.load(getClass().getResource("FXMLHasil.fxml"));
        apLangkah.getChildren().setAll(hasil);
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
    
}
