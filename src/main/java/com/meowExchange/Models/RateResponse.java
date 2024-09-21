package com.meowExchange.Models;

import java.util.Map;

public record RateResponse(String result, String time_next_update_utc, Map<String, Double> conversion_rate ) {
}
