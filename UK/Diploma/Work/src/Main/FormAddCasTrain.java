/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author ximik
 */
public class FormAddCasTrain extends javax.swing.JFrame {

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
     * @return the Date
     */
    public static String getDate() {
        return Date;
    }

    /**
     * @param aDate the Date to set
     */
    public static void setDate(String aDate) {
        Date = aDate;
    }

    /**
     * @return the Suma
     */
    public static String getSuma() {
        return Suma;
    }

    /**
     * @param aSuma the Suma to set
     */
    public static void setSuma(String aSuma) {
        Suma = aSuma;
    }

    /**
     * @return the nameCashier
     */
    public static String getNameCashier() {
        return nameCashier;
    }

    /**
     * @param aNameCashier the nameCashier to set
     */
    public static void setNameCashier(String aNameCashier) {
        nameCashier = aNameCashier;
    }

    /**
     * @return the variantStart
     */
    public static int getVariantStart() {
        return variantStart;
    }

    /**
     * @param aVariantStart the variantStart to set
     */
    public static void setVariantStart(int aVariantStart) {
        variantStart = aVariantStart;
    }

    ResultSet X = null;
    ResultSet XS = null;
    DataBase a = new DataBase();
    static int countPerson = 0;
    public static ArrayList<String> listPerson = new ArrayList<>();
    public static ArrayList<String> listEdit = new ArrayList<>();
    private static int variantStart = 0;

    private static int countP = 0;

    private static String id = "";
    private static String nameCashier = "";
    private static String Date = "";
    private static String Suma = "";
    double ValueKh = 0;
    double take = 0;
    double Rate = 0;
    double PayRate = 0;
    double PayDef = 0;
    double st1 = 0;
    double st2 = 0;

