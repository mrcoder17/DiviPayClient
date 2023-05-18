package ru.nsu.boxberger.divipay.purchases;

import org.springframework.web.reactive.function.client.WebClient;

public class PurchasesApiClient {
    private static final String PURCHASES_URL = "http://localhost:8080/purchases";
    private final WebClient webClient;

    public PurchasesApiClient() {
        this.webClient = WebClient.create();
    }

    public void getPurchasesData() {
        webClient.get()
                .uri(PURCHASES_URL)
                .retrieve()
                .bodyToMono(PurchasesModel.class)
                .subscribe(
                        purchasesModel -> {
                            System.out.println("Received purchases data: " + purchasesModel);
                        },
                        error -> {
                            System.err.println("Error occurred while retrieving purchases data: " + error.getMessage());
                        }
                );
    }
}
