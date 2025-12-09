/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author N1NRC
 */
public class latihan1 {
    public static void main(String[]args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        
        JTextField layar = new JTextField();
        frame.add(layar, BorderLayout.NORTH);
        
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4,4,5,5));
        
        panelTombol.add(new JButton("7"));
        panelTombol.add(new JButton("8"));
        panelTombol.add(new JButton("9"));
        
        panelTombol.add(new JButton("/"));
        panelTombol.add(new JButton("4"));
        panelTombol.add(new JButton("5"));
        
        panelTombol.add(new JButton("6"));
        panelTombol.add(new JButton("*"));
        panelTombol.add(new JButton("1"));
        
        panelTombol.add(new JButton("2"));
        panelTombol.add(new JButton("3"));
        panelTombol.add(new JButton("-"));
        
        panelTombol.add(new JButton("0"));
        panelTombol.add(new JButton("."));
        panelTombol.add(new JButton("="));
        panelTombol.add(new JButton("+"));
        
       frame.add(panelTombol,BorderLayout.CENTER);
       
       frame.setVisible(true);
    }
}
