/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import java.awt.Color;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author N1NRC
 */
public class ContohMouseListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Contoh MouseListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        
        //BUAT KOMPONEN (EVENT SOURCE)
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(200,200));
        
        //BUAT EVENT LISTENER (MENGGUNAKAN MouseAdapter)
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.CYAN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse diklik di: x=" + e.getX() + ", y=" + e.getY());
            }
        };
        
        panel.addMouseListener(adapter);
        frame.add(panel);
        frame.setVisible(true);
        
        
    }
}
