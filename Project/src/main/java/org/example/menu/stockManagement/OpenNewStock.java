package org.example.menu.stockManagement;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.warehouses.Warehouse;
import java.util.Scanner;

public class OpenNewStock {
    public static void openNewStock() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зарплатный бюджет склада: ");
        int salaryBudget = scanner.nextInt();
        System.out.println("Введите вместимость склада: ");
        int capacity = scanner.nextInt();
        Warehouse warehouse = new Warehouse(salaryBudget, capacity);
        StockMethods.openStock(warehouse); // создали запись сток и warehouse

        ClearConsole.clearConsole();
        System.out.println("Если хотите открыть еще склад - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                openNewStock();
                break;
            case 2:
                StockMenu.menu();
                break;
        }
    }
}
