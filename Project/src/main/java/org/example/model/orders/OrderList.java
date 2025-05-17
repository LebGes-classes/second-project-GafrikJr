package org.example.model.orders;

public class OrderList {
    private int id;
    private int buyerId;
    private int totalCost;

    public OrderList(int id, int buyerId, int totalCost) {
        this.id = id;
        this.buyerId = buyerId;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
