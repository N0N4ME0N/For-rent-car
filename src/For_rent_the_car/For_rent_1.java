package For_rent_the_car;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class For_rent_1 extends javax.swing.JFrame {

    private String carType;
    private String loggedInUserEmail;

    public For_rent_1(String carType, String userEmail) {
        initComponents();
        this.carType = carType;
        this.loggedInUserEmail = userEmail;
        this.setLocationRelativeTo(null);
        this.setTitle("For Rent - " + carType);
        ComboBoxTxt();
        
        icon_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        icon_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new main().setVisible(true);
                dispose();
            }
        });
    }
    public void ComboBoxTxt(){
        String filetxt = "C:\\Users\\visud\\Documents\\NetBeansProjects\\For-rent-car-main (1)\\For-rent-car-main\\src\\For_rent_the_car\\cars.txt";
        File file = new File(filetxt);
        
        try {
            BufferedReader BReader = new BufferedReader(new FileReader(file));
            Object[] lines = BReader.lines().toArray();
            
            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                jComboBox1.addItem(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_start_hour = new javax.swing.JTextField();
        txt_start_min = new javax.swing.JTextField();
        txt_end_hour = new javax.swing.JTextField();
        txt_end_min = new javax.swing.JTextField();
        txt_start = new javax.swing.JLabel();
        txt_hour2 = new javax.swing.JLabel();
        bt_clear = new javax.swing.JButton();
        bt_forrent = new javax.swing.JButton();
        txt_hour1 = new javax.swing.JLabel();
        txt_min1 = new javax.swing.JLabel();
        txt_start1 = new javax.swing.JLabel();
        txt_min2 = new javax.swing.JLabel();
        icon_close = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose please" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("For Rent");

        txt_end_hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_end_hourActionPerformed(evt);
            }
        });

        txt_end_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_end_minActionPerformed(evt);
            }
        });

        txt_start.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_start.setText("Start Time");

        txt_hour2.setText("Hour");

        bt_clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_clear.setText("Clear");
        bt_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_clearActionPerformed(evt);
            }
        });

        bt_forrent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_forrent.setText("For Rent");
        bt_forrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_forrentActionPerformed(evt);
            }
        });

        txt_hour1.setText("Hour");

        txt_min1.setText("Minute");

        txt_start1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_start1.setText("End Time");

        txt_min2.setText("Minute");

        icon_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/For_rent_the_car/close-window-24.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon_close)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_start_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_end_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_end_min, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_start_min, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(txt_hour1)
                                        .addGap(96, 96, 96)
                                        .addComponent(txt_min1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(78, 78, 78)
                                        .addComponent(txt_start))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(txt_start1))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(txt_hour2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_min2)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(bt_clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_forrent)
                        .addGap(51, 51, 51)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon_close))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_start)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hour1)
                    .addComponent(txt_min1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_start_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_start_min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_start1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_hour2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_end_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_end_min, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_clear)
                            .addComponent(bt_forrent)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_min2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txt_end_hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_end_hourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_end_hourActionPerformed

    private void txt_end_minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_end_minActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_end_minActionPerformed

    private void bt_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_clearActionPerformed
        txt_start_hour.setText("");
        txt_start_min.setText("");
        txt_end_hour.setText("");
        txt_end_min.setText("");
    }//GEN-LAST:event_bt_clearActionPerformed

    private void bt_forrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_forrentActionPerformed
        String startHourStr = txt_start_hour.getText().trim();
        String startMinStr = txt_start_min.getText().trim();
        String endHourStr = txt_end_hour.getText().trim();
        String endMinStr = txt_end_min.getText().trim();
        
        if(startHourStr.isEmpty() || startMinStr.isEmpty() || endHourStr.isEmpty() || endMinStr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Plase enter time", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int startHour, startMin, endHour, endMin;
        try {
            startHour = Integer.parseInt(startHourStr);
            startMin = Integer.parseInt(startMinStr);
            endHour = Integer.parseInt(endHourStr);
            endMin = Integer.parseInt(endMinStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Plase enter number only", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(startHour < 0 || startHour > 23 || endHour < 0 || endHour > 23 ||
           startMin < 0 || startMin > 59 || endMin < 0 || endMin > 59) {
            JOptionPane.showMessageDialog(this, "Your enter time is wrong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int startTotalMin = startHour * 60 + startMin;
        int endTotalMin = endHour * 60 + endMin;
        if(endTotalMin <= startTotalMin) {
            JOptionPane.showMessageDialog(this, "Plase enter 'End Time' more than 'Start Time'", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CarItem chosen = (CarItem) jComboBox1.getSelectedItem();
        if (chosen == null) {
            JOptionPane.showMessageDialog(this, "Please select a car", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String brand = chosen.getBrand();
        String model = chosen.getModel();
        String startTime = String.format("%02d:%02d", startHour, startMin);
        String endTime   = String.format("%02d:%02d", endHour, endMin);
        
        File bookingFile = new File("src/For_rent_the_car/bookings.txt");
        try {
            int nextId = 1;
            try (BufferedReader r = new BufferedReader(new FileReader(bookingFile))) {
                while (r.readLine() != null) nextId++;
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(bookingFile, true))) {
                String record = nextId + "," +
                            loggedInUserEmail + "," +
                            brand + "," +
                            model + "," +
                            startTime + "," +
                            endTime;
                bw.write(record);
                bw.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Error saving booking: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this,"Booking Confirmed:\n Brand: " + brand + "\n" +
            "Model: " + model + "\n" +
            "Start: " + startTime + "\n" +
            "End: " + endTime,
            "Success", JOptionPane.INFORMATION_MESSAGE);

        main m = new main();
        m.setLoggedInUserEmail(loggedInUserEmail);
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_bt_forrentActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_forrent;
    private javax.swing.JLabel icon_close;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JTextField txt_end_hour;
    private javax.swing.JTextField txt_end_min;
    private javax.swing.JLabel txt_hour1;
    private javax.swing.JLabel txt_hour2;
    private javax.swing.JLabel txt_min1;
    private javax.swing.JLabel txt_min2;
    private javax.swing.JLabel txt_start;
    private javax.swing.JLabel txt_start1;
    private javax.swing.JTextField txt_start_hour;
    private javax.swing.JTextField txt_start_min;
    // End of variables declaration//GEN-END:variables
}
