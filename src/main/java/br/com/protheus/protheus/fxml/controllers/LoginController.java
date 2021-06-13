package br.com.protheus.protheus.fxml.controllers;

import br.com.protheus.protheus.domains.RawCredentials;
import br.com.protheus.protheus.usecases.ValidateLoginCredentials;
import br.com.protheus.protheus.usecases.fxml.ChangeScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.protheus.protheus.domains.enums.fxml.FXMLResource.MAIN_SCENE;
import static br.com.protheus.protheus.domains.enums.fxml.Texts.LOGIN_FAILED_MESSAGE;
import static br.com.protheus.protheus.utils.fxml.Stages.getStage;

@Component
@RequiredArgsConstructor
public class LoginController {

    private final ValidateLoginCredentials validateLoginCredentials;
    private final ChangeScene changeScene;

    @FXML
    private Button mamouButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginStatusField;

    public void exitButtonOnAction(final ActionEvent event) {
        final var stage = getStage(mamouButton);
                stage.close();
    }

    public void loginButtonOnAction(final ActionEvent event) {
        final var usernameOrEmail = nameField.getText();
        final var password = passwordField.getText();
        final var currentScene = getStage(loginButton).getScene();

        final var rawCredentials = RawCredentials.builder()
                .password(password)
                .usernameOrEmail(usernameOrEmail)
                .build();

        final var isValid = validateLoginCredentials.isValid(rawCredentials);

        if (isValid) {
            changeScene.execute(MAIN_SCENE, currentScene);
        } else {
            loginStatusField.setText(LOGIN_FAILED_MESSAGE.getText());
        }
    }
}
