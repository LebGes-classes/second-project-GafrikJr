package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.SellPoint;
import org.example.model.warehouses.Warehouse;
import java.util.ArrayList;
import java.util.List;

public class SellPointMethods {

    public static SellPoint getSellPointById(int warehouseId) {
        return HibernateMethods.getObjectById(warehouseId, SellPoint.class);
    }

    public static void closeSellPointById(int warehouse_id) {
        EmployeeMethods.fireStaff(warehouse_id);
        CellMethods.closeCells(warehouse_id);
        HibernateMethods.deleteObjectById(warehouse_id, SellPoint.class);
        WarehouseMethods.deleteWarehouseById(warehouse_id, Warehouse.class);
    }

    public static List<SellPoint> getAllSellPoints() {
        String request = "FROM SellPoint";
        return HibernateMethods.getObjectsByRequest(SellPoint.class, request);
    }

    public static boolean printAllSellPoints() {
        boolean isEmpty = false;
        List<SellPoint> allSellPoints = SellPointMethods.getAllSellPoints();
        for (SellPoint sellPoint : allSellPoints) {
            System.out.println(sellPoint.toString());
        }
        if (allSellPoints.size() == 0) {
            System.out.println("Не существует открытых ПВЗ");
            isEmpty = true;
        }
        return isEmpty;
    }

    public static void openSellPoint(Warehouse warehouse) {
        /*
        По умолчанию нанимается 1 менеджер + 2 продавца
         */
        WarehouseMethods.openWarehouse(warehouse); // создали запись хранилища в БД
        SellPoint sellPoint = new SellPoint(
                warehouse.getId(),
                warehouse.getSalaryBudget(),
                warehouse.getCapacity()
        );
        HibernateMethods.createEntry(sellPoint, SellPoint.class); // создали запись ПВЗ в БД
        int managerId = EmployeeMethods.hireStaff(warehouse.getId(), 3, "seller"); // создали записи рабочих в БД
        CellMethods.createCells(warehouse.getId(), warehouse.getCapacity()); // создали записи ячеек в БД

        HibernateMethods.updateEntity(  // устанавливаем хранилищу managerId нанятого менеджера
                warehouse.getId(),
                Warehouse.class,
                _warehouse -> _warehouse.setManagerId(managerId)
        );

        HibernateMethods.updateEntity( // устанавливаем sellPoint'у нанятого менеджера
                sellPoint.getId(),
                SellPoint.class,
                _sellPoint -> _sellPoint.setManagerId(managerId)
        );
    }
}
