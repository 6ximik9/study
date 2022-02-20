/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class DataB {

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
    Settings o = new Settings();
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

    //Вкрадене
    public Statement getStatement() {
        try {
            return (Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
            if (table == "Door") {
                Xrez = s.executeQuery("SELECT name, appointment, type, style, coating, size, material " + "FROM  " + table + " ORDER BY name ASC");
            } else {
                Xrez = s.executeQuery("SELECT name " + "FROM  " + table + " ORDER BY name ASC");
            }
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
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
            if(table=="Door")
            {
            Xrez = s.executeQuery("SELECT name, appointment, type, style, coating, size, material " + "FROM " + table + " WHERE name LIKE '%" + name + "%' "
                    + " OR appointment LIKE '%" + name + "%'"
                    + " OR type LIKE '%" + name + "%'"
                    + " OR style LIKE '%" + name + "%'"
                    + " OR coating LIKE '%" + name + "%'"
                    + " OR size LIKE '%" + name + "%'"
                    + " OR material LIKE '%" + name + "%'"
                    + "ORDER BY name ASC;");
            }
            else
            {
            Xrez = s.executeQuery("SELECT name " + "FROM " + table + " WHERE name LIKE '%" + name + "%' "
                    
                    + "ORDER BY name ASC;");
            }
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     *
     * @param nameTbl ім'я таблиці
     * @param name ім'я дверей
     * @param appoint призначення
     * @param type тип
     * @param style стиль
     * @param coating покриття
     * @param size розміп
     * @param materia матеріал
     */
    public void InsertData(String nameTbl, String name, String appoint, String type, String style, String coating, String size, String materia) {

        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`name`,`appointment`,`type`,`style`,`coating`,`size`,`material`) "
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, name);
            X.setString(2, appoint);
            X.setString(3, type);
            X.setString(4, style);
            X.setString(5, coating);
            X.setString(6, size);
            X.setString(7, materia);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    /**
     * Видалення
     *
     * @param id Код
     * @param Table Ім'я таблиці
     * @param nameID Що видалити
     */
    public void del(String Table, String pole, String name) {
        // Connect();
        getCon();
        String mySQLquery = "";
        try {
            mySQLquery
                    = "DELETE FROM `" + Table + "` "
                    + "WHERE `" + pole + "`= '" + name + "';";
            conn.prepareStatement(mySQLquery);
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace() + "\n" + mySQLquery);
        }
    }

    /**
     *
     * @param nameTbl ім'я таблиці
     * @param name ім'я дверей
     * @param appoint призначення
     * @param type тип
     * @param style стиль
     * @param coating покриття
     * @param size розміп
     * @param materia матеріал
     */
    public void Update(String nameTbl, String name, String appoint, String type, String style, String coating, String size, String materia) {
        try {
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + "SET name=?, appointment=?, type=?, style=?, coating=?, size=?, material=? WHERE `name` = '" + frmShow.getNames() + "';";

            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, name);
            X.setString(2, appoint);
            X.setString(3, type);
            X.setString(4, style);
            X.setString(5, coating);
            X.setString(6, size);
            X.setString(7, materia);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Отримання інфи для заповнення випадаючого списку
     *
     * @param code Текстовий запит
     * @return
     */
    public ResultSet GetParam(String code) {
        //Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                try {
                    s = (Statement) conn.createStatement();
                } catch (Exception ex) {
                }
            }
            Xrez = s.executeQuery(code);

            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     *
     * @param code Повернення повтору
     * @return
     */
    public ResultSet GetInd(String code) {
        // Connect();
        getCon();
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
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Отримання повторі
     *
     * @param nameCol ім'я стовпця
     * @param value значення
     * @param table таблиця
     * @return
     */
    public ResultSet GetRep(String nameCol, String value, String table) {
        // Connect();
        getCon();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT " + nameCol + " FROM  " + table + " WHERE " + nameCol + " = '" + value + "'");
            while (Xrez.next()) {
                String name = Xrez.getString(1);
                setAddName(name);
            }
            return Xrez;

        } catch (SQLException ex) {
            Logger.getLogger(DataB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Вставка фільтрів
     *
     * @param table таблиця
     * @param nameCol ім'я стовпя
     * @param value значення
     */
    public void InsertDataFilter(String table, String nameCol, String value) {

        try {
            //Connect();
            getCon();
            String mySQLquery = "";

            mySQLquery
                    = "INSERT INTO `" + table + "` "
                    + "(`" + nameCol + "`) "
                    + "VALUES (?);";

            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, value);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    /**
     * Оновлення фільтра
     *
     * @param table таблиця
     * @param nameCol ім'я стовпця
     * @param value значення
     */
    public void UpdateFilter(String table, String nameCol, String value) {
        try {
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + table + "` "
                    + "SET name=? WHERE `name` = '" + frmShow.getNames() + "';";

            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, value);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
