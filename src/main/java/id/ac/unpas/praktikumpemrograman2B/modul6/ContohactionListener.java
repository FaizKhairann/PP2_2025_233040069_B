/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author N1NRC
 */
public class ContohactionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh ActionListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());
        
        //BUAT KOMPONEN (EVENT SOURCE DAN KOMPONEN LAIN)
        JLabel label = new JLabel("Halo, klik tombol di bawah!");
        JButton button = new JButton("Klik saya!");
        
        // BUAT EVENT LISTENER 
        //KITA MENGGUNAKAN "ANNONYMOUS INNER CLASS" DI SINI
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //LOGIKA YANG DI EKSEKUSI SAAT EVENT TERJADI
                label.setText("Tombol telah diklik!");
            }
        };
        
        //DAFTARKAN LISTENER KE SOURCE
        button.addActionListener(listener);
        //TAMBAHKAN KOMPONEN KE FRAME
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}
