/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul10;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author N1NRC
 */
public class MahasiswaApp extends JFrame{
    //komponen GUI
    JTextField txtNama, txtNIM, txtJurusan;
    JButton btnSimpan, btnEdit, btnHapus, btnClear;
    JTable tableMahasiswa;
    DefaultTableModel model;
    
    //latihan 3
    JTextField txtCari;
    JButton btnCari;
    
    
    public MahasiswaApp() {
        //setup frame
        setTitle("Aplikasi CRUD Mahasiswa JDBC");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //1. panel form (input data)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelForm.add(new JLabel("Nama :"));
        txtNama = new JTextField();
        panelForm.add(txtNama);
        
        panelForm.add(new JLabel("NIM : "));
        txtNIM = new JTextField();
        panelForm.add(txtNIM);
        
        panelForm.add(new JLabel("Jurusan : "));
        txtJurusan = new JTextField();
        panelForm.add(txtJurusan);
        
        //panel tombol
        JPanel panelTombol = new JPanel(new FlowLayout());
        btnSimpan = new JButton("Simpan");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnClear =  new JButton("Clear");
        
        panelTombol.add(btnSimpan);
        panelTombol.add(btnEdit);
        panelTombol.add(btnHapus);
        panelTombol.add(btnClear);
        
        //latihan 3
        txtCari = new JTextField(10);
        btnCari = new JButton("Cari");
        panelTombol.add(txtCari);
        panelTombol.add(btnCari);

        //gabungkan panel form dan tombol di bagian atas (NORTH)
        JPanel panelAtas = new JPanel(new BorderLayout());
        panelAtas.add(panelForm, BorderLayout.CENTER);
        panelAtas.add(panelTombol, BorderLayout.SOUTH);
        add(panelAtas, BorderLayout.NORTH);
        
        //2. Tabe data (menampilakan data)
        model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        
        tableMahasiswa = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tableMahasiswa);
        add(scrollPane, BorderLayout.CENTER);
        
        // -- event listener -- 
        
        // listener klik tabel (untuk mengambil data saat baris diklik)
        tableMahasiswa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMahasiswa.getSelectedRow();
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNIM.setText(model.getValueAt(row, 2).toString());
                txtJurusan.setText(model.getValueAt(row, 3).toString());

            }
        });
        
        //aksi tombol simpan (CREATE)
        btnSimpan.addActionListener(e -> tambahData());
        
        //aksi Toombol Edit (UPDATE)
        btnEdit.addActionListener(e -> ubahData());
        
        //aksi Tombol Hapus (DELETE)
        btnHapus.addActionListener(e -> hapusData());
        
        //aksi tombol Clear
        btnClear.addActionListener(e -> kosongkanForm());
        
        //latihan 3 aksi tombol cari
        btnCari.addActionListener(e-> cariData());
        
        //load data saat aplikasi pertama kali jalan
        loadData();
    }
    
    //latihan 4
    private boolean nimSudahAda(String nim) {
        try {
            String sql = "SELECT * FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nim);
            ResultSet res = pst.executeQuery();
            
            return res.next();
        }catch(Exception e) {
           System.err.println("Cek NIM gagal:" + e.getMessage());
           return false;
        }
    }
    
    private void loadData() {
        model.setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM mahasiswa");
            
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan"),
                });
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Load Data:" + e.getMessage());
        }
    }
    
    //2. create 
    private void tambahData() {
        //Latihan 2
        if (txtNama.getText().isEmpty() || txtNIM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!");
            return; 
        }
        
        //latihan 4
        if(nimSudahAda(txtNIM.getText())) {
            JOptionPane.showMessageDialog(this, "NIM" + txtNIM.getText() + "NIM sudah terdaftar!");
            return;
        }
        
        try {
            String sql = "INSERT INTO mahasiswa (nama, nim, jurusan) VALUE (?, ?, ?)";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtNIM.getText());
            pst.setString(3, txtJurusan.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data beehasil disimpan");
            loadData();
            kosongkanForm();

        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal disimpan:" + e.getMessage());
        }
    }
    
    
    //3. ubah data
    private void ubahData() {
        try {
            String sql = "UPDATE mahasiswa SET nama = ?, jurusan = ? WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtJurusan.getText());
            pst.setString(3, txtNIM.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
            loadData();
            kosongkanForm();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gagal edit" + e.getMessage());
        }
    }
    
    //4. delete
    private void hapusData() {
        try {
            String sql = "DELETE FROM mahasiswa WHERE nim = ?";
            Connection conn = KoneksiDB.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, txtNIM.getText());
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            loadData();
            kosongkanForm();
    }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal Hapus: " + e.getMessage());
    }
        
  }
    
   private void cariData() {
       model.setRowCount(0);
       
       try {
           String sql = "SELECT * FROM mahasiswa WHERE nama LIKE ?";
           Connection conn = KoneksiDB.configDB();
           PreparedStatement pst = conn.prepareStatement(sql);
           
           pst.setString(1, "%" + txtCari.getText() + "%");
           
           ResultSet res = pst.executeQuery();
           
           int no = 1;
           while(res.next()) {
               model.addRow(new Object[]{ 
                   no++,
                   res.getString("nama"),
                   res.getString("nim"),
                   res.getString("jurusan"),
               });
           }
       }catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Gagal cari data:" + e.getMessage());
       }
   }
    private void kosongkanForm() {
        txtNama.setText(null);
        txtNIM.setText(null);
        txtJurusan.setText(null);
        txtCari.setText(null);
    }
    
    public static void main (String[] args) {
        SwingUtilities.invokeLater(() -> new MahasiswaApp().setVisible(true));
    }
}