    /**
     * Creates new form addDay
     */
    public FormAddCasTrain() {
        initComponents();
        MoveMouseListener mml = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(mml);
        pnlHead.addMouseMotionListener(mml);
        this.setLocationRelativeTo(null);
        pnlIntern.setVisible(false);

        getEmp(2);
        //Редагування
        if (variantStart == 1) {
            SimpleDateFormat Fr = new SimpleDateFormat("y-MM-d", Locale.ENGLISH);
            try {
                MyDate.setDate(Fr.parse(Date));
                allW.setText(Suma);
            } catch (ParseException ex) {
                Logger.getLogger(FormAddCasTrain.class.getName()).log(Level.SEVERE, null, ex);
            }

            Component[] comp = pnlEm.getComponents();
            for (int i = 0; i < comp.length; i++) {
                String text = comp[i].toString();
                if (text.indexOf(getNameCashier()) != -1) {
                    setNameCashier(getNameCashier());
                    pnlEm.getComponent(i).setBackground(new Color(120, 101, 84));

                }
            }
        } else if (variantStart == 2) {
            getEmp(3);
            pnlIntern.setVisible(true);
            allW.setVisible(false);
            allW.setText(100 + "");
            lblTitle.setText("Додавання зміни стажера");
        } else if (variantStart == 3) {
            getEmp(3);
            SimpleDateFormat Fr = new SimpleDateFormat("y-MM-d", Locale.ENGLISH);

            try {
                MyDate.setDate(Fr.parse(Date));
                allW.setText("1");
                allW.setVisible(false);
                jCBTypeIn.setSelectedItem(Suma);
                pnlIntern.setVisible(true);
                TitleCalendar1.setVisible(false);
            } catch (ParseException ex) {
                Logger.getLogger(FormAddCasTrain.class.getName()).log(Level.SEVERE, null, ex);
            }

            Component[] comp = pnlEm.getComponents();
            for (int i = 0; i < comp.length; i++) {
                String text = comp[i].toString();
                if (text.indexOf(getNameCashier()) != -1) {
                    setNameCashier(getNameCashier());
                    pnlEm.getComponent(i).setBackground(new Color(120, 101, 84));

                }
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

        jPanel1 = new javax.swing.JPanel();
        allW = new javax.swing.JTextField();
        pnlIntern = new javax.swing.JPanel();
        jCBTypeIn = new javax.swing.JComboBox<>();
        TitleCalendar2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlEm = new javax.swing.JPanel();
        pnlHead = new javax.swing.JPanel();
        lblExit1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        MyDate = new com.toedter.calendar.JDateChooser();
        TitleCalendar = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        TitleCalendar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(240, 219, 189));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        allW.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        allW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                allWKeyTyped(evt);
            }
        });
        jPanel1.add(allW, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 100, -1));

        pnlIntern.setBackground(new java.awt.Color(240, 219, 189));

        jCBTypeIn.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jCBTypeIn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Стажер_1", "Стажер_2" }));

        TitleCalendar2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TitleCalendar2.setForeground(new java.awt.Color(70, 43, 25));
        TitleCalendar2.setText("Категорія:");
        TitleCalendar2.setToolTipText("");

        javax.swing.GroupLayout pnlInternLayout = new javax.swing.GroupLayout(pnlIntern);
        pnlIntern.setLayout(pnlInternLayout);
        pnlInternLayout.setHorizontalGroup(
            pnlInternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInternLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(TitleCalendar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBTypeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        pnlInternLayout.setVerticalGroup(
            pnlInternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInternLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(pnlInternLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTypeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TitleCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(pnlIntern, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlEm.setBackground(new java.awt.Color(255, 255, 255));
        pnlEm.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(pnlEm);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 300, 320));

        pnlHead.setBackground(new java.awt.Color(70, 43, 25));
        pnlHead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeadMousePressed(evt);
            }
        });

        lblExit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/exit-2.png"))); // NOI18N
        lblExit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExit1MouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Додавання зміни касира");

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(lblExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addComponent(lblExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MyDate.setDateFormatString("y-M-d");
        jPanel1.add(MyDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 320, 30));

        TitleCalendar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TitleCalendar.setForeground(new java.awt.Color(70, 43, 25));
        TitleCalendar.setText("Дата ");
        jPanel1.add(TitleCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btnSave.setBackground(new java.awt.Color(120, 101, 84));
        btnSave.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/file-5.png"))); // NOI18N
        btnSave.setText("Зберегти");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 160, 40));

        TitleCalendar1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        TitleCalendar1.setForeground(new java.awt.Color(70, 43, 25));
        TitleCalendar1.setText("Продано на суму:");
        TitleCalendar1.setToolTipText("");
        jPanel1.add(TitleCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //getEmp();
    }//GEN-LAST:event_formWindowOpened
    /**
     * Отримання працівників
     *
     * @param id Код
     */
    void getEmp(int id) {
        a.GetInfoBox("PIB", "employees", id + "");
        pnlEm.removeAll();
        for (int i = 0; i < a.list.size(); i++) {
            pnlEm.add(CreateBtn(a.array[i], 0));
        }
        pnlEm.updateUI();
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (getNameCashier() != "" && allW.getText().length() > 0 && MyDate.getDate() != null) {
            String result = listPerson.stream()
                    .map(n -> String.valueOf(n))
                    .collect(Collectors.joining());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            double allWe = Double.parseDouble(allW.getText());
            double salary = 0;
            getCalc();
            if (variantStart == 0) {
                if (allWe > take) {
                    salary = PayRate + ((allWe / 100) * Rate);
                } else {
                    salary = PayDef;
                }
                a.MyInsertCasa("cashier", getNameCashier(), dateFormat.format(MyDate.getDate()), allWe, salary);
                JOptionPane.showMessageDialog(this, "Успішно", "Додавання", 1);
                FormMain.GetData("cashier");
            } else if (variantStart == 1) {
                if (allWe > take) {
                    salary = PayRate + ((allWe / 100) * Rate);
                } else {
                    salary = PayDef;
                }
                a.MyUpdateCasa("cashier", getNameCashier(), dateFormat.format(MyDate.getDate()), allWe, salary, getId());
                JOptionPane.showMessageDialog(this, "Успішно", "Редагування", 1);
                FormMain.GetData("cashier");
            } else if (variantStart == 2) {
                if (jCBTypeIn.getSelectedItem() == "Стажер_1") {
                    salary = st1;
                } else if (jCBTypeIn.getSelectedItem() == "Стажер_2") {
                    salary = st2;
                }
                a.MyInsertInter("Interns", getNameCashier(), dateFormat.format(MyDate.getDate()), jCBTypeIn.getSelectedItem().toString(), salary);
                FormMain.GetData("Interns");
            } else if (variantStart == 3) {
                if (jCBTypeIn.getSelectedItem() == "Стажер_1") {
                    salary = st1;
                } else if (jCBTypeIn.getSelectedItem() == "Стажер_2") {
                    salary = st2;
                }
                a.MyUpdateInter("Interns", getNameCashier(), dateFormat.format(MyDate.getDate()), jCBTypeIn.getSelectedItem().toString(), salary, getId());
                FormMain.GetData("Interns");
            }
            listEdit.clear();
            listPerson.clear();
            variantStart = 0;
            FormMain.setAddP(0);
            allW.setText("");
            pnlIntern.setVisible(false);
            nameCashier = "";
            dispose();
        } else if (MyDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Дату не вибрано", "Помилка", 2);
        } else if (getNameCashier() == "") {
            JOptionPane.showMessageDialog(this, "Не вибрано касира", "Помилка", 2);
        } else if (allW.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Не вказано суму продажу", "Помилка", 2);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    /**
     * Отримання виплат
     */
    void getCalc() {
        DataBase DB = new DataBase();
        XS = DB.GetParam("SELECT name, value FROM setcalc");

        try {
            while (XS.next()) {
                if (XS.getString(1).equals("За кілограм")) {
                    ValueKh = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("ВиручкаВідсоток")) {
                    take = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("Відсоток")) {
                    Rate = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("ЗарплатаВідсоток")) {
                    PayRate = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("ЗвичайнаЗарплата")) {
                    PayDef = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("Стажер_1")) {
                    st1 = Double.parseDouble(XS.getString(2));
                } else if (XS.getString(1).equals("Стажер_2")) {
                    st2 = Double.parseDouble(XS.getString(2));
                }
            }
            DB.finalize();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Проблемка");
        }
    }
    private void pnlHeadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeadMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlHeadMousePressed

    private void allWKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_allWKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_PERIOD))) {

            if ((c == KeyEvent.VK_PERIOD && allW.getText().indexOf(".") != -1) || (c == KeyEvent.VK_PERIOD && allW.getText().length() == 0)) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_allWKeyTyped

    private void lblExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit1MouseClicked
        listEdit.clear();
        listPerson.clear();
        variantStart = 0;
        FormMain.setAddP(0);
        dispose();
    }//GEN-LAST:event_lblExit1MouseClicked

    public void Act() {
        this.isFocusable();
    }
