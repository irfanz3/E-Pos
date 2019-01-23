package helpers;

import com.jfoenix.controls.JFXButton;
import entity.DetailsRequest;
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

public class DetailCell implements Initializable {

    @FXML
    private HBox detailsCellContainer;

    @FXML
    private Label model;

    @FXML
    private Label request;

    @FXML
    private Label approve;

    @FXML
    private JFXButton action;

    public DetailCell() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/details_cell.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDetails(DetailsRequest details) {
        model.setText(details.getName());
        request.setText(details.getRequest() + " " + details.getUnit());
        approve.setText(details.getApprove() + " " + details.getUnit());
    }

    private String dateFormat(Date date) {
        String pattern = "dd MMMMM yyyy";

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, new Locale("id"));

        return sdf.format(date);
    }

    public HBox getContainer() {
        return detailsCellContainer;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
