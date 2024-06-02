package ru.bryanin.dev.middle.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.io.IOException;

public class Util {
    public static Long customerIdFromJsonToLong(@NonNull String body) throws Exception {
        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = om.readTree(body);
        } catch (IOException e) {
            throw new IOException("Ошибка чтения JSON");
        }
        String telegramIdString = null;
        try {
            telegramIdString = jsonNode.get("telegramId").toString();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Значение telegramId не найдено");
        }
        Long telegramId = null;
        try {
            telegramIdString = telegramIdString.replaceAll("[^0-9]", "");
            telegramId = Long.parseLong(telegramIdString);
        } catch (ClassCastException e) {
            throw new ClassCastException("Переданное значение telegramId не может быть приведено к типу Long");
        }
        return telegramId;
    }

}
