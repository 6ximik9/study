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
    //����� �����
    private String s;
    /**
     * ���� ��������
     * @throws IOException 
     */
    public void Interface() throws IOException {
        BankWork bank = new BankWork();
        bank.setS(this.s);
        bank.WriteCollections();
        Scanner in = new Scanner(System.in);
        System.out.print("³���, �������� ������ �� ������\n������� ��������� ��\n");
        int k = 1;
        do {
            System.out.println("===============================");
            System.out.println("1 ����������� ������ �����");
            System.out.println("-------------------------------");
            System.out.println("2 ������ ���� �� ������");
            System.out.println("-------------------------------");
            System.out.println("3 ������ ����� ����");
            System.out.println("-------------------------------");
            System.out.println("4 �������� ����");
            System.out.println("-------------------------------");
            System.out.println("5 ������ ���������� ��� ����");
            System.out.println("-------------------------------");
            System.out.println("0 �����");
            System.out.println("===============================");
            String c = in.nextLine();
            switch (c) {
                case "1": {
                    System.out.println("������� �����");
                    System.out.println("++++++++++++++++");
                    bank.getInfo();
                    System.out.println("++++++++++++++++");
                    break;
                }
                case "2": {
                    System.out.print("��'� �����: ");
                    String name = in.nextLine();
                    if (name.trim().length() != 0) {
                        bank.Search(name);
                    } else {
                        System.out.println("������ ��'� �����");
                    }
                    break;
                }
                case "3": {
                    System.out.print("������ ��'� �����: ");
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
                        System.out.println("����� ���� ��� ����");
                        break;
                    } else {
                        bank.setBankName(name);
                        System.out.print("������ ��������������� �����: ");
                        String gps = in.nextLine();
                        bank.setBankGPS(gps);
                        System.out.print("������ ������� ���������: ");
                        String Box = in.nextLine();
                        bank.setBankBox(Box);
                        System.out.print("������ ������ ������: ");
                        String Graph = in.nextLine();
                        bank.setBankGrap(Graph);
                        System.out.print("������ ��������: ");
                        String Contacts = in.nextLine();
                        bank.setBankContacts(Contacts);
                        bank.addBank();
                        break;
                    }
                }
                case "4": {
                    System.out.print("������ ����� ����� ��� ���������: ");
                    String name = in.nextLine();
                    bank.setBankName(name);
                    bank.delete();
                    break;
                }
                case "5": {
                    System.out.print("������ ����� ����� ��� �����������: ");
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
                        System.out.println("����� �� ����");
                        break;
                    } else {
                        bank.setBankName(name);
                        System.out.println("�� �� ������ ������");
                        System.out.println("1 ����� �����");
                        System.out.println("2 ������ ������");
                        System.out.println("3 ̳��� ������������");
                        System.out.println("4 ������� ���������");
                        System.out.println("5 ��������");
                        System.out.println("0 �����");
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
