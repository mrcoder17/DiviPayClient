package ru.nsu.boxberger.divipay.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class BaseService {
    public <T> ResponseEntity<T> requestToServer(Object request, String URL, HttpMethod method, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(request, httpHeaders);

        return restTemplate.exchange(URL, method, requestEntity, responseType);
    }
}
