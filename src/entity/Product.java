package entity;

import helpers.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Product {

    private int id;
    private int stock;
    private String code;
    private String name;
    private String unit;
    private Date created_at;

    private Connection connection;

    public Product() throws SQLException {

        this.connection = DBConnection.getConnection();

    }

    public void getAll() {
        PreparedStatement statement;

        try {

            statement = this.connection.prepareStatement("SELECT * FROM products");
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }



}
