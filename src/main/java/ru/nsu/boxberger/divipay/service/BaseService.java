package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.model.UserRequest;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.util.List;

public class BaseService {
    private static final RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
    }

    public static <T> ResponseEntity<T> requestToServer(Object request, String URL, HttpMethod method, ParameterizedTypeReference<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(request, httpHeaders);
        return restTemplate.exchange(URL, method, requestEntity, responseType);
    }

    public static UserRequest getUserFromServer(Long id) {
        String url = ServerUrls.USERS_URL + "/" + id;
        ParameterizedTypeReference<UserRequest> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<UserRequest> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve user from server. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public static List<String> getUsernamesFromServer() {
        String url = ServerUrls.USERS_URL;
        ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<String>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve usernames from server. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public static List<PurchasesModel> getPurchasesFromServer() {
        String url = ServerUrls.PURCHASES_URL;
        ParameterizedTypeReference<List<PurchasesModel>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<PurchasesModel>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<PurchasesModel> purchases = responseEntity.getBody();
            for (PurchasesModel purchase : purchases) {
                UserRequest user = getUserFromServer(purchase.getUserID());
                purchase.setUsername(user.getUsername());
            }
            return purchases;
        } else {
            throw new RuntimeException("Failed to retrieve purchases from server. Status code: " + responseEntity.getStatusCodeValue());
        }
    }

    public static List<RequestsModel> getRequestsFromServer() {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<List<RequestsModel>> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<List<RequestsModel>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<RequestsModel> requests = responseEntity.getBody();
            for (RequestsModel request : requests) {
                UserRequest user = getUserFromServer(request.getUserID());
                request.setUsername(user.getUsername());
            }
            return requests;
        } else {
            throw new RuntimeException("Failed to retrieve requests from server. Status code: " + responseEntity.getStatusCodeValue());
        }
    }
}
