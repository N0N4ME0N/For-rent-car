package For_rent_the_car;

import java.io.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class register extends javax.swing.JFrame {

    public register() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Register ");
        
        icon_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        icon_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new login().setVisible(true);
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_register = new javax.swing.JLabel();
        icon_user = new javax.swing.JLabel();
        icon_password = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        bt_reset = new javax.swing.JButton();
        bt_Submit = new javax.swing.JButton();
        icon_close = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setToolTipText("");

        txt_register.setBackground(new java.awt.Color(51, 255, 0));
        txt_register.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_register.setText("Register");
        txt_register.setAutoscrolls(true);

        icon_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/user-2-24.png"))); // NOI18N

        icon_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/key-4-24.png"))); // NOI18N

        bt_reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/undo-2-24.png"))); // NOI18N
        bt_reset.setText("Reset");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });

        bt_Submit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_Submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/login-24.png"))); // NOI18N
        bt_Submit.setText("Submit");
        bt_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SubmitActionPerformed(evt);
            }
        });

        icon_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/close-window-24.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_password)
                    .addComponent(icon_user))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt_reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(bt_Submit))
                    .addComponent(txt_user)
                    .addComponent(txt_password))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 360, Short.MAX_VALUE)
                        .addComponent(icon_close)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(icon_close)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_register)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_user)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_reset, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(bt_Submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SubmitActionPerformed
        String email = txt_user.getText().trim();
        String password = txt_password.getText().trim();
        
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Plaase enter email or password", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        File file = new File("src/For_rent_the_car/users.txt");
        int newId = 1;
        try {
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] tokens = line.split(",");
                    if (tokens.length >= 1) {
                        try {
                            int id = Integer.parseInt(tokens[0].trim());
                            if (id >= newId) {
                                newId = id + 1;
                            }
                        } catch(NumberFormatException ex) {
                        }
                    }
                }
                br.close();
            } else {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fail to read file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            String record = newId + "," + email + "," + password;
            out.println(record);
            
            JOptionPane.showMessageDialog(this, "Sing in Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            new login().setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Fail to sing in: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_SubmitActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        txt_user.setText("");
        txt_password.setText("");
    }//GEN-LAST:event_bt_resetActionPerformed

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Submit;
    private javax.swing.JButton bt_reset;
    private javax.swing.JLabel icon_close;
    private javax.swing.JLabel icon_password;
    private javax.swing.JLabel icon_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_password;
    private javax.swing.JLabel txt_register;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
