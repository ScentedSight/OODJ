
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private Time time;
    private String[] MenuColumn={"FoodID","Description","Price"};
    private String[] OrderList={"OrderID","Time", "Quantity" ,"Status"};
    private int MenuRow = -1; 
    private int OrderRow = -1;    
    private Food food = new Food();
    private Order order = new Order();
    
    public VendorFrame(){  //Default constructor for testing
        initComponents();
        MenuModel.setColumnIdentifiers(MenuColumn);
        OrderModel.setColumnIdentifiers(OrderList);
        VendorFrame vf =new VendorFrame();
    }
    
    public VendorFrame(Vendor vendor) {
        initComponents();
        this.vendor=vendor;
        lblWelcome.setText("Welcome " + vendor.getId());            //welcome vendor
        MenuModel.setColumnIdentifiers(MenuColumn); 
        OrderModel.setColumnIdentifiers(OrderList);
        setTitle("Vendor HomePage");
        
        
        displayMenu();
        displayOrder();
        displayNotification();
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
        btnEditMenu = new javax.swing.JButton();
        lblNotification = new javax.swing.JLabel();
        btnRead = new javax.swing.JButton();
        btnAddMenu = new javax.swing.JButton();
        textFoodName = new javax.swing.JTextField();
        textCost = new javax.swing.JTextField();
        btnDeleteMenu = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogOut.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLogOut.setText("LogOut");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

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
        OrderTable.setColumnSelectionAllowed(true);
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(OrderTable);
        OrderTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblMenu1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMenu1.setText("Menu");

        btnEditMenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEditMenu.setText("Edit");
        btnEditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMenuActionPerformed(evt);
            }
        });

        lblNotification.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNotification.setText("Notification");

        btnRead.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnAddMenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAddMenu.setText("Add");
        btnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMenuActionPerformed(evt);
            }
        });

        textFoodName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textFoodName.setText("Food");
        textFoodName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFoodNameActionPerformed(evt);
            }
        });

        textCost.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        textCost.setText("Cost");
        textCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCostActionPerformed(evt);
            }
        });

        btnDeleteMenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDeleteMenu.setText("Delete");
        btnDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMenuActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRead)
                                .addGap(132, 132, 132)
                                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMenu1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDeleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCost, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRevenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevenueActionPerformed
        Vendor_Revenue_Dashboard r = new Vendor_Revenue_Dashboard(vendor);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRevenueActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        if (order.getId() != null) { 
            Vendor_Order_Detail o = new Vendor_Order_Detail();
            for (Object obj : container) { //Finalise delivery order by plugging in extra properties
                Order OH = (Order) obj;
                if (OH.getId().equals(order.getId())) {
                    o = new Vendor_Order_Detail(vendor, OH.getId(), OH.getFood(), OH.getCustomerID(), OH.getTime(),  OH.getRemark(), OH.getStatus(), String.valueOf(OH.getCost()), OH.getQuantity());
                    break; //Break out of the loop once done since only one order should be edited at a time
                }
            }
            o.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Please select an order.","Warning",JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnEditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMenuActionPerformed
        List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        int row = MenuTable.getSelectedRow();
        if (row >= 0 && row < container2.size()) {
            Food existingMenu = (Food) container2.get(row);
            // Update the properties of the selected menu based on the table values
            String selectedFoodId = food.getId();
            if(existingMenu.getId().equals(selectedFoodId)){
                String foodName = textFoodName.getText();
                double foodCost = Double.parseDouble(textCost.getText());
                Food updatedFood = new Food(vendor,foodName, foodCost);
                if (existingMenu.getDescription().equals(textFoodName.getText())){
                    JOptionPane.showMessageDialog(null, "Food is exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                // Rewrite the entire list back to the file
                TextEditor.textDelete(TextEditor.FilePaths.MENU, existingMenu); // Delete the existing file
                TextEditor.fileWrite(TextEditor.FilePaths.MENU, updatedFood); // Rewrite the entire list back to the file
                JOptionPane.showMessageDialog(null, "Record Updated!");
                displayMenu(); // Assuming this method updates the JTable
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid row selection.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditMenuActionPerformed

    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        OrderTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) { // Check for single-click
                int row = OrderTable.getSelectedRow();
                if (row >= 0) {
                    order.setId(String.valueOf(OrderTable.getValueAt(row, 0)));
                }
            }
        }
    });
    }//GEN-LAST:event_OrderTableMouseClicked

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        List<Object> container3 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container3) { 
            Notification n = (Notification) obj;
            if (lblNotification.getText().contains(n.getId())) {       
                n.setVendorID(null); //Remove vendor ID from notification to clear it
                TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, n);
                TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, n);
                break; 
            }
        }
        displayNotification();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Login_Page LP = new Login_Page();
        LP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMenuActionPerformed
        boolean checker = false;
        List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        for (Object obj : container2) {
            Food menu = (Food) obj;
            if (menu.getVendorId().equals(vendor.getId()) && menu.getDescription().equals(textFoodName.getText())) { //Check for whether if there are same food description under same vendor
                checker = true; //Flag checker to true to avoid executing the write process
                JOptionPane.showMessageDialog(null,"Food is exist.","Warning",JOptionPane.WARNING_MESSAGE);
                break; //Stop the loop to speed up the process
            }
        }
        if (!checker) { //Proceed to write object to textfile
            Food food = new Food(vendor, textFoodName.getText(), Double.parseDouble(textCost.getText())); //Make new food object
            TextEditor.fileWrite(TextEditor.FilePaths.MENU, food); //Write to textfile
            JOptionPane.showMessageDialog(null,"Food is Added!.");
            displayMenu();
        }
    }//GEN-LAST:event_btnAddMenuActionPerformed

    private void MenuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTableMouseClicked
        MenuTable.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) { // Check for single-click
                int row = MenuTable.getSelectedRow();
                if (row >= 0) {
                    // Get data from the selected row and set it in your text fields
                    food.setId(String.valueOf(MenuTable.getModel().getValueAt(row, 0))); 
                    textFoodName.setText(String.valueOf(MenuTable.getModel().getValueAt(row, 1)));
                    textCost.setText(String.valueOf(MenuTable.getModel().getValueAt(row, 2)));
                }
            }
        }
    });

    }//GEN-LAST:event_MenuTableMouseClicked

    private void textFoodNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFoodNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFoodNameActionPerformed

    private void textCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCostActionPerformed

    private void btnDeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMenuActionPerformed
        List<Object> container2 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        int row = MenuTable.getSelectedRow();
        if (row >= 0 && row < container2.size()) {
            Food existingMenu = (Food) container2.get(row);
            if(existingMenu.getId().equals(food.getId())){
                TextEditor.textDelete(TextEditor.FilePaths.MENU, existingMenu); // Delete the existing file
                JOptionPane.showMessageDialog(null, "Record Deleted!");
                displayMenu(); // Assuming this method updates the JTable
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid row selection.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteMenuActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        displayOrder();
        displayNotification();
    }//GEN-LAST:event_btnRefreshActionPerformed

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
    
    public void displayMenu(){
        List<DataProvider> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        MenuModel.setRowCount(0);
        for (DataProvider obj : container) {
            Food menu = (Food) obj;
            if(menu.getVendorId().equals(vendor.getId())){
                String[] MenuArray = {
                menu.getId(),     //get FoodID
                menu.getDescription(),                      //get Food Name
                Double.toString(menu.getCost()),          //get Food Cost
                };
                MenuModel.addRow(MenuArray);
            }
        }
    }
    
    public void displayOrder(){
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        OrderModel.setRowCount(0);
        for (Object obj1 : container) { //change obj name
            Order O = (Order) obj1;
            if(O.getVendorID().equals(vendor.getId())){
                String status= O.getStatus();     
                if (!status.equals("PICKED_UP") && !status.equals("COMPLETED") && 
                        !status.equals("CANCELLED")) {
                    String[] OrderVendorArray = {
                        O.getId(),          //get OrderID
                        O.getTime(),        //get Order Time
                        String.valueOf(O.getQuantity()), //get quantity
                        status,             //get Order Status
                };
                OrderModel.addRow(OrderVendorArray);        //add data
            }
            }            
        }
    }
    
    private void displayNotification() { //Display notification  int counter = 1;
        String notification = "";
        List<Object> container3 = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container3) {
            Notification n = (Notification) obj;
            if ((n.getVendorID() != null && n.getVendorID().equals(vendor.getName())) && (n.getMessage().contains("You have an incoming order") || n.getMessage().contains("The order has been canceled"))) { //Making sure its not null so error wont pop out
                notification = n.getTime()+ " [" + n.getId() + "]" + n.getMessage();
            }
        }
        lblNotification.setText(notification);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MenuTable;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton btnAddMenu;
    private javax.swing.JButton btnDeleteMenu;
    private javax.swing.JButton btnEditMenu;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRevenue;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMenu1;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField textCost;
    private javax.swing.JTextField textFoodName;
    // End of variables declaration//GEN-END:variables
}
