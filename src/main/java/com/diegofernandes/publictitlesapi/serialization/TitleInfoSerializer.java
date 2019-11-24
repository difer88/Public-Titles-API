package com.diegofernandes.publictitlesapi.serialization;

import com.diegofernandes.publictitlesapi.model.TitleInfoDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@JsonComponent
public class TitleInfoSerializer extends JsonSerializer<TitleInfoDTO> {

    @Override
    public void serialize(TitleInfoDTO titleInfoDTO, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("ID", titleInfoDTO.getId());
        jsonGenerator.writeStringField("Nome", titleInfoDTO.getName());
        jsonGenerator.writeStringField("Vencimento", titleInfoDTO.getDueDate());
        jsonGenerator.writeStringField("Última cotação", titleInfoDTO.getQuoteTime());
        jsonGenerator.writeStringField("Taxa Compra", getRateFormatted(titleInfoDTO.getRatePurchase()));
        jsonGenerator.writeStringField("Taxa Venda", getRateFormatted(titleInfoDTO.getRateSale()));
        jsonGenerator.writeStringField("Valor Compra", getMonetaryValueFormatted(titleInfoDTO.getUnityValuePurchase()));
        jsonGenerator.writeStringField("Valor Venda", getMonetaryValueFormatted(titleInfoDTO.getUnityValueSale()));
        jsonGenerator.writeEndObject();

    }

    private static String getMonetaryValueFormatted(BigDecimal value) {
        DecimalFormat decFormat = new DecimalFormat("'R$ '0.##");
        return decFormat.format(value);
    }

    private static String getRateFormatted(Double rate) {
        String rateFormatted = String.valueOf(rate);
        return rateFormatted.replace(".", ",").concat(" %");
    }

}
