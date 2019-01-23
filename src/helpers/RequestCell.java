package helpers;

import com.jfoenix.controls.JFXButton;
import controller.RequestController;
import entity.Product;
import entity.Request;
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

public class RequestCell implements Initializable {

    @FXML
    private HBox productCellContainer;

    @FXML
    private Label letterNumber;

    @FXML
    private Label office;

    @FXML
    private Label date;

    @FXML
    private Label status;

    @FXML
    private JFXButton action;

    public RequestCell() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/request_cell.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setRequestCell(Request request) {
        letterNumber.setText(request.getLetterNumber());
        office.setText(request.getOffice());
        date.setText(dateFormat(request.getDate()));
        status.setText(request.getStatus());
    }

    private String dateFormat(Date date) {
        String pattern = "dd MMMMM yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("id"));

        return sdf.format(date);
    }

    public HBox getContainer() {
        return productCellContainer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}