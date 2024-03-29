import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
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
    private String[] column2 = {"OrderID", "Details", "Quantity", "Total", "Status"};
    private int row2 = -1;
   
    private DefaultTableModel model3 = new DefaultTableModel();
    private String[] column3 = {"No", "ID", "Messages", "Time"};
    private int row3 = -1;
    
    private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    
    private Customer customer;

    private ButtonGroup remarkGroup = new ButtonGroup();
    
    
    public C_MenuFrame(){}
    
    public C_MenuFrame(Customer customer) {
        initComponents(); 
        bNotificationAcknowledged.setEnabled(false);//Grey out buttons
        bFoodReceived.setEnabled(false);
        this.customer = customer;
        model.setColumnIdentifiers(column);
        model2.setColumnIdentifiers(column2);
        model3.setColumnIdentifiers(column3);
        balance.setText(String.valueOf(customer.getBal()));
        lblUsername.setText(customer.getId());
        
        populateCurrentOrderTable();
        populateComboBox();
        populateMenuTable();
        displayNotification();
        
        remarkGroup.add(rbDineIn);
        remarkGroup.add(rbTakeAway);
        remarkGroup.add(rbDelivery);
        rbDineIn.setSelected(true); //Make the first radio button selected default
    }
    
    private void reloadFrame() {
        List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.USER));
        for (Object obj : container) { //Reassign customer's balance
            if (obj instanceof Customer) {
                Customer customer = (Customer) obj;
                if (customer.getId().equals(this.customer.getId())) {
                    this.customer = customer;
                }  
            }
        }
        balance.setText(String.valueOf(customer.getBal()));
        populateCurrentOrderTable();
        populateMenuTable();
        displayNotification();
        bNotificationAcknowledged.setEnabled(false);
    }
    
    private List<Order> ViewReview(int row) { //To retrieve all orders related to a specific food from a specific vendor
        String retrieveVID = String.valueOf(model.getValueAt(row, 0));
        String retrieveFDesc = String.valueOf(model.getValueAt(row, 1));
        List<Object> reader = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        List<Order> container = new ArrayList<>();
        for (Object obj : reader) {
            if (obj instanceof DeliveryOrder) {
                DeliveryOrder order = (DeliveryOrder) obj;
                if ((order.getVendorID() + ":" + order.getFood()).equals(retrieveVID + ":" + retrieveFDesc) && (order.getReview() != null || order.getRatings() != 0)) { //Combination of vendor ID + food description = food ID
                    container.add(order); //Adds to the array list and return it for further processing
                }
            } else if (obj instanceof Order) {
                Order order = (Order) obj;
                if ((order.getVendorID() + ":" + order.getFood()).equals(retrieveVID + ":" + retrieveFDesc) && (order.getReview() != null || order.getRatings() != 0)) { //Combination of vendor ID + food description = food ID
                    container.add(order); //Adds to the array list and return it for further processing
                }
            }
        }
        return container;
    }
    
    private void populateComboBox() {
        comboBoxModel.removeAllElements(); //Remove everything first to prevent stacking
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.USER));
        List<String> vendors = new ArrayList<>();

        for (Object object: container) {
            if (object instanceof Vendor) {
                Vendor vendor = (Vendor) object;
                String vendorName = vendor.getName();
                vendors.add(vendorName);
            } 
        }
        comboBoxModel.addAll(vendors);
    }
    
    private void populateMenuTable() {
        model.setRowCount(0);
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.MENU));
        
        for (Object object: container) {
            Food food = (Food) object;
            
            if (food.getVendor().equals(String.valueOf(cbCuisine.getSelectedItem()))){
                String[] menu = {food.getVendorId(), food.getDescription(), String.valueOf(food.getCost())};
                model.addRow(menu);
            }
        }
    }

    private void populateCurrentOrderTable() {
        model2.setRowCount(0);
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object object : container) { // Load orders into the current order table
            if (object instanceof DeliveryOrder) {
                DeliveryOrder dOrder = (DeliveryOrder) object;
                if (dOrder.getCustomerID().equals(customer.getId())) {
                    if ((!dOrder.getStatus().equals("COMPLETED") && !dOrder.getStatus().equals("PICKED_UP")) && (dOrder.getStatusRunner().equals("SEARCHING") || dOrder.getStatusRunner().equals("DELIVERING") || dOrder.getStatusRunner().equals("DELIVERED"))) {
                        String[] currentOrder = {dOrder.getId(), dOrder.getFood(), String.valueOf(dOrder.getQuantity()), String.valueOf(dOrder.getCost()), String.valueOf(dOrder.getStatus())};
                        model2.addRow(currentOrder);
                    }
                }
            } else if (object instanceof Order) { // Load delivery orders into the current order table
                Order order = (Order) object;
                if (order.getCustomerID().equals(customer.getId())) { // Filters out completed, canceled, delivered, and pick-up status since they are only displayed in notification
                    if (order.getStatus().equals("PREPARING") || order.getStatus().equals("PENDING") || order.getStatus().equals("READY")) {
                        String[] currentOrder = {order.getId(), order.getFood(), String.valueOf(order.getQuantity()), String.valueOf(order.getCost()), String.valueOf(order.getStatus())};
                        model2.addRow(currentOrder);
                    }
                }
            }
        }
    }
        
    private void calculateTotal() {
        String currentPrice = tfPrice.getText();
        double doublePrice = Double.parseDouble(currentPrice);
        double newPrice = doublePrice * Double.parseDouble(tfQuantity.getText());
        tfPrice.setText(Double.toString(newPrice));
    }
    
    private void displayNotification() { //Display notifications function
        model3.setRowCount(0);
        int counter = 1;
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
        for (Object obj : container) {
            Notification notifyObj = (Notification) obj;
            if (notifyObj.getUser() != null && notifyObj.getUser().equals(customer.getId()) && (notifyObj.getMessage().contains("Your food is being prepared") || notifyObj.getMessage().contains("Your food is ready") || notifyObj.getMessage().contains("The order has been canceled"))) { //Filter to show only notification of food preparing, readied or canceled
                String[] notifyContainer = {String.valueOf(counter), notifyObj.getId(), notifyObj.getMessage(), notifyObj.getTime()};
                model3.addRow(notifyContainer);
                counter++;
            } else if (notifyObj.getUser() != null && notifyObj.getUser().equals(customer.getId()) && notifyObj.getMessageRunner() != null && (notifyObj.getMessageRunner().contains("Your food is delivering") || notifyObj.getMessageRunner().contains("Your food has been delivered") || notifyObj.getMessageRunner().contains("Searching for delivery runner"))) { //Filter to only show delivery notifications
                String[] notifyContainer = {String.valueOf(counter), notifyObj.getId(), notifyObj.getMessageRunner(), notifyObj.getTime()};
                model3.addRow(notifyContainer);
                counter++;
            } else if (notifyObj.getUser() != null && notifyObj.getUser().equals(customer.getId()) && notifyObj.getMessage().contains("You have successfully topped up ")) { //Filter to only show top up notifications
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
            if ((notification.getReceiptID() != null && notification.getReceiptID().equals(model3.getValueAt(row3, 1))) || (notification.getId() != null && notification.getId().equals(model3.getValueAt(row3, 1)))) {
                notification.setUserID(null); //Remove self from notification so it wouldnt appear
                TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, notification);
                TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification);
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

        pnlC_MenuFrame = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jBalance = new javax.swing.JLabel();
        bTransactionHistory = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        bOrderHistory = new javax.swing.JButton();
        jUsername = new javax.swing.JLabel();
        bLogOut = new javax.swing.JButton();
        pnlC_MenuFrameTables = new javax.swing.JPanel();
        cbCuisine = new javax.swing.JComboBox<>();
        scrlpnlC_MenuFrameCurrentOrderTable = new javax.swing.JScrollPane();
        CurrentOrder = new javax.swing.JTable();
        jMenu = new javax.swing.JLabel();
        jCurrentOrder = new javax.swing.JLabel();
        bPlaceOrder = new javax.swing.JButton();
        bCancelOrder = new javax.swing.JButton();
        tfNumber = new javax.swing.JTextField();
        tfDetails = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        bAddQuantity = new javax.swing.JButton();
        bReduceQuantity = new javax.swing.JButton();
        tfQuantity = new javax.swing.JTextField();
        lblC_MenuFramePrice = new javax.swing.JLabel();
        scrlpnlC_MenuFrameMenuTable = new javax.swing.JScrollPane();
        Menu = new javax.swing.JTable();
        rbDineIn = new javax.swing.JRadioButton();
        rbTakeAway = new javax.swing.JRadioButton();
        rbDelivery = new javax.swing.JRadioButton();
        scrlpnlC_MenuFrameNotification = new javax.swing.JScrollPane();
        Notification = new javax.swing.JTable();
        bFoodReceived = new javax.swing.JButton();
        bNotificationAcknowledged = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlC_MenuFrame.setBackground(new java.awt.Color(0, 0, 255));

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

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(255, 255, 255));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUsername.setText(" ");

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

        javax.swing.GroupLayout pnlC_MenuFrameLayout = new javax.swing.GroupLayout(pnlC_MenuFrame);
        pnlC_MenuFrame.setLayout(pnlC_MenuFrameLayout);
        pnlC_MenuFrameLayout.setHorizontalGroup(
            pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlC_MenuFrameLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlC_MenuFrameLayout.createSequentialGroup()
                        .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bTransactionHistory)
                            .addComponent(jBalance))
                        .addGap(118, 118, 118)
                        .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bOrderHistory)
                            .addComponent(jUsername)
                            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTitle))
                .addContainerGap())
        );
        pnlC_MenuFrameLayout.setVerticalGroup(
            pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlC_MenuFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBalance)
                    .addComponent(jUsername))
                .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlC_MenuFrameLayout.createSequentialGroup()
                        .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlC_MenuFrameLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlC_MenuFrameLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblUsername)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlC_MenuFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bTransactionHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bOrderHistory))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlC_MenuFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );

        pnlC_MenuFrameTables.setBackground(new java.awt.Color(255, 255, 255));

        cbCuisine.setModel(comboBoxModel);
        cbCuisine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuisineActionPerformed(evt);
            }
        });
        cbCuisine.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbCuisinePropertyChange(evt);
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
        scrlpnlC_MenuFrameCurrentOrderTable.setViewportView(CurrentOrder);

        jMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu.setForeground(new java.awt.Color(0, 0, 255));
        jMenu.setText("MENU (Double click the elements for review)");

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
        tfQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantityActionPerformed(evt);
            }
        });

        lblC_MenuFramePrice.setText("RM");

        Menu.setModel(model);
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuMouseReleased(evt);
            }
        });
        scrlpnlC_MenuFrameMenuTable.setViewportView(Menu);

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

        scrlpnlC_MenuFrameNotification.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notifications", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Notification.setModel(model3);
        Notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NotificationMousePressed(evt);
            }
        });
        scrlpnlC_MenuFrameNotification.setViewportView(Notification);

        bFoodReceived.setText("Food Received");
        bFoodReceived.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bFoodReceivedMousePressed(evt);
            }
        });
        bFoodReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFoodReceivedActionPerformed(evt);
            }
        });

        bNotificationAcknowledged.setText("Acknowledged");
        bNotificationAcknowledged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNotificationAcknowledgedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlC_MenuFrameTablesLayout = new javax.swing.GroupLayout(pnlC_MenuFrameTables);
        pnlC_MenuFrameTables.setLayout(pnlC_MenuFrameTablesLayout);
        pnlC_MenuFrameTablesLayout.setHorizontalGroup(
            pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                        .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbTakeAway, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                                        .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblC_MenuFramePrice))
                                    .addComponent(rbDineIn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bReduceQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bAddQuantity))
                                    .addComponent(bPlaceOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlC_MenuFrameTablesLayout.createSequentialGroup()
                                    .addComponent(jMenu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(scrlpnlC_MenuFrameMenuTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCurrentOrder)
                            .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlC_MenuFrameTablesLayout.createSequentialGroup()
                                    .addGap(181, 181, 181)
                                    .addComponent(bFoodReceived)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bCancelOrder))
                                .addComponent(scrlpnlC_MenuFrameCurrentOrderTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9))
                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                        .addComponent(scrlpnlC_MenuFrameNotification)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bNotificationAcknowledged)))
                .addGap(25, 25, 25))
        );
        pnlC_MenuFrameTablesLayout.setVerticalGroup(
            pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jMenu)
                    .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCurrentOrder)
                        .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlpnlC_MenuFrameMenuTable, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrlpnlC_MenuFrameCurrentOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblC_MenuFramePrice)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAddQuantity)
                    .addComponent(bReduceQuantity)
                    .addComponent(bCancelOrder)
                    .addComponent(bFoodReceived))
                .addGap(11, 11, 11)
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDineIn)
                    .addComponent(bPlaceOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(pnlC_MenuFrameTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                        .addComponent(rbTakeAway)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDelivery)
                        .addGap(18, 18, 18)
                        .addComponent(scrlpnlC_MenuFrameNotification, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addGroup(pnlC_MenuFrameTablesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bNotificationAcknowledged)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlC_MenuFrameTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlC_MenuFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlC_MenuFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlC_MenuFrameTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bFoodReceivedActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bTransactionHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void CurrentOrderMouseReleased(java.awt.event.MouseEvent evt) {
        
    }
    
    private void balanceComponentShown(java.awt.event.ComponentEvent evt) {
        
    }
    
    private void bLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void bReduceQuantityActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void MenuMouseReleased(java.awt.event.MouseEvent evt) {
        
    }
    
    private void rbDineInActionPerformed(java.awt.event.ActionEvent evt) {

    }
    
    private void rbTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {
    
    }
    
    private void rbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {
      
    }
            
    private void NotificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationMousePressed
        row3 = Notification.getSelectedRow();
        if (row3 != -1) {
            String selector = String.valueOf(model3.getValueAt(row3, 2));
            if (selector.contains("You have successfully topped up ") || selector.equals("Your food is ready") || selector.equals("The order has been canceled") || selector.equals("Your food has been delivered")) { //Check for order ID identifier which starts with O and only allowing 3 statuses of ready and canceled to make the food received button available
                bNotificationAcknowledged.setEnabled(true); //Make the receipt acknowledge button available
            } else {
                bNotificationAcknowledged.setEnabled(false);
            }
        }

    }//GEN-LAST:event_NotificationMousePressed

    private void cbCuisineActionPerformed(java.awt.event.ActionEvent evt) {
        model.setRowCount(0);
        reloadFrame();
    }
    
    private void bNotificationAcknowledgedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNotificationAcknowledgedActionPerformed
        if (bNotificationAcknowledged.isEnabled() && row3 != -1) {
            deleteNotification();
        }
        row3 = -1;
        reloadFrame();
    }//GEN-LAST:event_bNotificationAcknowledgedActionPerformed

    private void bTransactionHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTransactionHistoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bTransactionHistoryMouseClicked

    private void bTransactionHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bTransactionHistoryMousePressed
        C_TransactionHistory transactionHistoryFrame = new C_TransactionHistory(customer);
        transactionHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        transactionHistoryFrame.setVisible(true);
        reloadFrame();
    }//GEN-LAST:event_bTransactionHistoryMousePressed

    private void bOrderHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bOrderHistoryMousePressed
        C_OrderHistory orderHistoryFrame = new C_OrderHistory(customer);
        orderHistoryFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        orderHistoryFrame.setVisible(true);
        reloadFrame();
    }//GEN-LAST:event_bOrderHistoryMousePressed

    private void CurrentOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentOrderMousePressed
        row2 = CurrentOrder.getSelectedRow();
        String selector = String.valueOf(model2.getValueAt(row2, 4));
        if (row2 != -1) {
            if (selector.equals("READY") || selector.equals("DELIVERED")) { //Check for order ID identifier which starts with O and only allowing 3 statuses of ready and canceled to make the food received button available
                bFoodReceived.setEnabled(true); //Make the receipt acknowledge button available
            } else {
                bFoodReceived.setEnabled(false); //Disable the button for all other statuses
            }
        }
    }//GEN-LAST:event_CurrentOrderMousePressed

    private void bCancelOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCancelOrderMousePressed
        if (row2 == -1) { //Filter which order can be canceled
            JOptionPane.showMessageDialog(null, "Please select an order to cancel!", "Warning", JOptionPane.WARNING_MESSAGE);
            reloadFrame();
        } else if (model2.getValueAt(row2, 4).equals("READY") || model2.getValueAt(row2, 4).equals("DELIVERING")) { //Throw error dialog to disable canceling of prepared food
            JOptionPane.showMessageDialog(null, "You cant cancel prepared or delivering food!", "Warning", JOptionPane.WARNING_MESSAGE);
            reloadFrame();
            row2 = -1;
        } else if (model2.getValueAt(row2, 4).equals("PENDING") || model2.getValueAt(row2, 4).equals("PREPARING") || model2.getValueAt(row2, 4).equals("SEARCHING")) {
            List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
            for (Object obj : container) { //Set order status to canceled
                if (obj instanceof DeliveryOrder) {
                    DeliveryOrder dOrder = (DeliveryOrder) obj;
                    if (dOrder.getId().equals(model2.getValueAt(row2, 0))) {
                        dOrder.setStatus(Order.Status.CANCELLED);
                        dOrder.setRunnerStatus(Order.Status.CANCELLED);
                        dOrder.refund(customer.getId()); //Refund all
                        TextEditor.textDelete(TextEditor.FilePaths.HISTORY, dOrder);
                        TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, dOrder);
                        break;
                    }
                } else if (obj instanceof Order) {
                    Order order = (Order) obj;
                    if (order.getId().equals(model2.getValueAt(row2, 0))) {
                        order.setStatus(Order.Status.CANCELLED);
                        order.refund(customer.getId()); //Refund all
                        TextEditor.textDelete(TextEditor.FilePaths.HISTORY, order);
                        TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order);
                        break;
                    }
                }
            }
            List<Object> notifyContainer = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.NOTIFICATION));
            for (Object obj : notifyContainer) { //Set notification status to canceled
                Notification notification = (Notification) obj;
                if (notification.getId().equals(model2.getValueAt(row2, 0))) {
                    notification.setMessageBackUp(4);
                    if (notification.getMessageRunner() != null) { //Cancels runner's delivery notification as well
                        notification.setMessageRunnerBackUp(4);
                    }
                    TextEditor.textDelete(TextEditor.FilePaths.NOTIFICATION, notification);
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "You have sucessfully canceled the order!", "Cancelation Success", JOptionPane.INFORMATION_MESSAGE);
            row2 = -1;
            reloadFrame();
        }
    }//GEN-LAST:event_bCancelOrderMousePressed

    private void bPlaceOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bPlaceOrderMousePressed
        if (row != -1) {
            if (customer.getBal() >= Double.parseDouble(tfPrice.getText())) { //Check if the balance is enough to pay
                if (rbDineIn.isSelected()) { //Set remark to dine in to notify vendor
                    Order order = new Order(tfNumber.getText(), String.valueOf(cbCuisine.getSelectedItem()), customer, tfDetails.getText(), Double.parseDouble(tfPrice.getText()) * Double.parseDouble(tfQuantity.getText()));
                    order.setRemark("Dine in"); //Set for whether dine in or take away in order to notify vendor
                    order.payment(customer); //Deduct balance and pay vendor
                    order.setQuantity(Double.parseDouble(tfQuantity.getText()));
                    Notification notification = new Notification(String.valueOf(cbCuisine.getSelectedItem()), customer, order.getId());
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification); //Writes notification to database
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order); //Writes order to database
                    JOptionPane.showMessageDialog(null, "You have successfully ordered " + tfDetails.getText(), "Order Placed", JOptionPane.INFORMATION_MESSAGE); //Throw success message
                    reloadFrame();
                    row = -1;
                } else if (rbTakeAway.isSelected()) { //Set remark to take away to notify vendor
                    Order order = new Order(tfNumber.getText(), String.valueOf(cbCuisine.getSelectedItem()), customer, tfDetails.getText(), Double.parseDouble(tfPrice.getText()) * Double.parseDouble(tfQuantity.getText()));
                    order.setRemark("Take Away"); //Set for whether dine in or take away in order to notify vendor
                    order.payment(customer); //Deduct balance and pay vendor
                    order.setQuantity(Double.parseDouble(tfQuantity.getText()));
                    Notification notification = new Notification(String.valueOf(cbCuisine.getSelectedItem()), customer, order.getId());
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification); //Writes notification to database
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order); //Writes order to database
                    JOptionPane.showMessageDialog(null, "You have successfully ordered " + tfDetails.getText(), "Take Away", JOptionPane.INFORMATION_MESSAGE); //Throw success message
                    reloadFrame();
                    row = -1;
                } else if (rbDelivery.isSelected()) { //Creates delivery order object
                    Order order = new Order(tfNumber.getText(), String.valueOf(cbCuisine.getSelectedItem()), customer, tfDetails.getText(), Double.parseDouble(tfPrice.getText()) * Double.parseDouble(tfQuantity.getText()));
                    order.payment(customer); //Create order object to use overriden method
                    order.setQuantity(Double.parseDouble(tfQuantity.getText()));
                    DeliveryOrder dOrder = new DeliveryOrder(tfNumber.getText(), String.valueOf(cbCuisine.getSelectedItem()), customer, tfDetails.getText(), Double.parseDouble(tfPrice.getText()) * Double.parseDouble(tfQuantity.getText()));
                    dOrder.setRemark("Delivery"); //Set for whether dine in or take away in order to notify vendor
                    dOrder.setQuantity(Double.parseDouble(tfQuantity.getText()));
                    Notification notification = new Notification(String.valueOf(cbCuisine.getSelectedItem()), customer, dOrder.getId());
                    notification.setMessageRunnerBackUp(5);
                    TextEditor.fileWrite(TextEditor.FilePaths.NOTIFICATION, notification); //Writes notification to database
                    TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, dOrder); //Writes order to database
                    JOptionPane.showMessageDialog(null, "You have successfully ordered " + tfDetails.getText(), "Delivery", JOptionPane.INFORMATION_MESSAGE); //Throw success message
                    reloadFrame();
                    row = -1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Balance is low! Please proceed to top up!", "Warning", JOptionPane.WARNING_MESSAGE); //Throw error when balance is low
                reloadFrame();
                row = -1;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select an order to place!", "No order selected", JOptionPane.WARNING_MESSAGE); //Throw error when nothing is selected
            row = -1;
            reloadFrame();
        }
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
        
        if (evt.getClickCount() == 2 && row != -1) { //Check for double click then redirects the user to the review page of the selected food and pass respective food details
            C_Reviews review = new C_Reviews(ViewReview(row), String.valueOf(cbCuisine.getSelectedItem()), String.valueOf(model.getValueAt(row, 1)));
            review.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            review.setVisible(true);
        }
    }//GEN-LAST:event_MenuMousePressed

    private void bFoodReceivedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bFoodReceivedMousePressed
        if (bFoodReceived.isEnabled()) {
            List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
            for (Object obj : container) {
                if (obj instanceof DeliveryOrder) {
                    DeliveryOrder dOrder = (DeliveryOrder) obj;
                    if (dOrder.getId().equals(model2.getValueAt(row2, 0))) {
                        int result = JOptionPane.showConfirmDialog(null, "This is a delivery order, are you sure you have received it?", "Confirmation", JOptionPane.YES_NO_OPTION); //Check whether if the customer intended to pe rform this action
                        if (result == JOptionPane.YES_OPTION) {
                            dOrder.payment(customer); //Pay vendor, delivery runner and deduct from customer after completion
                            dOrder.setStatus(Order.Status.PICKED_UP);
                            TextEditor.textDelete(TextEditor.FilePaths.HISTORY, dOrder);
                            TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, dOrder);
                            break;
                        }
                    }
                } else if (obj instanceof Order) {
                    Order order = (Order) obj;
                    if (order.getId().equals(model2.getValueAt(row2, 0)) && order.getRemark().equals("Dine in")) { //Check for whether dine in or take away to set proper status
                        order.setStatus(Order.Status.COMPLETED);
                        TextEditor.textDelete(TextEditor.FilePaths.HISTORY, order);
                        TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order);
                        break;
                    } else if (order.getId().equals(model2.getValueAt(row2, 0)) && order.getRemark().equals("Take Away")) {
                        order.setStatus(Order.Status.PICKED_UP);
                        TextEditor.textDelete(TextEditor.FilePaths.HISTORY, order);
                        TextEditor.fileWrite(TextEditor.FilePaths.HISTORY, order);
                        break;
                    }
                }
            }
        }
        row2 = -1;
        reloadFrame();
    }//GEN-LAST:event_bFoodReceivedMousePressed

    private void bLogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogOutMousePressed
        Login_Page LP = new Login_Page();
        LP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bLogOutMousePressed

    private void bAddQuantityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bAddQuantityMousePressed
        String currentText = tfQuantity.getText();
        int currentValue = Integer.parseInt(currentText);
        int newValue = currentValue + 1;
        tfQuantity.setText(Integer.toString(newValue));
    }//GEN-LAST:event_bAddQuantityMousePressed

    private void bReduceQuantityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bReduceQuantityMousePressed
        String currentText = tfQuantity.getText();
        int currentValue = Integer.parseInt(currentText);

        // Dont let the value drop below 0
        if (currentValue > 1) {
            int newValue = currentValue - 1;
            tfQuantity.setText(Integer.toString(newValue));
        }
    }//GEN-LAST:event_bReduceQuantityMousePressed

    private void cbCuisinePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCuisinePropertyChange
        
    }//GEN-LAST:event_cbCuisinePropertyChange

    private void tfQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfQuantityActionPerformed

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
    private javax.swing.JButton bFoodReceived;
    private javax.swing.JButton bLogOut;
    private javax.swing.JButton bNotificationAcknowledged;
    private javax.swing.JButton bOrderHistory;
    private javax.swing.JButton bPlaceOrder;
    private javax.swing.JButton bReduceQuantity;
    private javax.swing.JButton bTransactionHistory;
    private javax.swing.JLabel balance;
    private javax.swing.JComboBox<String> cbCuisine;
    private javax.swing.JLabel jBalance;
    private javax.swing.JLabel jCurrentOrder;
    private javax.swing.JLabel jMenu;
    private javax.swing.JLabel jTitle;
    private javax.swing.JLabel jUsername;
    private javax.swing.JLabel lblC_MenuFramePrice;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlC_MenuFrame;
    private javax.swing.JPanel pnlC_MenuFrameTables;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JRadioButton rbDineIn;
    private javax.swing.JRadioButton rbTakeAway;
    private javax.swing.JScrollPane scrlpnlC_MenuFrameCurrentOrderTable;
    private javax.swing.JScrollPane scrlpnlC_MenuFrameMenuTable;
    private javax.swing.JScrollPane scrlpnlC_MenuFrameNotification;
    private javax.swing.JTextField tfDetails;
    private javax.swing.JTextField tfNumber;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    // End of variables declaration//GEN-END:variables
}
