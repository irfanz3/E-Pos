package controller;

import adapter.ProductAdapter;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private ListView<Product> productList;

    @Override
    public void handle(ActionEvent e) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Box Seal", 2010, "box"));
        products.add(new Product("Bar Code", 412, "box"));

        for (int i = 0; i < 15; i++)  products.add(new Product("Bar Code " + i, 412 + i, "box"));

        ObservableList<Product> observableList = FXCollections.observableList(products);
        productList.setItems(observableList);
        productList.setCellFactory(productListView -> new ProductAdapter());
    }
}
