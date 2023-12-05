

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author huach
 */
public class RevenueDashboardVendor extends JFrame {

    private String id,date,remark;
    private String year,month;
    private double profit;
    private DefaultTableModel revenueModel = new DefaultTableModel();
    private String[] revenuecol={"OrderID","Food Name","Review","Ratings","Date","Time","Remarks","Income(RM)"};
    private int revenueRow = -1,rowsCount;
    
    TextEditor reader = new TextEditor();       // for order history
    
    public RevenueDashboardVendor() {
        initComponents();
        revenueModel.setColumnIdentifiers(revenuecol);
        setTitle("Revenue Dashboard");
    }
    
    public RevenueDashboardVendor(String vendorID) {
        initComponents();
        revenueModel.setColumnIdentifiers(revenuecol);
        id=vendorID;
        
        List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY));
        for (Object obj : container) {          
            Order O = (Order) obj;
            String status=O.getStatus();     
            
            if (O.getVendorID().equals(id) && status.equals("COMPLETED" )|| status.equals("PICKED_UP")) {
                if (status.equals("COMPLETED")){
                    remark="Dine in";
                }
                else if(status.equals("PICKED_UP")){        //delivery use deliveryOrder, do not same
                    remark="Take away";
                }
                else{
                    remark=null;
                }
            }
            
            if (!(String.valueOf(O.getOrderMonth()).equals(" "))){
                if(String.valueOf(O.getOrderMonth()).equals(month) && String.valueOf(O.getOrderYear()).equals(year)){
                //filter month & year together
                String[] OrderHistVendorArray = {
                    O.getId(),
                    O.getFood(),
                    O.getReview(),
                    String.valueOf(O.getRatings()),
                    date=O.getOrderDay()+"/"+month+"/"+year,
                    O.getTime(),
                    remark,
                    Double.toString(O.getCost()),
                };
                revenueModel.addRow(OrderHistVendorArray);
                profit=profit+O.getCost();
                }
            }
            else if (month.equals(" ") && String.valueOf(O.getOrderYear()).equals(year)){
                // filter for year only, show all result for months
                String[] OrderHistVendorArray = {
                    O.getId(),
                    O.getFood(),
                    O.getReview(),
                    String.valueOf(O.getRatings()),
                    date=O.getOrderDay()+"/"+O.getOrderMonth()+"/"+year,
                    O.getTime(),
                    remark,
                    Double.toString(O.getCost()),
                };
                revenueModel.addRow(OrderHistVendorArray);
                profit=profit+O.getCost();
                }
            }
            lblTotal.setText("RM"+profit);
            rowsCount=tableRevenue.getRowCount();
            lblaverage.setText("RM"+profit/rowsCount);
        
    }
    
    public void filterMonth(){
        comboMonth.setSelectedIndex(-1);        //do not selected item in initial
        int i=comboMonth.getSelectedIndex();        //get selected month
        
        switch(i){
            case 0:
                month=" ";
                break;
            case 1:
                month="January";
                break;
            case 2:
                month="February";
                break;
            case 3:
                month="March";
                break;
            case 4:
                month="April";
                break;
            case 5:
                month="May";
                break;
            case 6:
                month="June";
                break;
            case 7:
                month="July";
                break;
            case 8:
                month="August";
                break;
            case 9:
                month="September";
                break;
            case 10:
                month="October";
                break;
            case 11:
                month="November";
                break;
            case 12:
                month="December";
                break;
            default:
                break;
        }
    }
    
    public void filterYear(){
        comboYear.setSelectedIndex(-1);       //do not selected item in initial
        int i=comboYear.getSelectedIndex();         //get selected year
        
        switch(i){
            case 0:
                year="2021";
                break;
            case 1:
                year="2022";
                break;  
            case 2:
                year="2023";
                break;
            default:
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRevenue = new javax.swing.JTable();
        comboMonth = new javax.swing.JComboBox<>();
        lblTotalRevenue = new javax.swing.JLabel();
        comboYear = new javax.swing.JComboBox<>();
        btnQuit = new javax.swing.JButton();
        lblRevenue = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        lblaverageRevenue = new javax.swing.JLabel();
        lblaverage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));
        setForeground(new java.awt.Color(51, 204, 255));

        tableRevenue.setModel(revenueModel);
        tableRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRevenueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRevenue);

        comboMonth.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ","Jan","Feb","Mac","April","May","June","July","Aug","Sep","Oct","Nov","Dec"}));
        comboMonth.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                comboMonthComponentAdded(evt);
            }
        });
        comboMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMonthItemStateChanged(evt);
            }
        });
        comboMonth.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                comboMonthComponentMoved(evt);
            }
        });
        comboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMonthActionPerformed(evt);
            }
        });

        lblTotalRevenue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotalRevenue.setText("Total Revenue:");

        comboYear.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021","2022","2023" }));
        comboYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboYearItemStateChanged(evt);
            }
        });
        comboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboYearActionPerformed(evt);
            }
        });

        btnQuit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        lblRevenue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRevenue.setText("Revenue Dashboard");

        lblTotal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotal.setText("RM");
        lblTotal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTotalPropertyChange(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        lblaverageRevenue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblaverageRevenue.setText("Average Income: ");

        lblaverage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblaverage.setText("RM ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblaverageRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblaverage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(524, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRevenue)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblaverageRevenue)
                    .addComponent(lblaverage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuit)
                    .addComponent(btnView))
                .addGap(9, 9, 9))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(lblRevenue)
                    .addContainerGap(359, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
            VendorFrame v=new VendorFrame();
            v.setVisible(true);
            RevenueDashboardVendor o= new RevenueDashboardVendor();
            o.setVisible(false);
    }//GEN-LAST:event_btnQuitActionPerformed

      
    private void comboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMonthActionPerformed
            filterMonth();
        
    }//GEN-LAST:event_comboMonthActionPerformed

    private void comboMonthComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_comboMonthComponentMoved
        
    }//GEN-LAST:event_comboMonthComponentMoved

    private void comboMonthComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_comboMonthComponentAdded
        
    }//GEN-LAST:event_comboMonthComponentAdded

    private void comboMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMonthItemStateChanged
        
    }//GEN-LAST:event_comboMonthItemStateChanged

    private void comboYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboYearItemStateChanged
        
    }//GEN-LAST:event_comboYearItemStateChanged

    private void lblTotalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblTotalPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalPropertyChange

    private void comboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboYearActionPerformed
        filterYear();
    }//GEN-LAST:event_comboYearActionPerformed

    private void tableRevenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRevenueMouseClicked
        
    }//GEN-LAST:event_tableRevenueMouseClicked

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        int selectedRow=tableRevenue.getSelectedColumn();              
        if (selectedRow != -1) {        // Check if a row is selected
            int modelRow = tableRevenue.convertRowIndexToModel(selectedRow);
            System.out.println("Selected Model Row: " + modelRow);  
        }   
        else {
        System.out.println("No row selected.");
        }
    }//GEN-LAST:event_btnViewActionPerformed

    
    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevenueDashboardVendor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRevenue;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalRevenue;
    private javax.swing.JLabel lblaverage;
    private javax.swing.JLabel lblaverageRevenue;
    private javax.swing.JTable tableRevenue;
    // End of variables declaration//GEN-END:variables
}
