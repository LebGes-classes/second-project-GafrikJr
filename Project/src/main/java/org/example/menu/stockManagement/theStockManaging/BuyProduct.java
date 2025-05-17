package org.example.menu.stockManagement.theStockManaging;

import org.example.methods.otherMethods.ClearConsole;
import org.example.methods.warehousesMethods.CellMethods;
import org.example.methods.ordersMethods.ProductMethods;
import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.warehouses.Cell;

import java.util.List;
import java.util.Scanner;

public class BuyProduct {
    public static void buyProduct(int warehouseId) {
        ClearConsole.clearConsole();
        boolean isPuted = false;
        Scanner scanner = new Scanner(System.in);
        ProductMethods.printAllProducts();
        System.out.println("\nПоследовательно введите id продукта, который хотите закупить, и количество: ");
        int productId = scanner.nextInt();
        int productCount = scanner.nextInt();

        ClearConsole.clearConsole();
        List<Cell> stockCells = WarehouseMethods.getWarehouseCells(warehouseId);
        for (Cell cell : stockCells) {
            if (cell.getProductId() == 0 && !isPuted) {
                CellMethods.putProduct(cell.getId(), productId, productCount);
                System.out.println("Вы положили " + productCount + " единиц товара '" + ProductMethods.getProductById(productId).getName() + "' в ячейку с id = " + cell.getId());
                isPuted = true;
            }
        }

        System.out.println("\nЕсли хотите закупить еще товара - нажмите 1" +
                "\nЕсли хотите вернуться назад - нажмите 2");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                buyProduct(warehouseId);
                break;
            case 2:
                StockManagement.stockManagementMenu(warehouseId);
                break;
        }
    }
}
