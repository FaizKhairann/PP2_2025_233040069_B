/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul08.model;

/**
 *
 * @author N1NRC
 */
public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    //tugas 2
    private double keliling;
    
    //meghitung luas (logika bisnis)
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }
    
    //TUGAS 2 HITUNG KELILING
    public void hitungKeliling() {
        this.keliling = 2*(this.panjang + this.lebar);
    }
    
    // getters dan setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }
    
   public void setLebar(double lebar) {
       this.lebar = lebar;
   }
   
   public double getLuas() {
       return luas;
   }
   
   public double getKeliling() {
       return keliling;
   }
}
