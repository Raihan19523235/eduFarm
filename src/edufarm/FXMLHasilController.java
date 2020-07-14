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
import java.net.URL;
import java.time.Month;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLHasilController implements Initializable {
    XYChart.Series chart = new XYChart.Series<>();
    Anggota list;String ubah;
    
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
    
    ObservableList<Anggota> data = FXCollections.observableArrayList();
    ObservableList<Hasil> dataH = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonPanduan(ActionEvent event) throws IOException {
        AnchorPane panduan = FXMLLoader.load(getClass().getResource("FXMLPanduan.fxml"));
        apHasil.getChildren().setAll(panduan);
    }
    
    @FXML
    private void handleButtonHasil(ActionEvent event) throws IOException {
        AnchorPane hasil = FXMLLoader.load(getClass().getResource("FXMLHasil.fxml"));
        apHasil.getChildren().setAll(hasil);
    }
    
    @FXML
    private void handleButtonTambah(ActionEvent event) {
        String namaSayur = tfSayur.getText();
        String hasilPanen = tfHasil.getText();
        int angka = Integer.parseInt(hasilPanen);
        Month bulanPanen = dpTglPanen.getValue().getMonth();
        ubah = String.valueOf(bulanPanen);
        String tanggal = dpTglPanen.getValue().toString();
        
        
        chart.getData().add(new XYChart.Data(namaSayur, angka));
        dataH.add(new Hasil(namaSayur, angka, ubah, tanggal));
        saveData(dataH);
        
        System.out.println(ubah + " " + hasilPanen + " " + tanggal);
    }
    
    private void saveData(ObservableList<Hasil> dataH) {
        XStream xstream = new XStream(new StaxDriver());
        HasilList Hlist = new HasilList();
        Hlist.setListData(dataH);
        String xml = xstream.toXML(Hlist);
        
        FileOutputStream f = null;
        try{
            f = new FileOutputStream("Raihan Digo Saputra.xml");//pake nama anggota
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
        FileInputStream f =null;
        FileInputStream masuk =null;
        
        try {
            f = new FileInputStream("Anggota.xml");
//            masuk = new FileInputStream("Anggota.xml");//nama anggota
            int isi;
//            int isi1;
            char c;
//            char c1;
            String xml = "";
//            String xml1 = "";
            
            while((isi = f.read() )!=-1){
                c = (char) isi;
                xml = xml + c;
            }
//            while((isi1 = masuk.read() )!=-1){
//                c1 = (char) isi1;
//                xml1 = xml1 + c1;
//            }
            
           AnggotaList dataWrap = new AnggotaList();
           dataWrap = (AnggotaList) xstream.fromXML(xml);
           
//           HasilList dataHWrap = new HasilList();
//           dataHWrap = (HasilList) xstream.fromXML(xml1);
           
           data.addAll(dataWrap.getListData());
//           dataH.addAll(dataHWrap.getListData());
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
            }if(masuk!=null){
                try{
                    masuk.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        cbBulan.getItems().addAll(ubah);
        cbBulan.getItems().addAll("Januari", "Februari", "Maret", "April", "Mei", "Juni","Juli", "Agustus", "September"
                ,"Oktober","November","Desember");
        bcHasil.getData().addAll(chart);
        loadData();
        
    }    

    

    
    
}
