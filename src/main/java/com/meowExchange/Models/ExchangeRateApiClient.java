package com.meowExchange.Models;

import com.meowExchange.Services.HttpService;
import com.meowExchange.Utils.ExchangeRateApiUrlBuilder;

import java.net.http.HttpResponse;

public class ExchangeRateApiClient {
    private final HttpService httpService;

    public ExchangeRateApiClient() {
        this.httpService = new HttpService();
    }

    public HttpResponse<String> getExchangeRate(String currency) {
        String url = ExchangeRateApiUrlBuilder.buildUrl(currency);
        return httpService.sendRequest(url);
    }
}
