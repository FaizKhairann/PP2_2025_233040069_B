/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.Tugasmodul10.model;
import java.sql.*;
import javax.swing.JOptionPane;
import id.ac.unpas.pp2_B_233040069.Tugasmodul10.KoneksiDB;

/**
 *
 * @author N1NRC
 */
public class MahasiswaModel {
    // Create
    public void simpan(String nama, String nim, String jurusan) {
        try {
            String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUES (?, ?, ?)";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, nim);
            pst.setString(3, jurusan);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
        }
    }

    // Update
    public void ubah(String nama, String nim, String jurusan) {
        try {
            String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, jurusan);
            pst.setString(3, nim);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Edit: " + e.getMessage());
        }
    }

    // Delete
    public void hapus(String nim) {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
        }
    }
    
   
    public ResultSet getData() {
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            return stm.executeQuery("SELECT * FROM mahasiswa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Load Data: " + e.getMessage());
            return null;
        }
    }
    
    // cari data
    public ResultSet cariData(String keyword) {
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + keyword + "%");
            return pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Cari Data: " + e.getMessage());
            return null;
        }
    }
    
    // Cek NIM
    public boolean nimSudahAda(String nim) {
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            ResultSet res = pst.executeQuery();
            return res.next();
        } catch (Exception e) {
            return false;
        }
    }
}
