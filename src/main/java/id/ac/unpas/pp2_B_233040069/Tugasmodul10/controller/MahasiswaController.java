/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.Tugasmodul10.controller;

import id.ac.unpas.pp2_B_233040069.Tugasmodul10.model.MahasiswaModel;
import id.ac.unpas.pp2_B_233040069.Tugasmodul10.view.MahasiswaView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author N1NRC
 */
public class MahasiswaController { 
    
    private MahasiswaModel model;
    private MahasiswaView view;
    
    public MahasiswaController(MahasiswaModel model, MahasiswaView view) {
        this.model = model;
        this.view = view;
        
        view.setVisible(true);
        loadData();
        
        // Event Listeners
        view.btnSimpan.addActionListener(e -> simpanData());
        view.btnEdit.addActionListener(e -> ubahData());
        view.btnHapus.addActionListener(e -> hapusData());
        view.btnClear.addActionListener(e -> kosongkanForm());
        
        // Listener Latihan 3 (Cari)
        view.btnCari.addActionListener(e -> cariData());
        
        view.tableMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = view.tableMahasiswa.getSelectedRow();
                view.txtNama.setText(view.model.getValueAt(row, 1).toString());
                view.txtNIM.setText(view.model.getValueAt(row, 2).toString());
                view.txtJurusan.setText(view.model.getValueAt(row, 3).toString());
            }
        });
    }
    
    private void loadData() {
        tampilkanData(model.getData());
    }
    
    
    private void cariData() {
        String keyword = view.txtCari.getText();
        tampilkanData(model.cariData(keyword));
    }
    
    private void tampilkanData(ResultSet res) {
        view.model.setRowCount(0);
        try {
            int no = 1;
            while (res != null && res.next()) {
                view.model.addRow(new Object[]{
                    no++,
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("jurusan")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void simpanData() {
        String nama = view.txtNama.getText();
        String nim = view.txtNIM.getText();
        String jurusan = view.txtJurusan.getText();
        
        if (nama.isEmpty() || nim.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
            return;
        }
        
        if (model.nimSudahAda(nim)) {
             JOptionPane.showMessageDialog(view, "NIM Sudah Ada! Gunakan NIM lain.");
             return;
        }
        
        model.simpan(nama, nim, jurusan);
        loadData();
        kosongkanForm();
    }
    
    private void ubahData() {
        String nama = view.txtNama.getText();
        String nim = view.txtNIM.getText();
        String jurusan = view.txtJurusan.getText();
        
        model.ubah(nama, nim, jurusan);
        loadData();
        kosongkanForm();
    }
    
    private void hapusData() {
        String nim = view.txtNIM.getText();
        model.hapus(nim);
        loadData();
        kosongkanForm();
    }
    
    private void kosongkanForm() {
        view.txtNama.setText("");
        view.txtNIM.setText("");
        view.txtJurusan.setText("");
        view.txtCari.setText("");
    }
}