package org.example.menu.sellpointManagement;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.SellPointMethods;
import java.util.Scanner;

public class CloseSellPoint {
    public static void closeSellPoint() {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        boolean isEmpty = SellPointMethods.printAllSellPoints();
        if (!isEmpty) {
            System.out.println("Напишите id ПВЗ, который хотите закрыть:");
            int warehouseId = scanner.nextInt();
            SellPointMethods.closeSellPointById(warehouseId);
        }

        ClearConsole.clearConsole();
        System.out.println("Если хотите закрыть еще ПВЗ - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                closeSellPoint();
                break;
            case 2:
                SellPointMenu.menu();
                break;
        }
    }
}
