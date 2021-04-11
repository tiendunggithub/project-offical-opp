/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.console;

import java.sql.Connection;

/**
 *
 * @author MyPC
 */
public class LoginController {
    private LoginView myview;
    private Connection ketnoi;

    public LoginController() {
    }

    public LoginController(LoginView myview) {
        this.myview = myview;
    }

    public LoginController(LoginView myview, Connection ketnoi) {
        this.myview = myview;
        this.ketnoi = ketnoi;
    }
    
    
    
    public void dang_nhap(){
        UserModel user = myview.login_information();
        if (user.kiem_tra_account(ketnoi)){
            myview.thong_bao_ket_qua("Ban da dang nhap thanh cong");
        } else{
            myview.thong_bao_ket_qua("USername hoac Password nhap sai");
        }
    }
}
