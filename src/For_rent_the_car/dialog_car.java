package For_rent_the_car;

import java.io.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class dialog_car extends javax.swing.JFrame {

    private String operation;
    private String carId;
    private main_admin parentFrame;
    
    public dialog_car(java.awt.Frame parent, boolean modal, String operation, String id, String brand, String carName, String carType) {
        this(parent, modal, operation, id, brand, carName, carType, "");
    }
    
    public dialog_car(java.awt.Frame parent, boolean modal, String operation, String id, String brand, String carName, String carType, String price) {
        initComponents();
        this.setLocationRelativeTo(parent);
        this.operation = operation;
        this.carId = id;
        this.parentFrame = (main_admin) parent;
        setTitle(operation + " Car");

        txt_brand.setText(brand);
        txt_name.setText(carName);

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo_carType.getModel();
        if (model.getSize() <= 1) {
            model.addElement("Normal");
            model.addElement("Sport");
        }
        
        if (operation.equals("Edit")) {
            bt_ok.setText("Save");
            model.setSelectedItem(carType);
            loadCarPrice(id);
        } else if (operation.equals("Add")) {
            bt_ok.setText("Add");
            txt_brand.setText("");
            txt_name.setText("");
            txt_price.setText("");
            combo_carType.setSelectedIndex(0);
        }
    }
    
    private void loadCarPrice(String carIdToLoad) {
        File file = new File("src/For_rent_the_car/cars.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length >= 4 && tokens[0].trim().equals(carIdToLoad)) {
                    if (tokens.length > 4) {
                        txt_price.setText(tokens[4].trim());
                    } else {
                        txt_price.setText("");
                    }
                    return;
                }
            }
            txt_price.setText("");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading cars.txt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void saveCarDataToFile() {
        File file = new File("src/For_rent_the_car/cars.txt");
        ArrayList<String> lines = new ArrayList<>();
        String brand = txt_brand.getText().trim();
        String name = txt_name .getText().trim();
        String priceStr = txt_price.getText().trim();
        String type = combo_carType.getSelectedItem().toString();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (operation.equals("Edit")
                 && tokens.length >= 1
                 && tokens[0].trim().equals(carId)) {
                    lines.add(carId + "," + brand + "," + name + "," + type + "," + priceStr);
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Error reading cars.txt: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (operation.equals("Add")) {
            long maxId = 0;
            for (String l : lines) {
                String[] tok = l.split(",");
                try {
                    long id = Long.parseLong(tok[0].trim());
                    if (id > maxId) maxId = id;
                } catch (NumberFormatException ignore) {}
            }
            long newId = maxId + 1;
            lines.add(newId + "," + brand + "," + name + "," + type + "," + priceStr);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this,
                (operation.equals("Edit") ? "Save" : "Add") + " car data success",
                "Success", JOptionPane.INFORMATION_MESSAGE);

            
            dispose();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Error writing cars.txt: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lb_brand = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_price = new javax.swing.JLabel();
        txt_brand = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        bt_cancle = new javax.swing.JButton();
        bt_ok = new javax.swing.JButton();
        lb_price1 = new javax.swing.JLabel();
        combo_carType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_brand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_brand.setText("Brand");

        lb_name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_name.setText("Name");

        lb_price.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_price.setText("Price/Hour");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        bt_cancle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_cancle.setText("Cancle");
        bt_cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancleActionPerformed(evt);
            }
        });

        bt_ok.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_ok.setText("Submit");
        bt_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_okActionPerformed(evt);
            }
        });

        lb_price1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lb_price1.setText("Car type");

        combo_carType.setEditable(true);
        combo_carType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose please" }));
        combo_carType.setToolTipText("");
        combo_carType.setName(""); // NOI18N
        combo_carType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_carTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_brand)
                            .addComponent(lb_name))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txt_brand)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_price)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_price)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_cancle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(bt_ok))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_price1)
                        .addGap(33, 33, 33)
                        .addComponent(combo_carType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_brand)
                    .addComponent(txt_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_price)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_price1)
                    .addComponent(combo_carType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancle)
                    .addComponent(bt_ok))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
        String brand = txt_brand.getText().trim();
        String name = txt_name.getText().trim();
        String priceStr = txt_price.getText().trim();
        String type = combo_carType.getSelectedItem().toString();

        if (brand.isEmpty() || name.isEmpty() || priceStr.isEmpty() || type.equals("Choose please")) {
            JOptionPane.showMessageDialog(this, "Please enter all data", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            saveCarDataToFile();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter only number for Price/Hour", "Error", JOptionPane.ERROR_MESSAGE);
        }
        parentFrame.loadCarData();
    }//GEN-LAST:event_bt_okActionPerformed
    
    private void combo_carTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_carTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_carTypeActionPerformed

    private void bt_cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancleActionPerformed
        dispose();
    }//GEN-LAST:event_bt_cancleActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

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
            java.util.logging.Logger.getLogger(dialog_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialog_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialog_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialog_car.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancle;
    private javax.swing.JButton bt_ok;
    private javax.swing.JComboBox<String> combo_carType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_brand;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_price;
    private javax.swing.JLabel lb_price1;
    private javax.swing.JTextField txt_brand;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
