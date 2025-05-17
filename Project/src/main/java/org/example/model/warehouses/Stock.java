package org.example.model.warehouses;

import jakarta.persistence.*;
import org.example.methods.userMethods.EmployeeMethods;

@Entity
@Table(name = "Stock")
public class Stock {
    @Id
    @Column(name = "warehouse_id")
    private int warehouseId;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "salary_budget")
    private int salaryBudget;

    @Column(name = "capacity")
    private int capacity;

    public Stock() {};

    public Stock(int warehouseId, int salaryBudget, int capacity) {
        this.warehouseId = warehouseId;
        this.managerId = 0;
        this.salaryBudget = salaryBudget;
        this.capacity = capacity;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(int salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStockId() {
        return warehouseId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return  "id: " + warehouseId +
                " | менеджер: " + EmployeeMethods.getEmployeeById(managerId).getFullName() +
                " | зарплатный бюджет: " + salaryBudget +
                " | вместимость склада: " + capacity;
    }
}
