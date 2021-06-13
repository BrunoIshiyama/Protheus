package br.com.protheus.protheus;

import br.com.protheus.protheus.utils.fxml.FXMLResourceLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static br.com.protheus.protheus.ProtheusUiApplication.StageReadyEvent;
import static br.com.protheus.protheus.domains.enums.fxml.FXMLResource.LOGIN_SCENE;

@Component
@RequiredArgsConstructor
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private final FXMLResourceLoader fxmlResourceLoader;

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        final var stage = event.getStage();
        final var scene = fxmlResourceLoader.getScene(LOGIN_SCENE);
        stage.setTitle(LOGIN_SCENE.getTitle().getText());
        stage.setScene(scene);
        stage.show();
    }
}
