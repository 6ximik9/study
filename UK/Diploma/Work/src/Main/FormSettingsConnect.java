/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ximik
 */
public class FormSettingsConnect extends javax.swing.JFrame {

    /**
     * @param dbname the dbname to set
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    /*get + set
     /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the dbname
     */
    public String getDbname() {
        return dbname;
    }
    ////////////

    private int delID = 0;
    ArrayList<String> list = new ArrayList<>();
    public static String[] array;
    private String server;
    private String port;
    private String user;
    private String pass;
    private String dbname;

    /**
     * Creates new form Set
     */
    public FormSettingsConnect() {
        initComponents();
        txtServer.setHorizontalAlignment(txtServer.CENTER);
        txtBD.setHorizontalAlignment(txtBD.CENTER);
        txtPort.setHorizontalAlignment(txtPort.CENTER);
        txtUser.setHorizontalAlignment(txtUser.CENTER);
        txtPass.setHorizontalAlignment(txtPass.CENTER);
        setLocationRelativeTo(null);
        MoveMouseListener mml = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(mml);
        pnlHead.addMouseMotionListener(mml);
        server = "";
        port = "";
        user = "";
        pass = "";
        dbname = "";
        try {
            Read();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FormSettingsConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void Read() throws IOException {

        try ( Scanner scan = new Scanner(new File("UserSettings.txt"))) {
            while (scan.hasNextLine()) {
                list.add(scan.nextLine());
            }
            array = list.toArray(new String[0]);
            txtServer.setText(array[0]);
            txtPort.setText(array[1]);
            txtUser.setText(array[2]);
            txtPass.setText(array[3]);
            txtBD.setText(array[4]);

            setServer(array[0]);
            setPort(array[1]);
            setUser(array[2]);
            setPass(array[3]);
            setDbname(array[4]);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(pnlContent, "?????????????? ????????????????????", "??????????????", 2);
            CreateFile();
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

        pnlContent = new javax.swing.JPanel();
        pnlHead = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtBD = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        lblPhotoServer = new javax.swing.JLabel();
        lblPhotoServer1 = new javax.swing.JLabel();
        lblPhotoServer2 = new javax.swing.JLabel();
        lblPhotoServer3 = new javax.swing.JLabel();
        lblPhotoServer4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlContent.setBackground(new java.awt.Color(240, 219, 189));

        pnlHead.setBackground(new java.awt.Color(70, 43, 25));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("???????????????????????? ??????????????????????");

        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/exit-2.png"))); // NOI18N
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHeadLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSave.setBackground(new java.awt.Color(120, 101, 84));
        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/floppy-disk.png"))); // NOI18N
        btnSave.setText("????????????????????");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(70, 43, 25));
        jLabel5.setText("????");

        txtBD.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N
        txtBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBDActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(70, 43, 25));
        jLabel4.setText("????????????");
        jLabel4.setName(""); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(70, 43, 25));
        jLabel3.setText("??????????");

        txtUser.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N

        txtPort.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N
        txtPort.setToolTipText("");
        txtPort.setCaretColor(new java.awt.Color(69, 73, 74));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(70, 43, 25));
        jLabel2.setText("????????");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(70, 43, 25));
        jLabel1.setText("????????????");

        txtServer.setFont(new java.awt.Font("Times New Roman", 0, 32)); // NOI18N
        txtServer.setToolTipText("");
        txtServer.setCaretColor(new java.awt.Color(69, 73, 74));

        lblPhotoServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/vagueness.png"))); // NOI18N

        lblPhotoServer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/usb-port.png"))); // NOI18N

        lblPhotoServer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/identity.png"))); // NOI18N

        lblPhotoServer3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/password.png"))); // NOI18N

        lblPhotoServer4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/database.png"))); // NOI18N

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPort, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(txtServer, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass)
                    .addComponent(txtBD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhotoServer)
                    .addComponent(lblPhotoServer1)
                    .addComponent(lblPhotoServer2)
                    .addComponent(lblPhotoServer3)
                    .addComponent(lblPhotoServer4))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(btnSave)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhotoServer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPhotoServer1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPhotoServer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(lblPhotoServer3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPhotoServer4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (txtServer.getText().trim().length() <= 0 || txtPort.getText().trim().length() <= 0
                    || txtUser.getText().trim().length() <= 0 || txtBD.getText().trim().length() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "??????????????");
            } else {
                FileWriter nFile = new FileWriter("UserSettings.txt");
                nFile.write(txtServer.getText() + "\n");
                nFile.write(txtPort.getText() + "\n");
                nFile.write(txtUser.getText() + "\n");
                nFile.write(txtPass.getText() + "\n");
                nFile.write(txtBD.getText() + "\n");
                nFile.close();
            }
            FormMenu.PlugIn();
        } catch (IOException ex) {
            // Logger.getLogger(Open.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * ?????????????????? ??????????
     * @throws IOException 
     */
    void CreateFile() throws IOException {
        FileWriter nFile = new FileWriter("UserSettings.txt");
        nFile.write("127.0.0.1\n");
        nFile.write("3306\n");
        nFile.write("root\n");
        nFile.write("\n");
        nFile.write("work");
        nFile.close();
    }
    private void txtBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBDActionPerformed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        dispose();
        FormMenu.setCountForm(0);
    }//GEN-LAST:event_lblExitMouseClicked

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
            java.util.logging.Logger.getLogger(FormSettingsConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSettingsConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSettingsConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSettingsConnect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSettingsConnect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblPhotoServer;
    private javax.swing.JLabel lblPhotoServer1;
    private javax.swing.JLabel lblPhotoServer2;
    private javax.swing.JLabel lblPhotoServer3;
    private javax.swing.JLabel lblPhotoServer4;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JTextField txtBD;
    private javax.swing.JTextField txtPass;
    public javax.swing.JTextField txtPort;
    public javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
