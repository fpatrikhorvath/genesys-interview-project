package com.genesys.framework.rest;

import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class RestClient {
    private static final Logger       logger = LogManager.getLogger(RestClient.class);
    private final        String       baseUrl;
    private final        OkHttpClient client;
    private final        Headers      headers;

    public RestClient(final String baseUrl, final Map<String, String> headersMap) {
        this.baseUrl = baseUrl;
        this.client  = new OkHttpClient();

        // Convert Map to Headers for OkHttp
        Headers.Builder headersBuilder = new Headers.Builder();
        headersMap.forEach(headersBuilder::add);
        this.headers = headersBuilder.build();
    }

    // Method to perform GET requests
    public String GET(final String endpoint) throws IOException {
        final String url = baseUrl + endpoint;
        final Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();

        try (final Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }
}
