import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin_TopUpCredit_Page extends javax.swing.JFrame {
    TextEditor text;
    Administrator admin;
    Time time;
    Notification nt;
    public Admin_TopUpCredit_Page() {
        initComponents();
        text = new TextEditor();
        admin = new Administrator();
        time = new Time();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ManageRecord_Table = new javax.swing.JTable();
        Confirm_BTN = new javax.swing.JButton();
        ViewReceipt_BTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SortAll_BTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Email_TF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PN_TF = new javax.swing.JTextField();
        ID_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        InitialBalance_TF = new javax.swing.JTextField();
        SearchID_TF = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        ManageRecord_BTN = new javax.swing.JButton();
        TopUP_BTN = new javax.swing.JButton();
        Regd_BTN = new javax.swing.JButton();
        Logout_BTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Search_BTN = new javax.swing.JButton();
        AddBalance_CB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        ManageRecord_Table.setBackground(new java.awt.Color(153, 204, 255));
        ManageRecord_Table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ManageRecord_Table.setForeground(new java.awt.Color(255, 255, 255));
        ManageRecord_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Email", "Phone Number", "Balance (RM)"
            }
        ));
        ManageRecord_Table.setToolTipText("");
        ManageRecord_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageRecord_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ManageRecord_Table);

        Confirm_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Confirm_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Confirm_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Confirm_BTN.setText("Confirm");
        Confirm_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Confirm_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confirm_BTNActionPerformed(evt);
            }
        });

        ViewReceipt_BTN.setBackground(new java.awt.Color(102, 153, 255));
        ViewReceipt_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ViewReceipt_BTN.setForeground(new java.awt.Color(255, 255, 255));
        ViewReceipt_BTN.setText("View Receipt");
        ViewReceipt_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ViewReceipt_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewReceipt_BTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        SortAll_BTN.setBackground(new java.awt.Color(153, 204, 255));
        SortAll_BTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SortAll_BTN.setForeground(new java.awt.Color(255, 255, 255));
        SortAll_BTN.setText("Display Records");
        SortAll_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortAll_BTNActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add balance: (RM)");

        Email_TF.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Initial Balance: (RM)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID:");

        PN_TF.setEditable(false);

        ID_TF.setEditable(false);
        ID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_TFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Top Up Credit");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PhoneNo:");

        InitialBalance_TF.setEditable(false);

        SearchID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchID_TFActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        ManageRecord_BTN.setBackground(new java.awt.Color(102, 153, 255));
        ManageRecord_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ManageRecord_BTN.setForeground(new java.awt.Color(255, 255, 255));
        ManageRecord_BTN.setText("Manage User Records");
        ManageRecord_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageRecord_BTNActionPerformed(evt);
            }
        });

        TopUP_BTN.setBackground(new java.awt.Color(102, 153, 255));
        TopUP_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        TopUP_BTN.setForeground(new java.awt.Color(255, 255, 255));
        TopUP_BTN.setText("Top Up Credits");
        TopUP_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopUP_BTNActionPerformed(evt);
            }
        });

        Regd_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Regd_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Regd_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Regd_BTN.setText("Registration");
        Regd_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regd_BTNActionPerformed(evt);
            }
        });

        Logout_BTN.setBackground(new java.awt.Color(51, 102, 255));
        Logout_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Logout_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Logout_BTN.setText("Logout");
        Logout_BTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Logout_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout_BTNActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Admin Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Regd_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TopUP_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageRecord_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Logout_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel4)
                .addGap(61, 61, 61)
                .addComponent(Regd_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ManageRecord_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TopUP_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(Logout_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search for ID:");

        Search_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Search_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Search_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Search_BTN.setText("Search");
        Search_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Search_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_BTNActionPerformed(evt);
            }
        });

        AddBalance_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "50", "100" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(InitialBalance_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PN_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddBalance_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(SearchID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Search_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(SortAll_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 32, Short.MAX_VALUE)))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Confirm_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(ViewReceipt_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PN_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InitialBalance_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search_BTN)
                            .addComponent(AddBalance_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Confirm_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ViewReceipt_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SortAll_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageRecord_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageRecord_BTNActionPerformed
        Admin_Main_Page MP =  new Admin_Main_Page();
        MP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ManageRecord_BTNActionPerformed

    private void TopUP_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUP_BTNActionPerformed
        Admin_TopUpCredit_Page tp =  new Admin_TopUpCredit_Page();
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TopUP_BTNActionPerformed

    private void Regd_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regd_BTNActionPerformed
        Admin_Registration_Page RP =  new Admin_Registration_Page();
        RP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Regd_BTNActionPerformed

    private void Confirm_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confirm_BTNActionPerformed
        String custId = ID_TF.getText();
        double Initialbalance = Double.parseDouble(InitialBalance_TF.getText());
        int topupamount = Integer.parseInt(String.valueOf(AddBalance_CB.getSelectedItem()));
        String date = time.getDay()+ "/" +time.getMonth()+ "/" +time.getYear();
        String topuptime = time.toString();
        String type = "Top Up";
        Boolean generateReceipt = false;
        
        if(!custId.equals("")){
            admin.setBal(Initialbalance);
            admin.addBal(topupamount);
            String balance = String.valueOf(admin.getbal());
            List<DataProvider> appenedcontainer = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
            for(DataProvider value : appenedcontainer){
                if (value instanceof Customer) {
                    Customer cust = (Customer) value;
                    if (custId.equals(cust.getId())) {
                        cust.setBal(balance);
                        text.textDelete(TextEditor.FilePaths.USER, cust);
                        text.fileWrite(TextEditor.FilePaths.USER, cust);
                        customerRecord(custId);
                        generateReceipt = true;
                        break;
                    }
                }
            }
            if(generateReceipt){
                String receiptId = String.valueOf(generateReceiptID());
                String notificationId = generateNotificationID();
                nt = new Notification(notificationId, receiptId, custId, date, topuptime, type, topupamount);
                text.fileWrite(TextEditor.FilePaths.NOTIFICATION, nt);
                JOptionPane.showMessageDialog(this, " You have successfully topped up ,receipt has been generated!");
            }
        }
    }//GEN-LAST:event_Confirm_BTNActionPerformed

    private void ViewReceipt_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewReceipt_BTNActionPerformed
     Admin_View_Receipt VR = new Admin_View_Receipt(nt.getId(), nt.getReceiptID(), nt.getUserID(), nt.getDate(), nt.getTime(), nt.getType(), nt.getTopupamount());
     VR.setVisible(true);
     this.dispose();
        
    }//GEN-LAST:event_ViewReceipt_BTNActionPerformed

    private void Logout_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout_BTNActionPerformed
        
    }//GEN-LAST:event_Logout_BTNActionPerformed

    private void SortAll_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortAll_BTNActionPerformed
        String ID = "All";
        customerRecord(ID);
    }//GEN-LAST:event_SortAll_BTNActionPerformed

    private void ManageRecord_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageRecord_TableMouseClicked
        ManageRecord_Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1){ // Check for single-click
                    int row = ManageRecord_Table.getSelectedRow();
                    if (row >= 0) {
                        // Get data from the selected row and set it in your text fields
                        String ID = ManageRecord_Table.getModel().getValueAt(row, 0).toString();
                        ID_TF.setText(ID);
                        String Email = ManageRecord_Table.getModel().getValueAt(row, 1).toString();
                        Email_TF.setText(Email);
                        String PhoneNo = ManageRecord_Table.getModel().getValueAt(row, 2).toString();
                        PN_TF.setText(PhoneNo); 
                        String initialBalance = ManageRecord_Table.getModel().getValueAt(row, 3).toString();
                        InitialBalance_TF.setText(initialBalance); 
                    }
                }
            }
        });
    }//GEN-LAST:event_ManageRecord_TableMouseClicked

    private void ID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_TFActionPerformed

    private void Search_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Search_BTNActionPerformed
        String ID = SearchID_TF.getText();
        customerRecord(ID);
    }//GEN-LAST:event_Search_BTNActionPerformed

    private void SearchID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchID_TFActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Main_Page().setVisible(true);
            }
        });
    }
    
    public void customerRecord(String ID){
        int numRows = 100;
        int numCols = 20;  
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
        String[][] userDetails = new String[numRows][numCols];

        DefaultTableModel model = (DefaultTableModel) ManageRecord_Table.getModel();
        model.setRowCount(0);
        int row = 0;

        for (DataProvider value : container) {
            if (value instanceof Customer) {
                Customer cust = (Customer) value;
                if (ID.equals(cust.getId()) || ID.equals("All")){
                    // Customer found by ID
                    userDetails[row][0] = cust.getId();
                    userDetails[row][1] = cust.getEmail();
                    userDetails[row][2] = cust.getPhoneNo();
                    userDetails[row][3] = String.valueOf(cust.getBal());
                }else{
                    JOptionPane.showMessageDialog(this, "Customer ID does not exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            // Continue with the rest of your code to check and add rows to the table
            boolean isEmptyRow = true;
            for (int col = 0; col < userDetails[row].length; col++){
                if (userDetails[row][col] != null && !userDetails[row][col].isEmpty()) {
                    isEmptyRow = false;
                    break;
                }
            }
            if (!isEmptyRow) {
                model.addRow(userDetails[row]);
            }
            row++;
        }
    }

    public int generateReceiptID(){
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.NOTIFICATION));
        
        int countReceipt = 1; 
        for (DataProvider value : container) {
            Notification nt = (Notification) value;
            if(nt.getType().equals("Top Up")){
                countReceipt++;
            }else{
                break;
            }
        }
        return countReceipt;
    }
    
     public String generateNotificationID(){
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.NOTIFICATION));
        
        int count = 0; 
        for (DataProvider value : container) {
            Notification nt = (Notification) value;
            if(nt == null){
                return "N" +count;
            }else{
                count++;
            }
            
        }
        return "N" +count;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AddBalance_CB;
    private javax.swing.JButton Confirm_BTN;
    private javax.swing.JTextField Email_TF;
    private javax.swing.JTextField ID_TF;
    private javax.swing.JTextField InitialBalance_TF;
    private javax.swing.JButton Logout_BTN;
    private javax.swing.JButton ManageRecord_BTN;
    private javax.swing.JTable ManageRecord_Table;
    private javax.swing.JTextField PN_TF;
    private javax.swing.JButton Regd_BTN;
    private javax.swing.JTextField SearchID_TF;
    private javax.swing.JButton Search_BTN;
    private javax.swing.JButton SortAll_BTN;
    private javax.swing.JButton TopUP_BTN;
    private javax.swing.JButton ViewReceipt_BTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
