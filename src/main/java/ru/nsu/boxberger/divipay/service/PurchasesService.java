package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class PurchasesService extends BaseService{

    public void createPurchase(PurchasesModel purchase){
        String url = ServerUrls.PURCHASES_URL;
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {};
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(purchase, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Purchase successful created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

}
