package org.example.methods.ordersMethods;

import org.example.methods.otherMethods.HibernateMethods;
import org.example.methods.warehousesMethods.CellMethods;
import org.example.methods.warehousesMethods.StockMethods;
import org.example.model.orders.Order;
import org.example.model.orders.OrderList;
import org.example.model.users.Buyer;
import org.example.model.warehouses.Cell;
import org.example.model.warehouses.SellPoint;
import java.util.List;
import java.util.Random;

public class RandomOrder {
    public static void makeOrderList(int sellPointId) {
        Random random = new Random();
        int stockId = StockMethods.getRandomStockId();

        Buyer buyer = BuyerMethods.getBuyerById(random.nextInt(6) + 1);
        OrderList orderList = new OrderList(OrderListMethods.getLastId(), buyer.getId(), 0);
        List<Cell> notVoidStockCells = CellMethods.getNotVoidCells(stockId);
        List<Cell> voidSellPointCells = CellMethods.getVoidCells(sellPointId);

        // тут мы создаем маленькое кол-во заказов из содержимого ячеек склада
        // условие: Если пустых и не пустых ячеек больше, чем размер нашего заказа
        int orderSize = random.nextInt(3) + 1;
        if (voidSellPointCells.size() >= orderSize && notVoidStockCells.size() >= orderSize) {
            for (Cell stockCell : notVoidStockCells) {
                if (stockCell.getProductId() != 0 && orderSize != 0) {
                    for (Cell sellPointCell : voidSellPointCells) {
                        Order order = new Order(
                                OrderMethods.getLastId(),
                                orderList.getId(),
                                stockCell.getProductId(),
                                stockCell.getProductCount(),
                                sellPointCell.getId(),
                                stockCell.getProfit()
                        );
                        //убираем продукт из склада
                        HibernateMethods.updateEntity(stockCell.getId(), Cell.class, cell -> cell.setProductId(0));
                        HibernateMethods.updateEntity(stockCell.getId(), Cell.class, cell -> cell.setProductCount(0));
                        HibernateMethods.updateEntity(stockCell.getId(), Cell.class, cell -> cell.setProfit(0));

                        OrderMethods.makeEntry(order);
                        orderList.setTotalCost(orderList.getTotalCost() + order.getCost());
                        orderSize--;
                        break;
                    }
                }
            }
            OrderListMethods.makeEntry(orderList);
            HibernateMethods.updateEntity(
                    sellPointId,
                    SellPoint.class,
                    sellPoint -> sellPoint.setProfit(sellPoint.getProfit() + orderList.getTotalCost())
            );
        }

    }
}
