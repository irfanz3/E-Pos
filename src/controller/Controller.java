package controller;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable, EventHandler<ActionEvent> {


    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnRequest;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private VBox halamanUtama;

    @FXML
    private VBox halamanPermintaan;

    @FXML
    private VBox detailRequest;

    @FXML
    private VBox filter;



    /* DASHBOARD VIEW */

    @FXML
    protected JFXButton btnHomeAdd;

    @FXML
    protected JFXTreeTableView<?> homeTableView;

    @FXML
    protected Pane formProduk;

    @FXML
    protected JFXButton btnSaveFormProduct;

    @FXML
    protected JFXButton btnCloseFormProduct;

    @FXML
    protected JFXDatePicker productDate;

    @FXML
    protected JFXComboBox<String> productModel;

    @FXML
    protected JFXTextField productQty;

    @FXML
    private JFXButton addProduct;



    /* REQUEST VIEW */

    @FXML
    private JFXButton btnAddPermintaan;

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
    private Pane formPermintaan;



    /* DETAILS VIEW */

    @FXML
    private JFXTreeTableView<?> detailsTreeTable;

    @FXML
    private JFXButton btnDetailsSave;

    @FXML
    private JFXButton btnDetailsCancel;

    @FXML
    private JFXButton btnApproveSave;

    @FXML
    private JFXButton btnApproveCancel;

    @FXML
    private JFXTextField approveQty;

    @FXML
    private JFXToggleButton approveToggle;

    @FXML
    private Pane approval;

    private ArrayList<String> selectedProduct = new ArrayList<>();


    private void setDisabled(Boolean isDisabled) {
        btnDashboard.setDisable(isDisabled);
        btnRequest.setDisable(isDisabled);
        btnDelivery.setDisable(isDisabled);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnHomeAdd.setOnAction(this);
        btnSaveFormProduct.setOnAction(this);
        btnCloseFormProduct.setOnAction(this);
        addProduct.setOnAction(this);

        btnAddPermintaan.setOnAction(this);
        btnPermintaanSave.setOnAction(this);
        btnPermintaanCancel.setOnAction(this);

        btnDetailsSave.setOnAction(this);
        btnDetailsCancel.setOnAction(this);

        setDropdownProduct();
        setDropdownOffice();

    }

    @Override
    public void handle(ActionEvent e) {

        /* HOME VIEW */
        if (e.getSource().equals(btnHomeAdd))
            openForm(formProduk);

        if (e.getSource().equals(btnSaveFormProduct))
            closeForm(formProduk);

        if (e.getSource().equals(btnCloseFormProduct))
            closeForm(formProduk);

        if (e.getSource().equals(addProduct))
            addProductSelected();


        /* REQUEST VIEW */
        if (e.getSource().equals(btnAddPermintaan))
            openForm(formPermintaan);

        if (e.getSource().equals(btnPermintaanSave))
            closeForm(formPermintaan);

        if (e.getSource().equals(btnPermintaanCancel))
            closeForm(formPermintaan);

        /* DETAILS VIEW */
        if (e.getSource().equals(btnDetailsSave)) {
            closeForm(detailRequest);
            openView(halamanPermintaan);
        }

        if (e.getSource().equals(btnDetailsCancel)) {
            closeForm(detailRequest);
            openView(halamanPermintaan);
        }

    }

    @FXML
    void handleAction(ActionEvent event) {

        if (event.getSource() == btnDashboard) {
            openView(halamanUtama);
        }

        if (event.getSource() == btnRequest) {
            openView(halamanPermintaan);
        }

        if (event.getSource() == btnDelivery) {
            openView(detailRequest);
        }



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

        productModel.getItems().removeAll();
        productModel.getItems().addAll(product);

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

    private void setProductSelected() {

    }

    private void addProductSelected() {
        String value = permintaanModel.getValue();
        System.out.println(value);
        permintaanModelContainer.getChips().add(value);
    }

    private void openView(VBox view) {
        halamanUtama.setVisible(false);
        halamanPermintaan.setVisible(false);
        detailRequest.setVisible(false);

        view.setVisible(true);
    }

    protected void openForm(Pane form) {
        filter.setVisible(true);
        form.setVisible(true);
    }

    protected void closeForm(Pane form) {
        filter.setVisible(false);
        form.setVisible(false);
    }

    protected void disableMenu() {
        setDisabled(true);
    }

    protected void enableMenu() {
        setDisabled(false);
    }
}
