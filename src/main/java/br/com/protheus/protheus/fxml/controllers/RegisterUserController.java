package br.com.protheus.protheus.fxml.controllers;

import br.com.protheus.protheus.domains.UserCredentials;
import br.com.protheus.protheus.usecases.CreateUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterUserController implements Controller {

    private final CreateUser createUser;

    @FXML
    private Button saveUserButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField secretField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    public void onActionSaveUserButton() {
        final var password = passwordField.getText();
        final var secret = secretField.getText();
        final var username = usernameField.getText();
        final var email = emailField.getText();


        final var userCredentials = UserCredentials.builder()
                .password(password)
                .email(email)
                .secret(secret)
                .username(username)
                .build();
        final var createdUser = createUser.execute(userCredentials);
        log.info("New user created: {}", createdUser.getUuid());
    }
}
