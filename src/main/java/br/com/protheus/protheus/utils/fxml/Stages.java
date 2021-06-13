package br.com.protheus.protheus.utils.fxml;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Stages {

    public static Stage getStage(final Button button){
        return (Stage) button.getScene().getWindow();
    }

}
