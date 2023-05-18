package ru.nsu.boxberger.divipay.about;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class AboutApiClient {
    private static final String ABOUT_URL = "http://localhost:8080/about";
    private final WebClient webClient;

    public AboutApiClient() {
        this.webClient = WebClient.create();
    }

    public void getAboutData() {
        try {
            AboutModel aboutModel = webClient.get()
                    .uri(ABOUT_URL)
                    .retrieve()
                    .bodyToMono(AboutModel.class)
                    .block();
            // Обработка полученных данных
            System.out.println("Received data: " + aboutModel);
        } catch (Exception e) {
            // Обработка ошибки
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
