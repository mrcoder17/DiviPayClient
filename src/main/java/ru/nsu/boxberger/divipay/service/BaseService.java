package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.nsu.boxberger.divipay.model.*;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

import java.util.*;

public class BaseService {
    private static final RestTemplate restTemplate;
    private static final Map<Long, UserRequest> userMap = new HashMap<>();
    private static final Map<Long, PurchasesModel> purchaseMap = new HashMap<>();
    private static final Map<Long, RequestsModel> requestMap = new HashMap<>();
    private static final Map<Long, PaymentModel> paymentMap = new HashMap<>();


    private static final ProfileModel profileModel = ProfileModel.getInstance();

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

    public static List<UserRequest> getUsersFromServer() {
        String url = ServerUrls.USERS_URL;
        ParameterizedTypeReference<List<UserRequest>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<UserRequest>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<UserRequest> users = responseEntity.getBody();
            for (UserRequest user : users) {
                userMap.put(user.getUserID(), user);
            }
            return users;
        } else {
            throw new RuntimeException("Failed to retrieve usernames from server. Status code: " + responseEntity.getStatusCode().value());
        }
    }


    public static List<PurchasesModel> getPurchasesFromServer() {
        String url = ServerUrls.PURCHASES_URL;
        ParameterizedTypeReference<List<PurchasesModel>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<PurchasesModel>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<PurchasesModel> purchases = responseEntity.getBody();
            List<PaymentModel> payments = getPaymentsFromServer();
            for (PurchasesModel purchase : purchases) {

                updatePayments(payments, purchase);
                Long userID = purchase.getUserID();
                if (userMap.containsKey(userID)) {
                    purchase.setUsername(userMap.get(userID).getUsername());
                } else {
                    throw new RuntimeException("User not found for userID: " + userID);
                }

                purchaseMap.put(purchase.getPurchaseID(), purchase);
            }
            return purchases;
        } else {
            return Collections.emptyList();
        }
    }

    public static List<RequestsModel> getRequestsFromServer() {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<List<RequestsModel>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<RequestsModel>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<RequestsModel> requests = responseEntity.getBody();

            for (RequestsModel request : requests) {
                Long userID = request.getUserID();
                if (userMap.containsKey(userID)) {
                    request.setUsername(userMap.get(userID).getUsername());
                } else {
                    throw new RuntimeException("User not found for userID: " + userID);
                }
                requestMap.put(request.getRequestID(), request);
            }
            return requests;
        } else {
            return Collections.emptyList();
        }
    }

    public static List<PaymentModel> getPaymentsFromServer() {
        String url = ServerUrls.PAYMENTS_URL;
        ParameterizedTypeReference<List<PaymentModel>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<PaymentModel>> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            List<PaymentModel> payments = responseEntity.getBody();
            for (PaymentModel payment : payments) {
                paymentMap.put(payment.getPurchaseID(), payment);
            }
            return payments;
        } else {
            return Collections.emptyList();
        }
    }

    public static void updatePayments(List<PaymentModel> payments, PurchasesModel purchase) {
        for (PaymentModel payment : payments) {
            if (payment.getUserID().equals(profileModel.getUserID()) && payment.getPurchaseID().equals(purchase.getPurchaseID())) {
                purchase.setPaid(true);
            }
        }
    }
}
