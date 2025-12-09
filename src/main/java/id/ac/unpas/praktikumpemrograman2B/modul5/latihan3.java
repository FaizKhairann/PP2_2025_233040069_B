/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul5;
import java.awt.FlowLayout;
import javax.swing.*;
/**
 *
 * @author N1NRC
 */
public class latihan3 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                JFrame frame = new JFrame("Label dan Tombol");
                frame.setSize(400,300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                //1. Atur Layout Manager
                // FlowLayout akan menyusun komponen dari kiri ke kanan.
                frame.setLayout(new FlowLayout());
                
                //2. Buat komponen GUI
                JLabel label = new JLabel("Teks awal");
                JButton button = new JButton("Klik Saya!");
                
                //3. Tambahkan Aksi (ActionListener) ke tombol
                //penambahan ini menggunakan lambda untuk mempersingkat 
                // penggunaan anonymus inner class 
                button.addActionListener(e -> {
                    //aksi ini akan mengubah teks pada label
                    label.setText("Tombol berhasil diklik!");
                });
                
                /*4. Tambahkan komponen ke frame
                karena kita menggunakan FlowLayout,
                keduanya akan tampil berdampingan */
                frame.add(label);
                frame.add(button);
    
                frame.setVisible(true);
                
            }
        });
    }
}
