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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLDaftarController implements Initializable {
    int id =0;
    
    @FXML
    private AnchorPane apDaftar;

    @FXML
    private Label lb;

    @FXML
    private Label lb1;

    @FXML
    private TextField tfNaDep;
    
    @FXML
    private TextField tfNaBel;
    
    @FXML
    private TextField tfNoTlp;
    
    @FXML
    private TextField tfNaPeng;
    
    @FXML
    private PasswordField pass;
    
    @FXML
    private DatePicker dplahir;
    
    @FXML
    private RadioButton rbPria;
    
    @FXML
    private RadioButton rbWanita;
    
    ObservableList<Anggota> data = FXCollections.observableArrayList();
    
    @FXML
    private void handleButtonMasuk(ActionEvent event) throws IOException {
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        apDaftar.getChildren().setAll(login);
    }
    
    @FXML
    private void handleButtonDaftar(ActionEvent event) throws IOException {
        String namaDepan = tfNaDep.getText();
        String namaBelakang = tfNaBel.getText();
        String namaLengkap = namaDepan + " " + namaBelakang;
        String jekel = null;
        if(rbPria.isSelected()){
            jekel = "Pria";
        }else if(rbWanita.isSelected()){
            jekel = "Wanita";
        }
        String noHp = tfNoTlp.getText();
        String tanggal = dplahir.getValue().toString();
        String username = tfNaPeng.getText();
        String password = pass.getText();
        id++;
        
        data.add(new Anggota(id,namaLengkap,jekel,noHp,tanggal,username,password));
        saveData(data);
        
        AnchorPane login = FXMLLoader.load(getClass().getResource("FXMLMenuUtama.fxml"));
        apDaftar.getChildren().setAll(login);
    }
    
    public void saveData(ObservableList<Anggota> data){
        XStream xstream = new XStream(new StaxDriver());
        AnggotaList list = new AnggotaList();
        list.setListData(data);
        String xml = xstream.toXML(list);
        
        FileOutputStream f = null;
        try{
            f = new FileOutputStream("Anggota.xml");
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
    
    public void loadData(){
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f =null;
        
        try {
            f = new FileInputStream("Anggota.xml");
            
            int isi;
            char c;
            String xml = "";
            
            while((isi = f.read() )!=-1){
                c = (char) isi;
                xml = xml + c;
            }
            
           AnggotaList dataWrap = new AnggotaList();
           dataWrap = (AnggotaList) xstream.fromXML(xml);
           
           data.clear();
           data.addAll(dataWrap.getListData());
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
//        data = new AnggotaList();
        loadData();
    }    
    
}
