package org.example.Interface;

import java.awt.*;
import java.util.Scanner;

public class Terminal {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    private static Scanner scanner = new Scanner(System.in);
    public static void chooseServerClient(){
        parsers2();
        System.out.println(GREEN + "            Добро пожаловать!");
        System.out.println(GREEN + "     Выберите действия:");
        System.out.println(GREEN + "       "+YELLOW+"1 "+CYAN+"Server "+GREEN+"- Создать сервер");
        System.out.println(GREEN + "       "+YELLOW+"2 "+CYAN+"Client "+GREEN+"- Подключиться к серверу");
        parsers2();
        System.out.print("     Ваш Выбор:");
    }
    public static void clientAuthorization(){

        parsers();
        System.out.println(GREEN + "   Введите Параметры для подключения:");
        parsers();
    }
    public static String menuIpAddr(){
        System.out.print(YELLOW + "       IpAddres: ");
        return scanner.next();
    }
    public static  int menuPORT(){
        System.out.print(YELLOW + "       PORT: " );
        return scanner.nextInt();
    }
    public static String menuNickname(){
        System.out.print(YELLOW + "       Nickname: ");
        return scanner.next();
    }
    public static void error(String message){
        System.out.println(RED+ message);
    }

    public static void instruction(){
        parsers3();
        System.out.println(GREEN + " Для вызова меню воспользуетесь\n" +
                           " формулировкой:");
        System.out.println(GREEN + "     /menu -[command] -[option]");
        System.out.println(GREEN + " Для просмотра всех комманд пропишите:");
        System.out.println(GREEN + " /menu");
        parsers2();
    }
    public static void parsers(){System.out.println(GREEN + "========================================");}
    public static void parsers2(){System.out.println(GREEN + "----------------------------------------");}
    public static void parsers3(){System.out.println(GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");}

}
