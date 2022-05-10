package model.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonOutput {

    private String clientId;
    private String channelId;
    private String orderId;
    private String fulfillmentId;
    private Map<String, ItemsOutput> items = new HashMap<>();
    private RefundOutput refund;
    private boolean refundProcessed;
    private ExtensionAttributesOutput extensionAttributes;
    private String placedAt;
    private String createdAt;
    private String status;

    public JsonOutput() {
    }

    public JsonOutput(String clientId, String channelId, String orderId, String fulfillmentId, RefundOutput refund, boolean refundProcessed, ExtensionAttributesOutput extensionAttributes, String placedAt, String createdAt, String status) {
        this.clientId = clientId;
        this.channelId = channelId;
        this.orderId = orderId;
        this.fulfillmentId = fulfillmentId;
        this.refund = refund;
        this.refundProcessed = refundProcessed;
        this.extensionAttributes = extensionAttributes;
        this.placedAt = placedAt;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFulfillmentId() {
        return fulfillmentId;
    }

    public void setFulfillmentId(String fulfillmentId) {
        this.fulfillmentId = fulfillmentId;
    }

    public Map<String, ItemsOutput> getItems() {
        return items;
    }

    public void setItems(Map<String, ItemsOutput> items) {
        this.items = items;
    }

    public RefundOutput getRefund() {
        return refund;
    }

    public void setRefund(RefundOutput refund) {
        this.refund = refund;
    }

    public boolean isRefundProcessed() {
        return refundProcessed;
    }

    public void setRefundProcessed(boolean refundProcessed) {
        this.refundProcessed = refundProcessed;
    }

    public ExtensionAttributesOutput getExtensionAttributes() {
        return extensionAttributes;
    }

    public void setExtensionAttributes(ExtensionAttributesOutput extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public String getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(String placedAt) {
        this.placedAt = placedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
