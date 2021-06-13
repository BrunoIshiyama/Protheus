package br.com.protheus.protheus.domains.enums.fxml;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Texts {
    LOGIN_PAGE_TITLE("Login"),
    USER_REGISTRATION_PAGE_TITLE("Register"),
    MAIN_PAGE_TITLE("Main"),
    LOGIN_SUCCESSFUL_MESSAGE("Login Successful"),
    LOGIN_FAILED_MESSAGE("Invalid Credentials");

    private final String text;
}
