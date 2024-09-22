package com.meowExchange.Models;

import java.util.Map;

public class ExchangeRateData {
    String result;
    String timeNextUpdateUtc;
    String baseCurrency;
    Map<String, Double> conversionRates;

    public ExchangeRateData(ApiResponse apiResponse) {
        this.result = apiResponse.result();
        this.timeNextUpdateUtc = apiResponse.time_next_update_utc();
        this.baseCurrency = apiResponse.base_code();
        this.conversionRates = apiResponse.conversion_rates();
    }

    public double getRate(String fromCurrency, String toCurrency) {
        if (!fromCurrency.equals(baseCurrency)) {
            updateExchangeRate(fromCurrency);
        }
        return conversionRates.get(toCurrency);
    }

    public void updateExchangeRate(String currency) {
        ExchangeRateApiClient exchangeRateApiClient = new ExchangeRateApiClient();
        ApiResponse response = exchangeRateApiClient.updateExchangeRate(currency);
        this.baseCurrency = response.base_code();
        this.conversionRates = response.conversion_rates();
        this.result = response.result();
        if (!result.equals("success")) {
            throw new RuntimeException("Failed to update exchange rate data");
        }
    }
}
