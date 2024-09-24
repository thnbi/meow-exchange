package com.meowExchange.Utils;

import io.github.cdimascio.dotenv.Dotenv;

public class ExchangeRateApiUrlBuilder {
    public static String buildUrl(String currency) {
        Dotenv dotenv = Dotenv.configure()
                .systemProperties()
                .load();
        String apiKey = System.getProperty("API_KEY");

        return "https://v6.exchangerate-api.com/v6/" +
                apiKey + "/latest/" +
                currency.toUpperCase();
    }
}
