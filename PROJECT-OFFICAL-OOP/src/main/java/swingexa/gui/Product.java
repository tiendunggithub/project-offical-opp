/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author MyPC
 */
public class Product {
    private int idproduct;
    private String product;
    private String unitprice;
    private String unit;
    private String species;
    private FileInputStream imageIn;
    private BufferedImage imageOut;
    
    //Xây dựng các hàm khởi tạo

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

    public Product(String product, String unitprice, String unit, String species, 
                        String imagePath) {
        this.product = product;
        this.unitprice = unitprice;
        this.unit = unit;
        this.species = species;
        
        try {
            //Đọc ảnh vào bộ nhớ
            this.imageIn = new FileInputStream(new File(imagePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       
    //Xây dựng hàm thêm 1 product vào database
    public void save_product_to_db(){
        try {
            //Code của bạn ở đây
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();            
            // the mysql insert statement
            String query = " insert into product (product, unitprice, unit, species)"
                    + " values (?, ?, ?, ?)";
            
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
    
    //Hàm chèn dữ liệu sinh viên có ảnh vào csdl
    public void save_product_with_image(){
        try {
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection ketnoicsdl = db.lay_ket_noi_csdl();
            // the mysql insert statement
            String query = " insert into product (product, unitprice, unit,species, image)"
                    + " values (?, ?, ?, ?, ?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = ketnoicsdl.prepareStatement(query);
            preparedStmt.setString(1, this.product);
            preparedStmt.setString(2, this.unitprice);
            preparedStmt.setString(3, this.unit);
            preparedStmt.setString(4, this.species);
            preparedStmt.setBlob(5, imageIn);
            
            // execute the preparedstatement
            preparedStmt.execute();
            
            ketnoicsdl.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Hàm lấy ra 1 sinh vien theo id
    public Product get_product_by_id(int id) throws SQLException{
        dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
        Connection conn = db.lay_ket_noi_csdl();
        String query = "select product, unitprice, unit, species from product where idproduct = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Product sv = new Product();
        if (rs.next()){
            sv.setProduct(rs.getString("product"));
            sv.setUnitprice(rs.getString("unitprice"));
            sv.setUnit(rs.getString("unit"));
            sv.setSpecies(rs.getString("species"));
        }
        conn.close();
        return sv;
    }
    
    //Hàm lấy sinh viên với ảnh theo id
    public Product get_product_image_by_id(int id){
        Product sv = new Product();
        try {
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection conn = db.lay_ket_noi_csdl();
            String query = "select product, unitprice, unit, species, image from product where idproduct = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                sv.setIdproduct(idproduct);
                sv.setProduct(rs.getString("product"));
                sv.setUnitprice(rs.getString("unitprice"));
                sv.setUnit(rs.getString("unit"));
                sv.setSpecies(rs.getString("species"));
                //doc anh vao bo nho
                Blob blob = rs.getBlob("image");
                InputStream in = blob.getBinaryStream();
                sv.imageOut = ImageIO.read(in);
            }
            conn.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
    
    //Hàm lấy ra danh sách các sinh viên trong bang product
    public ArrayList<Product>get_product_list(){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection conn = db.lay_ket_noi_csdl(); 
            //String query = "select * from product";
            Statement stmt=conn.createStatement();
            //PreparedStatement stmt = ketnoicsdl.prepareStatement(query);
            ResultSet rs=stmt.executeQuery("select * from product");
            while(rs.next()){
                Product sv = new Product(rs.getInt("idproduct"), 
                                        rs.getString("product"), 
                                        rs.getString("unitprice"), 
                                        rs.getString("unit"),
                                        rs.getString("species"));
                result.add(sv);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Ham tim kiem theo ten san pham
    public ArrayList<Product> search_for_products_by_name(String s){
        ArrayList<Product> result = new ArrayList<>();
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection conn = db.lay_ket_noi_csdl(); 
            String query = "select idproduct, product, unitprice, unit, species from product where product = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, '%' + s + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Product sv = new Product(rs.getInt("idproduct"), 
                                        rs.getString("product"), 
                                        rs.getString("unitprice"), 
                                        rs.getString("unit"),
                                        rs.getString("species"));
                result.add(sv);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Hàm cập nhật sinh viên hiện tại vào csdl
    public void update_current_product(){
        try {
            //code của bạn ở đây
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
            // create the java mysql update preparedstatement
            String query = "update product set product = ?,"
                    + " unitprice = ?,"
                    + "unit = ?,"
                    + "species = ? where idproduct = ?";
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
            dbutils db = new dbutils("qlsp", "3306", "root", "01639861242");
            Connection ketnoicsdl = db.lay_ket_noi_csdl(); 
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

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
    public FileInputStream getImageIn() {
        return imageIn;
    }

    public void setImageIn(FileInputStream imageIn) {
        this.imageIn = imageIn;
    }

    public BufferedImage getImageOut() {
        return imageOut;
    }

    public void setImageOut(BufferedImage imageOut) {
        this.imageOut = imageOut;
    }

    
    @Override
    public String toString() {
        return "Product{" + "idproduct=" + idproduct + ", product=" + product + ", unitprice=" + unitprice 
                + ", unit=" + unit + ", species="+ species +'}';
    }
    
    
}
