package ru.nsu.boxberger.divipay.login;

import org.springframework.web.reactive.function.client.WebClient;

public class LoginApiClient {
    private static final String LOGIN_URL = "http://localhost:8080/login";
    private final WebClient webClient;

    public LoginApiClient() {
        this.webClient = WebClient.create();
    }

    public void performLogin(String username, String password) {

        LoginModel loginModel = new LoginModel(username, password);

        webClient.post()
                .uri(LOGIN_URL)
                .bodyValue(loginModel)
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .subscribe(
                        loginResponse -> {
                            System.out.println("Login successful. Token: " + loginResponse.getToken());
                        },
                        error -> {
                            System.err.println("Error occurred during login: " + error.getMessage());
                        }
                );
    }
}
