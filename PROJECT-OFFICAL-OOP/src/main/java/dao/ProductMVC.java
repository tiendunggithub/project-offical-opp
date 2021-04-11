/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


/**
 *
 * @author LOVE
 */
public class ProductMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        kich_ban_3();
    }
    
    public static void kich_ban_3(){
        MenuController menu = new MenuController(new ProductController(new ProductView()), 
                                new MenuView());
        menu.lua_chon_menu();
    }
    
    public static void kich_ban_1(){
        ProductController sc = new ProductController(new ProductView());
        sc.enter_product_data();
       
    }
    
    public static void kich_ban_2(){
        ProductController sc = new ProductController(new ProductView());
        sc.enter_product_list();
        sc.hien_thi_danh_sach_sinh_vien();
        sc.search_by_unit_price();
    }
}
