/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LOVE
 */
public class Product {
    private int idproduct;
    private String product;
    private String unitprice;
    private String unit;
    private String species;

    public Product() {
    }

    public Product(String product, String unitprice, String unit, String species) {
        this.product = product;
        this.unitprice = unitprice;
        this.unit = unit;
        this.species = species;
    }
    
    public Product(int idproduct, String product, String unitprice, String unit, String species) {
        this.idproduct = idproduct;
        this.product = product;
        this.unitprice = unitprice;
        this.unit = unit;
        this.species = species;
    }
    
    
    //Xây dựng các hàm khởi tạo

//    public Product() {
//    }
//
//    public Product(String product, String unitprice, String unit) {
//        this.product = product;
//        this.unitprice = unitprice;
//        this.unit = unit;
//    }
//
//    public Product(int idproduct, String product, String unitprice, String unit) {
//        this.idproduct = idproduct;
//        this.product = product;
//        this.unitprice = unitprice;
//        this.unit = unit;
//    }
    
    //Xây dựng hàm kết nối đến cơ sở dữ liệu
    public Connection lay_ket_noi_csdl(){
        Connection conn = null;
        try {
            //Code của bạn ở đây
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qlsp",
                    "root", "01639861242");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    //Xây dựng hàm thêm 1 product vào database
    public void save_product_to_db(){
        try {
            //Code của bạn ở đây
            //Buoc 1: Lay ket noi toi csdl
            Connection ketnoicsdl = lay_ket_noi_csdl();
            
            // the mysql insert statement
            String query = " insert into product (product, unitprice, unit, species)"
                    + " values (?, ?, ?, ?, ?)";
            
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.product);
            preparedStmt.setString(2, this.unitprice);
            preparedStmt.setString(3, this.unit);
            preparedStmt.setString(4, this.species);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Hàm lấy ra danh sách các sinh viên trong bang product
    public ArrayList<Product> lay_danh_sach_sinh_vien(){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            //Buoc 1: Tao ket noi toi csdl
            Connection ketnoicsdl = lay_ket_noi_csdl();
            Statement stmt=ketnoicsdl.createStatement();
            ResultSet rs=stmt.executeQuery("select * from product");
            while(rs.next()){
                Product sv = new Product(rs.getInt("idproduct"), 
                                        rs.getString("product"), 
                                        rs.getString("unitprice"), 
                                        rs.getString("unit"),
                                        rs.getString("species"));
                result.add(sv);
            }
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    //Hàm cập nhật sinh viên hiện tại vào csdl
    public void update_current_product(){
        try {
            //code của bạn ở đây
            //Buoc 1: Tao ket noi toi csdl
            Connection ketnoicsdl = lay_ket_noi_csdl();
            // create the java mysql update preparedstatement
            String query = "update product set product = ?,"
                    + " unitprice = ?,"
                    + "unit = ?,"
                    + "species = ?, where idproduct = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.product);
            preparedStmt.setString(2, this.unitprice);
            preparedStmt.setString(3, this.unit);
            preparedStmt.setString(4, this.species);
            preparedStmt.setInt(5, this.idproduct);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm xóa sinh viên hiện tại ra khỏi csdl
    public void delete_current_product(){
        //code của bạn ở đây
        try {
            //code của bạn ở đây
            //Buoc 1: Tao ket noi toi csdl
            Connection ketnoicsdl = lay_ket_noi_csdl();
            // create the java mysql update preparedstatement
            String query = "delete from product where idproduct = ?";
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setInt(1, this.idproduct);
            
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Các getter và setter 

    public int getIdproduct() {
        return idproduct;
    }

    public String getProduct() {
        return product;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public String getUnit() {
        return unit;
    }

    public String getSpecies() {
        return species;
    }
    
    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    

    @Override
    public String toString() {
        return "Product{" + "idproduct=" + idproduct + ", product=" + product + ", unitprice=" + unitprice 
                + ", unit=" + unit + unitprice + ", species=" + species +'}';
    }
    
    
}
