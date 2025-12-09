/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import javax.swing.*;
import java.awt.GridLayout;
/**
 *
 * @author N1NRC
 */
// GRID LAYOUT
public class gridLayout {
    public static void main(String[] args) {
        //BUAT FRAME
        JFrame frame = new JFrame("Contoh GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        //ATUR LAYOUT FRAME MENJADI GRIDLAYOUT 3 BARIS, 2 KOLOM
        // KITA JUGA BISA MENAMBAHKAN JARAK (GAP) ANTAR SEL
        frame.setLayout(new GridLayout(3,2,5,5));
        
        //TAMBAHKAN 6 KOMPONEN (3*2 =6)
        frame.add(new JLabel("Label 1: "));
        frame.add(new JTextField());
        frame.add(new JLabel("Label 2 : "));
        frame.add(new JPasswordField());
        frame.add(new JButton("Login"));
        frame.add(new JButton("Batal"));
        
        //TAMPILKAN FRAME
        frame.setVisible(true);
    }
}
