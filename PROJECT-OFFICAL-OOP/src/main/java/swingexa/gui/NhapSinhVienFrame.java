/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa.gui;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MyPC
 */
public class NhapSinhVienFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form NhapSinhVienFrame
     */
    public NhapSinhVienFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtProduct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtUnitprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtUnit = new javax.swing.JTextField();
        jbtnCancel = new javax.swing.JButton();
        jbtnOk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtxtImage = new javax.swing.JTextField();
        jbtnBrowse = new javax.swing.JButton();
        jtxtSpecies = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Nhập dữ liệu sinh viên");

        jLabel1.setText("Product");

        jLabel2.setText("Unit Price");

        jLabel3.setText("Unit");

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnOk.setText("OK");
        jbtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOkActionPerformed(evt);
            }
        });

        jLabel4.setText("Image");

        jbtnBrowse.setText("Browse");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });

        jLabel5.setText("Species");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnOk)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtProduct)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtImage)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnBrowse))
                            .addComponent(jtxtSpecies)
                            .addComponent(jtxtUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(jtxtUnitprice))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtUnitprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jtxtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jtxtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBrowse))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnOk)
                    .addComponent(jbtnCancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOkActionPerformed
        // TODO add your handling code here:
//        Product sv = new Product(jtxtFullname.getText(), 
//                                    jtxtSdt.getText(), 
//                                    jtxtEmail.getText());
//        sv.save_product_to_db();
        Product sv = new Product(jtxtProduct.getText(), 
                                   jtxtUnitprice.getText(), 
                                    jtxtUnit.getText(),
                                       jtxtImage.getText());
        sv.save_product_with_image();
        JOptionPane.showMessageDialog(this, "Đã lưu vào CSDL", "Thông báo kết quả", 
                        JOptionPane.INFORMATION_MESSAGE);
        jtxtProduct.setText("");
        jtxtUnitprice.setText("");
        jtxtUnit.setText("");
        jtxtImage.setText("");
        jtxtProduct.setFocusable(true);
    }//GEN-LAST:event_jbtnOkActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        try {
            // TODO add your handling code here:
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(NhapSinhVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        //Loc ra cac tap tin hinh anh
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image types", 
                                            "jpg", "jpeg", "gif", "bmp", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showDialog(null, "Choose");
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String path = chooser.getSelectedFile().getPath();
//            path = path.replaceAll("\\", "\\\\");
            jtxtImage.setText(path);
        }
    }//GEN-LAST:event_jbtnBrowseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnOk;
    private javax.swing.JTextField jtxtImage;
    private javax.swing.JTextField jtxtProduct;
    private javax.swing.JTextField jtxtSpecies;
    private javax.swing.JTextField jtxtUnit;
    private javax.swing.JTextField jtxtUnitprice;
    // End of variables declaration//GEN-END:variables
}
