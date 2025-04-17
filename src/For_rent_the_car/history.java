package For_rent_the_car;

import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class history extends javax.swing.JFrame {

    private String loggedInUserEmail;
    
    public history(String email) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("History");
        this.loggedInUserEmail = email;
        loadBookingHistory();
    }
    
    public void setLoggedInUserEmail(String email) {
        this.loggedInUserEmail = email;
        loadBookingHistory();
    }
    
    private void loadBookingHistory() {
        File file = new File("src/For_rent_the_car/bookings.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Not found bookings.txt", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) table_history.getModel();
        model.setRowCount(0);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length >= 7) {
                    String bookingID = tokens[0].trim();
                    String userEmail = tokens[1].trim();
                    String brand = tokens[2].trim();
                    String carName = tokens[3].trim();
                    String startTime = tokens[4].trim();
                    String endTime = tokens[5].trim();
                    String status = tokens[6].trim();
                    
                    if(loggedInUserEmail.equalsIgnoreCase("admin") || userEmail.equalsIgnoreCase(loggedInUserEmail)) {
                        Object[] row = {bookingID, userEmail, brand, carName, startTime, endTime, status};
                        model.addRow(row);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading bookings.txt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_add2 = new javax.swing.JButton();
        txt_history = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_history = new javax.swing.JTable();
        bt_add1 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        bt_add2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add2.setText("Add");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_history.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txt_history.setText("History");

        table_history.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Brand", "Name car", "Start Time", "End Time", "Status"
            }
        ));
        jScrollPane1.setViewportView(table_history);

        bt_add1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add1.setText("Add");

        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(txt_history)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(btn_back)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bt_add1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_history)
                    .addComponent(btn_back, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bt_add1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        if (loggedInUserEmail.equalsIgnoreCase("admin")){
            main_admin adminFrame = new main_admin();
            adminFrame.setLoggedInUserEmail(loggedInUserEmail);
            adminFrame.setVisible(true);
        }else{
            main userFrame = new main();
            userFrame.setLoggedInUserEmail(loggedInUserEmail);
            userFrame.setVisible(true);
        }
        System.out.println("Logged In User Email: " + loggedInUserEmail);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add1;
    private javax.swing.JButton bt_add2;
    private javax.swing.JButton btn_back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_history;
    private javax.swing.JLabel txt_history;
    // End of variables declaration//GEN-END:variables
}
