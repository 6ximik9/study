package Main;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ximik
 */
public class DataBase {

    /**
     * @return the photo
     */
    public static String getPhotoPatn() {
        return photoPath;
    }

    /**
     * @param aMySQL the MySQL to set
     */
    public static void setMySQL(String aMySQL) {
        MySQL = aMySQL;
    }

    /**
     * @return the MySQL
     */
    public static String getMySQL() {
        return MySQL;
    }

    /**
     * @return the namePerson
     */
    public static String getNamePerson() {
        return namePerson;
    }

    /**
     * @param aNamePerson the namePerson to set
     */
    public static void setNamePerson(String aNamePerson) {
        namePerson = aNamePerson;
    }

    /**
     * @return the array
     */
    public static String[] getArray() {
        return array;
    }

    private String tbl = "users";
    private Statement s = null;
    FormSettingsConnect o = new FormSettingsConnect();
    private String addName = "Такого нема";
    public ArrayList<String> list = new ArrayList<>();
    public static String[] array;
    private int idBranch = 0;
    private static String nameBranch = "";
    private static String namePerson = "";
    private static String MySQL = "";
    private static String photoPath = "";

    /**
     * @return the addName
     */
    public String getAddName() {
        return addName;
    }

    /**
     * @param addName the addName to set
     */
    public void setAddName(String addName) {
        this.addName = addName;
    }

    /**
     * @return the tbl_users
     */
    public String getTbl_users() {
        return tbl_users;
    }
    private String server = o.getServer();
    private String port = o.getPort();
    private String user = o.getUser();
    private String pass = o.getPass();
    private String dbname = o.getDbname();
    private String charset = "utf8";
    private String timezone = "UTC";
    private String tbl_users = "users";

    private Connection conn = null;

