package br.com.protheus.protheus.fxml.controllers;

import br.com.protheus.protheus.usecases.fxml.ChangeScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.protheus.protheus.domains.enums.fxml.FXMLResource.REGISTER_USER_SCENE;
import static br.com.protheus.protheus.utils.fxml.Stages.getStage;

@Component
@RequiredArgsConstructor
public class MainController implements Controller {

    private final ChangeScene changeScene;

    @FXML
    private Button registerUserButton;

    public void onActionRegisterButton() {
        final var stage = getStage(registerUserButton).getScene();
        changeScene.execute(REGISTER_USER_SCENE, stage);
    }
}
