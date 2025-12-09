/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemrograman2B.modul6;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author N1NRC
 */
public class latihan2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Konvers Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3,2,5,5));
        
        JLabel lC = new JLabel("Celcius");
        JTextField tC = new JTextField();
        
        JButton bK = new JButton("Konversi");
        JLabel lF = new JLabel("Fahrenheit");
        JLabel hasilF = new JLabel("");
        
        frame.add(lC);
        frame.add(tC);
        frame.add(lF);
        frame.add(hasilF);
        frame.add(bK);
         
        bK.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                   String input = tC.getText();
                   double c = Double.parseDouble(input);
                   double f = (c * 9/5) + 32;
                   
                   hasilF.setText(String.format("%.2f°F", f));
               } catch(NumberFormatException ex) {
                   hasilF.setText("Masukan Angka!!");
               }
           }
        });
        
        frame.setVisible(true);
    }
}
