/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author ximik
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * @return the data1
     */
    public static String getData1() {
        return data1;
    }

    /**
     * @param aData1 the data1 to set
     */
    public static void setData1(String aData1) {
        data1 = aData1;
    }

    /**
     * @return the data2
     */
    public static String getData2() {
        return data2;
    }

    /**
     * @param aData2 the data2 to set
     */
    public static void setData2(String aData2) {
        data2 = aData2;
    }

    /**
     * @return the nameTbl
     */
    public static String getNameTbl() {
        return nameTbl;
    }

    /**
     * @param aNameTbl the nameTbl to set
     */
    public static void setNameTbl(String aNameTbl) {
        nameTbl = aNameTbl;
    }

    /**
     * @return the VariantData
     */
    public static int getVariantData() {
        return VariantData;
    }

    /**
     * @param aVariantData the VariantData to set
     */
    public static void setVariantData(int aVariantData) {
        VariantData = aVariantData;
    }

    /**
     * @return the nameP
     */
    public static String getNameP() {
        return nameP;
    }

    /**
     * @param aNameP the nameP to set
     */
    public static void setNameP(String aNameP) {
        nameP = aNameP;
    }

    /**
     * @return the RequestVariant
     */
    public static int getRequestVariant() {
        return RequestVariant;
    }

    /**
     * @param aRequestVariant the RequestVariant to set
     */
    public static void setRequestVariant(int aRequestVariant) {
        RequestVariant = aRequestVariant;
    }

    /**
     * @return the dateRequest
     */
    public static int getDateRequest() {
        return dateRequest;
    }

    /**
     * @param aDateRequest the dateRequest to set
     */
    public static void setDateRequest(int aDateRequest) {
        dateRequest = aDateRequest;
    }

    /**
     * @return the addP
     */
    public static int getAddP() {
        return addP;
    }

    /**
     * @param aAddP the addP to set
     */
    public static void setAddP(int aAddP) {
        addP = aAddP;
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
    int xMouse, yMouse;
    private ImageIcon icon = new ImageIcon("");
    private static int status = 0;
    static ResultSet X = null;
    static ResultSet Cat = null;
    static String data = "";
    private Connection conn = null;
    int tb = 0;
    private DataBase a = new DataBase();
    private static int addP = 0;
    private static String nameTbl = "";
    //Можливість запуску тільки одного вікна
    private static int dateRequest = 0;
    //Все що стосується запитів
    private String[] Requests = {"Дані по цеху за місяць", "Зарплати цеху", "Зарплати касирів", "Статистика по працівнику"};

    //Вибір дати для запиту + варіант запуску
    private static int RequestVariant = 0;
    private static int VariantData = 0;
    //Змінні для формування статистики про користувача
    private static String nameP = "";
    public ArrayList<String> Person = new ArrayList<>();
    private static String data1 = "";
    private static String data2 = "";
    static int ExportV = 0;

    /**
     * Creates new form frmMain
     */
    public FormMain() {

        initComponents();
        MoveMouseListener mml = new MoveMouseListener(pnlMain, this);
        pnlMain.addMouseListener(mml);
        pnlMain.addMouseMotionListener(mml);
        this.setLocationRelativeTo(null);
        FormSettingsConnect o = new FormSettingsConnect();
        nameTbl = "allWork";
        pnlInfoZvit.setVisible(false);
        tbl.setBackground(Color.WHITE);
        tbl.setDefaultEditor(Object.class, null);
        tbl.setAutoCreateRowSorter(true);
        btnBack.setVisible(false);
        this.requestFocus();
        txtSearch.setText("Пошук");
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
        btnExport = new javax.swing.JButton();
        pnlHead1 = new javax.swing.JPanel();
        lblExit6 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        pnlActiv = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        pnlInfoZvit = new javax.swing.JPanel();
        lblResultTitle = new javax.swing.JLabel();
        lblResult = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnRequests = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblTitleP = new javax.swing.JLabel();
        chooseTbl = new javax.swing.JComboBox<>();
        lblTitleMove = new javax.swing.JLabel();
        btnExit1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(70, 43, 25));
        setIconImages(null);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setName(""); // NOI18N
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExport.setBackground(new java.awt.Color(120, 101, 84));
        btnExport.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnExport.setForeground(new java.awt.Color(255, 255, 255));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/file-7.png"))); // NOI18N
        btnExport.setText("Експорт");
        btnExport.setMaximumSize(new java.awt.Dimension(70, 70));
        btnExport.setMinimumSize(new java.awt.Dimension(70, 70));
        btnExport.setPreferredSize(new java.awt.Dimension(70, 50));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        pnlMain.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 700, 170, 40));

        pnlHead1.setBackground(new java.awt.Color(70, 43, 25));
        pnlHead1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/exit-2.png"))); // NOI18N
        lblExit6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExit6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExit6MouseEntered(evt);
            }
        });
        pnlHead1.add(lblExit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 50, 50));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Центр керування");
        pnlHead1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 50));

        javax.swing.GroupLayout pnlActivLayout = new javax.swing.GroupLayout(pnlActiv);
        pnlActiv.setLayout(pnlActivLayout);
        pnlActivLayout.setHorizontalGroup(
            pnlActivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlActivLayout.setVerticalGroup(
            pnlActivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlHead1.add(pnlActiv, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, 30));

        lblTitle1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("Галя Балувана");
        pnlHead1.add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 240, 50));

        pnlMain.add(pnlHead1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 50));

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlContentMouseDragged(evt);
            }
        });
        pnlContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlContentMousePressed(evt);
            }
        });

        tbl.setBackground(new java.awt.Color(255, 255, 255));
        tbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl.setForeground(new java.awt.Color(70, 43, 25));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.setFocusable(false);
        tbl.setGridColor(new java.awt.Color(0, 0, 0));
        tbl.setSelectionBackground(new java.awt.Color(240, 219, 189));
        tbl.setSelectionForeground(new java.awt.Color(70, 43, 25));
        tbl.setShowGrid(true);
        tbl.setSize(new java.awt.Dimension(2, 1));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        txtSearch.setBackground(new java.awt.Color(255, 255, 255));
        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMain.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 970, 570));

        pnlInfoZvit.setBackground(new java.awt.Color(240, 219, 189));

        lblResultTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblResultTitle.setForeground(new java.awt.Color(120, 101, 84));
        lblResultTitle.setText("За місяць виготовлено, кг");

        lblResult.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblResult.setForeground(new java.awt.Color(120, 101, 84));
        lblResult.setText("222");

        javax.swing.GroupLayout pnlInfoZvitLayout = new javax.swing.GroupLayout(pnlInfoZvit);
        pnlInfoZvit.setLayout(pnlInfoZvitLayout);
        pnlInfoZvitLayout.setHorizontalGroup(
            pnlInfoZvitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoZvitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResult)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlInfoZvitLayout.setVerticalGroup(
            pnlInfoZvitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoZvitLayout.createSequentialGroup()
                .addGroup(pnlInfoZvitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlMain.add(pnlInfoZvit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 380, -1));

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setLayout(new java.awt.GridLayout(1, 3));

        btnRequests.setBackground(new java.awt.Color(240, 219, 189));
        btnRequests.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        btnRequests.setForeground(new java.awt.Color(0, 0, 0));
        btnRequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/req.png"))); // NOI18N
        btnRequests.setText("Запити");
        btnRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestsActionPerformed(evt);
            }
        });
        pnlButton.add(btnRequests);

        btnAdd.setBackground(new java.awt.Color(240, 219, 189));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/add.png"))); // NOI18N
        btnAdd.setText("Додати");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlButton.add(btnAdd);

        btnEdit.setBackground(new java.awt.Color(240, 219, 189));
        btnEdit.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/edit.png"))); // NOI18N
        btnEdit.setText("Редагувати");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlButton.add(btnEdit);

        btnDelete.setBackground(new java.awt.Color(240, 219, 189));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/delete.png"))); // NOI18N
        btnDelete.setText("Видалити");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlButton.add(btnDelete);

        pnlMain.add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 680, 40));

        lblTitleP.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        lblTitleP.setForeground(new java.awt.Color(0, 0, 0));
        lblTitleP.setText("Розділ:");
        pnlMain.add(lblTitleP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        chooseTbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        chooseTbl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Виробництво", "Каса", "Працівники", "Стажери", "Додаткові виплати" }));
        chooseTbl.setToolTipText("");
        chooseTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseTblActionPerformed(evt);
            }
        });
        pnlMain.add(chooseTbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, 30));

        lblTitleMove.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        lblTitleMove.setForeground(new java.awt.Color(0, 0, 0));
        lblTitleMove.setText("Керування");
        pnlMain.add(lblTitleMove, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, 30));

        btnExit1.setBackground(new java.awt.Color(120, 101, 84));
        btnExit1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(255, 255, 255));
        btnExit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/file-7.png"))); // NOI18N
        btnExit1.setText("Експорт");
        btnExit1.setMaximumSize(new java.awt.Dimension(70, 70));
        btnExit1.setMinimumSize(new java.awt.Dimension(70, 70));
        btnExit1.setPreferredSize(new java.awt.Dimension(70, 50));
        pnlMain.add(btnExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnBack.setBackground(new java.awt.Color(240, 219, 189));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/FLBack.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        pnlMain.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlContentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlContentMousePressed

    }//GEN-LAST:event_pnlContentMousePressed

    private void pnlContentMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlContentMouseDragged

    }//GEN-LAST:event_pnlContentMouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            PlugIn();
            GetData(getNameTbl());
            // btnUpdate.setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pnlContent, "Помилка підключення");
            // btnUpdate.setVisible(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (getNameTbl() == "allWork") {
            FormAddDay ad = new FormAddDay();
            if (getAddP() == 0) {
                ad.setVisible(true);
                setAddP(1);
            } else {
                JOptionPane.showMessageDialog(this, "Відкрито вікно додавання зміни", "Помилка", 2);
            }
        } else if (getNameTbl() == "employees") {
            if (getAddP() == 0) {
                FormAddPerson.setVariant(0);
                FormAddPerson a = new FormAddPerson();
                a.setVisible(true);
                setAddP(1);
            } else {
                JOptionPane.showMessageDialog(this, "Відкрито вікно додавання працівника", "Помилка", 2);
            }
        } else if (getNameTbl() == "cashier") {
            if (getAddP() == 0) {
                FormAddCasTrain add = new FormAddCasTrain();
                add.setVisible(true);
                setAddP(1);
            } else {
                JOptionPane.showMessageDialog(this, "Відкрито вікно додавання зміни касира", "Помилка", 2);
            }
        } else if (getNameTbl() == "category") {
            String name = JOptionPane.showInputDialog(rootPane, "Введіть ім'я категорії:", "Додавання категорії", 3);
            if (name != null && name.length() > 0) {
                a.GetInd("SELECT id FROM category WHERE `nameCategory` = '" + name + "'");
                if (a.getAddName() == "Такого нема") {
                    a.insertCat(name, getNameTbl());
                    GetData("category");
                    JOptionPane.showMessageDialog(this, "Успішно", "Додавання категорії", 1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Категорія існує", "Помилка", 2);
                }
            }
        } else if (getNameTbl() == "Payments") {
            if (getAddP() == 0) {
                FormAddPayment add = new FormAddPayment();
                add.setVisible(true);
                setAddP(1);
            } else {
                JOptionPane.showMessageDialog(this, "Відкрито вікно додавання виплат", "Помилка", 2);
            }
        } else if (getNameTbl() == "Interns") {
            if (getAddP() == 0) {
                FormAddCasTrain.setVariantStart(2);
                FormAddCasTrain add = new FormAddCasTrain();
                add.setVisible(true);
                setAddP(1);
            } else {
                JOptionPane.showMessageDialog(this, "Відкрито вікно додавання стажера", "Помилка", 2);
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int selectedRow = tbl.getSelectedRow();
            String[] YesNo = new String[]{"Так", "Ні"};

            if (getNameTbl() == "allWork") {
                String data = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String countP = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String PIB = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String weightPerOne = (String) tbl.getModel().getValueAt(selectedRow, 3);
                String weightAll = (String) tbl.getModel().getValueAt(selectedRow, 4);
                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити зміну: " + data + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    a.del("allWork", data, countP, PIB, weightPerOne, weightAll);
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("allWork");
                } else {

                }
            } else if (getNameTbl() == "employees") {

                String p = (String) tbl.getModel().getValueAt(selectedRow, 0);
                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити працівника: " + p + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    a.del("employees", p, "", "", "", "");
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("employees");
                }
            } else if (getNameTbl() == "cashier") {
                String pib = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String p = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String sold = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String zp = (String) tbl.getModel().getValueAt(selectedRow, 3);
                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити зміну: " + p + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    a.del("cashier", pib, p, sold, zp, "");
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("cashier");
                }
            } else if (getNameTbl() == "category") {
                String p = (String) tbl.getModel().getValueAt(selectedRow, 1);
                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити категорію: " + p + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    //a.del(Integer.parseInt(val1), "category", "id");
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("category");
                }
            } else if (getNameTbl() == "Interns") {
                String PIB = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String date = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String type = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String zp = (String) tbl.getModel().getValueAt(selectedRow, 3);

                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити зміну: " + date + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    a.del("Interns", PIB, date, type, zp, "");
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("Interns");
                }
            } else if (getNameTbl() == "Payments") {
                String pib = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String date = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String category = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String payment = (String) tbl.getModel().getValueAt(selectedRow, 3);
                int rez = JOptionPane.showOptionDialog(null,
                        "Видалити виплату: " + date + "?",
                        "Видалення",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        YesNo,
                        "default");
                if (rez == 0) {
                    a.del("Payments", pib, date, category, payment, "");
                    JOptionPane.showMessageDialog(this, "Успішно", "Видалення", 1);
                    GetData("Payments");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pnlContent, "Виберіть запис", "Помилка", 2);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(dateRequest==1)
        {
        }
        else
        {
        if (getNameTbl() == "allWork") {
            try {
                int selectedRow = tbl.getSelectedRow();
                //String id = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String Data = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String countPerson = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String Person = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String resultOne = (String) tbl.getModel().getValueAt(selectedRow, 3);
                String resultAll = (String) tbl.getModel().getValueAt(selectedRow, 4);
                DataBase db = new DataBase();
                X = db.GetParam("SELECT id FROM allWork WHERE "
                        + "`date` = '" + Data + "' AND `countPerson` =  '" + countPerson + "' AND `personsName` = '" + Person
                        + "' AND `weightPerOne` = '" + resultOne + "' AND `weightProduced` = '" + resultAll + "';");

                while (X.next()) {
                    FormAddDay.setId(X.getString(1));
                }
                db.finalize();
                FormAddDay.setDate(Data);
                FormAddDay.setResult(resultAll);

                FormAddDay.setCountP(Integer.parseInt(countPerson));
                FormAddDay.setVariantStart(1);

                for (String retval : Person.split("\n")) {
                    FormAddDay.listEdit.add(retval);
                }
                FormAddDay day = new FormAddDay();
                day.setVisible(true);
                dateRequest = 1;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 2);
            }
        } else if (getNameTbl() == "employees") {
            try {
                int selectedRow = tbl.getSelectedRow();
                //String id = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String PIB = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String category = (String) tbl.getModel().getValueAt(selectedRow, 1);
                DataBase db = new DataBase();

                X = db.GetParam("SELECT id FROM employees WHERE "
                        + "`PIB` = '" + PIB + "';");
                while (X.next()) {
                    FormAddPerson.setId(X.getString(1));
                }
                db.finalize();
                FormAddPerson.setPIB(PIB);
                FormAddPerson.setCategory(category);
                FormAddPerson.setVariant(1);
                FormAddPerson ad = new FormAddPerson();
                ad.setVisible(true);
               dateRequest = 1;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 2);
            }
        } else if (getNameTbl() == "cashier") {
            try {
                int selectedRow = tbl.getSelectedRow();
                String PIB = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String Date = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String Suma = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String zp = (String) tbl.getModel().getValueAt(selectedRow, 3);
                DataBase db = new DataBase();

                X = db.GetParam("SELECT id FROM cashier " + "WHERE `PIB` = '" + PIB + "' AND `date` =  '" + Date + "' AND `SoldOut` = '" + Suma
                        + "' AND `Salary` = '" + zp + "';");
                while (X.next()) {
                    FormAddCasTrain.setId(X.getString(1));
                }
                db.finalize();

                FormAddCasTrain.setNameCashier(PIB);
                FormAddCasTrain.setDate(Date);
                FormAddCasTrain.setSuma(Suma);
                FormAddCasTrain.setVariantStart(1);
                FormAddCasTrain st = new FormAddCasTrain();
                st.setVisible(true);
                dateRequest = 1;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 2);
            }
        } else if (getNameTbl() == "Interns") {
            try {
                int selectedRow = tbl.getSelectedRow();
                String PIB = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String Date = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String type = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String zp = (String) tbl.getModel().getValueAt(selectedRow, 3);
                DataBase db = new DataBase();

                X = db.GetParam("SELECT id FROM Interns " + "WHERE `PIB` = '" + PIB + "' AND `date` =  '" + Date + "' AND `type` = '" + type
                        + "' AND `Salary` = '" + zp + "';");
                while (X.next()) {
                    FormAddCasTrain.setId(X.getString(1));
                }
                db.finalize();

                FormAddCasTrain.setNameCashier(PIB);
                FormAddCasTrain.setDate(Date);
                FormAddCasTrain.setSuma(type);
                FormAddCasTrain.setVariantStart(3);
                FormAddCasTrain st = new FormAddCasTrain();
                st.setVisible(true);
               dateRequest = 1;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 2);
            }
        } else if (getNameTbl() == "Payments") {
            try {
                int selectedRow = tbl.getSelectedRow();
                String pib = (String) tbl.getModel().getValueAt(selectedRow, 0);
                String date = (String) tbl.getModel().getValueAt(selectedRow, 1);
                String category = (String) tbl.getModel().getValueAt(selectedRow, 2);
                String payment = (String) tbl.getModel().getValueAt(selectedRow, 3);
                DataBase db = new DataBase();

                X = db.GetParam("SELECT id FROM Payments " + "WHERE `PIB` = '" + pib + "' AND `date` =  '" + date + "' AND `categoryPayment` = '" + category
                        + "' AND `Payment` = '" + payment + "';");
                while (X.next()) {
                    FormAddPayment.setId(X.getString(1));
                }
                db.finalize();
                FormAddPayment.setNameCashier(pib);
                FormAddPayment.setDate(date);
                FormAddPayment.setType(category);
                FormAddPayment.setSuma(payment);
                FormAddPayment.setVariantStart(1);
                FormAddPayment st = new FormAddPayment();
                st.setVisible(true);
                dateRequest = 1;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Виберіть запис", "Помилка", 2);
            }
        }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestsActionPerformed

        if (getDateRequest() == 0) {
            FormDataRequest dr = new FormDataRequest();
            Object result = JOptionPane.showInputDialog(
                    this, "Виберіть необхідний запит",
                    "Вибір запиту",
                    JOptionPane.QUESTION_MESSAGE,
                    icon, Requests, Requests[0]);
            if (result == "Дані по цеху за місяць") {
                setRequestVariant(0);
                setVariantData(0);
                dr.setVisible(true);
                setDateRequest(1);
                ExportV = 1;
            } else if (result == "Зарплати цеху") {
                //Дати
                FormDataRequest.setCategory(1);
                setRequestVariant(1);
                dr.setVisible(true);
                setDateRequest(1);
                ExportV = 2;
            } else if (result == "Статистика по працівнику") {
                try {
                    setDateRequest(1);
                    DataBase db = new DataBase();
                    X = db.GetParam("SELECT PIB FROM employees");
                    while (X.next()) {
                        String get = X.getString(1);
                        Person.add(get);
                    }
                    String[] pr = new String[Person.size()];
                    for (int i = 0; i < Person.size(); i++) {
                        pr[i] = Person.get(i);
                    }
                    Object person = JOptionPane.showInputDialog(
                            this, "Виберіть працівника",
                            "Вибір працівника",
                            JOptionPane.QUESTION_MESSAGE,
                            icon, pr, pr[0]);
                    if (person != null) {
                        setNameP(person.toString());
                        RequestVariant = 2;
                        dr.setVisible(true);
                        Person.clear();

                    } else {
                        setDateRequest(0);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                    Person.clear();
                    setDateRequest(0);
                }
            } else if (result == "Зарплати касирів") {
                //Дати
                FormDataRequest.setCategory(2);
                setRequestVariant(1);
                dr.setVisible(true);
                setDateRequest(1);
                ExportV = 3;
            }
        }

    }//GEN-LAST:event_btnRequestsActionPerformed

    private void chooseTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseTblActionPerformed

        if (chooseTbl.getSelectedItem().toString() == "Виробництво") {
            GetData("allWork");
            setNameTbl("allWork");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        } else if (chooseTbl.getSelectedItem().toString() == "Працівники") {
            setNameTbl("employees");
            GetData("employees");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        } else if (chooseTbl.getSelectedItem().toString() == "Стажери") {
            GetData("Interns");
            setNameTbl("Interns");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        } else if (chooseTbl.getSelectedItem().toString() == "Каса") {
            GetData("cashier");
            setNameTbl("cashier");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        } else if (chooseTbl.getSelectedItem().toString() == "Категорії") {
            GetData("category");
            setNameTbl("category");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        } else if (chooseTbl.getSelectedItem().toString() == "Додаткові виплати") {
            GetData("Payments");
            setNameTbl("Payments");
            pnlInfoZvit.setVisible(false);
            txtSearch.setText("Пошук");
        }
        btnExport.setVisible(false);
        btnBack.setVisible(false);
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        txtSearch.setEnabled(true);
    }//GEN-LAST:event_chooseTblActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        pnlContent.requestFocus();
    }//GEN-LAST:event_tblMouseClicked

    private void lblExit6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit6MouseClicked
        FormMenu menu = new FormMenu();
        menu.setVisible(true);
        a.finalize();
        this.dispose();
    }//GEN-LAST:event_lblExit6MouseClicked

    private void lblExit6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit6MouseEntered

    }//GEN-LAST:event_lblExit6MouseEntered

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        if (path != null && path != "") {
            try {
                createDoc(path);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (chooseTbl.getSelectedItem().toString() == "Виробництво") {
            GetData("allWork");
            setNameTbl("allWork");
            pnlInfoZvit.setVisible(false);
        } else if (chooseTbl.getSelectedItem().toString() == "Працівники") {
            GetData("employees");
            setNameTbl("employees");
            pnlInfoZvit.setVisible(false);
        } else if (chooseTbl.getSelectedItem().toString() == "Стажери") {
            GetData("Interns");
            setNameTbl("Interns");
            pnlInfoZvit.setVisible(false);
        } else if (chooseTbl.getSelectedItem().toString() == "Каса") {
            GetData("cashier");
            setNameTbl("cashier");
            pnlInfoZvit.setVisible(false);
        } else if (chooseTbl.getSelectedItem().toString() == "Категорії") {
            GetData("category");
            setNameTbl("category");
            pnlInfoZvit.setVisible(false);
        } else if (chooseTbl.getSelectedItem().toString() == "Додаткові виплати") {
            GetData("Payments");
            setNameTbl("Payments");
            pnlInfoZvit.setVisible(false);
        }
        txtSearch.setText("Пошук");
        btnExport.setVisible(false);
        btnBack.setVisible(false);
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
        txtSearch.setEnabled(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Пошук")) {
            txtSearch.setText("");
            // txtSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().isEmpty()) {
            // txtSearch.setForeground(Color.GRAY);
            txtSearch.setText("Пошук");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void tblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseEntered

    }//GEN-LAST:event_tblMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        try {
            Search(nameTbl, txtSearch.getText());
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_txtSearchKeyTyped

    /**
     * Пошук
     * @param nameT Ім'я таблиці
     * @param text Текс пошуку
     */
    void Search(String nameT, String text) {
        DataBase db = new DataBase();
        DataBase ac = new DataBase();
        if (nameT == "allWork") {
            X = db.Search(nameT, text);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "№";
                nazvaKolonki[1] = "Дата";
                nazvaKolonki[2] = "К-сть осіб";
                nazvaKolonki[3] = "ПІБ";
                nazvaKolonki[4] = "Кг на особу";
                nazvaKolonki[5] = "Кг за зміну";
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
                tbl.getColumn("№").setMinWidth(30);
                tbl.getColumn("№").setMaxWidth(50);

                tbl.getColumn("Дата").setMinWidth(100);
                tbl.getColumn("Дата").setMaxWidth(100);

                tbl.getColumn("К-сть осіб").setMinWidth(100);
                tbl.getColumn("К-сть осіб").setMaxWidth(100);

                tbl.getColumn("Кг на особу").setMinWidth(140);
                tbl.getColumn("Кг на особу").setMaxWidth(140);

                tbl.getColumn("Кг за зміну").setMinWidth(100);
                tbl.getColumn("Кг за зміну").setMaxWidth(100);
                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("ПІБ").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
        } else if (nameT == "employees") {
            X = db.Search(nameT, text);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Номер запису";
                nazvaKolonki[1] = "Працівник";
                nazvaKolonki[2] = "Категорія";
                dtm.setColumnIdentifiers(nazvaKolonki);
                dtm.setRowCount(0);//
                while (X.next()) {
                    dtm.setRowCount(dtm.getRowCount() + 1);
                    for (int j = 1; j <= i; j++) {
                        String g = X.getString(j);
                        if (j - 1 == 2) {
                            Cat = ac.GetParam("SELECT nameCategory FROM category WHERE id = " + g);
                            while (Cat.next()) {
                                dtm.setValueAt(Cat.getString(1), ii - 1, j - 1);
                            }
                        } else {
                            dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                        }

                    }
                    ii++;
                }
                tbl.setModel(dtm);
                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
        } else if (nameT == "cashier") {
            X = db.Search(nameT, text);
            String formatD;
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "№";
                nazvaKolonki[1] = "Працівник";
                nazvaKolonki[2] = "Дата";
                nazvaKolonki[3] = "Сума продажу";
                nazvaKolonki[4] = "Заробіток";
                dtm.setColumnIdentifiers(nazvaKolonki);
                dtm.setRowCount(0);//
                while (X.next()) {
                    dtm.setRowCount(dtm.getRowCount() + 1);
                    for (int j = 1; j <= i; j++) {
                        String g = X.getString(j);
                        if (j == 4) {
                            double c = Double.parseDouble(g);
                            formatD = new DecimalFormat("#0.00").format(c);
                            dtm.setValueAt(formatD.replace(",", "."), ii - 1, j - 1);//виводимо дані у модель
                        } else {
                            dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                        }

                    }
                    ii++;
                }
                tbl.setModel(dtm);

                tbl.getColumn("Дата").setMinWidth(100);
                tbl.getColumn("Дата").setMaxWidth(100);

                tbl.getColumn("Сума продажу").setMinWidth(140);
                tbl.getColumn("Сума продажу").setMaxWidth(140);

                tbl.getColumn("Заробіток").setMinWidth(140);
                tbl.getColumn("Заробіток").setMaxWidth(140);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
        } else if (nameT == "Interns") {
            X = db.Search(nameT, text);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "№";
                nazvaKolonki[1] = "Стажер";
                nazvaKolonki[2] = "Дата";
                nazvaKolonki[3] = "Тип";
                nazvaKolonki[4] = "Заробіток";
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

                tbl.getColumn("№").setMinWidth(30);
                tbl.getColumn("№").setMaxWidth(50);

                tbl.getColumn("Дата").setMinWidth(120);
                tbl.getColumn("Дата").setMaxWidth(120);

                tbl.getColumn("Тип").setMinWidth(180);
                tbl.getColumn("Тип").setMaxWidth(180);

                tbl.getColumn("Заробіток").setMinWidth(160);
                tbl.getColumn("Заробіток").setMaxWidth(160);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Стажер").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
        } else if (nameT == "Payments") {
            X = db.Search(nameT, text);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "№";
                nazvaKolonki[1] = "Працівник";
                nazvaKolonki[2] = "Дата";
                nazvaKolonki[3] = "Вид виплати";
                nazvaKolonki[4] = "Сума";
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

                tbl.getColumn("№").setMinWidth(30);
                tbl.getColumn("№").setMaxWidth(50);

                tbl.getColumn("Дата").setMinWidth(120);
                tbl.getColumn("Дата").setMaxWidth(120);

                tbl.getColumn("Вид виплати").setMinWidth(180);
                tbl.getColumn("Вид виплати").setMaxWidth(180);

                tbl.getColumn("Сума").setMinWidth(160);
                tbl.getColumn("Сума").setMaxWidth(160);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(120, 101, 84));
        headerRenderer.setForeground(new Color(240, 219, 189));
        for (int i = 0; i < tbl.getModel().getColumnCount(); i++) {
            tbl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
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
        db.finalize();
        ac.finalize();

    }

    /**
     * Створення документу
     * @param path Пошук
     * @throws FileNotFoundException 
     */
    void createDoc(String path) throws FileNotFoundException {
        if (ExportV == 1) {
            try {
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(new File(path + "/" + "ЗвітЦех від " + getData1() + " до " + getData2() + ".docx"));
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setFontSize(14);
                run.setFontFamily("Times New Roman");
                run.setText("Дані цеху від " + getData1() + " до " + getData2());
                paragraph.setSpacingAfter(200);

                //Створення таблиці
                XWPFTable table = document.createTable();
                table.setCellMargins(200, 200, 200, 200);
                //// 
                //Перший стовпчик
                XWPFTableRow tableRowOne = table.getRow(0);
                XWPFTableCell cell0 = tableRowOne.getCell(0);
                cell0.removeParagraph(0);
                XWPFParagraph p = cell0.addParagraph();
                XWPFRun run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Дата");
                /////
                ////Другий стовпчик
                XWPFTableCell cell1 = tableRowOne.createCell();
                cell1.removeParagraph(0);
                p = cell1.addParagraph();
                run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("К-сть осіб");
                /////
                //Третій стовпчик
                XWPFTableCell cell2 = tableRowOne.createCell();
                cell2.removeParagraph(0);
                p = cell2.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("ПІБ");
                ////
                //Четвертий стовпчик
                XWPFTableCell cell3 = tableRowOne.createCell();
                cell3.removeParagraph(0);
                p = cell3.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Кг на особу");
                ////
                //П'ятий стовпчик
                XWPFTableCell cell4 = tableRowOne.createCell();
                cell4.removeParagraph(0);
                p = cell4.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Кг за зміну");
                ////
                //Запис даних
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    XWPFTableRow tableRow = table.createRow();
                    XWPFTableCell cell01 = tableRow.getCell(0);
                    cell01.removeParagraph(0);
                    p = cell01.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 1).toString());

                    XWPFTableCell cell02 = tableRow.getCell(1);
                    cell02.removeParagraph(0);
                    p = cell02.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 2).toString());

                    XWPFTableCell cell03 = tableRow.getCell(2);
                    cell03.removeParagraph(0);
                    p = cell03.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    for (String retval : (tbl.getModel().getValueAt(i, 3).toString()).split("\n")) {
                        run1 = p.createRun();
                        run1.setFontSize(14);
                        run1.setFontFamily("Times New Roman");
                        run1.setText(retval.trim());
                        run1.addBreak();
                    }
                    XWPFTableCell cell04 = tableRow.getCell(3);
                    cell04.removeParagraph(0);
                    p = cell04.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 4).toString());

                    XWPFTableCell cell05 = tableRow.getCell(4);
                    cell05.removeParagraph(0);
                    p = cell05.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 5).toString());

                }
                XWPFTableRow tableRow = table.createRow();
                XWPFTableCell cell01 = tableRow.getCell(0);
                cell01.removeParagraph(0);
                p = cell01.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText("Всього");

                XWPFTableCell cell02 = tableRow.getCell(4);
                cell02.removeParagraph(0);
                p = cell02.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText(lblResult.getText() + " кг");

                document.write(out);
                out.close();
                JOptionPane.showMessageDialog(rootPane, "Успішно", "Повідомлення", 1);
            } catch (Exception ex) {

            }
        } else if (ExportV == 2) {
            try {
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(new File(path + "/" + "ЗаробітніПлатиЦех від " + getData1() + " до " + getData2() + ".docx"));
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setFontSize(14);
                run.setFontFamily("Times New Roman");
                run.setText("Заробітні плати цеху від " + getData1() + " до " + getData2());
                paragraph.setSpacingAfter(200);

                //Створення таблиці
                XWPFTable table = document.createTable();
                table.setCellMargins(200, 200, 200, 200);
                //// 
                //Перший стовпчик
                XWPFTableRow tableRowOne = table.getRow(0);
                XWPFTableCell cell0 = tableRowOne.getCell(0);
                cell0.removeParagraph(0);
                XWPFParagraph p = cell0.addParagraph();
                XWPFRun run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("ПІБ");
                /////
                ////Другий стовпчик
                XWPFTableCell cell1 = tableRowOne.createCell();
                cell1.removeParagraph(0);
                p = cell1.addParagraph();
                run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("К-сть змін");
                /////
                //Третій стовпчик
                XWPFTableCell cell2 = tableRowOne.createCell();
                cell2.removeParagraph(0);
                p = cell2.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Кілограми");
                ////
                //Четвертий стовпчик
                XWPFTableCell cell3 = tableRowOne.createCell();
                cell3.removeParagraph(0);
                p = cell3.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Зарплата");
                ////
                ////
                //Запис даних
                double allCas = 0;
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    XWPFTableRow tableRow = table.createRow();
                    XWPFTableCell cell01 = tableRow.getCell(0);
                    cell01.removeParagraph(0);
                    p = cell01.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 0).toString());

                    XWPFTableCell cell02 = tableRow.getCell(1);
                    cell02.removeParagraph(0);
                    p = cell02.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 1).toString());

                    XWPFTableCell cell03 = tableRow.getCell(2);
                    cell03.removeParagraph(0);
                    p = cell03.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 2).toString());

                    //JOptionPane.showMessageDialog(pnlContent, tbl.getModel().getValueAt(i, 2).toString());
                    XWPFTableCell cell04 = tableRow.getCell(3);
                    cell04.removeParagraph(0);
                    p = cell04.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    if (tbl.getModel().getValueAt(i, 3) == null) {
                        run1.setText("0 грн");
                    } else {
                        run1.setText(tbl.getModel().getValueAt(i, 3).toString() + " грн");
                        allCas = allCas + Integer.parseInt(tbl.getModel().getValueAt(i, 3).toString());
                    }

                }
                XWPFTableRow tableRow = table.createRow();
                XWPFTableCell cell01 = tableRow.getCell(0);
                cell01.removeParagraph(0);
                p = cell01.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText("Всього");

                XWPFTableCell cell02 = tableRow.getCell(3);
                cell02.removeParagraph(0);
                p = cell02.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText(allCas + " грн");

                document.write(out);
                out.close();
                JOptionPane.showMessageDialog(rootPane, "Успішно", "Повідомлення", 1);
            } catch (Exception ex) {

            }

        } else if (ExportV == 3) {
            try {
                XWPFDocument document = new XWPFDocument();
                FileOutputStream out = new FileOutputStream(new File(path + "/" + "ЗаробітніПлатиКаса від " + getData1() + " до " + getData2() + ".docx"));
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setFontSize(14);
                run.setFontFamily("Times New Roman");
                run.setText("Заробітні плати касирів від " + getData1() + " до " + getData2());
                paragraph.setSpacingAfter(200);

                //Створення таблиці
                XWPFTable table = document.createTable();
                table.setCellMargins(200, 200, 200, 200);
                //// 
                //Перший стовпчик
                XWPFTableRow tableRowOne = table.getRow(0);
                XWPFTableCell cell0 = tableRowOne.getCell(0);
                cell0.removeParagraph(0);
                XWPFParagraph p = cell0.addParagraph();
                XWPFRun run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("ПІБ");
                /////
                ////Другий стовпчик
                XWPFTableCell cell1 = tableRowOne.createCell();
                cell1.removeParagraph(0);
                p = cell1.addParagraph();
                run1 = p.createRun();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("К-сть змін");
                /////
                //Третій стовпчик
                XWPFTableCell cell2 = tableRowOne.createCell();
                cell2.removeParagraph(0);
                p = cell2.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Сума продаж");
                ////
                //Четвертий стовпчик
                XWPFTableCell cell3 = tableRowOne.createCell();
                cell3.removeParagraph(0);
                p = cell3.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setFontFamily("Times New Roman");
                run1.setText("Зарплата");
                ////
                ////
                //Запис даних
                double allCas = 0;
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    XWPFTableRow tableRow = table.createRow();
                    XWPFTableCell cell01 = tableRow.getCell(0);
                    cell01.removeParagraph(0);
                    p = cell01.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 0).toString());

                    XWPFTableCell cell02 = tableRow.getCell(1);
                    cell02.removeParagraph(0);
                    p = cell02.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 1).toString());

                    XWPFTableCell cell03 = tableRow.getCell(2);
                    cell03.removeParagraph(0);
                    p = cell03.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    run1.setText(tbl.getModel().getValueAt(i, 2).toString() + " грн");

                    //JOptionPane.showMessageDialog(pnlContent, tbl.getModel().getValueAt(i, 2).toString());
                    XWPFTableCell cell04 = tableRow.getCell(3);
                    cell04.removeParagraph(0);
                    p = cell04.addParagraph();
                    p.setAlignment(ParagraphAlignment.CENTER);
                    run1 = p.createRun();
                    run1.setFontSize(14);
                    run1.setFontFamily("Times New Roman");
                    if (tbl.getModel().getValueAt(i, 3) == null) {
                        run1.setText("0 грн");
                    } else {
                        run1.setText(tbl.getModel().getValueAt(i, 3).toString() + " грн");
                        allCas = allCas + Integer.parseInt(tbl.getModel().getValueAt(i, 3).toString());
                    }
                }

                XWPFTableRow tableRow = table.createRow();
                XWPFTableCell cell01 = tableRow.getCell(0);
                cell01.removeParagraph(0);
                p = cell01.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText("Всього");

                XWPFTableCell cell02 = tableRow.getCell(3);
                cell02.removeParagraph(0);
                p = cell02.addParagraph();
                p.setAlignment(ParagraphAlignment.CENTER);
                run1 = p.createRun();
                run1.setFontSize(14);
                run1.setBold(true);
                run1.setFontFamily("Times New Roman");
                run1.setText(allCas + " грн");

                document.write(out);
                out.close();
                JOptionPane.showMessageDialog(rootPane, "Успішно", "Повідомлення", 1);
            } catch (Exception ex) {

            }
        }

    }

    /**
     * Підключення
     */
    void PlugIn() {
        if (this.conn == null) {
            conn = a.Connect();
            if (conn == null) {
                pnlActiv.setBackground(Color.red);
                //  btnUpdateCon.setVisible(true);
            } else {
                pnlActiv.setBackground(Color.green);
                // btnUpdateCon.setVisible(false);
            }
        }
    }

    /**
     * Отримання інформації
     * @param nameT Ім'я таблиці
     */
    public static void GetData(String nameT) {
        DataBase db = new DataBase();
        DataBase ac = new DataBase();
        if (nameT == "allWork") {
            X = db.GetDataSet(nameT);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                //nazvaKolonki[0] = "№";
                nazvaKolonki[0] = "Дата";
                nazvaKolonki[1] = "К-сть осіб";
                nazvaKolonki[2] = "ПІБ";
                nazvaKolonki[3] = "Кг на особу";
                nazvaKolonki[4] = "Кг за зміну";
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
//                tbl.getColumn("№").setMinWidth(30);
//                tbl.getColumn("№").setMaxWidth(50);

                tbl.getColumn("Дата").setMinWidth(100);
                tbl.getColumn("Дата").setMaxWidth(100);

                tbl.getColumn("К-сть осіб").setMinWidth(100);
                tbl.getColumn("К-сть осіб").setMaxWidth(100);

                tbl.getColumn("Кг на особу").setMinWidth(140);
                tbl.getColumn("Кг на особу").setMaxWidth(140);

                tbl.getColumn("Кг за зміну").setMinWidth(100);
                tbl.getColumn("Кг за зміну").setMaxWidth(100);
                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("ПІБ").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
            chooseTbl.setSelectedItem("Виробництво");
        } else if (nameT == "employees") {
            X = db.GetDataSet(nameT);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Працівник";
                nazvaKolonki[1] = "Категорія";
                dtm.setColumnIdentifiers(nazvaKolonki);
                dtm.setRowCount(0);//
                while (X.next()) {
                    dtm.setRowCount(dtm.getRowCount() + 1);
                    for (int j = 1; j <= i; j++) {
                        String g = X.getString(j);
                        if (j - 1 == 1) {
                            Cat = ac.GetParam("SELECT nameCategory FROM category WHERE id = " + g);
                            while (Cat.next()) {
                                dtm.setValueAt(Cat.getString(1), ii - 1, j - 1);
                            }
                        } else {
                            dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                        }

                    }
                    ii++;
                }
                tbl.setModel(dtm);
                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
            chooseTbl.setSelectedItem("Працівники");
        } else if (nameT == "cashier") {
            X = db.GetDataSet(nameT);
            String formatD;
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Працівник";
                nazvaKolonki[1] = "Дата";
                nazvaKolonki[2] = "Сума продажу";
                nazvaKolonki[3] = "Заробіток";
                dtm.setColumnIdentifiers(nazvaKolonki);
                dtm.setRowCount(0);//
                while (X.next()) {
                    dtm.setRowCount(dtm.getRowCount() + 1);
                    for (int j = 1; j <= i; j++) {
                        String g = X.getString(j);
                        if (j == 4) {
                            double c = Double.parseDouble(g);
                            formatD = new DecimalFormat("#0.00").format(c);
                            dtm.setValueAt(formatD.replace(",", "."), ii - 1, j - 1);//виводимо дані у модель
                        } else {
                            dtm.setValueAt(g, ii - 1, j - 1);//виводимо дані у модель
                        }

                    }
                    ii++;
                }
                tbl.setModel(dtm);

                tbl.getColumn("Дата").setMinWidth(100);
                tbl.getColumn("Дата").setMaxWidth(100);

                tbl.getColumn("Сума продажу").setMinWidth(140);
                tbl.getColumn("Сума продажу").setMaxWidth(140);

                tbl.getColumn("Заробіток").setMinWidth(140);
                tbl.getColumn("Заробіток").setMaxWidth(140);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
            chooseTbl.setSelectedItem("Каса");
        } else if (nameT == "category") {
            X = db.GetDataSet(nameT);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Код";
                nazvaKolonki[1] = "Посада";
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
                tbl.getColumn("Посада").setCellRenderer(new myCellRenderer());

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
        } else if (nameT == "Interns") {
            X = db.GetDataSet(nameT);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Стажер";
                nazvaKolonki[1] = "Дата";
                nazvaKolonki[2] = "Тип";
                nazvaKolonki[3] = "Заробіток";
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

                tbl.getColumn("Дата").setMinWidth(120);
                tbl.getColumn("Дата").setMaxWidth(120);

                tbl.getColumn("Тип").setMinWidth(180);
                tbl.getColumn("Тип").setMaxWidth(180);

                tbl.getColumn("Заробіток").setMinWidth(160);
                tbl.getColumn("Заробіток").setMaxWidth(160);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Стажер").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                //  txtRez.setText(ex.getMessage());
            }
            chooseTbl.setSelectedItem("Стажери");
        } else if (nameT == "Payments") {
            X = db.GetDataSet(nameT);
            int i = 0, ii = 1;
            try {
                ResultSetMetaData colonki = X.getMetaData();
                i = colonki.getColumnCount();
                javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                dtm.setColumnCount(i);//
                String nazvaKolonki[] = new String[i];
                nazvaKolonki[0] = "Працівник";
                nazvaKolonki[1] = "Дата";
                nazvaKolonki[2] = "Вид виплати";
                nazvaKolonki[3] = "Сума";
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

                tbl.getColumn("Дата").setMinWidth(120);
                tbl.getColumn("Дата").setMaxWidth(120);

                tbl.getColumn("Вид виплати").setMinWidth(180);
                tbl.getColumn("Вид виплати").setMaxWidth(180);

                tbl.getColumn("Сума").setMinWidth(160);
                tbl.getColumn("Сума").setMaxWidth(160);

                for (int j = 1; j <= i; j++) {
                    tbl.getColumn("Працівник").setCellRenderer(new myCellRenderer());
                }

            } catch (Exception ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            chooseTbl.setSelectedItem("Додаткові виплати");
        }

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(120, 101, 84));
        headerRenderer.setForeground(new Color(240, 219, 189));
        for (int i = 0; i < tbl.getModel().getColumnCount(); i++) {
            tbl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
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
        if (nameT != "employees" && nameT != "cashier" && nameT != "Interns" && nameT != "Payments") {
            for (int i = 0; i < tbl.getColumnCount(); i++) {
                DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
                centerRend.setHorizontalAlignment(JLabel.CENTER);
                if (i == 2 && nameT == "allWork") {

                } else {
                    tbl.getColumnModel().getColumn(i).setCellRenderer(centerRend);
                }
            }
        }
        db.finalize();
        ac.finalize();

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
                Font font = new Font("Times New Roman", Font.PLAIN, 19);
                this.setFont(font);
                this.setBackground(new Color(255, 255, 255));
                this.setSelectionColor(new Color(240, 219, 189));
                this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            }
            if (!isSelected == true) {
                this.setBackground(Color.WHITE);
            } else {

                this.setBackground(new Color(240, 219, 189));
            }
            return this;
        }
    }

    static void Result(String rez) {
        pnlInfoZvit.setVisible(true);
        lblResult.setText(rez);
        btnExport.setVisible(true);
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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd;
    public static javax.swing.JButton btnBack;
    public static javax.swing.JButton btnDelete;
    public static javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit1;
    public static javax.swing.JButton btnExport;
    private javax.swing.JButton btnRequests;
    public static javax.swing.JComboBox<String> chooseTbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExit6;
    public static javax.swing.JLabel lblResult;
    public static javax.swing.JLabel lblResultTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitleMove;
    private javax.swing.JLabel lblTitleP;
    private javax.swing.JPanel pnlActiv;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHead1;
    public static javax.swing.JPanel pnlInfoZvit;
    private javax.swing.JPanel pnlMain;
    public static javax.swing.JTable tbl;
    public static javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
