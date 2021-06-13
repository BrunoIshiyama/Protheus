package br.com.protheus.protheus.usecases.fxml;

import br.com.protheus.protheus.domains.enums.fxml.FXMLResource;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ChangeScene {

    private final CreateFXMLScene createFXMLScene;

    public void execute(final FXMLResource resource, final Scene currentScene) {
        if (Objects.nonNull(currentScene)) {
            final var fxmlScene = createFXMLScene.execute(resource);
            setupStage(currentScene, resource);
            currentScene.setRoot(fxmlScene);
        }
    }

    private void setupStage(final Scene currentScene, final FXMLResource resource) {
        final var stage = (Stage) currentScene.getWindow();
        stage.setTitle(resource.getTitle().getText());
        stage.setWidth(resource.getDimensions().getWidth());
        stage.setHeight(resource.getDimensions().getHeight());
    }


}
