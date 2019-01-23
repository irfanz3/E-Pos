package entity;

import java.util.Date;

public class Product {

    private int id;
    private int stock;
    private String name;
    private String unit;
    private Date created_at;

    public Product(String productName, int productStock, String productUnit) {
        name = productName;
        stock = productStock;
        unit = productUnit;
        created_at = new Date();
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public Date getDate() {
        return created_at;
    }
}
