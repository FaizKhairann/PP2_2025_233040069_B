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
    
    // --- LATIHAN 3: Variable Tombol ---
    private JButton btnSaveObj, btnLoadObj; 
    // --- LATIHAN 4: Variable Tombol Baru ---
    private JButton btnAppendText;
    
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
        
        // Tombol Latihan 1
        btnOpenText = new JButton("Buka Text");
        btnSaveText = new JButton("Simpan Text");
        
        // --- LATIHAN 4: Inisialisasi Tombol Append ---
        btnAppendText = new JButton("Tambah Text (Append)");
        
        btnSaveBinary = new JButton("Simpan config (Binary)");
        btnLoadBinary = new JButton("Muat config (Binary)");
        
        // --- LATIHAN 3: Inisialisasi Tombol ---
        btnSaveObj = new JButton("Simpan Objek");
        btnLoadObj = new JButton("Baca Objek");
        
        // Masukkan ke panel
        buttonPanel.add(btnOpenText);
        buttonPanel.add(btnSaveText);
        // --- LATIHAN 4: Masukin Tombol ke Panel ---
        buttonPanel.add(btnAppendText);
        
        buttonPanel.add(btnSaveBinary);
        buttonPanel.add(btnLoadBinary);
        // --- LATIHAN 3: Masukin Tombol ke Panel ---
        buttonPanel.add(btnSaveObj);
        buttonPanel.add(btnLoadObj);
        
        //LAYOUT
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        //EVENT HANDLING
        btnOpenText.addActionListener(e -> bukaFileTeks());
        btnSaveText.addActionListener(e -> simpanFileTeks());
        btnSaveBinary.addActionListener(e -> simpanConfigBinary());
        btnLoadBinary.addActionListener(e -> muatConfigBinary());
        
        // --- LATIHAN 3 Handlers ---
        btnSaveObj.addActionListener(e -> simpanUserConfig());
        btnLoadObj.addActionListener(e -> bacaUserConfig());
        
        // --- LATIHAN 4 Handler ---
        btnAppendText.addActionListener(e -> tambahFileTeks());

        // --- LATIHAN 2 ---
        bacaFileOtomatis();
        
    } 
    
    private void bukaFileTeks() {
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                JOptionPane.showMessageDialog(this, "File berhasil dimuat!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            }
        }
    } 
    
    private void simpanFileTeks() {
        if(fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "File berhasil disimpan!");
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "gagal menyimpan file: " + ex.getMessage());
            }
        }
    }
    
    private void simpanConfigBinary() {
        try (DataOutputStream dos =  new DataOutputStream(new FileOutputStream("config.bin"))) {
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
            textArea.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "gagal membaca" + ex.getMessage());
        }
    }
    
    // --- LATIHAN 3 ---
    private void simpanUserConfig() {
        UserConfig config = new UserConfig();
        config.SetUsername("MahasiswaUnpas"); 
        config.setFontsize(textArea.getFont().getSize());
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.cfg"))) {
            oos.writeObject(config);
            JOptionPane.showMessageDialog(this, "Objek UserConfig berhasil disimpan!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan objek: " + ex.getMessage());
        }
    }

    private void bacaUserConfig() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.cfg"))) {
            UserConfig config = (UserConfig) ois.readObject();
            JOptionPane.showMessageDialog(this, 
                "Username: " + config.getUsername() + "\n" +
                "Font Size: " + config.getFontsize()
            );
            textArea.setFont(new Font("Monospaced", Font.PLAIN, config.getFontsize()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Gagal membaca objek: " + ex.getMessage());
        }
    }

    // --- LATIHAN 4 ---
    private void tambahFileTeks() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.newLine(); 
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "Teks berhasil ditambahkan (Append)!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal append: " + ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
      SwingUtilities.invokeLater(()-> {
        new AplikasiFileIO().setVisible(true);
      });
    }
    
    // --- LATIHAN 2 ---
    private void bacaFileOtomatis() {
        File file = new File("last_notes.txt");
        if (!file.exists()) return;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            textArea.setText("");
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException ex) {
            
        }
    }
}