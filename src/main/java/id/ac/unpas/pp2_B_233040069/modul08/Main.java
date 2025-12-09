/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul08;
import id.ac.unpas.pp2_B_233040069.modul08.model.PersegiPanjangModel;
import id.ac.unpas.pp2_B_233040069.modul08.view.PersegiPanjangView;
import id.ac.unpas.pp2_B_233040069.modul08.controller.PersegiPanjangController;

/**
 *
 * @author N1NRC
 */
public class Main {
    public static void main (String[] args) {
        PersegiPanjangModel model = new PersegiPanjangModel();
        
        PersegiPanjangView view = new PersegiPanjangView();
        
        PersegiPanjangController controller = new PersegiPanjangController(model, view);
        
        view.setVisible(true);
    }
}

