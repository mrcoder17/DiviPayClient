package ru.nsu.boxberger.divipay.login;

public class LoginResponse {
    private String token;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
