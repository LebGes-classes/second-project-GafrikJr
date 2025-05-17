package org.example.menu.generalManagementMethods;

import org.example.menu.sellpointManagement.sellpointManaging.SellPointManagement;
import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.model.users.Employee;
import java.util.Scanner;

public class HireEmployee {
    public static void hireEmployee(int warehouseId, String post) {
        ClearConsole.clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во работников для наёма");
        int hiringCount = scanner.nextInt();
        ClearConsole.clearConsole();
        for (int i = 0; i < hiringCount; i++) {
            Employee employee = new Employee(warehouseId, post);
            EmployeeMethods.hireEmployee(employee);
            System.out.println("Вы наняли " + employee.getFullName());
        }
    }

    public static void stockContinue(int warehouseId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЕсли хотите нанять еще сотрудников - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                hireEmployee(warehouseId, "loader");
                break;
            case 2:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }

    public static void sellPointContinue(int warehouseId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЕсли хотите нанять еще сотрудников - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                hireEmployee(warehouseId, "loader");
                break;
            case 2:
                SellPointManagement.sellPointManagementMenu(warehouseId);
                break;
        }
    }
}
