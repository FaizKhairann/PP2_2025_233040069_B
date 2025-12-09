/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul5;
import java.awt.BorderLayout;
import javax.swing.*;
/**
 *
 * @author N1NRC
 */
public class latihan4 {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("Contoh borderLayout");
            frame.setSize(400,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
           /*1. Atur Layout Manager ke BorderLayout
                Sebenarnya ini tidak perlu
                Karena BorderLayout adalah Layout Mangager deafult*/
            
            frame.setLayout(new BorderLayout());
            
            //2. Buat komponen
            JLabel label = new JLabel("Label ada di atas (NORTH)");
            JButton button = new JButton("Tombol ada di  bawah (SOUTH)");
            
            //3. Tambahkan aksi (ActionListener) ke tombol
            button.addActionListener(e -> {
                label.setText("Tombol di SOUTH Diklik!");
            });
            
            //4. Tambahkan komponen ke frame DENGAN posisi
            frame.add(label, BorderLayout.NORTH);
            frame.add(button, BorderLayout.SOUTH);
            
            //Kita bisa tambahkan komponen lain
            frame.add(new JButton("WEST"), BorderLayout.WEST);
            frame.add(new JButton("EAST"), BorderLayout.EAST);
            frame.add(new JButton("SOUTH"), BorderLayout.CENTER);
            
            frame.setVisible(true);
            }
        });
    }
}


