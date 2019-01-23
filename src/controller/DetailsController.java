package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableView;
import entity.DetailsRequest;
import entity.Request;
import helpers.DetailCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DetailsController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Label headerLetterNumber;

    @FXML
    private Label headerOffice;

    @FXML
    private Label headerDate;

    @FXML
    private ListView<DetailsRequest> productList;


    @Override
    public void handle(ActionEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<DetailsRequest> detailsRequests = new ArrayList<>();
        detailsRequests.add(new DetailsRequest("Box Surat", 1000, "box", 100, 100));
        detailsRequests.add(new DetailsRequest("Box Buku", 800, "box", 100, 100));

//        for (int i = 0; i < 15; i++) detailsRequests.add(new DetailsRequest("Bar Code " + i, 800 + i, "box", 100 + i, 100 - i));

        ObservableList<DetailsRequest> observableList = FXCollections.observableArrayList(detailsRequests);
        productList.setItems(observableList);
        productList.setCellFactory(detailsRequestListView -> new ListCell<DetailsRequest>() {
            @Override
            protected void updateItem(DetailsRequest detailsRequest, boolean b) {
                super.updateItem(detailsRequest, b);

                if (detailsRequest != null) {
                    DetailCell detailCell = new DetailCell();
                    detailCell.setDetails(detailsRequest);
                    setGraphic(detailCell.getContainer());
                }
            }
        });



    }
}
