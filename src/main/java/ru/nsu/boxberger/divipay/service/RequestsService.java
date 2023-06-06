package ru.nsu.boxberger.divipay.service;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class RequestsService extends BaseService{

    public void createRequest(RequestsModel request) {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(request, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
