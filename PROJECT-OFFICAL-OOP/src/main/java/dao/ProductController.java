/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;

/**
 *
 * @author LOVE
 */
public class ProductController {
    private ArrayList<Product> products;
    private ProductView view;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    public ProductController(ProductView view) {
        this.view = view;
    }
    

    public ProductController(ArrayList<Product> products) {
        this.products = products;
    }
    
    
    
//    public void nhap_du_lieu_sinh_vien(ProductView view){
//        this.product = view.them_du_lieu_sinh_vien();
//    }
    
    public void enter_product_data(){
        Product product = this.view.add_product_data();
        product.save_product_to_db();
    }
    
    public void enter_product_list(){
        this.products = this.view.data_entry_for_multiple_products();
        for(Product sv: products){
            sv.save_product_to_db();
        }
    }
    
     
    public void hien_thi_danh_sach_sinh_vien(){
        //Lay tu csdl ra
        this.products = new Product().lay_danh_sach_sinh_vien();
        this.view.show_a_list_of_products(this.products);
    }
    

    private ArrayList<Product> find_by_unit_price(ArrayList<Product> products, String unitprice){
        ArrayList<Product> result = new ArrayList<>(); //empty =khong tim thay
     
        for(Product sv: products){
            if (sv.getUnitprice().contains(unitprice)){
                result.add(sv);
            }
             
        }
        return result;
    }
    public void search_by_unit_price(){
        String unitprice = this.view.enter_unit_price_to_find();
        ArrayList<Product> kq = find_by_unit_price(products, unitprice);
        this.view.unit_price_search_results(kq);
    }
}

