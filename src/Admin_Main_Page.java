


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin_Main_Page extends javax.swing.JFrame {
    TextEditor text;
    Customer customer;
    Vendor vendor;
    DeliveryRunner runner;
    public Admin_Main_Page() {
        initComponents();
        text = new TextEditor();
        customer = new Customer();
        vendor = new Vendor();
        runner = new DeliveryRunner();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ManageRecord_BTN = new javax.swing.JButton();
        TopUP_BTN = new javax.swing.JButton();
        Regd_BTN = new javax.swing.JButton();
        Logout_BTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ManageRecord_Table = new javax.swing.JTable();
        Update_BTN = new javax.swing.JButton();
        Delete_BTN = new javax.swing.JButton();
        SortCustomer_BTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SortRunner_BTN = new javax.swing.JButton();
        SortVendor_BTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        VN_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Gender_CB = new javax.swing.JComboBox<>();
        Email_TF = new javax.swing.JTextField();
        PN_TF = new javax.swing.JTextField();
        Address_TF = new javax.swing.JTextField();
        ID_TF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Pass_TF = new javax.swing.JTextField();
        Pass_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        ManageRecord_Table.setBackground(new java.awt.Color(153, 204, 255));
        ManageRecord_Table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ManageRecord_Table.setForeground(new java.awt.Color(255, 255, 255));
        ManageRecord_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vendor Name", "Email", "Phone No", "Gender", "Address", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ManageRecord_Table.setToolTipText("");
        ManageRecord_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageRecord_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ManageRecord_Table);

        Update_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Update_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Update_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Update_BTN.setText("Update");
        Update_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Update_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_BTNActionPerformed(evt);
            }
        });

        Delete_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Delete_BTN.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Delete_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Delete_BTN.setText("Delete");
        Delete_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Delete_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_BTNActionPerformed(evt);
            }
        });

        SortCustomer_BTN.setBackground(new java.awt.Color(153, 204, 255));
        SortCustomer_BTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SortCustomer_BTN.setForeground(new java.awt.Color(255, 255, 255));
        SortCustomer_BTN.setText("Customer");
        SortCustomer_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortCustomer_BTNActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sort By:");

        SortRunner_BTN.setBackground(new java.awt.Color(153, 204, 255));
        SortRunner_BTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SortRunner_BTN.setForeground(new java.awt.Color(255, 255, 255));
        SortRunner_BTN.setText("Delivery Runner");
        SortRunner_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortRunner_BTNActionPerformed(evt);
            }
        });

        SortVendor_BTN.setBackground(new java.awt.Color(153, 204, 255));
        SortVendor_BTN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SortVendor_BTN.setForeground(new java.awt.Color(255, 255, 255));
        SortVendor_BTN.setText("Vendor");
        SortVendor_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortVendor_BTNActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Store Name:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Phone Number:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID:");

        Gender_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        ID_TF.setEditable(false);
        ID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_TFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gender:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Manage User Records");

        Pass_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pass_TFActionPerformed(evt);
            }
        });

        Pass_Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pass_Label.setForeground(new java.awt.Color(255, 255, 255));
        Pass_Label.setText("Password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VN_TF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PN_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Pass_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Pass_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Update_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Address_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Gender_CB, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(SortCustomer_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(SortVendor_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(SortRunner_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(jLabel1)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(Delete_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Pass_Label)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pass_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VN_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gender_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SortCustomer_BTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SortVendor_BTN)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Address_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PN_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Delete_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SortRunner_BTN)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Regd_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TopUP_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageRecord_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Logout_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(122, 122, 122)
                .addComponent(Regd_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageRecord_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TopUP_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManageRecord_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageRecord_BTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageRecord_BTNActionPerformed

    private void TopUP_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUP_BTNActionPerformed

    }//GEN-LAST:event_TopUP_BTNActionPerformed

    private void Regd_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regd_BTNActionPerformed

    }//GEN-LAST:event_Regd_BTNActionPerformed

    private void Update_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_BTNActionPerformed
        String ID = ID_TF.getText().trim();
        String phoneNo = PN_TF.getText().trim();
        String email = Email_TF.getText().trim();
        String password = Pass_TF.getText();
        String address = Address_TF.getText().trim();
        String vendorName = VN_TF.getText().trim();
        String gender = String.valueOf(Gender_CB.getSelectedItem());
        String path = "C:\\Users\\110ti\\OneDrive - Asia Pacific University\\Degree Year 2\\Tutorial\\Java\\Assignment\\files\\USERS.txt";
        
        if(!ID.equals("")){
            List<DataProvider> appenedcontainer = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
            for(DataProvider value : appenedcontainer){
                if (value instanceof Vendor) {
                    Vendor vendor = (Vendor) value;
                    if (ID.equals(vendor.getId())) {
                        vendor.setName(vendorName);
                        vendor.setEmail(email);
                        vendor.setPhoneNo(phoneNo);
                        vendor.setGender(gender);
                        vendor.setPass(password);
                        break;
                    }
                } else if (value instanceof Customer) {
                    Customer customer = (Customer) value;
                    if (ID.equals(customer.getId())) {
                        customer.setEmail(email);
                        customer.setPhoneNo(phoneNo);
                        customer.setGender(gender);
                        customer.setAddress(address);
                        customer.setPass(password);
                        break;
                    }
                } else if (value instanceof DeliveryRunner) {
                    DeliveryRunner runner = (DeliveryRunner) value;
                    if (ID.equals(runner.getId())) {
                        runner.setEmail(email);
                        runner.setPhoneNo(phoneNo);
                        runner.setGender(gender);
                        runner.setPass(password);
                        break;
                    }
                }
            }
            text.textWrite(path, appenedcontainer);
        }else{
            JOptionPane.showMessageDialog(this, "Please select a record from the table!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_Update_BTNActionPerformed

    private void Delete_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_BTNActionPerformed
        String ID = ID_TF.getText().trim();
        
        if(!ID.equals("")){
            char user = ID.charAt(0);
            switch(String.valueOf(user)){
                    case "C":
                        customer.setId(ID);
                        text.textDelete(TextEditor.FilePaths.USER, customer);
                        break;
                    case "V":
                        vendor.setId(ID);
                        text.textDelete(TextEditor.FilePaths.USER, vendor);
                        break;
                    case "D":
                        runner.setId(ID);
                        text.textDelete(TextEditor.FilePaths.USER, runner);
                        break;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Please select a record from the table!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Delete_BTNActionPerformed

    private void SortCustomer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortCustomer_BTNActionPerformed
        String role = "Customer";
        displayRecord(role);
    }//GEN-LAST:event_SortCustomer_BTNActionPerformed

    private void SortVendor_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortVendor_BTNActionPerformed
        String role = "Vendor";
        displayRecord(role);
    }//GEN-LAST:event_SortVendor_BTNActionPerformed

    private void SortRunner_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortRunner_BTNActionPerformed
        String role = "Runner";
        displayRecord(role);
    }//GEN-LAST:event_SortRunner_BTNActionPerformed

    private void Logout_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout_BTNActionPerformed

    }//GEN-LAST:event_Logout_BTNActionPerformed

    private void ManageRecord_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageRecord_TableMouseClicked
        ManageRecord_Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Check for single-click
                    int row = ManageRecord_Table.getSelectedRow();
                    if (row >= 0) {
                        // Get data from the selected row and set it in your text fields
                        String ID = ManageRecord_Table.getModel().getValueAt(row, 0).toString();
                        ID_TF.setText(ID);
                        String VN = ManageRecord_Table.getModel().getValueAt(row, 1).toString();
                        VN_TF.setText(VN);
                        String Email = ManageRecord_Table.getModel().getValueAt(row, 2).toString();
                        Email_TF.setText(Email); 
                        String PhoneNo = ManageRecord_Table.getModel().getValueAt(row, 3).toString();
                        PN_TF.setText(PhoneNo); 
                        String Address = ManageRecord_Table.getModel().getValueAt(row, 5).toString();
                        Address_TF.setText(Address); 
                        String Password = ManageRecord_Table.getModel().getValueAt(row, 6).toString();
                        Pass_TF.setText(Password); 
                    }
                }
            }
        });
    }//GEN-LAST:event_ManageRecord_TableMouseClicked

    private void ID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_TFActionPerformed

    private void Pass_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pass_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pass_TFActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Main_Page().setVisible(true);
            }
        });
    }
    
    public void displayRecord(String role){
        int numRows = 100;
        int numCols = 20;  
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
        String[][] userDetails = new String[numRows][numCols];
        
        DefaultTableModel model = (DefaultTableModel) ManageRecord_Table.getModel();
        model.setRowCount(0);
        int row = 0;
        for (DataProvider value : container) {
            if (value instanceof Vendor) {
                if (role.equals("Vendor")) {
                    Vendor vendor = (Vendor) value;
                    userDetails[row][0] = vendor.getId();
                    userDetails[row][1] = vendor.getName();
                    userDetails[row][2] = vendor.getEmail();
                    userDetails[row][3] = vendor.getPhoneNo();
                    userDetails[row][4] = vendor.getGender();
                    userDetails[row][5] = "";
                    userDetails[row][6] = vendor.getPass();
                }
            } else if (value instanceof Customer) {
                if (role.equals("Customer")) {
                    Customer customer = (Customer) value;
                    userDetails[row][0] = customer.getId();
                    userDetails[row][1] = "";  // Assuming there's a getName() method in Customer
                    userDetails[row][2] = customer.getEmail();
                    userDetails[row][3] = customer.getPhoneNo();
                    userDetails[row][4] = customer.getGender();
                    userDetails[row][5] = customer.getAddress();
                    userDetails[row][6] = customer.getPass();
                }
            } else if (value instanceof DeliveryRunner) {
                if (role.equals("Delivery Runner")) {
                    DeliveryRunner runner = (DeliveryRunner) value;
                    userDetails[row][0] = runner.getId();
                    userDetails[row][1] = "";  // Assuming there's no getName() method in DeliveryRunner
                    userDetails[row][2] = runner.getEmail();
                    userDetails[row][3] = runner.getPhoneNo();
                    userDetails[row][4] = runner.getGender();
                    userDetails[row][5] = "";
                    userDetails[row][6] = runner.getPass();
                }
            }

            // Check if any of the fields in the current row are empty before adding it to the table
            boolean isEmptyRow = true;
            for (int col = 0; col < userDetails[row].length; col++) {
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address_TF;
    private javax.swing.JButton Delete_BTN;
    private javax.swing.JTextField Email_TF;
    private javax.swing.JComboBox<String> Gender_CB;
    private javax.swing.JTextField ID_TF;
    private javax.swing.JButton Logout_BTN;
    private javax.swing.JButton ManageRecord_BTN;
    private javax.swing.JTable ManageRecord_Table;
    private javax.swing.JTextField PN_TF;
    private javax.swing.JLabel Pass_Label;
    private javax.swing.JTextField Pass_TF;
    private javax.swing.JButton Regd_BTN;
    private javax.swing.JButton SortCustomer_BTN;
    private javax.swing.JButton SortRunner_BTN;
    private javax.swing.JButton SortVendor_BTN;
    private javax.swing.JButton TopUP_BTN;
    private javax.swing.JButton Update_BTN;
    private javax.swing.JTextField VN_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
