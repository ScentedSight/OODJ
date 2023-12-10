 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.ArrayList;
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
   
    private DefaultTableModel model3 = new DefaultTableModel();
    private String[] column3 = {"No", "ID", "Notifications", "Time"};
    private int row3 = -1;
    
    private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    
    private Customer customer;
    
    private ButtonGroup remarkGroup = new ButtonGroup();
    
    private String remark;
    
    
    /**
     * Creates new form Menu
     */
    public C_MenuFrame(){}
    
    public C_MenuFrame(Customer customer) {
        initComponents();
        bNotificationReceived.setEnabled(false); //Grey out buttons
        bNotificationAcknowledged.setEnabled(false);
        this.customer = customer;
        model.setColumnIdentifiers(column);
        model2.setColumnIdentifiers(column2);
        model3.setColumnIdentifiers(column3);
        balance.setText(String.valueOf(customer.getBal()));
        username.setText(customer.getId());
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
            if (object instanceof Vendor) {
                Vendor vendor = (Vendor) object;
                String vendorName = vendor.getName();
                vendors.add(vendorName);
            }
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
    
    private void displayNotification() { //Display notifications function
        int counter = 1;
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container) {
            Notification notifyObj = (Notification) obj;
            if (notifyObj.getUser().equals(customer.getId())) {
                String[] notifyContainer = {String.valueOf(counter), notifyObj.getOrderID() + "\n" + notifyObj.getMessageRunner(), notifyObj.getMessage(), notifyObj.getTime()};
                model3.addRow(notifyContainer);
                counter++;
            }
            if (notifyObj.getUser().equals(customer.getId()) && notifyObj.getMessage().equals("You have successfully topped up ")) {
                String[] notifyContainer = {String.valueOf(counter), notifyObj.getReceiptID(), notifyObj.getMessage() + notifyObj.getTopupamount() + " on " + notifyObj.getDate(), notifyObj.getTime()};
                model3.addRow(notifyContainer);
                counter++;
            }
        }
    }
    
    private void deleteNotification() { //Acknowledge notifications function
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container) {
            Notification notification = (Notification) obj;
            if (notification.getReceiptID().equals(model3.getValueAt(row3, 1)) || notification.getOrderID().equals(model3.getValueAt(row3, 1))) {
                TextEditor.textDelete(TextEditor.FilePaths.USER, notification);
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
        bLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Notification = new javax.swing.JTable();
        bNotificationReceived = new javax.swing.JButton();
        bNotificationAcknowledged = new javax.swing.JButton();
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

        bTransactionHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bTransactionHistory.setForeground(new java.awt.Color(0, 0, 255));
        bTransactionHistory.setText("Transaction History >");
        bTransactionHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTransactionHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bTransactionHistoryMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bTransactionHistoryMousePressed(evt);
            }
        });
        bTransactionHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTransactionHistoryActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        username.setText(" ");

        bOrderHistory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bOrderHistory.setForeground(new java.awt.Color(0, 0, 255));
        bOrderHistory.setText("Order History");
        bOrderHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bOrderHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bOrderHistoryMousePressed(evt);
            }
        });
        bOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrderHistoryActionPerformed(evt);
            }
        });

        jUsername.setForeground(new java.awt.Color(255, 255, 255));
        jUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jUsername.setText("Username");

        bLogOut.setText("Log Out");
        bLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bLogOutMousePressed(evt);
            }
        });
        bLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogOutActionPerformed(evt);
            }
        });

        Notification.setModel(model3);
        Notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NotificationMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Notification);

        bNotificationReceived.setText("Food Received");
        bNotificationReceived.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bNotificationReceivedMousePressed(evt);
            }
        });
        bNotificationReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNotificationReceivedActionPerformed(evt);
            }
        });

        bNotificationAcknowledged.setText("Acknowledged");
        bNotificationAcknowledged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNotificationAcknowledgedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jUsername)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTitle)
                                .addGap(83, 83, 83)
                                .addComponent(bLogOut))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bNotificationReceived, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bNotificationAcknowledged, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bNotificationReceived)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNotificationAcknowledged))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bLogOut))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBalance)
                                .addComponent(jUsername))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(balance)
                                .addComponent(username))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bOrderHistory)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CurrentOrderMousePressed(evt);
            }
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
        bPlaceOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bPlaceOrderMousePressed(evt);
            }
        });
        bPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPlaceOrderActionPerformed(evt);
            }
        });

        bCancelOrder.setText("Cancel Order");
        bCancelOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bCancelOrderMousePressed(evt);
            }
        });
        bCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelOrderActionPerformed(evt);
            }
        });

        bReviews.setText("Reviews");
        bReviews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bReviewsMousePressed(evt);
            }
        });
        bReviews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReviewsActionPerformed(evt);
            }
        });

        tfNumber.setEditable(false);

        tfDetails.setEditable(false);

        tfPrice.setEditable(false);

        bAddQuantity.setText("+");
        bAddQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bAddQuantityMousePressed(evt);
            }
        });
        bAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddQuantityActionPerformed(evt);
            }
        });

        bReduceQuantity.setText("-");
        bReduceQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bReduceQuantityMousePressed(evt);
            }
        });
        bReduceQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReduceQuantityActionPerformed(evt);
            }
        });

        tfQuantity.setEditable(false);
        tfQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQuantity.setText("1");

        jLabel1.setText("RM");

        Menu.setModel(model);
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(Menu);

        tfOrderID.setEditable(false);

        tfCurrentOrderDetails.setEditable(false);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jMenu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbDineIn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bReduceQuantity)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bAddQuantity)))
                        .addGap(189, 189, 189)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCurrentOrder)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bReviews))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(bCancelOrder))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(tfCurrentOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(bPlaceOrder)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMenu)
                    .addComponent(jCurrentOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAddQuantity)
                    .addComponent(bReduceQuantity)
                    .addComponent(tfCurrentOrderDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bPlaceOrder))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bReviews)
                            .addComponent(bCancelOrder)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rbDineIn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTakeAway)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDelivery)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NotificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationMousePressed
        row3 = Notification.getSelectedRow();
        String selector = String.valueOf(model3.getValueAt(row3, 1));
        String selector2 = String.valueOf(model3.getValueAt(row3, 2));
        if (row3 != -1) {
            if (selector.contains("O") && (selector2.contains("READY") || selector2.contains("CANCELED"))) { //Check for order ID identifier which starts with O and only allowing 3 statuses of ready and canceled to make the food received button available
                bNotificationReceived.setEnabled(true); //Make the food received button available
            } else if (selector.contains("R")) {//Check for receipt ID identifier which starts with R
                bNotificationAcknowledged.setEnabled(true); //Make the receipt acknowledge button available
            }
        }
    }//GEN-LAST:event_NotificationMousePressed

    private void bNotificationAcknowledgedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNotificationAcknowledgedActionPerformed
        if (bNotificationAcknowledged.isEnabled()) {
            deleteNotification();
        }    
    }//GEN-LAST:event_bNotificationAcknowledgedActionPerformed

    private void bTransactionHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTransactionHistoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bTransactionHistoryMouseClicked

    private void bTransactionHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTransactionHistoryMousePressed
        C_TransactionHistory transactionHistoryFrame = new C_TransactionHistory(customer);
        transactionHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        transactionHistoryFrame.setVisible(true);
    }//GEN-LAST:event_bTransactionHistoryMousePressed

    private void bOrderHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOrderHistoryMousePressed
        C_OrderHistory orderHistoryFrame = new C_OrderHistory(customer);
        orderHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        orderHistoryFrame.setVisible(true);
    }//GEN-LAST:event_bOrderHistoryMousePressed

    private void bReviewsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReviewsMousePressed
        C_Reviews reviewsFrame = new C_Reviews();
        reviewsFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        reviewsFrame.setVisible(true);
       
        reviewsFrame.setFoodNameText(tfDetails.getText(), String.valueOf(cbCuisine.getSelectedItem()));
    }//GEN-LAST:event_bReviewsMousePressed

    private void CurrentOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentOrderMousePressed
            row2 = CurrentOrder.getSelectedRow();
            String orderID = String.valueOf(model2.getValueAt(row2, 0));
            String details = String.valueOf(model2.getValueAt (row2, 1));
            String quantity = String.valueOf(model2.getValueAt (row2, 2));
            String total = String.valueOf(model2.getValueAt (row2, 3));
            String status = String.valueOf(model2.getValueAt (row2, 4));

            tfOrderID.setText(orderID);
            tfCurrentOrderDetails.setText(details);
    }//GEN-LAST:event_CurrentOrderMousePressed

    private void bCancelOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelOrderMousePressed
        deleteCurrentOrder();
    }//GEN-LAST:event_bCancelOrderMousePressed

    private void bPlaceOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPlaceOrderMousePressed
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
        
        Notification notification = new Notification(String.valueOf(cbCuisine.getSelectedItem()), customer, order.getId());
        TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification);  
    }//GEN-LAST:event_bPlaceOrderMousePressed

    private void MenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMousePressed
        row = Menu.getSelectedRow();
        String number = String.valueOf(model.getValueAt(row, 0));
        String details = String.valueOf(model.getValueAt (row, 1));
        String price = String.valueOf(model.getValueAt (row, 2));
        
        tfNumber.setText(number);
        tfDetails.setText(details);
        tfPrice.setText(price);
        
        calculateTotal();
    }//GEN-LAST:event_MenuMousePressed

    private void bNotificationReceivedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNotificationReceivedMousePressed
        if (bNotificationReceived.isEnabled()) {
            deleteNotification();
        }
    }//GEN-LAST:event_bNotificationReceivedMousePressed

    private void bLogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogOutMousePressed
        Login_Page LP = new Login_Page();
        LP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bLogOutMousePressed

    private void bAddQuantityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddQuantityMousePressed
        addQuantity();
    }//GEN-LAST:event_bAddQuantityMousePressed

    private void bReduceQuantityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReduceQuantityMousePressed
        minusQuantity();
    }//GEN-LAST:event_bReduceQuantityMousePressed

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
    private javax.swing.JTable Notification;
    private javax.swing.JButton bAddQuantity;
    private javax.swing.JButton bCancelOrder;
    private javax.swing.JButton bLogOut;
    private javax.swing.JButton bNotificationAcknowledged;
    private javax.swing.JButton bNotificationReceived;
    private javax.swing.JButton bOrderHistory;
    private javax.swing.JButton bPlaceOrder;
    private javax.swing.JButton bReduceQuantity;
    private javax.swing.JButton bReviews;
    private javax.swing.JButton bTransactionHistory;
    private javax.swing.JLabel balance;
    private javax.swing.JComboBox<String> cbCuisine;
    private javax.swing.JLabel jBalance;
    private javax.swing.JLabel jCurrentOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jTitle;
    private javax.swing.JLabel jUsername;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JRadioButton rbDineIn;
    private javax.swing.JRadioButton rbTakeAway;
    private javax.swing.JTextField tfCurrentOrderDetails;
    private javax.swing.JTextField tfDetails;
    private javax.swing.JTextField tfNumber;
    private javax.swing.JTextField tfOrderID;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
