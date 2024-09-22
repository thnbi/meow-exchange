package com.meowExchange.Models;

import com.google.gson.Gson;
import com.meowExchange.Services.HttpService;
import com.meowExchange.Utils.ExchangeRateApiUrlBuilder;

import java.net.http.HttpResponse;

public class ExchangeRateApiClient {
    private final HttpService httpService;

    public ExchangeRateApiClient() {
        this.httpService = new HttpService();
    }

    public ApiResponse getExchangeRate(String currency) {
        String url = ExchangeRateApiUrlBuilder.buildUrl(currency);
        HttpResponse<String> response = httpService.sendRequest(url);
        response.statusCode();
        Gson gson = new Gson();

        return gson.fromJson(response.body(), ApiResponse.class);
    }

    public ApiResponse updateExchangeRate(String currency) {
        return getExchangeRate(currency);
    }
}
