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
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author PREDATOR
 */
public class FXMLSistemAdminController implements Initializable {
    AnggotaList list;
    int id = 0;
    String up,uNama,uNoHp,uTanggal,uJekel,uUsername,uPassword,hapus;
    String namaLengkap,nomorHP,tanggal,username,jekel,password;
    private boolean selected = false;

//    Anggota[] ang;
//    List<String> namaAL = new ArrayList();
//    List<String> noHpAL = new ArrayList();
//    List<String> usernameAL = new ArrayList();
//    List<Integer> idAL = new ArrayList();

    @FXML
    private Label label2;
    
    @FXML
    private Button bGanti;
        
    @FXML
    private TextField tfNama;
    
    @FXML
    private TextField tfHp;
    
    @FXML
    private DatePicker dpLahir;
    
    @FXML
    private TextField tfUserId;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private TextField tfUpdate;
    
    @FXML
    private TextField tfUserUp;
    
    @FXML
    private TextField tfDelete;
    
    @FXML
    private TextField tfUpdatenama;
    
    @FXML
    private TextField tfUpdateNoHp;
    
    @FXML
    private PasswordField pfUpdatePassword;
    
    @FXML
    private DatePicker dpUpdateTL;
    
    @FXML
    private ChoiceBox cbUpdateJekel;
    
    @FXML
    private TableColumn<Anggota, Integer> tcNo;
    
    @FXML
    private TableColumn<Anggota, String> tcNama;
    
    @FXML
    private TableColumn<Anggota, String> tcHP;
    
    @FXML
    private TableColumn<Anggota, String> tcTLahir;
    
    @FXML
    private TableColumn<Anggota, String> tcJekel;
    
    @FXML
    private TableColumn<Anggota, String> tcUserN;
    
    @FXML
    private TableColumn<Anggota, String> tcPassword;
    
    @FXML
    private TableView<Anggota> tv;
    
    @FXML
    private RadioButton rbJekelLaki;
    
    @FXML
    private RadioButton rbJekelPerempuan;
    
    @FXML
    private TextArea taIsi;
    
    @FXML
    private CheckBox cbKet1;
    
    @FXML
    private CheckBox cbKet2;
    
    Anggota anggota;
    private ObservableList <Anggota> data = FXCollections.observableArrayList();
    TableViewSelectionModel pilih;
    
    @FXML
    private void handleButtonTambah(ActionEvent event) {
        namaLengkap = tfNama.getText();
        jekel = null;
        if(rbJekelLaki.isSelected()){
            jekel = "Pria";
        }else if(rbJekelPerempuan.isSelected()){
            jekel = "Wanita";
        }
        nomorHP = tfHp.getText();
        tanggal = dpLahir.getValue().toString();
        username = tfUserId.getText();
        password = pfPassword.getText();
        id++;

        data.add(new Anggota(id,namaLengkap,jekel,nomorHP,tanggal,username,password));
        list.setData(id, namaLengkap, jekel, nomorHP, tanggal, username, password);
        saveData(data);
        if(rbJekelLaki.isSelected()){
            selected = true;
        }
        clearField();
        
        
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
    
    @FXML
    private void handleButtonGanti(ActionEvent event) { 
        String temp;
        int selectedIndex = tv.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) { //mengatasi handling error
            uNama = tfUpdatenama.getText();
            uNoHp = tfUpdateNoHp.getText();
            uTanggal = dpUpdateTL.getValue().toString();
            uUsername = tfUpdate.getText();

            if(cbUpdateJekel.getValue().equals("Pria")){
                uJekel = "Pria";
            }else if(cbUpdateJekel.getValue().equals("Wanita")){
                uJekel = "Wanita";
            }
            uPassword = pfUpdatePassword.getText();
            data.set(selectedIndex, new Anggota(selectedIndex,uNama,uJekel,uNoHp,uTanggal,uUsername,uPassword));
            tv.getItems().set(selectedIndex, new Anggota(selectedIndex,uNama,uJekel,uNoHp,uTanggal,uUsername,uPassword));
            bGanti.setDisable(true);
        }
        
        saveData(data);
        System.out.println("You clicked me!");
        clearField();
    }
    @FXML
    private void handleButtonAmbil(ActionEvent event) { 
        String temp;
        int selectedIndex = tv.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) { //mengatasi handling error
            temp = tv.getItems().get(selectedIndex).getNama();tfUpdatenama.setText(temp);
            temp = tv.getItems().get(selectedIndex).getJekel();cbUpdateJekel.setValue(temp);
            temp = tv.getItems().get(selectedIndex).getNohp();tfUpdateNoHp.setText(temp);
            temp = tv.getItems().get(selectedIndex).getTanggal();
            LocalDate dateTime = LocalDate.parse(temp);dpUpdateTL.setValue(dateTime);
            temp = tv.getItems().get(selectedIndex).getUsername();tfUpdate.setText(temp);
            temp = tv.getItems().get(selectedIndex).getPassword();pfUpdatePassword.setText(temp);

        }
        bGanti.setDisable(false);
        System.out.println("You clicked me!");
        
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
       
    @FXML
    private void handleButtonHapus(ActionEvent event) {
        int selectedIndex = tv.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) { //mengatasi handling error
            tv.getItems().remove(selectedIndex);
            saveData(data);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        
        cbUpdateJekel.getItems().addAll("Pria","Wanita");
        
        tcNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcJekel.setCellValueFactory(new PropertyValueFactory<>("Jekel"));
        tcHP.setCellValueFactory(new PropertyValueFactory<>("Nohp"));
        tcTLahir.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcUserN.setCellValueFactory(new PropertyValueFactory<>("Username"));
//        tcPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        
        list = new AnggotaList();
//        ang = new Anggota[99];
//        data.setDummy();
        pilih = tv.getSelectionModel();
        pilih.setSelectionMode(SelectionMode.SINGLE);
        pilih.select(data);
        
        tv.setItems(data);
    }    

    private void clearField() {
        //untuk tambah
        tfNama.clear();
        tfHp.clear();
        dpLahir.setValue(null);
        tfUserId.clear();
        rbJekelLaki.setSelected(false);
        rbJekelPerempuan.setSelected(false);
        pfPassword.clear();
        
        //untuk ganti
        tfUpdatenama.clear();
        tfUpdateNoHp.clear();
        dpUpdateTL.setValue(null);
        tfUpdate.clear();
        cbUpdateJekel.setValue(null);
        pfUpdatePassword.clear();
    }
        
}
