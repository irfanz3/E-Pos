package controller;


import adapter.ProductAdapter;
import adapter.RequestAdapter;
import entity.Product;
import entity.Request;
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

public class RequestController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private ListView<Request> requestList;


    @Override
    public void handle(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Request> requests =new ArrayList<>();
        requests.add(new Request("SURAT/XI/121/31", "KCP Warung Lobak", Request.STATUS_APPROVE));
        requests.add(new Request("SURAT/XI/121/32", "KCP Soreang", Request.STATUS_PENDING));

        for (int i = 0; i < 15; i++)  requests.add(new Request("SURAT/XI/121/3" + i,"KCP Bandung " + i, Request.STATUS_REJECT));

        ObservableList<Request> observableList = FXCollections.observableList(requests);
        requestList.setItems(observableList);
        requestList.setCellFactory(requestListView -> new RequestAdapter());

    }
}
