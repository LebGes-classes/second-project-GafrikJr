package org.example.methods.warehousesMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.userMethods.EmployeeMethods;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.Stock;
import org.example.model.warehouses.Warehouse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockMethods {

    public static List<Stock> getAllStocks() {
        String request = "FROM Stock";
        return HibernateMethods.getObjectsByRequest(Stock.class, request);
    }

    public static boolean printAllStocks() {
        boolean isEmpty = false;
        List<Stock> allStocks = StockMethods.getAllStocks();
        for (Stock stock : allStocks) {
            System.out.println(stock.toString());
        }
        if (allStocks.size() == 0) {
            System.out.println("Не существует открытых складов");
            isEmpty = true;
        }
        return isEmpty;
    }

    public static void openStock(Warehouse warehouse) {
        /*
        / т.к Warehouse - абстрактная штука, используемая только ради получения уникального warehouse_id,
        / для открытия конкретного Stock мы сначала должны сделать запись Warehouse, и потом с его полями открыть Stock
        / Так же при открытии склада автоматически создаются 5 грузчиков + 1 менеджер и ячейки склада.
        */
        WarehouseMethods.openWarehouse(warehouse); // создали запись хранилища в БД
        Stock stock = new Stock(
                warehouse.getId(),
                warehouse.getSalaryBudget(),
                warehouse.getCapacity()
        );
        HibernateMethods.createEntry(stock, Stock.class); // создали запись склада в БД
        int managerId = EmployeeMethods.hireStaff(warehouse.getId(), 5, "loader"); // наняли рабочих + менеджера
        CellMethods.createCells(warehouse.getId(), warehouse.getCapacity()); // создали ячейки склада

        HibernateMethods.updateEntity(  // устанавливаем хранилищу managerId нанятого менеджера
                warehouse.getId(),
                Warehouse.class,
                _warehouse -> _warehouse.setManagerId(managerId)
        );
        HibernateMethods.updateEntity( // устанавливаем складу managerId нанятого менеджера
                warehouse.getId(),
                Stock.class,
                _stock -> _stock.setManagerId(managerId)
        );

    }

    public static void closeStockById(int warehouse_id) {
        /*
        /Чтобы закрыть склад, нам нужно
        1) уволить персонал
        2) закрыть все ячейки
        3) удалить записи warehouse и stock
        */
        EmployeeMethods.fireStaff(warehouse_id);
        CellMethods.closeCells(warehouse_id);
        HibernateMethods.deleteObjectById(warehouse_id, Stock.class);
        WarehouseMethods.deleteWarehouseById(warehouse_id, Warehouse.class);
    }

    public static int getRandomStockId() {
        List<Stock> stocks = getAllStocks();
        Random random = new Random();
        int randomIndex = random.nextInt(stocks.size());
        return stocks.get(randomIndex).getStockId();
    }

}
