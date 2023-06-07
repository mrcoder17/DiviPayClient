package ru.nsu.boxberger.divipay.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import ru.nsu.boxberger.divipay.model.PaymentModel;
import ru.nsu.boxberger.divipay.model.PurchasesModel;
import ru.nsu.boxberger.divipay.utils.ServerUrls;

public class PurchasesService extends BaseService {

    public void createPurchase(PurchasesModel purchase) {
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

    public void updatePurchase(PurchasesModel updatePurchase) {
        String url = ServerUrls.PURCHASES_URL + "/" + updatePurchase.getPurchaseID();
        ParameterizedTypeReference<PurchasesModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PurchasesModel> responseEntity = requestToServer(updatePurchase, url, HttpMethod.PUT, responseType);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Purchase successful updated");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }

    public void createPayment(PaymentModel paymentModel) {
        String url = ServerUrls.PAYMENTS_URL;
        ParameterizedTypeReference<PaymentModel> responseType = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<PaymentModel> responseEntity = requestToServer(paymentModel, url, HttpMethod.POST, responseType);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            System.out.println("Payment successfully created");
        } else {
            System.err.println("Failed: " + responseEntity.getStatusCode().value());
        }
    }
}
