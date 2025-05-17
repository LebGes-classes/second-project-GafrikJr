package org.example.menu.stockManagement.theStockManaging;

import org.example.menu.Menu;
import org.example.menu.generalManagementMethods.ChangeManager;
import org.example.menu.generalManagementMethods.FireEmployee;
import org.example.menu.generalManagementMethods.HireEmployee;
import org.example.menu.generalManagementMethods.WatchInfo;
import org.example.methods.otherMethods.ClearConsole;

import java.util.Scanner;

public class StockManagement {
    public static void stockManagementMenu(int warehouseId) {
        ClearConsole.clearConsole();
        System.out.println("Выберите:" +
                "\n1) Нанять сотрудника" +
                "\n2) Уволить сотрудника" +
                "\n3) Поменять менеджера" +
                "\n4) Посмотреть информацию о складе" +
                "\n5) Закупить товар" +
                "\n6) Вернуться назад");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                HireEmployee.hireEmployee(warehouseId, "loader");
                HireEmployee.stockContinue(warehouseId);
                break;
            case 2:
                FireEmployee.fireEmployee(warehouseId);
                FireEmployee.stockContinue(warehouseId);
                break;
            case 3:
                ChangeManager.changeStockManager(warehouseId);
                break;
            case 4:
                WatchInfo.watchStockInfo(warehouseId);
                break;
            case 5:
                BuyProduct.buyProduct(warehouseId);
                break;
            case 6:
                Menu.mainMenu();
                break;
        }
    }
}
