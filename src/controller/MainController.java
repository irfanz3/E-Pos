package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, EventHandler<ActionEvent> {

    private static final String DASHBOARD_FXML = "dashboard.fxml";
    private static final String REQUEST_FXML = "request.fxml";
    private static final String DETAILS_FXML = "details.fxml";

    @FXML
    private Pane container;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnRequest;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private RequestController requestController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDashboardFxml();

        btnDashboard.setOnAction(this);
        btnRequest.setOnAction(this);
        btnDelivery.setOnAction(this);
    }

    private void setDashboardFxml() {
        FXMLLoader loader = setContainer(DASHBOARD_FXML);
        loader.setController(new HomeController());
    }

    private void setRequestFxml() {
        FXMLLoader loader = setContainer(REQUEST_FXML);
        loader.setController(new RequestController());
    }

    public void setDetailsFxml() {
        FXMLLoader loader = setContainer(DETAILS_FXML);
    }

    private FXMLLoader setContainer(String filename) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/".concat(filename)));
            Node node = loader.load();
            container.getChildren().clear();
            container.getChildren().setAll(node);

            return loader;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource().equals(btnDashboard)) setDashboardFxml();
        if (e.getSource().equals(btnRequest)) setRequestFxml();
        if (e.getSource().equals(btnDelivery)) setDetailsFxml();
    }
}
