package com.pluralsight;

public class Product {
    private String ID;
    private String Name;
    private double Price;

    public Product(String ID, String name, double price) {
        this.ID = ID;
        Name = name;
        Price = price;
    }

    public Product getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
