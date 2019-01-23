package adapter;

import controller.HomeController;
import entity.Product;
import helpers.ProductCell;
import javafx.scene.control.ListCell;

public class ProductAdapter extends ListCell<Product> {

    private HomeController controller;

    public ProductAdapter(HomeController parent) {
        controller = parent;
    }

    @Override
    protected void updateItem(Product product, boolean b) {
        super.updateItem(product, b);

        if (product != null) {
            ProductCell productCell = new ProductCell(controller, getIndex());
            productCell.setProductCell(product);
            setGraphic(productCell.getContainer());
        }
    }
}
