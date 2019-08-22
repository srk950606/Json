package com.jack.common.action.vo.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeStampDeserialize extends JsonDeserializer<LocalDateTime> {
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String data = p.readValueAs(String.class);
        if (data == null || data.length() == 0) {
            return null;
        }
        Timestamp timestamp = Timestamp.valueOf(data);
        return timestamp.toLocalDateTime();

    }
}
