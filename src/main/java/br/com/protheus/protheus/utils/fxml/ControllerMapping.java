package br.com.protheus.protheus.utils.fxml;

import br.com.protheus.protheus.domains.enums.fxml.FXMLResource;
import br.com.protheus.protheus.fxml.controllers.LoginController;
import br.com.protheus.protheus.fxml.controllers.MainController;
import br.com.protheus.protheus.fxml.controllers.RegisterUserController;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

import static br.com.protheus.protheus.domains.enums.fxml.FXMLResource.*;

@Component
@RequiredArgsConstructor
public class ControllerMapping {

    private final LoginController loginController;
    private final MainController mainController;
    private final RegisterUserController registerUserController;

    private final Map<FXMLResource, Object> mapping = Maps.newHashMap();

    @PostConstruct
    private void initMapping() {
        mapping.put(LOGIN_SCENE, loginController);
        mapping.put(MAIN_SCENE, mainController);
        mapping.put(REGISTER_USER_SCENE, registerUserController);
    }

    public Object getController(final FXMLResource resource) {
        return mapping.get(resource);
    }

}
