package com.meowExchange.Utils;

public class ExchangeRateApiUrlBuilder {
    public static String buildUrl(String currency) {
        String url =
                "https://v6.exchangerate-api.com/v6/" +
                        System.getenv("API_KEY") + "/latest/" +
                        currency.toUpperCase();
        return url;
    }
}
