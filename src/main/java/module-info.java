module ru.nsu.boxberger.divipay {

    requires javafx.controls;
    requires javafx.fxml;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.rmi;
    requires spring.context;
    requires spring.web;
    requires spring.webmvc;
    requires spring.boot.starter;
    requires spring.core;
    requires spring.beans;
    requires java.sql;
    requires spring.jdbc;
    requires spring.webflux;
    requires reactor.core;

//    opens ru.nsu.boxberger.divipay.server;
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
//    exports ru.nsu.boxberger.divipay.server;


}