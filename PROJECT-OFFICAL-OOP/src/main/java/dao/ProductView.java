/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LOVE
 */
public class ProductView {

    public ProductView() {
    }
    //hiển thị một sản phẩm
    public void show_a_product(Product x){
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("++++ " + x.toString() + " ++++");
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
    
    public Product add_product_data(){
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Product: ");
        Scanner sc = new Scanner(System.in);
        String product = sc.nextLine();
        System.out.println("UnitPrice: ");
        String unitprice = sc.nextLine();
        System.out.println("Unit: ");
        String unit = sc.nextLine();
        System.out.println("Species: ");
        String species = sc.nextLine();
        Product sv = new Product(product, unitprice, unit, species);
        System.out.println("Finished");
        System.out.println("++++++++++++++++++++++++++++++++++");
        return sv;
    }
    //nhập dữ liệu nhiều sản phẩm
    public ArrayList<Product> data_entry_for_multiple_products(){
        ArrayList<Product> result = new ArrayList<>();
        boolean flag = true;
        while(flag){
            System.out.println("Ban co muon nhap du lieu khong? (y/n)");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if ("n".equals(answer) || "N".equals(answer)){
                flag = false;
            }else{
                Product sv = add_product_data();
                result.add(sv);
            }
        }
        return result;
    }
    //hiển thị danh sách sản phẩm
    public void show_a_list_of_products(ArrayList<Product> products){
        
        System.out.println("++++++++++++++++++++++++++++++++++");
        for(Product sv: products){
            System.out.println("++++ " + sv.toString() + " ++++");
        }    
        System.out.println("++++++++++++++++++++++++++++++++++");
    }
    
    
    
    //view nhap thong tin can tim
    public String enter_unit_price_to_find(){
        System.out.println("+++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so dien thoai can tim kiem: ");
        String unitprice = sc.nextLine();
        System.out.println("+++++++++++++++++++++++");
        return unitprice;
    }
    
    //view in ket qua tim kiem
    public void unit_price_search_results(ArrayList<Product> products){
        System.out.println("+++++++++++++++++++++++");
        if (products.isEmpty()){
            System.out.println("Khong tim thay");
        }else{
            for(Product sv: products){
                System.out.println(sv.toString());
            }
        }
        System.out.println("+++++++++++++++++++++++");
    }
}
