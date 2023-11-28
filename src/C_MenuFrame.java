 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class C_MenuFrame extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] column = {"No.", "Details", "Price"};
    private int row = -1;
    
    private DefaultTableModel model2 = new DefaultTableModel();
    private String[] column2 = {"OrderID", "Details", "Quantity", "Total", "Status"};
    private int row2 = -1;
    
    private double originalPrice;
    
    private Customer customer;
    
    /**
     * Creates new form Menu
     */
    public C_MenuFrame(Customer customer) {
        initComponents();
        this.customer = customer;
        model.setColumnIdentifiers(column);
        model2.setColumnIdentifiers(column2);
        loadBalanceAndUsernameFromFile();
        populateMenuTable();
        populateCOrderTable();
        
        cbCuisine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuisineActionPerformed(evt);
            }
        });
    }
    
    
    
    private void loadBalanceAndUsernameFromFile() {
        try {
            String balanceFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\balance.txt";
            FileReader balanceFileReader = new FileReader(balanceFilePath);
            BufferedReader balanceBufferedReader = new BufferedReader(balanceFileReader);

            // Read the balance from the file
            String balanceString = balanceBufferedReader.readLine();
            double loadedBalance = Double.parseDouble(balanceString);

            // Format the balance with two decimal points
            String formattedBalance = String.format("%.2f", loadedBalance);

            // Update the "balance" JLabel
            balance.setText("RM" + formattedBalance);

            // Close the balance file readers
            balanceBufferedReader.close();
            balanceFileReader.close();

            String usernameFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\username.txt";
            FileReader usernameFileReader = new FileReader(usernameFilePath);
            BufferedReader usernameBufferedReader = new BufferedReader(usernameFileReader);

            // Read the username from the file
            String usernameString = usernameBufferedReader.readLine();

            // Update the "username" JLabel
            username.setText(usernameString);

            // Close the username file readers
            usernameBufferedReader.close();
            usernameFileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading balance and username from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearTextField(){
        tfNumber.setText("");
        tfDetails.setText("");
        tfPrice.setText("");

    }
   
    private void addQuantity() {
        int currentValue = Integer.parseInt(tfQuantity.getText());
        tfQuantity.setText(String.valueOf(currentValue + 1));

        updatePrice();
    }
    
    private void minusQuantity() {
        int currentValue = Integer.parseInt(tfQuantity.getText());
        if (currentValue > 1) {
            tfQuantity.setText(String.valueOf(currentValue - 1));
            updatePrice();
        }
    }
    
    private void updatePrice() {
        int quantity = Integer.parseInt(tfQuantity.getText());
        double totalPrice = originalPrice * quantity;
        tfPrice.setText(String.format("%.2f", totalPrice));
    }
    
    private void populateMenuTable() {
        // Specify the path to your menu text files
        String chineseMenuFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\chinese.txt";
        String indianMenuFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\indian.txt";
        String malayMenuFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\malay.txt";
        String westernMenuFilePath = "C:\\Users\\User\\Desktop\\APU\\Degree Lvl 2\\OODJ\\OODJ_txt\\western.txt";

        // Read data from the selected menu text file and populate the menu table
        String selectedCuisine = cbCuisine.getSelectedItem().toString();
        String menuFilePath = switch (selectedCuisine) {
            case "Chinese" -> chineseMenuFilePath;
            case "Indian" -> indianMenuFilePath;
            case "Malay" -> malayMenuFilePath;
            case "Western" -> westernMenuFilePath;
            default -> ""; // Handle the default case appropriately
        };

        Object[][] menuData = readMenuFile(menuFilePath);
        model.setDataVector(menuData, column);
}
    
    private void populateCOrderTable() {
    // Specify the path to your menu text file
    

    // Read data from the file and populate the menu table
    Object[][] COrderData = readCOrderFile(COrderFilePath);
    model2.setDataVector(COrderData, column2);
    }
    
    
    private static Object[][] readMenuFile(String menuFilePath) {
        // Initialize a 2D array to hold the data
        Object[][] data = null;

        try (BufferedReader br = new BufferedReader(new FileReader(menuFilePath))) {
            // Assuming each line in the file represents a row in the table
            // You may need to modify this based on the actual format of your text file
            String line;
            int rowCount = 0;

            // Count the number of lines in the file
            while (br.readLine() != null) {
                rowCount++;
            }

            // Reset the reader using a separate variable
            BufferedReader resetReader = new BufferedReader(new FileReader(menuFilePath));

            // Initialize the 2D array based on the row count
            data = new Object[rowCount][3];

            // Read each line and populate the 2D array
            int i = 0;
            while ((line = resetReader.readLine()) != null) {
                // Assuming the data is separated by some delimiter (e.g., comma)
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    data[i][0] = parts[0].trim();
                    data[i][1] = parts[1].trim();
                    data[i][2] = parts[2].trim();
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    
    
    private static Object[][] readCOrderFile(String COrderFilePath) {
        // Initialize a 2D array to hold the data
        Object[][] data = null;

        try (BufferedReader br = new BufferedReader(new FileReader(COrderFilePath))) {
            // Assuming each line in the file represents a row in the table
            // You may need to modify this based on the actual format of your text file
            String line;
            int rowCount = 0;

            // Count the number of lines in the file
            while (br.readLine() != null) {
                rowCount++;
            }

            // Reset the reader using a separate variable
            BufferedReader resetReader = new BufferedReader(new FileReader(COrderFilePath));

            // Initialize the 2D array based on the row count
            data = new Object[rowCount][5];

            // Read each line and populate the 2D array
            int i = 0;
            while ((line = resetReader.readLine()) != null) {
                // Assuming the data is separated by some delimiter (e.g., comma)
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    data[i][0] = parts[0].trim();
                    data[i][1] = parts[1].trim();
                    data[i][2] = parts[2].trim();
                    data[i][3] = parts[3].trim();
                    data[i][4] = parts[4].trim();
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Menu = new javax.swing.JTable();
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
            .addComponent(jTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
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
                .addGap(297, 297, 297))
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

        Menu.setModel(model);
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Menu);

        cbCuisine.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chinese", "Malay", "Indian", "Western" }));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bCancelOrder)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jMenu)
                                .addGap(335, 335, 335)
                                .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(bReviews)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bPlaceOrder))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
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
                                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bAddQuantity))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCurrentOrder)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCurrentOrder)
                    .addComponent(jMenu))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReduceQuantity)
                    .addComponent(bAddQuantity)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelOrder)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPlaceOrder)
                    .addComponent(bReviews))
                .addGap(25, 25, 25))
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
    }//GEN-LAST:event_bReviewsActionPerformed

    private void bAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddQuantityActionPerformed
        // TODO add your handling code here:
        addQuantity();
    }//GEN-LAST:event_bAddQuantityActionPerformed

    private void MenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseReleased
        // TODO add your handling code here:
        row = Menu.getSelectedRow();
        String number = String.valueOf(model.getValueAt(row, 0));
        String details = String.valueOf(model.getValueAt(row, 1));
        originalPrice = Double.parseDouble(String.valueOf(model.getValueAt(row, 2)));

        tfNumber.setText(number);
        tfDetails.setText(details);
        tfPrice.setText(String.valueOf(originalPrice));
    }//GEN-LAST:event_MenuMouseReleased

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
    }//GEN-LAST:event_CurrentOrderMouseReleased

    private void bCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelOrderActionPerformed
        // TODO add your handling code here:
        // NEED TO DELETE FROM FILE
        if(row2 == -1){
            JOptionPane.showMessageDialog(this, "Please select a row");
        } else {
            model2.removeRow(row2);
            clearTextField();
            row2 = -1;
        }
        model2.removeRow(row2);
        clearTextField();
    }//GEN-LAST:event_bCancelOrderActionPerformed

    private void bPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPlaceOrderActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bPlaceOrderActionPerformed

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
    private javax.swing.JLabel jTitle;
    private javax.swing.JLabel jUsername;
    private javax.swing.JTextField tfDetails;
    private javax.swing.JTextField tfNumber;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
