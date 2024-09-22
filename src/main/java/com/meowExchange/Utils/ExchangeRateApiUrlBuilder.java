package com.meowExchange.Utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeRateApiUrlBuilder {
    public static String buildUrl(String currency) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        return "https://v6.exchangerate-api.com/v6/" +
                apiKey + "/latest/" +
                currency.toUpperCase();
    }
}
