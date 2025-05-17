package org.example.menu.stockManagement.theStockManaging;

import org.example.menu.stockManagement.StockMenu;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.StockMethods;

import java.util.Scanner;

public class ChooseStock {
    public static void chooseStock() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        if (!StockMethods.printAllStocks()) {
            System.out.println("Введите id склада: ");
            int warehouseId = scanner.nextInt();
            StockManagement.stockManagementMenu(warehouseId);
        }
        else {
            StockMenu.menu();
        }
    }
}
