/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.Tugasmodul10;
import id.ac.unpas.pp2_B_233040069.Tugasmodul10.model.MahasiswaModel;
import id.ac.unpas.pp2_B_233040069.Tugasmodul10.view.MahasiswaView;
import id.ac.unpas.pp2_B_233040069.Tugasmodul10.controller.MahasiswaController;
/**
 *
 * @author N1NRC
 */
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            
            MahasiswaView view = new MahasiswaView();
            MahasiswaModel model = new MahasiswaModel();
            new MahasiswaController(model, view);
            
        });
    }
}
