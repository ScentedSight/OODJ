import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Login_Page extends javax.swing.JFrame {
    TextEditor text;
    Customer customer;
    Vendor vendor;
    DeliveryRunner runner;
    Administrator admin;
    public Login_Page() {
        initComponents();
        text = new TextEditor();
        admin = new Administrator();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Username_Check = new javax.swing.JLabel();
        Pass_Label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Pass_Field = new javax.swing.JPasswordField();
        Username_Label = new javax.swing.JLabel();
        ID_TF = new javax.swing.JTextField();
        Login_BTN = new javax.swing.JButton();
        Pass_Check = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));

        Username_Check.setForeground(new java.awt.Color(255, 0, 0));

        Pass_Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pass_Label.setForeground(new java.awt.Color(255, 255, 255));
        Pass_Label.setText("Password:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login Page");

        Username_Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Username_Label.setForeground(new java.awt.Color(255, 255, 255));
        Username_Label.setText("ID:");

        ID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_TFActionPerformed(evt);
            }
        });

        Login_BTN.setBackground(new java.awt.Color(102, 153, 255));
        Login_BTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Login_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Login_BTN.setText("Login");
        Login_BTN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Login_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_BTNActionPerformed(evt);
            }
        });

        Pass_Check.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pass_Check.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ID_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(Username_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(Username_Check, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Pass_Field)
                            .addComponent(Pass_Check)
                            .addComponent(Pass_Label)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(Login_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addComponent(Username_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(Username_Check)
                .addGap(12, 12, 12)
                .addComponent(Pass_Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pass_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(Pass_Check)
                .addGap(31, 31, 31)
                .addComponent(Login_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_TFActionPerformed

    private void Login_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_BTNActionPerformed
        Username_Check.setText(null);
        Pass_Check.setText(null);
        
        String ID = ID_TF.getText();
        String Pass = Pass_Field.getText();
        
        int numRows = 100;
        int numCols = 20;        
        
        List<DataProvider> container = new ArrayList<>(text.fileReader(TextEditor.FilePaths.USER));
        String[][] userDetails = new String[numRows][numCols];

        int row = 0;
        for (DataProvider value : container) {
            if (value instanceof Vendor) {
                Vendor vend = (Vendor) value;
                userDetails[row][0] = vend.getId();
                userDetails[row][1] = vend.getPass();
            } else if (value instanceof Customer) {
                Customer cust = (Customer) value;
                userDetails[row][0] = cust.getId();
                userDetails[row][1] = cust.getPass();  
            } else if (value instanceof DeliveryRunner) {
                DeliveryRunner drunner = (DeliveryRunner) value;
                userDetails[row][0] = drunner.getId();
                userDetails[row][1] = drunner.getPass();  
            }else if(value instanceof Administrator){
                Administrator ad = (Administrator) value;
                userDetails[row][0] = ad.getId();
                userDetails[row][1] = ad.getPass();  
            }
            row++;
        }
        
        int error = 0;
        if (!ID.equals("")){
            if(!Pass.equals("")){
                if(ID.equals(admin.getid())){
                    if(Pass.equals(admin.getPass())){
                        Admin_Main_Page mainPage = new Admin_Main_Page();
                        mainPage.setVisible(true);
                        this.dispose();
                    }else{
                        Pass_Check.setText("Incorrect Password!");
                        error = 2;
                    }
                }else{
                    for (int i = 0; i < numRows; i++) {
                        if(ID.equals(userDetails[i][0])){
                            if(Pass.equals(userDetails[i][1])){
                                char User = ID.charAt(0);
                                userLogin(User, ID, Pass);
                                return;
                            }else{
                                Pass_Check.setText("Incorrect Password!");
                                error = 2;
                                break;
                            }
                        }
                    }
                }
                if(error != 2){
                    Username_Check.setText("ID does not exist!");
                }
            }else{
                Pass_Check.setText("Please fill in your Password!");
            }
        }else{
            Username_Check.setText("Please fill in your ID!");
        }
        
        
        
    }//GEN-LAST:event_Login_BTNActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Page().setVisible(true);
            }
        });
    }
    
    public void userLogin(char UserChar, String ID, String Pass){
        String user = String.valueOf(UserChar);
        switch (user) {
            case "C":
                customer = new Customer(ID, Pass);
                JOptionPane.showMessageDialog(this,"Welcome Back " +customer.getId()+ " !");
                C_MenuFrame cmenu = new C_MenuFrame(customer);
                cmenu.setVisible(true);
                this.dispose();
                break;
            case "V":
                vendor = new Vendor(ID, Pass);
                JOptionPane.showMessageDialog(this,"Welcome Back " +vendor.getId()+ " !");
                VendorFrame VF = new VendorFrame(vendor);
                VF.setVisible(true);
                this.dispose();
                break;
            case "D":
                runner = new DeliveryRunner(ID, Pass);
                JOptionPane.showMessageDialog(this,"Welcome Back " +runner.getId()+ " !");
                RunnerFrame RF = new RunnerFrame(runner);
                RF.setVisible(true);
                this.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(this,"Please try again!","Error",JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_TF;
    private javax.swing.JButton Login_BTN;
    private javax.swing.JLabel Pass_Check;
    private javax.swing.JPasswordField Pass_Field;
    private javax.swing.JLabel Pass_Label;
    private javax.swing.JLabel Username_Check;
    private javax.swing.JLabel Username_Label;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
