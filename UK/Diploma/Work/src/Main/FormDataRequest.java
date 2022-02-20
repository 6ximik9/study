/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Main.FormInfoWorker.tblInfo;
import static Main.FormInfoWorker.tblInfoV;
import static Main.FormMain.btnAdd;
import static Main.FormMain.btnBack;
import static Main.FormMain.btnDelete;
import static Main.FormMain.btnEdit;
import static Main.FormMain.btnExport;
import static Main.FormMain.pnlInfoZvit;
import static Main.FormMain.tbl;
import static Main.FormMain.txtSearch;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ximik
 */
public class FormDataRequest extends javax.swing.JFrame {

    /**
     * @return the Sal
     */
    public static String getSal() {
        return Sal;
    }

    /**
     * @param aSal the Sal to set
     */
    public static void setSal(String aSal) {
        Sal = aSal;
    }

    /**
     * @return the weight
     */
    public static String getWeight() {
        return weight;
    }

    /**
     * @param aWeight the weight to set
     */
    public static void setWeight(String aWeight) {
        weight = aWeight;
    }

    /**
     * @return the countDay
     */
    public static String getCountDay() {
        return countDay;
    }

    /**
     * @param aCountDay the countDay to set
     */
    public static void setCountDay(String aCountDay) {
        countDay = aCountDay;
    }

    /**
     * @return the category
     */
    public static int getCategory() {
        return category;
    }

    /**
     * @param aCategory the category to set
     */
    public static void setCategory(int aCategory) {
        category = aCategory;
    }

    ResultSet X = null;
    ResultSet XS = null;
    ResultSet Intern = null;
    ResultSet Pay = null;
    ResultSet P = null;
    ResultSet Zp = null;
    DataBase a = null;
    DataBase db = null;
    DataBase Internn = null;
    DataBase PP = null;
    DataBase Zpp = null;
    private Connection conn = null;
    public ArrayList<String> Person = new ArrayList<>();
    private static int category = 0;
    private static String countDay = "";
    private static String weight = "";
    private static String Sal = "";
    double ValueKh = 0;

