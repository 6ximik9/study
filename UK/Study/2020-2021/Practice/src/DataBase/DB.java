/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

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
    
private String tbl="users";
private Statement s=null;
Open o = new Open();
private String addName = "������ ����";
public ArrayList<String> list = new ArrayList<>();
public static String[] array;
private int idBranch = 0;
private static String nameBranch="";
private static String namePerson="";
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
    private String server=o.getServer();
    private String port=o.getPort();
    private String user=o.getUser();
    private String pass=o.getPass();
    private String dbname=o.getDbname();
    private String charset="utf8";
    private String timezone="UTC";
    private String tbl_users="users";
    
    private Connection conn=null;
    /**
     * ϳ���������
     * @return conn �'�������
     */
    public Connection Connect(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(this.user);
        dataSource.setPassword(this.pass);
        dataSource.setServerName(this.server);     
        dataSource.setDatabaseName(this.dbname);
        dataSource.setPort(Integer.parseInt(this.port)); 
        try {
            dataSource.setServerTimezone(this.timezone);
        } catch (SQLException ex) {
            System.out.println("Err on setting Timezone :\n"+ex.toString());
        }
        try {
            dataSource.setCharacterEncoding(this.charset);
        } catch (SQLException ex) {
            System.out.println("Err on setting CP :\n"+ex.toString());
        }
        try {
            conn=dataSource.getConnection();
            return conn;
        } catch (SQLException ex) {
            conn=null;
            System.out.println("Err on getting connection :\n"+ex.toString());
        }
        return conn;
    }

    public Connection getCon(){
        if(this.conn!=null){
            return this.conn;
        }else{
            return Connect();
        }
    }   
    
    //��������
    
    public Statement getStatement(){
        try {
            return (Statement) conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     * // ����� ������� �� ������ � ������� � ������ �������� �����
     * @return rez ��������� ����� ��� �������
     */
    public String GetData() {
        String rez="�������!!!";
        int i;//������� �������
        try{
            if (s==null) {
                s = (Statement) conn.createStatement();
            }
            // ����� �� ��
            ResultSet r =null;
                  //r=s.executeQuery("SET NAMES utf8");
                  r=s.executeQuery(
                    "SELECT * " +
                    "FROM  " + tbl +" WHERE 1"
                  );
            ResultSetMetaData colonki =r.getMetaData();
            i=colonki.getColumnCount();//�-�� �������

            rez="";
            /*
            for (int j=1;j<=i;j++){
                rez+=colonki.getCatalogName(j)+" || ";
            }*/
            
            while(r.next()) {
                rez+="\n";
                for (int j=1;j<=i;j++){
                    rez+=r.getString(j)+" || ";
                }
            }
        }
        catch (Exception e)
        {
            return rez;
        }
        return rez;
    }
    /**
     * // ����� ������� �ᒺ�� ����� ����Ѳ� ���� ���i� ���� ����������� ��� ��������� � ������� �� ����
     * @param table ��'� �������
     * @return Xrez ���������
     */
    public ResultSet GetDataSet(String table){ 
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * " + "FROM  " + table);
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }
    /**
     * �����
     * @param table ��'� �������
     * @param nameColumn ��'� ���������
     * @param PIB �������
     * @return Xrez ���������
     */
    public ResultSet Search(String table, String nameColumn, String PIB){ // ����� �������
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * " + "FROM  " + table + " WHERE "+nameColumn+" LIKE '%"+PIB+"%'");
            setMySQL("SELECT * " + "FROM  " + table + " WHERE "+nameColumn+" LIKE '%"+PIB+"%'");
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
        
    }
    /**
     * ���������
     * @param pib �������
     * @param login ����
     * @param password ������
     */
    public void insert(String pib, String login, String password){
        try{
            Connect();
            String mySQLquery="";
                  mySQLquery=
                    "INSERT INTO `"+ tbl +"` " +
                    "(`PIB`, `login`, `password`) " +
                    "VALUES (?, ?, ?);"
                  ;                  
                PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                
                X.setString(1, pib);
                X.setString(2, login);
                X.setString(3, password);
            
            X.execute();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());   
        }
    }
    /**
     * ����������� �����������
     * @param pib �������
     * @param login ����
     * @param password ������
     * @param id ���
     * @param tblN �������
     */
    public void editUser(String pib, String login, String password, int id, String tblN){
        try{
            Connect();
            String mySQLquery="";
                  mySQLquery=
                        "UPDATE `"+ tblN +"` " +
                       " SET PIB=?, login=?, password=? WHERE id_user ="+id;
                      ; 
                PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                
                X.setString(1, pib);
                X.setString(2, login);
                X.setString(3, password);
            
            X.execute();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace());   
        }
    }
    /**
     * ���������
     * @param id ���
     * @param Table ��'� �������
     * @param nameID �� ��������
     */
    public void del(int id, String Table, String nameID){
        Connect();
        String mySQLquery="";
        try{                  
                  mySQLquery=
                    "DELETE FROM `"+ Table +"` " +
                    "WHERE `"+nameID+"`= " + id +";"
                  ;
            conn.prepareStatement(mySQLquery);                     
            PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
            X.execute();
        }
        catch (Exception e){
            System.out.println(e.fillInStackTrace()+"\n"+mySQLquery);
        }
    }
    
    @Override
    protected void finalize(){
        if (conn != null){
            try
            {
                conn.close ();
            }
            catch (Exception e) { }
        }
    }
    
    /**
     * ��������� ���������� ��� ������
     * @param nameRow ��'� ���������
     * @param nameTbl ��'� �������
     * @param txt �����
     * @return Xrez ���������
     */
    public ResultSet GetInfo(String nameRow, String nameTbl, String txt) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT "+nameRow+" From " +nameTbl+ " WHERE " + nameRow+ "=" + "'"+txt+"'");
            while(Xrez.next()){
               String name =  Xrez.getString(1);
               setAddName(name);
            }
            return Xrez;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
        
    }
    /**
     * �������� ���� �� ����
     * @param id ��� ����������
     * @return Xrez ���������
     */
     public ResultSet GetPhoto(int id) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT Photo"+" From personality"+ " WHERE id_person =" + id);
            while(Xrez.next()){
               String name =  Xrez.getString(1);
              photoPath = name;
            }
            return Xrez;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
     }
     /**
      * �������� ��� ����������
      * @param nameRow ��'� ���������
      * @param nameTbl ��'� ������� 
      * @param txt �����
      * @return Xrez ���������
      */
     public ResultSet Getid(String nameRow, String nameTbl, String txt) {// ����� ������� �� ������ � ������� � ������
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT *"+" From " +nameTbl+ " WHERE " + nameRow+ "=" + "'"+txt+"'");
            while(Xrez.next()){
               int id =  Xrez.getInt(1);
                setIdBranch(id);
            }
            return Xrez;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
        
}
    /**
     * �������� ����� �� ����
     * @param nameRow ��'� ���������
     * @param nameTbl ��'� �������
     * @param id ���
     * @param i ��������� �� ����������
     * @return Xrez ���������
     */
     
     public ResultSet GetNameid(String nameRow, String nameTbl, int id,int i) {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            if (i==0)
            {
            Xrez = s.executeQuery("SELECT *"+" From " +nameTbl+ " WHERE " + nameRow+ "=" + "'"+id+"'");
            while(Xrez.next()){
                String name =  Xrez.getString(2);
                nameBranch = name;
            }
            }
            else if (i==1)
            {
                Xrez = s.executeQuery("SELECT *"+" From " +nameTbl+ " WHERE " + nameRow+ "=" + "'"+id+"'");
                while(Xrez.next()){
                String name =  Xrez.getString(3);
                namePerson = name;
                System.out.println(getNamePerson());
             }
            }
            return Xrez;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
}
    
     /**
      * ����� ��� ���������� JComboBox
      * @param nameRow ��'� ���������
      * @param nameTbl ��'� �������
      * @param txt ����
      * @return Xrez ��������
      */
    public ResultSet GetInfoBox(String nameRow, String nameTbl, String txt){
        Connect();
        list.clear();
        array = null;
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT "+nameRow+" FROM " +nameTbl);
            while(Xrez.next()){
               String name =  Xrez.getString(1);
               
               list.add(name);
            }
            array = list.toArray(new String[0]);
            return Xrez;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
      
 }
    
    /**
     * �������� ��� � ������� ����� �� �������
     * @param nameTbl ��'� �������
     * @param txt  �����
     */
    public void MyInsert(String nameTbl, String txt){
        if(nameTbl=="branch")
        {
            try{
                Connect();
                String mySQLquery="";
                      mySQLquery=
                        "INSERT INTO `"+ nameTbl +"` " +
                        "(`name_branch`) " +
                        "VALUES (?);"
                      ;                  
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);

                    X.setString(1, txt);

                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
        else if(nameTbl=="categories_of_property")
        {
            try{
                Connect();
                String mySQLquery="";
                      mySQLquery=
                        "INSERT INTO `"+ nameTbl +"` " +
                        "(`name_property`) " +
                        "VALUES (?);"
                      ;                  
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);

                    X.setString(1, txt);

                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
        else if(nameTbl=="personality")
        {
            
        }
    }
    
    /**
     * �������� ��� ����������
     * @param nameTbl ��'� �������
     * @param branch ��'� �������
     * @param PIB �������
     * @param born ����������
     * @param dead ������
     * @param religion �����
     * @param education �����
     * @param biography ������� ��������������
     * @param Photo ����
     */
    public void personInsert(String nameTbl,String branch, String PIB,String born, String dead,String religion, String education,String biography, String Photo)
    {
    try{
                Connect();
                String mySQLquery="";
                      mySQLquery=
                        "INSERT INTO `"+ nameTbl +"` " +
                        "(`id_branch`,`PIB`,`born`,`dead`,`religion`,`education`,`short_biography`,`Photo`) " +
                        "VALUES (?,?,?,?,?,?,?,?);"
                      ;                  
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, branch);
                    X.setString(2, PIB);
                    X.setString(3, born);
                    X.setString(4, dead);
                    X.setString(5, religion);
                    X.setString(6, education);
                    X.setString(7, biography);
                    X.setString(8, Photo);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    /**
     * ��������� �����
     * @param nameTbl ��'� �������
     * @param branch ��'� �������
     * @param PIB �������
     * @param born ����������
     * @param dead ������
     * @param religion �����
     * @param education �����
     * @param biography ������� ��������������
     * @param Photo ����
     * @param idPerson ��� ������� ��� ��� �������� 
     */
     public void personUpdate(String nameTbl,String branch, String PIB,String born, String dead,String religion, String education,String biography, String Photo, int idPerson)
    {
    try{
                Connect();
                String mySQLquery="";
                      mySQLquery=
                        "UPDATE `"+ nameTbl +"` " +
                       " SET id_branch=?, PIB=?, born=?, dead=?, religion=?, education=?, short_biography=?, Photo=? WHERE id_person ="+idPerson;
                      ; 
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, branch);
                    X.setString(2, PIB);
                    X.setString(3, born);
                    X.setString(4, dead);
                    X.setString(5, religion);
                    X.setString(6, education);
                    X.setString(7, biography);
                    X.setString(8, Photo);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    
    
        /**
         * ������� �������
         * @param nameTbl ��'� �������
         * @param idPerson ��� �������
         * @param idProperty ��� �������
         * @param Year г� ���� �������
         * @param characteristic ������� ��������������
         */
    public void propertyInsert(String nameTbl,String idPerson, String idProperty, String Year,String characteristic)
    {
    try{
                Connect();
                String mySQLquery="";                 
                      
                      mySQLquery=
                        "INSERT INTO `"+ nameTbl +"` " +
                        "(`id_person`,`id_property`,`year`,`short_characteristic`) " +
                        "VALUES (?,?,?,?);"
                      ;   
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, idPerson);
                    X.setString(2, idProperty);
                    X.setString(3, Year);
                    X.setString(4, characteristic);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    /**
     * 
     * @param nameTbl ��'� �������
     * @param idPerson ��� �������
     * @param idProperty ��� �������
     * @param Year г� ���� �������
     * @param characteristic ������� ��������������
     * @param id ��� ��� ���� ��������
     */
    public void propertyUpdate(String nameTbl,String idPerson, String idProperty, String Year,String characteristic,int id)
    {
    try{
                Connect();
                String mySQLquery="";          
                      mySQLquery=
                        "UPDATE `"+ nameTbl +"` " +
                       " SET id_person=?, id_property=?, year=?, short_characteristic=? WHERE id_pro ="+id;
                      ; 
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, idPerson);
                    X.setString(2, idProperty);
                    X.setString(3, Year);
                    X.setString(4, characteristic);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    
    /**
     * ������� ��� � ������� ������ �� �������
     * @param nameTbl ��'� �������
     * @param name ���� ��'� 
     * @param id ��� ������
     */
    public void UpdateData(String nameTbl,String name, int id)
    {
        if(nameTbl=="branch")
        {
    try{
                Connect();
                String mySQLquery="";
                      mySQLquery="UPDATE "+nameTbl +" SET name_branch=? WHERE id_branch ="+id;
                      ;     
                      System.out.println(mySQLquery);
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, name);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    
    else
    {
        try{
                Connect();
                String mySQLquery="";
                      mySQLquery="UPDATE "+nameTbl +" SET name_property=? WHERE id_property ="+id;
                      ;     
                      System.out.println(mySQLquery);
                    PreparedStatement X=(PreparedStatement) conn.prepareStatement(mySQLquery);
                    
                    X.setString(1, name);
                X.execute();
            }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());   
            }
        }
    }
    /**
     * ����������
     * @param nameTbl ��'� �������
     * @param nameColumn ��'� �������
     * @param idSort ��� ����������
     * @param X ���� ��� ��������� �����
     * @return Xrez ��������� 
     */
    public ResultSet Sort(String nameTbl, String nameColumn, int idSort, String X)
    {
        if(idSort == 0)
        {
         Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * " + "FROM  " + nameTbl +" ORDER BY "+nameColumn);
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
    }   
        else if (idSort==1){
            Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery("SELECT * " + "FROM  " + nameTbl +" ORDER BY "+nameColumn + " DESC");
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
      }
        else if(idSort==2)
        {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery(X +" ORDER BY "+nameColumn);
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
        
        }
         else if(idSort==3)
        {
        Connect();
        ResultSet Xrez = null;
        try {
            if (s == null) {
                s = (Statement) conn.createStatement();
            }
            Xrez = s.executeQuery(X +" ORDER BY "+nameColumn + " DESC");
            return Xrez;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return Xrez;
        }
        
        }
        else{
        return null;
        }
    }
}


