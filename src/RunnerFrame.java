import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RunnerFrame extends javax.swing.JFrame {

    private DeliveryRunner runner;
    private DefaultTableModel taskListModel = new DefaultTableModel();
    private DefaultTableModel tasksModel = new DefaultTableModel();
    private String[] taskListColumns = {"Order ID", "Order Placed", "Vendor", "Customer ID", "Food", "Address"};
    private String[] tasksColumns = {"Order ID", "Time Elapsed", "Vendor", "Customer ID", "Food", "Address"};
    private int taskListRow = -1; //-1 = absence of a selected row, can be used as conditions
    private int tasksRow = -1; //Different row selector for different tables
    TextEditor reader = new TextEditor();
    List<Object> container = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY));
    
    public RunnerFrame(DeliveryRunner runner) { //Runner object read from textfile and passed to runner frame after log in
        initComponents();
        taskListModel.setColumnIdentifiers(taskListColumns);
        tasksModel.setColumnIdentifiers(tasksColumns);
        this.runner = runner;
        runnerHomeTitlelbl.setText("Welcome Runner " + runner.getId()); //Set title
        
        for (Object obj : container) {
            DeliveryOrder dOrder = (DeliveryOrder) obj;
            if (dOrder.getStatusRunner().equals("SEARCHING")) {
                String[] rowDataArray = {
                    dOrder.getId(),
                    dOrder.getTime(), //Retrieve time when order was placed
                    dOrder.getVendorName(), //Retrieve vendor's name
                    dOrder.getCustomer(), //Retrieve customer ID
                    dOrder.getFood(), //Retrieve food name
                    dOrder.getAddress() //Retrieve address
                };
                taskListModel.addRow(rowDataArray);
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

        runnerHomeTitlelbl = new javax.swing.JLabel();
        runnerHomeLogOutbtn = new javax.swing.JButton();
        runnerHomeTaskpnl = new javax.swing.JScrollPane();
        runnerHomeTasklst = new javax.swing.JList<>();
        runnerHomePendingpnl = new javax.swing.JScrollPane();
        runnerHomePendinglst = new javax.swing.JList<>();
        runnerTaskAcceptbtn = new javax.swing.JButton();
        runnerHomeTaskHistbtn = new javax.swing.JButton();
        runnerHomeFailedbtn = new javax.swing.JButton();
        runnerHomeDeliveredbtn = new javax.swing.JButton();
        runnerHomeYeartxt = new javax.swing.JTextField();
        runnerHomeMonthtxt = new javax.swing.JTextField();
        runnerHomeDaylbl = new javax.swing.JLabel();
        runnerHomeMonthlbl = new javax.swing.JLabel();
        runnerHomeYearlbl = new javax.swing.JLabel();
        runnerHomeTotallbl = new javax.swing.JLabel();
        runnerHomeTotaltxt = new javax.swing.JTextField();
        runnerHomeDaytxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delivery Runner Home Page");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Runner Homepage Frame"); // NOI18N

        runnerHomeTitlelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        runnerHomeTitlelbl.setLabelFor(this);
        runnerHomeTitlelbl.setText("WELCOME HOME, DELIVERY RUNNER");
        runnerHomeTitlelbl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        runnerHomeTitlelbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        runnerHomeTitlelbl.setName("Runner Homepage Title"); // NOI18N
        getContentPane().add(runnerHomeTitlelbl);

        runnerHomeLogOutbtn.setText("LOG OUT");
        runnerHomeLogOutbtn.setName("Runner Home Page Log Out Button"); // NOI18N
        runnerHomeLogOutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runnerHomeLogOutbtnActionPerformed(evt);
            }
        });
        getContentPane().add(runnerHomeLogOutbtn);

        runnerHomeTaskpnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tasks", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        runnerHomeTaskpnl.setName("Runner Home Page Task List"); // NOI18N

        runnerHomeTasklst.setName("Runner Home Page Task Listbox"); // NOI18N
        runnerHomeTaskpnl.setViewportView(runnerHomeTasklst);

        getContentPane().add(runnerHomeTaskpnl);

        runnerHomePendingpnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pending Tasks", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        runnerHomePendingpnl.setName("Runner Home Page Pending Task Scrollpanel"); // NOI18N

        runnerHomePendinglst.setName("Runner Home Page Pending Task Listbox"); // NOI18N
        runnerHomePendingpnl.setViewportView(runnerHomePendinglst);
        runnerHomePendinglst.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(runnerHomePendingpnl);

        runnerTaskAcceptbtn.setText("Accept");
        runnerTaskAcceptbtn.setName("Runner Home Page Accept Task Button"); // NOI18N
        runnerTaskAcceptbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                runnerTaskAcceptbtnMouseClicked(evt);
            }
        });
        runnerTaskAcceptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runnerTaskAcceptbtnActionPerformed(evt);
            }
        });
        getContentPane().add(runnerTaskAcceptbtn);

        runnerHomeTaskHistbtn.setText("Task History");
        runnerHomeTaskHistbtn.setName("Runner Home Page Task History Button"); // NOI18N
        getContentPane().add(runnerHomeTaskHistbtn);

        runnerHomeFailedbtn.setText("Failed");
        runnerHomeFailedbtn.setName("Runner Home Page Delivery Failed Button"); // NOI18N
        getContentPane().add(runnerHomeFailedbtn);

        runnerHomeDeliveredbtn.setText("Delivered");
        runnerHomeDeliveredbtn.setName("Runner Home Page Delivered Button"); // NOI18N
        runnerHomeDeliveredbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                runnerHomeDeliveredbtnMouseClicked(evt);
            }
        });
        getContentPane().add(runnerHomeDeliveredbtn);

        runnerHomeYeartxt.setText("jTextField2");
        runnerHomeYeartxt.setName("Runner Home Page Yearly Revenue Text Field"); // NOI18N
        getContentPane().add(runnerHomeYeartxt);

        runnerHomeMonthtxt.setText("jTextField3");
        runnerHomeMonthtxt.setName("Runner Home Page Monthly Revenue Text Field"); // NOI18N
        getContentPane().add(runnerHomeMonthtxt);

        runnerHomeDaylbl.setText("Day:");
        runnerHomeDaylbl.setName("Runner Home Page Daily Revenue Label"); // NOI18N
        getContentPane().add(runnerHomeDaylbl);

        runnerHomeMonthlbl.setText("Month:");
        runnerHomeMonthlbl.setName("Runner Home Page Monthly Revenue Label"); // NOI18N
        getContentPane().add(runnerHomeMonthlbl);

        runnerHomeYearlbl.setText("Year:");
        runnerHomeYearlbl.setName("Runner Home Page Yearly Revenue Label"); // NOI18N
        getContentPane().add(runnerHomeYearlbl);

        runnerHomeTotallbl.setText("Total:");
        runnerHomeTotallbl.setName("Runner Home Page Total Revenue Label"); // NOI18N
        getContentPane().add(runnerHomeTotallbl);

        runnerHomeTotaltxt.setText("jTextField4");
        runnerHomeTotaltxt.setName("Runner Home Page Total Revenue Text Field"); // NOI18N
        getContentPane().add(runnerHomeTotaltxt);

        runnerHomeDaytxt.setText("jTextField1");
        runnerHomeDaytxt.setName("Runner Home Page Daily Revenue Textfield"); // NOI18N
        runnerHomeDaytxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runnerHomeDaytxtActionPerformed(evt);
            }
        });
        getContentPane().add(runnerHomeDaytxt);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runnerHomeLogOutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runnerHomeLogOutbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runnerHomeLogOutbtnActionPerformed

    private void runnerTaskAcceptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runnerTaskAcceptbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runnerTaskAcceptbtnActionPerformed

    private void runnerHomeDaytxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runnerHomeDaytxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runnerHomeDaytxtActionPerformed

    private void runnerHomeTaskstblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runnerHomeTaskstblMouseReleased
        taskListRow = runnerHomeTaskListtbl.getSelectedRow();
    }//GEN-LAST:event_runnerHomeTaskstblMouseReleased

    private void runnerHomeTaskListtblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runnerHomeTaskListtblMouseReleased
        tasksRow = runnerHomeTaskstbl.getSelectedRow();
    }//GEN-LAST:event_runnerHomeTaskListtblMouseReleased

    private void runnerTaskAcceptbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runnerTaskAcceptbtnMouseClicked
        if (taskListRow != -1) { //Fill tasks table with accepted deliveries
            String[] valuesForRow = new String[6];
            for (int columnCounter = 0; columnCounter <= 5; columnCounter++) {
                valuesForRow[columnCounter] = String.valueOf(taskListModel.getValueAt(taskListRow, columnCounter)); //Insert value into tasks table column by column in the selected row from tasks list table
            }
            taskListModel.addRow(valuesForRow);
            for (Object obj : container) { //Finalise delivery order by plugging in extra properties
                DeliveryOrder dOrder = (DeliveryOrder) obj;
                if (dOrder.getId().equals(String.valueOf(taskListModel.getValueAt(taskListRow, 0)))) {
                    dOrder.setRunner(runner); //Set the current runner
                    dOrder.setRunnerStatus(Order.Status.DELIVERING); //Set status
                    dOrder.setTime(); //Set current time
                    reader.textDelete(TextEditor.FilePaths.HISTORY, dOrder);
                    reader.fileWrite(TextEditor.FilePaths.HISTORY, dOrder); //Rewrite it all back
                    break;
                }
            }
        }
    }//GEN-LAST:event_runnerTaskAcceptbtnMouseClicked

    private void runnerHomeDeliveredbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_runnerHomeDeliveredbtnMouseClicked
        if (tasksRow != -1) { //Fill tasks table with accepted deliveries
            tasksModel.removeRow(tasksRow);
            List<Object> tasksContainer = new ArrayList(reader.fileReader(TextEditor.FilePaths.HISTORY));
            for (Object obj : tasksContainer) { //Finalise delivery order by plugging in extra properties
                DeliveryOrder dOrder = (DeliveryOrder) obj;
                if (dOrder.getId().equals(String.valueOf(tasksModel.getValueAt(tasksRow, 0)))) {
                    dOrder.setRunnerStatus(Order.Status.DELIVERED); //Set status
                    dOrder.setTime(); //Set current time
                    dOrder.runnerProfit();
                    reader.textDelete(TextEditor.FilePaths.HISTORY, dOrder);
                    reader.fileWrite(TextEditor.FilePaths.HISTORY, dOrder); //Rewrite it all back
                    break;
                }
            }
        }
    }//GEN-LAST:event_runnerHomeDeliveredbtnMouseClicked

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
            java.util.logging.Logger.getLogger(RunnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RunnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RunnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RunnerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RunnerFrame().setVisible(true);
                int i = 5;
                TextEditor textEditor = new TextEditor();
                while (i > 0) {
                textEditor.fileReader(TextEditor.FilePaths.ORDER, runner);
                runnerHomeTasklst.
            }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel runnerHomeDaylbl;
    private javax.swing.JTextField runnerHomeDaytxt;
    private javax.swing.JButton runnerHomeDeliveredbtn;
    private javax.swing.JButton runnerHomeFailedbtn;
    private javax.swing.JButton runnerHomeLogOutbtn;
    private javax.swing.JLabel runnerHomeMonthlbl;
    private javax.swing.JTextField runnerHomeMonthtxt;
    private javax.swing.JList<String> runnerHomePendinglst;
    private javax.swing.JScrollPane runnerHomePendingpnl;
    private javax.swing.JButton runnerHomeTaskHistbtn;
    private javax.swing.JList<String> runnerHomeTasklst;
    private javax.swing.JScrollPane runnerHomeTaskpnl;
    private javax.swing.JLabel runnerHomeTitlelbl;
    private javax.swing.JLabel runnerHomeTotallbl;
    private javax.swing.JTextField runnerHomeTotaltxt;
    private javax.swing.JLabel runnerHomeYearlbl;
    private javax.swing.JTextField runnerHomeYeartxt;
    private javax.swing.JButton runnerTaskAcceptbtn;
    // End of variables declaration//GEN-END:variables
}
