
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 110ti
 */
public class Vendor_Order_Detail extends javax.swing.JFrame {
    private String orderID,foodID,custID,remark,time,cost;
    private Customer customer;
    private String status;
    private Vendor vendor;
    private Order order = new Order();
    
    public Vendor_Order_Detail(){}
    
    public Vendor_Order_Detail(Vendor vendor, String orderID, String foodID, String custID, String time, String remark, String status, String cost) {
        initComponents();
        this.vendor = vendor;
        this.orderID= orderID;
        this.foodID = foodID;
        this.time= time;
        this.remark=remark;
        this.status=status;
        this.cost = cost;
        this.custID = custID;
        inputOrderID_TF.setEditable(false);
        inputFoodID_TF.setEditable(false);
        inputTime_TF.setEditable(false);
        inputOrderID_TF.setText(orderID);
        inputFoodID_TF.setText(foodID);
        inputTime_TF.setText(time);
        
        Dine_Rbtn.setActionCommand("Dine in");
        TakeAway_Rbtn.setActionCommand("Take Away");

        if (remark.equals("Dine in")) {
            Dine_Rbtn.setSelected(true);
            TakeAway_Rbtn.setSelected(false);
        } else if(remark.equals("Take Away")){
            Dine_Rbtn.setSelected(false);
            TakeAway_Rbtn.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        inputOrderID_TF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        inputFoodID_TF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputTime_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Dine_Rbtn = new javax.swing.JRadioButton();
        TakeAway_Rbtn = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        Status_CB = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputOrderID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOrderID_TFActionPerformed(evt);
            }
        });

        jLabel1.setText("Order ID:");

        inputFoodID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFoodID_TFActionPerformed(evt);
            }
        });

        jLabel2.setText("Food");

        inputTime_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTime_TFActionPerformed(evt);
            }
        });

        jLabel3.setText("Time");

        jLabel4.setText("Remark:");

        buttonGroup1.add(Dine_Rbtn);
        Dine_Rbtn.setText("Dine in");

        buttonGroup1.add(TakeAway_Rbtn);
        TakeAway_Rbtn.setText("Take Away");
        TakeAway_Rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TakeAway_RbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        Status_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PENDING", "PREPARING", "READY", "COMPLETED", "PICKED_UP", "CANCELLED" }));
        Status_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status_CBActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputFoodID_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputOrderID_TF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputTime_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Status_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TakeAway_Rbtn)
                            .addComponent(Dine_Rbtn))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputOrderID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputFoodID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTime_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Dine_Rbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TakeAway_Rbtn)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Status_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputOrderID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOrderID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputOrderID_TFActionPerformed

    private void inputFoodID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFoodID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFoodID_TFActionPerformed

    private void inputTime_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTime_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTime_TFActionPerformed

    private void TakeAway_RbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeAway_RbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TakeAway_RbtnActionPerformed

    private void Status_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_CBActionPerformed
        order.setUpdateStatus(Status_CB.getSelectedIndex());
    }//GEN-LAST:event_Status_CBActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        
        List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        String custid = null;
        double foodCost = 0;
        boolean check = false;
        boolean cancelled = false;
        
        for (Object obj : container) {
            Order order = (Order) obj;

            if (order.getId().equals(orderID)) {
                if (Status_CB.getSelectedItem().equals("CANCELLED")) {
                    updateCustomerBalance(order.getCustomerID(), order.getCost());
                    order.setStatus(Order.Status.CANCELLED);
                    order.setTime();
                    System.out.println("New Status: " + order.getStatus());
                    updateOrder(order);
                    updateNotification(orderID);
                    JOptionPane.showMessageDialog(null, "Order Cancelled!");
                    check = true;
                    break;
                } else {
                    custid = order.getCustomerID();
                    foodCost = order.getCost();
                    order.setUpdateStatus(Status_CB.getSelectedIndex());
                    order.setTime();
                    System.out.println("New Status: " + order.getStatus());
                    updateOrder(order);
                    updateNotification(orderID);
                    JOptionPane.showMessageDialog(null, "Order Status Updated!");
                    check = true;
                    break;
                }
            }
        }

        if (!check) {
            JOptionPane.showMessageDialog(null, "Order not exist!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendor_Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_Order_Detail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_Order_Detail().setVisible(true);
            }
        });
    }
    
    public void updateCustomerBalance(String id, double cost) {
        List<DataProvider> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (DataProvider obj : container) {
            if (obj instanceof Customer) {
                Customer cust = (Customer) obj;
                if (cust.getId().equals(id)) {
                    double newBalance = cust.getBal() + cost;
                    cust.setBal(String.valueOf(newBalance));
                    System.out.println("New Balance: " + cust.getBal());
                    TextEditor.textDelete(TextEditor.FilePaths.USER, cust);
                    TextEditor.fileWrite(TextEditor.FilePaths.USER, cust);
                    break;
                }
            }
        }
    }

    
    // Separate method to update the order in the file    
    public void updateNotification(String orderId){
        List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container2) { 
            Notification n = (Notification) obj;
            if (n.getId().equals(orderID)){                //compare orderID in order table
                if (order.getStatus().equals("PREPARING")) {        
                    n.setMessage(Notification.Messages.PREPARE);
                    n.setTime(time);
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                    JOptionPane.showMessageDialog(null, "Order Status Updated!");
                    break;
                }
                else if (order.getStatus().equals("READY")){
                    n.setMessage(Notification.Messages.READY);
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                    JOptionPane.showMessageDialog(null, "Order Status Updated!");
                    break;
                }
                else if (order.getStatus().equals("CANCELLED")){
                    n.setMessage(Notification.Messages.CANCEL);
                    n.setTime(time);
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                    JOptionPane.showMessageDialog(null, "Order Status Updated!");
                    break;
                }
            }
        }
    }
    
    private void updateOrder(Order order) {
        TextEditor.textDelete(TextEditor.FilePaths.HISTORY, order);
        TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Dine_Rbtn;
    private javax.swing.JComboBox<String> Status_CB;
    private javax.swing.JRadioButton TakeAway_Rbtn;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputFoodID_TF;
    private javax.swing.JTextField inputOrderID_TF;
    private javax.swing.JTextField inputTime_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
