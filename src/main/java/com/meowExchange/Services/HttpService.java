package com.meowExchange.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpService {
    private final HttpClient client;

    public HttpService() {
        this.client = HttpClient.newHttpClient();
    }

    private HttpRequest createRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }

    public HttpResponse<String> sendRequest(String url) {
        try {
            HttpRequest request = createRequest(url);
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
