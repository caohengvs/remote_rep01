package com.caoheng.www.entity;

public class Bank {
    private int id;
    private String name;
    private double money;

    public Bank() {
    }

    public Bank(int id, String name, double money) {
        this.id = id;
        this.name= name;
        this.money = money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ",name='" + name+ '\'' +
                ", money=" + money +
                '}';
    }
}
