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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    
    AnggotaList list;
    @FXML
    private TextField tfUsername;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private AnchorPane apLogin;
    String notif;
//    PreparedStatement pst = null;
//    Connection conn = connection.koneksi();
//    ResultSet rs = null;
    ObservableList<Anggota> data = FXCollections.observableArrayList();
    Anggota[] anggota;
    
    
    @FXML
    private void handleButtonMasuk(ActionEvent event) throws IOException{        
        String username = tfUsername.getText();
        String pass = password.getText();
        int i = 0;
        while(data.get(i) != null){
            if(data.get(i).getUsername().equals(username) && data.get(i).getPassword().equals(pass)){
                AnchorPane menuUtama = FXMLLoader.load(getClass().getResource("FXMLMenuUtama.fxml"));
                apLogin.getChildren().setAll(menuUtama);
            }
            System.out.println(data.get(i).getUsername() +" "+ data.get(i).getPassword());
            i++;
        }
            
        
        
    }
    
    @FXML
    private void handleButtonDaftar(ActionEvent event) throws IOException {
        AnchorPane daftar = FXMLLoader.load(getClass().getResource("FXMLDaftar.fxml"));
        apLogin.getChildren().setAll(daftar);

    }
    
    private void loadData() {
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
//           anggota = (Anggota[]) xstream.fromXML(xml);
           
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
        loadData();
//        anggota = (Anggota[]) data.toArray();
    }  
}

    
  

    