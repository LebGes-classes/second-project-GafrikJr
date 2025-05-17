package org.example.model.warehouses;

import jakarta.persistence.*;
import org.example.methods.ordersMethods.ProductMethods;
import org.example.model.orders.Product;

@Entity
@Table(name = "Cell")
public class Cell {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "profit")
    private int profit;

    public Cell() {};

    public Cell(int warehouseId) {
        this.warehouseId = warehouseId;
        this.productId = 0;
        this.productCount = 0;
        this.profit = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void printContent() {
        Product content = ProductMethods.getProductById(productId);
        if (content != null) {
            System.out.println("В ячейке с id = " + id + " лежит '" + content.getName() + "' в количестве " + productCount + " штук. Выгода с продажи содержимого составляет " + profit + " руб.");
        }
        else {
            System.out.println("В ячейке с id = " + id + " пусто.");
        }
    }
}
