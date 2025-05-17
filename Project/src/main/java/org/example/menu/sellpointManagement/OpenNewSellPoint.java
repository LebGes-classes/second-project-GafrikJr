package org.example.menu.sellpointManagement;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.SellPointMethods;
import org.example.model.warehouses.Warehouse;
import java.util.Scanner;

public class OpenNewSellPoint {
    public static void openNewSellPoint() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зарплатный бюджет склада: ");
        int salaryBudget = scanner.nextInt();
        System.out.println("Введите вместимость склада: ");
        int capacity = scanner.nextInt();
        Warehouse warehouse = new Warehouse(salaryBudget, capacity);
        SellPointMethods.openSellPoint(warehouse); // создали запись ПВЗ и warehouse

        ClearConsole.clearConsole();
        System.out.println("Если хотите открыть еще ПВЗ - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                openNewSellPoint();
                break;
            case 2:
                SellPointMenu.menu();
                break;
        }
    }
}
