/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul5;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author N1NRC
 */
public class latihan1 {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 //1. Buat objek Frame
            JFrame frame = new JFrame("Jendela Pertamaku");
            
            //2. Atur ukuran jendela (lebar 400, tinggi 300)
            frame.setSize(400,300);
            
            //3.Atur aksi saat tombol close (X) ditekan
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            //4. Buat jendela terlihat
            frame.setVisible(true);
            }
         
            
        }
                
        );
    }
}
