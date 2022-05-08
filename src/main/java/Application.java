import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.input.ItemsInput;
import model.input.JsonInput;
import model.output.ExtensionAttributesOutput;
import model.output.ItemsOutput;
import model.output.JsonOutput;
import model.output.RefundOutput;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static Scanner SC = new Scanner(System.in);
    //estudar classe e explicar README
    //https://www.devmedia.com.br/classes-de-entrada-e-saida-de-dados-em-java/26029
    //https://code-examples.net/pt/q/4b5cb

    public static void main(String[] args) throws Exception {

        InputStream is = System.in;
        System.out.print("Digite o JSON: ");

        //input do JSON
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String digitado = br.readLine();

        List<String> jsonList = new ArrayList<>();
        while (digitado != null) {
            jsonList.add(digitado);
            digitado = br.readLine();

            if (digitado.contains("]")) {
                jsonList.add("]");
                jsonList.add("}");
                break;
            }
        }

        //converter List para string
        StringBuilder jsonString = new StringBuilder();
        jsonList.forEach(line -> {
            jsonString.append(line);

        });

        //transforma em json object para a classe JsonInput
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonInput jsonInput = gson.fromJson(jsonString.toString(), JsonInput.class);

        //passar jsoninput para jsonoutput
        JsonOutput jsonOutput = transferData(jsonInput);

        System.out.println(gson.toJson(jsonOutput));
    }

    public static JsonOutput transferData(JsonInput jsonInput){
        JsonOutput jsonOutput = new JsonOutput();

        jsonOutput.setClientId(jsonInput.getClientId());
        jsonOutput.setChannelId(jsonInput.getChannelId());
        jsonOutput.setOrderId(jsonInput.getOrderId());
        jsonOutput.setFulfillmentId(jsonInput.getId());

        //items
        for (ItemsInput item : jsonInput.getItems())
            jsonOutput.getItems().add(new ItemsOutput(item.getSku(), item.getQuantity()));

        //refund's
        Double freightRefund = 0.0;
        Double itemsRefund = 0.0;
        Double refundValue; //converter para int
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

        //demais campos
        jsonOutput.setExtensionAttributes(new ExtensionAttributesOutput(
                                            jsonInput.getExtensionAttributes().isAcceptGiftcard(),
                                            jsonInput.getExtensionAttributes().getGiftcardCurrency(),
                                            jsonInput.getExtensionAttributes().getGiftcardType()
        ));

        jsonOutput.setPlacedAt(jsonInput.getProcessedAt());
        jsonOutput.setCreatedAt(Instant.now().toString());
        jsonOutput.setStatus("PENDING"); //MUDAR TREATMENT PARA PENDING -> DÚVIDA


        return jsonOutput;
    }
}

