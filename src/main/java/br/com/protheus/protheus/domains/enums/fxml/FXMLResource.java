package br.com.protheus.protheus.domains.enums.fxml;

import br.com.protheus.protheus.fxml.controllers.LoginController;
import br.com.protheus.protheus.fxml.controllers.MainController;
import br.com.protheus.protheus.fxml.controllers.RegisterUserController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static br.com.protheus.protheus.domains.enums.fxml.Dimensions.*;
import static br.com.protheus.protheus.domains.enums.fxml.Texts.*;

@Getter
@RequiredArgsConstructor
public enum FXMLResource {

    LOGIN_SCENE("fxml/login.fxml", LOGIN_PAGE_TITLE, SMALL_SCREEN, LoginController.class),
    REGISTER_USER_SCENE("fxml/register-user.fxml", USER_REGISTRATION_PAGE_TITLE, MEDIUM_SCREEN, RegisterUserController.class),
    MAIN_SCENE("fxml/main.fxml", MAIN_PAGE_TITLE, MEDIUM_SCREEN, MainController.class);

    private final String path;
    private final Texts title;
    private final Dimensions dimensions;
    private final Class controllerClass;

}
