package com.diegofernandes.publictitlesapi.serialization;

import com.diegofernandes.publictitlesapi.model.Title;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class TitleSerializer extends JsonSerializer<Title> {

    @Override
    public void serialize(Title title, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("ID", title.getId());
        jsonGenerator.writeStringField("Nome", title.getName());
        jsonGenerator.writeStringField("Vencimento", title.getDueDate());
        jsonGenerator.writeEndObject();

    }

}
