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
public class tugas {
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
            JLabel label = new JLabel("Label ada di atas (NORTH)", SwingConstants.CENTER);
            JButton button = new JButton("(SOUTH)");
            JButton button2 = new JButton("(WEST)");
            JButton button3 = new JButton("(CENTER)");
            JButton button4 = new JButton("(EAST)");



            //3. Tambahkan aksi (ActionListener) ke tombol
            //SOUTH
            button.addActionListener(e -> {
                label.setText("Tombol di SOUTH Diklik!");
            });
            //WEST
            button2.addActionListener(e -> {
                label.setText("Tombol di WEST Diklik!");
            });
            //CENTER
            button3.addActionListener(e -> {
                label.setText("Tombol di Center Diklik!");
            });
            //EAST
            button4.addActionListener(e -> {
                label.setText("Tombol di EAST Diklik!");
            });
            
            //4. Tambahkan komponen ke frame DENGAN posisi
            frame.add(label, BorderLayout.NORTH);
            frame.add(button, BorderLayout.SOUTH);
            frame.add(button2, BorderLayout.WEST);
            frame.add(button3, BorderLayout.CENTER);
            frame.add(button4, BorderLayout.EAST);
           
            frame.setVisible(true);
            }
        });
    }
}
