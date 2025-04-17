package For_rent_the_car;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class main_admin extends javax.swing.JFrame {

    private String loggedInUserEmail;
    
    public main_admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Main Page");
        loadCarData();
    }

    private void loadCarData() {
        File file = new File("src/For_rent_the_car/cars.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Not found cars.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel normalModel = (DefaultTableModel) table_one.getModel();
        DefaultTableModel sportModel = (DefaultTableModel) table_two.getModel();
        normalModel.setRowCount(0);
        sportModel.setRowCount(0);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length == 4) {
                    String id = tokens[0].trim();
                    String brand = tokens[1].trim();
                    String carName = tokens[2].trim();
                    String carType = tokens[3].trim();
                    
                    Object[] row = {brand, carName};
                    if(carType.equalsIgnoreCase("Normal")){
                        normalModel.addRow(row);
                    } else if(carType.equalsIgnoreCase("Sport")){
                        sportModel.addRow(row);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading cars.txt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setLoggedInUserEmail(String email) {
        this.loggedInUserEmail = email;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_one = new javax.swing.JTable();
        bt_edit1 = new javax.swing.JButton();
        bt_add1 = new javax.swing.JButton();
        bt_add3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_two = new javax.swing.JTable();
        bt_edit2 = new javax.swing.JButton();
        bt_add2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_one.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Brand", "Name Car"
            }
        ));
        jScrollPane1.setViewportView(table_one);

        bt_edit1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_edit1.setText("Edit");
        bt_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit1ActionPerformed(evt);
            }
        });

        bt_add1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add1.setText("Add");

        bt_add3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add3.setText("History");
        bt_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(bt_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_add3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_edit1)
                    .addComponent(bt_add1)
                    .addComponent(bt_add3))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tab.addTab("Normal Car", jPanel1);

        table_two.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Brand", "Name Car"
            }
        ));
        jScrollPane2.setViewportView(table_two);

        bt_edit2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_edit2.setText("Edit");

        bt_add2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add2.setText("Add");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(bt_edit2)
                .addGap(78, 78, 78)
                .addComponent(bt_add2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_edit2)
                    .addComponent(bt_add2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("Sport Car", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_edit1ActionPerformed

    private void bt_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add3ActionPerformed
        System.out.println("Logged In User Email: " + loggedInUserEmail);
        history h = new history(loggedInUserEmail);
        h.setLoggedInUserEmail(loggedInUserEmail);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_add3ActionPerformed

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
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add1;
    private javax.swing.JButton bt_add2;
    private javax.swing.JButton bt_add3;
    private javax.swing.JButton bt_edit1;
    private javax.swing.JButton bt_edit2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable table_one;
    private javax.swing.JTable table_two;
    // End of variables declaration//GEN-END:variables
}
