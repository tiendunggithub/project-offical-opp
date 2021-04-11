/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.console;

/**
 *
 * @author MyPC
 */
public class LoginMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginController lc = new LoginController(new LoginView(),
                                        new dbutils("qlht", "3306", "root", "01639861242").lay_ket_noi_csdl());
        lc.dang_nhap();
    }
    
}
