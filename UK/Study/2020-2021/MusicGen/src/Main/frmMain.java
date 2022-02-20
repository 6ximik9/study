/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ximik
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * @return the nameSound
     */
    public static String getNameSound() {
        return nameSound;
    }

    /**
     * @param aNameSound the nameSound to set
     */
    public static void setNameSound(String aNameSound) {
        nameSound = aNameSound;
    }

    /**
     * @return the status
     */
    public static int getStatus() {
        return status;
    }

    /**
     * @param aStatus the status to set
     */
    public static void setStatus(int aStatus) {
        status = aStatus;
    }

    /**
     * @return the nameUser
     */
    public static String getNameUser() {
        return nameUser;
    }

    /**
     * @param aNameUser the nameUser to set
     */
    public static void setNameUser(String aNameUser) {
        nameUser = aNameUser;
    }

    private Connection conn = null;
    private DB a = new DB();
    String[] YesNo = new String[]{"Так", "Ні"};
    static ResultSet X = null;
    static ResultSet mood = null;
    private static String nameUser = "";
    private static int status = 0;
    private static String nameSound = "";

    /**
     * Creates new form frmView
     */
    public frmMain() {
        initComponents();
        MoveMouseListener m = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(m);
        pnlHead.addMouseMotionListener(m);
        this.setLocationRelativeTo(null);
        tbl.setDefaultEditor(Object.class, null);
        GetData("Music");
        if (getNameUser().equals("admin")) {
            btnEdit.setEnabled(true);
            btnDel.setEnabled(true);
        } else {
            btnEdit.setEnabled(false);
            btnDel.setEnabled(false);
            btnEdit.setToolTipText("Для редагування потрібні права адміністратора");
            btnDel.setToolTipText("Для видалення потрібні права адміністратора");
        }
        tbl.setDefaultEditor(Object.class, null);
        tbl.setAutoCreateRowSorter(true);
        jcmbType.removeAllItems();

        mood = a.GetParam("SELECT name FROM mood;");

        try {
            while (mood.next()) {
                String g = mood.getString(1);
                jcmbType.addItem(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmAdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        X = null;
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
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcmbPart = new javax.swing.JComboBox<>();
        pnlButtton = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        lblDate1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblHead1 = new javax.swing.JLabel();
        jcmbType = new javax.swing.JComboBox<>();
        btnsett3 = new javax.swing.JButton();
        lblDate2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(66, 33, 148));

        pnlHead.setBackground(new java.awt.Color(169, 76, 175));
        pnlHead.setForeground(new java.awt.Color(221, 47, 85));

        btnExit.setBackground(new java.awt.Color(169, 76, 175));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/close.png"))); // NOI18N
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Музика для твого настрою");

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jcmbPart.setBackground(new java.awt.Color(169, 76, 175));
        jcmbPart.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jcmbPart.setForeground(new java.awt.Color(255, 255, 255));
        jcmbPart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Музика", "Автори", "Настрій" }));
        jcmbPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbPartActionPerformed(evt);
            }
        });

        pnlButtton.setBackground(new java.awt.Color(66, 33, 148));
        pnlButtton.setLayout(new java.awt.GridLayout(1, 3));

        btnAdd.setBackground(new java.awt.Color(169, 76, 175));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/plus.png"))); // NOI18N
        btnAdd.setText("Додати");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlButtton.add(btnAdd);

        btnEdit.setBackground(new java.awt.Color(169, 76, 175));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/pencil.png"))); // NOI18N
        btnEdit.setText("Редагувати");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlButtton.add(btnEdit);

        btnDel.setBackground(new java.awt.Color(169, 76, 175));
        btnDel.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/trash.png"))); // NOI18N
        btnDel.setText("Видалити");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        pnlButtton.add(btnDel);

        tbl.setBackground(new java.awt.Color(169, 76, 175));
        tbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl.setForeground(new java.awt.Color(255, 255, 255));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl.setToolTipText("Клацніть два рази для \nперегляду детальної інформації");
        tbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl.setGridColor(new java.awt.Color(66, 33, 148));
        tbl.setRowHeight(40);
        tbl.setSelectionBackground(new java.awt.Color(169, 76, 175));
        tbl.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        lblDate1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblDate1.setForeground(new java.awt.Color(255, 255, 255));
        lblDate1.setText("Настрій");

        txtSearch.setBackground(new java.awt.Color(66, 33, 148));
        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setToolTipText("Пошук відбувається по всім полям\nВведіть запит та натисніть Enter");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        lblHead1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblHead1.setForeground(new java.awt.Color(255, 255, 255));
        lblHead1.setText("Пошук");

        jcmbType.setBackground(new java.awt.Color(169, 76, 175));
        jcmbType.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jcmbType.setForeground(new java.awt.Color(255, 255, 255));
        jcmbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbTypeActionPerformed(evt);
            }
        });

        btnsett3.setBackground(new java.awt.Color(169, 76, 175));
        btnsett3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsett3.setForeground(new java.awt.Color(255, 255, 255));
        btnsett3.setText("Застосувати");
        btnsett3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsett3ActionPerformed(evt);
            }
        });

        lblDate2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblDate2.setForeground(new java.awt.Color(255, 255, 255));
        lblDate2.setText("Розділ");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsett3))
                    .addComponent(lblDate1))
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate2)
                    .addComponent(jcmbPart, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHead1))
                .addContainerGap())
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(pnlButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate1)
                    .addComponent(lblHead1)
                    .addComponent(lblDate2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsett3)
                    .addComponent(jcmbPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                .addComponent(pnlButtton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMainLayout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(64, Short.MAX_VALUE)))
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

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            PlugIn();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Помилка підключення");
            //btnUpdate.setVisible(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        setNameSound(tbl.getModel().getValueAt(tbl.getSelectedRow(), 0).toString());
        int col = tbl.getSelectedColumn();
        if (col == 4) {
            URI uri;
            try {
                uri = new URI(tbl.getModel().getValueAt(tbl.getSelectedRow(), col).toString());
                open(uri);
            } catch (URISyntaxException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_tblMouseClicked

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(jcmbPart, "Не правильне посилання, зверніться до адміністратора", "Помилка", 0);
            }
        } else {
            /* TODO: error handling */ }
    }


    private void tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseEntered

    }//GEN-LAST:event_tblMouseEntered

    private void tblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMousePressed
        setNameSound(tbl.getModel().getValueAt(tbl.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tblMousePressed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed

        if (jcmbPart.getSelectedItem() == "Музика") {
            int rezz = JOptionPane.showOptionDialog(null,
                    "Видалити пісню: " + getNameSound() + "?",
                    "Видалення",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    YesNo,
                    "default");
            if (rezz == 0) {
                a.del("Music", "nameSound", getNameSound());
                JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                GetData("Music");
            }
        } else if (jcmbPart.getSelectedItem() == "Автори") {

        } else if (jcmbPart.getSelectedItem() == "Настрій") {

        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (status == 0) {
            if (jcmbPart.getSelectedItem() == "Музика") {
                frmAdd.setVariantStart(0);
                frmAdd add = new frmAdd();
                add.setVisible(true);
                status = 1;
            } else if (jcmbPart.getSelectedItem() == "Автори") {
                String name = JOptionPane.showInputDialog(rootPane, "Введіть ім'я автора:", "Додавання автора", 3);
                if (name != null && name.length() > 0) {
                    a.GetInd("SELECT name FROM author WHERE `name` = '" + name + "'");
                    if (a.getAddName() == "") {
                        a.InsertAuthor("author", name);
                        GetData("author");
                        JOptionPane.showMessageDialog(this, "Успішно", "Додавання автора", 1);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Автор існує", "Помилка", 2);
                    }
                    a.setAddName("");
                }
            } else if (jcmbPart.getSelectedItem() == "Настрій") {
                String name = JOptionPane.showInputDialog(rootPane, "Введіть назву настрою:", "Додавання настрою", 3);
                if (name != null && name.length() > 0) {
                    a.GetInd("SELECT name FROM mood WHERE `name` = '" + name + "'");
                    if (a.getAddName() == "") {
                        a.InsertAuthor("mood", name);
                        GetData("mood");
                        JOptionPane.showMessageDialog(this, "Успішно", "Додавання настрою", 1);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Настрій існує", "Помилка", 2);
                    }
                    a.setAddName("");
                }
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (status == 0) {
            if (nameSound != "") {
                if (jcmbPart.getSelectedItem() == "Музика") {

                    frmAdd.setVariantStart(1);
                    frmAdd add = new frmAdd();
                    add.setVisible(true);
                    status = 1;
                } else if (jcmbPart.getSelectedItem() == "Автори") {
                    String name = JOptionPane.showInputDialog(rootPane, "Введіть нове ім'я для автора: " + nameSound, "Редагування автора", 3);
                    if (name != null && name.length() > 0) {
                        a.GetInd("SELECT name FROM author WHERE `name` = '" + name + "'");
                        if (a.getAddName() == "") {
                            a.UpdateAM("author", name);
                            GetData("author");
                            JOptionPane.showMessageDialog(this, "Успішно", "Додавання Автора", 1);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Автор існує", "Помилка", 2);
                        }
                        a.setAddName("");
                    }
                } else if (jcmbPart.getSelectedItem() == "Настрій") {
                    String name = JOptionPane.showInputDialog(rootPane, "Введіть нове ім'я для настрою: " + nameSound, "Редагування настрою", 3);
                    if (name != null && name.length() > 0) {
                        a.GetInd("SELECT name FROM mood WHERE `name` = '" + name + "'");
                        if (a.getAddName() == "") {
                            a.UpdateAM("mood", name);
                            GetData("mood");
                            JOptionPane.showMessageDialog(this, "Успішно", "Редагування настрою", 1);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Настрій існує", "Помилка", 2);
                        }
                        a.setAddName("");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 0);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void jcmbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbTypeActionPerformed
        DB db = new DB();
        X = db.GetParam("SELECT nameSound, author, mood, tags, link FROM Music WHERE mood = '" + jcmbType.getSelectedItem() + "';");
        int i = 0, ii = 1;
        try {
            ResultSetMetaData colonki = X.getMetaData();
            i = colonki.getColumnCount();
            javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
            dtm.setColumnCount(i);//
            String nazvaKolonki[] = new String[i];
            nazvaKolonki[0] = "Назва";
            nazvaKolonki[1] = "Виконавець";
            nazvaKolonki[2] = "Настрій";
            nazvaKolonki[3] = "Теги";
            nazvaKolonki[4] = "Посилання";
            dtm.setColumnIdentifiers(nazvaKolonki);
            dtm.setRowCount(0);//
            while (X.next()) {
                dtm.setRowCount(dtm.getRowCount() + 1);
                for (int j = 1; j <= i; j++) {
                    String g = X.getString(j);
                    dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                }
                ii++;
            }
            tbl.setModel(dtm);

            final TableColumnModel columnModel = tbl.getColumnModel();
            for (int column = 0; column < tbl.getColumnCount(); column++) {
                int width = 15; // Min width
                for (int row = 0; row < tbl.getRowCount(); row++) {
                    TableCellRenderer renderer = tbl.getCellRenderer(row, column);
                    Component comp = tbl.prepareRenderer(renderer, row, column);
                    width = Math.max(comp.getPreferredSize().width + 1, width);
                }
                if (width > 300) {
                    width = 300;
                }
                columnModel.getColumn(column).setPreferredWidth(width);
            }
            tbl.getColumn("Назва").setCellRenderer(new myCellRenderer());
            tbl.getColumn("Виконавець").setCellRenderer(new myCellRenderer());
            tbl.getColumn("Настрій").setCellRenderer(new myCellRenderer());
            tbl.getColumn("Теги").setCellRenderer(new myCellRenderer());
            tbl.getColumn("Посилання").setCellRenderer(new myCellRenderer());
        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);

        }
        db.finalize();
    }//GEN-LAST:event_jcmbTypeActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        try {
            if (jcmbPart.getSelectedItem() == "Музика") {
                Search("Music");
                txtSearch.setEnabled(true);
                jcmbType.setEnabled(true);
            } else if (jcmbPart.getSelectedItem() == "Автори") {
                Search("author");
                jcmbType.setEnabled(false);
            } else if (jcmbPart.getSelectedItem() == "Настрій") {
                Search("mood");
                jcmbType.setEnabled(false);
            }
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btnsett3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsett3ActionPerformed

    }//GEN-LAST:event_btnsett3ActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (jcmbPart.getSelectedItem() == "Музика") {
            Search("Music");
            txtSearch.setEnabled(true);
            jcmbType.setEnabled(true);
        } else if (jcmbPart.getSelectedItem() == "Автори") {
            Search("author");
            jcmbType.setEnabled(false);
        } else if (jcmbPart.getSelectedItem() == "Настрій") {
            Search("mood");
            jcmbType.setEnabled(false);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void jcmbPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbPartActionPerformed
        if (jcmbPart.getSelectedItem() == "Музика") {
            GetData("Music");
            txtSearch.setEnabled(true);
            jcmbType.setEnabled(true);
        } else if (jcmbPart.getSelectedItem() == "Автори") {
            GetData("author");
            jcmbType.setEnabled(false);
        } else if (jcmbPart.getSelectedItem() == "Настрій") {
            GetData("mood");
            jcmbType.setEnabled(false);
        }
    }//GEN-LAST:event_jcmbPartActionPerformed

    /**
     * Пошук
     */
    void Search(String nameT) {
        DB db = new DB();
        X = db.Search(nameT, txtSearch.getText());
        int i = 0, ii = 1;
        try {
            ResultSetMetaData colonki = X.getMetaData();
            i = colonki.getColumnCount();
            javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
            dtm.setColumnCount(i);//
            String nazvaKolonki[] = new String[i];
            if (nameT == "Music") {
                nazvaKolonki[0] = "Назва";
                nazvaKolonki[1] = "Виконавець";
                nazvaKolonki[2] = "Настрій";
                nazvaKolonki[3] = "Теги";
                nazvaKolonki[4] = "Посилання";
            } else {
                nazvaKolonki[0] = "Ім'я";
            }
            dtm.setColumnIdentifiers(nazvaKolonki);
            dtm.setRowCount(0);//
            while (X.next()) {
                dtm.setRowCount(dtm.getRowCount() + 1);
                for (int j = 1; j <= i; j++) {
                    String g = X.getString(j);
                    dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                }
                ii++;
            }
            tbl.setModel(dtm);

            final TableColumnModel columnModel = tbl.getColumnModel();
            for (int column = 0; column < tbl.getColumnCount(); column++) {
                int width = 15; // Min width
                for (int row = 0; row < tbl.getRowCount(); row++) {
                    TableCellRenderer renderer = tbl.getCellRenderer(row, column);
                    Component comp = tbl.prepareRenderer(renderer, row, column);
                    width = Math.max(comp.getPreferredSize().width + 1, width);
                }
                if (width > 300) {
                    width = 300;
                }
                columnModel.getColumn(column).setPreferredWidth(width);
            }
            if (nameT == "Music") {
                tbl.getColumn("Назва").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Виконавець").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Настрій").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Теги").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Посилання").setCellRenderer(new myCellRenderer());
            } else {
                tbl.getColumn("Ім'я").setCellRenderer(new myCellRenderer());
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);

        }
        db.finalize();
    }

    void PlugIn() {
        if (this.conn == null) {
            a.finalize();
            a = null;
            a = new DB();
            conn = a.Connect();
            if (conn == null) {
                // btnUpdate.setVisible(true);
            } else {
                GetData("Music");
            }
        }
    }

    /**
     * Отримання даних
     *
     * @param nameT ім'я таблиці
     */
    public static void GetData(String nameT) {

        DB db = new DB();
        X = null;
        X = db.GetDataSet(nameT);
        int i = 0, ii = 1;
        try {
            ResultSetMetaData colonki = X.getMetaData();
            i = colonki.getColumnCount();
            javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
            dtm.setColumnCount(i);//
            String nazvaKolonki[] = new String[i];
            if (nameT == "Music") {
                nazvaKolonki[0] = "Назва";
                nazvaKolonki[1] = "Виконавець";
                nazvaKolonki[2] = "Настрій";
                nazvaKolonki[3] = "Теги";
                nazvaKolonki[4] = "Посилання";
            } else {
                nazvaKolonki[0] = "Ім'я";
            }
            dtm.setColumnIdentifiers(nazvaKolonki);
            dtm.setRowCount(0);//
            while (X.next()) {
                dtm.setRowCount(dtm.getRowCount() + 1);
                for (int j = 1; j <= i; j++) {
                    String g = X.getString(j);
                    dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                }
                ii++;
            }
            tbl.setModel(dtm);

            final TableColumnModel columnModel = tbl.getColumnModel();
            for (int column = 0; column < tbl.getColumnCount(); column++) {
                int width = 15; // Min width
                for (int row = 0; row < tbl.getRowCount(); row++) {
                    TableCellRenderer renderer = tbl.getCellRenderer(row, column);
                    Component comp = tbl.prepareRenderer(renderer, row, column);
                    width = Math.max(comp.getPreferredSize().width + 1, width);
                }
                if (width > 300) {
                    width = 300;
                }
                columnModel.getColumn(column).setPreferredWidth(width);
            }
            if (nameT == "Music") {
                tbl.getColumn("Назва").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Виконавець").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Настрій").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Теги").setCellRenderer(new myCellRenderer());
                tbl.getColumn("Посилання").setCellRenderer(new myCellRenderer());
            } else {
                tbl.getColumn("Ім'я").setCellRenderer(new myCellRenderer());
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private static class myCellRenderer extends JTextArea implements TableCellRenderer {

        myCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
                Font font = new Font("Times New Roman", Font.PLAIN, 18);
                this.setFont(font);
            }
            if (!isSelected == true) {
                this.setBackground(new Color(169, 76, 175));
                this.setForeground(Color.white);

            } else {
                this.setBackground(new Color(66, 33, 148));
                this.setForeground(Color.white);
            }
            return this;
        }

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnsett3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox<String> jcmbPart;
    public static javax.swing.JComboBox<String> jcmbType;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblHead1;
    private javax.swing.JPanel pnlButtton;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMain;
    public static javax.swing.JTable tbl;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
