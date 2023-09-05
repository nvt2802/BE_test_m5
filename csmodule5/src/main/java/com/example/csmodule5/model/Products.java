package com.example.csmodule5.model;

import javax.persistence.*;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    @Column(columnDefinition = "date")
    private String dateAdded;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Products(int id, String code, String name, String dateAdded, int quantity, Type type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dateAdded = dateAdded;
        this.quantity = quantity;
        this.type = type;
    }

    public Products() {
    }
}
