package model.output;

public class ItemsOutput {

    private String sku;
    private Integer quantity;

    public ItemsOutput(String sku, Integer quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public ItemsOutput() {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
