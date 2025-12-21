/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.Tugasmodul10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author N1NRC
 */
public class KoneksiDB {
     private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        try {
            //url database Ganti 'root' dan '' sesuai user/pass database lokal anda 
            String url = "jdbc:mysql://localhost:3306/kampus_db";
            String user = "root";
            String pass = "";
            
            //registrasi driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            //buat koneksi 
            mysqlconfig = DriverManager.getConnection(url, user, pass);
            
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal:" + e.getMessage());
        }
        return mysqlconfig;
    }
}
