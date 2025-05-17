package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.users.Employee;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Warehouse;
import java.util.ArrayList;
import java.util.List;

public class WarehouseMethods {

    public static Warehouse getWarehouseById(int id) {
        return HibernateMethods.getObjectById(id, Warehouse.class);
    }

    public static void deleteWarehouseById(int id, Class<Warehouse> warehouseClass) {
        HibernateMethods.deleteObjectById(id, warehouseClass);
    }

    public static void openWarehouse(Warehouse warehouse) {
        HibernateMethods.createEntry(warehouse, Warehouse.class);
    }

    // метод универсальный для ПВЗ и складов
    public static void printCellsContent(int warehouseId) {
        System.out.println("\nСодержимое ячеек склада");
        List<Cell> cells = getWarehouseCells(warehouseId);
        for (Cell cell : cells) {
            cell.printContent();
        }
    }


    // тоже метод универсальный для ПВЗ и Складов
    public static List<Cell> getWarehouseCells(int warehouseId) {
        List<Cell> cells = HibernateMethods.getObjectsByRequest(Cell.class, "FROM Cell");
        List<Cell> warehouseCells = new ArrayList<>();
        for (Cell cell : cells) {
            if (cell.getWarehouseId() == warehouseId) {
                warehouseCells.add(cell);
            }
        }
        return warehouseCells;
    }

    // универсальный метод для ПВЗ и складов
    public static void printStaff(int warehouseId) {
        String request = "FROM Employee where placeOfWorkId = " + warehouseId;
        List<Employee> staff = HibernateMethods.getObjectsByRequest(Employee.class, request);
        System.out.println("Рабочий персонал:");
        for (Employee employee : staff) {
            System.out.println(employee.toString());
        }
    }
}
