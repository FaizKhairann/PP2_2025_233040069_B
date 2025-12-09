/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul08.view;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author N1NRC
 */
public class PersegiPanjangView extends JFrame{
     //komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    private JLabel lblHasil = new JLabel("-");
    //tugas 2
    private JLabel lblhasilKeliling = new JLabel("-");
    private JButton btnHitung = new JButton("Hitung");
    //tugas 3
    private JButton btnReset = new JButton("Reset");
    
    public PersegiPanjangView() {
        //inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setLayout(new GridLayout(5, 2, 10, 10));
        this.setTitle("MVC Kalkulator");
        
        this.add(new JLabel("Panjang: "));
        this.add(txtPanjang);
        this.add(new JLabel("Lebar : "));
        this.add(txtLebar);
        this.add(new JLabel("Hasil Luas : "));
        this.add(lblHasil);
        //TUGAS 2 KELILIING
        this.add(new JLabel("Hasil Keliling"));
        this.add(lblhasilKeliling);
        
      
        
        this.add(btnHitung);
        //tugas 3
        this.add(btnReset);
    }
    
    // mengambil nilai panjang dari TextField
    public double getPanjang() {
        return Double.parseDouble(txtPanjang.getText());
    }

    public double getLebar() {
        return Double.parseDouble(txtLebar.getText());
    }
    
    public void setHasil(double hasil) {
        lblHasil.setText(String.valueOf(hasil));
    }
    
    public void setHasilKeliling(double hasil) {
        lblhasilKeliling.setText(String.valueOf(hasil));
    }
    
    public void clearInput() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasil.setText("-");
        lblhasilKeliling.setText("-");
        txtPanjang.requestFocus();
    }
            
    public void tampilkanPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    
    }
    
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    //TUGAS 3
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}   
