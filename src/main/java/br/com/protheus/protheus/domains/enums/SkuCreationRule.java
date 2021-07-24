package br.com.protheus.protheus.domains.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SkuCreationRule {
    DEPARTMENT_RULE("[A-Z]*2"),
    BRAND_RULE("[A-Z]*2"),
    CATEGORY_RULE("[A-Z]*3"),
    COLOR_RULE("[0-9]*3"),
    SIZE_RULE("[0-9]*2"),
    VOLTAGE_RULE("[1-3]*2");

    private final String regex;
}
