package org.example.model.users;


import jakarta.persistence.*;
import org.example.methods.otherMethods.RandomHuman;
import org.example.model.warehouses.Warehouse;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "place_of_work_id")
    private int placeOfWorkId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "is_working")
    private boolean isWorking;

    @Column(name = "post")
    private String post;

    public Employee() {};

    public Employee(int placeOfWorkId, String post) {
        this.placeOfWorkId = placeOfWorkId;
        this.fullName = RandomHuman.randomHuman();
        this.isWorking = true;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceOfWorkId() {
        return placeOfWorkId;
    }

    public void setPlaceOfWorkId(int placeOfWorkId) {
        this.placeOfWorkId = placeOfWorkId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " | ФИО: " + fullName  +
                " | должность: '" + post;
    }
}
