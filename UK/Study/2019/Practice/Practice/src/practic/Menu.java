/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 7heXiMiK
 */
public class Menu {

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
    //Змінна шляху
    private String s;
    /**
     * Меню програми
     * @throws IOException 
     */
    public void Interface() throws IOException {
        BankWork bank = new BankWork();
        bank.setS(this.s);
        bank.WriteCollections();
        Scanner in = new Scanner(System.in);
        System.out.print("Вітаю, програма готова до роботи\nВиберіть необхідну дію\n");
        int k = 1;
        do {
            System.out.println("===============================");
            System.out.println("1 Переглянути список банків");
            System.out.println("-------------------------------");
            System.out.println("2 Знайти банк за іменем");
            System.out.println("-------------------------------");
            System.out.println("3 Додати новий банк");
            System.out.println("-------------------------------");
            System.out.println("4 Видалити банк");
            System.out.println("-------------------------------");
            System.out.println("5 Змінити інформацію про банк");
            System.out.println("-------------------------------");
            System.out.println("0 Вихід");
            System.out.println("===============================");
            String c = in.nextLine();
            switch (c) {
                case "1": {
                    System.out.println("Доступні банки");
                    System.out.println("++++++++++++++++");
                    bank.getInfo();
                    System.out.println("++++++++++++++++");
                    break;
                }
                case "2": {
                    System.out.print("Ім'я банку: ");
                    String name = in.nextLine();
                    if (name.trim().length() != 0) {
                        bank.Search(name);
                    } else {
                        System.out.println("Введіть ім'я банку");
                    }
                    break;
                }
                case "3": {
                    System.out.print("Введіть ім'я банку: ");
                    String name = in.nextLine();
                    BufferedReader bufReader = new BufferedReader(new FileReader(getS()));
                    ArrayList<String> list = new ArrayList<>();
                    String line = bufReader.readLine();
                    while (line != null) {
                        list.add(line);
                        line = bufReader.readLine();
                    }
                    bufReader.close();

                    int j = list.lastIndexOf("Bank: " + name);
                    if (j != -1) {
                        System.out.println("Такий банк вже існує");
                        break;
                    } else {
                        bank.setBankName(name);
                        System.out.print("Введіть місцезнаходження банку: ");
                        String gps = in.nextLine();
                        bank.setBankGPS(gps);
                        System.out.print("Введіть доступні банкомати: ");
                        String Box = in.nextLine();
                        bank.setBankBox(Box);
                        System.out.print("Введіть графік роботи: ");
                        String Graph = in.nextLine();
                        bank.setBankGrap(Graph);
                        System.out.print("Введіть контакти: ");
                        String Contacts = in.nextLine();
                        bank.setBankContacts(Contacts);
                        bank.addBank();
                        break;
                    }
                }
                case "4": {
                    System.out.print("Введіть назву банку для видалення: ");
                    String name = in.nextLine();
                    bank.setBankName(name);
                    bank.delete();
                    break;
                }
                case "5": {
                    System.out.print("Введіть назву банку для редагування: ");
                    String name = in.nextLine();
                    BufferedReader bufReader = new BufferedReader(new FileReader(getS()));
                    ArrayList<String> list = new ArrayList<>();
                    String line = bufReader.readLine();
                    while (line != null) {
                        list.add(line);
                        line = bufReader.readLine();
                    }
                    bufReader.close();

                    int j = list.lastIndexOf("Bank: " + name);
                    if (j == -1) {
                        System.out.println("Банка не існує");
                        break;
                    } else {
                        bank.setBankName(name);
                        System.out.println("Що ви хочете змінити");
                        System.out.println("1 Назву банка");
                        System.out.println("2 Графік роботи");
                        System.out.println("3 Місце розташування");
                        System.out.println("4 Доступні банкомати");
                        System.out.println("5 Контакти");
                        System.out.println("0 Назад");
                        String info = in.nextLine();
                        switch (info) {
                            case "1": {
                                bank.edit(1);
                                break;
                            }
                            case "2": {
                                bank.edit(2);
                                break;
                            }
                            case "3": {
                                bank.edit(3);
                                break;
                            }
                            case "4": {
                                bank.edit(4);
                                break;
                            }
                            case "5": {
                                bank.edit(5);
                                break;
                            }
                            case "0": {
                                
                                break;
                            }
                        }

                    }
                    break;
                }
                case "0": {
                    System.exit(0);
                    break;
                }
            }
        } while (k > 0);
    }
}
