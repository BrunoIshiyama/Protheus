package br.com.protheus.protheus.utils.fxml;

import br.com.protheus.protheus.domains.enums.fxml.FXMLResource;
import br.com.protheus.protheus.usecases.fxml.CreateFXMLScene;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FXMLResourceLoader {

    private final CreateFXMLScene createFXMLScene;

    public Scene getScene(final FXMLResource resource) {
        return createScene(resource);
    }

    private Scene createScene(final FXMLResource resource) {
        final Parent fxmlScene = createFXMLScene.execute(resource);
        return new Scene(fxmlScene, resource.getDimensions().getWidth(), resource.getDimensions().getHeight());
    }
}
