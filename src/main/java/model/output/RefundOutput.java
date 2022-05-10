package model.output;

public class RefundOutput {

    private Double refundValue;
    private Double freightRefund;
    private Double itemsRefund;
    private String refundType;

    public RefundOutput() {
    }

    public RefundOutput(Double refundValue, Double freightRefund, Double itemsRefund, String refundType) {
        this.refundValue = refundValue;
        this.freightRefund = freightRefund;
        this.itemsRefund = itemsRefund;
        this.refundType = refundType;
    }

    public Double getRefundValue() {
        return refundValue;
    }

    public void setRefundValue(Double refundValue) {
        this.refundValue = refundValue;
    }

    public Double getFreightRefund() {
        return freightRefund;
    }

    public void setFreightRefund(Double freightRefund) {
        this.freightRefund = freightRefund;
    }

    public Double getItemsRefund() {
        return itemsRefund;
    }

    public void setItemsRefund(Double itemsRefund) {
        this.itemsRefund = itemsRefund;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }
}
