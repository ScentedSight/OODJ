
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
    private String orderID,foodID,custID,remark,time,cost, quantity, runner;
    private Customer customer;
    private String status;
    private Vendor vendor;
    private Order order = new Order();
    
    public Vendor_Order_Detail(){}
    
    public Vendor_Order_Detail(Vendor vendor, String orderID, String foodID, String custID, String time, String remark, String status, String cost, Double quantity) {
        initComponents();
        this.vendor = vendor;
        this.orderID= orderID;
        this.foodID = foodID;
        this.time= time;
        this.remark=remark;
        this.status=status;
        this.quantity = String.valueOf(quantity);
        this.cost = cost;
        this.custID = custID;
        inputOrderID_TF.setEditable(false);
        txtQuantity.setEditable(false);
        inputTime_TF.setEditable(false);
        inputOrderID_TF.setText(orderID);
        txtQuantity.setText(this.quantity);
        inputFoodID_TF1.setText(foodID);
        inputTime_TF.setText(time);
        setTitle("Order Detail");
        
        Dine_Rbtn.setEnabled(false); //Disable radio button
        TakeAway_Rbtn.setEnabled(false);
        Delivery_Rbtn.setEnabled(false);
        
        remarkChecker();
    }
    
    public Vendor_Order_Detail(Vendor vendor, String orderID, String foodID, String custID, String time, String remark, String status, String cost, Double quantity, String runner) { //For deliveries
        initComponents();
        this.vendor = vendor;
        this.orderID= orderID;
        this.foodID = foodID;
        this.time= time;
        this.remark=remark;
        this.status=status;
        this.quantity = String.valueOf(quantity);
        this.cost = cost;
        this.custID = custID;
        this.runner = runner;
        inputOrderID_TF.setEditable(false);
        txtQuantity.setEditable(false);
        inputTime_TF.setEditable(false);
        inputOrderID_TF.setText(orderID);
        txtQuantity.setText(this.quantity);
        inputFoodID_TF1.setText(foodID);
        inputTime_TF.setText(time);
        setTitle("Order Detail");
        if (runner == null) { //Set to empty space if runner is null
            lblRunner.setText("");
        } else {
            lblRunner.setText("Delivery Runner: " + runner);
        }
        
        Dine_Rbtn.setEnabled(false); //Disable radio button
        TakeAway_Rbtn.setEnabled(false);
        Delivery_Rbtn.setEnabled(false);
        
        remarkChecker();
    }

    private void remarkChecker() {
        if (remark.equals("Dine in")) {
            Dine_Rbtn.setSelected(true);
            TakeAway_Rbtn.setSelected(false);
            Delivery_Rbtn.setSelected(false);
        } else if(remark.equals("Take Away")){
            Dine_Rbtn.setSelected(false);
            TakeAway_Rbtn.setSelected(true);
            Delivery_Rbtn.setSelected(false);
        } else if (remark.equals("Delivery")) {
            Dine_Rbtn.setSelected(false);
            TakeAway_Rbtn.setSelected(false);
            Delivery_Rbtn.setSelected(true);
        }
    }
    
    private Order.Status statusConvert(String index) { //convert combobox string to status object in order
        switch (index) {
            case "PENDING":
                return Order.Status.PENDING;
            case "PREPARING":
                return Order.Status.PREPARING;
            case "READY":
                return Order.Status.READY;
            case "COMPLETED":
                return Order.Status.COMPLETED;
            case "PICKED_UP":
                return Order.Status.PICKED_UP;
            case "CANCELLED":
                return Order.Status.CANCELLED;
            default:
                throw new IllegalArgumentException("Invalid status: " + index);
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
        txtQuantity = new javax.swing.JTextField();
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
        lblQuantity = new javax.swing.JLabel();
        inputFoodID_TF1 = new javax.swing.JTextField();
        Delivery_Rbtn = new javax.swing.JRadioButton();
        lblRunner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputOrderID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputOrderID_TFActionPerformed(evt);
            }
        });

        jLabel1.setText("Order ID:");

        txtQuantity.setEditable(false);
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel2.setText("Food:");

        inputTime_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTime_TFActionPerformed(evt);
            }
        });

        jLabel3.setText("Time:");

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

        lblQuantity.setText("Quantity:");

        inputFoodID_TF1.setEditable(false);
        inputFoodID_TF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFoodID_TF1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Delivery_Rbtn);
        Delivery_Rbtn.setText("Delivery");
        Delivery_Rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delivery_RbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputOrderID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Status_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblQuantity)
                                    .addGap(13, 13, 13)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputTime_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Dine_Rbtn)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Delivery_Rbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(TakeAway_Rbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(inputFoodID_TF1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRunner)
                                .addComponent(btnSave))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputOrderID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFoodID_TF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputTime_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Dine_Rbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TakeAway_Rbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delivery_Rbtn)
                    .addComponent(lblRunner))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSave))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputOrderID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputOrderID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputOrderID_TFActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void inputTime_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTime_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTime_TFActionPerformed

    private void TakeAway_RbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TakeAway_RbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TakeAway_RbtnActionPerformed

    private void Status_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status_CBActionPerformed

    }//GEN-LAST:event_Status_CBActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        String custid = null;
        double foodCost = 0;
        boolean check = false;

        for (Object obj : container) {
            if (obj instanceof DeliveryOrder) {
                DeliveryOrder dOrder = (DeliveryOrder) obj;
                if (String.valueOf(Status_CB.getSelectedItem()).equals("CANCELLED")) {
                    dOrder.refund(dOrder.getCustomerID());
                }
                if (dOrder.getId().equals(orderID)) {
                    custid = dOrder.getCustomerID();
                    foodCost = dOrder.getCost();
                    dOrder.setStatus(statusConvert(String.valueOf(Status_CB.getSelectedItem())));
                    dOrder.setTime();
                    System.out.println("New Status: " + dOrder.getStatus());
                    TextEditor.textDelete(TextEditor.FilePaths.HISTORY, dOrder);
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, dOrder);
                    this.order = dOrder;
                    updateNotification(orderID);
                    JOptionPane.showMessageDialog(null, "Order Status Updated!");
                    check = true;
                    break;
                }
            } else if (obj instanceof Order) {
                Order order = (Order) obj;
                if (String.valueOf(Status_CB.getSelectedItem()).equals("CANCELLED")) {
                    order.refund(order.getCustomerID());
                }
                if (order.getId().equals(orderID)) {
                    custid = order.getCustomerID();
                    foodCost = order.getCost();
                    order.setStatus(statusConvert(String.valueOf(Status_CB.getSelectedItem())));
                    order.setTime();
                    System.out.println("New Status: " + order.getStatus());
                    TextEditor.textDelete(TextEditor.FilePaths.HISTORY, order);
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order);
                    this.order = order;
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
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void inputFoodID_TF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFoodID_TF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFoodID_TF1ActionPerformed

    private void Delivery_RbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delivery_RbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Delivery_RbtnActionPerformed

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
                }
                else if (order.getStatus().equals("READY")){
                    n.setMessage(Notification.Messages.READY);
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                }
                else if (order.getStatus().equals("CANCELLED")){
                    n.setMessage(Notification.Messages.CANCEL);
                    n.setTime(time);
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Delivery_Rbtn;
    private javax.swing.JRadioButton Dine_Rbtn;
    private javax.swing.JComboBox<String> Status_CB;
    private javax.swing.JRadioButton TakeAway_Rbtn;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField inputFoodID_TF1;
    private javax.swing.JTextField inputOrderID_TF;
    private javax.swing.JTextField inputTime_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRunner;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
