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
    requires com.fasterxml.jackson.annotation;

    opens ru.nsu.boxberger.divipay to javafx.fxml;
    exports ru.nsu.boxberger.divipay;
    exports ru.nsu.boxberger.divipay.controller;
    opens ru.nsu.boxberger.divipay.controller to javafx.fxml;
    exports ru.nsu.boxberger.divipay.model;
    opens ru.nsu.boxberger.divipay.model to javafx.fxml;
    exports ru.nsu.boxberger.divipay.api;
    opens ru.nsu.boxberger.divipay.api to javafx.fxml;


}