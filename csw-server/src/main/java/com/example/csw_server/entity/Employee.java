package com.example.csw_server.entity;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String address;
    private String numberphone;

    public Employee() {
    }

    public Employee(int id, String name, int age, String address, String numberphone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.numberphone = numberphone;
    }

    public Employee(String name, int age, String address, String numberphone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.numberphone = numberphone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }
}
