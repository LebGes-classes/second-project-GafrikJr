package org.example.menu.sellpointManagement.sellpointManaging;

import org.example.methods.ordersMethods.OrderMethods;
import org.example.methods.ordersMethods.RandomOrder;
import org.example.methods.otherMethods.ClearConsole;
import org.example.model.orders.Order;
import java.util.List;
import java.util.Scanner;

public class PrintSalesHistory {

    public static void printSalesHistory(int warehouseId) {
        ClearConsole.clearConsole();
        RandomOrder.makeOrderList(warehouseId);
        List<Order> orders = OrderMethods.getSellPointOrders(warehouseId);
        if (!orders.isEmpty()) {
            for (Order order : orders) {
                order.printInfo();
            }
        }
        else {
            System.out.println("Еще не совершались продажи у данного ПВЗ");
        }

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
