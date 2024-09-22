package com.meowExchange.Models;

import java.util.Map;

public record ApiResponse(String result, String time_next_update_utc, String base_code,
                          Map<String, Double> conversion_rates) {
}
