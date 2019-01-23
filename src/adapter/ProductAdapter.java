package adapter;

import entity.Product;
import helpers.ProductCell;
import javafx.scene.control.ListCell;

public class ProductAdapter extends ListCell<Product> {

    @Override
    protected void updateItem(Product product, boolean b) {
        super.updateItem(product, b);

        if (product != null) {
            ProductCell productCell = new ProductCell();
            productCell.setProductCell(product);
            setGraphic(productCell.getContainer());
        }
    }
}
