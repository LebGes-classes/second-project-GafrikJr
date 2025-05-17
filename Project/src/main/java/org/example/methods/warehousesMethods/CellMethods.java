package org.example.methods.warehousesMethods;

import org.example.methods.ordersMethods.ProductMethods;
import org.example.methods.otherMethods.HibernateMethods;
import org.example.model.warehouses.Cell;
import org.example.model.orders.Product;
import java.util.ArrayList;
import java.util.List;

public class CellMethods {
    public static void createCell(Cell cell) {
        HibernateMethods.createEntry(cell, Cell.class);
    }

    public static void createCells(int warehouseId, int capacity) {
        for (int i = 0; i < capacity; i++) {
            Cell cell = new Cell(warehouseId);
            createCell(cell);
        }
    }

    public static void closeCells(int warehouse_id) {
        List<Cell> closedCells = getClosedCells(warehouse_id);
        for (Cell cell : closedCells) {
            HibernateMethods.deleteObjectById(cell.getId(), Cell.class);
        }
    }

    public static void putProduct(int cellId, int productId, int productCount) {
        Cell cell = getCellById(cellId);
        // обновляем запись ячейки в БД, изменяя столбцы id продукта и кол-во продукта
        HibernateMethods.updateEntity(cellId,
                Cell.class,
                _cell -> putContent(_cell, productId, productCount)
        );
    }

    public static List<Cell> getVoidCells(int warehouseId) {
        List<Cell> voidCells = new ArrayList<>();
        List<Cell> allCells = WarehouseMethods.getWarehouseCells(warehouseId);
        for (Cell cell : allCells) {
            if (cell.getProductId() == 0) {
                voidCells.add(cell);
            }
        }
        return voidCells;
    }

    public static List<Cell> getNotVoidCells(int warehouseId) {
        List<Cell> notVoidCells = new ArrayList<>();
        List<Cell> allCells = WarehouseMethods.getWarehouseCells(warehouseId);
        for (Cell cell : allCells) {
            if (cell.getProductId() != 0) {
                notVoidCells.add(cell);
            }
        }
        return notVoidCells;
    }

    public static Cell getCellById(int cellId) {
        return HibernateMethods.getObjectById(cellId, Cell.class);
    }

    private static List<Cell> getClosedCells(int warehouse_id) {
        String request = "FROM Cell where warehouseId = " + warehouse_id;
        List<Cell> closedCells = HibernateMethods.getObjectsByRequest(Cell.class, request);
        return closedCells;
    }

    // этот метод нужен для функц. интерфейса Consumer
    private static void putContent(Cell cell, int productId, int productCount) {
        Product product = ProductMethods.getProductById(productId);
        cell.setProductId(productId);
        cell.setProductCount(productCount);
        cell.setProfit(productCount * (product.getSellCost() - product.getBuyCost()));
    }
}
