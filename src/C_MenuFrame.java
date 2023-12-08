 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class C_MenuFrame extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] column = {"VID", "Details", "Price"};
    private int row = -1;
    
    private DefaultTableModel model2 = new DefaultTableModel();
    private String[] column2 = {"OrderID", "Details", "Total", "Status"};
    private int row2 = -1;
    
    private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    
    private double originalPrice;
    
    private Customer customer;
    
    private Notification notification;
    
    private ButtonGroup remarkGroup = new ButtonGroup();
    
    private String remark;
    
    
    /**
     * Creates new form Menu
     */
    public C_MenuFrame(){}
    
    public C_MenuFrame(Customer customer) {
        initComponents();
        this.customer = customer;
        model.setColumnIdentifiers(column);
        model2.setColumnIdentifiers(column2);
        balance.setText(String.valueOf(customer.getBal()));
        username.setText(customer.getId());
        tfNID.setText(notification.getOrderID());
        populateMenuTable();
        populateCurrentOrderTable();
        populateComboBox();
        displayNotification();
        
        remarkGroup.add(rbDineIn);
        remarkGroup.add(rbTakeAway);
        remarkGroup.add(rbDelivery);
    }
    
    private void populateComboBox() {
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.USER));

        List<String> vendors = new ArrayList<>();

        for (Object object: container) {
             Vendor vendor = (Vendor) object;
             String vendorName = vendor.getName();
             vendors.add(vendorName);

             comboBoxModel.addAll(vendors);
        }
    }
    
    private void populateMenuTable() {
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.MENU));
        
        for (Object object: container) {
            Food food = (Food) object;
            
            if (food.getVendor().equals(String.valueOf(cbCuisine.getSelectedItem()))){
                String[] menu = {food.getVendorId(), food.getDescription(), String.valueOf(food.getCost())};
                model.addRow(menu);
            }
        }
        
    }
    
    private void populateCurrentOrderTable() {
        // Specify the path to your menu text file
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY)); 
        
        for (Object object: container){
            Order order = (Order) object;
            if (order.getStatus().equals("PENDING") && order.getCustomerID().equals(customer.getId())) {
                String[] currentOrder = {order.getId(), order.getFood(), String.valueOf(order.getTotal()), String.valueOf(order.getStatus())};
                model2.addRow(currentOrder);
            }
        }    
    }
    
    private void deleteCurrentOrder() {
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY)); 
        
        for (Object object: container){
            Order orderDelete = (Order) object;

            if (tfOrderID.getText().equals(orderDelete.getId())) {
                orderDelete.setStatus(Order.Status.CANCELLED);
                reader.textDelete(TextEditor.FilePaths.HISTORY, orderDelete);
                reader.fileWrite(TextEditor.FilePaths.HISTORY, orderDelete);
            }
        }
    }
    
    
    private void addQuantity() {
        String currentText = tfQuantity.getText();
        int currentValue = Integer.parseInt(currentText);
        int newValue = currentValue + 1;
        tfQuantity.setText(Integer.toString(newValue));
    }
    
    private void minusQuantity() {
        String currentText = tfQuantity.getText();
        int currentValue = Integer.parseInt(currentText);
        int newValue = currentValue - 1;
        tfQuantity.setText(Integer.toString(newValue));
    }
        
    private void calculateTotal() {
        String currentPrice = tfPrice.getText();
        double doublePrice = Double.parseDouble(currentPrice);
        double newPrice = doublePrice * Double.parseDouble(tfQuantity.getText());
        tfPrice.setText(Double.toString(newPrice));
    }

    private String getRemark(){
        if (rbDineIn.isSelected()) {
            remark = "Dine In";
        }
        else if (rbTakeAway.isSelected()) {
            remark = "Take Away";
        }
        else {
            remark = "Delivery";
        }
        return remark;
    }
    
    private void displayNotification() { 
        int counter = 1;
        String notification = "";
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container) {
            Notification notifyObj = (Notification) obj;
            if (notifyObj.getUser().equals(customer.getId())) {
                String placeHolder = notifyObj.getMessage();
                notification = notification + "   " + counter + ". " +placeHolder;
                counter++;
            }
        }
        tfNotification.setText(notification);
    }
    
    private void deleteNotification() {
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container) {
            Notification dNotify = (Notification) obj;
            if(tfNID.getText().equals(dNotify.getOrderID())) {
                TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, dNotify);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jBalance = new javax.swing.JLabel();
        bTransactionHistory = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        bOrderHistory = new javax.swing.JButton();
        jUsername = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbCuisine = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        CurrentOrder = new javax.swing.JTable();
        jMenu = new javax.swing.JLabel();
        jCurrentOrder = new javax.swing.JLabel();
        bPlaceOrder = new javax.swing.JButton();
        bCancelOrder = new javax.swing.JButton();
        bReviews = new javax.swing.JButton();
        tfNumber = new javax.swing.JTextField();
        tfDetails = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        bAddQuantity = new javax.swing.JButton();
        bReduceQuantity = new javax.swing.JButton();
        tfQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Menu = new javax.swing.JTable();
        tfOrderID = new javax.swing.JTextField();
        tfCurrentOrderDetails = new javax.swing.JTextField();
        rbDineIn = new javax.swing.JRadioButton();
        rbTakeAway = new javax.swing.JRadioButton();
        rbDelivery = new javax.swing.JRadioButton();
        tfNotification = new javax.swing.JTextField();
        b_notification = new javax.swing.JButton();
        tfNID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTitle.setForeground(new java.awt.Color(255, 255, 255));
        jTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitle.setText("WELCOME TO TECH UNIVERSITY CAFETERIA");

        balance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                balanceComponentShown(evt);
            }
        });

        jBalance.setForeground(new java.awt.Color(255, 255, 255));
        jBalance.setText("Balance");

        bTransactionHistory.setBackground(new java.awt.Color(255, 255, 255));
        bTransactionHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bTransactionHistory.setForeground(new java.awt.Color(0, 0, 255));
        bTransactionHistory.setText("Transaction History >");
        bTransactionHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTransactionHistoryActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setText(" ");

        bOrderHistory.setBackground(new java.awt.Color(255, 255, 255));
        bOrderHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bOrderHistory.setForeground(new java.awt.Color(0, 0, 255));
        bOrderHistory.setText("Order History");
        bOrderHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrderHistoryActionPerformed(evt);
            }
        });

        jUsername.setForeground(new java.awt.Color(255, 255, 255));
        jUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jUsername.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(bTransactionHistory)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bOrderHistory))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jBalance)
                            .addGap(280, 280, 280)
                            .addComponent(jUsername))))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBalance)
                    .addComponent(jUsername))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance)
                    .addComponent(username))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bOrderHistory))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbCuisine.setModel(comboBoxModel);
        cbCuisine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuisineActionPerformed(evt);
            }
        });

        CurrentOrder.setModel(model2);
        CurrentOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CurrentOrderMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(CurrentOrder);

        jMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu.setForeground(new java.awt.Color(0, 0, 255));
        jMenu.setText("MENU");

        jCurrentOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCurrentOrder.setForeground(new java.awt.Color(0, 0, 255));
        jCurrentOrder.setText("Current Order");

        bPlaceOrder.setText("Place Order");
        bPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlaceOrderActionPerformed(evt);
            }
        });

        bCancelOrder.setText("Cancel Order");
        bCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelOrderActionPerformed(evt);
            }
        });

        bReviews.setText("Reviews");
        bReviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReviewsActionPerformed(evt);
            }
        });

        bAddQuantity.setText("+");
        bAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddQuantityActionPerformed(evt);
            }
        });

        bReduceQuantity.setText("-");
        bReduceQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReduceQuantityActionPerformed(evt);
            }
        });

        tfQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQuantity.setText("1");

        jLabel1.setText("RM");

        Menu.setModel(model);
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Menu);

        rbDineIn.setText("Dine in");
        rbDineIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDineInActionPerformed(evt);
            }
        });

        rbTakeAway.setText("Take Away");
        rbTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTakeAwayActionPerformed(evt);
            }
        });

        rbDelivery.setText("Delivery");
        rbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDeliveryActionPerformed(evt);
            }
        });

        b_notification.setText("OK");
        b_notification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_notificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jMenu)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCurrentOrder)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCurrentOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCancelOrder))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbDineIn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bReviews)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bPlaceOrder)
                                .addGap(161, 161, 161))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(1, 1, 1)
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bReduceQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bAddQuantity))
                                    .addComponent(rbTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(b_notification)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCurrentOrder)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jMenu)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReduceQuantity)
                    .addComponent(bAddQuantity)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelOrder)
                    .addComponent(jLabel1)
                    .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCurrentOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPlaceOrder)
                    .addComponent(bReviews)
                    .addComponent(rbDineIn))
                .addGap(0, 0, 0)
                .addComponent(rbTakeAway)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDelivery)
                    .addComponent(tfNotification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_notification)
                    .addComponent(tfNID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTransactionHistoryActionPerformed
        // TODO add your handling code here:
        C_TransactionHistory transactionHistoryFrame = new C_TransactionHistory();
        transactionHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        transactionHistoryFrame.setVisible(true);
    }//GEN-LAST:event_bTransactionHistoryActionPerformed

    private void cbCuisineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuisineActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        populateMenuTable();
    }//GEN-LAST:event_cbCuisineActionPerformed

    private void balanceComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_balanceComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceComponentShown

    private void bOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrderHistoryActionPerformed
        // TODO add your handling code here:
        C_OrderHistory orderHistoryFrame = new C_OrderHistory();
        orderHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        orderHistoryFrame.setVisible(true);
    }//GEN-LAST:event_bOrderHistoryActionPerformed

    private void bReviewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReviewsActionPerformed
        // TODO add your handling code here:
        C_Reviews reviewsFrame = new C_Reviews();
        reviewsFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        reviewsFrame.setVisible(true);
       
        reviewsFrame.setFoodNameText(tfDetails.getText(), String.valueOf(cbCuisine.getSelectedItem()));
        
    }//GEN-LAST:event_bReviewsActionPerformed

    private void bAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddQuantityActionPerformed
        // TODO add your handling code here:
        addQuantity();
    }//GEN-LAST:event_bAddQuantityActionPerformed

    private void bReduceQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReduceQuantityActionPerformed
        // TODO add your handling code here:
        minusQuantity();
    }//GEN-LAST:event_bReduceQuantityActionPerformed

    private void CurrentOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentOrderMouseReleased
        // TODO add your handling code here:
        row2 = CurrentOrder.getSelectedRow();
        String orderID = String.valueOf(model2.getValueAt(row2, 0));
        String details = String.valueOf(model2.getValueAt (row2, 1));
        String quantity = String.valueOf(model2.getValueAt (row2, 2));
        String total = String.valueOf(model2.getValueAt (row2, 3));
        String status = String.valueOf(model2.getValueAt (row2, 4));
        
        tfOrderID.setText(orderID);
        tfCurrentOrderDetails.setText(details);
    }//GEN-LAST:event_CurrentOrderMouseReleased

    private void bCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelOrderActionPerformed
        // TODO add your handling code here:
        deleteCurrentOrder();
    }//GEN-LAST:event_bCancelOrderActionPerformed

    private void bPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlaceOrderActionPerformed
        // TODO add your handling code here:
        Order order = new Order(tfNumber.getText(),String.valueOf(cbCuisine.getSelectedItem()), customer, tfDetails.getText(), Double.parseDouble(tfPrice.getText()));
        
        TextEditor reader = new TextEditor();
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY));
        
        for (Object object: container) {
            Order placeOrder = (Order) object;
            
            tfNumber.getText();
            String.valueOf(cbCuisine.getSelectedIndex());
            placeOrder.getCustomer();
            tfDetails.getText();
            Double.parseDouble(tfPrice.getText());
            getRemark();
            String review = "";
            int rating = 0;
            String date = placeOrder.getOrderDay()+"/"+placeOrder.getOrderMonth()+"/"+placeOrder.getOrderYear();
            placeOrder.getTime();
            placeOrder.setStatus(Order.Status.PENDING);
            placeOrder.getId();
            
            break;
        }
        
        Notification notification = new Notification(customer, order.getId());
        notification.setMessage(Notification.Messages.ORDER);
        
        TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification);
        
        
    }//GEN-LAST:event_bPlaceOrderActionPerformed

    private void MenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseReleased
        // TODO add your handling code here:
        row = Menu.getSelectedRow();
        String number = String.valueOf(model.getValueAt(row, 0));
        String details = String.valueOf(model.getValueAt (row, 1));
        String price = String.valueOf(model.getValueAt (row, 2));
        
        tfNumber.setText(number);
        tfDetails.setText(details);
        tfPrice.setText(price);
        
        calculateTotal();
    }//GEN-LAST:event_MenuMouseReleased

    private void rbDineInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDineInActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbDineInActionPerformed

    private void rbTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTakeAwayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbTakeAwayActionPerformed

    private void rbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDeliveryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDeliveryActionPerformed

    private void b_notificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_notificationActionPerformed
        // TODO add your handling code here:
        deleteNotification();
    }//GEN-LAST:event_b_notificationActionPerformed

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
            java.util.logging.Logger.getLogger(C_MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_MenuFrame().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CurrentOrder;
    private javax.swing.JTable Menu;
    private javax.swing.JButton bAddQuantity;
    private javax.swing.JButton bCancelOrder;
    private javax.swing.JButton bOrderHistory;
    private javax.swing.JButton bPlaceOrder;
    private javax.swing.JButton bReduceQuantity;
    private javax.swing.JButton bReviews;
    private javax.swing.JButton bTransactionHistory;
    private javax.swing.JButton b_notification;
    private javax.swing.JLabel balance;
    private javax.swing.JComboBox<String> cbCuisine;
    private javax.swing.JLabel jBalance;
    private javax.swing.JLabel jCurrentOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jTitle;
    private javax.swing.JLabel jUsername;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JRadioButton rbDineIn;
    private javax.swing.JRadioButton rbTakeAway;
    private javax.swing.JTextField tfCurrentOrderDetails;
    private javax.swing.JTextField tfDetails;
    private javax.swing.JTextField tfNID;
    private javax.swing.JTextField tfNotification;
    private javax.swing.JTextField tfNumber;
    private javax.swing.JTextField tfOrderID;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
