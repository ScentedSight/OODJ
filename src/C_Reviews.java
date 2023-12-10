import java.util.List;
import javax.swing.table.DefaultTableModel;


public class C_Reviews extends javax.swing.JFrame {
    
    private DefaultTableModel model = new DefaultTableModel();
    private String[] column = {"OrderID", "Reviews", "Rating(1-5)", "Time", "Date"};
    private List<Order> order;

    public C_Reviews(List<Order> order, String vendorName, String foodName) {
        initComponents();
        tfFoodName.setText(foodName);
        tfVendorName.setText(vendorName);
        this.order = order;
        model.setColumnIdentifiers(column);
        populateReviewTable();   
    }

    private C_Reviews() { //Obsolete
        
    }

    private void populateReviewTable() {
        for (Order orders : order) {
            String[] menu = {orders.getId(), orders.getReview(), String.valueOf(orders.getRatings()), orders.getTime(), orders.getOrderDay() + "/" + orders.getOrderMonth() + "/" + orders.getOrderYear()};
            model.addRow(menu);
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

        pnlReviews = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlReviewTable = new javax.swing.JPanel();
        scrlpnReviewTable = new javax.swing.JScrollPane();
        Reviews = new javax.swing.JTable();
        tfVendorName = new javax.swing.JTextField();
        tfFoodName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlReviews.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reviews");

        javax.swing.GroupLayout pnlReviewsLayout = new javax.swing.GroupLayout(pnlReviews);
        pnlReviews.setLayout(pnlReviewsLayout);
        pnlReviewsLayout.setHorizontalGroup(
            pnlReviewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReviewsLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        pnlReviewsLayout.setVerticalGroup(
            pnlReviewsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReviewsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlReviewTable.setBackground(new java.awt.Color(255, 255, 255));

        Reviews.setModel(model);
        scrlpnReviewTable.setViewportView(Reviews);

        tfVendorName.setEditable(false);
        tfVendorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfVendorNameActionPerformed(evt);
            }
        });

        tfFoodName.setEditable(false);

        javax.swing.GroupLayout pnlReviewTableLayout = new javax.swing.GroupLayout(pnlReviewTable);
        pnlReviewTable.setLayout(pnlReviewTableLayout);
        pnlReviewTableLayout.setHorizontalGroup(
            pnlReviewTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReviewTableLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlReviewTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlpnReviewTable, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlReviewTableLayout.createSequentialGroup()
                        .addComponent(tfVendorName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlReviewTableLayout.setVerticalGroup(
            pnlReviewTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReviewTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReviewTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVendorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrlpnReviewTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlReviews, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlReviewTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlReviews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlReviewTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfVendorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfVendorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfVendorNameActionPerformed

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
            java.util.logging.Logger.getLogger(C_Reviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(C_Reviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(C_Reviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(C_Reviews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new C_Reviews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Reviews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlReviewTable;
    private javax.swing.JPanel pnlReviews;
    private javax.swing.JScrollPane scrlpnReviewTable;
    private javax.swing.JTextField tfFoodName;
    private javax.swing.JTextField tfVendorName;
    // End of variables declaration//GEN-END:variables
}
