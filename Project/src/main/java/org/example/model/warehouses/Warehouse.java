package org.example.model.warehouses;

import jakarta.persistence.*;
import org.example.model.users.Employee;

import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "salary_budget")
    private int salaryBudget;

    @Column(name = "capacity")
    private int capacity;

    public Warehouse() {}

    public Warehouse(int salaryBudget, int capacity) {
        this.managerId = 0;
        this.salaryBudget = salaryBudget;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getSalaryBudget() {
        return salaryBudget;
    }

    public void setSalaryBudget(int salaryBudget) {
        this.salaryBudget = salaryBudget;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                ", id=" + id +
                ", managerId=" + managerId +
                ", salaryBudget=" + salaryBudget +
                ", capacity=" + capacity +
                '}';
    }
}
