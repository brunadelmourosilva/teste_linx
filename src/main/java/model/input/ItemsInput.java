package model.input;

public class ItemsInput {

    private String sku;
    private String name;
    private Integer quantity;
    private String stockType;
    private String itemType;
    private TotalsInput totals;

    public ItemsInput() {
    }

    public ItemsInput(String sku, String name, Integer quantity, String stockType, String itemType, TotalsInput totals) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.stockType = stockType;
        this.itemType = itemType;
        this.totals = totals;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public TotalsInput getTotals() {
        return totals;
    }

    public void setTotals(TotalsInput totals) {
        this.totals = totals;
    }
}
