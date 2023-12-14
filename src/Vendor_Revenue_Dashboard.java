
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 110ti
 */
public class Vendor_Revenue_Dashboard extends javax.swing.JFrame {
    private String id,date,remark;
    private String year,month;
    private double profit;
    private DefaultTableModel revenueModel = new DefaultTableModel();
    private String[] revenuecol={"OrderID","Food Name","Review","Ratings","Date","Time","Remarks","Income(RM)"};
    private int revenueRow = -1,rowsCount;
    private Vendor vendor;
    
    TextEditor reader = new TextEditor();       // for order history
    
    public Vendor_Revenue_Dashboard() {
        initComponents();
        revenueModel.setColumnIdentifiers(revenuecol);
        setTitle("Revenue Dashboard");
    }
    
    public Vendor_Revenue_Dashboard(Vendor vendor) {
        initComponents();
        setTitle("Revenue Dashboard");
        revenueModel.setColumnIdentifiers(revenuecol);
        this.vendor = vendor;
        comboMonth.setSelectedIndex(-1);        //do not selected item in initial
        comboYear.setSelectedIndex(-1);       //do not selected item in initial
        
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj : container) {
            if (obj instanceof DeliveryOrder) {
                DeliveryOrder O = (DeliveryOrder) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    if (status.equals("COMPLETED")) {
                        remark = "Dine in";
                        break;
                    } else if (status.equals("PICKED_UP")) {        //delivery use deliveryOrder, do not same
                        remark = "Take away";
                        break;
                    } else {
                        remark = " ";
                        break;
                    }
                }
            } else if (obj instanceof Order) {
                Order O = (Order) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    if (status.equals("COMPLETED")) {
                        remark = "Dine in";
                        break;
                    } else if (status.equals("PICKED_UP")) {        //delivery use deliveryOrder, do not same
                        remark = "Take away";
                        break;
                    } else {
                        remark = " ";
                        break;
                    }
                }
            }
            viewAllOrderHistory(vendor.getId());
        }
    }
    
    public String filterMonth(){
        int i=comboMonth.getSelectedIndex();        //get selected month
        
        if (i!=-1){
            switch(i){
            case 0:
                month="1";
                break;
            case 1:
                month="2";
                break;
            case 2:
                month="3";
                break;
            case 3:
                month="4";
                break;
            case 4:
                month="5";
                break;
            case 5:
                month="6";
                break;
            case 6:
                month="7";
                break;
            case 7:
                month="8";
                break;
            case 8:
                month="9";
                break;
            case 9:
                month="10";
                break;
            case 10:
                month="11";
                break;
            case 11:
                month="12";
                break;
            default:
                break;
            }
        }
        else {
            System.out.println("Please select month.");
        }
        System.out.println("Please select month."+month);
        return month;
    }
    
    public String filterYear(){
        int i=comboYear.getSelectedIndex();         //get selected year
        
        if(i!=-1){
           switch(i){
            case 0:
                year="2023";
                break;
            case 1:
                year="2022";
                break;  
            case 2:
                year="2021";
                break;
            default:
                break;
            } 
        }
        else{
            System.out.println("Please select year.");
        }
        System.out.println("Please select year."+year);
        return year;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRevenue = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        LabelAverageIncome = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Revenue Dashboard");

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        comboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMonthActionPerformed(evt);
            }
        });

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021" }));
        comboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYearActionPerformed(evt);
            }
        });

        tableRevenue.setModel(revenueModel);
        jScrollPane1.setViewportView(tableRevenue);

        jLabel2.setText("Total Revenue:");

        jLabel3.setText("Average Income:");

        LabelTotal.setText("RM");

        LabelAverageIncome.setText("RM");

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelAverageIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                                .addComponent(btnView)
                                .addGap(18, 18, 18)
                                .addComponent(btnQuit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LabelTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(LabelAverageIncome))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnQuit)
                        .addComponent(btnView)))
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(64, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMonthActionPerformed
       filterMonth();
       
    }//GEN-LAST:event_comboMonthActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        VendorFrame v = new VendorFrame(vendor);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void comboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYearActionPerformed
        filterYear();
    }//GEN-LAST:event_comboYearActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (year != null && !year.isEmpty()&& month != null && !month.isEmpty()) {   
            viewOrderHistory(vendor.getId());
        }else{
            JOptionPane.showMessageDialog(this, "Please select the year and month!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnViewActionPerformed

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
            java.util.logging.Logger.getLogger(Vendor_Revenue_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendor_Revenue_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendor_Revenue_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendor_Revenue_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendor_Revenue_Dashboard().setVisible(true);
            }
        });
    }
    
    
    public void viewOrderHistory(String id) {
        List<Object> container = new ArrayList<>(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        int rowCount = 0;
        double totalProfit = 0;
        // Clear existing rows in the model
        revenueModel.setRowCount(0);
        for (Object obj : container) {
            if (obj instanceof DeliveryOrder) {
                DeliveryOrder O = (DeliveryOrder) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    if (String.valueOf(O.getOrderYear()).equals(year)&& String.valueOf(O.getOrderMonth()).equals(month)){
                        String[] OrderHistVendorArray = {
                            O.getId(),
                            O.getFood(),
                            O.getReview(),
                            String.valueOf(O.getRatings()),
                            date = O.getOrderDay() + "/" + O.getOrderMonth() + "/" + O.getOrderYear(),
                            O.getTime(),
                            O.getRemark(),
                            Double.toString(O.getCost()),};
                        totalProfit += (O.getCost()-2);         //not include delivery fee
                        rowCount++;
                        revenueModel.addRow(OrderHistVendorArray);
                    }
                }
            } else if (obj instanceof Order) {
                Order O = (Order) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    if (String.valueOf(O.getOrderYear()).equals(year) && String.valueOf(O.getOrderMonth()).equals(month)) {
                        String[] OrderHistVendorArray = {
                            O.getId(),
                            O.getFood(),
                            O.getReview(),
                            String.valueOf(O.getRatings()),
                            date = O.getOrderDay() + "/" + O.getOrderMonth() + "/" + O.getOrderYear(),
                            O.getTime(),
                            O.getRemark(),
                            Double.toString(O.getCost()),};
                        totalProfit += O.getCost();
                        rowCount++;
                        revenueModel.addRow(OrderHistVendorArray);
                    }
                }
            }
        }
        // Update the labels with total profit and average income
        LabelTotal.setText("RM" + totalProfit);
        DecimalFormat df = new DecimalFormat("0.00");
        LabelAverageIncome.setText("RM" + df.format(totalProfit / rowCount));
    }

    
    public void viewAllOrderHistory(String id) {
        int rowCount = 0;
        double totalProfit = 0;
        List<Object> container = new ArrayList(TextEditor.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj : container) {
            if (obj instanceof DeliveryOrder) {
                DeliveryOrder O = (DeliveryOrder) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    // filter for year only, show all result for months
                    String[] OrderHistVendorArray = {
                        O.getId(),
                        O.getFood(),
                        O.getReview(),
                        String.valueOf(O.getRatings()),
                        date = O.getOrderDay() + "/" + O.getOrderMonth() + "/" + O.getOrderYear(),
                        O.getTime(),
                        O.getRemark(),
                        Double.toString(O.getCost()),};
                    totalProfit += (O.getCost()-2);         //not include delivery fee
                    rowCount++;
                    revenueModel.addRow(OrderHistVendorArray);
                }
            } else if (obj instanceof Order) {
                Order O = (Order) obj;
                String status = O.getStatus();
                if (O.getVendorID().equals(id) && status.equals("COMPLETED") || status.equals("PICKED_UP")) {
                    // filter for year only, show all result for months
                    String[] OrderHistVendorArray = {
                        O.getId(),
                        O.getFood(),
                        O.getReview(),
                        String.valueOf(O.getRatings()),
                        date = O.getOrderDay() + "/" + O.getOrderMonth() + "/" + O.getOrderYear(),
                        O.getTime(),
                        O.getRemark(),
                        Double.toString(O.getCost()),};
                    totalProfit += O.getCost();
                    rowCount++;
                    revenueModel.addRow(OrderHistVendorArray);
                }
            }
            LabelTotal.setText("RM" + totalProfit);
            DecimalFormat df = new DecimalFormat("0.00");
            LabelAverageIncome.setText("RM" + df.format(totalProfit / rowCount));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAverageIncome;
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRevenue;
    // End of variables declaration//GEN-END:variables
}
