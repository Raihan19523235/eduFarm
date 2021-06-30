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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLTampilDetailController implements Initializable {
    //Rania Putri Savira 19523036
    //Jasmine Erina Firdaus 19523095
    //Khoiri Rochmanila 19523142
    //Raihan Digo Saputra 19523235
    private String username;
    
    @FXML
    private Label lb;
    
    @FXML
    private TableView<Hasil> tv;
    
    @FXML
    private TableColumn<Hasil, String> tcNama;
    
    @FXML
    private TableColumn<Hasil, String> tcHasil;
    
    @FXML
    private TableColumn<Hasil, String> tcTanggal;
    
    private ObservableList <Hasil> dataH = FXCollections.observableArrayList();   
    TableView.TableViewSelectionModel pilih;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        tcHasil.setCellValueFactory(new PropertyValueFactory<>("Hasil"));
        tcTanggal.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
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
    
    public String getNama() {
        return username;
        
    }

    public void setNama(String username) {
        this.username = username;
        loadData();
        tv.setItems(dataH);
        lb.setText(username);
    }
}
