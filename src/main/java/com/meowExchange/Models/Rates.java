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

    public Rates(String currency, HttpResponse<String> response) {
        if (response != null){
            RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
            this.conversionRate = rateResponse.conversion_rate();
        }
        this.currency = currency;
    }

    public void updateRate(){
        HttpService httpService = new HttpService();
        HttpResponse<String> response = httpService.sendRequest(ExchangeRateApiUrlBuilder.buildUrl(currency));
        
        Gson gson = new Gson();
        RateResponse rateResponse = gson.fromJson(response.body(), RateResponse.class);
        this.conversionRate = rateResponse.conversion_rate();
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public double getRate(){
        return conversionRate.get(currency);
    }
}
