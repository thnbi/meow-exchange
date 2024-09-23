package com.meowExchange.Utils;

import com.meowExchange.Models.ApiResponse;
import com.meowExchange.Models.ExchangeRateApiClient;
import com.meowExchange.Models.ExchangeRateData;

public class ExchangeRateUtil {
    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        ApiResponse response = new ExchangeRateApiClient().getExchangeRate(fromCurrency);
        ExchangeRateData exchangeRateData = new ExchangeRateData(response);
        System.out.println("Exchange rate: " + exchangeRateData.getRate(fromCurrency, toCurrency));
        return Calculator.convert(amount, exchangeRateData.getRate(fromCurrency, toCurrency));
    }

    public static void updateExchangeRate(String currency) {
        ApiResponse response = new ExchangeRateApiClient().updateExchangeRate(currency);
        ExchangeRateData exchangeRateData = new ExchangeRateData(response);
    }
}
