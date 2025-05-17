package org.example.model.orders;

import org.example.methods.ordersMethods.BuyerMethods;
import org.example.methods.ordersMethods.OrderListMethods;
import org.example.methods.ordersMethods.ProductMethods;

public class Order {
    private int id;
    private int orderListId;
    private int productId;
    private int productCount;
    private int cellId;
    private int cost;

    public Order(int id, int orderListId, int productId, int productCount, int cellId, int cost) {
        this.id = id;
        this.orderListId = orderListId;
        this.productId = productId;
        this.productCount = productCount;
        this.cellId = cellId;
        this.cost = cost;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(int orderListId) {
        this.orderListId = orderListId;
    }

    public int getCellId() {
        return cellId;
    }

    public void setCellId(int cellId) {
        this.cellId = cellId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void printInfo() {
        System.out.println(
                "id: " + id
                + " | Товар: " + ProductMethods.getProductById(productId).getName()
                + " | Кол-во: " + productCount
                + " | Стоимость заказа: " + cost
                + " | Заказчик: " + BuyerMethods.getBuyerById(OrderListMethods.getOrderListById(orderListId).getBuyerId()).getFullName()
        );
    }
}
