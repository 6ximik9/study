/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import javax.swing.JOptionPane;

/**
 *
 * @author 7heXiMiK
 */
public class InsertProperty extends javax.swing.JFrame {

    Viev v = new Viev();
    private static int start = 0;

    /**
     * Creates new form InsertProperty
     */
    public InsertProperty() {
        initComponents();
        this.setLocationRelativeTo(null);//center screen
        MoveMouseListener mml = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(mml);
        pnlHead.addMouseMotionListener(mml);
        txtArea.setLineWrap(true);
        start();
        if(v.getStart() == 1)
        {
            metod();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        lblBorn = new javax.swing.JLabel();
        chYear = new java.awt.Choice();
        chMount = new java.awt.Choice();
        chData = new java.awt.Choice();
        jBoxYear = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        pnlHead = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jBoxPerson = new java.awt.Choice();
        jBoxProperty = new java.awt.Choice();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        lblBorn.setBackground(new java.awt.Color(0, 0, 0));
        lblBorn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblBorn.setText("���� ��������� (�� ����'������)");

        chYear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        chMount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        chData.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jBoxYear.setText("�� ���������");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("�����");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("����� ��������");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("������� �������������� ��������");

        btnAdd.setBackground(new java.awt.Color(126, 87, 195));
        btnAdd.setText("������");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        pnlHead.setBackground(new java.awt.Color(141, 50, 187));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/logout.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jBoxPerson.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jBoxProperty.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(lblBorn)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(chYear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chMount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chData, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(jBoxYear))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBoxPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBoxProperty, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jBoxPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jBoxProperty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBorn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chMount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBoxYear)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * ���������� ���� ����, �� ������ �����
 */
    void start() {
        for (int i = 1000; i < 2500; i++) {
            chYear.add("" + i + "");
        }
        for (int i = 1; i < 10; i++) {
            chMount.add("0" + i + "");
        }
        chMount.add("10");
        chMount.add("11");
        chMount.add("12");
        for (int i = 1; i < 10; i++) {
            chData.add("0" + i + "");
        }
        for (int i = 10; i < 32; i++) {
            chData.add("" + i + "");
        }

        DB d = new DB();
        d.GetInfoBox("PIB", "personality", "");
        jBoxPerson.removeAll();
        for (int i = 0; i < d.list.size(); i++) {
            jBoxPerson.addItem(d.array[i]);
        }
        d.GetInfoBox("name_property", "categories_of_property", "");
        jBoxProperty.removeAll();
        for (int i = 0; i < d.list.size(); i++) {
            jBoxProperty.addItem(d.array[i]);
        }

    }
/**
 * ����� ������������ ��� ������������
 */
    void metod() {
        DB d = new DB();
        //�������
        jBoxPerson.select(d.getNamePerson());
        jBoxProperty.select(d.getNameBranch());
        try{
        chYear.select(v.getBornSplit(0));
        chMount.select(v.getBornSplit(1));
        chData.select(v.getBornSplit(2));
        }
        catch(Exception ex){}
        txtArea.setText(v.getBiog());
        
    }
    /**
     * ϳ����������� ���������/������������
     * @param evt 
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (v.getStart() == 0) {
            String year = chYear.getSelectedItem() + "-" + chMount.getSelectedItem() + "-" + chData.getSelectedItem();
            if (txtArea.getText().trim().length() > 0) {
                DB d = new DB();
                if (jBoxYear.isSelected()) {
                    d.Getid("PIB", "personality", (String) jBoxPerson.getSelectedItem());
                    int i = d.getIdBranch();
                    d.Getid("name_property", "categories_of_property", (String) jBoxProperty.getSelectedItem());
                    int c = d.getIdBranch();
                    d.propertyInsert("property", "" + i + "", "" + c + "", null, txtArea.getText());
                    JOptionPane.showMessageDialog(rootPane, "������");
                    dispose();
                    v.Use();
                } else {
                    d.Getid("PIB", "personality", (String) jBoxPerson.getSelectedItem());
                    int i = d.getIdBranch();
                    d.Getid("name_property", "categories_of_property", (String) jBoxProperty.getSelectedItem());
                    int c = d.getIdBranch();
                    d.propertyInsert("property", "" + i + "", "" + c + "", year, txtArea.getText());
                    JOptionPane.showMessageDialog(rootPane, "������");
                    dispose();
                    v.Use();

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "������ �������� ����");
            }
        } else if(v.getStart() == 1) {
                btnAdd.setText("�������");
                String year = chYear.getSelectedItem() + "-" + chMount.getSelectedItem() + "-" + chData.getSelectedItem();
            if (txtArea.getText().trim().length() > 0) {
                DB d = new DB();
                if (jBoxYear.isSelected()) {
                    d.Getid("PIB", "personality", (String) jBoxPerson.getSelectedItem());
                    int i = d.getIdBranch();
                    d.Getid("name_property", "categories_of_property", (String) jBoxProperty.getSelectedItem());
                    int c = d.getIdBranch();
                   
                    d.propertyUpdate("property", "" + i + "", "" + c + "", null, txtArea.getText(), v.getIdDel());
                    JOptionPane.showMessageDialog(rootPane, "������");
                    dispose();
                    v.Use();
                } else {
                    d.Getid("PIB", "personality", (String) jBoxPerson.getSelectedItem());
                    int i = d.getIdBranch();
                    d.Getid("name_property", "categories_of_property", (String) jBoxProperty.getSelectedItem());
                    int c = d.getIdBranch();
                     System.out.println(i+"  "+c);
                    d.propertyUpdate("property", "" + i + "", "" + c + "", year, txtArea.getText(), v.getIdDel());
                    JOptionPane.showMessageDialog(rootPane, "������");
                    dispose();
                    v.Use();

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "������ �������� ����");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * �����
     * @param evt 
     */
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        v.Use();
        v.setStart(0);
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(InsertProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertProperty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private java.awt.Choice chData;
    private java.awt.Choice chMount;
    private java.awt.Choice chYear;
    private java.awt.Choice jBoxPerson;
    private java.awt.Choice jBoxProperty;
    private javax.swing.JCheckBox jBoxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBorn;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
