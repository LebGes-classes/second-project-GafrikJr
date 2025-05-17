package org.example.menu.generalManagementMethods;

import org.example.menu.sellpointManagement.sellpointManaging.SellPointManagement;
import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.SellPointMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import java.util.Scanner;

public class WatchInfo {
    public static void watchStockInfo(int warehouseId) {
        ClearConsole.clearConsole();
        WarehouseMethods.printStaff(warehouseId);
        WarehouseMethods.printCellsContent(warehouseId);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЧтобы вернуться назад - нажмите 1");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }

    public static void watchSellPointInfo(int warehouseId) {
        ClearConsole.clearConsole();
        WarehouseMethods.printStaff(warehouseId);
        WarehouseMethods.printCellsContent(warehouseId);
        System.out.println("\nДоходность ПВЗ: " + SellPointMethods.getSellPointById(warehouseId).getProfit() + " руб.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЧтобы вернуться назад - нажмите 1");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                SellPointManagement.sellPointManagementMenu(warehouseId);
                break;
        }
    }
}
