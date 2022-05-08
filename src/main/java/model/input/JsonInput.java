package model.input;

//https://gist.github.com/guilhermefainer/40876d3c4149640b4ce8d20bcb14f6c7

//https://gist.github.com/guilhermefainer/5e63d22573a85a24f14f8f8cb969138e

import java.util.ArrayList;
import java.util.List;

public class JsonInput {

    private String id; //fulfillmentId
    private String orderId;
    private String channelId;
    private String clientId;
    private String status;
    private ExtensionAttributesInput extensionAttributes;
    private String createdAt; //não copiar o campo - colocar output => Instant.now().toString()
    private String processedAt;
    private List<ItemsInput> items = new ArrayList<>();

    public JsonInput() {
    }

    public JsonInput(String id, String orderId, String channelId, String clientId, String status, ExtensionAttributesInput extensionAttributes, String processedAt) {
        this.id = id;
        this.orderId = orderId;
        this.channelId = channelId;
        this.clientId = clientId;
        this.status = status;
        this.extensionAttributes = extensionAttributes;
        this.processedAt = processedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExtensionAttributesInput getExtensionAttributes() {
        return extensionAttributes;
    }

    public void setExtensionAttributes(ExtensionAttributesInput extensionAttributes) {
        this.extensionAttributes = extensionAttributes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public List<ItemsInput> getItems() {
        return items;
    }

    public void setItems(List<ItemsInput> items) {
        this.items = items;
    }
}
