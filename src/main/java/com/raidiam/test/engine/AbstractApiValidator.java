package com.raidiam.test.engine;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractApiValidator extends AbstractTestStep {

    private RestTemplate restTemplate = new RestTemplate();
    private Gson gson = new Gson();

    @Override
    public void execute(Context context) {
        String url = context.getProperty("resource_url");
        String method = context.getProperty("resource_method");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "application/json");
        httpHeaders.add("Content-Type", "application/json");

        HttpEntity<?> request = new HttpEntity<>(null, httpHeaders);;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.resolve(method), request, String.class);
        JsonObject responseEntity = gson.fromJson(response.getBody(), JsonObject.class);
        context.addProperty("resource_response_status", response.getStatusCodeValue());
        context.addProperty("resource_response_body", responseEntity);
        evaluate(context);
    }

    public abstract void evaluate(Context context);

}