    /**
     * Підключення
     *
     * @return conn З'єднання
     */
    public Connection Connect() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(this.user);
        dataSource.setPassword(this.pass);
        dataSource.setServerName(this.server);
        dataSource.setDatabaseName(this.dbname);
        dataSource.setPort(Integer.parseInt(this.port));
        try {
            dataSource.setServerTimezone(this.timezone);
        } catch (SQLException ex) {
            System.out.println("Err on setting Timezone :\n" + ex.toString());
        }
        try {
            dataSource.setCharacterEncoding(this.charset);
        } catch (SQLException ex) {
            System.out.println("Err on setting CP :\n" + ex.toString());
        }
        try {
            conn = dataSource.getConnection();
            return conn;
        } catch (SQLException ex) {
            conn = null;
            System.out.println("Err on getting connection :\n" + ex.toString());
        }
        return conn;
    }

    public Connection getCon() {
        if (this.conn != null) {
            return this.conn;
        } else {
            return Connect();
        }
    }

    public Statement getStatement() {
        try {
            return (Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * // метод повертає всі записи з таблиці у вигляді великого рядка
     *
     * @return rez Результат даних для таблиці
     */
    public String GetData() {
        String rez = "Помилка!!!";
        int i;//кількість колонок
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            // запит до БД
            ResultSet r = null;
            //r=s.executeQuery("SET NAMES utf8");
            r = s.executeQuery(
                    "SELECT * "
                    + "FROM  " + tbl + " WHERE 1"
            );
            ResultSetMetaData colonki = r.getMetaData();
            i = colonki.getColumnCount();//к-ть колонок

            rez = "";
            /*
            for (int j=1;j<=i;j++){
                rez+=colonki.getCatalogName(j)+" || ";
            }*/

            while (r.next()) {
                rez += "\n";
                for (int j = 1; j <= i; j++) {
                    rez += r.getString(j) + " || ";
                }
            }
        } catch (Exception e) {
            return rez;
        }
        return rez;
    }

    /**
     * // метод поверне об’єкт НАБІР ЗАПИСІВ який потiм буде використано для
     * виведення в таблицю на формі
     *
     * @param table Ім'я таблиці
     * @return Xrez Результат
     */
    public ResultSet GetDataSet(String table) {
        getCon();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }

            if (table == "allWork") {
                Xrez = s.executeQuery("SELECT date, countPerson, personsName, weightPerOne, weightProduced " + "FROM  " + table + " ORDER BY date DESC;");
            } else if (table == "employees") {
                Xrez = s.executeQuery("SELECT PIB, idCategory " + "FROM  " + table + " ORDER BY PIB ASC;");
            } else if (table == "Interns") {
                Xrez = s.executeQuery("SELECT PIB, date, type, Salary " + "FROM  " + table + " ORDER BY date DESC;");
            } else if (table == "cashier") {
                Xrez = s.executeQuery("SELECT PIB, date, SoldOut, Salary " + "FROM  " + table + " ORDER BY date DESC;");
            } else if (table == "Payments") {
                Xrez = s.executeQuery("SELECT PIB, date, categoryPayment, Payment " + "FROM  " + table + " ORDER BY date DESC;");
            }

            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     * Повертає набір записів з таблиці
     *
     * @param table Ім'я таблиці
     * @return
     */
    public ResultSet GetDataP(String table) {
        // Connect();
        getCon();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT PIB, id " + "FROM  " + table);
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     * Пошук
     *
     * @param table Ім'я таблиці
     * @param nameColumn Ім'я стовпчика
     * @param PIB Ініціали
     * @return Xrez Результат
     */
    public ResultSet Search(String table, String nameColumn, String PIB) { // метод зпошуку
        //Connect();
        getCon();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * " + "FROM  " + table + " WHERE " + nameColumn + " LIKE '%" + PIB + "%'");
            setMySQL("SELECT * " + "FROM  " + table + " WHERE " + nameColumn + " LIKE '%" + PIB + "%'");
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Додавання працівника
     *
     * @param pib Ініціали
     * @param login Логін
     * @param password Пароль
     */
    public void insert(String pib, String nameTb, String category) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTb + "` "
                    + "(`PIB`, `idCategory`) "
                    + "VALUES (?, ?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, pib);
            X.setString(2, category);

            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Вставка категорії
     *
     * @param nameCat Ім'я категорії
     * @param nameTb Ім'я таблиці
     */
    public void insertCat(String nameCat, String nameTb) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTb + "` "
                    + "(`nameCategory`) "
                    + "VALUES (?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, nameCat);

            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Отримання інформації про повтор
     *
     * @param nameRow Ім'я стовпчика
     * @param nameTbl Ім'я таблиці
     * @param txt Текст
     * @return Xrez Результат
     */
    public ResultSet GetInd(String code) {
        // Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery(code);
            while (Xrez.next()) {
                String name = Xrez.getString(1);
                setAddName(name);
            }
            return Xrez;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Видалення
     *
     * @param table Таблиця
     * @param param1 Параметр 1
     * @param param2 Параметр 2
     * @param param3 Параметр 3
     * @param param4 Параметр 4
     * @param param5 Параметр 5
     */
    public void del(String table, String param1, String param2, String param3, String param4, String param5) {
        // Connect();
        getCon();
        String mySQLquery = "";
        try {
            if (table == "allWork") {
                mySQLquery
                        = "DELETE FROM `" + table + "` "
                        + "WHERE `date` = '" + param1 + "' AND `countPerson` =  '" + param2 + "' AND `personsName` = '" + param3
                        + "' AND `weightPerOne` = '" + param4 + "' AND `weightProduced` = '" + param5 + "';";
            } else if (table == "employees") {
                mySQLquery
                        = "DELETE FROM `" + table + "` "
                        + "WHERE `PIB` = '" + param1 + "';";
            } else if (table == "Interns") {
                mySQLquery
                        = "DELETE FROM `" + table + "` "
                        + "WHERE `PIB` = '" + param1 + "' AND `date` =  '" + param2 + "' AND `type` = '" + param3
                        + "' AND `Salary` = '" + param4 + "';";

            } else if (table == "cashier") {
                mySQLquery
                        = "DELETE FROM `" + table + "` "
                        + "WHERE `PIB` = '" + param1 + "' AND `date` =  '" + param2 + "' AND `SoldOut` = '" + param3
                        + "' AND `Salary` = '" + param4 + "';";

            } else if (table == "Payments") {
                mySQLquery
                        = "DELETE FROM `" + table + "` "
                        + "WHERE `PIB` = '" + param1 + "' AND `date` =  '" + param2 + "' AND `categoryPayment` = '" + param3
                        + "' AND `Payment` = '" + param4 + "';";
            }

            conn.prepareStatement(mySQLquery);
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace() + "\n" + mySQLquery);
        }
    }

    @Override
    protected void finalize() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * Метод для заповнення
     *
     * @param nameRow Ім'я стовпчика
     * @param nameTbl Ім'я таблиці
     * @param Cat Текс
     * @return Xrez Реультат
     */
    public ResultSet GetInfoBox(String nameRow, String nameTbl, String Cat) {
        // Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT " + nameRow + " FROM " + nameTbl + " WHERE `idCategory` = " + Cat);
            while (Xrez.next()) {
                String name = Xrez.getString(1);
                list.add(name);
            }
            array = list.toArray(new String[0]);
            return Xrez;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Метод для заповнення
     *
     * @param nameRow Ім'я стовпчика
     * @param nameTbl Ім'я таблиці
     * @return Xrez Реультат
     */
    public ResultSet GetInfoBoxAll(String nameRow, String nameTbl) {
        // Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT " + nameRow + " FROM " + nameTbl);
            while (Xrez.next()) {
                String name = Xrez.getString(1);
                list.add(name);
            }
            array = list.toArray(new String[0]);
            return Xrez;

        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    public ResultSet Request(String nameCol, String nameTbl, String param1, String param2) {
        // Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * FROM " + nameTbl + " WHERE " + nameCol + " BETWEEN "
                    + "'" + param1 + "'" + " AND " + "'" + param2 + "'");

            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    public ResultSet GetParam(String code) {
        //Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery(code);

            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Вставка даних
     *
     * @param nameTbl Ім'я таблиці
     * @param data Дата
     * @param countPerson Кількість персон
     * @param PersonName ПІБ Персон
     * @param OneW Кілограми на одного
     * @param AllW Всього
     */
    public void MyInsert(String nameTbl, String data, int countPerson, String PersonName, double OneW, double AllW) {
        if (nameTbl == "allWork") {
            try {
                //Connect();
                getCon();
                String mySQLquery = "";
                mySQLquery
                        = "INSERT INTO `" + nameTbl + "` "
                        + "(`date`,`countPerson`,`personsName`,`weightPerOne`,`weightProduced`) "
                        + "VALUES (?,?,?,?,?);";
                PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

                X.setString(1, data);
                X.setString(2, countPerson + "");
                X.setString(3, PersonName);
                X.setString(4, OneW + "");
                X.setString(5, AllW + "");
                X.execute();
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
            }
        }

    }

    /**
     * Вставка даних каса
     *
     * @param nameTbl Ім'я таблиці
     * @param PIB ПІБ
     * @param data Дата
     * @param SoldOut Продано
     * @param salary Заробіток
     */
    public void MyInsertCasa(String nameTbl, String PIB, String data, double SoldOut, double salary) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`PIB`,`date`,`SoldOut`,`Salary`) "
                    + "VALUES (?,?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, SoldOut + "");
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Оновлення каса
     *
     * @param nameTbl Ім'я таблиці
     * @param PIB ПІБ
     * @param data Дата
     * @param SoldOut Продано
     * @param salary Заробіток
     * @param id Ід запису
     */
    public void MyUpdateCasa(String nameTbl, String PIB, String data, double SoldOut, double salary, String id) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + " SET PIB=?, date=?, SoldOut=?, Salary=? WHERE id =" + id;
            ;
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, SoldOut + "");
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Вставка інтернів
     *
     * @param nameTbl Ім'я таблиці
     * @param PIB ПІБ
     * @param data Дата
     * @param type Тип
     * @param salary Заробітна плата
     */
    public void MyInsertInter(String nameTbl, String PIB, String data, String type, double salary) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`PIB`,`date`,`type`,`Salary`) "
                    + "VALUES (?,?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, type);
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Онволення інтерна
     *
     * @param nameTbl Ім'я таблиці
     * @param PIB Піб
     * @param data Дата
     * @param type Тип
     * @param salary Заробіна плата
     * @param id ІД
     */
    public void MyUpdateInter(String nameTbl, String PIB, String data, String type, double salary, String id) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + " SET PIB=?, date=?, type=?, Salary=? WHERE id = " + id;
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, type);
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Оновлення
     *
     * @param nameTbl Ім'я таблиці
     * @param Date Дата
     * @param countPerson Кількість персон
     * @param PersonName ПІБ
     * @param OneW Кг одного
     * @param AllW всього кг
     * @param id Ід
     */
    public void Update(String nameTbl, String Date, int countPerson, String PersonName, double OneW, double AllW, String id) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + " SET date=?, countPerson=?, personsName=?, weightPerOne=?, weightProduced=? WHERE id =" + id;
            ;
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, Date);
            X.setString(2, countPerson + "");
            X.setString(3, PersonName);
            X.setString(4, OneW + "");
            X.setString(5, AllW + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Оновлення 
     * @param pib ПІБ
     * @param nameTb Ім'я таблиці
     * @param category категорія
     * @param id код
     */
    public void UpdatePerson(String pib, String nameTb, String category, String id) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTb + "` "
                    + " SET PIB=?, idCategory=? WHERE id =" + id;
            ;
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, pib);
            X.setString(2, category);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Виплати
     * @param nameTbl Ім'я таблиці 
     * @param PIB Піб
     * @param data Дата
     * @param type Тип
     * @param salary Заробіна плата
     */
    
    public void MyInsertPayment(String nameTbl, String PIB, String data, String type, double salary) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`PIB`,`date`,`categoryPayment`,`Payment`) "
                    + "VALUES (?,?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, type);
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * 
     * Виплати оновлення
     * @param nameTbl Ім'я таблиці 
     * @param PIB Піб
     * @param data Дата
     * @param type Тип
     * @param salary Заробіна плата
     * @param id  Код
     */
    public void MyUpdatePayment(String nameTbl, String PIB, String data, String type, double salary, String id) {
        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + "SET PIB=?, date=?, categoryPayment=?, Payment=? WHERE id = " + id
                    + ";";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, PIB);
            X.setString(2, data);
            X.setString(3, type);
            X.setString(4, salary + "");
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Зиіна розрахувань
     * @param nameTbl Ім'я таблиці
     * @param name Ім'я зміни
     * @param value Значення
     */
    public void MyUpdateCalc(String nameTbl, String name, String value) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + " SET value=? WHERE name = '" + name + "'";
            ;
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, value);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Пошук
     *
     * @param table ім'я тамблиці
     * @param name що шукати
     * @return
     */
    public ResultSet Search(String table, String name) {
        getCon();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            if (table == "allWork") {
                Xrez = s.executeQuery("SELECT * " + "FROM " + table + " WHERE "
                        + " date LIKE '%" + name + "%' OR"
                        + " countPerson LIKE '%" + name + "%' OR"
                        + " personsName LIKE '%" + name + "%' OR"
                        + " weightPerOne LIKE '%" + name + "%' OR"
                        + " weightProduced LIKE '%" + name + "%'"
                        + " ORDER BY date DESC;");

            } else if (table == "employees") {
                Xrez = s.executeQuery("SELECT * " + "FROM " + table + " WHERE "
                        + " PIB LIKE '%" + name + "%' OR"
                        + " countPerson LIKE '%" + name + "%' OR"
                        + " personsName LIKE '%" + name + "%' OR"
                        + " weightPerOne LIKE '%" + name + "%' OR"
                        + " weightProduced LIKE '%" + name + "%'"
                        + " ORDER BY PIB DESC;");
            } else if (table == "Interns") {
                Xrez = s.executeQuery("SELECT * " + "FROM " + table + " WHERE "
                        + " date LIKE '%" + name + "%' OR"
                        + " type LIKE '%" + name + "%' OR"
                        + " salary LIKE '%" + name + "%'"
                        + " ORDER BY date DESC;");

            } else if (table == "cashier") {
                Xrez = s.executeQuery("SELECT * " + "FROM " + table + " WHERE "
                        + " PIB LIKE '%" + name + "%' OR"
                        + " date LIKE '%" + name + "%' OR"
                        + " SoldOut LIKE '%" + name + "%' OR"
                        + " Salary LIKE '%" + name + "%'"
                        + " ORDER BY date DESC;");

            } else if (table == "Payments") {
                Xrez = s.executeQuery("SELECT * " + "FROM " + table + " WHERE "
                        + " PIB LIKE '%" + name + "%' OR"
                        + " date LIKE '%" + name + "%' OR"
                        + " categoryPayment LIKE '%" + name + "%' OR"
                        + " Payment LIKE '%" + name + "%' "
                        + " ORDER BY PIB DESC;");

            }
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }
}
