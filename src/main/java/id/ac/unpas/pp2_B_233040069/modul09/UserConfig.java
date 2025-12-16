/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pp2_B_233040069.modul09;
import java.io.Serializable;

/**
 *
 * @author N1NRC
 */
public class UserConfig implements Serializable {
    private String username;
    private int fontsize;
    
    public String getUsername() {
        return username;
    }
    
    public void SetUsername(String username) {
        this.username = username;
    }
    
    public int getFontsize() {
        return fontsize;
    }
    
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }
}
