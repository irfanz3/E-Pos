package helpers;

import com.jfoenix.controls.JFXButton;
import controller.HomeController;
import entity.Product;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductCell implements Initializable{

    @FXML
    private Label name;

    @FXML
    private Label total;

    @FXML
    private Label date;

    @FXML
    private JFXButton action;

    @FXML
    private HBox productCellContainer;

    private HomeController controller;

    private int cellPosition = 0;

    public ProductCell(HomeController parent, int position) {
        controller = parent;
        cellPosition = position;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/product_cell.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setProductCell(Product product) {
        name.setText(product.getName());
        total.setText(product.getStock() + " " + product.getUnit());
        date.setText(dateFormat(product.getDate()));
        action.setOnAction(actionEvent -> {
            if (actionEvent.getSource().equals(action)) {
                controller.openAddQty(cellPosition);
            }
        });
    }

    private String dateFormat(Date date) {
        String pattern = "dd MMMMM yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("id"));

        return  sdf.format(date);
    }

    public HBox getContainer() {
        return productCellContainer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
