package org.example.menu.stockManagement;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.StockMethods;
import java.util.Scanner;

public class CloseStock {
    public static void closeStock() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        boolean isEmpty = StockMethods.printAllStocks();
        if (!isEmpty) {
            System.out.println("Напишите id склада, который хотите закрыть:");
            int warehouseId = scanner.nextInt();
            StockMethods.closeStockById(warehouseId); // удалили нужные записи из БД
        }

        ClearConsole.clearConsole();
        System.out.println("Если хотите закрыть еще склад - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                closeStock();
                break;
            case 2:
                StockMenu.menu();
                break;
        }
    }
}
