package org.example.menu;

import org.example.menu.businessInfo.PrintBusinessInfo;
import org.example.menu.sellpointManagement.SellPointMenu;
import org.example.menu.stockManagement.StockMenu;
import org.example.methods.otherMethods.ClearConsole;
import java.util.Scanner;

public class Menu {
    public static void mainMenu() {
        ClearConsole.clearConsole();
        System.out.println("Выберите опцию: " +
                "\n1) Управление складами" +
                "\n2) Управление ПВЗ" +
                "\n3) Информация о бизнесе" +
                "\n4) Закрыть программу");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StockMenu.menu();
                break;
            case 2:
                SellPointMenu.menu();
                break;
            case 3:
                PrintBusinessInfo.printBusinessInfo();
                break;
            case 4:
                System.exit(0);
        }
    }
}