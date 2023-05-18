package ru.nsu.boxberger.divipay.contacts;

import org.springframework.web.reactive.function.client.WebClient;

public class ContactsApiClient {
    private static final String CONTACTS_URL = "http://localhost:8080/contacts";
    private final WebClient webClient;

    public ContactsApiClient() {
        this.webClient = WebClient.create();
    }

    public void getContactsData() {
        webClient.get()
                .uri(CONTACTS_URL)
                .retrieve()
                .bodyToMono(ContactsModel.class)
                .subscribe(
                        contactsModel -> {
                            System.out.println("Received contacts data: " + contactsModel);
                        },
                        error -> {
                            System.err.println("Error occurred while retrieving contacts data: " + error.getMessage());
                        }
                );
    }
}
