package br.com.protheus.protheus.usecases.fxml;

import br.com.protheus.protheus.domains.enums.fxml.FXMLResource;
import br.com.protheus.protheus.exceptions.ResourceNotFoundException;
import br.com.protheus.protheus.utils.fxml.ControllerMapping;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateFXMLScene {

    private final ConfigurableApplicationContext applicationContext;
    private ControllerMapping controllerMapping;

    @PostConstruct
    private void setUpControllerMapping() {
        controllerMapping = applicationContext.getBeansOfType(ControllerMapping.class)
                .get("controllerMapping");
    }

    public Parent execute(final FXMLResource resource) {
        try {
            return buildFXMLLoader(resource).load();
        } catch (IOException e) {
            log.error("An error occurred while fetching for fxml resource: {}", resource, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    private FXMLLoader buildFXMLLoader(final FXMLResource resource) {
        final var resourceUrl = ClassLoader.getSystemResource(resource.getPath());

        if (Objects.isNull(resourceUrl))
            throw new ResourceNotFoundException("Resource not found with path: " + resource.getPath());

        final var loader = new FXMLLoader();
        loader.setLocation(resourceUrl);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setControllerFactory(controllerClass -> resource.getControllerClass()
                .cast(controllerMapping.getController(resource))
        );

        return loader;
    }
}
