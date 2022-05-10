import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.input.JsonInput;
import model.output.JsonOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ApplicationTest {

    @Test
    @DisplayName("Should return Items created")
    public void transferItemsTest(){
        //transforma a String(formato JSON) para a classe JsonInput
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonInput jsonInputObject = gson.fromJson(jsonInput(), JsonInput.class);

        String jsonItems = createItems();

        JsonOutput jsonOutput = new JsonOutput();

        Application.transferItems(jsonInputObject, jsonOutput); //retorna o objeto JsonOutput
        assertEquals(jsonItems, gson.toJson(jsonOutput));
    }

    @Test
    @DisplayName("Should return Refund created")
    public void transferRefundTest(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonInput jsonInput = gson.fromJson(jsonInput(), JsonInput.class);

        String jsonRefund = createRefund();

        JsonOutput jsonOutput = new JsonOutput();

        Application.transferRefund(jsonInput, jsonOutput);
        assertEquals(jsonRefund, gson.toJson(jsonOutput));
    }

    public String createItems(){
        return  "{\n" +
                "  \"items\": {\n" +
                "    \"100085110\": {\n" +
                "      \"sku\": \"100085110\",\n" +
                "      \"quantity\": 1\n" +
                "    },\n" +
                "    \"100080466\": {\n" +
                "      \"sku\": \"100080466\",\n" +
                "      \"quantity\": 1\n" +
                "    },\n" +
                "    \"982440469\": {\n" +
                "      \"sku\": \"982440469\",\n" +
                "      \"quantity\": 1\n" +
                "    }\n" +
                "  },\n" +
                "  \"refundProcessed\": false\n" +
                "}";
    }

    public String createRefund(){
        return "{\n" +
                "  \"items\": {},\n" +
                "  \"refund\": {\n" +
                "    \"refundValue\": 1778.3,\n" +
                "    \"freightRefund\": 8.33,\n" +
                "    \"itemsRefund\": 1769.97,\n" +
                "    \"refundType\": \"PAYMENT_VOID\"\n" +
                "  },\n" +
                "  \"refundProcessed\": false\n" +
                "}";
    }

    public String jsonInput(){
        return "{    \"id\": \"F1\",    \"orderId\": \"003666\",    \"channelId\": \"site\",    \"clientId\": \"sony\",    \"status\": \"TREATMENT\",    \"extensionAttributes\": {        \"acceptGiftcard\": true,        \"giftcardCurrency\": \"USD\",        \"giftcardType\": \"GIFTCARD\"    },    \"createdAt\": \"2022-04-08T07:06:18.000Z\",    \"processedAt\": \"2022-04-29T13:49:03.000Z\",    \"items\": [        {            \"sku\": \"100085110\",            \"name\": \"PlayStation 4 500GB Console\",            \"quantity\": 1,            \"stockType\": \"PHYSICAL\",            \"itemType\": \"CONSOLE\",            \"totals\": {                \"price\": 1599.99,                \"totalAmount\": 1604.99,                \"priceDiscounted\": 1599.99,                \"proportionalShippingAmount\": 5            }        },        {            \"sku\": \"100080466\",            \"name\": \"Dark souls 3\",            \"quantity\": 1,            \"stockType\": \"PHYSICAL\",            \"itemType\": \"GAME\",            \"totals\": {                \"price\": 129.99,                \"totalAmount\": 133.32,                \"priceDiscounted\": 129.99,                \"proportionalShippingAmount\": 3.33            }        },        {            \"sku\": \"982440469\",            \"name\": \"Tribes of Midgard\",            \"quantity\": 1,            \"stockType\": \"DIGITAL\",            \"itemType\": \"OTHER\",            \"totals\": {                \"price\": 39.99,                \"totalAmount\": 39.99,                \"priceDiscounted\": 39.99,                \"proportionalShippingAmount\": 0            }        }]}\n";
    }

}