    /**
     * Creates new form dataRequest
     */
    public FormDataRequest() {
        initComponents();
        a = new DataBase();
        db = new DataBase();
        Internn = new DataBase();
        PP = new DataBase();
        Zpp = new DataBase();
        MoveMouseListener mml = new MoveMouseListener(pnlHead, this);
        pnlHead.addMouseListener(mml);
        pnlHead.addMouseMotionListener(mml);
        this.setLocationRelativeTo(null);

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
        dateNow = new com.toedter.calendar.JDateChooser();
        btnNext = new javax.swing.JButton();
        dateLast = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblExit1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 219, 189));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(240, 219, 189));

        dateNow.setDateFormatString("y-M-d");

        btnNext.setBackground(new java.awt.Color(120, 101, 84));
        btnNext.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photo/file-6.png"))); // NOI18N
        btnNext.setText("Продовжити");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        dateLast.setDateFormatString("y-M-d");

        jLabel1.setBackground(new java.awt.Color(70, 43, 25));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Від");

        jLabel2.setBackground(new java.awt.Color(70, 43, 25));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("До");

        pnlHead.setBackground(new java.awt.Color(70, 43, 25));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Вибір терміну");

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
                .addComponent(lblExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblExit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateNow, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLast, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateNow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (dateLast.getDate() != null && dateNow.getDate() != null) {
            FormMain.setData1(dateFormat.format(dateLast.getDate()).toString());
            FormMain.setData2(dateFormat.format(dateNow.getDate()).toString());
            getCalc();
            if (FormMain.getRequestVariant() == 0) {
                String date1 = dateFormat.format(dateLast.getDate());
                String date2 = dateFormat.format(dateNow.getDate());
                //PlugIn();
                GetData("allWork", date1, date2);
                double allW = 0;
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    String val = (String) tbl.getModel().getValueAt(i, 5);
                    allW += Double.parseDouble(val);
                }
                pnlInfoZvit.setVisible(false);
                FormMain.Result(allW + "");
                a.finalize();
                db.finalize();
                Internn.finalize();
                dispose();
                FormMain.setDateRequest(0);
                btnAdd.setEnabled(false);
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnBack.setVisible(true);
                txtSearch.setEnabled(false);
            } else if (FormMain.getRequestVariant() == 1) {
                String date1 = dateFormat.format(dateLast.getDate());
                String date2 = dateFormat.format(dateNow.getDate());

                if (getCategory() == 1) {
                    X = db.GetParam("SELECT PIB FROM employees WHERE idCategory = 1");
                } else if (getCategory() == 2) {
                    X = db.GetParam("SELECT PIB FROM employees WHERE idCategory = 2");
                }
                int i = 0, ii = 1;
                try {
                    while (X.next()) {
                        String get = X.getString(1);
                        Person.add(get);
                    }
                    ResultSetMetaData colonki = X.getMetaData();
                    i = 4;
                    javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                    dtm.setColumnCount(i);//
                    String nazvaKolonki[] = new String[i];
                    if (getCategory() == 1) {
                        nazvaKolonki[0] = "ПІБ";
                        nazvaKolonki[1] = "Зміни";
                        nazvaKolonki[2] = "Кілограми";
                        nazvaKolonki[3] = "Зарплата";
                    } else if (getCategory() == 2) {
                        nazvaKolonki[0] = "ПІБ";
                        nazvaKolonki[1] = "Зміни";
                        nazvaKolonki[2] = "Сума продаж";
                        nazvaKolonki[3] = "Зарплата";
                    }
                    dtm.setColumnIdentifiers(nazvaKolonki);
                    dtm.setRowCount(0);//
                    if (getCategory() == 1) {
                        X = db.GetParam("SELECT PIB FROM employees WHERE idCategory = 1");
                    } else if (getCategory() == 2) {
                        X = db.GetParam("SELECT PIB FROM employees WHERE idCategory = 2");
                    }
                    while (X.next()) {
                        dtm.setRowCount(dtm.getRowCount() + 1);
                        for (int j = 1; j <= i; j++) {
                            String g = X.getString(1);
                            dtm.setValueAt(g, ii - 1, 0);//виводимо дані у модель
                        }
                        ii++;
                    }

                    ii = 1;
                    for (int f = 0; f < Person.size(); f++) {
                        if (getCategory() == 1) {
                            X = db.GetParam("SELECT COUNT(*) as count From allWork WHERE personsName like '%" + Person.get(f) + "%'"
                                    + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        } else if (getCategory() == 2) {

                            X = db.GetParam("SELECT COUNT(*) as count From cashier WHERE PIB like '%" + Person.get(f) + "%'"
                                    + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        }
                        while (X.next()) {
                            for (int j = 1; j <= i; j++) {
                                String Zmina = X.getString(1);
                                dtm.setValueAt(Zmina, ii - 1, 1);
                            }
                            ii++;
                        }
                    }

                    ii = 1;
                    for (int f = 0; f < Person.size(); f++) {
                        if (getCategory() == 1) {
                            X = db.GetParam("SELECT ROUND(SUM(weightPerOne),3) From allWork WHERE personsName like '%" + Person.get(f) + "%'"
                                    + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        } else if (getCategory() == 2) {
                            X = db.GetParam("SELECT ROUND(SUM(SoldOut),3) From cashier WHERE pib like '%" + Person.get(f) + "%'"
                                    + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        }
                        while (X.next()) {
                            String weight = X.getString(1);
                            if (weight == null) {
                                dtm.setValueAt("0", ii - 1, 2);
                            } else {
                                dtm.setValueAt(weight, ii - 1, 2);
                            }

                            ii++;
                        }
                    }
                    ii = 1;
                    for (int f = 0; f < Person.size(); f++) {
                        if (getCategory() == 1) {
                            X = db.GetParam("SELECT ROUND(SUM(weightPerOne),3) FROM allWork WHERE personsName like '%" + Person.get(f) + "%' "
                                    + "AND date " + "BETWEEN" + "'" + date1 + "'" + " AND " + "'" + date2 + "'");
                            Intern = Internn.GetParam("SELECT Salary FROM Interns WHERE PIB like '%" + Person.get(f) + "%' "
                                    + "AND date " + "BETWEEN" + "'" + date1 + "'" + " AND " + "'" + date2 + "'");
                            Pay = a.GetParam("SELECT Payment FROM Payments WHERE PIB like '%" + Person.get(f) + "%' "
                                    + "AND date " + "BETWEEN" + "'" + date1 + "'" + " AND " + "'" + date2 + "'");
                        } else if (getCategory() == 2) {
                            X = db.GetParam("SELECT ROUND(SUM(Salary),3) FROM cashier WHERE PIB like '%" + Person.get(f) + "%' "
                                    + "AND date " + "BETWEEN" + "'" + date1 + "'" + " AND " + "'" + date2 + "'");
                            Pay = a.GetParam("SELECT Payment FROM Payments WHERE PIB like '%" + Person.get(f) + "%' "
                                    + "AND date " + "BETWEEN" + "'" + date1 + "'" + " AND " + "'" + date2 + "'");
                        }
                        double intern = 0;
                        double payP = 0;
                        if (Intern != null) {
                            while (Intern.next()) {
                                intern = intern + Double.parseDouble(Intern.getString(1));
                            }
                        }
                        if (Pay != null) {
                            while (Pay.next()) {
                                payP = payP + Double.parseDouble(Pay.getString(1));
                            }
                        }
                        while (X.next()) {

                            if (X.getString(1) != null) {
                                double weight = Double.parseDouble(X.getString(1));
                                if (getCategory() == 1) {
                                    weight = Double.parseDouble(X.getString(1)) * ValueKh;
                                    weight = (weight - intern) - payP;
                                    String formatD = new DecimalFormat("#0").format(weight);
                                    //JOptionPane.showMessageDialog(rootPane, formatD, "Помилка", 2);
                                    dtm.setValueAt(formatD, ii - 1, 3);
                                } else if (getCategory() == 2) {
                                    weight = weight - payP;
                                    String formatD = new DecimalFormat("#0").format(weight);
                                    dtm.setValueAt(formatD, ii - 1, 3);
                                }
                            }

                            ii++;
                        }
                    }

                    tbl.setModel(dtm);
                    tbl.getColumn("ПІБ").setCellRenderer(new myCellRenderer());
                    Person.clear();
                } catch (Exception ex) {
                    Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
                    //  txtRez.setText(ex.getMessage());
                }
                DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
                headerRenderer.setBackground(new Color(120, 101, 84));
                headerRenderer.setForeground(new Color(240, 219, 189));
                for (int v = 0; v < tbl.getModel().getColumnCount(); v++) {
                    tbl.getColumnModel().getColumn(v).setHeaderRenderer(headerRenderer);
                }
                a.finalize();
                db.finalize();
                Internn.finalize();
                dispose();
                FormMain.setDateRequest(0);
                btnExport.setVisible(true);
                pnlInfoZvit.setVisible(false);
                btnAdd.setEnabled(false);
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnBack.setVisible(true);
                txtSearch.setEnabled(false);
            } 
            //Інформація про працівника
            else if (FormMain.getRequestVariant() == 2) {
                String date1 = dateFormat.format(dateLast.getDate());
                String date2 = dateFormat.format(dateNow.getDate());
                int i = 0, ii = 1;
                try {

                    X = db.GetParam("SELECT idCategory FROM employees WHERE PIB  = '" + FormMain.getNameP() + "';");
                    while (X.next()) {
                        setCategory(Integer.parseInt(X.getString(1)));
                    }

                    if (getCategory() == 1) {
                        //JOptionPane.showMessageDialog(rootPane, "Робочий");
                    } else if (getCategory() == 2) {
                        //JOptionPane.showMessageDialog(rootPane, "Касир");
                    }

                    //Кількість змін
                    if (getCategory() == 1) {
                        X = db.GetParam("SELECT COUNT(*) as count From allWork WHERE personsName like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    } else if (getCategory() == 2) {
                        X = db.GetParam("SELECT COUNT(*) as count From cashier WHERE PIB = '" + FormMain.getNameP() + "'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    }

                    while (X.next()) {
                        setCountDay(X.getString(1));
                    }

                    //Кількість вироблених кг або зароблені гроші касира
                    if (getCategory() == 1) {
                        X = db.GetParam("SELECT SUM(weightPerOne) FROM allWork WHERE personsName like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    } else if (getCategory() == 2) {
                        X = db.GetParam("SELECT SUM(SoldOut) FROM cashier WHERE PIB = '" + FormMain.getNameP() + "'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    }

                    while (X.next()) {
                        setWeight(X.getString(1));
                    }

                    //Робочі дні
                    if (getCategory() == 1) {
                        X = db.GetParam("SELECT date From allWork WHERE personsName like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    } else if (getCategory() == 2) {
                        X = db.GetParam("SELECT date, SoldOut, salary From cashier WHERE PIB = '" + FormMain.getNameP() + "'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                    }

                    ResultSetMetaData colonki = X.getMetaData();
                    i = 3;
                    javax.swing.table.DefaultTableModel dtm = new javax.swing.table.DefaultTableModel();
                    dtm.setColumnCount(i);
                    String nazvaKolonki[] = new String[i];
                    if (getCategory() == 1) {
                        nazvaKolonki[0] = "Дата";
                        nazvaKolonki[1] = "Кілограми";
                        nazvaKolonki[2] = "Зарплата";
                    } else if (getCategory() == 2) {
                        nazvaKolonki[0] = "Дата";
                        nazvaKolonki[1] = "Сума продажу";
                        nazvaKolonki[2] = "Зарплата";
                    }

                    dtm.setColumnIdentifiers(nazvaKolonki);
                    dtm.setRowCount(0);//

                    if (getCategory() == 1) {
                        while (X.next()) {
                            dtm.setRowCount(dtm.getRowCount() + 1);
                            String Zmina = X.getString(1);
                            dtm.setValueAt(Zmina, ii - 1, 0);
                            ii++;
                        }
                    } else if (getCategory() == 2) {
                        double Salary = 0;

                        for (int q = 0; q < Integer.parseInt(getCountDay()); q++) {
                            while (X.next()) {
                                dtm.setRowCount(dtm.getRowCount() + 1);
                                String Zmina = X.getString(1);
                                String soldout = X.getString(2);
                                String sal = X.getString(3);
                                dtm.setValueAt(Zmina, ii - 1, 0);
                                dtm.setValueAt(soldout, ii - 1, 1);
                                String formatD = new DecimalFormat("#0.00").format(Double.parseDouble(sal));
                                dtm.setValueAt(formatD, ii - 1, 2);
                                Salary = Salary + Double.parseDouble(sal);
                                setSal(Salary + "");
                                ii++;
                            }
                        }
                        ii = 1;
                        Zp = Zpp.GetParam("SELECT payment From Payments WHERE PIB like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        while (Zp.next()) {
                            String Zmina = Zp.getString(1);
                            Salary = Salary - Double.parseDouble(Zmina);
                            setSal(Salary + "");

                            ii++;
                        }
                        
                    }

                    ii = 1;

                    //Вироблені кілограми або заробітна плата
                    if (getCategory() == 1) {
                        X = db.GetParam("SELECT weightPerOne From allWork WHERE personsName like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        for (int q = 0; q < Integer.parseInt(getCountDay()); q++) {
                            while (X.next()) {
                                String Zmina = X.getString(1);
                                dtm.setValueAt(Zmina, ii - 1, 1);
                                // double c = Double.parseDouble(X.getString(1));
                                String formatD = new DecimalFormat("#0.00").format(Double.parseDouble(Zmina) * ValueKh);
                                dtm.setValueAt(formatD.replace(",", "."), ii - 1, 2);

                                ii++;
                            }
                        }
                    } else if (getCategory() == 2) {

                    }
                    

                    i = 3;
                    javax.swing.table.DefaultTableModel dtm2 = new javax.swing.table.DefaultTableModel();
                    dtm2.setColumnCount(i);//
                    String nazvaKolonki2[] = new String[i];
                    nazvaKolonki2[0] = "Дата";
                    nazvaKolonki2[1] = "Тип";
                    nazvaKolonki2[2] = "Сума";
                    dtm2.setColumnIdentifiers(nazvaKolonki2);
                    dtm2.setRowCount(0);//
                    ii = 1;
                    P = PP.GetParam("SELECT date, categoryPayment, payment From Payments WHERE PIB like '%" + FormMain.getNameP() + "%'"
                            + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");

                    while (P.next()) {
                        dtm2.setRowCount(dtm2.getRowCount() + 1);
                        for (int j = 1; j <= i; j++) {
                            String Zmina = P.getString(j);
                            dtm2.setValueAt(Zmina, ii - 1, j - 1);

                        }
                        ii++;
                    }

                    if (getCategory() == 1) {
                        double Salary = Double.parseDouble(getWeight()) * ValueKh;
                        setSal(Salary + "");
                        ii = 1;
                        Zp = Zpp.GetParam("SELECT payment From Payments WHERE PIB like '%" + FormMain.getNameP() + "%'"
                                + " AND date " + "BETWEEN" + " '" + date1 + "'" + " AND " + "'" + date2 + "'");
                        while (Zp.next()) {
                            String Zmina = Zp.getString(1);
                            Salary = Salary - Double.parseDouble(Zmina);
                            setSal(Salary + "");

                            ii++;
                        }
                    } else if (getCategory() == 2) {
                        //JOptionPane.showMessageDialog(rootPane, "Касир");
                    }

                    FormInfoWorker f = new FormInfoWorker();
                    tblInfo.setModel(dtm);
                    tblInfoV.setModel(dtm2);
                    a.finalize();
                    db.finalize();
                    Internn.finalize();
                    PP.finalize();
                    Zpp.finalize();
                    dispose();
                    setWeight("");
                    f.setVisible(true);
                } catch (Exception ex) {

                }
            }
        } else if (dateLast.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Виберіть початкову дату", "Помилка", 2);
        } else if (dateNow.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Виберіть кінцеву дату", "Помилка", 2);
        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void lblExit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExit1MouseClicked
        dispose();
        FormMain.setDateRequest(0);
    }//GEN-LAST:event_lblExit1MouseClicked

    void getCalc() {
        DataBase DB = new DataBase();
        XS = DB.GetParam("SELECT name, value FROM setcalc");

        try {
            while (XS.next()) {
                if (XS.getString(1).equals("За кілограм")) {
                    ValueKh = Double.parseDouble(XS.getString(2));
                }
            }
            DB.finalize();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Проблемка");
        }
    }

    /**
     * Отримання даних
     * @param nameT Ім'я таблиці
     * @param date1 Дата початок
     * @param date2 Дата кінець
     */
    public void GetData(String nameT, String date1, String date2) {
        if (nameT == "allWork") {
            X = a.Request("date", "allWork", date1, date2);
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
        }
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(120, 101, 84));
        headerRenderer.setForeground(new Color(240, 219, 189));
        for (int i = 0; i < tbl.getModel().getColumnCount(); i++) {
            tbl.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
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
            java.util.logging.Logger.getLogger(FormDataRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private com.toedter.calendar.JDateChooser dateLast;
    private com.toedter.calendar.JDateChooser dateNow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblExit1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlHead;
    // End of variables declaration//GEN-END:variables
}