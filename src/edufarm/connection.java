/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edufarm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

//public class connection {
//    Connection conn = null;
//    public static Connection koneksi(){
//        String driver = "com.mysql.jdbc.Driver";
//        String host = "jdbc:mysql://localhost/anggota";
//        String user = "root";
//        String pass = "";
//        try{
//            Class.forName(driver);
//            Connection conn = DriverManager.getConnection(host,user,pass);
//            Alert peringatan = new Alert(Alert.AlertType.INFORMATION);
//            peringatan.setTitle("Peringatan SQL Connection");
//            peringatan.setHeaderText(null);
//            peringatan.setContentText("berhasil mengkoneksikan ke host" + host);
//            peringatan.showAndWait();
//            return conn;
//        } catch (ClassNotFoundException | SQLException e) {
//            Alert peringatan = new Alert(Alert.AlertType.INFORMATION);
//            peringatan.setTitle("Peringatan SQL Connection");
//            peringatan.setHeaderText(null);
//            peringatan.setContentText("berhasil mengkoneksikan ke host" + host);
//            peringatan.showAndWait();
//        }
//        return null;
//    }
//}
