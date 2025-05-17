package org.example.menu.generalManagementMethods;

import org.example.menu.sellpointManagement.sellpointManaging.SellPointManagement;
import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import java.util.Scanner;

public class FireEmployee {

    public static void fireEmployee(int warehouseId) {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        WarehouseMethods.printStaff(warehouseId);
        System.out.println("\nВведите id рабочего, которого хотите уволить(менеджера нельзя уволить):");
        int employeeId = scanner.nextInt();
        while (employeeId == WarehouseMethods.getWarehouseById(warehouseId).getManagerId()) {
            System.out.println("Менеджера нельзя уволить!");
            employeeId = scanner.nextInt();
        }
        EmployeeMethods.fireEmployeeById(employeeId);
    }

    public static void stockContinue(int warehouseId) {
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clearConsole();
        System.out.println("Если хотите уволить еще сотрудника - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fireEmployee(warehouseId);
                break;
            case 2:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }

    public static void sellPointContinue(int warehouseId) {
        Scanner scanner = new Scanner(System.in);
        ClearConsole.clearConsole();
        System.out.println("Если хотите уволить еще сотрудника - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fireEmployee(warehouseId);
                break;
            case 2:
                SellPointManagement.sellPointManagementMenu(warehouseId);
                break;
        }
    }
}
