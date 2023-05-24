package ru.nsu.boxberger.divipay.api;

import org.springframework.web.reactive.function.client.WebClient;
import ru.nsu.boxberger.divipay.model.ProfileModel;

public class ProfileApiClient {
    private static final String PROFILE_URL = "http://localhost:8080/api/profile";
    private final WebClient webClient;

    public ProfileApiClient() {
        this.webClient = WebClient.create();
    }

    public void getProfileData() {
        webClient.get()
                .uri(PROFILE_URL)
                .retrieve()
                .bodyToMono(ProfileModel.class)
                .subscribe(
                        profileModel -> {
                            System.out.println("Received profile data: " + profileModel);
                        },
                        error -> {
                            System.err.println("Error occurred while retrieving profile data: " + error.getMessage());
                        }
                );
    }
}
