package ru.nsu.boxberger.divipay.mainpage;

import ru.nsu.boxberger.divipay.contacts.ContactsModel;
import ru.nsu.boxberger.divipay.profile.ProfileModel;
import ru.nsu.boxberger.divipay.purchases.PurchasesModel;
import ru.nsu.boxberger.divipay.requests.RequestsModel;

import java.util.List;

public class MainPageModel {
    private ProfileModel profileModel;
    private ContactsModel contactsModel;
    private PurchasesModel purchasesModel;
    private RequestsModel requestsModel;
//    private NavigationModel navigationModel;

    public MainPageModel(ProfileModel profileModel, ContactsModel contactsModel, PurchasesModel purchasesModel,
                         RequestsModel requestsModel) {
        this.profileModel = profileModel;
        this.contactsModel = contactsModel;
        this.purchasesModel = purchasesModel;
        this.requestsModel = requestsModel;
    }

    public void loadProfileData() {
        // Загрузка данных профиля
//        ProfileData profileData = profileModel.getProfileData("john");
        // Обновление представления главной страницы с данными профиля
    }

    public void loadContactsData() {
        // Загрузка данных контактов
//        List<ContactData> contactsData = contactsModel.getContactsData();
        // Обновление представления главной страницы с данными контактов
    }

    public void loadPurchasesData() {
        // Загрузка данных о покупках
//        List<PurchaseData> purchasesData = purchasesModel.getPurchasesData();
        // Обновление представления главной страницы с данными о покупках
    }

    public void loadRequestsData() {
        // Загрузка данных о запросах
//        List<RequestData> requestsData = requestsModel.getRequestsData();
        // Обновление представления главной страницы с данными о запросах
    }
}