/**
 * Створення кнопки
 * @param name Ім'я 
 * @param variant Варіант кліку
 * @return 
 */
    JButton CreateBtn(String name, int variant) {
        JButton b = new JButton(name);
        b.setPreferredSize(new Dimension(200, 50));
        b.setBackground(Color.WHITE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 14);
        b.setFont(BigFontTR);
        b.setVisible(true);
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    b.setBackground(Color.WHITE);
                    setNameCashier("");
                    Component[] comp = pnlEm.getComponents();
                    for (int i = 0; i < comp.length; i++) {
                        pnlEm.getComponent(i).setBackground(Color.WHITE);
                    }

                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    setNameCashier(b.getText());
                    Component[] comp = pnlEm.getComponents();
                    for (int i = 0; i < comp.length; i++) {
                        pnlEm.getComponent(i).setBackground(Color.WHITE);
                    }
                    b.setBackground(new Color(120, 101, 84));
                }
            }
        });

        return b;
    }

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
            java.util.logging.Logger.getLogger(FormAddCasTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAddCasTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAddCasTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAddCasTrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormAddCasTrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser MyDate;
    private javax.swing.JLabel TitleCalendar;
    private javax.swing.JLabel TitleCalendar1;
    private javax.swing.JLabel TitleCalendar2;
    private javax.swing.JTextField allW;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> jCBTypeIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExit1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlEm;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlIntern;
    // End of variables declaration//GEN-END:variables
}
