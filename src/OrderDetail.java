

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;


public class OrderDetail extends JFrame {
    private String orderID,foodID,time,remark;
    String status;
    
    TextEditor reader = new TextEditor();   
                
    public OrderDetail() {
        initComponents();
              
        setTitle("Order Detail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        buttonGroupRemark.add(rbtnDine);
        buttonGroupRemark.add(rbtnTake);
    }
    
   public OrderDetail(String orderID, String foodID,String time,String remark,String status){           // add remark(delivery,take away)
       this.orderID=orderID;
       this.foodID =foodID;
       this.time=time;
       this.remark=remark;
       this.status=status;
       inputOrderID.setText(orderID);
       inputFoodID.setText(foodID);
       inputTime.setText(time);
       comboStatus.setSelectedItem(status);
       
       if (remark.equals("Take Away")){
           rbtnDine.isSelected();
       }
       else if (remark.equals("Dine-in")){
           rbtnTake.isSelected();
       }
       
   }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupRemark = new javax.swing.ButtonGroup();
        lblOrderID = new javax.swing.JLabel();
        lblFoodID = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblRemark = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        rbtnDine = new javax.swing.JRadioButton();
        rbtnTake = new javax.swing.JRadioButton();
        comboStatus = new javax.swing.JComboBox<>();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        inputOrderID = new javax.swing.JLabel();
        inputTime = new javax.swing.JLabel();
        inputFoodID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOrderID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblOrderID.setText("OrderID: ");

        lblFoodID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblFoodID.setText("Food ID:");

        lblTime.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTime.setText("Time:");

        lblRemark.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblRemark.setText("Remark: ");

        lblStatus.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblStatus.setText("Status:");

        rbtnDine.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbtnDine.setText("Dine-in");
        rbtnDine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDineActionPerformed(evt);
            }
        });

        rbtnTake.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rbtnTake.setText("Take away");
        rbtnTake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTakeActionPerformed(evt);
            }
        });

        comboStatus.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING", "PREPARING", "READY", "COMPLETED", "PICKED_UP", "CANCELLED" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        inputOrderID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        inputOrderID.setText("O");

        inputTime.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        inputTime.setText("T");

        inputFoodID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        inputFoodID.setText("F");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblFoodID, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRemark)
                                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblOrderID))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnTake)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnDine)
                            .addComponent(inputOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTime, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(102, 102, 102)
                        .addComponent(btnClose)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderID)
                    .addComponent(inputOrderID))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFoodID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(inputTime))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRemark)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnDine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnTake)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnSave))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnTakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTakeActionPerformed

     
    }//GEN-LAST:event_rbtnTakeActionPerformed

    private void rbtnDineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDineActionPerformed
        
    }//GEN-LAST:event_rbtnDineActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj : container) { 
                Order o = (Order) obj;
                if (o.getId().equals(orderID)) {
                    o.getVendorID();
                    o.getVendorName();
                    o.getCustomer();
                    o.getFood();
                    o.getCost();
                    o.getTime();
                    o.setStatus(Order.Status.valueOf(status));
                    reader.textDelete(TextEditor.FilePaths.HISTORY, o);
                    reader.fileWrite(TextEditor.FilePaths.HISTORY, o);     //Rewrite it all back
                    break; 
                }
            }
            
    }//GEN-LAST:event_btnSaveActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        
        switch (comboStatus.getSelectedIndex()) {           //add status
            case 0:
                status="PENDING";
                break;
            case 1:
                status="PREPARING";
                break;
            case 2:
                status="READY";
                break;
            case 3:
                status="COMPLETED";
                break;
            case 4:
                status="PICKED_UP";
                break;
            case 5:
                status="CANCELLED";
                break;
            default:
                break;
        }
    }//GEN-LAST:event_comboStatusActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        VendorFrame v=new VendorFrame();
        v.setVisible(true);
        OrderDetail o=new OrderDetail();
        o.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    
    public static void main(String args[]) {
        OrderDetail o= new OrderDetail();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderDetail().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroupRemark;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JLabel inputFoodID;
    private javax.swing.JLabel inputOrderID;
    private javax.swing.JLabel inputTime;
    private javax.swing.JLabel lblFoodID;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblRemark;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTime;
    private javax.swing.JRadioButton rbtnDine;
    private javax.swing.JRadioButton rbtnTake;
    // End of variables declaration//GEN-END:variables
}
