/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.console;

import java.util.Scanner;

/**
 *
 * @author MyPC
 */
public class LoginView {

    public LoginView() {
    }
    
    public UserModel login_information(){
        System.out.println("+++++++++++++++++++++++++++++");
        UserModel result = new UserModel();
        System.out.println("Username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        result.setUsername(username);
        result.setPassword(password);
        System.out.println("+++++++++++++++++++++++++++++");
        return result;
    }
    
    public void thong_bao_ket_qua(String message){
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println(message);
        System.out.println("+++++++++++++++++++++++++++++");
    }
}
