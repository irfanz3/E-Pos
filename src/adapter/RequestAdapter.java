package adapter;

import entity.Request;
import helpers.RequestCell;
import javafx.scene.control.ListCell;

public class RequestAdapter extends ListCell<Request> {

    @Override
    protected void updateItem(Request request, boolean b) {
        super.updateItem(request, b);

        if (request != null) {
            RequestCell requestCell = new RequestCell();
            requestCell.setRequestCell(request);
            setGraphic(requestCell.getContainer());
        }
    }
}
