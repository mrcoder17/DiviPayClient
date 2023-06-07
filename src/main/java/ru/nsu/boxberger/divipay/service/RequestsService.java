package ru.nsu.boxberger.divipay.service;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.model.RequestsModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class RequestsService extends BaseService {

    public void createRequest(RequestsModel request) {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(request, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

    public void deleteRequest(RequestsModel request) {
        String url = ServerUrls.REQUESTS_URL;
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(request, url, HttpMethod.DELETE, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful deleted");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

    public void createPurchaseFromRequest (PurchasesModel purchase){
        String url = ServerUrls.PURCHASES_URL;
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(purchase, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Purchase successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
    public RequestsModel getRequestById (Long id){
        String url = ServerUrls.REQUESTS_URL + "/" + id;
        ParameterizedTypeReference<RequestsModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<RequestsModel> responseEntity = requestToServer(null, url, HttpMethod.GET, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Request successful created");
            return responseEntity.getBody();
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
        return null;
    }
}
