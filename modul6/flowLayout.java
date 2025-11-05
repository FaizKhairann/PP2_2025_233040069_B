/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import javax.swing.*;
import java.awt.BorderLayout;

/**
 *
 * @author N1NRC
 */
public class flowLayout {
    public static void main(String[] args) {
        //BUAT FRAME
        JFrame frame = new JFrame("Contoh BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        //JFrame sudah menggunakan BorderLayout secara default
        
        //Buat dan tambahkan komponen ke 5 wilayah
        frame.add(new JButton("NORTH"), BorderLayout.NORTH);
        frame.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        frame.add(new JButton("EAST"), BorderLayout.EAST);
        frame.add(new JButton("WEST"), BorderLayout.WEST);
        frame.add(new JButton("CENTER"), BorderLayout.CENTER);   
        
        //Tampilkan frame
        frame.setVisible(true);
    }
}
