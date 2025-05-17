package org.example.menu.businessInfo;

import org.example.menu.Menu;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.SellPointMethods;
import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.warehouses.SellPoint;
import org.example.model.warehouses.Stock;
import java.util.List;
import java.util.Scanner;

public class PrintBusinessInfo {

    public static void printBusinessInfo() {
        ClearConsole.clearConsole();
        List<SellPoint> sellPoints = SellPointMethods.getAllSellPoints();
        List<Stock> stocks = StockMethods.getAllStocks();
        System.out.println("Кол-во складов: " + stocks.size());
        System.out.println("Кол-во ПВЗ: " + sellPoints.size());
        int totalProfit = 0;
        int totalSalaryBudget = 0;
        for (SellPoint sellPoint : sellPoints) {
            totalProfit += sellPoint.getProfit();
            totalSalaryBudget += sellPoint.getSalaryBudget();
        }
        for (Stock stock : stocks) {
            totalSalaryBudget += stock.getSalaryBudget();
        }
        System.out.println("Прибыль со всего бизнеса: " + (totalProfit - totalSalaryBudget) + " руб.");


        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЧтобы вернуться назад - нажмите 1");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Menu.mainMenu();
                break;
        }
    }
}
