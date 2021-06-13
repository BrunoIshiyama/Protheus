package br.com.protheus.protheus.domains.enums.fxml;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Dimensions {

    SMALL_SCREEN(520, 400),
    MEDIUM_SCREEN(800,600);

    private final int width;
    private final int height;
}
