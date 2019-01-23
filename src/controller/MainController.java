package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String DASHBOARD_FXML = "dashboard.fxml";
    private static final String REQUEST_FXML = "request.fxml";
    private static final String DETAILS_FXML = "details.fxml";

    @FXML
    private Pane container;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDetailsFxml();
    }

    private void setDashboardFxml() {
        setContainer(DASHBOARD_FXML);
    }

    private void setRequestFxml() {
        setContainer(REQUEST_FXML);
    }

    private void setDetailsFxml() {
        setContainer(DETAILS_FXML);
    }

    private void setContainer(String filename) {
        try {
            Node node = FXMLLoader.load(getClass().getResource("../fxml/".concat(filename)));
            container.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
