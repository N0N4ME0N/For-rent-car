package For_rent_the_car;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class main_admin extends javax.swing.JFrame {

    private String loggedInUserEmail;
    
    public main_admin(String email) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Main Page");
        this.loggedInUserEmail = email;
        System.out.println("Logged In User Email: " + loggedInUserEmail);
        loadCarData();

        table_one.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean isSelected = table_one.getSelectedRow() != -1;
                bt_edit1.setEnabled(isSelected);
            }
        });
        
        table_two.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                boolean isSelected = table_two.getSelectedRow() != -1;
                bt_edit2.setEnabled(isSelected);
            }
        });
        
        bt_add1.addActionListener(e -> {
            dialog_car addDialog = new dialog_car(this, true, "Add", "", "", "", "Normal");
            addDialog.setVisible(true);
            loadCarData();
        });

        bt_add2.addActionListener(e -> {
            dialog_car addDialog = new dialog_car(this, true, "Add", "", "", "", "Sport");
            addDialog.setVisible(true);
            loadCarData();
        });
        
        bt_del1.addActionListener(e -> deleteSelectedCar(table_one));
        bt_del2.addActionListener(e -> deleteSelectedCar(table_two));
    }

    private void deleteSelectedCar(JTable table) {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a car first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String idToDelete = table.getModel().getValueAt(row, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete car ID " + idToDelete + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        if (confirm != JOptionPane.YES_OPTION) return;

        File file = new File("src/For_rent_the_car/cars.txt");
        java.util.List<String> remaining = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] tok = line.split(",");
            if (!tok[0].trim().equals(idToDelete)) {
                remaining.add(line);
            }
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error reading cars.txt: " + ex.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
        for (String l : remaining) {
            bw.write(l);
            bw.newLine();
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Error writing cars.txt: " + ex.getMessage(),
                                      "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    loadCarData(); 
    JOptionPane.showMessageDialog(this, "Delete successful", "Info", JOptionPane.INFORMATION_MESSAGE);
}
    
    void loadCarData() {
        File file = new File("src/For_rent_the_car/cars.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Not found cars.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel normalModel = (DefaultTableModel) table_one.getModel();
        DefaultTableModel sportModel = (DefaultTableModel) table_two.getModel();
        normalModel.setRowCount(0);
        sportModel.setRowCount(0);
        
        normalModel.setColumnIdentifiers(new Object[]{"ID", "Brand", "Name Car", "Car Type", "Price/Hour"});
        sportModel.setColumnIdentifiers(new Object[]{"ID", "Brand", "Name Car", "Car Type", "Price/Hour"});
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 5) {
                    String id = tokens[0].trim();
                    String brand = tokens[1].trim();
                    String carName = tokens[2].trim();
                    String carType = tokens[3].trim();
                    String price = tokens[4].trim();

                    Object[] row = {id, brand, carName, carType, price}; 
                    if (carType.equalsIgnoreCase("Normal")) {
                        normalModel.addRow(row);
                    } else if (carType.equalsIgnoreCase("Sport")) {
                        sportModel.addRow(row);
                    }
                } else if (tokens.length == 4) {
                    String id = tokens[0].trim();
                    String brand = tokens[1].trim();
                    String carName = tokens[2].trim();
                    String carType = tokens[3].trim();
                    String price = "";

                    Object[] row = {id, brand, carName, carType, price};
                    if (carType.equalsIgnoreCase("Normal")) {
                        normalModel.addRow(row);
                    } else if (carType.equalsIgnoreCase("Sport")) {
                        sportModel.addRow(row);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading cars.txt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        bt_del1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_two = new javax.swing.JTable();
        bt_edit2 = new javax.swing.JButton();
        bt_add2 = new javax.swing.JButton();
        bt_del2 = new javax.swing.JButton();
        bt_add18 = new javax.swing.JButton();

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
        bt_edit1.setEnabled(false);
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

        bt_del1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_del1.setText("Delete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(bt_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_add3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_add1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(bt_del1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_edit1)
                    .addComponent(bt_add1)
                    .addComponent(bt_del1))
                .addGap(18, 18, 18)
                .addComponent(bt_add3)
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
        bt_edit2.setEnabled(false);
        bt_edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_edit2ActionPerformed(evt);
            }
        });

        bt_add2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add2.setText("Add");
        bt_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_add2ActionPerformed(evt);
            }
        });

        bt_del2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_del2.setText("Delete");

        bt_add18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add18.setText("History");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(bt_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_add18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bt_add2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(bt_del2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_del2)
                    .addComponent(bt_add2)
                    .addComponent(bt_edit2))
                .addGap(18, 18, 18)
                .addComponent(bt_add18)
                .addContainerGap(18, Short.MAX_VALUE))
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
        int selectedRow = table_one.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table_one.getModel();
            String brand = (String) model.getValueAt(selectedRow, 0);
            String carName = (String) model.getValueAt(selectedRow, 1);
            String id = (String) model.getValueAt(selectedRow, 2);
            String carType = (String) model.getValueAt(selectedRow, 3);
            String price = (String) model.getValueAt(selectedRow, 4);

            dialog_car editDialog = new dialog_car(this, true, "Edit", id, brand, carName, carType, price); // ส่ง carType และ price
            editDialog.setVisible(true);

            loadCarData();
        } else {
            JOptionPane.showMessageDialog(this, "Please Choose car to edit", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_edit1ActionPerformed

    private void bt_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add3ActionPerformed
        history h = new history(loggedInUserEmail);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bt_add3ActionPerformed

    private void bt_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_add2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_add2ActionPerformed

    private void bt_edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_edit2ActionPerformed
        int selectedRow = table_two.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) table_two.getModel();
            String brand = (String) model.getValueAt(selectedRow, 0);
            String carName = (String) model.getValueAt(selectedRow, 1);
            String id = (String) model.getValueAt(selectedRow, 2);
            String carType = (String) model.getValueAt(selectedRow, 3);
            String price = (String) model.getValueAt(selectedRow, 4);

            dialog_car editDialog = new dialog_car(this, true, "Edit", id, brand, carName, carType, price); // ส่ง carType และ price
            editDialog.setVisible(true);

            loadCarData();
        } else {
            JOptionPane.showMessageDialog(this, "Please Choose car to edit", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bt_edit2ActionPerformed

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
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add1;
    private javax.swing.JButton bt_add18;
    private javax.swing.JButton bt_add2;
    private javax.swing.JButton bt_add3;
    private javax.swing.JButton bt_del1;
    private javax.swing.JButton bt_del2;
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
