import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.input.ItemsInput;
import model.input.JsonInput;
import model.output.*;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //converte o JSON inicial para List
        List<String> jsonList = inputJsonAndConvertToList();

        System.out.println("\n-------------------------------------");

        //converte List para String
        StringBuilder jsonString = new StringBuilder();
        jsonList.forEach(x -> {
            jsonString.append(x);
        });

        //transforma a String para a classe JsonInput
        JsonInput jsonInput = gson.fromJson(jsonString.toString(), JsonInput.class);

        //transfere os dados de input, realiza as manipulações e retorna o output
        JsonOutput jsonOutput = transferData(jsonInput);

        //retorno dos dados para o usuário
        System.out.println(gson.toJson(jsonOutput));
    }

    public static List<String> inputJsonAndConvertToList() throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        System.out.println("Cole o JSON: ");

        String line = br.readLine();

        List<String> jsonList = new ArrayList<>();

        while (line != null) {
            jsonList.add(line);
            line = br.readLine();

            if (line.contains("]")) {
                jsonList.add("]");
                jsonList.add("}");
                break;
            }
        }

        return jsonList;
    }

    public static JsonOutput transferData(JsonInput jsonInput){
        JsonOutput jsonOutput = new JsonOutput();

        jsonOutput.setClientId(jsonInput.getClientId());
        jsonOutput.setChannelId(jsonInput.getChannelId());
        jsonOutput.setOrderId(jsonInput.getOrderId());
        jsonOutput.setFulfillmentId(jsonInput.getId());

        //items
        transferItems(jsonInput, jsonOutput);

        //refund
        transferRefund(jsonInput, jsonOutput);

        jsonOutput.setExtensionAttributes(new ExtensionAttributesOutput(
                                            jsonInput.getExtensionAttributes().isAcceptGiftcard(),
                                            jsonInput.getExtensionAttributes().getGiftcardCurrency(),
                                            jsonInput.getExtensionAttributes().getGiftcardType()
        ));

        jsonOutput.setPlacedAt(jsonInput.getProcessedAt());
        jsonOutput.setCreatedAt(Instant.now().toString());
        jsonOutput.setStatus("PENDING");

        return jsonOutput;
    }

    public static JsonOutput transferItems(JsonInput jsonInput, JsonOutput jsonOutput){
        for (ItemsInput item : jsonInput.getItems()) {
            jsonOutput.getItems().put(item.getSku(), new ItemsOutput(item.getSku(), item.getQuantity()));
        }
        return jsonOutput;
    }

    public static JsonOutput transferRefund(JsonInput jsonInput, JsonOutput jsonOutput){
        Double freightRefund = 0.0,
                itemsRefund = 0.0,
                refundValue;

        String refundType;
        boolean refundProcessed = false;

        for (ItemsInput item : jsonInput.getItems()) {
            freightRefund += item.getTotals().getProportionalShippingAmount();
            itemsRefund += item.getTotals().getPriceDiscounted();
        }
        refundValue = (freightRefund + itemsRefund);

        if(refundValue <= 100) refundType = "GIFTCARD";
        else if(refundValue > 100 && refundValue <= 300) refundType = "DEPOSIT";
        else refundType = "PAYMENT_VOID";

        jsonOutput.setRefund(new RefundOutput(refundValue, freightRefund, itemsRefund, refundType));

        if(refundType.equals("GIFTCARD") && freightRefund < 10) refundProcessed = true;

        jsonOutput.setRefundProcessed(refundProcessed);

        return jsonOutput;
    }
}

