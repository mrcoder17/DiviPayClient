package ru.nsu.boxberger.divipay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationRequest {
    @JsonProperty ("username")
    private String username;
    @JsonProperty ("password")
    private String password;


    public AuthorizationRequest() {
    }

    public AuthorizationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
