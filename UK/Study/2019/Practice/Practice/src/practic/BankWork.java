/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;

public class BankWork {

    /**
     * @return the s
     */
    public String getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(String s) {
        this.s = s;
    }
    private String s;
    
    /**
     * @return the in
     */
    public Scanner getIn() {
        return in;
    }
    /**
     * @param in the in to set
     */
    public void setIn(Scanner in) {
        this.in = in;
    }
    /**
     * @return the bankGPS
     */
    public String getBankGPS() {
        return bankGPS;
    }
    /**
     * @param bankGPS the bankGPS to set
     */
    public void setBankGPS(String bankGPS) {
        this.bankGPS = bankGPS;
    }
    /**
     * @return the bankKontakt
     */
    public String getBankContacts() {
        return bankContacts;
    }
    /**
     * @param bankContacts the bankKontakt to set
     */
    public void setBankContacts(String Contacts) {
        this.bankContacts = Contacts;
    }
    /**
     * @return the bankBox
     */
    public String getBankBox() {
        return bankBox;
    }
    /**
     * @param bankBox the bankBox to set
     */
    public void setBankBox(String bankBox) {
        this.bankBox = bankBox;
    }
    /**
     * @return the bankGrap
     */
    public String getBankGrap() {
        return bankGrap;
    }
    /**
     * @param bankGrap the bankGrap to set
     */
    public void setBankGrap(String bankGrap) {
        this.bankGrap = bankGrap;
    }
    /**
     * @return the flag
     */
    public static boolean isFlag() {
        return flag;
    }
    /**
     * @param aFlag the flag to set
     */
    public static void setFlag(boolean aFlag) {
        flag = aFlag;
    }
    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }
    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    private Scanner in = new Scanner(System.in);
    private String bankName;
    private String bankGPS;
    private String bankContacts;
    private String bankBox;
    private String bankGrap;
    private static boolean flag;
    private File file;
    private  ArrayList<String> list;

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;

    }

    /**
     * Отримати інформацію про банки, або вони є або відсутні.
     */
    public void getInfo() throws FileNotFoundException, IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(getS()));
        int c =0;
        int s = 1;
        for (int i = 0; i < list.size() / 6; i++) {
            System.out.println(list.get(s));
            s += 6;
        }
        if(c==0)
        {
            System.out.println("Список банків порожній");
        }
    }

    /**
     * Пошук банку
     * @param find Назва банку
     * @throws IOException
     */
    public void Search(String find) throws IOException {
        int c = list.indexOf("Bank: " + find);
        File f = new File(getS());
        if (f.exists()&&c!=-1) {
            dia(c);
        } else {
            System.out.println("Банк відсутній");
        }
    }

    /**
     * Дія яка виконується після пошуку
     * @param ind Індекс банку
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void dia(int ind) throws FileNotFoundException, IOException {
        int c = 1;
        do {
            System.out.println("Виберіть дію");
            System.out.println("====================");
            System.out.println("1 Графік роботи");
            System.out.println("--------------------");
            System.out.println("2 Місце розташування");
            System.out.println("--------------------");
            System.out.println("3 Доступні банкомати");
            System.out.println("--------------------");
            System.out.println("4 Контакти");
            System.out.println("--------------------");
            System.out.println("0 Назад");
            System.out.println("====================");
            String d = getIn().nextLine();
            switch (d) {
                case "1": {
                    try {
                        showInfo(ind, 1);
                        System.out.println("====================");
                    } catch (IOException t) {

                    }
                    break;
                }
                case "2": {
                    showInfo(ind, 2);
                    System.out.println("====================");
                    break;
                }
                case "3": {
                    showInfo(ind, 3);
                    System.out.println("====================");
                    break;
                }
                case "4": {
                    showInfo(ind, 4);
                    System.out.println("====================");
                    break;
                }
                case "0": {
                    c = -1;
                    break;
                }
            }
        } while (c > 0);
    }

    /**
     * Додати новий банк, створює папку з інформацією про банк
     *
     * @throws IOException
     */
    public void addBank() throws IOException {

        try (FileWriter fw = new FileWriter(getS(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println("Bank: " + bankName);
            out.println("Work schedule: " + bankGrap);
            out.println("Location: " + bankGPS);
            out.println("Available ATMs: " + bankBox);
            out.println("Contacts: " + bankContacts);
            out.println("=========================================");
            System.out.println("Успішно створено");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        this.WriteCollections();
    }
    /**
     * Видалити банк
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void delete() throws FileNotFoundException, IOException {
        int c = list.indexOf("Bank: " + bankName);
        list.remove(c + 5);
        list.remove(c + 4);
        list.remove(c + 3);
        list.remove(c + 2);
        list.remove(c + 1);
        list.remove(c);
        FileWriter writer = new FileWriter(getS());
        for (String str : list) {
            writer.write(str + System.lineSeparator());
        }
        System.out.println("Успішно видалено");
        writer.close();
    }

    /**
     * Редагування даних
     * @param choice Вибір корисувача
     * @throws IOException 
     */
    public void edit(int choice) throws IOException {
        int x;
        String nm;

        int c = list.indexOf("Bank: " + getBankName());
        if (c != -1) {
            System.out.print("Введіть нову інформацію: ");
            switch (choice) {
                case 1:{
                    String name = in.nextLine();
                    int z = list.indexOf("Bank: " + name);
                    if (z == -1) {
                        list.set(c, "Bank: " + name);
                        break;
                    } else {
                         do{
                        System.out.println("Ім'я вже існує, повторіть спробу");
                        nm = in.nextLine();
                        x = list.indexOf("Bank: " + nm);
                         }
                         while(x!=-1);
                         list.set(c, "Bank: " + nm);
                        break;
                    }}
                case 2:
                    String graph = in.nextLine();
                    list.set(c + 1, "Work schedule: " + graph);
                    break;
                case 3:
                    String gps = in.nextLine();
                    list.set(c + 2, "Location: " + gps);
                    break;
                case 4:
                    String box = in.nextLine();
                    list.set(c + 3, "Available ATMs: " + box);
                    break;
                case 5:
                    String con = in.nextLine();
                    list.set(c + 4, "Contacts: " + con);
                    break;
            }
        } else {
            System.out.println("Банка не існує, можливо ви вже його перейменували!\nВведіть нову назву");
        }
        FileWriter writer = new FileWriter(getS());
        for (String str : list) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
        System.out.println("Успішно змінено");

    }

    /**
     * Загрузити інформацію в колекцію
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void WriteCollections() throws FileNotFoundException, IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(s));
        list = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            list.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
    }
    
    /**
     * Відобразити необхідну інформацію
     * @param index Індекс банку
     * @param dia Дія яка виконується
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void showInfo(int index, int dia) throws FileNotFoundException, IOException {
            System.out.println(list.get(index + dia));
    }
    
}
