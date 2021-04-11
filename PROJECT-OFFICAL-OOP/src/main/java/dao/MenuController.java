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
public class MenuController {
    private ProductController st_contrl;
    private MenuView mnview;

    public MenuController() {
    }

    public MenuController(ProductController st_contrl) {
        this.st_contrl = st_contrl;
    }

    public MenuController(ProductController st_contrl, MenuView mnview) {
        this.st_contrl = st_contrl;
        this.mnview = mnview;
    }
    
    
    
    public void lua_chon_menu(){
        boolean flag = true;
        while (flag){
            int kq = mnview.hien_thi_menu();
            switch(kq){
                case 1: 
                    st_contrl.enter_product_list();
                    break;
                case 2:
                    st_contrl.search_by_unit_price();
                    break;
                case 3: 
                    flag = false;
                    break;
            }
        }
        
    }
    
    
}
