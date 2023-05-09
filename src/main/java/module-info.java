module com.example.divipay {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.boxberger.divipay to javafx.fxml;
    exports ru.nsu.boxberger.divipay;
    exports ru.nsu.boxberger.divipay.purchases;
    opens ru.nsu.boxberger.divipay.purchases to javafx.fxml;
    exports ru.nsu.boxberger.divipay.about;
    opens ru.nsu.boxberger.divipay.about to javafx.fxml;
    exports ru.nsu.boxberger.divipay.contacts;
    opens ru.nsu.boxberger.divipay.contacts to javafx.fxml;
    exports ru.nsu.boxberger.divipay.login;
    opens ru.nsu.boxberger.divipay.login to javafx.fxml;
    exports ru.nsu.boxberger.divipay.mainpage;
    opens ru.nsu.boxberger.divipay.mainpage to javafx.fxml;
    exports ru.nsu.boxberger.divipay.profile;
    opens ru.nsu.boxberger.divipay.profile to javafx.fxml;
    exports ru.nsu.boxberger.divipay.requests;
    opens ru.nsu.boxberger.divipay.requests to javafx.fxml;
}