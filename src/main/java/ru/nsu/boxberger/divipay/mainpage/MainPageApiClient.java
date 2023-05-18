package ru.nsu.boxberger.divipay.mainpage;

import org.springframework.web.reactive.function.client.WebClient;

public class MainPageApiClient {
    private static final String MAINPAGE_URL = "http://localhost:8080/mainpage";
    private final WebClient webClient;

    public MainPageApiClient() {
        this.webClient = WebClient.create();
    }

    public void getMainPageData() {
        webClient.get()
                .uri(MAINPAGE_URL)
                .retrieve()
                .bodyToMono(MainPageModel.class)
                .subscribe(
                        mainPageModel -> {
                            System.out.println("Received main page data: " + mainPageModel);
                        },
                        error -> {
                            System.err.println("Error occurred while retrieving main page data: " + error.getMessage());
                        }
                );
    }
}
