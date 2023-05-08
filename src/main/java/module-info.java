module com.example.divipay {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.nsu.boxberger.divipay to javafx.fxml;
    exports ru.nsu.boxberger.divipay;
}