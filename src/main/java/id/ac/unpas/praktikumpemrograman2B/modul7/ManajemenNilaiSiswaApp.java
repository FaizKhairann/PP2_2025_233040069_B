/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author N1NRC
 */
public class ManajemenNilaiSiswaApp extends JFrame {

    // Variabel Global
    private JTextField txtNama;
    private JTextField txtNilai;
    private JComboBox<String> cmbMatkul;
    private JTable tableData;
    private DefaultTableModel tableModel;
    private JTabbedPane tabbedPane;

    //method untuk membuat desain tab input
    private JPanel createInputPanel() {

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Komponen Nama
        panel.add(new JLabel("Nama Siswa :"));
        txtNama = new JTextField();
        panel.add(txtNama);

        // Komponen Mata Pelajaran
        panel.add(new JLabel("Mata Pelajaran :"));
        String[] matkul = {
                "Matematika Dasar",
                "Bahasa Indonesia",
                "Algoritma dan Pemrograman",
                "Praktikum Pemrograman II"
        };
        cmbMatkul = new JComboBox<>(matkul);
        panel.add(cmbMatkul);

        // Komponen Nilai
        panel.add(new JLabel("Nilai (0–100) :"));
        txtNilai = new JTextField();
        panel.add(txtNilai);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan Data");
        panel.add(new JLabel("")); // Placeholder kosong agar tombol di kanan
        panel.add(btnSimpan);

        // Event Handling Tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prosesSimpan();
            }
        });

        return panel;
    }

    //method untuk membuat desain Tab Tabel
    private JPanel createTablePanel() {

        JPanel panel = new JPanel(new BorderLayout());

        // SetUp Model Tabel (Kolom)
        String[] kolom = {"Nama Siswa", "Mata Pelajaran", "Nilai", "Grade"};
        tableModel = new DefaultTableModel(kolom, 0);

        tableData = new JTable(tableModel);

        // membungkus tabel dengan ScrollPanel (agar bisa discroll jika data banyak)
        JScrollPane scrollPane = new JScrollPane(tableData);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

   //logika validasi dan penyimpanan data
    private void prosesSimpan() {

        // 1. ambil data dari input
        String nama = txtNama.getText();
        String matkul = (String) cmbMatkul.getSelectedItem();
        String strNilai = txtNilai.getText();
        

        // 2. validasi input
        
        // validasi input 1: cek apakah nama kosong
        if (nama.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama tidak boleh kosong.",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // validasi 2: cek apakah nilai berupa angka dan dalam range valid
        int nilai;
        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error Validasi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berada pada rentang 0 - 100.",
                    "Error Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 3. logika bisnis (menentukan grade)
        String grade;
        if (nilai >= 80) grade = "A";
        else if (nilai >= 70) grade = "AB";
        else if (nilai >= 60) grade = "B";
        else if (nilai >= 50) grade = "BC";
        else if (nilai >= 40) grade = "C";
        else if (nilai >= 30) grade = "D";
        else grade = "E";

        // 4. masukan ke tabel (update Model)
        Object[] data = {nama, matkul, nilai, grade};
        tableModel.addRow(data);


        // 5. reset form dan pindah tab
        txtNama.setText("");
        txtNilai.setText("");
        cmbMatkul.setSelectedIndex(0);

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        tabbedPane.setSelectedIndex(1);
    }

  
    public ManajemenNilaiSiswaApp() {
        // 1. konfigurasi frame utama
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 2. inisialisasi tabbed pane
        tabbedPane = new JTabbedPane();
        //3. membuat panel untuk tab 1 (form input)
        tabbedPane.addTab("Input Data", createInputPanel());
        // 4. membuat panel untuk tab 2 (tabel data)
        tabbedPane.addTab("Daftar Nilai", createTablePanel());
        // menambahkan tabbedPane ke Frame
        add(tabbedPane);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenNilaiSiswaApp().setVisible(true);
        });
    }
}
