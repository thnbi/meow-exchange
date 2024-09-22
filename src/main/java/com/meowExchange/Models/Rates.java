package com.meowExchange.Models;
import com.google.gson.Gson;
import com.meowExchange.Services.HttpService;
import com.meowExchange.Utils.ExchangeRateApiUrlBuilder;
import java.net.http.HttpResponse;
import java.util.Map;

public class Rates {
    private String currency;
    private Map<String, Double> conversionRate;
    Gson gson = new Gson();

    public Rates(HttpResponse<String> response) {
        if (response != null){
            RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
            this.currency = rateResponse.base_code();
            this.conversionRate = rateResponse.conversion_rates();
        }
    }

    public void updateRate(String currency){
        this.currency = currency;
        HttpService httpService = new HttpService();
        HttpResponse<String> response = httpService.sendRequest(ExchangeRateApiUrlBuilder.buildUrl(currency));
        
        Gson gson = new Gson();
        RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
        this.conversionRate = rateResponse.conversion_rates();
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public double getRate(String currency){
        return conversionRate.get(currency);
    }
}
