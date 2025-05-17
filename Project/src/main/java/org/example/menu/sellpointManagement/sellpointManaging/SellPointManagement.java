package org.example.menu.sellpointManagement.sellpointManaging;

import org.example.menu.Menu;
import org.example.menu.generalManagementMethods.ChangeManager;
import org.example.menu.generalManagementMethods.FireEmployee;
import org.example.menu.generalManagementMethods.HireEmployee;
import org.example.menu.generalManagementMethods.WatchInfo;
import org.example.methods.otherMethods.ClearConsole;

import java.util.Scanner;

public class SellPointManagement {
    public static void sellPointManagementMenu(int warehouseId) {
        ClearConsole.clearConsole();
        System.out.println("Выберите:" +
                "\n1) Нанять сотрудника" +
                "\n2) Уволить сотрудника" +
                "\n3) Поменять менеджера" +
                "\n4) Посмотреть информацию о ПВЗ" +
                "\n5) Посмотреть историю продаж" +
                "\n6) Вернуться назад"
        );
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                HireEmployee.hireEmployee(warehouseId, "seller");
                HireEmployee.sellPointContinue(warehouseId);
                break;
            case 2:
                FireEmployee.fireEmployee(warehouseId);
                FireEmployee.sellPointContinue(warehouseId);
                break;
            case 3:
                ChangeManager.changeSellPointManager(warehouseId);
                break;
            case 4:
                WatchInfo.watchSellPointInfo(warehouseId);
                break;
            case 5:
                PrintSalesHistory.printSalesHistory(warehouseId);
                break;
            case 6:
                Menu.mainMenu();
                break;
        }
    }
}
