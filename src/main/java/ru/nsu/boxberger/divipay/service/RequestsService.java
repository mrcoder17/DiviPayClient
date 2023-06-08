package ru.nsu.boxberger.divipay.service;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.nsu.boxberger.divipay.model.PurchaseModel;
import ru.nsu.boxberger.divipay.model.RequestModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class RequestsService extends BaseService {

    public void createRequest(RequestModel request) {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<RequestModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<RequestModel> responseEntity = requestToServer(request, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

    public void deleteRequest(RequestModel request) {
        String url = ServerUrls.REQUESTS_URL + "/" + request.getRequestID();
        ParameterizedTypeReference<RequestModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<RequestModel> responseEntity = requestToServer(request, url, HttpMethod.DELETE, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful deleted");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

    public void createPurchaseFromRequest (PurchaseModel purchase){
        String url = ServerUrls.PURCHASES_URL;
        ParameterizedTypeReference<PurchaseModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PurchaseModel> responseEntity = requestToServer(purchase, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Purchase successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public RequestModel getRequestById (Long id){
        String url = ServerUrls.REQUESTS_URL + "/" + id;
        ParameterizedTypeReference<RequestModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<RequestModel> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful created");
            return responseEntity.getBody();
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
        return null;
    }
}
