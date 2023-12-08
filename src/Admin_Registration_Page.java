import java.awt.HeadlessException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Admin_Registration_Page extends javax.swing.JFrame {
    Customer customer;
    Vendor vendor;
    DeliveryRunner deliveryrunner;
    TextEditor text;
    public Admin_Registration_Page(){
        initComponents();
        text = new TextEditor();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        VN_Label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Role_CB = new javax.swing.JComboBox<>();
        Address_Label = new javax.swing.JLabel();
        Gender_Label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Role_Label = new javax.swing.JLabel();
        PN_Label = new javax.swing.JLabel();
        Email_Label = new javax.swing.JLabel();
        Pass_Label = new javax.swing.JLabel();
        ConfirmPass_Label = new javax.swing.JLabel();
        Regd_BTN = new javax.swing.JButton();
        Back_BTN = new javax.swing.JButton();
        VN_TF = new javax.swing.JTextField();
        Pass_Field = new javax.swing.JPasswordField();
        Address_TF = new javax.swing.JTextField();
        ConfirmPass_Field = new javax.swing.JPasswordField();
        Email_TF = new javax.swing.JTextField();
        Male_RB = new javax.swing.JRadioButton();
        Female_RB = new javax.swing.JRadioButton();
        PN_TF = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registration");

        VN_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VN_Label.setForeground(new java.awt.Color(255, 255, 255));
        VN_Label.setText("Vendor Name");

        Role_CB.setBackground(new java.awt.Color(102, 153, 255));
        Role_CB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Role_CB.setForeground(new java.awt.Color(255, 255, 255));
        Role_CB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer", "Vendor", "Delivery Runner" }));
        Role_CB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Role_CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Role_CBActionPerformed(evt);
            }
        });

        Address_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Address_Label.setForeground(new java.awt.Color(255, 255, 255));
        Address_Label.setText("Address");

        Gender_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Gender_Label.setForeground(new java.awt.Color(255, 255, 255));
        Gender_Label.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Role_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Role_Label.setForeground(new java.awt.Color(255, 255, 255));
        Role_Label.setText("Role");

        PN_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PN_Label.setForeground(new java.awt.Color(255, 255, 255));
        PN_Label.setText("Phone Number");

        Email_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Email_Label.setForeground(new java.awt.Color(255, 255, 255));
        Email_Label.setText("Email");

        Pass_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Pass_Label.setForeground(new java.awt.Color(255, 255, 255));
        Pass_Label.setText("Password");

        ConfirmPass_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ConfirmPass_Label.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPass_Label.setText("Confirm Password");

        Regd_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Regd_BTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Regd_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Regd_BTN.setText("Register");
        Regd_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regd_BTNActionPerformed(evt);
            }
        });

        Back_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Back_BTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Back_BTN.setText("Back");
        Back_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back_BTNActionPerformed(evt);
            }
        });

        VN_TF.setEditable(false);
        VN_TF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VN_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        VN_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VN_TFActionPerformed(evt);
            }
        });

        Pass_Field.setText("123456");
        Pass_Field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Address_TF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Address_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Address_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Address_TFActionPerformed(evt);
            }
        });

        ConfirmPass_Field.setText("123456");
        ConfirmPass_Field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Email_TF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Email_TF.setText(" example@gmail.com");
        Email_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Email_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Email_TFActionPerformed(evt);
            }
        });

        Male_RB.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup1.add(Male_RB);
        Male_RB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Male_RB.setForeground(new java.awt.Color(255, 255, 255));
        Male_RB.setSelected(true);
        Male_RB.setText("Male");

        Female_RB.setBackground(new java.awt.Color(153, 204, 255));
        buttonGroup1.add(Female_RB);
        Female_RB.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Female_RB.setForeground(new java.awt.Color(255, 255, 255));
        Female_RB.setText("Female");
        Female_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Female_RBActionPerformed(evt);
            }
        });

        PN_TF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PN_TF.setText("+60101112222");
        PN_TF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PN_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PN_TFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VN_Label)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Regd_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PN_Label)
                                        .addComponent(Role_Label)
                                        .addComponent(Pass_Label)
                                        .addComponent(Pass_Field)
                                        .addComponent(Role_CB, 0, 268, Short.MAX_VALUE)
                                        .addComponent(VN_TF)
                                        .addComponent(PN_TF)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(Back_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Address_Label)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ConfirmPass_Label)
                                                .addComponent(Email_Label)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Gender_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(Male_RB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(35, 35, 35)
                                                    .addComponent(Female_RB))
                                                .addComponent(ConfirmPass_Field)
                                                .addComponent(Address_TF)
                                                .addComponent(Email_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel5))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VN_Label)
                    .addComponent(Address_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Address_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(VN_TF))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email_Label)
                    .addComponent(PN_Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Email_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(PN_TF))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Gender_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Role_Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Role_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Male_RB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Female_RB))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pass_Label)
                            .addComponent(ConfirmPass_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ConfirmPass_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(Pass_Field))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Regd_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Role_CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Role_CBActionPerformed
        if(Role_CB.getSelectedItem().equals("Vendor")){
            VN_TF.setEditable(true);
            Address_TF.setText(null);
            Address_TF.setEditable(false);
        }else if(Role_CB.getSelectedItem().equals("Customer")){
            VN_TF.setText(null);
            VN_TF.setEditable(false);
            Address_TF.setEditable(true);
        }else if(Role_CB.getSelectedItem().equals("Delivery Runner")){
            VN_TF.setText(null);
            Address_TF.setText(null);
            VN_TF.setEditable(false);
            Address_TF.setEditable(false);
        }
    }//GEN-LAST:event_Role_CBActionPerformed

    private void VN_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VN_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VN_TFActionPerformed

    private void Address_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Address_TFActionPerformed
        
    }//GEN-LAST:event_Address_TFActionPerformed

    private void Email_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Email_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Email_TFActionPerformed

    private void Female_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Female_RBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Female_RBActionPerformed

    private void Regd_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regd_BTNActionPerformed
        String phoneNo = PN_TF.getText().trim();
        String email = Email_TF.getText().trim();
        String password = Pass_Field.getText();
        String confirmPass = ConfirmPass_Field.getText();
        String address = Address_TF.getText().trim();
        String vendorName = VN_TF.getText().trim();

        Male_RB.setActionCommand("Male");
        Female_RB.setActionCommand("Female");
        String gender = buttonGroup1.getSelection().getActionCommand().trim();
        Object role = Role_CB.getSelectedItem();

        int countCustomer = 0;
        int countVendor = 0;
        int countRunner = 0;
        int numRows = 100;
        int numCols = 20;        
        
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
        String[][] userDetails = new String[numRows][numCols];

        int row = 0;
        for (DataProvider value : container) {
            if (value instanceof Vendor) {
                Vendor vend = (Vendor) value;
                userDetails[row][0] = vend.getId();
                userDetails[row][1] = vend.getName();
                userDetails[row][2] = vend.getEmail();
                userDetails[row][3] = vend.getPhoneNo();
                row++;
                countVendor++;
            } else if (value instanceof Customer) {
                Customer  cust = (Customer) value;
                userDetails[row][0] = cust.getId();
                userDetails[row][1] = "";  // Assuming there's a getName() method in Customer
                userDetails[row][2] = cust.getEmail();
                userDetails[row][3] = cust.getPhoneNo();
                row++;
                countCustomer++;
            } else if (value instanceof DeliveryRunner) {
                DeliveryRunner drunner = (DeliveryRunner) value;
                userDetails[row][0] = drunner.getId();
                userDetails[row][1] = "";  // Assuming there's no getName() method in DeliveryRunner
                userDetails[row][2] = drunner.getEmail();
                userDetails[row][3] = drunner.getPhoneNo();
                row++;
                countRunner++;
            }
        }
        
        if (!email.equals("") && validateEmail(email)) {
            if (!phoneNo.equals("") && validatePhoneNo(phoneNo)) {
                if (validatePassword(password, confirmPass).equals("Valid")) {
                    for (int i = 0; i < numRows; i++) {
                        String tempcustid = "C" + countCustomer;
                        String tempvendorid = "V" + countVendor;
                        String temprunnerid = "D" + countRunner;
                        if (email.equals(userDetails[i][2])) {
                            JOptionPane.showMessageDialog(this, "Email exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        }else if(phoneNo.equals(userDetails[i][3])){
                            JOptionPane.showMessageDialog(this, "Phone Number exist!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        }else if(tempcustid.equals(userDetails[i][0])){
                            countCustomer+=1;
                        }else if(tempvendorid.equals(userDetails[i][0])){
                            countVendor+=1;
                        }else if(temprunnerid.equals(userDetails[i][0])){
                            countRunner+=1;
                        }
                    }
                    if (role.equals("Customer") && !validateAddress(address).equals("Valid")) {
                        JOptionPane.showMessageDialog(this, validateAddress(address), "ERROR", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else if (role.equals("Vendor")){
                        if(validateVendorName(vendorName).equals("Valid")) {
                            for (int i = 0; i < numRows; i++) {
                                if (vendorName.equals(userDetails[i][1])) {
                                    JOptionPane.showMessageDialog(this, "Vendor name exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }
                        }else {
                            JOptionPane.showMessageDialog(this, validateVendorName(vendorName), "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, validatePassword(password, confirmPass), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Phone number is invalid.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email is invalid.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        for (DataProvider value : container) {
            String id = generateID(role, countCustomer, countVendor, countRunner);
            if (role.equals("Customer") && value instanceof Customer) {
                customer = new Customer(id, email, phoneNo, gender, address, password);
                text.fileWrite(TextEditor.FilePaths.USER, customer);
                JOptionPane.showMessageDialog(this, "Your Registration was Successful");
                JOptionPane.showMessageDialog(this, "Generated ID is " + id);
                break;
            } else if (role.equals("Vendor") && value instanceof Vendor) {
                vendor = new Vendor(id, vendorName, email, phoneNo, gender, password);
                text.fileWrite(TextEditor.FilePaths.USER, vendor);
                JOptionPane.showMessageDialog(this, "Your Registration was Successful");
                JOptionPane.showMessageDialog(this, "Generated ID is " + id);                
                break;
            } else if (role.equals("Delivery Runner") && value instanceof DeliveryRunner) {
                deliveryrunner = new DeliveryRunner(id, email, phoneNo, gender, password);
                text.fileWrite(TextEditor.FilePaths.USER, deliveryrunner);
                JOptionPane.showMessageDialog(this, "Your Registration was Successful");
                JOptionPane.showMessageDialog(this, "Generated ID is " + id);
                break;
            }
        }
                
        // Print information for testing purposes
        List<DataProvider> container1 = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
        for (DataProvider value : container1) {
            if (value instanceof Vendor) {
                Vendor vend = (Vendor) value;
                System.out.println("VendorID: " + vend.getId());
                System.out.println("Name: " + vend.getName());
                System.out.println("Email: " + vend.getEmail());
                System.out.println("Phone Number: " + vend.getPhoneNo());
            } else if (value instanceof Customer) {
                Customer cust = (Customer) value;
                System.out.println("CustomerID: " + cust.getId());
                System.out.println("Email: " + cust.getEmail());
                System.out.println("Phone Number: " + cust.getPhoneNo());
            } else if (value instanceof DeliveryRunner) {
                DeliveryRunner drunner = (DeliveryRunner) value;
                System.out.println("RunnerID: " + drunner.getId());
                System.out.println("Email: " + drunner.getEmail());
                System.out.println("Phone Number: " + drunner.getPhoneNo());
            }
        }


    }//GEN-LAST:event_Regd_BTNActionPerformed

    private void Back_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back_BTNActionPerformed
        Admin_Main_Page MP = new Admin_Main_Page();
        MP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Back_BTNActionPerformed

    private void PN_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PN_TFActionPerformed
      
    }//GEN-LAST:event_PN_TFActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Registration_Page().setVisible(true);
            }
        });
    } 
    
    public String validateVendorName(String VN){
        String checkVN;
        if(!VN.equals("")){
            if(VN.length()>= 3){
                checkVN = "Valid";
            }else{
                checkVN = "Invalid Vendor name format (At least 3 characters and above)!";
            }
        }else{
            checkVN = "Vendor name cannnot be empty!";
        }
        return checkVN;
    }
    
    public String validateAddress(String address){
        String check;
        if(!address.equals("")){
            if(address.length()>= 20){
                check = "Valid";
            }else{
                check = "Invalid Address (At least 20 characters and above)!";
            }
        }else{
            check = "Address cannnot be empty!";
        }
        return check;
    }
    
    public String generateID(Object role, int countCustomer, int countVendor, int countRunner){
        String ID;
        if(role.equals("Customer")){
            ID = "C" + countCustomer;
        }else if(role.equals("Vendor")){
            ID = "V" + countVendor;
        }else{
            ID = "D" + countRunner;
        }
        return ID;
    }
    
    public static boolean validateEmail(String Email){
        String emailRegex =  "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(Email);
        return matcher.find();
    }
    
    public static boolean validatePhoneNo(String phoneNumber) {
        String regex = "^(\\+\\d{1,3})?\\d{10}$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    public String validatePassword(String Password, String Confirm_Password){
        String checkPassword;
        if(!Password.equals("")){
            if(!Confirm_Password.equals("")){
                if (Password.length()>= 5){
                    if(Password.equals(Confirm_Password)){
                        checkPassword = "Valid";
                    }else{
                        checkPassword = "Password and Confirm password are not the same!";
                    }
                }else{
                    checkPassword = "Password must be at least 5 characters and above!";
                }
            }else{
                checkPassword = "confirm password cannot be empty!";
            }
        }else{
            checkPassword = "Password cannot be empty!";

        }      
        return checkPassword;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address_Label;
    private javax.swing.JTextField Address_TF;
    private javax.swing.JButton Back_BTN;
    private javax.swing.JPasswordField ConfirmPass_Field;
    private javax.swing.JLabel ConfirmPass_Label;
    private javax.swing.JLabel Email_Label;
    private javax.swing.JTextField Email_TF;
    private javax.swing.JRadioButton Female_RB;
    private javax.swing.JLabel Gender_Label;
    private javax.swing.JRadioButton Male_RB;
    private javax.swing.JLabel PN_Label;
    private javax.swing.JTextField PN_TF;
    private javax.swing.JPasswordField Pass_Field;
    private javax.swing.JLabel Pass_Label;
    private javax.swing.JButton Regd_BTN;
    private javax.swing.JComboBox<String> Role_CB;
    private javax.swing.JLabel Role_Label;
    private javax.swing.JLabel VN_Label;
    private javax.swing.JTextField VN_TF;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
