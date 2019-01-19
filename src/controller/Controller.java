package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnRequest;

    @FXML
    private Button btnDelivery;

    @FXML
    private Button btnAddstock;

    @FXML
    private VBox content;

    @FXML
    private Pane coba;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void handleClick(ActionEvent event){
        /*if (event.getSource() == btnDashboard){

        }else
        if (event.getSource() == btnRequest){
            coba.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        } else
        if (event.getSource() == btnDelivery) {
            content.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.rgb(0,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        }*/
    }
}
