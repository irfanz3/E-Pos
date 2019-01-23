package controller;

import adapter.ProductAdapter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private ListView<Product> productList;

    @FXML
    private Pane formProduk;

    @FXML
    private Button btnHomeAdd;

    @FXML
    private Button btnSaveFormProduct;

    @FXML
    private Button btnCloseFormProduct;

    @FXML
    private JFXTextField productModel;

    @FXML
    private JFXTextField productQty;

    @FXML
    private JFXTextField unit;

    @FXML
    private Pane formAddQty;

    @FXML
    private JFXTextField addStockField;

    @FXML
    private JFXButton btnSaveFormStock;

    @FXML
    private JFXButton btnCloseFormStock;

    private List<Product> products = new ArrayList<>();

    private int selected = 0;

    @Override
    public void handle(ActionEvent e) {

        if(e.getSource().equals(btnHomeAdd)) formProduk.setVisible(true);
        if(e.getSource().equals(btnSaveFormProduct)) saveForm();
        if(e.getSource().equals(btnCloseFormProduct)) closeForm();
        if(e.getSource().equals(btnSaveFormStock)) saveFormQty();
        if(e.getSource().equals(btnCloseFormStock)) closeFormQty();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        products.add(new Product("Resi Tunggal", 2010, "box"));
        products.add(new Product("Seal Plastik", 412, "roll"));
        products.add(new Product("Barcode Steaker ePos", 300, "lembar"));
        products.add(new Product("Map Dinas", 1206, "lembar"));
        products.add(new Product("Amplop Dinas Kecil", 350, "lembar"));
        products.add(new Product("Amplop Dinas Sedang", 482, "lembar"));

        ObservableList<Product> observableList = FXCollections.observableList(products);
        productList.setItems(observableList);
        productList.setCellFactory(productListView -> new ProductAdapter(this));

        btnHomeAdd.setOnAction(this);
        btnSaveFormProduct.setOnAction(this);
        btnCloseFormProduct.setOnAction(this);
        btnCloseFormStock.setOnAction(this);
        btnSaveFormStock.setOnAction(this);
    }

    public void openAddQty(int index) {
        selected = index;
        formAddQty.setVisible(true);
    }

    private void saveFormQty() {
        int qty = Integer.parseInt(addStockField.getText());
        Product add = products.get(selected);
        add.setStock(add.getStock() + qty);

        products.set(selected, add);
        productList.refresh();
        System.out.println(products.size());
        closeFormQty();
    }

    private void closeFormQty() {
        addStockField.setText("");
        formAddQty.setVisible(false);
    }

    private void saveForm() {
        String model = productModel.getText();
        String modelUnit = unit.getText();
        int qty = Integer.parseInt(productQty.getText());

        products.add(new Product(model, qty, modelUnit));
        productList.refresh();
        closeForm();
    }

    private void closeForm() {
        formProduk.setVisible(false);
    }
}
