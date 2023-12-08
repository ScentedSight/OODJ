
import javax.swing.table.*;
import java.util.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author huach
 */
public class VendorFrame extends JFrame {
        
    private DefaultTableModel MenuModel = new DefaultTableModel();
    private DefaultTableModel OrderModel = new DefaultTableModel();
    private Vendor vendor;
    private String[] MenuColumn={"FoodID","Description","Price"};
    private String[] OrderList={"OrderID","Time","Status"};
    private int MenuRow = -1; 
    private int OrderRow = -1;
    
    public VendorFrame(){  //Default constructor for testing
        initComponents();
        MenuModel.setColumnIdentifiers(MenuColumn);
        OrderModel.setColumnIdentifiers(OrderList);
        lblWelcome.setText("Welcome"+vendor.getName());
    }
    
    public VendorFrame(Vendor vendor) {
        initComponents();
        this.vendor=vendor;
        lblWelcome.setText("Welcome " + vendor.getId());            //welcome vendor
        MenuModel.setColumnIdentifiers(MenuColumn);
        OrderModel.setColumnIdentifiers(OrderList);
        
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj1 : container) { //change obj name
            Order O = (Order) obj1;
            String status=O.getStatus();     
            
            if (!status.equals("PICKED_UP")|| !status.equals("COMPLETED")) {
                String[] OrderVendorArray = {
                    O.getId(),          //get OrderID
                    O.getTime(),        //get Order Time
                    status,             //get Order Status
                };
                OrderModel.addRow(OrderVendorArray);        //add data
            }
            
        }
        
        Set<String> uniqueDescriptions = new HashSet<>();           //like select distinct, add once only
        List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        for (Object obj : container2) { //change obj name
            Food menu = (Food) obj;
            
            if (menu.getId().equals(vendor.getId()) && uniqueDescriptions.add(menu.getDescription())) {   //prevent duplicated data or wrong vendor
                String[] MenuArray = {
                    menu.getId()+":"+menu.getDescription(),     //get FoodID
                    menu.getDescription(),                      //get Food Name
                    Double.toString(menu.getCost()),          //get Food Cost
                };
                MenuModel.addRow(MenuArray);
            }
            else{
                System.out.println("Something went wrong.");
            }
            
        }
           
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogOut = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        btnRevenue = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        lblOrder = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        lblMenu1 = new javax.swing.JLabel();
        btnAddMenu = new javax.swing.JButton();
        lblNotification = new javax.swing.JLabel();
        btnRead = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogOut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLogOut.setText("LogOut");

        lblWelcome.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblWelcome.setText("Welcome, XXX");

        btnRevenue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRevenue.setText("Revenue Dashboard (Order History & Review)");
        btnRevenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevenueActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        MenuTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        MenuTable.setModel(MenuModel);
        MenuTable.setColumnSelectionAllowed(true);
        MenuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MenuTable);
        MenuTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MenuTable.getAccessibleContext().setAccessibleName("Vendor Menu");

        lblOrder.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblOrder.setText("Order");

        OrderTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        OrderTable.setModel(OrderModel);
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(OrderTable);
        OrderTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblMenu1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMenu1.setText("Menu");

        btnAddMenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAddMenu.setText("Add");
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        lblNotification.setText("Notification");

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))))
                    .addComponent(btnRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(471, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogOut)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRead))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(121, 121, 121)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj : container) { 
                Order rd = (Order) obj;
                if (rd.getVendorName().equals(vendor.getName())) {
                    RevenueDashboardVendor r=new RevenueDashboardVendor(rd.getVendorID());
                    r.setVisible(true);
                    break;  
                }
            }
        VendorFrame v=new VendorFrame();
        v.setVisible(false);
            
        
        
            
        
    }//GEN-LAST:event_btnRevenueActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        if (OrderRow != -1) { 
            for (Object obj : container) { //Finalise delivery order by plugging in extra properties
                Order OH = (Order) obj;
                if (OH.getId().equals(String.valueOf(OrderModel.getValueAt(OrderRow, 0)))) {
                    OrderDetail o=new OrderDetail(OH.getId(),OH.getFood(),OH.getTime(),OH.getRemark(),OH.getStatus());
                    o.isVisible();
                    break; //Break out of the loop once done since only one order should be edited at a time
                }
            }
            
        }
        VendorFrame v=new VendorFrame();
        v.setVisible(false);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        if (MenuRow != -1) {
            List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
            for (Object obj : container2) { //Finalise delivery order by plugging in extra properties
                Food menu = (Food) obj;
                if (menu.getId().equals(String.valueOf(MenuModel.getValueAt(MenuRow, 0)))) {
                    menu.getId();
                    menu.setDescription(String.valueOf(MenuModel.getValueAt(MenuRow, 1)));
                    menu.setCost(Double.parseDouble(String.valueOf(MenuModel.getValueAt(MenuRow, 2))));
                    TextEditor.textDelete(TextEditor.FilePaths.HISTORY, menu);
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, menu);     //Rewrite it all back
                    break; //Break out of the loop once done since only one menu should be edited at a time
                }
            }
        }    
    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void MenuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTableMouseClicked
        MenuRow=MenuTable.getSelectedRow();
        
    }//GEN-LAST:event_MenuTableMouseClicked

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        OrderRow=OrderTable.getSelectedColumn();
    }//GEN-LAST:event_OrderTableMouseClicked

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        List<Object> container3 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container3) { 
                Notification n = (Notification) obj;
                if (n.getOrderID().equals(OrderModel.getValueAt(OrderRow, 0))) {        //compare orderID in ordertable
                    lblNotification.setText(n.getMessage());                                //get message.order
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);    //Rewrite it all back
                    break; 
                }
            }
    }//GEN-LAST:event_btnReadActionPerformed

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
            java.util.logging.Logger.getLogger(VendorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MenuTable;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMenu1;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
