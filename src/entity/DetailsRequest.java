package entity;

public class DetailsRequest extends Product {

    private int request;
    private int approve;

    public DetailsRequest(String productName, int productStock, String productUnit, int req, int appr) {
        super(productName, productStock, productUnit);
        request = req;
        approve = appr;

    }

    public int getRequest() {
        return request;
    }

    public int getApprove() {
        return approve;
    }
}
