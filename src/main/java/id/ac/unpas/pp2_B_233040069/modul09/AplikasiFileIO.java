/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul09;
import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 *
 * @author N1NRC
 */
public class AplikasiFileIO extends JFrame {
    //komponen UI
    private JTextArea textArea;
    private JButton btnOpenText, btnSaveText;
    private JButton btnSaveBinary, btnLoadBinary;
    private JFileChooser fileChooser;
    
    public AplikasiFileIO() {
        super("Tutorial Dile IO & Exception Handling");
        setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //inisialisasi komponen
        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        fileChooser = new JFileChooser();
        
        // panel tombol
        JPanel buttonPanel = new JPanel();
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        btnSaveBinary = new JButton("Simpan config (Binary)");
        btnLoadBinary = new JButton("Muat config (Binary)");
        
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        
        //LAYOUT
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        //EVENT HANDLING
        //1.
        btnOpenText.addActionListener(e -> bukaFileTeks());
        //2
        btnSaveText.addActionListener(e -> simpanFileTeks());
        //3
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        //4
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
    }
    
    private void bukaFileTeks() {
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            BufferedReader reader = null;
            
            //try with resources otomatis menutup stream tanpa block finally manual
            try {
                //membuka stream
                reader = new BufferedReader(new FileReader(file));
                textArea.setText("");
                
                String line;
                //pane baris demi baris 
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
                
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "File tidak ditemukan : " + ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal membaca file : " + ex.getMessage());
            } finally {
                //blok finally : selalu dijalankan untuk menutup resource
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    } 
    
    private void simpanFileTeks() {
        if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            //TRY
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal menyimpan file: " + ex.getMessage());
            }
        }
    }
    
    //contoh menulis binary (menyimpan ukuran font seat ini ke dile .bin)
    private void simpanConfigBinary() {
        try (DataOutputStream dos =  new DataOutputStream(new FileOutputStream("config.bin"))) {
            //kitas simpan ukuran font 
            int fontSize = textArea.getFont().getSize();
            dos.writeInt(fontSize);
            
            JOptionPane.showMessageDialog(this, "ukuran font (" + fontSize +") disimpan ke config .bin");
                    
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "gagal menyimpan binary : " + ex.getMessage());
        }
    }
    
    private void muatConfigBinary() {
        try(DataInputStream dis = new DataInputStream(new FileInputStream("config.bin"))) {
            int fontSize = dis.readInt();
            
            // Terapkan ke aplikasi
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "File config.bin belum dibuat!");
        }catch  (IOException ex) {
            JOptionPane.showMessageDialog(this, "gagal membaca" + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
     SwingUtilities.invokeLater(()-> {
        new AplikasiFileIO().setVisible(true);
     });
    }
    
   
}
