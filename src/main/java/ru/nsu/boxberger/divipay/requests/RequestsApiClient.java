package ru.nsu.boxberger.divipay.requests;

import org.springframework.web.reactive.function.client.WebClient;

public class RequestsApiClient {
    private static final String REQUESTS_URL = "http://localhost:8080/requests";
    private final WebClient webClient;

    public RequestsApiClient() {
        this.webClient = WebClient.create();
    }

//    public void getRequestsData() {
//        webClient.get()
//                .uri(REQUESTS_URL)
//                .retrieve()
//                .bodyToMono(RequestsModel.class)
//                .subscribe(
//                        requestsModel -> {
//                            System.out.println("Received requests data: " + requestsModel);
//                        },
//                        error -> {
//                            System.err.println("Error occurred while retrieving requests data: " + error.getMessage());
//                        }
//                );
//    }
}
