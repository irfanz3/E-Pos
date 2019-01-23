package controller;


import adapter.ProductAdapter;
import adapter.RequestAdapter;
import com.jfoenix.controls.*;
import entity.Product;
import entity.Request;
import helpers.RequestCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RequestController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private ListView<Request> requestList;

    @FXML
    private JFXButton btnHomeAdd;

    @FXML
    private Pane formRequest;

    @FXML
    private JFXTextField permintaanQty;

    @FXML
    private JFXComboBox<String> permintaanModel;

    @FXML
    private JFXDatePicker permintaanDate;

    @FXML
    private JFXButton btnPermintaanSave;

    @FXML
    private JFXButton btnPermintaanCancel;

    @FXML
    private JFXTextField permintaanLetterNumber;

    @FXML
    private JFXComboBox<String> permintaanOffice;

    @FXML
    private JFXChipView<String> permintaanModelContainer;

    @FXML
    private JFXButton addProduct;

    @FXML
    private RequestCell requestCell;


    private List<Request> requests = new ArrayList<>();


    @Override
    public void handle(ActionEvent e) {
        if (e.getSource().equals(btnHomeAdd)) formRequest.setVisible(true);
        if (e.getSource().equals(btnPermintaanSave)) saveForm();
        if (e.getSource().equals(btnPermintaanCancel)) closeForm();
        if (e.getSource().equals(addProduct)) addProductSelected();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        requests.add(new Request("SURAT/XI/121/31", "KCP Warung Lobak", Request.STATUS_APPROVE));
        requests.add(new Request("SURAT/XI/121/32", "KCP Soreang", Request.STATUS_PENDING));

        ObservableList<Request> observableList = FXCollections.observableList(requests);
        requestList.setItems(observableList);
        requestList.setCellFactory(requestListView -> new RequestAdapter());

        setDropdownProduct();
        setDropdownOffice();

        btnHomeAdd.setOnAction(this);
        btnPermintaanSave.setOnAction(this);
        addProduct.setOnAction(this);
        btnPermintaanCancel.setOnAction(this);

    }

    private void saveForm() {
        String letter = permintaanLetterNumber.getText();
        String office = permintaanOffice.getSelectionModel().getSelectedItem();

        requests.add(new Request(letter, office, Request.STATUS_PENDING));
        requestList.refresh();
        closeForm();
    }

    private void closeForm() {
        formRequest.setVisible(false);
    }

    private void addProductSelected() {
        String value = permintaanModel.getValue();
        System.out.println(value);
        permintaanModelContainer.getChips().add(value);
    }

    private void setDropdownProduct() {

        ArrayList<String> product = new ArrayList<>();
        product.add("Resi Tunggal");
        product.add("Seal Plastik");
        product.add("Barcode Steaker ePos");
        product.add("Map Dinas");
        product.add("Amplop Dinas Kecil");
        product.add("Amplop Dinas Sedang");
        product.add("Amplop Dinas Besar");

        permintaanModel.getItems().removeAll();
        permintaanModel.getItems().addAll(product);
    }

    private void setDropdownOffice() {
        ArrayList<String> office = new ArrayList<>();
        office.add("KP Tanggerang Selatan");
        office.add("KP Bogor");
        office.add("KP Depok");
        office.add("KP Cibinong");
        office.add("KP Cikarang");

        permintaanOffice.getItems().removeAll();
        permintaanOffice.getItems().addAll(office);
    }


}
