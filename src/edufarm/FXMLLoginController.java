/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.naming.spi.DirStateFactory;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLLoginController implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    AnggotaList list;
    @FXML
    private TextField tfUsername;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private AnchorPane apLogin;
    
    @FXML
    private Button btMasuk;
    
    String notif;
    
    ObservableList<Anggota> data = FXCollections.observableArrayList();
    ObservableList<Anggota> dataAdmin = FXCollections.observableArrayList();
//    Anggota[] anggota;
    
    
    @FXML
    private void handleButtonMasuk(ActionEvent event) throws IOException{        
        username = tfUsername.getText();
        String pass = password.getText();
        int i = 0;
        int masuk = 0;
        
        for(Anggota dt : data ){
            if(data.get(i).getUsername().equals(username) && data.get(i).getPassword().equals(pass)){
                System.out.println("Masuk sebagai anggota");
                
                FXMLLoader uiMenuUtama = new FXMLLoader(getClass().getResource("FXMLMenuUtama.fxml"));
                Parent root = (Parent) uiMenuUtama.load();            
                
                FXMLMenuUtamaController menu = uiMenuUtama.getController();
                menu.setNama(username);        
                
                btMasuk.getScene().setRoot(root); 
                masuk = 1;
            }
            System.out.println(data.get(i).getUsername() +" "+ data.get(i).getPassword());
            i++;
        }      
        i=0;
        for(Anggota dt : dataAdmin ){
            if(dataAdmin.get(i).getUsername().equals(username) && dataAdmin.get(i).getPassword().equals(pass)){
                System.out.println("Masuk sebagai Admin");
                       
                Parent sistemAdmin = FXMLLoader.load(getClass().getResource("FXMLSistemAdmin.fxml"));
                apLogin.getChildren().setAll(sistemAdmin);
                masuk = 1;                
            }
            System.out.println(dataAdmin.get(i).getUsername() +" "+ dataAdmin.get(i).getPassword());
            i++;
        }
        System.out.println(masuk);
        if(masuk == 0){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("GAGAL!!!");
                alert.setHeaderText("Username atau Password salah");
                alert.setContentText("Untuk masuk silahkan masukan username dan password dengan benar");
                alert.showAndWait();
        }
    }
    
    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException {
        AnchorPane awal = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        apLogin.getChildren().setAll(awal);
    }
    
    @FXML
    private void handleButtonDaftar(ActionEvent event) throws IOException {
        AnchorPane daftar = FXMLLoader.load(getClass().getResource("FXMLDaftar.fxml"));
        apLogin.getChildren().setAll(daftar);

    }
    
    private void loadData() {
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream f = null;
        FileInputStream fAdmin = null;
        
        try {
            f = new FileInputStream("Anggota.xml");
            fAdmin = new FileInputStream("Admin.xml");
            
            int isi;
            char c;
            String xml = "";
            
            while((isi = f.read() )!=-1){
                c = (char) isi;
                xml = xml + c;
            }
            
            int isi1;
            char c1;
            String xml1 = "";
            
            while((isi1 = fAdmin.read() )!=-1){
                c1 = (char) isi1;
                xml1 = xml1 + c1;
            }
            
           AnggotaList dataWrap = new AnggotaList();
           dataWrap = (AnggotaList) xstream.fromXML(xml);
           
           AnggotaList dataWrap1 = new AnggotaList();
           dataWrap1 = (AnggotaList) xstream.fromXML(xml1);
           
           data.clear();
           data.addAll(dataWrap.getListData());
           
           dataAdmin.clear();
           dataAdmin.addAll(dataWrap1.getListData());
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
            }else if(fAdmin!=null){
                try{
                    fAdmin.close();
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
//        anggota = (Anggota[]) data.toArray();
    }  
}

    
  

    