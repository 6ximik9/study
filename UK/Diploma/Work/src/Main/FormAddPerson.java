/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.mysql.cj.protocol.Resultset;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ximik
 */
public class FormAddPerson extends javax.swing.JFrame {

    /**
     * @return the variant
     */
    public static int getVariant() {
        return variant;
    }

    /**
     * @param aVariant the variant to set
     */
    public static void setVariant(int aVariant) {
        variant = aVariant;
    }

    /**
     * @return the id
     */
    public static String getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(String aId) {
        id = aId;
    }

    /**
     * @return the PIB
     */
    public static String getPIB() {
        return PIB;
    }

    /**
     * @param aPIB the PIB to set
     */
    public static void setPIB(String aPIB) {
        PIB = aPIB;
    }

    /**
     * @return the category
     */
    public static String getCategory() {
        return category;
    }

    /**
     * @param aCategory the category to set
     */
    public static void setCategory(String aCategory) {
        category = aCategory;
    }
     DataBase a = new DataBase();
     static ResultSet X = null;
     private static String id = "";
     private static String PIB = "";
     private static String category = "";
     private static int variant = 0;
    /**
     * Creates new form addPerson
     */
    public FormAddPerson() {
        initComponents();
        MoveMouseListener mml = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(mml);
        pnlHead.addMouseMotionListener(mml);
        this.setLocationRelativeTo(null);
        jCmbCat.removeAll();
        X = a.GetParam("SELECT nameCategory FROM category");
        txtPib.requestFocusInWindow();


        try {
            while(X.next())
            {
                String g = X.getString(1);
                jCmbCat.addItem(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormAddPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(variant == 1)
        {
            lblTitle.setText(("Редагування"));
            txtPib.setText(getPIB());
            jCmbCat.setSelectedItem(category);
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

        pnlMain = new javax.swing.JPanel();
        pnlHead = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblExit1 = new javax.swing.JLabel();
        lblPib = new javax.swing.JLabel();
        txtPib = new javax.swing.JTextField();
        jCmbCat = new javax.swing.JComboBox<>();
        lblPib1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlMain.setBackground(new java.awt.Color(240, 219, 189));

        pnlHead.setBackground(new java.awt.Color(70, 43, 25));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Додавання працівника");

        lblExit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/exit-2.png"))); // NOI18N
        lblExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExit1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addComponent(lblExit1)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        lblPib.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblPib.setText("ПІБ працівника");

        txtPib.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        txtPib.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPibKeyTyped(evt);
            }
        });

        jCmbCat.setBackground(new java.awt.Color(120, 101, 84));
        jCmbCat.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jCmbCat.setForeground(new java.awt.Color(255, 255, 255));

        lblPib1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblPib1.setText("Категорія працівника");

        btnAdd.setBackground(new java.awt.Color(120, 101, 84));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/file-5.png"))); // NOI18N
        btnAdd.setText("Зберегти");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jCmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addComponent(txtPib, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPib)
                    .addComponent(lblPib1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPib1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtPib.getText().length()>0&&txtPib.getText()!=null)
        {
            if(getVariant() == 0)
            {
                
            X = a.GetParam("SELECT id FROM category WHERE `nameCategory` = '" + jCmbCat.getSelectedItem()+"'");
            try {
                while(X.next())
                {
                   String g = X.getString(1);
                   a.insert(txtPib.getText(), "employees", g);
                }
                FormMain.setAddP(0);
                JOptionPane.showMessageDialog(this, "Успішно", "Додавання", 1);
                FormMain.GetData("employees");
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(FormAddPerson.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if(getVariant() ==1)
            {
                X = a.GetParam("SELECT id FROM category WHERE `nameCategory` = '" + jCmbCat.getSelectedItem()+"'");
            try {
                while(X.next())
                {
                   String g = X.getString(1);
                   a.UpdatePerson(txtPib.getText(), "employees", g, getId());
                }
                FormMain.setAddP(0);
                dispose();
                JOptionPane.showMessageDialog(this, "Успішно", "Редагування", 1);
                
                FormMain.GetData("employees");
            } catch (SQLException ex) {
                Logger.getLogger(FormAddPerson.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            a.finalize();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtPibKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPibKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isLetterOrDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_SPACE))) {
            
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtPibKeyTyped

    private void lblExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit1MouseClicked
        FormMain.setAddP(0);
        a.finalize();
        dispose();
    }//GEN-LAST:event_lblExit1MouseClicked

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
            java.util.logging.Logger.getLogger(FormAddPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAddPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAddPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAddPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAddPerson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> jCmbCat;
    private javax.swing.JLabel lblExit1;
    private javax.swing.JLabel lblPib;
    private javax.swing.JLabel lblPib1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtPib;
    // End of variables declaration//GEN-END:variables
}
