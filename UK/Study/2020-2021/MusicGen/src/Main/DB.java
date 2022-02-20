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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class DB {

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
     * @return the nameBranch
     */
    public String getNameBranch() {
        return nameBranch;
    }

    /**
     * @param nameBranch the nameBranch to set
     */
    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    /**
     * @return the idBranch
     */
    public int getIdBranch() {
        return idBranch;
    }

    /**
     * @param idBranch the idBranch to set
     */
    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    /**
     * @return the array
     */
    public static String[] getArray() {
        return array;
    }

    private String tbl = "users";
    private Statement s = null;
    Open o = new Open();
    private String addName = "";
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
     * ϳ���������
     *
     * @return conn �'�������
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

    @Override
    protected void finalize() {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    //��������
    public Statement getStatement() {
        try {
            return (Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet GetDataSet(String table) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            if(table=="Music")
            {
            Xrez = s.executeQuery("SELECT nameSound, author, mood, tags, link " + "FROM  " + table);
            }
            else
            {
                Xrez = s.executeQuery("SELECT name " + "FROM  " + table);
            }
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     * отримання повтору
     * @param table таблиця
     * @param param1 парамтер
     * @return 
     */
    public ResultSet GetR(String table, String param1) {
        // Connect();
        getCon();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            try {
                if (table == "users") {
                    Xrez = s.executeQuery("SELECT * FROM `" + table + "` "
                            + "WHERE `login` = '" + param1 + "';");
                } else if (table == "Music") {
                    Xrez = s.executeQuery("SELECT * FROM `" + table + "` "
                            + "WHERE `PIB` = '" + param1 + "';");
                } else if (table == "author") {
                    Xrez = s.executeQuery("SELECT * FROM `" + table + "` "
                            + "WHERE `login` =  '" + param1 + "';");

                } else if (table == "mood") {
                    Xrez = s.executeQuery("SELECT * FROM `" + table + "` "
                            + "WHERE `name` =  '" + param1 + "';");

                }
                while (Xrez.next()) {
                    String name = Xrez.getString(2);
                    Authorization.setNameRpt(name);
                }
            } catch (Exception ex) {

            }

            return Xrez;

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Реєстрація
     * @param nameTb таблиця 
     * @param pib піб
     * @param login логін 
     * @param pas пароль
     */
    public void Register(String nameTb, String pib, String login, String pas) {
        try {
            // Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTb + "` "
                    + "(`pib`, `login`, `pass`) "
                    + "VALUES (?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, pib);
            X.setString(2, login);
            X.setString(3, pas);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    /**
     * Авторизація
     * @param table таблиця
     * @param login логін 
     * @param pass пароль
     * @return 
     */
    public ResultSet GetUser(String table, String login, String pass) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT login, pass " + "FROM " + table + " WHERE `login` = '" + login + "' AND `pass` = '" + pass + "';");
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     * ПОШУК
     * @param table ТАБЛИЦЯ
     * @param txt ЩО ШУКАТИ
     * @return 
     */
    public ResultSet Search(String table, String txt) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            if(table=="Music")
            {
            Xrez = s.executeQuery("SELECT nameSound, author, mood, tags, link " + "FROM  " + table + " WHERE "
                    + " nameSound LIKE '%" + txt + "%' OR"
                    + " author LIKE '%" + txt + "%' OR"
                    + " mood LIKE '%" + txt + "%' OR"
                    + " tags LIKE '%" + txt + "%' OR"
                    + " link LIKE '%" + txt + "%';");
            }
            else
            {
                Xrez = s.executeQuery("SELECT name " + "FROM  " + table + " WHERE "
                    + " name LIKE '%" + txt+ "%';");
            }
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }

    /**
     *
     * @param code Код щоб не паритись
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
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }

    /**
     * Вставка в основну таблицю
     * @param nameTbl Ім'я таблиці
     * @param name назва
     * @param author автор
     * @param mood настрій 
     * @param tags теги 
     * @param link посилання
     */
    
    public void InsertData(String nameTbl, String name, String author, String mood, String tags, String link) {

        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`nameSound`,`author`,`mood`,`tags`,`link`) "
                    + "VALUES (?,?,?,?,?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, name);
            X.setString(2, author);
            X.setString(3, mood);
            X.setString(4, tags);
            X.setString(5, link);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    /**
     * Вставка автора
     * @param nameTbl Ім'я таблиці
     * @param name  значення
     */
    public void InsertAuthor(String nameTbl, String name) {

        try {
            //Connect();
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "INSERT INTO `" + nameTbl + "` "
                    + "(`name`) "
                    + "VALUES (?);";
            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, name);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }
    
    /**
     * Заповнення випадаючого списку
     *
     * @param code код
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
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }

    }
    
    /**
     *
     * @param Table таблиця
     * @param pole поле
     * @param name що видалити
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
     * @param nameTbl Ім'я таблиця
     * @param nameSound назва пісні
     * @param author автор
     * @param mood натстрій
     * @param tags теги
     * @param link посилання
     */

    public void Update(String nameTbl, String nameSound, String author, String mood, String tags, String link) {
        try {
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + "SET nameSound=?, author=?, mood=?, tags=?, link=? WHERE `nameSound` = '" + frmMain.getNameSound()+ "';";

            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, nameSound);
            X.setString(2, author);
            X.setString(3, mood);
            X.setString(4, tags);
            X.setString(5, link);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
    
    /**
     * Оновлення
     * @param nameTbl Ім'я таблиці
     * @param name значення 
     */
    public void UpdateAM(String nameTbl, String name) {
        try {
            getCon();
            String mySQLquery = "";
            mySQLquery
                    = "UPDATE `" + nameTbl + "` "
                    + "SET name=? WHERE `name` = '" + frmMain.getNameSound() + "';";

            PreparedStatement X = (PreparedStatement) conn.prepareStatement(mySQLquery);

            X.setString(1, name);
            X.execute();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
