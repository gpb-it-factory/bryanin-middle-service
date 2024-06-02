package ru.bryanin.dev.middle.utils;

public enum BotResponse {
    CODE_204("Регистрация прошла успешно"),
    CODE_5xx("Ошибка на сервере"),
    CODE_4xx("Ошибка в запросе"),
    CODE_409("Пользователь был зарегистрирован ранее"),
    UNKNOWN_ERROR("Произошла неизвестная ошибка");

    private String description;

    BotResponse(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
