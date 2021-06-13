package br.com.protheus.protheus.fxml.controllers;

import br.com.protheus.protheus.domains.UserCredentials;
import br.com.protheus.protheus.usecases.CreateUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class RegisterUserController {

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

    public void onActionSaveUserButton(final ActionEvent event) {
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
        if (Objects.nonNull(createdUser)) {
            System.out.println("user " + createdUser + "created successfully");
        }
    }

}
