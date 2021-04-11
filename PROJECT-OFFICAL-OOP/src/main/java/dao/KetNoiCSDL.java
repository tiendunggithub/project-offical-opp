/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MyPC
 */
public class KetNoiCSDL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qlsp",
                    "root", "01639861242")) {
                Statement stmt=conn.createStatement();
                ResultSet rs=stmt.executeQuery("select * from sanpham");
                while(rs.next())
                    System.out.println(rs.getInt("actor_id")+"  "+rs.getString("first_name")+"  "+rs.getString("last_name"));
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(KetNoiCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
