package practic;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu start = new Menu();
        BankWork b = new BankWork();
        //Отримати шлях до файлу з БД
                    try {
                String s = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent(); 
                b.setS(s+"\\Data\\Banks.txt");
                start.setS(s+"\\Data\\Banks.txt");
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
        start.Interface();
        
    }
}
