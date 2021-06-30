/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.time.Month;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLHasilController implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    XYChart.Series chart = new XYChart.Series<>();
    Anggota list;
    String ubah,username;
    
    @FXML 
    private DatePicker dpTglPanen;
    
    @FXML 
    private ChoiceBox cbBulan;
    
    @FXML
    private TextField tfSayur;
    
    @FXML
    private TextField tfHasil;
    
    @FXML
    private BarChart bcHasil;
    
    @FXML
    private CategoryAxis cSayur;
    
    @FXML
    private NumberAxis nSayur;
    
    @FXML
    private AnchorPane apHasil;
    
    @FXML
    private Label label;
    
    @FXML
    private Button btPanduan;
    
//    ObservableList<Anggota> data = FXCollections.observableArrayList();
    ObservableList<Hasil> dataH = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        FXMLLoader uiPanduan = new FXMLLoader(getClass().getResource("FXMLPanduan.fxml"));
        Parent root = (Parent) uiPanduan.load();            
                
        FXMLPanduanController panduan = uiPanduan.getController();
        panduan.setNama(username);        
                
        btPanduan.getScene().setRoot(root); 
    }
    
    
    @FXML
    private void handleButtonTambah(ActionEvent event) {
        try{
            int i = 0;
            String namaSayur = tfSayur.getText();
            String hasilPanen = tfHasil.getText();
            int angka = Integer.parseInt(hasilPanen);
            String tanggal = dpTglPanen.getValue().toString();

            dataH.add(new Hasil(namaSayur, angka, tanggal));
            saveData(dataH);
            chart.getData().addAll(new XYChart.Data(namaSayur, angka));

//            for(Hasil dt : dataH){
//                if(namaSayur.equals(dataH.get(i).getNama())){
//                    System.out.println("ini sama");
//                    
////                    break;
//                }else{
//                    chart.getData().addAll(new XYChart.Data(namaSayur, angka));
//                    System.out.println("ini engga");
////                    break;
//                }
//                i++;
//            }
            
//            chart.getData().addAll(new XYChart.Data(namaSayur, angka));
            
            
        }catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perhatian!!!");
            alert.setHeaderText("Silahkan lengkapi informasi");
            alert.setContentText("Untuk menambahkan hasil panen silahkan lengkapi informasi");
            alert.showAndWait();
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Perhatian!!!");
            alert.setHeaderText("Silahkan masukkan informasi dengan benar");
            alert.setContentText("Untuk menambahkan hasil panen silahkan masukkan informasi dengan benar");
            alert.showAndWait();
        }
        
        clearField();      
    }
    
    @FXML
    private void handleButtonDetail(ActionEvent event) throws IOException {
        FXMLLoader uiTampil = new FXMLLoader(getClass().getResource("FXMLTampilDetail.fxml"));
        Parent root = (Parent) uiTampil.load();            
                
        FXMLTampilDetailController detail = uiTampil.getController();
        detail.setNama(username);  
        
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Detail Hasil Panen");
        stage.show();        
                
    }
    
    @FXML
    void handleButtonLogout(ActionEvent event) throws IOException {
        AnchorPane awal = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        apHasil.getChildren().setAll(awal);
    }
    
    private void saveData(ObservableList<Hasil> dataH) {
//        System.out.println("nama di metod savedata: "+ username);
        XStream xstream = new XStream(new StaxDriver());
        HasilList Hlist = new HasilList();
        Hlist.setListData(dataH);
        String xml = xstream.toXML(Hlist);
        
        FileOutputStream f = null;
        try{
            f = new FileOutputStream(username + ".xml");//pake nama anggota
            byte[] bytes = xml.getBytes("UTF-8");
            f.write(bytes);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            if(f != null){
                try{
                    f.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void loadData() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        
        try {
            f = new FileInputStream(username + ".xml");
            int isi;
            char c;
            String xml = "";
            
            while((isi = f.read() )!=-1){
                c = (char) isi;
                xml = xml + c;
            }           
            
            HasilList dataWrap = new HasilList();
            dataWrap = (HasilList) xstream.fromXML(xml);
            
            dataH.clear();
            dataH.addAll(dataWrap.getListData());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally{
            if(f!=null){
                try{
                    f.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        chart.setName("Hasil Panen");
        bcHasil.getData().addAll(chart);
    }    

    public String getNama() {
        return username;
    }

    public void setNama(String username) {
        this.username = username;
        int i = 0;
        loadData();
        for (Hasil dt : dataH) {
            chart.getData().addAll(new XYChart.Data(dataH.get(i).getNama(), dataH.get(i).getHasil()));
            i++;
        }
         
    }

    private void apa() {
        System.out.println("ini nama: " + username);    
    }

    private void clearField() {
        //untuk tambah
        tfSayur.clear();
        tfHasil.clear();
        dpTglPanen.setValue(null);

    } 
}
