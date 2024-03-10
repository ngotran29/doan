package com.example.nhp;

public class Tinhthanh {
    int id ;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tinhthanh(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tinhthanh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}