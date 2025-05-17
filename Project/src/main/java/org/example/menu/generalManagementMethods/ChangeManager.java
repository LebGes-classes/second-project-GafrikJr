package org.example.menu.generalManagementMethods;

import org.example.menu.sellpointManagement.sellpointManaging.SellPointManagement;
import org.example.menu.stockManagement.theStockManaging.StockManagement;
import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.SellPoint;
import org.example.model.warehouses.Stock;
import org.example.model.warehouses.Warehouse;
import java.util.Scanner;

public class ChangeManager {
    public static void changeStockManager(int warehouseId) {
        ClearConsole.clearConsole();
        Warehouse warehouse = WarehouseMethods.getWarehouseById(warehouseId);
        int managerId = warehouse.getManagerId();
        Employee newManager = new Employee(warehouseId, "manager");
        EmployeeMethods.hireEmployee(newManager); // создали запись в БД с новым менеджером
        HibernateMethods.updateEntity(warehouseId,// поставили warehouse нового менеджера
                Warehouse.class,
                _warehouse -> _warehouse.setManagerId(newManager.getId())
        );
        HibernateMethods.updateEntity(warehouseId,// поставили складу нового менеджера
                Stock.class,
                _stock -> _stock.setManagerId(newManager.getId())
        );
        EmployeeMethods.fireEmployeeById(managerId); // уволили старого менеджера
        System.out.println("Теперь ваш новый менеджер: " + newManager.getFullName());

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nЧтобы вернуться назад - нажмите 1");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }

    public static void changeSellPointManager(int warehouseId) {
        ClearConsole.clearConsole();
        Warehouse warehouse = WarehouseMethods.getWarehouseById(warehouseId);
        int managerId = warehouse.getManagerId();
        Employee newManager = new Employee(warehouseId, "manager");
        EmployeeMethods.hireEmployee(newManager); // создали запись в БД с новым менеджером
        HibernateMethods.updateEntity(warehouseId,// поставили warehouse нового менеджера
                Warehouse.class,
                _warehouse -> _warehouse.setManagerId(newManager.getId())
        );
        HibernateMethods.updateEntity(warehouseId,// поставили складу нового менеджера
                SellPoint.class,
                _sellPoint -> _sellPoint.setManagerId(newManager.getId())
        );
        EmployeeMethods.fireEmployeeById(managerId); // уволили старого менеджера
        System.out.println("Теперь ваш новый менеджер: " + newManager.getFullName());

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
