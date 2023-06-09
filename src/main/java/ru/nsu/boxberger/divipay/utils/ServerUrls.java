package ru.nsu.boxberger.divipay.utils;

public final class ServerUrls {
    public static final String BASE_URL = "http://localhost:8080";
    public static final String USERS_URL = BASE_URL + "/api/users";
    public static final String PURCHASES_URL = BASE_URL + "/api/purchases";
    public static final String PAYMENTS_URL = BASE_URL + "/api/payments";
    public static final String REQUESTS_URL = BASE_URL + "/api/requests";
    public static final String LOGIN_URL = BASE_URL + "/api/login";
    public static final String REGISTRATION_URL = BASE_URL + "/api/registration";

    private ServerUrls() {
    }
}
