package org.example.methods.ordersMethods;

import org.example.methods.warehousesMethods.WarehouseMethods;
import org.example.model.orders.Order;
import org.example.model.warehouses.Cell;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMethods {
    private static final File ORDER_TXT = new File("C://Users/Тимур/Documents/GitHub/MarketPlaceProject/files/Orders.txt");

    public static Order getOrderById(int id) {
        Order order = null;
        String[] columns = new String[6];
        try {
            Scanner scanner = new Scanner(ORDER_TXT);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                columns = scanner.nextLine().split("  ");
                if (Integer.parseInt(columns[0]) == id) {
                    order = new Order(
                            Integer.parseInt(columns[0]),
                            Integer.parseInt(columns[1]),
                            Integer.parseInt(columns[2]),
                            Integer.parseInt(columns[3]),
                            Integer.parseInt(columns[4]),
                            Integer.parseInt(columns[5])
                    );
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static void makeEntry(Order order) {
        try {
            FileWriter fileWriter = new FileWriter(ORDER_TXT, true);
            String entry =
                    "\n" + order.getId() + "  "
                    + order.getOrderListId() + "  "
                    + order.getProductId() + "  "
                    + order.getProductCount() + "  "
                    + order.getCellId() + "  "
                    + order.getCost();
            fileWriter.write(entry);
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getLastId() {
        int size = 0;
        try {
            Scanner scanner = new Scanner(ORDER_TXT);
            while (scanner.hasNext()) {
                size++;
                scanner.nextLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    public static List<Order> getSellPointOrders(int warehouseId) {
        List<Cell> cells = WarehouseMethods.getWarehouseCells(warehouseId);
        List<Order> orders = new ArrayList<>();
        for (Cell cell : cells) {
            for (int i = 0; i < getLastId(); i++) {
                Order order = getOrderById(i);
                if (order != null && order.getCellId() == cell.getId()) {
                    orders.add(order);
                }
            }
        }
        return orders;
    }
}
