package model.input;

public class Totals {

    private Double price;
    private Double totalAmount;
    private Double priceDiscounted;
    private Double proportionalShippingAmount;

    public Totals() {
    }

    public Totals(Double price, Double totalAmount, Double priceDiscounted, Double proportionalShippingAmount) {
        this.price = price;
        this.totalAmount = totalAmount;
        this.priceDiscounted = priceDiscounted;
        this.proportionalShippingAmount = proportionalShippingAmount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPriceDiscounted() {
        return priceDiscounted;
    }

    public void setPriceDiscounted(Double priceDiscounted) {
        this.priceDiscounted = priceDiscounted;
    }

    public Double getProportionalShippingAmount() {
        return proportionalShippingAmount;
    }

    public void setProportionalShippingAmount(Double proportionalShippingAmount) {
        this.proportionalShippingAmount = proportionalShippingAmount;
    }

    @Override
    public String toString() {
        return "Totals{" +
                "price=" + price +
                ", totalAmount=" + totalAmount +
                ", priceDiscounted=" + priceDiscounted +
                ", proportionalShippingAmount=" + proportionalShippingAmount +
                '}';
    }
}
