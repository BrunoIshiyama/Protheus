package br.com.protheus.protheus;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProtheusApplication {

    public static void main(String[] args) {
        Application.launch(ProtheusUiApplication.class, args);
    }

}
